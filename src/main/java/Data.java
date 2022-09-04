import InterfaceManager.GameInterfaces.SettingsInterface;
import InterfaceManager.Option;
import InterfaceManager.OptionGroup;
import Inventory.Inventory;
import Settings.*;
import SignificantThings.Artifacts.Artifact;
import SignificantThings.Buffs.Buff;
import SignificantThings.Weapons.Verbs;
import SignificantThings.Weapons.Weapon;
import SignificantThings.Characters.Character;

import org.json.JSONArray;
import org.json.JSONObject;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;

public class Data {
    private static JSONObject data;
    private OkHttpClient client = new OkHttpClient();
    public Data(){
        //empty constructor lol
    }

    public void getSaveDataFromServer(String username, String password, String serverURL) throws IOException {
        JSONObject responseBody = new JSONObject(run(serverURL+"/api/account/login/"+username+"+"+password));
        try{
            data = responseBody.getJSONObject("metadata").getJSONObject("Gentry's Quest data");
        }
        catch (Exception E){
            data = new JSONObject("{\n" +
                    "  \"startupamount\" : 0,\n" +
                    "  \"inventory\" : {\n" +
                    "    \"money\" : 0,\n" +
                    "    \"characters\" : [],\n" +
                    "    \"weapons\" : [],\n" +
                    "    \"artifacts\" : []\n" +
                    "  },\n" +
                    "  \"settings\" : {\n" +
                    "    \"debug\" : false,\n" +
                    "    \"no timeout\" : false\n" +
                    "  }\n" +
                    "}");
        }
    }

    public ArrayList<Setting> initializeSettings(){
        JSONObject settingsFromJSON = data.getJSONObject("settings");
        ArrayList<Setting> settings = new ArrayList<Setting>();
        for(String setting: settingsFromJSON.keySet()){
            System.out.println(settingsFromJSON.get(setting));
            if (settingsFromJSON.get(setting) instanceof Integer) settings.add(new IntSetting(setting, ((Integer) settingsFromJSON.get(setting)).intValue()));
            if (settingsFromJSON.get(setting) instanceof String) settings.add(new StringSetting(setting, settingsFromJSON.get(setting).toString()));
            if (settingsFromJSON.get(setting) instanceof Boolean) settings.add(new ToggleSetting(setting, ((Boolean) settingsFromJSON.get(setting)).booleanValue()));
        }
        return settings;
    }

    public Inventory loadData(){
        Inventory inventory = new Inventory();
        //cofigurations
        System.out.println("\tstep 1, configurations");




        //money
        System.out.println("\tstep 2, money");
        inventory.addMoney(data.getJSONObject("inventory").getInt("money"));




        //characters
        System.out.println("\tstep 3, characters");
        for(Object notJSONCharacterData: data.getJSONObject("inventory").getJSONArray("characters")){
            JSONObject characterData = (JSONObject) notJSONCharacterData;
            int starRating = characterData.getInt("star rating");
            String name = characterData.getString("name");
            String description = characterData.getString("description");
            JSONObject stats = characterData.getJSONObject("stats");
            int initialHealth = stats.getInt("health");
            int initialAttack = stats.getInt("attack");
            int initialDefense = stats.getInt("defense");
            double initialCritRate = stats.getDouble("critRate");
            int initialCritDamage = stats.getInt("critDamage");

            JSONObject weapon;
            Buff weaponBuff;

            if(characterData.getJSONObject("equips").has("weapon")){
                weapon = characterData.getJSONObject("equips").getJSONObject("weapon");
                weaponBuff = new Buff(
                        Buff.getBuffString(
                                weapon.getJSONObject(
                                        "stats"
                                ).getJSONArray(
                                        "buff"
                                ).getInt(
                                        0
                                )
                        ),
                        weapon.getJSONObject(
                                "stats"
                        ).getJSONArray(
                                "buff"
                        ).getInt(
                                1
                        ) == 1
                );
                weaponBuff.levelUp(weapon.getJSONObject(
                        "stats"
                ).getJSONArray(
                        "buff"
                ).getInt(
                        2
                ));
            }
            else{
                weapon = characterData;
                weaponBuff = new Buff("");
            }

            ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

            for(Object artifact: characterData.getJSONObject("equips").getJSONArray("artifacts")) {
                JSONObject artifactData = (JSONObject) artifact;
                ArrayList<Buff> buffs = new ArrayList<Buff>();
                for (int i = 0; i<artifactData.getJSONObject("stats").getJSONArray("attributes").length(); i++){
                    JSONArray buffArray = artifactData.getJSONObject("stats").getJSONArray("attributes").getJSONObject(i).getJSONArray("buff");
                    buffs.add(Buff.createBuff(buffArray));
                }
                Buff mainAttribute = Buff.createBuff(artifactData.getJSONObject("stats").getJSONArray("main attribute"));
                Artifact newArtifact = new Artifact(artifactData.getString("name"), mainAttribute, artifactData.getString("family"));
                for(Buff buff: buffs){
                    newArtifact.addAttribute(buff);
                }
                newArtifact.setStarRating(artifactData.getInt("star rating"));
                newArtifact.setLevel(artifactData.getJSONObject("experience").getInt("level"));
                artifacts.add(newArtifact);
            }

            Character character = new Character(
                    starRating,
                    name,
                    initialHealth,
                    initialAttack,
                    initialDefense,
                    initialCritRate,
                    initialCritDamage,
                    description,
                    characterData.getJSONObject("experience").getInt("level"),
                    characterData.getJSONObject("experience").getLong("xp"),
                    (((characterData.getJSONObject("equips").has("weapon")) ? new Weapon(weapon.getString("name"), weapon.getInt("star rating"), weapon.getString("weapon type"), weapon.getJSONObject("stats").getInt("attack"), weaponBuff, new Verbs(weapon.getJSONObject("verbs").getString("normal"), weapon.getJSONObject("verbs").getString("critical")), weapon.getString("description"), weapon.getJSONObject("experience").getInt("level"), weapon.getJSONObject("experience").getInt("xp")) : null)),
                    artifacts
            );
            inventory.addCharacter(character);
        }
        JSONObject inventoryData = data.getJSONObject("inventory");
        System.out.println("\tstep 4, weapons");
        for(Object weapon: inventoryData.getJSONArray("weapons")){
            JSONObject weaponData = (JSONObject) weapon;
            JSONObject weaponStats = weaponData.getJSONObject("stats");
            JSONObject weaponVerbs = weaponData.getJSONObject("verbs");
            JSONObject weaponExperience = weaponData.getJSONObject("experience");
            Buff newBuff = Buff.createBuff(weaponStats.optJSONArray("buff"));
            Weapon newWeapon = new Weapon(
                    weaponData.getString("name"),
                    weaponData.getInt("star rating"),
                    weaponData.getString("weapon type"),
                    weaponStats.getInt("attack"),
                    newBuff,
                    new Verbs(weaponVerbs.getString("normal"), weaponVerbs.getString("critical")),
                    weaponData.getString("description"),
                    weaponExperience.getInt("level"),
                    weaponExperience.getInt("xp")
            );
            inventory.addWeapon(newWeapon);
        }
        System.out.println("\tstep 5, artifacts");
        for(Object artifact: inventoryData.getJSONArray("artifacts")) {
            JSONObject artifactData = (JSONObject) artifact;
            ArrayList<Buff> buffs = new ArrayList<Buff>();
            for (int i = 0; i<artifactData.getJSONObject("stats").getJSONArray("attributes").length(); i++){
                JSONArray buffArray = artifactData.getJSONObject("stats").getJSONArray("attributes").getJSONObject(i).getJSONArray("buff");
                buffs.add(Buff.createBuff(buffArray));
            }
            Buff mainAttribute = Buff.createBuff(artifactData.getJSONObject("stats").getJSONArray("main attribute"));
            Artifact newArtifact = new Artifact(artifactData.getString("name"), mainAttribute, artifactData.getString("family"));
            for(Buff buff: buffs){
                newArtifact.addAttribute(buff);
            }
            newArtifact.setStarRating(artifactData.getInt("star rating"));
            newArtifact.setLevel(artifactData.getJSONObject("experience").getInt("level"));
            inventory.addArtifact(newArtifact);
        }

        return inventory;
    }

    public String run(String serverURL) throws IOException {
        Request request = new Request.Builder()
            .url(serverURL)
            .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public JSONObject getData(){
        return data;
    }
}
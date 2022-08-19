//package IO;
//
//public class Read {
//    public static void loadGame() throws FileNotFoundException, UnsupportedEncodingException, MalformedURLException {
//        System.out.println("\tstep 1, configurations");
//        settings.put("debug", isToggledSetting("debug", false));
//        settings.put("no timeout", isToggledSetting("no timeout", false));
//        serverData = getData().getJSONObject("server");
//        url = new URL(serverData.getString("ip") + (serverData.getInt("port") > 0 ? (":" + serverData.getInt("port")) : ""));
//        try {
//            serverConnection = (HttpURLConnection) url.openConnection();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("\tstep 2, money");
//        inventory.addMoney(getData().getJSONObject("inventory").getInt("money"));
//        System.out.println("\tstep 3, characters");
//        for(Object notJSONCharacterData: getData().getJSONObject("inventory").getJSONArray("characters")){
//            JSONObject characterData = (JSONObject) notJSONCharacterData;
//            if(isToggledSetting("debug", true)) System.out.println(characterData.toString(4));
//            int starRating = characterData.getInt("star rating");
//            String name = characterData.getString("name");
//            String description = characterData.getString("description");
//            JSONObject stats = characterData.getJSONObject("stats");
//            int initialHealth = stats.getInt("health");
//            int initialAttack = stats.getInt("attack");
//            int initialDefense = stats.getInt("defense");
//            double initialCritRate = stats.getDouble("critRate");
//            int initialCritDamage = stats.getInt("critDamage");
//
//            JSONObject weapon;
//            Buff weaponBuff;
//
//            if(characterData.getJSONObject("equips").has("weapon")){
//                weapon = characterData.getJSONObject("equips").getJSONObject("weapon");
//                weaponBuff = new Buff(
//                        getBuffString(
//                                weapon.getJSONObject(
//                                        "stats"
//                                ).getJSONArray(
//                                        "buff"
//                                ).getInt(
//                                        0
//                                )
//                        ),
//                        weapon.getJSONObject(
//                                "stats"
//                        ).getJSONArray(
//                                "buff"
//                        ).getInt(
//                                1
//                        ) == 1
//                );
//                weaponBuff.levelUp(weapon.getJSONObject(
//                        "stats"
//                ).getJSONArray(
//                        "buff"
//                ).getInt(
//                        2
//                ));
//            }
//            else{
//                weapon = characterData;
//                weaponBuff = new Buff("");
//            }
//
//            ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
//
//            for(Object artifact: characterData.getJSONObject("equips").getJSONArray("artifacts")) {
//                JSONObject artifactData = (JSONObject) artifact;
//                ArrayList<Buff> buffs = new ArrayList<Buff>();
//                for (int i = 0; i<artifactData.getJSONObject("stats").getJSONArray("attributes").length(); i++){
//                    JSONArray buffArray = artifactData.getJSONObject("stats").getJSONArray("attributes").getJSONObject(i).getJSONArray("buff");
//                    buffs.add(createBuff(buffArray));
//                }
//                Buff mainAttribute = createBuff(artifactData.getJSONObject("stats").getJSONArray("main attribute"));
//                Artifact newArtifact = new Artifact(artifactData.getString("name"), mainAttribute, artifactData.getString("family"));
//                for(Buff buff: buffs){
//                    newArtifact.addAttribute(buff);
//                }
//                newArtifact.setStarRating(artifactData.getInt("star rating"));
//                newArtifact.setLevel(artifactData.getJSONObject("experience").getInt("level"));
//                artifacts.add(newArtifact);
//            }
//
//            Character character = new Character(
//                    starRating,
//                    name,
//                    initialHealth,
//                    initialAttack,
//                    initialDefense,
//                    initialCritRate,
//                    initialCritDamage,
//                    description,
//                    characterData.getJSONObject("experience").getInt("level"),
//                    characterData.getJSONObject("experience").getLong("xp"),
//                    (((characterData.getJSONObject("equips").has("weapon")) ? new Weapon(weapon.getString("name"), weapon.getInt("star rating"), weapon.getString("weapon type"), weapon.getJSONObject("stats").getInt("attack"), weaponBuff, new Verbs(weapon.getJSONObject("verbs").getString("normal"), weapon.getJSONObject("verbs").getString("critical")), weapon.getString("description"), weapon.getJSONObject("experience").getInt("level"), weapon.getJSONObject("experience").getInt("xp")) : null)),
//                    artifacts
//            );
//            inventory.addCharacter(character);
//        }
//        JSONObject inventoryData = getData().getJSONObject("inventory");
//        System.out.println("\tstep 4, weapons");
//        for(Object weapon: inventoryData.getJSONArray("weapons")){
//            JSONObject weaponData = (JSONObject) weapon;
//            JSONObject weaponStats = weaponData.getJSONObject("stats");
//            JSONObject weaponVerbs = weaponData.getJSONObject("verbs");
//            JSONObject weaponExperience = weaponData.getJSONObject("experience");
//            Buff newBuff = createBuff(weaponStats.optJSONArray("buff"));
//            Weapon newWeapon = new Weapon(
//                    weaponData.getString("name"),
//                    weaponData.getInt("star rating"),
//                    weaponData.getString("weapon type"),
//                    weaponStats.getInt("attack"),
//                    newBuff,
//                    new Verbs(weaponVerbs.getString("normal"), weaponVerbs.getString("critical")),
//                    weaponData.getString("description"),
//                    weaponExperience.getInt("level"),
//                    weaponExperience.getInt("xp")
//            );
//            inventory.addWeapon(newWeapon);
//        }
//        System.out.println("\tstep 5, artifacts");
//        for(Object artifact: inventoryData.getJSONArray("artifacts")) {
//            JSONObject artifactData = (JSONObject) artifact;
//            ArrayList<Buff> buffs = new ArrayList<Buff>();
//            for (int i = 0; i<artifactData.getJSONObject("stats").getJSONArray("attributes").length(); i++){
//                JSONArray buffArray = artifactData.getJSONObject("stats").getJSONArray("attributes").getJSONObject(i).getJSONArray("buff");
//                buffs.add(createBuff(buffArray));
//            }
//            Buff mainAttribute = createBuff(artifactData.getJSONObject("stats").getJSONArray("main attribute"));
//            Artifact newArtifact = new Artifact(artifactData.getString("name"), mainAttribute, artifactData.getString("family"));
//            for(Buff buff: buffs){
//                newArtifact.addAttribute(buff);
//            }
//            newArtifact.setStarRating(artifactData.getInt("star rating"));
//            newArtifact.setLevel(artifactData.getJSONObject("experience").getInt("level"));
//            inventory.addArtifact(newArtifact);
//        }
//
//    }
//}

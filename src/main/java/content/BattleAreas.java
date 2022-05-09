package content;

import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import location.BattleArea;
import weapon.Verbs;
import weapon.Weapon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BattleAreas {
    private static ArrayList<BattleArea> contentBattleAreas = new ArrayList<BattleArea>();
    public BattleAreas(){
        //empty constructor lol
    }

    private static Artifact[] getFamily(String family){
        Artifact[] artifactsToCollect = new Artifact[5];
        int counter = 0;
        for(Artifact artifact: artifacts.getContentArtifacts()){
            if(artifact.getFamily().equals(family)){
                artifactsToCollect[counter] = artifact;
                counter += 1;
            }
            if(counter >= 5) break;
        }
        return artifactsToCollect;
    }

    public static ArrayList<BattleArea> getContentBattleAreas(){
        BattleArea braydensHouse = new BattleArea(
            "Brayden's House",
            false,
            new ArrayList<Enemy>(
                    List.of(new Enemy(
                        "A voice from Brayden's head",
                        60,
                        6,
                        3,
                        new Weapon(
                            "Psychology",
                            2,
                            "Mental",
                            2,
                            new Buff(""),
                            new Verbs("messed with", ""),
                            "The psychic weapon used by this being"
                        ),
                    "A voice that often talks to Brayden.")
                    )
            ),
            new ArrayList<Artifact>(List.of(getFamily("brayden messerschmidt"))));

        contentBattleAreas.add(braydensHouse);

        return contentBattleAreas;
    }
}
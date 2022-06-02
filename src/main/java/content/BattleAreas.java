package content;

import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import location.BattleArea;
import weapon.Verbs;
import weapon.Weapon;
import java.util.ArrayList;
import java.util.List;

public class BattleAreas {
    private static ArrayList<BattleArea> contentBattleAreas = new ArrayList<BattleArea>();
    public BattleAreas(){
        //empty constructor lol
    }

    private static ArrayList<Artifact> getFamilyArtifacts(String family){
        ArrayList<Artifact> artifactList = new ArrayList<Artifact>();
        for(Artifact artifact: artifacts.getContentArtifacts()){
            if(artifact.getFamily().equals(family)) artifactList.add(artifact);
        }
        return artifactList;
    }

    public static void initializeContentBattleAreas(){
        BattleArea braydensHouse = new BattleArea(
            "Brayden's House",
            false,
            false,
            new ArrayList<Enemy>(
                List.of(new Enemy(
                    "Voice from Brayden's head",
                    20,
                    6,
                    3,
                    new Weapon(
                        "Psychology",
                        2,
                        "Mental",
                        2,
                        new Buff(""),
                        new Verbs("messed with", "tricked"),
                        "A psychic weapon."
                    ),
                "A voice that often talks to Brayden."),
                new Enemy(
                    "Demon from under brayden's bed",
                    23,
                    5,
                    1,
                    new Weapon(
                        "Trident",
                        3,
                        "Trident",
                        3,
                        new Buff(""),
                        new Verbs("poked", "impaled"),
                        "A demon's trident."
                    ),
                "A demon from underneath brayden's bed."
                )
                )
            ),
            getFamilyArtifacts("brayden messerschmidt")
        );

        BattleArea unfinishedConstructionSite = new BattleArea(
            "Unfinished Construction Site",
            true,
            false,
            new ArrayList<Enemy>(
                List.of(new Enemy(
                    "OSHA Worker",
                    15,
                    3,
                    1,
                    new Weapon(
                        "Clipboard",
                        1,
                        "Clipboard",
                        1,
                        new Buff(""),
                        new Verbs("smacked", "broke the clipboard in the process of smacking"),
                        "A wooden clipboard"
                    ),
                "An OSHA worker with an unlimited supply of clipboards.")
                )

            ),
            getFamilyArtifacts("max shrum")
        );

        BattleArea downTown = new BattleArea(
            "Down Town",
            false,
            false,
            new ArrayList<Enemy>(
                List.of(new Enemy(
                    "Homeless guy",
                    10,
                    2,
                    2,
                    new Weapon(
                        "Empty beer bottle",
                        1,
                        "beer bottle",
                        3,
                        new Buff(""),
                        new Verbs("whacked", "peed on"),
                        "A beer bottle in a brown paper bag."
                    ),
                    "A homeless guy."),
                new Enemy(
                    "Business man",
                    26,
                    3,
                    2,
                    new Weapon(
                        "Briefcase",
                        4,
                        "briefcase",
                        4,
                        new Buff(""),
                        new Verbs("swung his breifcase at", "downsmashed with his breifcase at"),
                        "A briefcase with 'important' files."
                    ),
                    "A very serious buisiness man"
                )
                )
            ),
            getFamilyArtifacts("down town")
        );


        contentBattleAreas.add(braydensHouse);
        contentBattleAreas.add(unfinishedConstructionSite);
        contentBattleAreas.add(downTown);
    }

    public static ArrayList<BattleArea> getContentBattleAreas() {
        return contentBattleAreas;
    }
}
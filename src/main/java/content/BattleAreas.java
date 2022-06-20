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
        BattleArea introFight = new BattleArea(
            "intro",
            false,
            true,
            new ArrayList<Enemy>(
                List.of(new Enemy(
                    "Angry Pedestrian",
                    15,
                    25,
                    3,
                    new Weapon(
                        "Knife",
                        1,
                        "Knife",
                        0,
                        new Buff("attack"),
                        new Verbs("stabbed", "slashed"),
                        "A regular everyday knife"
                    ),
                    "A for some reason very angry pedestrian"
                )
                )
            ),
            getFamilyArtifacts("brayden messerschmidt")
        );

        //iowa locations
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
                        0,
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
                        0,
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
                    2,
                    1,
                    new Weapon(
                        "Clipboard",
                        1,
                        "Clipboard",
                        0,
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
                    3,
                    2,
                    new Weapon(
                        "Empty beer bottle",
                        1,
                        "beer bottle",
                        0,
                        new Buff(""),
                        new Verbs("whacked", "peed on"),
                        "A beer bottle in a brown paper bag."
                    ),
                    "A homeless guy."),
                new Enemy(
                    "Business man",
                    26,
                    6,
                    2,
                    new Weapon(
                        "Briefcase",
                        4,
                        "briefcase",
                        0,
                        new Buff(""),
                        new Verbs("swung his briefcase at", "downsmashed with his briefcase at"),
                        "A briefcase with 'important' files."
                    ),
                    "A very serious business man"
                )
                )
            ),
            getFamilyArtifacts("down town")
        );

        //town of robloxia highschool
        BattleArea gymLockerRoomBathroom = new BattleArea(
            "Gym's Locker Room's Bathroom",
            false,
            false,
            new ArrayList<Enemy>(
                List.of(
                    new Enemy(
                        "Valley White Girl",
                        10,
                        3,
                        1,
                        new Weapon(
                            "Whiny Voice",
                            1,
                            "Vocal",
                            3,
                            new Buff(""),
                            new Verbs("breathed on", "spat on"),
                            "A whiny white girls voice"
                        ),
                        "An annoying species."
                    ),
                    new Enemy(
                        "Teacher",
                        22,
                        5,
                        2,
                        new Weapon(
                            "Clipboard",
                            3,
                            "clipboard",
                            1,
                            new Buff(""),
                            new Verbs("punished", "gave detention to"),
                            "A clipboard that never actually has stuff written on it."
                        ),
                        "A busty white milf."
                    ),
                    new Enemy(
                        "Buff Gym Teacher",
                        30,
                        6,
                        3,
                        new Weapon(
                            "Whistle",
                            1,
                            "Whistle",
                            1,
                            new Buff(""),
                            new Verbs("blew", "deafened"),
                            "Loud, no running."
                        ),
                        "Don't let him catch you. You'll suffer the wrath."
                    ),
                    new Enemy(
                        "Bully",
                        20,
                        3,
                        1,
                        new Weapon(
                            "Fists",
                            2,
                            "hands",
                            1,
                            new Buff(""),
                            new Verbs("tripped", "punched"),
                            "Stubby little fingers create a stubby little fist."
                        ),
                        "Sensitive man on the inside. Strong man on the outside."
                    )
                )
            ),
            getFamilyArtifacts("man clan")
        );

        contentBattleAreas.add(introFight);

        contentBattleAreas.add(braydensHouse);
        contentBattleAreas.add(unfinishedConstructionSite);
        contentBattleAreas.add(downTown);
        contentBattleAreas.add(gymLockerRoomBathroom);
    }

    public static ArrayList<BattleArea> getContentBattleAreas() {
        return contentBattleAreas;
    }
}
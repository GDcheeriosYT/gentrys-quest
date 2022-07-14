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

    private static ArrayList<Artifact> getFamilyArtifacts(ArrayList<String> families){
        ArrayList<Artifact> artifactList = new ArrayList<Artifact>();
        for(String family: families){
            for(Artifact artifact: artifacts.getContentArtifacts()){
                if(artifact.getFamily().equals(family)) artifactList.add(artifact);
            }
        }
        return artifactList;
    }

    public static void initializeContentBattleAreas(){
        BattleArea introFight = new BattleArea(
            "intro",
            false,
            new ArrayList<Enemy>(
                List.of(new Enemy(
                    "Angry Pedestrian",
                    30,
                    60,
                    2,
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
            getFamilyArtifacts(new ArrayList<>(List.of("brayden messerschmidt", "dan messerschmidt")))
        );

        //iowa locations
        BattleArea braydensHouse = new BattleArea(
            "Brayden's House",
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
                ),
                new Enemy(
                    "Chinchilla",
                    16,
                    4,
                    2,
                    new Weapon(
                        "paws",
                        2,
                        "paws",
                        0,
                        new Buff(""),
                        new Verbs("pounced on", "bit"),
                        "pair of paws on a chinchilla"
                    ),
                    "Just a normal pet chinchilla"
                ),
                new Enemy(
                    "Guinea Pig",
                    16,
                    4,
                    3,
                    new Weapon(
                        "teeth",
                        2,
                        "teeth",
                        0,
                        new Buff(""),
                        new Verbs("bit", "chomped on"),
                        "teeth on a guinea pig"
                    ),
                    "A guinea pig"
                )
            )
            ),
            getFamilyArtifacts(new ArrayList<>(List.of("brayden messerschmidt", "dan messerschmidt")))
        );

        BattleArea unfinishedConstructionSite = new BattleArea(
            "Unfinished Construction Site",
            true,
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
            getFamilyArtifacts(new ArrayList<>(List.of("max shrum")))
        );

        BattleArea downTown = new BattleArea(
            "Down Town",
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
            getFamilyArtifacts(new ArrayList<>(List.of("down town")))
        );

        BattleArea target = new BattleArea(
            "Target",
            false,
                new ArrayList<Enemy>(
                List.of(
                    new Enemy(
                        "Karen",
                        23,
                        4,
                        4,
                        new Weapon(
                            "camera",
                            5,
                            "camera",
                            1,
                            new Buff(""),
                            new Verbs("recorded", "left a bad review about"),
                            "a regular iphone camera"
                        ),
                        "A for some reason very angry woman."
                    ),
                    new Enemy(
                        "Target Employee",
                        20,
                        3,
                        3,
                        new Weapon(
                            "zebra",
                            5,
                            "phone",
                            1,
                            new Buff(""),
                            new Verbs("scanned", "called over a manger to deal with"),
                            "just a scanner phone."
                        ),
                        "an employee"
                    ),
                    new Enemy(
                        "Target Manager",
                        25,
                        5,
                        5,
                        new Weapon(
                                "zebra",
                                5,
                                "phone",
                                1,
                                new Buff(""),
                                new Verbs("scanned", "dealt with"),
                                "just a scanner phone."
                        ),
                        "a manager"
                    )
                )
            ),
            getFamilyArtifacts(new ArrayList<>(List.of("lucas smidt")))
        );

        BattleArea climbIowa = new BattleArea(
            "Climb Iowa",
            false,
            new ArrayList<Enemy>(
                List.of(
                    new Enemy(
                        "Gym Bro",
                        27,
                        5,
                        4,
                        new Weapon(
                            "Muscles",
                            2,
                            "muscle",
                            1,
                            new Buff(""),
                            new Verbs("confidently flexed on", "power screamed at"),
                            "some nice looking muscles"
                        ),
                        "probably short"
                    ),
                    new Enemy(
                        "8 year old who can climb v9s",
                        15,
                        8,
                        1,
                        new Weapon(
                            "Little Muscles",
                            2,
                            "muscle",
                            1,
                            new Buff(""),
                            new Verbs("punches up at", "flashed the project of"),
                            "looks can be decieving"
                        ),
                        "definitely short"
                    )
                )
            ),
            getFamilyArtifacts(new ArrayList<>(List.of("brody krysa", "david napier")))
        );

        BattleArea hyvee = new BattleArea(
            "Hy-vee",
            false,
            new ArrayList<Enemy>(
                List.of(
                    new Enemy(
                        "Customer Service Manager",
                        20,
                        4,
                        3,
                        new Weapon(
                            "Customer Service Phone",
                            new Verbs("didn't find the item for", "declined service for")
                        ),
                        "A customer service manager"
                    ),
                    new Enemy(
                        "Courtesy Clerk",
                        25,
                        4,
                        4,
                        new Weapon(
                            "Hands",
                            new Verbs("sprayed some oxiver at", "gave a disgusted look at")
                        ),
                        "a courtesy clerk"
                    ),
                    new Enemy(
                        "Checker",
                        20,
                        3,
                        3,
                        new Weapon(
                            "Scanner",
                            new Verbs("didn't greet", "told a really unrelatable story to")
                        ),
                        "Just a checker"
                    ),
                    new Enemy(
                        "Chinese chef",
                        20,
                        5,
                        2,
                        new Weapon(
                            "pan",
                            new Verbs("sliced", "超級扇耳光")
                        ),
                        "a chinese chef"
                    ),
                    new Enemy(
                        "Baker",
                        20,
                        4,
                        2,
                        new Weapon(
                            "rolling pin",
                            new Verbs("used a rolling pin to hit", "used a really hot crousaunt to burn")
                        ),
                        "a baker"
                    ),
                    new Enemy(
                        "Butcher",
                        20,
                        6,
                        4,
                        new Weapon(
                            "cleaver",
                            new Verbs("cleaved", "clean sliced")
                        ),
                        "a butcher from meat department"
                    ),
                    new Enemy(
                        "Rude Customer",
                        20,
                        6,
                        2,
                        new Weapon(
                            "voice",
                            new Verbs("made a rude remark about", "roasted")
                        ),
                        "a rude customer"
                    ),
                    new Enemy(
                        "Karen",
                        20,
                        4,
                        3,
                        new Weapon(
                            "phone",
                            new Verbs("recorded", "made a rude comment about")
                        ),
                        "a distasteful person"
                    )
                )
            ),
            getFamilyArtifacts(new ArrayList<>(List.of("brayden messerschmidt", "david napier", "hyvee")))
        );


        //town of robloxia highschool
        BattleArea gymLockerRoomBathroom = new BattleArea(
            "Gym's Locker Room's Bathroom",
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
            getFamilyArtifacts(new ArrayList<>(List.of("man clan")))
        );

        //nigeria
        BattleArea pureTaboosSet = new BattleArea(
            "Pure Taboo Set",
            true,
            new ArrayList<Enemy>(
                List.of(
                    new Enemy(
                        "Riley Reid",
                        35,
                        10,
                        5,
                        new Weapon(
                            "Hand of Exhaust",
                            5,
                            "Adult Toy",
                            1,
                            new Buff(""),
                            new Verbs("touched", "grabbed"),
                            "A very used \"adult toy\""
                        ),
                        "Popular actress"
                    )
                )
            ),
            getFamilyArtifacts(new ArrayList<>(List.of("mason james")))
        );

        contentBattleAreas.add(introFight);

        contentBattleAreas.add(braydensHouse);
        contentBattleAreas.add(unfinishedConstructionSite);
        contentBattleAreas.add(downTown);
        contentBattleAreas.add(climbIowa);
        contentBattleAreas.add(target);
        contentBattleAreas.add(hyvee);
        contentBattleAreas.add(gymLockerRoomBathroom);
        contentBattleAreas.add(pureTaboosSet);
    }

    public static ArrayList<BattleArea> getContentBattleAreas() {
        return contentBattleAreas;
    }
}
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

        BattleArea valleyHighSchool = new BattleArea(
            "Valley High School",
            false,
            new ArrayList<Enemy>(
                List.of(
                    new Enemy(
                        "Brody Krysa",
                        20,
                        3,
                        2,
                        new Weapon("Brody's Broadsword", 1, "Broadsword", 10, new Buff("attack"), new Verbs("swung at", "whacked"), "Brody the mighty warrior's broadsword.\nThe weapon was wielded for centuries by Brody himself, but was lost when the great calamity struck and he lost his life to the invading Waifu's."),
                        "Mighty warrior. Known as wall climber."
                    ),
                    new Enemy(
                        "David Napier",
                        20,
                        3,
                        2,
                        new Weapon("Jason's Junk", 5, "penis", 42, new Buff("health"), new Verbs("wanked", "cumblasted"), "it's Jason's. From Hy-vee. Estimated 14 inches."),
                        "6'4''."
                    ),
                    new Enemy(
                        "Gavin Knudsen",
                        20,
                        4,
                        2,
                        new Weapon("Nut Buster", 4, "Mace", 25, new Buff("attack"), new Verbs("you busted", "busted their nuts"), "Perfect weapon to slide on your opps and bust their nuts."),
                        "description"
                    ),
                    new Enemy(
                        "Ryan Martinez",
                        25,
                        3,
                        2,
                        new Weapon(
                            "Fists",
                            new Verbs(
                                "punched",
                                "upper-cut"
                            )
                        ),
                        "an American former YouTuber known for his rant videos, vlogs, and for being a superfan of the American football team the Philadelphia Eagles."
                    ),
                    new Enemy(
                        "Connor Fogarty",
                        20,
                        4,
                        3,
                        new Weapon("Bone", 2, "Sword", 3, new Buff(""), new Verbs("clobbered", "smushed"), "4 foot long dog bone"),
                        "A mutant shih tzu who loves cheese and belly rubs."
                    ),
                    new Enemy(
                        "Connor",
                        20,
                        4,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "description"
                    ),
                    new Enemy(
                        "Max Tramontina",
                        25,
                        4,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "description"
                    ),
                    new Enemy(
                        "Caleb Jallen",
                        25,
                        4,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "Dude I don't know."
                    ),
                    new Enemy(
                        "Charlie Eddie",
                        20,
                        5,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "A lone hunter in the wild just trying to avenge his dead dog."
                    ),
                    new Enemy(
                        "Alec Ferchen",
                        20,
                        5,
                        2,
                        new Weapon("Alec's Rock", 2, "Stone", 12, new Buff("attack"), new Verbs("hit", "immensely bashed"), "A small rock."),
                        "Big sexy man"
                    ),
                    new Enemy(
                        "Dyllon Forney",
                        20,
                        5,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "description"
                    ),
                    new Enemy(
                        "Kolin Craig",
                        25,
                        3,
                        3,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "A super *tall* and handsome man."
                    ),
                    new Enemy(
                        "Asher Lane",
                        20,
                        5,
                        2,
                        new Weapon("Homade Staff of Honey", 3, "Staff", 20, new Buff("critRate"), new Verbs("stabbed", "enlightened"), "A pointy staff of honey."),
                        "Pray to the goddess honey"
                    ),
                    new Enemy(
                        "Benji",
                        20,
                        6,
                        2,
                        new Weapon("The Messerschmidter", 5, "Sword", 40, new Buff("attack"), new Verbs("with his Messerschmidter tapped", "with his Messerschmidter spat on"), "A life size version of Brayden Messerschmidt but as a sword"),
                        "He was born a very lucky boy."
                    ),
                    new Enemy(
                        "Dylan Topic",
                        35,
                        3,
                        2,
                        new Weapon("Sir Far Quad", 5, "Lance", 50, new Buff("critDamage"), new Verbs("impailed", "sliced"), "Long long sword."),
                        "Cool uhm uhm uhm uhm uhm uhm oh tetris dude."
                    ),
                    new Enemy(
                        "Max Shrum",
                        30,
                        4,
                        2,
                        new Weapon("Cypirean Scythe", 5, "Scythe", 38, new Buff(""), new Verbs("swung at", "did a sweeping 360 BayBlade scythe spin"), "Long black shaft with 死 imprinted on the blade."),
                        "Minecraft player thing"
                    ),
                    new Enemy(
                        "Joe Nuts",
                        20,
                        3,
                        5,
                        new Weapon("Anubis Blade", 4, "Sword", 30, new Buff("attack"), new Verbs("quindavious bingleton smashed", "placed a goblin giant on the battlefield and it smacked the poop out of"), "Fried chicken muncher :)."),
                        "Massive man who likes sausage."
                    ),
                    new Enemy(
                        "Hanna Hardy",
                        25,
                        5,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "IDK"
                    ),
                    new Enemy(
                        "Mr.Gentry",
                        30,
                        5,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "Hyplains drifter"
                    ),
                    new Enemy(
                        "Brayden Messerschmidt",
                        20,
                        7,
                        2,
                        new Weapon("Brayden's Osu Pen", 5, "Pen", 36, new Buff("critRate"), new Verbs("hit a circle on", "fc'ed the pattern on"), "Brayden's osu pen."),
                        "An osu player who formed a contract with ppy(Dean Herbert ot not talk to females.)"
                    ),
                    new Enemy(
                        "Seth Smith",
                        25,
                        6,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "goat."
                    ),
                    new Enemy(
                        "Oliver Strauss",
                        20,
                        7,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "sneaky boi, has many females."
                    ),
                    new Enemy(
                        "Nathan Tenney",
                        25,
                        4,
                        4,
                        new Weapon("Ichimonji", 4, "Katana", 36, new Buff("attack"), new Verbs("sliced", "performed a 100 calibur slice on"), "A blade wielded by Zoro.\nIs sharp enough to slice the wind."),
                        "description"
                    ),
                    new Enemy(
                        "Nolan Anderson",
                        30,
                        5,
                        2,
                        new Weapon("Mason Killer", 5, "Dagger", 50, new Buff("attack"), new Verbs("penetrated", "hard penetrated"), "Two purple daggers."),
                        "Best character in the game"
                    ),
                    new Enemy(
                        "Grant Armstrong",
                        30,
                        4,
                        3,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "description"
                    ),
                    new Enemy(
                        "Brian Hightower",
                        20,
                        5,
                        4,
                        new Weapon(
                            "Guitar",
                            new Verbs(
                                    "used his guitar to hit",
                                    "played a terrible song to"
                            )
                        ),
                        "A headbanger"
                    ),
                    new Enemy(
                        "Mason James",
                        20,
                        7,
                        2,
                        new Weapon("Mason-ator", 5, "Toothbrush", 34, new Buff("critDamage"), new Verbs("brushed", "squirted toothpaste on"), "THE TOOTHBRUSH.\nThis toothbrush has been handed down for generations upon generations by the greek gods. You must be worthy of the brush to obtain this brush."),
                        "description"
                    ),
                    new Enemy(
                        "Kevin",
                        20,
                        7,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "description"
                    ),
                    new Enemy(
                        "Lucas Smidt",
                        25,
                        5,
                        3,
                        new Weapon("Cool Weapon", 5, "Sword", 43, new Buff("attack"), new Verbs("sweetified", "coolified"), "Super cool sword.\nOnly the coolest of the cool can wield this sword."),
                        "Totally rad guy who is super awesome."
                    ),
                    new Enemy(
                        "Sean Mcbroom",
                        20,
                        5,
                        2,
                        new Weapon(
                                "Fists",
                                new Verbs(
                                        "punched",
                                        "upper-cut"
                                )
                        ),
                        "Fart nuts"
                    ),
                        new Enemy(
                            "Derek Corona",
                            30,
                            5,
                            2,
                            new Weapon(
                                    "Fists",
                                    new Verbs(
                                            "punched",
                                            "upper-cut"
                                    )
                            ),
                            "A mexican assassin who can't keep away from alcohol."
                        ),
                        new Enemy(
                            "Bryce Anderson",
                            30,
                            5,
                            2,
                            new Weapon("Quandale Dingle", 5, "Person", 46, new Buff("attack"), new Verbs("quandale dingle'd", "dingle bombed"), "Long nose guy."),
                            "Tall guy."
                        ),
                        new Enemy(
                            "Spencer George",
                            20,
                            7,
                            2,
                            new Weapon("Sharp Throwing Cards", 5, "Playing Cards", 33, new Buff("critRate"), new Verbs("grazed", "sliced"), "Tactical throwing cards."),
                            "Gambling glass cannon"
                        ),
                        new Enemy(
                            "Will Johnson",
                            25,
                            5,
                            3,
                            new Weapon(
                                    "Fists",
                                    new Verbs(
                                            "punched",
                                            "upper-cut"
                                    )
                            ),
                            "He has teh longest johnson."
                        ),
                        new Enemy(
                            "Grant Wiseman",
                            15,
                            3,
                            2,
                            new Weapon("Shit Launcher Supreem", 5, "Grenade Launcher", 41, new Buff("defense"), new Verbs("glooped on", "sharted on"), "The sequel to the noob tube."),
                            "Large and made of shit."
                        ),
                        new Enemy(
                            "Mr.Maxwell",
                            40,
                            8,
                            7,
                            new Weapon(
                                "the punisher",
                                    new Verbs(
                                            "punished",
                                            "bent over"
                                    )
                            ),
                                "The principle of Valley High School."
                        )
                )
            ),
              getFamilyArtifacts(new ArrayList<>(List.of("nathan tenny", "brayden messerschmdit", "connor fogarty", "alec ferchen", "max shrum", "spencer george", "brody krysa", "lucas smidt", "nolan anderson", "gavin knudsen", "bryce anderson", "david napier", "grant wiseman")))
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
        contentBattleAreas.add(valleyHighSchool);
        contentBattleAreas.add(gymLockerRoomBathroom);
        contentBattleAreas.add(pureTaboosSet);
    }

    public static ArrayList<BattleArea> getContentBattleAreas() {
        return contentBattleAreas;
    }
}
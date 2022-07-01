package content;
import java.util.ArrayList;
import artifact.Artifact;
import buff.Buff;

public class artifacts {
  private static ArrayList<Artifact> contentArtifacts = new ArrayList<Artifact>();

  public artifacts(){
    //empty constructor lol
  }

  public static void initializeContentArtifacts(){
    //nathan tenny artifacts
    Artifact rubiksCube = new Artifact("Rubik's Cube", new Buff("critRate"), "nathan tenney");
    Artifact fork = new Artifact("Fork", new Buff("attack"), "nathan tenney");
    Artifact bucket = new Artifact("Bucket", new Buff("defense"), "nathan tenney");
    Artifact globe = new Artifact("Globe", new Buff("critDamage"), "nathan tenney");
    Artifact blanket = new Artifact("Blanket", new Buff("defense"), "nathan tenney");

    //brayden messerschmidt artifacts
    Artifact loliBodyPillow = new Artifact("Loli Body Pillow", new Buff("critRate"), "brayden messerschmidt");
    Artifact madokaChibiPlush = new Artifact("Madoka Chibi Plush", new Buff("critRate"), "brayden messerschmidt");
    Artifact loliCloth = new Artifact("Loli Cloth", new Buff("critRate"), "brayden messerschmidt");
    Artifact pepsiBottle = new Artifact("Pepsi Bottle", new Buff("critRate"), "brayden messerschmidt");
    Artifact osuTablet = new Artifact("Osu Tablet", new Buff("critRate"), "brayden messerschmidt");

    //connor fogarty artifacts
    Artifact bone = new Artifact("Bone", new Buff("health"), "connor fogarty");
    Artifact multipetPigDogToy = new Artifact("Multipet Pig Dog ToyⓇ", new Buff("critRate"), "connor fogarty");
    Artifact cheeseWheel = new Artifact("Cheese Wheel", new Buff("defense"), "connor fogarty");
    Artifact silkDogBed = new Artifact("Silk Dog Bed", new Buff("critDamage"), "connor fogarty");
    Artifact bellyRubMachine = new Artifact("Belly Rub Machine", new Buff("attack"), "connor fogarty");

    //alec ferchen artifacts
    Artifact macBook = new Artifact("Mac Book", new Buff("critDamage"), "alec ferchen");
    Artifact canesTendies = new Artifact("Cane's Tendies", new Buff("health"), "alec ferchen");
    Artifact dog = new Artifact("dog", new Buff("defense"), "alec ferchen");

    //max shrum artifacts
    Artifact keyCard = new Artifact("Key Card", new Buff("critRate"), "max shrum");
    Artifact bowlOfNoodles = new Artifact("Bowl O' Noodles", new Buff("health"), "max shrum");
    Artifact bikeTirePump = new Artifact("Bike Tire Pump", new Buff("attack"), "max shrum");
    Artifact blueprints = new Artifact("Blueprints", new Buff("defense"), "max shrum");
    Artifact violin = new Artifact("Violin", new Buff("health"), "max shrum");

    //spencer george artifacts
    Artifact aceUpTheSleeve = new Artifact("Ace Up The Sleeve", new Buff("critDamage"), "spencer george");
    Artifact halfEatenSandwich = new Artifact("Half Eaten Sandwich", new Buff("health"), "spencer george");
    Artifact weightedDice = new Artifact("Weighted Dice", new Buff("defense"), "spencer george");
    Artifact rouletteWheel = new Artifact("Roulette Wheel", new Buff("attack"), "spencer george");
    Artifact bouncer = new Artifact("Bouncer", new Buff("defense"), "spencer george");

    //mason james artifacts
    Artifact usedUndies = new Artifact("Used Undies", new Buff("health"), "mason james");
    Artifact hairBrush = new Artifact("Hair Brush", new Buff("attack"), "mason james");
    Artifact handCuffs = new Artifact("Hand Cuffs", new Buff("defense"), "mason james");
    Artifact restraints = new Artifact("Restraints", new Buff("critRate"), "mason james");
    Artifact strangeFlashlight = new Artifact("Strange Flashlight", new Buff("critDamage"), "mason james");

    //brody krysa artifacts
    Artifact chalkBag = new Artifact("Chalk Bag", new Buff("critRate"), "brody krysa");
    Artifact climbingShoes = new Artifact("Climbing Shoes", new Buff("critRate"), "brody krysa");
    Artifact harness = new Artifact("Harness", new Buff("critRate"), "brody krysa");
    Artifact belayDevice = new Artifact("Belay Device", new Buff("critRate"), "brody krysa");
    Artifact karabiner = new Artifact("Karabiner", new Buff("critRate"), "brody krysa");

    //kelly krysa artifacts
    Artifact redEvoShield = new Artifact("Red Evo Shield", new Buff("defense"), "kelly krysa");
    Artifact jellyFish = new Artifact("Jellyfish", new Buff("critRate"), "kelly krysa");
    Artifact carbine = new Artifact("Carbine", new Buff("attack"), "kelly krysa");
    Artifact skittles = new Artifact("Skittles", new Buff("health"), "kelly krysa");
    Artifact kunaiKnife = new Artifact("Kunai Knife", new Buff("critDamage"), "kelly krysa");

    //lucas smidt artifacts
    Artifact computer = new Artifact("Computer", new Buff("critRate"), "lucas smidt");
    Artifact proteinShake = new Artifact("Protein Shake", new Buff("health"), "lucas smidt");
    Artifact basketball = new Artifact("Basketball", new Buff("attack"), "lucas smidt");
    Artifact piano = new Artifact("Piano", new Buff("critDamage"), "lucas smidt");
    Artifact tardySlip = new Artifact("Tardy Slip", new Buff("attack"), "lucas smidt");

    //dan messerschmidt artifacts
    Artifact budweiser = new Artifact("Budweiser Bottle", new Buff("attack"), "dan messerschmidt");
    Artifact tissues = new Artifact("Tissues", new Buff("defense"), "dan messerschmidt");
    Artifact brokenKeyboard = new Artifact("Broken Keyboard", new Buff(""), "dan messerschmidt");
    Artifact poop = new Artifact("Poop", new Buff(""), "dan messerschmidt");
    Artifact nachos = new Artifact("Nachos", new Buff("health"), "dan messerschmidt");

    //nolan anderson artifacts
    Artifact manscappedRazerBundle = new Artifact("Manscapped Razer Bundle", new Buff("attack"), "nolan anderson");
    Artifact lubricant = new Artifact("Lubricant", new Buff("defense"), "nolan anderson");
    Artifact pondWater = new Artifact("Pond Water", new Buff("health"), "nolan anderson");
    Artifact chikFilABurrito = new Artifact("Chik-Fil-A Burrito", new Buff("defense"), "nolan anderson");
    Artifact spicyStick = new Artifact("Spicy Stick", new Buff("attack"), "nolan anderson");

    //gavin knudsen artifacts
    Artifact nutCracker = new Artifact("Nut Cracker", new Buff("defense"), "gavin knudsen");
    Artifact saltyNuts = new Artifact("Salty Nuts", new Buff("health"), "gavin knudsen");
    Artifact bowlOfNuts = new Artifact("Bowl of Nuts", new Buff("critDamage"), "gavin knudsen");
    Artifact secretSauce = new Artifact("Secret Sauce", new Buff("health"), "gavin knudsen");
    Artifact emptyPringlesCan = new Artifact("Empty Pringles Can", new Buff("attack"), "gavin knudsen");

    //bryce anderson artifacts
    Artifact murphysNuts = new Artifact("Murphy's Nuts", new Buff("health"), "bryce anderson");
    Artifact quandaleDingleFartInAJar = new Artifact("Quandale Dingle Fart In A Jar", new Buff("attack"), "bryce anderson");
    Artifact buttahDog = new Artifact("buttah Dog", new Buff("defense"), "bryce anderson");
    Artifact nyanCat = new Artifact("Nyan Cat", new Buff("critRate"), "bryce anderson");
    Artifact angryAnubis = new Artifact("Angry Anubis", new Buff("critRate"), "bryce anderson");

    //Down Town artifacts
    Artifact trashCanLid = new Artifact("Trash Can Lid", new Buff("defense"), "down town");
    Artifact suit = new Artifact("Suit", new Buff("defense"), "down town");
    Artifact jacket = new Artifact("Jacket", new Buff("defense"), "down town");
    Artifact carKeys = new Artifact("Car Keys", new Buff(""), "down town");
    Artifact cardboardBox = new Artifact("Cardboard Box", new Buff(""), "down town");
    Artifact moldyCheese = new Artifact("Moldy Cheese", new Buff(""), "down town");
    Artifact emptyBeerBottle = new Artifact("Empty Beer Bottle", new Buff("attack"), "down town");

    //Man Clan artifacts
    //Hentai Man
    Artifact phone = new Artifact("Phone", new Buff("critDamage"), "man clan");
    Artifact spoonCollection = new Artifact("Spoon Collection", new Buff("health"), "man clan");
    Artifact crustyBodyPillow = new Artifact("Crusty Body Pillow", new Buff("defense"), "man clan");
    Artifact bluetoothSpeakerThatPlaysVineBoomSoundEffect = new Artifact("Bluetooth Speaker That Plays Vine Boom Sound Effect", new Buff("health"), "man clan");
    Artifact soakedDoujin = new Artifact("Soaked Doujin", new Buff("critRate"), "man clan");
    //kchuntMan artifacts


    //Dylan Topic artifacts

    //David Napier artifacts
    Artifact davidsGoldenAmuletOfMotherlessness = new Artifact("David's Golden Amulet of Motherlessness", new Buff("health"), "david napier");
    Artifact titaniumStiltsForShortKings = new Artifact("Titanium Stilts For Short Kings", new Buff("defense"), "david napier");
    Artifact headbangersGuitarOfLoneliness = new Artifact("Head-banger's Guitar of Loneliness", new Buff("critDamage"), "david napier");
    Artifact fidgetSpinner = new Artifact("Fidget Spinner", new Buff("attack"), "david napier");
    Artifact pictureOfChildScreaming = new Artifact("Picture of Child Screaming", new Buff(""), "david napier");

    //hyvee artifacts
    Artifact hyveeFuelSaverCard = new Artifact("Hy-vee Fuel Saver Card", new Buff(""), "hyvee");
    Artifact hyveeBrandWater = new Artifact("Hy-vee Brand Water", new Buff(""), "hyvee");
    Artifact hyveeBrandSpaghetti = new Artifact("Hy-vee Brand Spaghetti", new Buff(""), "hyvee");
    Artifact hyveeBrandCandy = new Artifact("Hy-vee Brand Candy", new Buff(""), "hyvee");
    Artifact hyveeBrandFruit = new Artifact("Hy-vee Brand Fruit", new Buff(""), "hyvee");
    Artifact hyveeBrandCereal = new Artifact("Hy-vee Brand Cereal", new Buff(""), "hyvee");
    Artifact lostCreditCard = new Artifact("Lost Credit Card", new Buff(""), "hyvee");
    Artifact lostID = new Artifact("Lost ID", new Buff(""), "hyvee");

    contentArtifacts.add(rubiksCube);
    contentArtifacts.add(fork);
    contentArtifacts.add(bucket);
    contentArtifacts.add(globe);
    contentArtifacts.add(blanket);
    contentArtifacts.add(loliBodyPillow);
    contentArtifacts.add(madokaChibiPlush);
    contentArtifacts.add(loliCloth);
    contentArtifacts.add(pepsiBottle);
    contentArtifacts.add(osuTablet);
    contentArtifacts.add(bone);
    contentArtifacts.add(multipetPigDogToy);
    contentArtifacts.add(cheeseWheel);
    contentArtifacts.add(silkDogBed);
    contentArtifacts.add(bellyRubMachine);
    contentArtifacts.add(macBook);
    contentArtifacts.add(canesTendies);
    contentArtifacts.add(keyCard);
    contentArtifacts.add(bowlOfNoodles);
    contentArtifacts.add(bikeTirePump);
    contentArtifacts.add(blueprints);
    contentArtifacts.add(violin);
    contentArtifacts.add(aceUpTheSleeve);
    contentArtifacts.add(halfEatenSandwich);
    contentArtifacts.add(weightedDice);
    contentArtifacts.add(rouletteWheel);
    contentArtifacts.add(bouncer);
    contentArtifacts.add(usedUndies);
    contentArtifacts.add(hairBrush);
    contentArtifacts.add(handCuffs);
    contentArtifacts.add(restraints);
    contentArtifacts.add(strangeFlashlight);
    contentArtifacts.add(chalkBag);
    contentArtifacts.add(climbingShoes);
    contentArtifacts.add(harness);
    contentArtifacts.add(belayDevice);
    contentArtifacts.add(karabiner);
    contentArtifacts.add(redEvoShield);
    contentArtifacts.add(jellyFish);
    contentArtifacts.add(carbine);
    contentArtifacts.add(skittles);
    contentArtifacts.add(kunaiKnife);
    contentArtifacts.add(computer);
    contentArtifacts.add(proteinShake);
    contentArtifacts.add(basketball);
    contentArtifacts.add(piano);
    contentArtifacts.add(tardySlip);
    contentArtifacts.add(budweiser);
    contentArtifacts.add(tissues);
    contentArtifacts.add(brokenKeyboard);
    contentArtifacts.add(poop);
    contentArtifacts.add(nachos);
    contentArtifacts.add(manscappedRazerBundle);
    contentArtifacts.add(lubricant);
    contentArtifacts.add(pondWater);
    contentArtifacts.add(chikFilABurrito);
    contentArtifacts.add(spicyStick);
    contentArtifacts.add(nutCracker);
    contentArtifacts.add(saltyNuts);
    contentArtifacts.add(bowlOfNuts);
    contentArtifacts.add(secretSauce);
    contentArtifacts.add(emptyPringlesCan);
    contentArtifacts.add(murphysNuts);
    contentArtifacts.add(quandaleDingleFartInAJar);
    contentArtifacts.add(buttahDog);
    contentArtifacts.add(nyanCat);
    contentArtifacts.add(angryAnubis);
    contentArtifacts.add(trashCanLid);
    contentArtifacts.add(suit);
    contentArtifacts.add(jacket);
    contentArtifacts.add(carKeys);
    contentArtifacts.add(cardboardBox);
    contentArtifacts.add(moldyCheese);
    contentArtifacts.add(emptyBeerBottle);
    contentArtifacts.add(phone);
    contentArtifacts.add(spoonCollection);
    contentArtifacts.add(crustyBodyPillow);
    contentArtifacts.add(bluetoothSpeakerThatPlaysVineBoomSoundEffect);
    contentArtifacts.add(soakedDoujin);
    contentArtifacts.add(davidsGoldenAmuletOfMotherlessness);
    contentArtifacts.add(titaniumStiltsForShortKings);
    contentArtifacts.add(headbangersGuitarOfLoneliness);
    contentArtifacts.add(fidgetSpinner);
    contentArtifacts.add(pictureOfChildScreaming);
    contentArtifacts.add(hyveeFuelSaverCard);
    contentArtifacts.add(hyveeBrandWater);
    contentArtifacts.add(hyveeBrandSpaghetti);
    contentArtifacts.add(hyveeBrandFruit);
    contentArtifacts.add(hyveeBrandCandy);
    contentArtifacts.add(hyveeBrandCereal);
  }

  public static ArrayList<Artifact> getContentArtifacts(){
    return contentArtifacts;
  }
}
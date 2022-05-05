package content;
import java.util.ArrayList;
import artifact.Artifact;
import buff.Buff;

public class artifacts {
  private static ArrayList<Artifact> contentArtifacts = new ArrayList<Artifact>();

  public artifacts(){
    
  }

  public static ArrayList<Artifact> getContentArtifacts(){
    //nathan tenny artifacts
    Artifact rubiksCube = new Artifact("Rubik's Cube", new Buff("critRate"), "nathan tenny");

    //brayden messerschmidt artifacts
    Artifact animeManga = new Artifact("animeManga", new Buff(""), "brayden messerschmidt");
    Artifact hyveeFualSaverCard = new Artifact("Hy-vee Fuel Saver", new Buff("critRate"), "brayden messerschmidt");

    //joe nuts artifacts
    Artifact joesCube = new Artifact("Joe's Cube", new Buff("defense"), "joe nuts");

    //connor fogarty artifacts
    Artifact bone = new Artifact("Bone", new Buff("health"), "connor fogarty");
    Artifact multipetPigDogToy = new Artifact("Multipet Pig Dog ToyⓇ", new Buff("critRate"), "connor fogarty");
    Artifact cheeseWheel = new Artifact("Cheese Wheel", new Buff("defense"), "connor fogarty");
    Artifact silkDogBed = new Artifact("Silk Dog Bed", new Buff("critDamage"), "connor fogarty");
    Artifact bellyRubMachine = new Artifact("Belly Rub Machine", new Buff("attack"), "connor fogarty");

    //alec ferchan artifacts
    Artifact macBook = new Artifact("Mac Book", new Buff("critDamage"), "alec ferchan");
    Artifact canesTendies = new Artifact("Cane's Tendies", new Buff("health"), "alec ferchan");

    //max shrum artifacts
    Artifact keyCard = new Artifact("Key Card", new Buff("critRate"), "max shrum");
    Artifact bowlOfNoodles = new Artifact("Bowl O' Noodles", new Buff("health"), "max shrum");

    //spencer george artifacts
    Artifact aceUpTheSleeve = new Artifact("Ace Up The Sleeve", new Buff("critDamage"), "spencer george");
    Artifact halfEatenSandwich = new Artifact("Half Eaten Sandwich", new Buff("health"), "spencer george");
    Artifact weightedDice = new Artifact("Weighted Dice", new Buff("defense"), "spencer george");
    Artifact rouletteWheel = new Artifact("Roulette Wheel", new Buff("attack"), "spencer george");
    Artifact bouncer = new Artifact("Bouncer", new Buff("defense"), "spencer george");

    //mason james artifacts
    Artifact toothpaste = new Artifact("Toothpaste", new Buff("attack"), "mason james");
    Artifact luckyFloss = new Artifact("Lucky Floss", new Buff("health"), "mason james");
    Artifact dentures = new Artifact("Dentures", new Buff("defense"), "mason james");
    Artifact retainers = new Artifact("Retainers", new Buff("critRate"), "mason james");
    Artifact toothComb = new Artifact("Tooth Comb", new Buff("critDamage"), "mason james");

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

    contentArtifacts.add(rubiksCube);
    contentArtifacts.add(animeManga);
    contentArtifacts.add(hyveeFualSaverCard);
    contentArtifacts.add(joesCube);
    contentArtifacts.add(bone);
    contentArtifacts.add(multipetPigDogToy);
    contentArtifacts.add(cheeseWheel);
    contentArtifacts.add(silkDogBed);
    contentArtifacts.add(bellyRubMachine);
    contentArtifacts.add(macBook);
    contentArtifacts.add(canesTendies);
    contentArtifacts.add(keyCard);
    contentArtifacts.add(bowlOfNoodles);
    contentArtifacts.add(aceUpTheSleeve);
    contentArtifacts.add(halfEatenSandwich);
    contentArtifacts.add(weightedDice);
    contentArtifacts.add(rouletteWheel);
    contentArtifacts.add(bouncer);
    contentArtifacts.add(toothpaste);
    contentArtifacts.add(luckyFloss);
    contentArtifacts.add(dentures);
    contentArtifacts.add(retainers);
    contentArtifacts.add(toothComb);
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

    return contentArtifacts;
  }
}
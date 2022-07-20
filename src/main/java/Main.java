import java.io.*;
import java.nio.file.*;
import java.util.*;

import content.*;
import org.json.JSONArray;
import org.json.JSONObject;

import artifact.Artifact;
import buff.Buff;
import character.Character;
import enemy.Enemy;
import location.BattleArea;
import location.Location;
import weapon.Verbs;
import weapon.Weapon;
import data.Inventory;

class Main{
  static Inventory inventory = new Inventory();
  static ArrayList<Character> gachaCharacterObtained = new ArrayList<Character>();
  static ArrayList<Weapon> gachaWeapopnObtained = new ArrayList<Weapon>();
  static String gameDataFilePath = "GameData.json";
  static JSONObject settings = new JSONObject();
  static int startupAmount;

  public static void main(String[] args) throws IOException {
    if(Files.exists(Path.of(gameDataFilePath))){
      startupAmount = getData().getInt("startupamount");
    }
    else{
      System.out.println("no save files found... creating them now!");
      createFiles();
      gameDataFilePath = System.getProperty("user.dir") + "/GameData.json";
      startupAmount = getData().getInt("startupamount");

    }
      String nameTest = "";
    for(int i = 0; i<args.length; i++){
      nameTest += args[i] + " ";
    }
    clearConsole();
    System.out.println("loading...");
    System.out.println("loading artifacts");
    artifacts.initializeContentArtifacts();
    System.out.println("loading characters");
    characters.initializeContentCharacters();
    System.out.println("loading weapons");
    weapons.initializeContentWeapons();
    System.out.println("loading battle areas");
    BattleAreas.initializeContentBattleAreas();
    System.out.println("loading locations");
    Locations.initializeContentLocations();
    System.out.println("loading game data");
    loadGame();
    Character equipedCharacter = null;
    if(getData().getInt("startupamount") == 0){
      Character player = null;
      if(args.length != 0){
        System.out.println("\n\n\n\n\nThanks for contributing to the content of this game!\nAs a gift take this.");
        gacha(false, 1, nameTest.substring(0, nameTest.length() - 1));
        player = inventory.getCharacters().get(0);
      }
      else{
        System.out.println("what's this protagonists name?");
        String name = new Scanner(System.in).nextLine();
        clearConsole();
        player = new Character(1, name, 1, 1, 1, 0.5, 1, "The guy");
      }


      equipedCharacter = player;
      //equipedCharacter.levelUp(99);
      Weapon fists = new Weapon("fists", 1, "hand", 5, new Buff("attack"), new Verbs("punched", "slapped the absolute poop out of"), "Just your hands.");

      if(player.getWeapon() == null) player.equipWeapon(fists, false);
      try{
        inventory.getCharacters().get(0);
      }
      catch (Exception e) {
        inventory.addCharacter(player);
      }

      timeout(2000, false);
      System.out.println("It's 10pm.");
      pressEnterToContinue(false, false);
      System.out.println(equipedCharacter.getName() + " is at the convenience store buying instant noodles.");
      pressEnterToContinue(false, false);
      System.out.println("He purchases " + (int)((Math.random() * ((Math.random() * 10) + 1)) + 1) + " packages of instant noodles and walks out the door.");
      pressEnterToContinue(false, false);
      System.out.println("As he is walking down the road a pedestrian runs up to him, pulls out a knife and commands " + equipedCharacter.getName() + " to give him $" + (int)((Math.random() * ((Math.random() * 1000) + 1)) + 1));
      pressEnterToContinue(false, false);
      System.out.println(equipedCharacter.getName() + " Prepares for battle\n");
      pressEnterToContinue(false, false);

      startBattle(BattleAreas.getContentBattleAreas().get(0), equipedCharacter, false, false);
      pressEnterToContinue(false, false);

      if(equipedCharacter.getStarRating() == 6){
        System.out.println("its quiet...");
      }
      else{
        System.out.println("Or so " + equipedCharacter.getName() + " thought...");
        pressEnterToContinue(false, false);

        System.out.println(equipedCharacter.getName() + " opened his eyes.\nAs he looks around he notices he is in someone's living room.\n\"How did I get here?\" he asked himself.\nSomeone comes into the room.\n\"Oh my, you're awake.\" she says.\n\"I'm surprised I was able to save you. You were injured pretty badly.\"");
        pressEnterToContinue(false, false);
        System.out.println("\"Thankfully Chug-Jugs are really effective.\"");
        pressEnterToContinue(false, false);
        System.out.println("\"Thank you.\" you reply. \"But I must return home. My sister might get worried.\"\n\"Such a good sibling you are.\" she says. \"As I see you're a very respectful young man I will give you this...\"");
        pressEnterToContinue(false, false);
        gacha(true, 1);
        System.out.println("\"I can't thank you enough!\" " + equipedCharacter.getName() + " says. She smiles at you while you exit through the front door.");
        if(equipedCharacter.getWeapon().getName() == "fists"){
          equipedCharacter.deEquipWeapon(false);
          equipedCharacter.equipWeapon(inventory.getWeapons().get(0), true);
        }
      }

      pressEnterToContinue(false, false);

      System.out.println("Welcome to Gentry's Quest!");
      timeout(2500, true);
    }
    else {
      //equip equipped character from data
    }
    startupAmount += 1;

    while(true){
      int input = getMainMenuInput("1.Travel\n2.Gacha\n3.Inventory\n4.Options\n5.changelog\n6.Quit", rangeArrayListMaker(1, 6));
      //Locations
      if(input == 1){
        clearConsole();
        listLocations();
        int input2 = getMainMenuInput("where would you like to go?\n", rangeArrayListMaker(1, Locations.getContentLocations().size()));
        Location location = Locations.getContentLocations().get(input2 - 1);
        clearConsole();
        location.listBattleAreas();
        input2 = getMainMenuInput("where in " + location.getName() + " would you like to go?", rangeArrayListMaker(1, location.battleAreaCount()));
        clearConsole();
        startBattle(location.getBattleArea(input2 - 1), equipedCharacter, true, true);
        try{
        }
        catch (Exception e){
          clearConsole();
          System.out.println("This battle area doesn't exist...");
          try {
            Thread.sleep(2000);
          } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
          }
          clearConsole();
        }
      }
      //gacha
      else if (input == 2) {
        clearConsole();
        int input2 = getMainMenuInput("what would you like to pull?\n1.character\n2.Weapon", new ArrayList<Integer>(List.of(1, 2)));
        clearConsole();
        //character
        if (input2 == 1){
          clearConsole();
          System.out.println("how many characters would you like to pull?\n!MAXIMUM OF 100!\n1 = $1000\nYou have: " + "$" + inventory.getMoney());
          int amount = getMainMenuInput("", rangeArrayListMaker(0, 100));
          clearConsole();
          if(inventory.checkMoney(amount * 1000)){
            inventory.spendMoney(amount * 1000);
            gacha(false, amount);
          }
        }
        //weapon
        else if(input2 == 2){
          clearConsole();
          int amount = getMainMenuInput("how many characters would you like to pull?\n!MAXIMUM OF 100!\n1 = $1000\nYou have: " + "$" + inventory.getMoney(), rangeArrayListMaker(0, 100));
          clearConsole();
          if(inventory.checkMoney(amount * 1000)){
            inventory.spendMoney(amount * 1000);
            gacha(true, amount);
          }
        }
        timeout(2000, true);
      }
      //inventory
      else if (input == 3) {
        boolean inventoryViewing = true;
        while(inventoryViewing){
          clearConsole();
          System.out.println("$" + inventory.getMoney());
          int input2 = getMainMenuInput("1.Characters\n2.Artifacts\n3.Weapons\n4.Back", rangeArrayListMaker(1, 4));
          clearConsole();
          //Characters
          if(input2 == 1){
            boolean characterViewing = true;
            while(characterViewing){

              int indexCounter = 1;
              for(Character character: inventory.getCharacters()){
                System.out.println(indexCounter + ". " + character.getName() + " " + character.getFancyStars() + " lvl " +  character.getLevel());
                indexCounter++;
              }
              int input3 = getMainMenuInput("View character\nor\n" + indexCounter + ". quit", rangeArrayListMaker(1, indexCounter));
              clearConsole();
              if(input3 == inventory.getCharacters().size() + 1) characterViewing = false;
              else{
                Character character = inventory.getCharacters().get(input3 - 1);
                boolean characterInfoViewing = true;
                while(characterInfoViewing){
                  System.out.println(character);
                  int input4 = getMainMenuInput("1.level up\n2.manage weapon\n3.manage artifacts\n4.equip character\n5.back", rangeArrayListMaker(1, 5));
                  clearConsole();
                  //leveling
                  if(input4 == 1){
                    float percent = (character.getXp() * 100.0f) / character.getXpRequired();
                    boolean leveling = true;
                    while(leveling){
                      int input5 = getMainMenuInput("lvl " + character.getLevel() +
                              "\nxp " + character.getXp() + "/" + character.getXpRequired() + " (" + percent + ")" +
                              "\nupgrade your character?\n" +
                              "$" + inventory.getMoney() + "/" + "$" + (int)(character.getXpRequired() * 0.1) + " required to level up" +
                              "\n$1 = 10xp\n0 to go back", rangeArrayListMaker(0, inventory.getMoney()));
                      clearConsole();
                      if(input5 != 0){
                        if(inventory.checkMoney(input5)){
                          character.addXp(input5 * 10);
                          inventory.spendMoney(input5);
                        }
                      }
                      else{
                        leveling = false;
                      }
                    }
                  }

                  //manage weapon
                  else if(input4 == 2){
                    boolean weaponViewing = true;
                    while(weaponViewing){
                      int input5 = getMainMenuInput(character.getName() + " currently has the weapon " + character.getWeapon() + " equipped\n1.swap weapon\n2.back", rangeArrayListMaker(1, 2));
                      clearConsole();
                      //swap weapon
                      int counter = 1;
                      if(input5 == 1){
                        //list weapons
                        for(Weapon weapon: inventory.getWeapons()){
                          System.out.println(counter + "." + weapon.getName() + " " + weapon.getFancyStars() + " lvl " + weapon.getLevel());
                          counter++;
                        }
                        int input6 = getMainMenuInput("select a weapon or " + counter + ".back", rangeArrayListMaker(1, counter));
                        if(input6 != counter) {
                          clearConsole();
                          character.deEquipWeapon(false);
                          character.equipWeapon(inventory.getWeapons().get(input6 - 1), true);
                        }
                        clearConsole();
                      }
                      //end loop
                      else if(input5 == 2) weaponViewing = false;
                    }
                  }

                  //manage artifacts
                  else if(input4 == 3){
                    clearConsole();
                    boolean artifactViewing = true;
                    while(artifactViewing){
                      for(int i = 1; i<6; i++){
                        if(character.getArtifactList()[i - 1] == null) System.out.println(i + ". unequipped");
                        else System.out.println(i + ". " + character.getArtifactList()[i - 1].getName() + " " + character.getArtifactList()[i - 1].getFancyStars() + " lvl " + character.getArtifactList()[i - 1].getLevel());
                      }
                      int input5 = getMainMenuInput(6 + ". back", rangeArrayListMaker(1, 6));
                      clearConsole();
                      if(input5 != 6){
                        boolean artifactDetailViewing = true;
                        while(artifactDetailViewing){
                          if(character.getArtifactList()[input5 - 1] == null){
                            switchArtifact(character, input5 - 1, null);
                            clearConsole();
                            break;
                          }
                          else{
                            System.out.println(character.getArtifactList()[input5 - 1]);
                            int input6 = getMainMenuInput("1.switch artifact\n2.remove artifact\n3.upgrade artifact\n4.back", rangeArrayListMaker(1, 4));
                            clearConsole();
                            if(input6 == 1){
                              switchArtifact(character, input5 - 1, character.getArtifactList()[input5 - 1]);
                            }
                            else if(input6 == 2){
                              removeArtifact(character, input5 - 1);
                              break;
                            }
                            else if(input6 == 3){
                              boolean upgradingArtifact = true;
                              while(upgradingArtifact){
                                if(character.getArtifactList()[input5 - 1].getLevel() == character.getArtifactList()[input5 - 1].getStarRating() * 4){
                                  System.out.println("Artifact is max level!");
                                  upgradingArtifact = false;
                                  break;
                                }
                                int tracker = 1;
                                for(Artifact artifact: inventory.getArtifacts()){
                                  System.out.println(tracker + ". " + artifact);
                                  tracker++;
                                }
                                int input7 = getMainMenuInput("which would you like to exchange?\n" + (inventory.getArtifacts().size() + 1) + ". back", rangeArrayListMaker(1, inventory.getArtifacts().size() + 1));
                                if(input7 != inventory.getArtifacts().size() + 1){
                                  upgradeArtifact(character.getArtifactList()[input5 - 1], inventory.getArtifacts().get(input7 - 1));
                                }
                                else{
                                  clearConsole();
                                  upgradingArtifact = false;
                                  break;
                                }
                              }
                            }
                            else{
                              clearConsole();
                              artifactDetailViewing = false;
                            }
                          }
                        }
                      }
                      else{
                        character.levelUp(0);
                        artifactViewing = false;
                      }
                    }
                  }

                  //equip character
                  else if(input4 == 4){
                    equipedCharacter = character;
                    System.out.println("You equiped " + character.getName() + " " + character.getFancyStars() + " lvl " + character.getLevel());
                  }

                  //end loop
                  else if(input4 == 5) characterInfoViewing = false;
                }
              }
            }
          }
          //artifacts
          else if(input2 == 2){
            boolean artifactViewing = true;
            while(artifactViewing){
              for(int i = 1; i < inventory.getArtifacts().size() + 1; i++){
                Artifact artifact = inventory.getArtifacts().get(i - 1);
                System.out.println(i + ". " + artifact);
              }
              int input3 = getMainMenuInput((inventory.getArtifacts().size() + 1) + ". back\nselect an artifact", rangeArrayListMaker(1, inventory.getArtifacts().size() + 1));
              if(input3 == inventory.getArtifacts().size() + 1)break;
              else{
                Artifact artifact = inventory.getArtifacts().get(input3 - 1);
                clearConsole();
                boolean viewingArtifact = true;
                while(viewingArtifact){
                  int input4 = getMainMenuInput(artifact + "\n1.level up artifact\n2.back", rangeArrayListMaker(1, 2));
                  if(input4 == 1){
                    clearConsole();
                    boolean upgradingArtifact = true;
                    while(upgradingArtifact){
                      if(artifact.getLevel() == artifact.getStarRating() * 4){
                        System.out.println("Artifact is max level!");
                        upgradingArtifact = false;
                        clearConsole();
                        break;
                      }
                      for(int i = 1; i < inventory.getArtifacts().size() + 1; i++){
                        Artifact artifact2 = inventory.getArtifacts().get(i - 1);
                        System.out.println(i + ". " + artifact2);
                      }
                      int input5 = getMainMenuInput("which would you like to exchange?\n" + (inventory.getArtifacts().size() + 1) + ". back", rangeArrayListMaker(1, inventory.getArtifacts().size() + 1));
                      if(input5 != inventory.getArtifacts().size() + 1){
                        upgradeArtifact(inventory.getArtifacts().get(input4 - 1), inventory.getArtifacts().get(input5 - 1));
                      }
                      else{
                        clearConsole();
                        break;
                      }
                    }
                  }
                  else{
                    clearConsole();
                    break;
                  }
                }
              }
            }
          }
          //weapons
          else if(input2 == 3){
            boolean selectingWeapons = true;
            while(selectingWeapons){
              int counter = 1;
              for(Weapon weapon: inventory.getWeapons()){
                System.out.println(counter + "." + weapon.getName() + " " + weapon.getFancyStars() + " lvl " + weapon.getLevel());
                counter += 1;
              }
              int input3 = getMainMenuInput("select a weapon\nor\n0.back", rangeArrayListMaker(0, counter));
              clearConsole();
              if(input3 != 0){
                Weapon weapon = inventory.getWeapons().get(input3 -1);
                float percent = (weapon.getXp() * 100.0f) / weapon.getXpRequired();
                boolean leveling = true;
                while(leveling){
                  int input4 = getMainMenuInput("lvl " + weapon.getLevel() + "\nxp " + weapon.getXp() + "/" + weapon.getXpRequired() + " (" + percent + ")\n\nupgrade your weapon?\n$1 = 10xp\n0 to go back", rangeArrayListMaker(0, inventory.getMoney()));
                  clearConsole();
                  if(input4 == 0) leveling = false;
                  else{
                    if(inventory.checkMoney(input4)){
                      weapon.addXp(input4 * 10);
                      inventory.spendMoney(input4);
                    }
                  }
                }
              }
              else selectingWeapons = false;
            }
          }
          else inventoryViewing = false;
        }
      }
      //settings
      else if(input == 4){
        clearConsole();
        boolean inSettings = true;
        while(inSettings){
          System.out.println("1. debug [" + isToggledSetting("debug", true) + "]");
          System.out.println("2. clear data");
          System.out.println("3. test battle scene");
          int input2 = getMainMenuInput("4. exit", rangeArrayListMaker(1, 4));
          //debug toggle
          if(input2 == 1) toggleSetting("debug");
          //clear data
          else if(input2 == 2) clearData();
          else if(input2 == 3) testBattleScene();
          else{
            clearConsole();
            inSettings = false;
          }
        }
      }
      else if(input == 5){
        clearConsole();
        System.out.println("v2.0.0 BETA");
        System.out.println("!some content that was added wasn't included in changelog!\n" +
                "* removed infinite money statement by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/2\n" +
                "* Regulated enemy stats by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/3\n" +
                "* Rescaled enemy level to stats result by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/4\n" +
                "* added some cody content by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/5\n" +
                "* Added intro sequence for starting out by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/6\n" +
                "* Fixed battle areas index out of bounds exception in robloxia high location by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/7\n" +
                "* Fixed locations not being indexed when listed by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/8\n" +
                "* Fixed difficulty incrementor going up on first level up by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/14\n" +
                "* Corrected verbs for quandale dingle weapon by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/16\n" +
                "* Made health restore at the end of battle area by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/18\n" +
                "* Made attack info shown in battles by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/19\n" +
                "* Fixed \"You have no weapon...\" dialogue from causing crashes by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/20\n" +
                "* Rescaled how stats change on leveling up by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/17\n" +
                "* Changed up the intro sequence a bit by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/21\n" +
                "* Fixed verb on brody's broadsword by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/22\n" +
                "* Fixed artifact is max level dialogue loop by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/23\n" +
                "* Removed single boss area parameter by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/24\n" +
                "* Work on mason content by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/25\n" +
                "* Added climbing gym battle area by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/26\n" +
                "* Added target battle area by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/27\n" +
                "* Made only one enemy appear in battle area if it's a boss area and there's only one enemy by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/28\n" +
                "* Added settings to the game by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/29\n" +
                "* Added arguments to start out with a character by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/30\n" +
                "* Fixed verbs on cool weapon by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/31\n" +
                "* Changed intro from timed to key press progression by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/32\n" +
                "* Changed code to update player stats after managing artifacts by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/44\n" +
                "* Changed `args[0] != null` to `args.length != 0` by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/43\n" +
                "* Fixed grammatical error in target battle area by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/41\n" +
                "* Add try & except clause around `averageStarRating` assignment by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/42\n" +
                "* Fixed player criticals not happening in battle by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/46\n" +
                "* Added obtaining of other families in results by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/47\n" +
                "* added divine characters by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/49\n" +
                "* Rescaled enemy stats by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/51\n" +
                "* Added missing clear console calls by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/53\n" +
                "* Added percentage value artifacts by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/59\n" +
                "* Reworked calculations to work without loops by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/66\n" +
                "* Added partial battle scene testing capability by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/60\n" +
                "* Added list of allowed keys to input methods to prevent crashes by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/67\n" +
                "* Added changelog by @GDcheeriosYT in https://github.com/GDcheeriosYT/gentrys-quest/pull/68");
        pressEnterToContinue(true, true);
      }
      else{
        saveGame();
        System.exit(0);
      }
    }
  }



  public static void gacha(Boolean pullWeapon, int amount){
    if(pullWeapon){
      int weaponsPulled = 0;
      for(int i = 0; i < amount; i = weaponsPulled){
        int randomPullWeapon = (int)((Math.random() * content.weapons.getContentWeapons().size()) + 1);
        int randomPullValue = (int)((Math.random() * ((Math.random() * 5) + 1)) + 1);
        Weapon weapon = content.weapons.getContentWeapons().get(randomPullWeapon - 1);
        if(weapon.getStarRating() <= randomPullValue){
          boolean ownsWeapon = false;
          for(Weapon inventoryWeapon: inventory.getWeapons()){
            if (weapon.getName().equals(inventoryWeapon.getName())) {
              ownsWeapon = true;
              break;
            }
          }
          if(ownsWeapon){
            inventory.addMoney(weapon.getStarRating() * 10);
            for(Weapon inventoryWeapon: inventory.getWeapons()){
              if (weapon.getName().equals(inventoryWeapon.getName())){
                inventoryWeapon.addXp(inventoryWeapon.getStarRating() * 100);
              }
            }
          }
          else{
            inventory.addWeapon(weapon);
          }
          weaponsPulled += 1;
          gachaWeapopnObtained.add(weapon);
        }
      }
      Map<String, Integer> counts = new HashMap<>();
      for (Weapon weapon : gachaWeapopnObtained) {
        int c = counts.computeIfAbsent(weapon.getName() + " " + weapon.getFancyStars(), key -> 0);
        counts.put(weapon.getName() + " " + weapon.getFancyStars(), ++c);
      }
      clearConsole();
      System.out.println("You got:");
      for (var entry : counts.entrySet()) {
        System.out.printf("%s x %d%n", entry.getKey(), entry.getValue());
      }
      gachaWeapopnObtained.clear();
      pressEnterToContinue(true, true);
    }
    else{
      int charactersPulled = 0;
      for(int i = 0; i < amount; i = charactersPulled){
        int randomPullCharacter = (int)((Math.random() * content.characters.getContentCharacters().size()) + 1);
        int randomPullValue = (int)((Math.random() * ((Math.random() * 5) + 1)) + 1);
        Character character = content.characters.getContentCharacters().get(randomPullCharacter - 1);
        if(character.getStarRating() <= randomPullValue){
          boolean ownsCharacter = false;
          for(Character inventoryCharacter: inventory.getCharacters()){
            if (character.getName().equals(inventoryCharacter.getName())) {
              ownsCharacter = true;
              break;
            }
          }
          if(ownsCharacter){
            inventory.addMoney(character.getStarRating() * 10);
            for(Character inventoryCharacter: inventory.getCharacters()){
              if (character.getName().equals(inventoryCharacter.getName())){
                inventoryCharacter.addXp(inventoryCharacter.getStarRating() * 100);
              }
            }
          }
          else{
            inventory.addCharacter(character);
          }
          charactersPulled += 1;
          gachaCharacterObtained.add(character);
        }
      }
      Map<String, Integer> counts = new HashMap<>();
      for (Character character : gachaCharacterObtained) {
        int c = counts.computeIfAbsent(character.getName() + " " + character.getFancyStars(), key -> 0);
        counts.put(character.getName() + " " + character.getFancyStars(), ++c);
      }
      clearConsole();
      System.out.println("You got:");
      for (var entry : counts.entrySet()) {
        System.out.printf("%s x %d%n", entry.getKey(), entry.getValue());
      }
      gachaCharacterObtained.clear();
      pressEnterToContinue(true, true);
    }
  }

  public static void gacha(Boolean pullWeapon, int amount, String name){
    if(pullWeapon){
      int weaponsPulled = 0;
      for(int i = 0; i < amount; i = weaponsPulled){
        Weapon weapon = content.weapons.getSpecificWeapon(name);
        inventory.addWeapon(weapon);
        weaponsPulled += 1;
        gachaWeapopnObtained.add(weapon);
      }
      Map<String, Integer> counts = new HashMap<>();
      for (Weapon weapon : gachaWeapopnObtained) {
        int c = counts.computeIfAbsent(weapon.getName() + " " + weapon.getFancyStars(), key -> 0);
        counts.put(weapon.getName() + " " + weapon.getFancyStars(), ++c);
      }
      System.out.println("You got:");
      for (var entry : counts.entrySet()) {
        System.out.printf("%s x %d%n", entry.getKey(), entry.getValue());
      }
      gachaWeapopnObtained.clear();
      pressEnterToContinue(true, true);
    }
    else{
      int charactersPulled = 0;
      for(int i = 0; i < amount; i = charactersPulled){
        Character character = content.characters.getSpecificCharacter(name);
        charactersPulled += 1;
        inventory.addCharacter(character);
        gachaCharacterObtained.add(character);
      }
      Map<String, Integer> counts = new HashMap<>();
      for (Character character : gachaCharacterObtained) {
        int c = counts.computeIfAbsent(character.getName() + " " + character.getFancyStars(), key -> 0);
        counts.put(character.getName() + " " + character.getFancyStars(), ++c);
      }
      System.out.println("You got:");
      for (var entry : counts.entrySet()) {
        System.out.printf("%s x %d%n", entry.getKey(), entry.getValue());
      }
      gachaCharacterObtained.clear();
      pressEnterToContinue(true, true);
    }
  }

  public static int getMainMenuInput(String text, ArrayList<Integer> allowedInputs) throws FileNotFoundException {
    Scanner input = null;
    int output = 0;
    boolean goodInput = false;
    while(!goodInput){
      input = new Scanner(System.in);
      System.out.println(text);
      try{
        int scannerInput = input.nextInt();
        if(isToggledSetting("debug", true)){
          System.out.println("debug: checking valid entries" + " {" + goodInput + "}");
        }
        for(int input1: allowedInputs){
          if(input1 == scannerInput){
            output = input1;
            if(isToggledSetting("debug", true)){
              System.out.println("debug: [" + allowedInputs.get(allowedInputs.indexOf(input1)) + "] valid entry" + " {" + !goodInput + "}");
              timeout(1000, true);
            }
            goodInput = true;
            break;
          }
          else{
            if(isToggledSetting("debug", true)){
              System.out.println("debug: [" + allowedInputs.get(allowedInputs.indexOf(input1)) + "]" + " not valid entry" + " {" + goodInput + "}");
            }
          }
        }
      }
      catch (InputMismatchException e){
        clearConsole();
      }
    }
    return output;
  }

  public static void clearConsole(){
    for (int i = 0; i < 100; i++) {
      System.out.println("");
    }
  }

  public static void listLocations(){
    int indexer = 1;
    for(Location location: content.Locations.getContentLocations()){
      System.out.println(indexer + ". " + location);
      indexer += 1;
    }
  }

  public static void startBattle(BattleArea battleArea, Character character, boolean canRun, boolean results) throws FileNotFoundException {
    ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    artifacts = battleArea.initializeArtifacts(character.getDifficulty());
    enemies = battleArea.initializeEnemies(character.getDifficulty(), (character.getLevel() % 20) + 2);

    boolean ran = false;
    String ending = "";
    String artifactList = "";

    for(Artifact artifact: artifacts){
      artifactList += artifact + "\n";
    }

    boolean alive = true;

    for(Enemy enemy: enemies){
      if(!alive) break;
      System.out.println(character.getName() + " encountered a " + enemy.getName());
      System.out.println(enemy);
      boolean fighting = true;
      while(fighting){
        int input;
        if(canRun){
          input = getMainMenuInput("===========================================\n\t" +
                  enemy.getName() + "(lvl " + enemy.getLevel() + ")" +
                  "\n\t" + enemy.getHealth() +
                  "\n==========================================\n" +
                  character.getName() + " has " + character.getHealth() + " health" +
                  "\n1.attack\n2.run", new ArrayList<Integer>(List.of(1,2)));
        }
        else{
          input = getMainMenuInput("===========================================\n\t" +
                  enemy.getName() + "(lvl " + enemy.getLevel() + ")" +
                  "\n\t" + enemy.getHealth() +
                  "\n==========================================\n" +
                  character.getName() + " has " + character.getHealth() + " health" +
                  "\n1.attack", new ArrayList<Integer>(List.of(1)));
        }
        if(input == 1){
          clearConsole();
          if(character.attack(enemy, isToggledSetting("debug", true))){
            inventory.addMoney(enemy.getLevel() * 2);
            character.addXp(enemy.getLevel() * 10);
            System.out.println("Killed " + enemy.getName() + ", received $" + (enemy.getLevel() * 2) + " and " + (enemy.getLevel() * 10) + "xp");
            fighting = false;
          }
          if(fighting){
            if(enemy.attack(character, isToggledSetting("debug", true))){
              alive = false;
              character.updateStats();
              artifacts.clear();
              fighting = false;
            }
          }
        }
        if(canRun){
          if(input == 2){
            ran = true;
            clearConsole();
            character.updateStats();
            artifacts.clear();
            break;
          }
        }
        else if(!canRun && input != 1){
          System.out.println(character.getName() + " did something you didn't expect to happen...");
        }
      }
      if(ran){
        ending = character.getName() + " ran\n" + ((enemies.indexOf(enemy) / enemies.size()) * 100) + "% completion";
        artifactList = "nothing";
        break;
      }
      else if(!alive){
        ending = ((enemies.indexOf(enemy) / enemies.size()) * 100) + "% completion";
        artifactList = "nothing";
      }
      else{
        ending = ((enemies.indexOf(enemy) / enemies.size()) * 100) + "% completion";
      }
    }
    for(Artifact artifact: artifacts){
      inventory.addArtifact(artifact);
    }
    if(results){
      character.updateStats();
      System.out.println("battle area summary:\n" +
              ending + "\n" +
              "obtained:\n" + artifactList
      );
      pressEnterToContinue(true, true);
    }
  }

  public static void switchArtifact(Character character, int position, Artifact startingArtifact) throws FileNotFoundException {
    int tracker = 1;
    for(Artifact artifact: inventory.getArtifacts()){
      System.out.println(tracker + ". " + artifact);
      tracker++;
    }
    int input = getMainMenuInput(tracker + ". back", rangeArrayListMaker(0, tracker));
    if(input != tracker){
      System.out.println("test");
      if(startingArtifact != null){
        character.deEquipArtifact(position);
        inventory.addArtifact(startingArtifact);
      }
      character.equipArtifact(position, inventory.getArtifacts().get(input - 1));
      inventory.removeArtifact(inventory.getArtifacts().get(input - 1));
      clearConsole();
    }
  }

  public static void removeArtifact(Character character, int position){
    inventory.addArtifact(character.getArtifactList()[position]);
    character.deEquipArtifact(position);
    clearConsole();
  }

  public static void upgradeArtifact(Artifact artifact, Artifact artifactInExchange){
    artifact.addXp((artifactInExchange.getLevel() * 50) * artifactInExchange.getStarRating());
    inventory.removeArtifact(artifactInExchange);
    clearConsole();
  }

  public static void timeout(int time, boolean clearConole){
    try {
      Thread.sleep(time);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    if(clearConole) clearConsole();
  }

  public static void saveGame() throws FileNotFoundException {
    //do inventory stuff
    JSONObject inventoryData = new JSONObject();

    JSONArray characterData = new JSONArray();

    for(Character character: inventory.getCharacters()){
      characterData.put(character.getData());
    }

    inventoryData.put("money", inventory.getMoney());
    inventoryData.put("characters", characterData);
    inventoryData.put("weapons", inventory.getWeapons());
    inventoryData.put("artifacts", inventory.getArtifacts());

    JSONObject gameData = new JSONObject();
    gameData.put("startupamount", startupAmount);
    gameData.put("inventory", inventoryData);
    gameData.put("settings", settings);

    if(isToggledSetting("debug", true)) System.out.println(gameData.toString(4));

    writeTo(gameDataFilePath, gameData.toString(4));
  }

  public static void writeTo(String fileName, String content) throws FileNotFoundException {
    try (FileWriter file = new FileWriter(fileName)) {
      file.write(content);
      file.flush();
    }
    catch (IOException e) {
      if(isToggledSetting("debug", true)) e.printStackTrace();
    }
  }

  public static JSONObject getData() throws FileNotFoundException {
    File file = new File(gameDataFilePath);

    String jsonData = "";

    try (BufferedReader br = new BufferedReader(new FileReader(file)))
    {
      String line;
      while ((line = br.readLine()) != null) {
        jsonData += line + "\n";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }


    return new JSONObject(jsonData);
  }

  public static void loadGame() throws FileNotFoundException, UnsupportedEncodingException {
    System.out.println("\tstep 1, configurations");
    settings.put("debug", isToggledSetting("debug", false));
    System.out.println("\tstep 2, characters");
    for(Object notJSONCharacterData: getData().getJSONObject("inventory").getJSONArray("characters")){
      JSONObject characterData = (JSONObject) notJSONCharacterData;
      if(isToggledSetting("debug", true)) System.out.println(characterData.toString(4));
//      int starRating = characterData.getInt("star rating");
//      String name = characterData.getString("name");
//      String description = characterData.getString("description");
//      JSONObject stats = characterData.getJSONObject("stats");
//      int health = stats.getInt("health");
//      int attack = stats.getInt("attack");
//      int defense = stats.getInt("defense");
//      double critRate = stats.getDouble("critRate");
//      int critDamage = stats.getInt("critDamage");
//      Character character = new Character(
//          starRating,
//          name,
//          health,
//          attack,
//          defense,
//          critRate,
//          critDamage,
//          description,
//
//      )
    }
  }

  public static boolean isToggledSetting(String setting, boolean instancedSettings) throws FileNotFoundException {
    if(instancedSettings) return settings.getBoolean(setting);
    else{
      JSONObject gameData = getData();
      return gameData.getJSONObject("settings").getBoolean(setting);
    }
  }

  public static void toggleSetting(String setting) throws FileNotFoundException {
    settings.put(setting, !isToggledSetting(setting, true));
    clearConsole();
    System.out.println("toggled debug");
  }

  public static void clearData() throws FileNotFoundException {

    String jsonData = "{\n" +
            "  \"startupamount\" : 0,\n" +
            "  \"inventory\" : {\n" +
            "    \"money\" : 0,\n" +
            "    \"characters\" : [],\n" +
            "    \"weapons\" : [],\n" +
            "    \"artifacts\" : []\n" +
            "  },\n" +
            "  \"settings\" : {\n" +
            "    \"debug\" : false\n" +
            "  }\n" +
            "}";

    writeTo(gameDataFilePath, new JSONObject(jsonData).toString(4));
    clearConsole();
    System.out.println("cleared data");
  }

  public static void pressEnterToContinue(boolean clearConsole, boolean print){
    if(print) System.out.println("press enter to continue...");
    new Scanner(System.in).nextLine();
    if(clearConsole) clearConsole();
  }

  public static void testBattleScene() throws FileNotFoundException {
    //variables
    Enemy testDummy = new Enemy("Test Dummy", 15, 1, 1, new Weapon("Test Weapon", new Verbs("did something to", "did something crazy to")), "a test dummy for the battle testing scene");
    Character testGuy = new Character(1, "Test Guy", 0, 0, 0, 0.0, 0, "a test guy for the battle testing scene");

    Artifact testArtifact1 = new Artifact("Test Artifact", new Buff(""), "testing");
    Artifact testArtifact2 = new Artifact("Test Artifact", new Buff(""), "testing");
    Artifact testArtifact3 = new Artifact("Test Artifact", new Buff(""), "testing");
    Artifact testArtifact4 = new Artifact("Test Artifact", new Buff(""), "testing");
    Artifact testArtifact5 = new Artifact("Test Artifact", new Buff(""), "testing");

    testArtifact1.setStarRating(1);
    testArtifact2.setStarRating(1);
    testArtifact3.setStarRating(1);
    testArtifact4.setStarRating(1);
    testArtifact5.setStarRating(1);

    testGuy.equipArtifact(0, testArtifact1);
    testGuy.equipArtifact(1, testArtifact2);
    testGuy.equipArtifact(2, testArtifact3);
    testGuy.equipArtifact(3, testArtifact4);
    testGuy.equipArtifact(4, testArtifact5);

    Weapon testWeapon = new Weapon("Test Weapon", 1, "test", 1, new Buff(""), new Verbs("did something", "did something better"), "just a testing weapon.");

    testGuy.equipWeapon(testWeapon, true);

    //scene mainLoop
    clearConsole();
    System.out.println("You are now testing a battle area scene.");
    boolean testing = true;
    while(testing){
      System.out.println(testGuy.getName() + " encountered a " + testDummy.getName());
      System.out.println(testDummy);
      boolean fighting = true;
      while(fighting){
        clearConsole();
        int input;
        input = getMainMenuInput("===========================================\n\t" +
                testDummy.getName() + "(lvl " + testDummy.getLevel() + ")" +
                "\n\t" + testDummy.getHealth() +
                "\n==========================================\n" +
                testGuy.getName() + " has " + testGuy.getHealth() + " health" +
                "\n1.attack\n2.edit test data\n3.run", rangeArrayListMaker(0, 3));
        if(input == 1){
          if(testGuy.attack(testDummy, isToggledSetting("debug", true))) testDummy.setLevel(testGuy.getLevel());
          if(testDummy.attack(testGuy, isToggledSetting("debug", true))) testGuy.updateStats();
        }
        else if(input == 2){
          clearConsole();
          int input2 = getMainMenuInput("1.enemy\n2.player\n3.break", rangeArrayListMaker(1, 3));
          clearConsole();
          if(input2 == 1) testDummy.editStats();
          else if(input2 == 2) testGuy.editStats();
          else break;
        }
        else if(input == 3){
          clearConsole();
          testing = false;
        }
      }
      pressEnterToContinue(true, true);
    }
  }
  public int generateStarRating() {
    int randomNumber = (int) (Math.random() * 100) + 1;
    if (randomNumber <= 7) return 5;
    else if (randomNumber <= 20) return 4;
    else if (randomNumber <= 35) return 3;
    else if (randomNumber <= 50) return 2;
    else if (randomNumber <= 80) return 1;
    return 1;
  }

  public static ArrayList<Integer> rangeArrayListMaker(int min, int max) throws FileNotFoundException {
    ArrayList<Integer> rangeToReturn = new ArrayList<Integer>();
    for(int i = min; i<=max; i++){
      rangeToReturn.add(i);
    }
    if(isToggledSetting("debug", true)){
      System.out.println("debug: range of input" + rangeToReturn);
    }
    return rangeToReturn;
  }

  public static void createFiles() throws IOException {
    new File("GameData.json").createNewFile();
    clearData();
  }
}

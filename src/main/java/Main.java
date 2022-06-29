import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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
  static JSONObject settings = new JSONObject();
  static int startupAmount;

  {
    try {
      startupAmount = getData().getInt("startupamount");
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
    String nameTest = "";
    for(int i = 0; i<args.length; i++){
      nameTest += args[i] + " ";
    }
    clearConsole();
    System.out.println("loading...");
    System.out.println("loading artifacts");
    content.artifacts.initializeContentArtifacts();
    System.out.println("loading characters");
    content.characters.initializeContentCharacters();
    System.out.println("loading weapons");
    content.weapons.initializeContentWeapons();
    System.out.println("loading battle areas");
    content.BattleAreas.initializeContentBattleAreas();
    System.out.println("loading locations");
    content.Locations.initializeContentLocations();
    System.out.println("loading game data");
    loadGame();
    Character equipedCharacter = null;
    if(getData().getInt("startupamount") == 0){
      Character player = null;
      if(args[0] != null){
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
      Weapon fists = new Weapon("fists", 1, "hand", 5, new Buff("attack"), new Verbs("punched", "slapped the absolute poop out of"), "Just your hands.");

      player.equipWeapon(fists, false);
      try{
        inventory.getCharacters().get(0);
      }
      catch (Exception e) {
        inventory.addCharacter(player);
      }

      timeout(2000, false);
      System.out.println("It's 10pm.");
      timeout(2000, false);
      System.out.println(equipedCharacter.getName() + " is at the convenience store buying instant noodles.");
      timeout(3500, false);
      System.out.println("He purchases " + (int)((Math.random() * ((Math.random() * 10) + 1)) + 1) + " packages of instant noodles and walks out the door.");
      timeout(3500, false);
      System.out.println("As he is walking down the road a pedestrian runs up to him, pulls out a knife and commands " + equipedCharacter.getName() + " to give him $" + (int)((Math.random() * ((Math.random() * 1000) + 1)) + 1));
      timeout(5000, false);
      System.out.println(equipedCharacter.getName() + " Prepares for battle\n");
      timeout(1000, false);

      startBattle(content.BattleAreas.getContentBattleAreas().get(0), equipedCharacter, false, false);
      timeout(1000, false);

      System.out.println("Or so " + equipedCharacter.getName() + " thought...");
      timeout(3000, true);

      System.out.println(equipedCharacter.getName() + " opened his eyes.\nAs he looks around he notices he is in someone's living room.\n\"How did I get here?\" he asked himself.\nSomeone comes into the room.\n\"Oh my, you're awake.\" she says.\n\"I'm surprised I was able to save you. You were injured pretty badly.\"");
      timeout(15000, false);
      System.out.println("\"Thankfully Chug-Jugs are really effective.\"");
      timeout(3500, true);
      System.out.println("\"Thank you.\" you reply. \"But I must return home. My sister might get worried.\"\n\"Such a good sibling you are.\" she says. \"As I see you're a very respectful young man I will give you this...\"");
      timeout(15000, true);
      gacha(true, 1);
      System.out.println("\"I can't thank you enough!\" " + equipedCharacter.getName() + " says. She smiles at you while you exit through the front door.");
      equipedCharacter.deEquipWeapon(false);
      equipedCharacter.equipWeapon(inventory.getWeapons().get(0), true);

      timeout(5000, true);

      System.out.println("Welcome to Gentry's Quest!");
      timeout(2500, true);
    }
    else {
      Character equippedCharacter = new Character(2, "john", 1, 1, 1, 1, 1, "likes penis");
      equippedCharacter.equipWeapon(new Weapon("dick destroyer", 5, "thing", 10, new Buff(""), new Verbs("fucked", "super fucked him"), "a weapon"), true);
    }
    startupAmount += 1;

    while(true){
      int input = getMainMenuInput("1.Travel\n2.Gacha\n3.Inventory\n4.Options\n5.Quit");
      //Locations
      if(input == 1){
        clearConsole();
        listLocations();
        int input2 = getMainMenuInput("where would you like to go?\n");
        Location location = content.Locations.getContentLocations().get(input2 - 1);
        clearConsole();
        location.listBattleAreas();
        input2 = getMainMenuInput("where in " + location.getName() + " would you like to go?");
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
        int input2 = getMainMenuInput("what would you like to pull?\n1.character\n2.Weapon");
        clearConsole();
        //character
        if (input2 == 1){
          System.out.println("how many characters would you like to pull?\n1 = $1000\nYou have: " + "$" + inventory.getMoney());
          int amount = getMainMenuInput("");
          if(inventory.checkMoney(amount * 1000)){
            inventory.spendMoney(amount * 1000);
            gacha(false, amount);
          }
        }
        //weapon
        else if(input2 == 2){
          clearConsole();
          int amount = getMainMenuInput("how many weapons would you like to pull?\n1 = $1000\nYou have: " + "$" + inventory.getMoney());
          if(inventory.checkMoney(amount * 1000)){
            inventory.spendMoney(amount * 1000);
            gacha(true, amount);
          }
        }
      }
      //inventory
      else if (input == 3) {
        boolean inventoryViewing = true;
        while(inventoryViewing){
          clearConsole();
          System.out.println("$" + inventory.getMoney());
          int input2 = getMainMenuInput("1.Characters\n2.Artifacts\n3.Weapons\n4.Back");
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
              int input3 = getMainMenuInput("View character\nor\n" + indexCounter + ". quit");
              clearConsole();
              if(input3 == inventory.getCharacters().size() + 1) characterViewing = false;
              else{
                Character character = inventory.getCharacters().get(input3 - 1);
                boolean characterInfoViewing = true;
                while(characterInfoViewing){
                  System.out.println(character);
                  int input4 = getMainMenuInput("1.level up\n2.manage weapon\n3.manage artifacts\n4.equip character\n5.back");
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
                              "\n$1 = 10xp\n0 to go back");
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
                      int input5 = getMainMenuInput(character.getName() + " currently has the weapon " + character.getWeapon() + " equipped\n1.swap weapon\n2.back");
                      clearConsole();
                      //swap weapon
                      int counter = 1;
                      if(input5 == 1){
                        //list weapons
                        for(Weapon weapon: inventory.getWeapons()){
                          System.out.println(counter + "." + weapon.getName() + " " + weapon.getFancyStars() + " lvl " + weapon.getLevel());
                          counter++;
                        }
                        int input6 = getMainMenuInput("select a weapon or " + counter + ".back");
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
                      int input5 = getMainMenuInput(6 + ". back");
                      clearConsole();
                      if(input5 != 6){
                        boolean artifactDetailViewing = true;
                        while(artifactDetailViewing){
                          if(character.getArtifactList()[input5 - 1] == null){
                            switchArtifact(character, input5 - 1, null);
                          }
                          else{
                            System.out.println(character.getArtifactList()[input5 - 1]);
                            int input6 = getMainMenuInput("1.switch artifact\n2.remove artifact\n3.upgrade artifact\n4.back");
                            clearConsole();
                            if(input6 == 1){
                              switchArtifact(character, input5 - 1, character.getArtifactList()[input5 - 1]);
                            }
                            else if(input6 == 2){
                              removeArtifact(character, input5 - 1);
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
                                int input7 = getMainMenuInput("which would you like to exchange?\n" + (inventory.getArtifacts().size() + 1) + ". back");
                                if(input7 != inventory.getArtifacts().size() + 1){
                                  upgradeArtifact(character.getArtifactList()[input5 - 1], inventory.getArtifacts().get(input7 - 1));
                                }
                                else upgradingArtifact = false;
                              }
                            }
                            else artifactDetailViewing = false;
                          }
                        }
                      }
                      else artifactViewing = false;
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
              int input3 = getMainMenuInput((inventory.getArtifacts().size() + 1) + ". back\nselect an artifact");
              if(input3 == inventory.getArtifacts().size() + 1) artifactViewing = false;
              else{
                Artifact artifact = inventory.getArtifacts().get(input3 - 1);
                clearConsole();
                boolean viewingArtifact = true;
                while(viewingArtifact){
                  int input4 = getMainMenuInput(artifact + "\n1.level up artifact\n2.back");
                  if(input4 == 1){
                    clearConsole();
                    boolean upgradingArtifact = true;
                    while(upgradingArtifact){
                      if(artifact.getLevel() == artifact.getStarRating() * 4){
                        System.out.println("Artifact is max level!");
                        upgradingArtifact = false;
                        break;
                      }
                      for(int i = 1; i < inventory.getArtifacts().size() + 1; i++){
                        Artifact artifact2 = inventory.getArtifacts().get(i - 1);
                        System.out.println(i + ". " + artifact2);
                      }
                      int input5 = getMainMenuInput("which would you like to exchange?\n" + (inventory.getArtifacts().size() + 1) + ". back");
                      if(input5 != inventory.getArtifacts().size() + 1){
                        upgradeArtifact(inventory.getArtifacts().get(input4 - 1), inventory.getArtifacts().get(input5 - 1));
                      }
                      else upgradingArtifact = false;
                    }
                  }
                  else viewingArtifact = false;
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
              int input3 = getMainMenuInput("select a weapon\nor\n0.back");
              clearConsole();
              if(input3 != 0){
                Weapon weapon = inventory.getWeapons().get(input3 -1);
                float percent = (weapon.getXp() * 100.0f) / weapon.getXpRequired();
                boolean leveling = true;
                while(leveling){
                  int input4 = getMainMenuInput("lvl " + weapon.getLevel() + "\nxp " + weapon.getXp() + "/" + weapon.getXpRequired() + " (" + percent + ")\n\nupgrade your weapon?\n$1 = 10xp\n0 to go back");
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
          int input2 = getMainMenuInput("3. exit");
          //debug toggle
          if(input2 == 1) toggleSetting("debug");
          //clear data
          else if(input2 == 2) clearData();
          else{
            clearConsole();
            inSettings = false;
          }
        }
      }
      else{
        saveGame();
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
      System.out.println("press enter to continue...");
      new Scanner(System.in).nextLine();
      clearConsole();
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
      System.out.println("\npress enter to continue...");
      new Scanner(System.in).nextLine();
      clearConsole();
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
      System.out.println("press enter to continue...");
      new Scanner(System.in).nextLine();
      clearConsole();
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
      System.out.println("\npress enter to continue...");
      new Scanner(System.in).nextLine();
      clearConsole();
    }
  }

  public static int getMainMenuInput(String text){
    Scanner input = new Scanner(System.in);
    System.out.println(text);
    return input.nextInt();
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

  public static void startBattle(BattleArea battleArea, Character character, boolean canRun, boolean results){
    ArrayList<Artifact> artifacts = new ArrayList<Artifact>();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
    artifacts = battleArea.initializeArtifacts(character.getDifficulty());
    enemies = battleArea.initializeEnemies(character.getDifficulty());

    boolean ran = false;
    String ending = "";
    String artifactList = "";

    for(Artifact artifact: artifacts){
      artifactList += artifact + "\n";
    }

    boolean alive = true;

    for(Enemy enemy: enemies){
      if(!alive) break;
      System.out.println(character.getName() + " encountered a " + enemy.getName() + "(lvl " + enemy.getLevel() + ")");
      boolean fighting = true;
      while(fighting){
        int input;
        if(canRun){
          input = getMainMenuInput("===========================================\n\t" +
                  enemy.getName() + "(lvl " + enemy.getLevel() + ")" +
                  "\n\t" + enemy.getHealth() +
                  "\n==========================================\n" +
                  character.getName() + " has " + character.getHealth() + " health" +
                  "\n1.attack\n2.run");
        }
        else{
          input = getMainMenuInput("===========================================\n\t" +
                  enemy.getName() + "(lvl " + enemy.getLevel() + ")" +
                  "\n\t" + enemy.getHealth() +
                  "\n==========================================\n" +
                  character.getName() + " has " + character.getHealth() + " health" +
                  "\n1.attack");
        }
        if(input == 1){
          clearConsole();
          if(character.attack(enemy)){
            inventory.addMoney(enemy.getLevel() * 2);
            character.addXp(enemy.getLevel() * 10);
            System.out.println("Killed " + enemy.getName() + ", received $" + (enemy.getLevel() * 2) + " and " + (enemy.getLevel() * 10) + "xp");
            fighting = false;
          }
          if(fighting){
            if(enemy.attack(character)){
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
      System.out.println("press enter to continue...");
      new Scanner(System.in).nextLine();
      clearConsole();
    }
  }

  public static void switchArtifact(Character character, int position, Artifact startingArtifact){
    int tracker = 1;
    for(Artifact artifact: inventory.getArtifacts()){
      System.out.println(tracker + ". " + artifact);
      tracker++;
    }
    int input = getMainMenuInput(tracker + ". back");
    if(input != tracker){
      if(startingArtifact != null){
        character.deEquipArtifact(position);
        inventory.addArtifact(startingArtifact);
      }
      character.equipArtifact(position, inventory.getArtifacts().get(input - 1));
      inventory.removeArtifact(inventory.getArtifacts().get(input - 1));
    }
  }

  public static void removeArtifact(Character character, int position){
    inventory.addArtifact(character.getArtifactList()[position - 1]);
    character.deEquipArtifact(position - 1);
  }

  public static void upgradeArtifact(Artifact artifact, Artifact artifactInExchange){
    artifact.addXp((artifactInExchange.getLevel() * 50) * artifactInExchange.getStarRating());
    inventory.removeArtifact(artifactInExchange);
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

    writeTo(String.valueOf(ClassLoader.getSystemClassLoader().getResourceAsStream("./GameData.json")), gameData.toString(4));
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
    String filePath = String.valueOf(ClassLoader.getSystemClassLoader().getResource("./GameData.json"));
    filePath = filePath.substring(6);
    File file = new File(filePath);

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
    Scanner in = new Scanner(new FileReader(String.valueOf(ClassLoader.getSystemClassLoader().getResourceAsStream("./defaults.json"))));

    StringBuilder sb = new StringBuilder();
    while(in.hasNext()) {
      sb.append(in.next());
    }
    in.close();
    String outString = sb.toString();

    writeTo(String.valueOf(ClassLoader.getSystemClassLoader().getResourceAsStream("./GameData.json")), new JSONObject(outString).toString(4));
    clearConsole();
    System.out.println("cleared data");
  }
}
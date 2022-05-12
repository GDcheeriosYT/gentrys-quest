import artifact.Artifact;
import character.Character;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import buff.Buff;
import weapon.Verbs;
import weapon.Weapon;
import data.Inventory;
import org.json.JSONObject;
class Main{
  static Inventory inventory = new Inventory();
  static ArrayList<Character> gachaCharacterObtained = new ArrayList<Character>();
  static ArrayList<Weapon> gachaWeapopnObtained = new ArrayList<Weapon>();
  public static void main(String[] args){

    //JSONObject gameData = new JSONObject();

    String name = new Scanner(System.in).nextLine();

    Character player = new Character(1, name, 1, 1, 1, 0.5, 1, "The guy");
    Weapon fists = new Weapon("fists", 1, "hand", 1, new Buff("critRate"), new Verbs("punched", "slapped the absolute poop out of"), "Just your hands.");

    player.equipWeapon(fists, false);
    inventory.addCharacter(player);

    inventory.setInfiniteMoney(true);

    System.out.println("Welcome to Gentry's Quest!");
    while(true){
      int input = getMainMenuInput("1.Travel\n2.Gacha\n3.Inventory\n4.Options\n5.Quit");
      //Locations
      if(input == 1){
        System.out.flush();
        System.out.println("1.United States\n2.Japan");
        //US actions
        if (input == 1){
          System.out.println("wip");
        }
      }
      //gacha
      else if (input == 2) {
        System.out.flush();
        int input2 = getMainMenuInput("1.Character\n2.Weapon");
        //character
        if (input2 == 1){
          System.out.flush();
          System.out.println("how many characters would you like to pull?\n1 = $1000\nYou have: " + "$" + inventory.getMoney());
          int amount = getMainMenuInput("");
          if(inventory.checkMoney(amount * 1000)){
            inventory.spendMoney(amount * 1000);
            gacha(false, amount);
          }
        }
        //weapon
        else if(input2 == 2){
          System.out.flush();
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
          System.out.flush();
          System.out.println("$" + inventory.getMoney());
          int input2 = getMainMenuInput("1.Characters\n2.Artifacts\n3.Weapons\n4.Back");
          //Characters
          if(input2 == 1){
            System.out.flush();
            int indexCounter = 1;
            for(Character character: inventory.getCharacters()){
              System.out.println(indexCounter + ". " + character.getName() + " " + character.getFancyStars() + " lvl " +  character.getLevel());
              indexCounter++;
            }
            int input3 = getMainMenuInput("View character\nor\n" + indexCounter + ". quit");
            try{
              System.out.println(inventory.getCharacters().get(input3 - 1));
            } catch (Exception e) {
              System.out.flush();
            }
            Character character = inventory.getCharacters().get(input3 - 1);
            boolean characterInfoViewing = true;
            int tracker = 0;
            while(characterInfoViewing){
              if(tracker != 0) System.out.println(character);
              int input4 = getMainMenuInput("1.level up\n2.manage weapon\n3.manage artifacts\n4.back");
              //leveling
              if(input4 == 1){
                float percent = (character.getXp() * 100.0f) / character.getXpRequired();
                boolean leveling = true;
                while(leveling){
                  int input5 = getMainMenuInput("lvl " + character.getLevel() + "\nxp " + character.getXp() + "/" + character.getXpRequired() + " (" + percent + ")\nupgrade your character?\n$1 = 10xp\n0 to go back");
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
                  int input5 = getMainMenuInput("1.swap weapon\n2.back");
                  //swap weapon
                  if(input5 == 1){
                    int counter = 1;
                    for(Weapon weapon: inventory.getWeapons()){
                      System.out.println(counter + "." + weapon.getName() + " " + weapon.getFancyStars() + " lvl " + weapon.getLevel());
                    }
                  }
                  //end loop
                  else if(input5 == 2) weaponViewing = false;
                }
              }
              //end loop
              else if(input4 == 4) characterInfoViewing = false;
            }
          }
          //artifacts
          else if(input2 == 2){

          }
          //weapons
          else if(input2 == 3){
            int counter = 1;
            for(Weapon weapon: inventory.getWeapons()){
              System.out.println(counter + "." + weapon.getName() + " " + weapon.getFancyStars() + " lvl " + weapon.getLevel());
              counter += 1;
            }
            int input3 = getMainMenuInput("select a weapon\nor\n0.back");
            boolean selectingWeapons = true;
            while(selectingWeapons){
              if(input3 != 0){
                try{
                  System.out.println(inventory.getWeapons().get(input3 - 1));
                } catch (Exception e) {
                  System.out.flush();
                }
                Weapon weapon = inventory.getWeapons().get(input3 -1);
                float percent = (weapon.getXp() * 100.0f) / weapon.getXpRequired();
                boolean leveling = true;
                while(leveling){
                  int input5 = getMainMenuInput("lvl " + weapon.getLevel() + "\nxp " + weapon.getXp() + "/" + weapon.getXpRequired() + " (" + percent + ")\nupgrade your weapon?\n$1 = 10xp\n0 to go back");
                  if(input5 == 0) leveling = false;
                  else{
                    if(inventory.checkMoney(input5)){
                      weapon.addXp(input5 * 10);
                      inventory.spendMoney(input5);
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
      else{
        break;
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
      System.out.println("You got:");
      for (var entry : counts.entrySet()) {
        System.out.printf("%s x %d%n", entry.getKey(), entry.getValue());
      }
      gachaWeapopnObtained.clear();
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
      System.out.println("You got:");
      for (var entry : counts.entrySet()) {
        System.out.printf("%s x %d%n", entry.getKey(), entry.getValue());
      }
      gachaCharacterObtained.clear();
    }
  }

  public static int getMainMenuInput(String text){
    Scanner input = new Scanner(System.in);
    System.out.println(text);
    return input.nextInt();
  }

  public void clearConsole(){
    for (int i = 0; i < 100; i++) {
      System.out.println("");
    }
  }
}
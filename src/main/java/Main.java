import character.Character;
import content.artifacts;
import content.characters;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import weapon.Verbs;
import weapon.Weapon;
import data.Inventory;
class Main{
  static Inventory inventory = new Inventory();
  static ArrayList<Character> gachaCharacterObtained = new ArrayList<Character>();
  static ArrayList<Weapon> gachaWeapopnObtained = new ArrayList<Weapon>();
  public static void main(String[] args){
    Character gentry = new Character(1, "Mr.Gentry", 1, 1, 1, 0.5, 1, "A computer science teacher");
    Weapon fists = new Weapon("fists", 1, "hand", 1, new Buff("critRate"), new Verbs("punched", "slapped the absolute poop out of"), "Just your hands.");

    gentry.equipWeapon(fists, false);
    inventory.addCharacter(gentry);

    inventory.addMoney(2000000);

    System.out.println("Welcome to Gentry's Quest!");
    while(true){
      int input = getMainMenuInput("1.Travel\n2.Gacha\n3.Inventory\n4.Options\n5.Quit");
      //Locations
      if(input == 1){
        System.out.println("1.United States\n2.Japan");
        //US actions
        if (input == 1){
          System.out.println("wip");
        }
      }
      //gacha
      else if (input == 2) {
        int input2 = getMainMenuInput("1.Character\n2.Weapon");
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
          int amount = getMainMenuInput("how many weapons would you like to pull?\n1 = $1000\nYou have: " + "$" + inventory.getMoney());
          if(inventory.checkMoney(amount * 1000)){
            inventory.spendMoney(amount * 1000);
            gacha(true, amount);
          }
        }
      }
      //inventory
      else if (input == 3) {
        System.out.println("$" + inventory.getMoney());
        int input2 = getMainMenuInput("1.Characters\n2.Artifacts\n3.Weapons\n4.Back");
        //Characters
        if(input2 == 1){
          int indexCounter = 1;
          for(Character character: inventory.getCharacters()){
            System.out.println(indexCounter + ". " + character.getName() + " " + character.getFancyStars() + " lvl " +  character.getLevel());
          }
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
}
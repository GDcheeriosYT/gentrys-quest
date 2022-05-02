import character.Character;
import content.artifacts;
import content.characters;
import java.util.ArrayList;
import java.util.Scanner;
import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import weapon.Verbs;
import weapon.Weapon;
import data.Inventory;
class Main{
  static Inventory inventory = new Inventory();
  public static void main(String[] args){
    Character gentry = new Character(1, "Mr.Gentry", 1, 1, 1, 0.5, 1, "A computer science teacher");
    Weapon fists = new Weapon("fists", 1, "hand", 1, new Buff("critRate"), new Verbs("punched", "slapped the absolute poop out of"), "Just your hands.");

    gentry.equipWeapon(fists, false);
    inventory.addCharacter(gentry);

    System.out.println("Welcome to Gentry's Quest!");

    System.out.println("1.Travel\n2.Gacha\n3.inventory\n4.option\n5.Quit");
    Scanner input = new Scanner(System.in);
    int x = 0;
    while(input.nextInt() != 5){
      int in = input.nextInt();
      if(x != 0){
        System.out.println("1.Travel\n2.Gacha\n3.inventory\n4.option\n5.Quit");
      }
      //Locations
      if(in == 1){
        System.out.println("1.United States\n2.Japan");
        //US actions
        if (in == 1){
          System.out.println("wip");
        }
      }
      else if (in == 2) {
        System.out.println("1.Character\n2.Weapon");
        if (input.nextInt() == 1){
          System.out.println("how many characters would you like to pull?\n1 = $1000");
          if(inventory.checkMoney(input.nextInt() * 1000)){
            inventory.spendMoney(input.nextInt() * 1000);
            gacha(false, input.nextInt());
          }
        }
        else if(input.nextInt() == 2){
          System.out.println("how many weapons would you like to pull?\n1 = $1000");
          if(inventory.checkMoney(input.nextInt() * 1000)){
            inventory.spendMoney(input.nextInt() * 1000);
            gacha(true, input.nextInt());
          }
        }
        else{
          System.out.println("");
        }
      }
      //inventory
      else if (in == 3) {
        System.out.println("$" + inventory.getMoney());
        System.out.println("1.Characters\n2.Artifacts\n3.Weapons\n4.Back");
      }
      else{
        System.out.println("BRO, PICK A VALID OPTION.");
      }
     }
  }




  public static void gacha(Boolean pullWeapon, int amount){
    if(pullWeapon){
      int weaponsPulled = 0;
      for(int i = 0; i < amount; i = weaponsPulled){
        int randomPullIteration = (int)((Math.random() * 10000) + 1);
        int randomPullWeapon = (int)((Math.random() * content.weapons.getContentWeapons().size()) + 1);
        Weapon weapon = content.weapons.getContentWeapons().get(randomPullWeapon - 1);
        String stars = "";
        for(int j = 0; j < weapon.getStarRating(); j++){
          stars += "*";
        }
        if(randomPullIteration <= 500){
          boolean inInventory = false;
          if (weapon.getStarRating() == 5){
            System.out.println("you got a " + weapon.getName() + " " + stars);
            for(Weapon weapon1: inventory.getWeapons()){
              if(weapon1.getName().equals(weapon.getName())){
                System.out.println("but you already have that weapon, giving xp and money");
                weapon1.levelUp(1);
                inventory.addMoney(50);
                inInventory = true;
              }
            }
            if(inInventory){
              weaponsPulled += 1;
            }
            else{
              inventory.addWeapon(weapon);
              weaponsPulled += 1;
            }
          }
        }
      }
    }
    else{
      int charactersPulled = 0;
      for(int i = 0; i < amount; i = charactersPulled){
        int randomPullCharacter = (int)((Math.random() * content.characters.getContentCharacters().size()) + 1);
        int randomPullIteration = (int)((Math.random() * 10000) + 1);
        Character character = content.characters.getContentCharacters().get(randomPullCharacter - 1);
        String stars = "";
        for(int j = 0; j < character.getStarRating(); j++){
          stars += "*";
        }
        if(randomPullIteration <= 500){
          boolean inInventory = false;
          if (character.getStarRating() == 5){
            System.out.println("you got a " + character.getName() + " " + stars);
            for(Character character2: inventory.getCharacters()){
              if(character2.getName().equals(character.getName())){
                System.out.println("but you already have that character, giving xp");
                character2.addXp(5000);
                inventory.addMoney(50);
                inInventory = true;
              }
            }
            if(inInventory == true){
              charactersPulled += 1;
            }
            else{
              inventory.addCharacter(character);
              charactersPulled += 1;
            }
          }
        }
        else if(randomPullIteration <= 1200){
          boolean inInventory = false;
          if (character.getStarRating() == 4){
            System.out.println("you got a " + character.getName() + " " + stars);
            for(Character character2: inventory.getCharacters()){
              if(character2.getName().equals(character.getName())){
                System.out.println("but you already have that character, giving xp");
                character2.addXp(4000);
                inventory.addMoney(40);
                inInventory = true;
              }
            }
            if(inInventory == true){
              charactersPulled += 1;
            }
            else{
              inventory.addCharacter(character);
              charactersPulled += 1;
            }
          }
        }
        else if(randomPullIteration <= 4500){
          boolean inInventory = false;
          if (character.getStarRating() == 3){
            System.out.println("you got a " + character.getName() + " " + stars);
            for(Character character2: inventory.getCharacters()){
              if(character2.getName().equals(character.getName())){
                System.out.println("but you already have that character, giving xp");
                character2.addXp(3000);
                inventory.addMoney(30);
                inInventory = true;
              }
            }
            if(inInventory == true){
              charactersPulled += 1;
            }
            else{
              inventory.addCharacter(character);
              charactersPulled += 1;
            }
          }
        }
        else if(randomPullIteration <= 7000){
          boolean inInventory = false;
          if (character.getStarRating() == 2){
            System.out.println("you got a " + character.getName() + " " + stars);
            for(Character character2: inventory.getCharacters()){
              if(character2.getName().equals(character.getName())){
                System.out.println("but you already have that character, giving xp");
                character2.addXp(2000);
                inventory.addMoney(20);
                inInventory = true;
              }
            }
            if(inInventory == true){
              charactersPulled += 1;
            }
            else{
              inventory.addCharacter(character);
              charactersPulled += 1;
            }
          }
        }
        else if(randomPullIteration <= 9000){
          boolean inInventory = false;
          if (character.getStarRating() == 1){
            System.out.println("you got a " + character.getName() + " " + stars);
            for(Character character2: inventory.getCharacters()){
              if(character2.getName().equals(character.getName())){
                System.out.println("but you already have that character, giving xp");
                character2.addXp(1000);
                inventory.addMoney(10);
                inInventory = true;
              }
            }
            if(inInventory == true){
              charactersPulled += 1;
            }
            else{
              inventory.addCharacter(character);
              charactersPulled += 1;
            }
          }
        }
      }
    }
  }

  public static void initializeArtifact(Artifact artifact){
    artifact.generateStarRating();
    for(int i = 0; i < artifact.getStarRating()*4; i++){
      artifact.levelUp();
    }
  }
}
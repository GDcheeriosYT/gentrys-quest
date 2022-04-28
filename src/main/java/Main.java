import character.Character;
import content.artifacts;
import content.characters;
import java.util.ArrayList;
import java.util.Scanner;
import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import weapon.Weapon;
import data.Inventory;
class Main{
  static Inventory inventory = new Inventory();
  public static void main(String[] args){

    System.out.println(content.characters.getContentCharacters());

    Character gentry = new Character(1, "Mr.Gentry", 1, 1, 1, 0.5, 1, "A computer science teacher");
    Weapon fists = new Weapon("fists", 1, "hand", 1, new Buff("critRate"));
    
    gentry.equipWeapon(fists, false);
    gentry.equipArtifact(new Artifact("Coding Laptop", 3, new Buff("")));
    inventory.addCharacter(gentry);

    System.out.println(gentry);

    System.out.println("Welcome to Gentry's Quest!");

    for(Character character: inventory.getCharacters()){
      System.out.println(character);
    }
     while(true){
       System.out.println("1.Travel\n2.Gacha\n3.inventory\n4.option\n5.Quit");
       Scanner input = new Scanner(System.in);
       //Locations
       if(input.nextInt() == 1){
         System.out.println("1.United States\n2.Japan");
         input = new Scanner(System.in);
         //US actions
           if (input.nextInt() == 1){

           }
       }

       else if (input.nextInt() == 2) {
         System.out.println("how many characters would you like to pull?\n1 = $1000");
         input = new Scanner(System.in);
         if(inventory.getMoney() > (input.nextInt() * 1000)){
          gacha();
         }
       }

       //inventory
       else if (input.nextInt() == 3) {
         System.out.println("$" + inventory.getMoney());
         System.out.println("1.Characters\n2.Artifacts\n3.Weapons\n4.Back");
         input = new Scanner(System.in);

       }

       else{
         break;
       }
     }
  }




  public static void gacha(Boolean pullWeapon, int amount){
    if(pullWeapon == true){
      int weaponsPulled = 0;
      for(int i = 0; i < amount; i = weaponsPulled){
        int randomPullIteration = (int)((Math.random() * 10000) + 1);
        int randomPullWeapon = (int)((Math.random() * content.weapons.getContentWeapons().size()) + 1);
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
}
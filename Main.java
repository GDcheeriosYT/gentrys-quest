import character.Character;
import java.util.ArrayList;
import artifact.Artifact;
import enemy.Enemy;
import weapon.Weapon;
class Main{
  public static void main(String[] args){
    ArrayList<Character> characters;
    ArrayList<Artifact> artifacts;
    ArrayList<Enemy> enemies;
    ArrayList<Weapon> weapons;

    

    gacha(false);
  }

  public static void gacha(Boolean pullWeapon){
    if(pullWeapon == true){
      //do something
    }
    else{
      System.out.println("uuhu");
      for(Character character: content.characters.getContentCharacters()){
        System.out.println(character);
      }
    }
  }
}
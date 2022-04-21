import character.Character;
import java.util.ArrayList;
import artifact.Artifact;
import enemy.Enemy;
import weapon.Weapon;
class Main{
  public static void main(String[] args){
    //private ArrayList<Character> characters;
    //private ArrayList<Artifact> artifacts;
    //private ArrayList<Enemy> enemies;
    //private ArrayList<Weapon> weapons;
    //new FileWriter("data\\data.json"));
    Character benji = new Character(5, "benji");
    //System.out.println(benji.toString());
    benji.addXp(1251);
    System.out.println(benji.toString());
  }
}
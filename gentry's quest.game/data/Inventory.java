package data;
import java.util.ArrayList;
import character.Character;
import artifact.Artifact;
import enemy.Enemy;
import weapon.Weapon;

public class Inventory {
  private ArrayList<Character> characters = new ArrayList<Character>();
  private ArrayList<Artifact> artifacts =  new ArrayList<Artifact>();
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
  private int money;

  public Inventory(){}
  
  public void addArtifact(Artifact artifact){
    artifacts.add(artifact);
  }

  public ArrayList<Artifact> getArtifacts(){
    return artifacts;
  }

  public void addCharacter(Character character){
    characters.add(character);
  }

  public void addMoney(int amount){
    money += amount;
  }
  
  public void spendMoney(int amount){
    if(money - amount < 0){
      System.out.println("not enough money...");
    }
    else{
      money -= amount;
    }
  }

  public ArrayList<Character> getCharacters(){
    return characters;
  }
}
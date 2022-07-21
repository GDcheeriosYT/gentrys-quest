package data;
import java.util.ArrayList;
import character.Character;
import artifact.Artifact;
import weapon.Weapon;

public class Inventory {
  private boolean infiniteMoney;
  private ArrayList<Character> characters = new ArrayList<Character>();
  private ArrayList<Artifact> artifacts =  new ArrayList<Artifact>();
  private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
  private int money;

  public Inventory(){}
  
  public void addArtifact(Artifact artifact){
    artifacts.add(artifact);
  }

  public void removeArtifact(Artifact artifact){
    artifacts.remove(artifact);
  }

  public void removeWeapon(Weapon weapon) { weapons.remove(weapon); }

  public ArrayList<Artifact> getArtifacts(){
    return artifacts;
  }

  public void addCharacter(Character character){
    characters.add(character);
  }

  public void addMoney(int amount){
    money += amount;
  }

  public boolean checkMoney(int amount){
    if(!infiniteMoney){
      if(money - amount < 0){
        System.out.println("Not enough money...");
        return false;
      }
      else{
        return true;
      }
    }
    else return true;
  }

  public void setInfiniteMoney(boolean infiniteMoney) {
    this.infiniteMoney = infiniteMoney;
  }

  public void spendMoney(int amount){
    if(!infiniteMoney)
      money -= amount;
  }

  public int getMoney() {
    if(infiniteMoney) return Integer.MAX_VALUE;
    return money;
  }

  public int getLongestCharacterNameLength(ArrayList<Character> characterList){
    int longest = 0;
    for(Character character: getCharacters()){
      if(character.getName().length() > longest) longest = character.getName().length();
    }
    return longest;
  }

  public ArrayList<Character> getCharacters(){
    return characters;
  }

  public void addWeapon(Weapon weapon){
    weapons.add(weapon);
  }

  public ArrayList<Weapon> getWeapons() {
    return weapons;
  }
}
package enemy;
import weapon.Weapon;
public class Enemy {
  private String name;
  private int level;
  private int health;
  private int attack;
  private int defense;
  private Weapon weapon;

  public Enemy(String name, int level, int health, int attack, int defense, Weapon weapon){
    this.name = name;
    this.level = level;
    this.health = health * (int)(level * 1.5);
    this.attack = attack * (int)(level * 0.9);
    this.defense = defense * (int)(level * 0.85);
    this.weapon = weapon;
  }

  public String toString(){
    return name + "\nlevel: " + level + "\nhealth: " + health + "\nattack: " + attack + "\ndefense: " + defense + "\nweapon: " + weapon;
  }
}
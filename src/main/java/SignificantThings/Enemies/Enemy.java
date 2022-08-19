package SignificantThings.Enemies;

import SignificantThings.SignificantThing;
import SignificantThings.Weapons.Weapon;
import SignificantThings.Characters.Character;
import ConsoleMethods.ConsoleMethods.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import static ConsoleMethods.ConsoleMethods.timeout;

public class Enemy extends SignificantThing {
  private final String description;
  private int health;
  private int attack;
  private int defense;
  private Weapon weapon;
  private int initialHealth;
  private int initialAttack;
  private int initialDefense;

  public Enemy(String name, int health, int attack, int defense, Weapon weapon, String description){
    super(name, description);
    this.health = health;
    this.attack = attack;
    this.defense = defense;
    this.weapon = weapon;
    this.description = description;
    this.initialHealth = health;
    this.initialAttack = attack;
    this.initialDefense = defense;
    super.setLevel(1);
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public int getHealth() {
    return health;
  }

  public boolean attack(Character character, boolean debug, boolean timeout) throws FileNotFoundException {
    double criticalChecker = (Math.random() * 100) + 1;
    int damage = attack;
    damage -= (Math.random() * character.getDefense()) + 1;
    if(debug) System.out.println("*debug*\nCriticalRatio(roll to stat): " + criticalChecker + "|20" + "\n*debug*");
    if(criticalChecker < 20){
      damage += damage * 0.4;
      System.out.println(super.getName() + " " + weapon.getVerb(true) + " " + character.getName() + " (" + damage + "dmg)");
    }
    else System.out.println(super.getName() + " " + weapon.getVerb(false) + " " + character.getName() + " (" + damage + "dmg)");
    if(timeout) timeout(2000, false);
    if(damage < 1) System.out.println(character.getName() + " dodged");
    else character.setHealth(character.getHealth() - damage);
    if(character.getHealth() < 1){
      System.out.println(character.getName() + " died...\n");
      if(timeout) timeout(2000, false);
      return true;
    }
    return false;
  }

  public int getAttack() {
    return attack;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public int getDefense() {
    return defense;
  }

 public String toString(){
    return "level: " + super.getLevel() + "\nhealth: " + health + "\nattack: " + attack + "\ndefense: " + defense;
  }
}
package enemy;
import character.Character;
import weapon.Weapon;

import java.util.Scanner;

public class Enemy {
  private final String name;
  private final String description;
  private int level = 1;
  private int health;
  private int attack;
  private int defense;
  private Weapon weapon;
  private int initialHealth;
  private int initialAttack;
  private int initialDefense;

  public Enemy(String name, int health, int attack, int defense, Weapon weapon, String description){
    this.name = name;
    this.health = health;
    this.attack = attack;
    this.defense = defense;
    this.weapon = weapon;
    this.description = description;
    this.initialHealth = health;
    this.initialAttack = attack;
    this.initialDefense = defense;
    setLevel(1);
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public String getName() {
    return name;
  }

  public int getLevel(){
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
    level = level - 1;
    int healthCalc = (int) (initialHealth + 2.5 * (level * 3 + ((level + 1 / 20) * 3)));
    int attackCalc = (int) (initialAttack + 0.5 * (level * 1.6 + ((level + 1 / 20) * 3)));
    int defenseCalc = (int) (initialDefense + 0.3 * (level * 1.3 + ((level + 1 / 20) * 3)));
    health = healthCalc;
    attack = attackCalc;
    defense = defenseCalc;
  }

  public int getHealth() {
    return health;
  }

  public boolean attack(Character character, boolean debug){
    double criticalChecker = (Math.random() * 100) + 1;
    int damage = attack;
    damage -= (Math.random() * character.getDefense()) + 1;
    if(debug) System.out.println("*debug*\nCriticalRatio(roll to stat): " + criticalChecker + "|20" + "\n*debug*");
    if(criticalChecker < 20){
      damage += damage * 0.4;
      System.out.println(name + " " + weapon.getVerb(true) + " " + character.getName() + " (" + damage + "dmg)");
    }
    else System.out.println(name + " " + weapon.getVerb(false) + " " + character.getName() + " (" + damage + "dmg)");
    timeout(2000, false);
    if(damage < 1) System.out.println(character.getName() + " dodged");
    else character.setHealth(character.getHealth() - damage);
    if(character.getHealth() < 1){
      System.out.println(character.getName() + " died...\n");
      timeout(2000, false);
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

  public String getDescription() {
    return description;
  }

  public static void clearConsole(){
    for (int i = 0; i < 100; i++) {
      System.out.println("");
    }
  }

  private String showStats(){
    return "name: " + name + "\nlevel:\t<-[K]" + level + "[L]->\nhealth:\t" + health + "\nattack:\t" + attack + "\ndefense:\t" + defense;
  }

  public void editStats(){
    label:
    while(true){
      String input = getStringInput(showStats());
      System.out.println(input);
      switch (input) {
        case "k":
          setLevel(level-1);
          break;
        case "l":
          setLevel(level+1);
          break;
        case "K":
          setLevel(level - 10);
          break;
        case "L":
          setLevel(level + 10);
          break;
        default:
          break label;
      }
    }
  }

  public String getStringInput(String outputText){
    System.out.println(outputText);
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public static void timeout(int time, boolean clearConole){
    try {
      Thread.sleep(time);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    if(clearConole) clearConsole();
  }

 public String toString(){
    return "level: " + level + "\nhealth: " + health + "\nattack: " + attack + "\ndefense: " + defense;
  }
}
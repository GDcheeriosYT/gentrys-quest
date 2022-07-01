package enemy;
import character.Character;
import weapon.Weapon;
public class Enemy {
  private final String name;
  private final String description;
  private int level = 1;
  private int health;
  private int attack;
  private int defense;
  private Weapon weapon;

  public Enemy(String name, int health, int attack, int defense, Weapon weapon, String description){
    this.name = name;
    this.health = health;
    this.attack = attack;
    this.defense = defense;
    this.weapon = weapon;
    this.description = description;
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
    this.health += (level * 3) + (level * 0.8);
    this.attack += (level * 0.3) + (level * 0.5);
    this.defense += (level * 0.15) + (level * 0.5);
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

  public static void timeout(int time, boolean clearConole){
    try {
      Thread.sleep(time);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    if(clearConole) clearConsole();
  }

  public String toString(){
    return name + "\nlevel: " + level + "\nhealth: " + health + "\nattack: " + attack + "\ndefense: " + defense + "\nweapon: " + weapon + "\n===============" + description + "\n===============";
  }
}
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
    this.health = health * (int)(level * 10.5);
    this.attack = attack * (int)(level * 0.9);
    this.defense = defense * (int)(level * 0.85);
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
    this.health = (int)(level * 10.5);
    this.attack = (int)(level * 0.9);
    this.defense = (int)(level * 0.85);
  }

  public int getHealth() {
    return health;
  }

  public boolean attack(Character character){
    System.out.println(name + " " + weapon.getVerb(false) + " " + character.getName());
    timeout(2000, false);
    character.setHealth(character.getHealth() - attack);
    if(character.getHealth() < 1){
      System.out.println("You died...\n");
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
package character;

import java.util.Objects;

import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import weapon.Weapon;


public class Character {
  private final int starRating;
  private final String name;
  private final String description;
  private int level = 1;
  private long xp = 0;
  private long xpRequired = 100;
  long previousXpRequired;
  private int health;
  private int defaultHealth;
  private int additionalHealth;
  private int attackDamage;
  private int defaultAttackDamage;
  private int additionalAttackDamage;
  private int defense;
  private int defaultDefense;
  private int additionalDefense;
  private double critRate;
  private double defaultCritRate;
  private double additionalCritRate;
  private int critDamage;
  private int defaultCritDamage;
  private int additionalCritDamage;
  private Weapon weapon;
  private Artifact[] artifacts = {null, null, null, null, null};
  private int difficulty = 1;

  public Character(int starRating, String name, int health, int attack, int defense, double critRate, int critDamage, String description){
    this.starRating = starRating;
    this.name = name;
    this.description = description;
    this.xpRequired = xpRequired * starRating;
    this.defaultHealth = (starRating * 10) + (health * 10);
    this.defaultAttackDamage = starRating + attack;
    this.defaultDefense = starRating + defense;
    this.defaultCritRate = starRating * 0.05 + critRate;
    this.defaultCritDamage = starRating;
    updateStats();
  }

  public void addXp(int amount){
    amount += xp;
    xp = 0;
    while(amount >= xpRequired){
      levelUp(1);
      amount -= previousXpRequired;
    }
    xp = amount;
  }

  private boolean hasSet(){
    boolean hasSet = false;
    String family = artifacts[0].getFamily();
    for(Artifact artifact: artifacts){
      if(artifact == null) return false;
      if(!artifact.getFamily().equals(family)){
        return false;
      }
    }
    return true;
  }

  public void levelUp(int amount){
    level += amount;
    for(int i = 0; i < amount; i++){
      //System.out.println(xpRequired);
      previousXpRequired = xpRequired;
      xpRequired += xpRequired * ((starRating * 0.004) + 0.045);
      defaultHealth += (level * 0.5) * (starRating * 0.9);
      defaultAttackDamage += (level * 0.5) * (starRating * 0.05);
      defaultDefense += (level * 0.5) * (starRating * 0.02);
      defaultCritRate += 0.2 + (starRating * 0.045);
      defaultCritDamage += (level * 0.5) * (starRating * 0.02);
    }
    int difficultyTracker = 1;
    for(int i = 0; i < level; i++){
      if(i%20==0) difficultyTracker++;
    }
    difficulty = difficultyTracker;

    updateStats();
  }

  public void updateStats(){
    health = defaultHealth + additionalHealth;
    attackDamage = defaultAttackDamage + additionalAttackDamage;
    defense = defaultDefense + additionalDefense;
  }

  public String getFancyStars(){
    String stars = "";
    for(int i = 0; i<starRating; i++){
      stars += "*";
    }
    return stars;
  }

  public long getXp() {
    return xp;
  }

  public long getXpRequired() {
    return xpRequired;
  }

  public void equipArtifact(int position, Artifact artifact){
    if(artifacts[position] == null){
      System.out.println("equipped " + artifact.getName());
      artifacts[position] = artifact;
      checkArtifacts();
    }
    else{
      System.out.println("couldn't equip " + artifact.getName());
    }
  }

  public void deEquipArtifact(int position){
    artifacts[position] = null;
    checkArtifacts();
  }

  public void checkArtifacts(){
    for(Artifact artifact2: artifacts){
      if(artifact2 != null){
        for(Buff attribute: artifact2.getAllBuffs()){
          int[] attributeInfo = attribute.getBuff();
          if(attributeInfo[0] == 1){
            additionalHealth += artifact2.getValue(attribute);
          }
          else if(attributeInfo[0] == 2){
            additionalAttackDamage += artifact2.getValue(attribute);
          }
          else if(attributeInfo[0] == 3){
            additionalDefense += artifact2.getValue(attribute);
          }
          else if(attributeInfo[0] == 4){
            if(defaultCritRate + additionalCritRate > 100){
              additionalCritRate = 100;
            }
            else{
              additionalCritRate += artifact2.getValue(attribute);
            }
          }
          else{
            additionalCritDamage += artifact2.getValue(attribute);
          }
        }
      }
    }
    if(hasSet()) {
      additionalHealth += starRating * 1.5;
      additionalAttackDamage += starRating * 1.5;
      additionalDefense += starRating * 1.5;
      additionalCritRate += starRating * 0.7;
      additionalCritDamage += starRating * 0.7;
    }
  }

  public void equipWeapon(Weapon weapon2, boolean output){
    if(output == true){
      System.out.println(name + " has succesfully equipped " + weapon2.getName());
    }
    weapon = weapon2;
  }

  public void deEquipWeapon(boolean output){
    weapon = null;
  }

  public Artifact[] getArtifactList(){
    return artifacts;
  }

  public String getName(){
    return name;
  }

  public int getStarRating(){
    return starRating;
  }

  public String getDescription(){
    return description;
  }

  public int getLevel() {
    return level;
  }

  public int getDifficulty() {
    return difficulty;
  }

  public int getHealth() {
    return health;
  }

  public Weapon getWeapon() {
    return weapon;
  }

  public void setHealth(int health) {
    this.health = health;
  }

  public boolean attack(Enemy enemy){
    String output = "You ";
    int damage = defaultAttackDamage;
    double criticalChecker = (Math.random() * 100) + 1;
    if(criticalChecker<critRate){
      output += weapon.getVerb(true) + " the " + enemy.getName();
      damage += critDamage;
    }
    else output += weapon.getVerb(false) + " the " + enemy.getName();
    if(damage < enemy.getDefense()){
      timeout(1000, true);
      System.out.println(enemy.getName() + " dodged...");
      return false;
    }
    else{
      timeout(1000, true);
      System.out.println(output);
    }

    enemy.setHealth(enemy.getHealth() - damage + enemy.getDefense());
    if(enemy.getHealth() < 0){
      timeout(1000, true);
      System.out.println(enemy.getName() + " is dead.");
      return true;
    }
    return false;
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
    String stars = "";
    //make fancier star display
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    String moreHealth = "";
    String moreAttackDamage = "";
    String moreDefense = "";
    String moreCritRate = "";
    String moreCritDamage = "";
    String weaponInfo = "";
    String artifactInfo = "";
    if(additionalHealth != 0){
      moreHealth = " + " + additionalHealth + " (" + (defaultHealth + additionalHealth) + ")";
    }

    if(additionalAttackDamage != 0){
      moreAttackDamage = " + " + additionalAttackDamage + " (" + (defaultAttackDamage + additionalAttackDamage) + ")";
    }

    if(additionalDefense != 0){
      moreDefense = " + " + additionalDefense + " (" + (defaultDefense + additionalDefense) + ")";
    }

    if(additionalCritRate != 0){
      moreCritRate = " + " + additionalCritRate + "%" + " (" + (defaultCritRate + additionalCritRate) + "%)";
      if(additionalCritRate + defaultCritRate > 100){
        moreCritRate = " + " + additionalCritRate + "%" + "(100.0%)";
      }
    }

    if(additionalCritDamage != 0){
      moreCritDamage = " + " + additionalCritDamage + " (" + (defaultCritDamage + additionalCritDamage) + ")";
    }

    weaponInfo += "\n--------weapon--------\n" + Objects.requireNonNullElse(weapon, "empty\n");

    for(Artifact artifact: artifacts){
      artifactInfo += "\n^^^^^^^^artifact^^^^^^^^\n";
      artifactInfo += Objects.requireNonNullElse(artifact, "empty\n");
    }

    float percent = (xp * 100.0f) / xpRequired;
    return name + " " + stars + "\nlevel " + level + "\nxp: " + xp + "/" + xpRequired + " " + (int)percent + "%" + "\nhealth: " + defaultHealth + moreHealth + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense + "\ncrit rate: " + defaultCritRate + "% " + moreCritRate + "\ncrit damage " + defaultCritDamage + moreCritDamage + weaponInfo + artifactInfo + "\n====================\n" + description + "\n====================";
  }
}



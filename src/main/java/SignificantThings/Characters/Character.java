package SignificantThings.Characters;

import SignificantThings.SignificantThing;
import SignificantThings.Weapons.*;
import SignificantThings.Artifacts.Artifact;
import SignificantThings.Enemies.Enemy;
import SignificantThings.Buffs.Buff;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Character extends SignificantThing {
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
  private int initialHealth;
  private int initialAttack;
  private int initialDefense;
  private double initialCritRate;
  private int initialCritDamage;

  //character creation constructor
  public Character(int starRating, String name, int health, int attack, int defense, double critRate, int critDamage, String description){
    super(starRating, name, description);
    initialHealth = health * 5;
    initialAttack = attack;
    initialDefense = defense;
    initialCritRate = critRate;
    initialCritDamage = critDamage;
    defaultHealth = (int) (2 * super.getLevel() + (super.getStarRating() * 10));
    defaultAttackDamage = (int) (1 * (super.getLevel() * 1.45) + (super.getStarRating() + 2));
    defaultDefense = (int) (0.5 + (super.getLevel() * 0.5) + (super.getStarRating() * 0.5));
    defaultCritRate = 7 + (super.getLevel() * 0.2) + (super.getStarRating() * 1);
    defaultCritDamage = (int) (0.5 + (super.getLevel() * 1.45) + (super.getStarRating() * 2));
    difficulty = (int)(1 + (super.getLevel() / 20));
    updateStats();
  }

  public Character(int starRating, String name, int health, int attack, int defense, double critRate, int critDamage, String description, int level, long xp, Weapon weapon, ArrayList<Artifact> artifacts){
    super(starRating, name, description);
    initialHealth = health * 5;
    initialAttack = attack;
    initialDefense = defense;
    initialCritRate = critRate;
    initialCritDamage = critDamage;
    defaultHealth = (int) (2 * super.getLevel() + (super.getStarRating() * 10));
    defaultAttackDamage = (int) (1 * (super.getLevel() * 1.45) + (super.getStarRating() + 2));
    defaultDefense = (int) (0.5 + (super.getLevel() * 0.5) + (super.getStarRating() * 0.5));
    defaultCritRate = 7 + (super.getLevel() * 0.2) + (super.getStarRating() * 1);
    defaultCritDamage = (int) (0.5 + (super.getLevel() * 1.45) + (super.getStarRating() * 2));
    difficulty = (int)(1 + (super.getLevel() / 20));
    setLevel(level);
    super.setXp(xp);
    if (weapon != null) equipWeapon(weapon, false);
    try{
      for(int i = 0; i<5; i++){
        if(artifacts.get(i) != null) equipArtifact(i, artifacts.get(i));
      }
    } catch (Exception e){}
    levelUp(0);
  }

  private boolean hasSet(){
    boolean hasSet = false;
    String family = "";
    if(artifacts[0]!=null){
      family = artifacts[0].getFamily();
    }
    else return false;
    for(Artifact artifact: artifacts){
      if(artifact == null) return false;
      if(!artifact.getFamily().equals(family)){
        return false;
      }
    }
    return true;
  }

  public void updateStats(){
    health = initialHealth + defaultHealth + additionalHealth;
    attackDamage = initialAttack + defaultAttackDamage + additionalAttackDamage;
    defense = initialDefense + defaultDefense + additionalDefense;
    critRate = initialCritRate + defaultCritRate + additionalCritRate;
    critDamage = initialCritDamage + defaultCritDamage + additionalCritDamage;
  }

  public String getFancyStars(){
    String stars = "";
    for(int i = 0; i<super.getStarRating(); i++){
      stars += "*";
    }
    return stars;
  }

  public void equipArtifact(int position, Artifact artifact){
    if(artifacts[position] == null){
      System.out.println("equipped " + artifact.getName());
      artifacts[position] = artifact;
      checkArtifacts(false, null);
    }
    else{
      System.out.println("couldn't equip " + artifact.getName());
    }
  }

  public void deEquipArtifact(int position){
    checkArtifacts(true, artifacts[position]);
    artifacts[position] = null;
  }

  private double getValue(Buff buff){
    double value = ((weapon.getAttribute().getBuff()[1] * 0.85) * (weapon.getStarRating() * 1.3));

    return value;
  }

  public void checkArtifacts(boolean removal, Artifact artifact){
    int averageStarRating = 0;
    int starRatingTotalSum = 0;
    int artifactCount = 0;
    for(Artifact artifact1: artifacts){
      if(artifact1 != null){
        artifactCount++;
        starRatingTotalSum += artifact1.getStarRating();
      }
    }
    try{
      averageStarRating = starRatingTotalSum / artifactCount;
    }
    catch (ArithmeticException ignored){}
    if(!removal){
      for(Artifact artifact2: artifacts){
        if(artifact2 != null){
          for(Buff attribute: artifact2.getAllBuffs()){
            int[] attributeInfo = attribute.getBuff();
            if(attributeInfo[0] == 1){
              if(attributeInfo[1] == 1) additionalHealth += percentValueGiver(artifact2.getStarRating(), defaultHealth, attribute);
              else additionalHealth += artifact2.getValue(attribute);
            }
            else if(attributeInfo[0] == 2){
              if(attributeInfo[1] == 1) additionalAttackDamage += percentValueGiver(artifact2.getStarRating(), defaultAttackDamage, attribute);
              else additionalAttackDamage += artifact2.getValue(attribute);
            }
            else if(attributeInfo[0] == 3){
              if(attributeInfo[1] == 1) additionalDefense += percentValueGiver(artifact2.getStarRating(), defaultDefense, attribute);
              else additionalDefense += artifact2.getValue(attribute);
            }
            else if(attributeInfo[0] == 4){
              if(attributeInfo[1] == 1) additionalCritRate += percentValueGiver(artifact2.getStarRating(), defaultCritRate, attribute);
              else additionalCritRate += artifact2.getValue(attribute);
            }
            else{
              if(attributeInfo[1] == 1) additionalCritDamage += percentValueGiver(artifact2.getStarRating(), defaultCritDamage, attribute);
              else additionalCritDamage += artifact2.getValue(attribute);
            }
          }
        }
      }
    }
    else {
      for (Buff attribute : artifact.getAllBuffs()) {
        int[] attributeInfo = attribute.getBuff();
        if (attributeInfo[0] == 1) {
          if (attributeInfo[1] == 1)
            additionalHealth -= percentValueGiver(artifact.getStarRating(), defaultHealth, attribute);
          else additionalHealth -= artifact.getValue(attribute);
        } else if (attributeInfo[0] == 2) {
          if (attributeInfo[1] == 1)
            additionalAttackDamage -= percentValueGiver(artifact.getStarRating(), defaultAttackDamage, attribute);
          else additionalAttackDamage -= artifact.getValue(attribute);
        } else if (attributeInfo[0] == 3) {
          if (attributeInfo[1] == 1)
            additionalDefense -= percentValueGiver(artifact.getStarRating(), defaultDefense, attribute);
          else additionalDefense -= artifact.getValue(attribute);
        } else if (attributeInfo[0] == 4) {
          if (attributeInfo[1] == 1)
            additionalCritRate -= percentValueGiver(artifact.getStarRating(), defaultCritRate, attribute);
          else additionalCritRate -= artifact.getValue(attribute);
        } else {
          if (attributeInfo[1] == 1)
            additionalCritDamage -= percentValueGiver(artifact.getStarRating(), defaultCritDamage, attribute);
          else additionalCritDamage -= artifact.getValue(attribute);
        }
      }
    }
    if(hasSet()){
      additionalHealth += averageStarRating;
      additionalAttackDamage += averageStarRating;
      additionalDefense += averageStarRating;
      additionalCritRate += averageStarRating;
      additionalCritDamage += averageStarRating;
    }
  }

  public void checkWeapon(){
    if(weapon != null){
      int[] attributeInfo = weapon.getAttribute().getBuff();
      if(attributeInfo[0] == 1){
        additionalHealth += getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 2){
        additionalAttackDamage += getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 3){
        additionalDefense += getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 4){
        additionalCritRate += getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 5){
        additionalCritDamage += getValue(weapon.getAttribute());
      }
    }
  }

  public void equipWeapon(Weapon weapon2, boolean output){
    if(output == true){
      System.out.println(super.getName() + " has succesfully equipped " + weapon2.getName());
    }
    weapon = weapon2;
    checkWeapon();
  }

  public void deEquipWeapon(boolean output){
    if(weapon!=null){
      int[] attributeInfo = weapon.getAttribute().getBuff();
      if(attributeInfo[0] == 1){
        additionalHealth -= getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 2){
        additionalAttackDamage -= getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 3){
        additionalDefense -= getValue(weapon.getAttribute());
      }
      else if(attributeInfo[0] == 4){
        additionalCritRate -= getValue(weapon.getAttribute());
      }
      else{
        additionalCritDamage -= getValue(weapon.getAttribute());
      }
      weapon = null;
      checkWeapon();
    }
  }

  public Artifact[] getArtifactList(){
    return artifacts;
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

  public boolean attack(Enemy enemy, boolean debug, boolean timeout){
    String output = super.getName() + " ";
    int damage = 0;
    if(weapon == null){
      System.out.println("You have no weapon...");
      if(timeout) timeout(2000, false);
      System.out.println("You're better off running away.");
      if(timeout) timeout(2000, false);
      return false;
    }
    else damage = (int)(attackDamage + weapon.getDamage() - (Math.random() * enemy.getDefense()) + 1);
    double criticalChecker = (Math.random() * 100) + 1;
    if(debug) System.out.println("*debug*\nCriticalRatio(roll to stat): " + criticalChecker + "|" + critRate + "\n*debug*");
    if(criticalChecker<critRate){
      output += weapon.getVerb(true) + " the " + enemy.getName() + " (" + (damage + critDamage) + "dmg)";
      damage += critDamage;
    }
    else output += weapon.getVerb(false) + " the " + enemy.getName() + " (" + damage + "dmg)";
    if(damage < enemy.getDefense()){
      System.out.println(enemy.getName() + " dodged...\n");
      if(timeout) timeout(2000, false);
      return false;
    }
    else{
      System.out.println(output + "\n");
      if(timeout) timeout(2000, false);
    }

    enemy.setHealth(enemy.getHealth() - damage);
    if(enemy.getHealth() < 1){
      System.out.println(enemy.getName() + " is dead.\n");
      if(timeout) timeout(2000, false);
      return true;
    }
    return false;
  }

  public static void clearConsole(){
    for (int i = 0; i < 100; i++) {
      System.out.println("");
    }
  }

  public double percentValueGiver(int starRating, double defaultAmount, Buff buff){
    return defaultAmount * ((2 * starRating) + (buff.getBuff()[2] * 2)) * 0.01;
  }

  public int getDefense() {
    return defense;
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
    for(int i = 0; i < super.getStarRating(); i++){
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

    float percent = (super.getXp() * 100.0f) / super.getXpRequired();
    return super.getName() + " " + stars + "\nlevel " + super.getLevel() + "\nxp: " + super.getXp() + "/" + super.getXpRequired() + " " + (int)percent + "%" + "\nhealth: " + defaultHealth + moreHealth + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense + "\ncrit rate: " + defaultCritRate + "% " + moreCritRate + "\ncrit damage " + defaultCritDamage + moreCritDamage + weaponInfo + artifactInfo + "\n====================\n" + super.getDescription() + "\n====================";
  }

  public JSONObject getData(){
    JSONObject data = new JSONObject();

    JSONObject stats = new JSONObject();
    JSONObject equips = new JSONObject();
    JSONObject experience = new JSONObject();
    JSONArray artifactData = new JSONArray();

    stats.put("health", initialHealth);
    stats.put("attack", initialAttack);
    stats.put("defense", initialDefense);
    stats.put("critRate", initialCritRate);
    stats.put("critDamage", initialCritDamage);

    try{
      equips.put("weapon", weapon.getData());
    }
    catch (NullPointerException e){}
    for(Artifact artifact: artifacts) if(artifact != null) artifactData.put(artifact.getData());
    equips.put("artifacts", artifactData);

    experience.put("xp", super.getXp());
    experience.put("level", super.getLevel());

    data.put("name", super.getName());
    data.put("description", super.getDescription());
    data.put("star rating", super.getStarRating());
    data.put("stats", stats);
    data.put("equips", equips);
    data.put("experience", experience);

    return data;
  }
}
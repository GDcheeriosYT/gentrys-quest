package character;

import java.util.Objects;
import java.util.Scanner;

import artifact.Artifact;
import buff.Buff;
import enemy.Enemy;
import org.json.JSONArray;
import org.json.JSONObject;
import weapon.Weapon;


public class Character {
  private int starRating;
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
  private boolean equipped = false;
  private int initialHealth;
  private int initialAttack;
  private int initialDefense;
  private double initialCritRate;
  private int initialCritDamage;

  //character creation constructor
  public Character(int starRating, String name, int health, int attack, int defense, double critRate, int critDamage, String description){
    this.starRating = starRating;
    this.name = name;
    this.description = description;
    initialHealth = health * 5;
    initialAttack = attack;
    initialDefense = defense;
    initialCritRate = critRate;
    initialCritDamage = critDamage;
    xpRequired = (level * 25) + (starRating * 75);
    defaultHealth = (int) (2 * level + (starRating * 10));
    defaultAttackDamage = (int) (1 * (level * 1.45) + (starRating + 2));
    defaultDefense = (int) (0.5 + (level * 0.5) + (starRating * 0.5));
    defaultCritRate = 7 + (level * 0.2) + (starRating * 1);
    defaultCritDamage = (int) (0.5 + (level * 1.45) + (starRating * 2));
    difficulty = (int)(1 + (level / 20));
    updateStats();
  }

  //character load constructor
  public Character(int starRating, String name, int health, int attack, int defense, double critRate, int critDamage, String description, int level, long xp, long xpRequired, int difficulty, Weapon weapon, Artifact[] artifacts){
    this.starRating = starRating;
    this.name = name;
    this.health = health;
    this.attackDamage = attack;
    this.defense = defense;
    this.critRate = critRate;
    this.critDamage = critDamage;
    this.description = description;
    this.level = level;
    this.xp = xp;
    this.xpRequired = xpRequired;
    this.difficulty = difficulty;
    equipWeapon(weapon, false);
    for(Artifact artifact: artifacts){
      if(artifact != null){
        for(int i = 0; i<4; i++){
          if(this.artifacts[i] == null) equipArtifact(i, artifact);
        }
      }
    }
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

  public void levelUp(int amount){
    level += amount;
    //System.out.println(xpRequired);
    previousXpRequired = xpRequired;
    xpRequired = (level * 25) + (starRating * 75);
    defaultHealth = (int) (2 * level + (starRating * 10));
    defaultAttackDamage = (int) (1 * (level * 1.45) + (starRating + 2));
    defaultDefense = (int) (0.5 + (level * 0.5) + (starRating * 0.5));
    defaultCritRate = 7 + (level * 0.2) + (starRating * 1);
    defaultCritDamage = (int) (0.5 + (level * 1.45) + (starRating * 2));
    difficulty = (int)(1 + (level / 20));

    additionalHealth = 0;
    additionalAttackDamage = 0;
    additionalDefense = 0;
    additionalCritRate = 0;
    additionalCritDamage = 0;

    checkWeapon();
    checkArtifacts(false, null);
    updateStats();
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
      System.out.println(name + " has succesfully equipped " + weapon2.getName());
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

  public boolean attack(Enemy enemy, boolean debug){
    String output = name + " ";
    int damage = 0;
    if(weapon == null){
      System.out.println("You have no weapon...");
      timeout(2000, false);
      System.out.println("You're better off running away.");
      timeout(2000, false);
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
      timeout(2000, false);
      return false;
    }
    else{
      System.out.println(output + "\n");
      timeout(2000, false);
    }

    enemy.setHealth(enemy.getHealth() - damage);
    if(enemy.getHealth() < 1){
      System.out.println(enemy.getName() + " is dead.\n");
      timeout(2000, false);
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
    return defaultAmount + (defaultAmount * ((2 * starRating) + (buff.getBuff()[2] * 1.5)));
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

  public boolean isEquipped() {
    return equipped;
  }

  public void setEquipped(boolean equipped) {
    this.equipped = equipped;
  }

  public JSONObject getData(){
    JSONObject data = new JSONObject();

    JSONObject stats = new JSONObject();
    JSONObject equips = new JSONObject();
    JSONObject experience = new JSONObject();
    JSONArray artifactData = new JSONArray();

    stats.put("health", health);
    stats.put("attack", attackDamage);
    stats.put("defense", defense);
    stats.put("critRate", critRate);
    stats.put("critDamage", critDamage);

    equips.put("weapon", weapon.getData());
    for(Artifact artifact: artifacts) if(artifact != null) artifactData.put(artifact.getData());
    equips.put("artifacts", artifactData);

    experience.put("xp", xp);
    experience.put("xp required", xpRequired);
    experience.put("previous xp required", previousXpRequired);
    experience.put("level", level);

    data.put("name", name);
    data.put("description", description);
    data.put("star rating", starRating);
    data.put("stats", stats);
    data.put("equips", equips);
    data.put("experience", experience);

    return data;
  }

  public String testingToString(){
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
    return name + " " + "<-[Q]" + stars + "[W]->" + "\nlevel\t<-[K]" + level + "[L]->\nxp: " + xp + "/" + xpRequired + " " + (int)percent + "%" + "\nhealth: " + defaultHealth + moreHealth + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense + "\ncrit rate: " + defaultCritRate + "% " + moreCritRate + "\ncrit damage " + defaultCritDamage + moreCritDamage + ".\n[E] edit weapon info" + weaponInfo + "\n[A] edit artifact info" + artifactInfo + "\n====================\n" + description + "\n====================";
  }

  public String getStringInput(String outputText){
    System.out.println(outputText);
    Scanner input = new Scanner(System.in);
    return input.nextLine();
  }

  public static int getMainMenuInput(String text){
    Scanner input = new Scanner(System.in);
    System.out.println(text);
    return input.nextInt();
  }

  public void editWeapon(){
    label:
    while(true){
      String input = getStringInput(weapon.editingToString());
      System.out.println(input);
      switch (input){
        case "q":
          weapon.setStarRating(weapon.getStarRating() - 1);
          break;
        case "w":
          weapon.setStarRating(weapon.getStarRating() + 1);
          break;
        case "Q":
          weapon.setStarRating(1);
          break;
        case "W":
          weapon.setStarRating(5);
          break;
        case "s":
          weapon.setBaseAttack(weapon.getBaseAttack() + 1);
          break;
        case "S":
          weapon.setBaseAttack(weapon.getBaseAttack() + 10);
          break;
        case "a":
          weapon.setBaseAttack(weapon.getBaseAttack() - 1);
          break;
        case "A":
          weapon.setBaseAttack(weapon.getBaseAttack() - 10);
          break;

        case "f":
          label1:
          while(true) {
            String input2 = getStringInput(weapon.attributeToStringEditing());
            switch (input2){
              case "q":
                String output1;
                int input3 = getMainMenuInput("1.health\n2.attack\n3.defense\n4.critRate\n5.critDamage");
                int input4 = getMainMenuInput("1.%\n2.integer");
                switch (input3) {
                  case 1 -> output1 = "health";
                  case 2 -> output1 = "attack";
                  case 3 -> output1 = "defense";
                  case 4 -> output1 = "critRate";
                  case 5 -> output1 = "critDamage";
                  default -> output1 = "";
                }
                weapon.setAttribute(output1, input4 == 1);
                break;

              case "a":
                weapon.getAttribute().levelUp(-1);
                break;
              case "A":
                weapon.getAttribute().levelUp(-10);
                break;
              case "s":
                weapon.getAttribute().levelUp(1);
                break;
              case "S":
                weapon.getAttribute().levelUp(10);
                break;

              default:
                break label1;
            }
          }
        default:
          break label;
      }
    }

  }

  public void editStats(){
    label:
    while(true){
      String input = getStringInput(testingToString());
      System.out.println(input);
      switch (input) {
        case "q":
          clearConsole();
          starRating -= 1;
          levelUp(0);
          break;
        case "w":
          clearConsole();
          starRating += 1;
          levelUp(0);
          break;
        case "Q":
          clearConsole();
          starRating = 1;
          levelUp(0);
          break;
        case "W":
          clearConsole();
          starRating = 5;
          levelUp(0);
          break;
        case "k":
          clearConsole();
          levelUp(-1);
          break;
        case "K":
          clearConsole();
          levelUp(-10);
          break;
        case "l":
          clearConsole();
          levelUp(1);
          break;
        case "L":
          clearConsole();
          levelUp(10);
          break;
        case "e":
          clearConsole();
          editWeapon();
          break;

        default:
          break label;
      }
    }
  }
}
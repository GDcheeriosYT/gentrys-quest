package character;
import java.util.ArrayList;

import artifact.Artifact;
import buff.Buff;
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
  }

  public void addXp(int amount){
    amount += xp;
    xp = 0;
    while(amount >= xpRequired){
      amount -= previousXpRequired;
      levelUp(1);
    }
    xp = amount;
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
    updateStats();
  }

  public void updateStats(){
    health = defaultHealth + additionalHealth;
    attackDamage = defaultAttackDamage + additionalAttackDamage;
    defense = defaultDefense + additionalDefense;
  }

  public void equipArtifact(Artifact artifact){
    boolean equipped = false;
    for(int i = 0; i < artifacts.length; i++){
      if(artifacts[i] == null){
        artifacts[i] = artifact;
        equipped = true;
        break;
      }
    }
    if(equipped == true){
      System.out.println(name + " succesfully equipped " + artifact.getName());
    }
    else{
      System.out.println(name + " couldn't equip" + artifact.getName());
    }
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
  }

  public void equipWeapon(Weapon weapon2, boolean output){
    if(output == true){
      System.out.println(name + " has succesfully equipped " + weapon2.getName());
    }
    weapon = weapon2;
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

    weaponInfo += "\n--------weapon--------\n" + weapon + "\n---------------------";

    for(Artifact artifact: artifacts){
      artifactInfo += "\n^^^^^^^^artifact^^^^^^^^\n";
      if(artifact != null){
        artifactInfo += artifact;
      }
      else{
        artifactInfo += "empty\n";
      }
    }

    float percent = (xp * 100.0f) / xpRequired;
    return name + " " + stars + "\nlevel " + level + "\nxp: " + xp + "/" + xpRequired + " " + (int)percent + "%" + "\nhealth: " + defaultHealth + moreHealth + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense + "\ncrit rate: " + defaultCritRate + "% " + moreCritRate + "\ncrit damage " + defaultCritDamage + moreCritDamage + weaponInfo + artifactInfo + "\n====================\n" + description + "\n====================";
  }
}
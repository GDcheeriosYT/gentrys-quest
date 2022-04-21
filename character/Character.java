package character;

public class Character {
  private int starRating;
  private String name;
  private int level = 1;
  private int xp = 0;
  private int xpRequired = 100;
  private int health;
  private int defaultHealth;
  private int additionalHealth;
  private int attackDamage;
  private int defaultAttackDamage;
  private int additionalAttackDamage;
  private int defense;
  private int defaultDefense;
  private int additionalDefense;
  
  public Character(int starRating, String name){
    this.starRating = starRating;
    this.name = name;
    this.xpRequired = xpRequired * starRating;
    this.defaultHealth = (starRating * 10);
    this.defaultAttackDamage = starRating;
    this.defaultDefense = starRating;
  }

  public void addXp(int amount){
    amount += xp;
    xp = 0;
    if(amount >= xpRequired){
      System.out.println("more " + level + " " + amount + " " + xpRequired);
      System.out.println(amount - xpRequired);
      amount -= xpRequired;
      levelUp(1);
      if (amount >= xpRequired){
        addXp(amount - xpRequired);
      }
      else{
        System.out.println("less " + xp + " " + amount + " " + xpRequired);
        xp += amount;
      }
    }
    else{
      System.out.println("less " + xp + " " + amount + " " + xpRequired);
      xp += amount;
    }
  }

  public void levelUp(int amount){
    level += amount;
    for(int i = 0; i < amount; i++){
      xpRequired += xpRequired * (starRating * 0.1);
    }
    defaultHealth += level * ((starRating * 10) * 0.5);
    defaultAttackDamage += level * (starRating * 0.5);
    defaultDefense += level * (starRating * 0.5);
    updateStats();
  }

  public void updateStats(){
    health = defaultHealth + additionalHealth;
    attackDamage = defaultAttackDamage + additionalAttackDamage;
    defense = defaultDefense + additionalDefense;
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
    if(additionalHealth != 0){
      moreHealth = " + " + additionalHealth;
    }

    if(additionalAttackDamage != 0){
      moreAttackDamage = " + " + additionalAttackDamage;
    }

    if(additionalDefense != 0){
      moreDefense = " + " + additionalDefense;
    }

    return name + " " + stars + "\nlevel " + level + "\nxp: " + xp + "/" + xpRequired + " " + ((xp/xpRequired)*100) + "%" + "\nhealth: " + defaultHealth + moreHealth  + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense;
  }
}
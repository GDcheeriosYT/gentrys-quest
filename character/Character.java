package character;

public class Character {
  private int starRating;
  private String name;
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
  
  public Character(int starRating, String name){
    this.starRating = starRating;
    this.name = name;
    this.xpRequired = xpRequired * starRating;
    this.defaultHealth = (starRating * 10);
    this.defaultAttackDamage = starRating;
    this.defaultDefense = (int)(starRating * 0.3);
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
      xpRequired += (xpRequired*0.2) * (starRating * 0.1);
      defaultHealth += level * (starRating * 0.3);
      defaultAttackDamage += level * (starRating * 0.05);
      defaultDefense += level * (starRating * 0.02);
    }
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
    float percent = (xp * 100.0f) / xpRequired;
    return name + " " + stars + "\nlevel " + level + "\nxp: " + xp + "/" + xpRequired + " " + (int)percent + "%" + "\nhealth: " + defaultHealth + moreHealth  + "\nattack: " + defaultAttackDamage + moreAttackDamage + "\ndefense: " + defaultDefense + moreDefense;
  }
}
package weapon;

import buff.Buff;

public class Weapon {
  private final String name;
  private final String weaponType;
  private int level = 1;
  private long xp = 0;
  private long xpRequired = 100;
  long previousXpRequired;
  private final int starRating;
  private int baseAttack;
  private final Buff attribute;
  private final Verbs verbs;
  private final String description;

  public Weapon(String name, int starRating, String weaponType, int baseAttack, Buff attribute, Verbs verbs, String description){
    this.name = name;
    this.starRating = starRating;
    this.weaponType = weaponType;
    this.baseAttack = baseAttack;
    this.attribute = attribute;
    this.verbs = verbs;
    this.description = description;
    this.xpRequired = xpRequired * starRating;
  }

  public void levelUp(int amount){
    level += amount;
    for(int i = 0; i < amount; i++){
      previousXpRequired = xpRequired;
      xpRequired += xpRequired * ((starRating * 0.004) + 0.045);
      baseAttack += (level*0.16) + (starRating);
      if(level % 5 == 0){
        attribute.levelUp(1);
      }
    }
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

  public int getLevel() {
    return level;
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

  public int getDamage(){
    return baseAttack;
  }

  public String getName(){
    return name;
  }

  public int getStarRating(){
    return starRating;
  }

  public String toString(){
    String stars = "";
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    return name + " " + stars + "\ntype: " + weaponType + "\nbase attack: " + baseAttack + "\nattribute " + attribute + " +" + ((attribute.getBuff()[1] * 0.85) * (starRating * 1.3));
  }
}
package weapon;

import buff.Buff;

public class Weapon {
  private final String name;
  private final String weaponType;
  private int level = 1;
  private final int starRating;
  private int baseAttack;
  private final Buff attribute;
  private final String[] verbs;
  private final String description;

  public Weapon(String name, int starRating, String weaponType, int baseAttack, Buff attribute, String[] verbs, String description){
    this.name = name;
    this.starRating = starRating;
    this.weaponType = weaponType;
    this.baseAttack = baseAttack;
    this.attribute = attribute;
    this.verbs = verbs;
    this.description = description;
  }

  public void levelUp(int amount){
    for(int i = 0; i < amount; i++){
      baseAttack += (level*0.85) * (starRating * 1.3);
      if(level % 5 == 0){
        attribute.levelUp(1);
      }
    }
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
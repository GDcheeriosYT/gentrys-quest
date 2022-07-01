package weapon;

import buff.Buff;
import org.json.JSONObject;

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

  public Weapon(String name, Verbs verbs){
    this.name = name;
    this.weaponType = "";
    this.verbs = verbs;
    this.starRating = 0;
    this.attribute = new Buff("");
    this.description = "";
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

  public String getVerb(boolean critical) {
    if(critical) return verbs.getCritical();
    else return verbs.getNormal();
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

  public Buff getAttribute() {
    return attribute;
  }

  public String toString(){
    String stars = "";
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    return name + " " + stars + "\ntype: " + weaponType + "\nbase attack: " + baseAttack + "\nattribute " + attribute + " +" + ((attribute.getBuff()[1] * 0.85) * (starRating * 1.3));
  }

  public JSONObject getData(){
    JSONObject data = new JSONObject();

    JSONObject stats = new JSONObject();
    JSONObject experience = new JSONObject();
    JSONObject verbs1 = new JSONObject();

    stats.put("attack", baseAttack);
    stats.put("buff", attribute.getBuff());

    experience.put("xp", xp);
    experience.put("xp required", xpRequired);
    experience.put("previous xp required", previousXpRequired);
    experience.put("level", level);

    verbs1.put("normal", getVerb(false));
    verbs1.put("critical", getVerb(true));

    data.put("name", name);
    data.put("description", description);
    data.put("weapon type", weaponType);
    data.put("star rating", starRating);
    data.put("verbs", verbs1);
    data.put("stats", stats);
    data.put("experience", experience);

    return data;
  }
}
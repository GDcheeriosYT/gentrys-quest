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
  private int starRating;
  private int baseAttack;
  private int initialBaseAttack;
  private Buff attribute;
  private final Verbs verbs;
  private final String description;

  public Weapon(String name, int starRating, String weaponType, int baseAttack, Buff attribute, Verbs verbs, String description){
    this.name = name;
    this.starRating = starRating;
    this.weaponType = weaponType;
    this.initialBaseAttack = baseAttack;
    this.attribute = attribute;
    this.verbs = verbs;
    this.description = description;
    this.xpRequired = (long) (((level * 75) + (level * 0.75)) + (starRating * 25));
    levelUp(0);
  }

  public Weapon(String name, Verbs verbs){
    this.name = name;
    this.weaponType = "";
    this.verbs = verbs;
    this.starRating = 0;
    this.attribute = new Buff("");
    this.description = "";
  }

  public Weapon(String name, int starRating, String weaponType, int baseAttack, Buff attribute, Verbs verbs, String description, int level, long xp){
    this.name = name;
    this.starRating = starRating;
    this.weaponType = weaponType;
    this.initialBaseAttack = baseAttack;
    this.attribute = attribute;
    this.verbs = verbs;
    this.description = description;
    this.xpRequired = xpRequired * starRating;
    this.level = level;
    this.xp = xp;
    previousXpRequired = (long) ((level - 1) * 25) + (starRating * 75);
    xpRequired = (long) (((level * 75) + (level * 0.75)) + (starRating * 25));
    levelUp(0);
  }

  public void levelUp(int amount){
    level += amount;
    previousXpRequired = xpRequired;
    xpRequired = (long) (((level * 75) + (level * 0.75)) + (starRating * 25));
    baseAttack = initialBaseAttack + (int) ((level*2.75) + (starRating * 1.25));
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

  public int getBaseAttack() {
    return baseAttack;
  }

  public void setBaseAttack(int baseAttack) {
    this.baseAttack = baseAttack;
  }

  public String toString(){
    String stars = "";
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    return name + " " + stars + "\ntype: " + weaponType + "\nbase attack: " + baseAttack + "\nattribute " + attribute + " +" + ((attribute.getBuff()[2] * 0.85) * (starRating * 1.3)) + (attribute.getBuff()[1] == 1 ? "%" : "");
  }

  public void setStarRating(int starRating) {
    this.starRating = starRating;
  }

  public String editingToString(){
    String stars = "";
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    return name + " <-[Q]" + stars + "[W]->\ntype: " + weaponType + "\nbase attack: <-[A]" + baseAttack + "[S]->\nattribute [F]change attribute " + attribute + " +" + ((attribute.getBuff()[2] * 0.85) * (starRating * 1.3)) + (attribute.getBuff()[1] == 1 ? "%" : "");
  }

  public String attributeToStringEditing(){
    String stars = "";
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    return name + " [Q]edit attribute type " + attribute + " <-[A]+" + ((attribute.getBuff()[2] * 0.85) * (starRating * 1.3)) + (attribute.getBuff()[1] == 1 ? "%" : "")+ "[S]->";
  }

  public void setAttribute(String buffAttribute, boolean percentageBoolean){
    attribute = new Buff(buffAttribute, percentageBoolean);
  }

  public JSONObject getData(){
    JSONObject data = new JSONObject();

    JSONObject stats = new JSONObject();
    JSONObject experience = new JSONObject();
    JSONObject verbs1 = new JSONObject();

    stats.put("attack", initialBaseAttack);
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
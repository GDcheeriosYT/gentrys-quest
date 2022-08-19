package SignificantThings.Weapons;

import SignificantThings.Buffs.Buff;
import SignificantThings.SignificantThing;
import org.json.JSONObject;

public class Weapon extends SignificantThing {
  private final String weaponType;
  private int level = 1;
  private long xp = 0;
  private long xpRequired = 100;
  private int baseAttack;
  private int initialBaseAttack;
  private Buff attribute;
  private final Verbs verbs;

  public Weapon(String name, int starRating, String weaponType, int baseAttack, Buff attribute, Verbs verbs, String description){
    super(starRating, name, description);
    this.weaponType = weaponType;
    this.initialBaseAttack = baseAttack;
    this.attribute = attribute;
    this.verbs = verbs;
    this.xpRequired = (long) (((level * 75) + (level * 0.75)) + (super.getStarRating() * 25));
  }

  public Weapon(String name, Verbs verbs){
    super(name);
    this.weaponType = "";
    this.verbs = verbs;
    this.attribute = new Buff("");
  }

  public Weapon(String name, int starRating, String weaponType, int baseAttack, Buff attribute, Verbs verbs, String description, int level, long xp){
    super(starRating, name, description);
    this.weaponType = weaponType;
    this.initialBaseAttack = baseAttack;
    this.attribute = attribute;
    this.verbs = verbs;
    this.xpRequired = xpRequired * starRating;
    this.level = level;
    this.xp = xp;
    super.setPreviousXpRequired((long) ((super.getLevel() - 1) * 25) + (super.getStarRating() * 75));
    super.setXpRequired((long) (((super.getLevel() * 75) + (super.getLevel() * 0.75)) + (super.getStarRating() * 25)));
  }

  public String getFancyStars(){
    String stars = "";
    for(int i = 0; i<super.getStarRating(); i++){
      stars += "*";
    }
    return stars;
  }

  public String getVerb(boolean critical) {
    if(critical) return verbs.getCritical();
    else return verbs.getNormal();
  }

  public int getDamage(){
    return baseAttack;
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
    for(int i = 0; i < super.getStarRating(); i++){
      stars += "*";
    }
    return super.getName() + " " + stars + "\ntype: " + weaponType + "\nbase attack: " + baseAttack + "\nattribute " + attribute + " +" + ((attribute.getBuff()[2] * 0.85) * (super.getStarRating() * 1.3)) + (attribute.getBuff()[1] == 1 ? "%" : "");
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
    experience.put("previous xp required", super.getPreviousXpRequired());
    experience.put("level", level);

    verbs1.put("normal", getVerb(false));
    verbs1.put("critical", getVerb(true));

    data.put("name", super.getName());
    data.put("description", super.getDescription());
    data.put("weapon type", weaponType);
    data.put("star rating", super.getStarRating());
    data.put("verbs", verbs1);
    data.put("stats", stats);
    data.put("experience", experience);

    return data;
  }
}
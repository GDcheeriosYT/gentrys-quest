package artifact;

import buff.Buff;
import org.json.JSONObject;

import java.util.ArrayList;

public class Artifact {
  private final String name;
  private int starRating;
  private int level = 1;
  int xp = 0;
  int xpRequired = 100;
  int previousXpRequired;
  private final Buff mainAttribute;
  private final String family;
  private ArrayList<Buff> attributes = new ArrayList<Buff>();

  public Artifact(String name, Buff mainAttribute, String family){
    this.name = name;
    this.mainAttribute = mainAttribute;
    this.family = family;
  }

  public Buff getMainAttribute() {
    return mainAttribute;
  }

  public void levelUp(){
    if(level < starRating * 4){
      timeout(1000, true);
      level += 1;
      System.out.println("Your artifact is now level " + level);
      previousXpRequired = xpRequired;
      xpRequired += xpRequired * ((starRating * 0.004) + 0.045);
      mainAttribute.levelUp(1);
      if(level % 4 == 0){
        ArrayList<Buff> rewriteList = new ArrayList<Buff>();
        Buff e = new Buff("");
        System.out.println("^" + e + "^");
        if(attributes.size() == 0){
          attributes.add(e);
        }
        for(Buff attribute: attributes){
          if(attribute == e){
            attribute.levelUp(1);
          }
          else{
            rewriteList.add(e);
          }
        }
        if(rewriteList.size() != 0){
          attributes.add(rewriteList.get(0));
        }
      }
    }
    else{
      timeout(1000, true);
      System.out.println("you have reached the max level of this artifact!");
    }
    timeout(3000, true);
  }
  public static void timeout(int time, boolean clearConole){
    try {
      Thread.sleep(time);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    if(clearConole) clearConsole();
  }

  public static void clearConsole(){
    for (int i = 0; i < 100; i++) {
      System.out.println("");
    }
  }

  public String getFancyStars(){
    String stars = "";
    for(int i = 0; i<starRating; i++){
      stars += "*";
    }
    return stars;
  }

  public void addXp(int amount){
    amount += xp;
    xp = 0;
    while(amount >= xpRequired){
      levelUp();
      amount -= previousXpRequired;
    }
    xp = amount;
  }

  public String getFamily() {
    return family;
  }

  public double getValue(Buff buff){
    double value;
    if(buff.getBuff()[0] == 4){
      value = 1 + (level * 0.05) + (starRating * 0.3) * (buff.getBuff()[1]);
    }
    else{
      value = 1 + (int)(level * 0.85) + (int)(starRating * 1.2) * (buff.getBuff()[1]);
    }
    return value;
  }

  public void generateStarRating(){
    starRating = (int)((Math.random() * (Math.random() * 5)) + 1);
  }

  public ArrayList<Buff> getAllBuffs(){
    ArrayList<Buff> buffs = new ArrayList<Buff>();
    buffs.add(mainAttribute);
    for(Buff attribute: attributes){
      buffs.add(attribute);
    }
    return buffs;
  }

  public void setStarRating(int starRating) {
    this.starRating = starRating;
    this.xpRequired = xpRequired * starRating;
  }

  public String getName(){
    return name;
  }

  public int getStarRating(){
    return starRating;
  }

  public int getLevel() {
    return level;
  }

  public String toString(){
    String stars = "";
    //make fancier star display
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    String strAttributes = "";
    for(int i = 0; i < attributes.size(); i++){
      strAttributes += attributes.get(i) + " " + getValue(attributes.get(i)) + "\n"; 
    }

    float percent;
    if(level != starRating*4) percent = (xp * 100.0f) / xpRequired;
    else percent = 100;

    return name + " " + stars + "\nappart of: " + family + " set" + "\n" + "level: " + level + " (" + percent + "%)\n" + mainAttribute + " " + getValue(mainAttribute) + "\n" + strAttributes;
  }

  public JSONObject getData(){
    JSONObject data = new JSONObject();

    JSONObject stats = new JSONObject();
    JSONObject experience = new JSONObject();

    stats.put("main attribute", mainAttribute.getBuff());
    stats.put("attributes", attributes);

    experience.put("xp", xp);
    experience.put("xp required", xpRequired);
    experience.put("previous xp required", previousXpRequired);
    experience.put("level", level);

    data.put("name", name);
    data.put("family", family);
    data.put("star rating", starRating);
    data.put("stats", stats);
    data.put("experience", experience);

    return data;
  }
}
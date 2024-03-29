package artifact;

import buff.Buff;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

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

  public Artifact(String name, Buff mainAttribute, String family) {
    this.name = name;
    this.mainAttribute = mainAttribute;
    this.family = family;
  }

  public Buff getMainAttribute() {
    return mainAttribute;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public void levelUp(Boolean output) {
    if (level < starRating * 4) {
      if (output) timeout(1000, true);
      level += 1;
      if (output) System.out.println("Your artifact is now level " + level);
      previousXpRequired = xpRequired;
      xpRequired += xpRequired * ((starRating * 0.004) + 0.045);
      mainAttribute.levelUp(1);
      if (level % 4 == 0) {
        Buff e = new Buff("");
        if (output) System.out.println("^ " + (e.getBuffString(e.getBuff()[0])) + (e.getBuff()[1] == 1 ? " %" : "") + " ^");
        addAttribute(e);
      }
    } else {
      if (output) {
        timeout(1000, true);
        System.out.println("you have reached the max level of this artifact!");
      }
    }
    if (output) timeout(3000, true);
  }

  public void addAttribute(Buff buff){
    if(attributes.size() == 0){
      attributes.add(buff);
    }
    else{
      boolean leveled = false;
      for(Buff attribute: attributes){
        if(isSameAttribute(buff, attribute, false)){
          attribute.levelUp(1);
          leveled = true;
        }
      }
      if(!leveled) attributes.add(buff);
    }
  }
  
  public static boolean isSameAttribute(Buff buff1, Buff buff2, boolean includeLevel){
    if(buff1.getBuff()[0] == buff2.getBuff()[0] && buff1.getBuff()[1] == buff2.getBuff()[1]){
      if(includeLevel){
        return buff1.getBuff()[2] == buff2.getBuff()[2];
      }
      return true;
    }
    else{
      return false;
    }
  }
  
  public static void timeout(int time, boolean clearConole) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException ex) {
      throw new RuntimeException(ex);
    }
    if (clearConole) clearConsole();
  }

  public static void clearConsole() {
    for (int i = 0; i < 100; i++) {
      System.out.println("");
    }
  }

  public String getFancyStars() {
    String stars = "";
    for (int i = 0; i < starRating; i++) {
      stars += "*";
    }
    return stars;
  }

  public void addXp(int amount) {
    amount += xp;
    xp = 0;
    while (amount >= xpRequired) {
      levelUp(true);
      amount -= previousXpRequired;
    }
    xp = amount;
  }

  public String getFamily() {
    return family;
  }



  public double getValue(Buff buff) {
    double value;
    if (buff.getBuff()[1] == 0) {
      if (buff.getBuff()[0] == 4) {
        value = 1 + (level * 0.05) + (starRating * 0.3) * (buff.getBuff()[2] * 0.5);
      } else {
        value = 1 + (!isSameAttribute(buff, mainAttribute, true) ? (level * 0.85) + (starRating * 1.2) * (buff.getBuff()[2]): (int) (starRating * 1.2) * (buff.getBuff()[2]));
      }
    } else {
      value = (2 * starRating) + (level * 1.5);
    }
    return value;
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

  public static String getStringBuff(int attributeID){
    return switch (attributeID) {
      case 1 -> "health";
      case 2 -> "attack";
      case 3 -> "defense";
      case 4 -> "critRate";
      case 5 -> "critDamage";
      default -> null;
    };
  }

  public String toString(){
    String stars = "";
    //make fancier star display
    for(int i = 0; i < starRating; i++){
      stars += "*";
    }
    String strAttributes = "";
    for(int i = 0; i < attributes.size(); i++){
      strAttributes += attributes.get(i) + " " + getValue(attributes.get(i)) + (attributes.get(i).getBuff()[1] == 1 ? "%" : "") + "\n";
    }

    float percent;
    if(level != starRating*4) percent = (xp * 100.0f) / xpRequired;
    else percent = 100;

    return name + " " + stars + "\nappart of: " + family + " set" + "\n" + "level: " + level + "/" + (starRating * 4) + " (" + percent + "%)\n" + mainAttribute + " " + getValue(mainAttribute) + " " + (mainAttribute.getBuff()[1] == 1 ? "%" : "") + "\n" + strAttributes;
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
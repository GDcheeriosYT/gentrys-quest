package SignificantThings.Artifacts;

import SignificantThings.SignificantThing;
import SignificantThings.Buffs.Buff;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

import static ConsoleMethods.ConsoleMethods.timeout;

public class Artifact extends SignificantThing {
  private final Buff mainAttribute;
  private final String family;
  private ArrayList<Buff> attributes = new ArrayList<Buff>();

  public Artifact(String name, Buff mainAttribute, String family) {
    super(name);
    this.mainAttribute = mainAttribute;
    this.family = family;
  }

  public Buff getMainAttribute() {
    return mainAttribute;
  }

  public void levelUp(Boolean output) throws FileNotFoundException {
    if (super.getLevel() < super.getStarRating() * 4) {
      if (output) timeout(1000, true);
      super.levelUp(1);
      if (output) System.out.println("Your artifact is now level " + super.getLevel());
      super.setPreviousXpRequired(super.getXpRequired());
      super.setXpRequired((long) (super.getXpRequired() + super.getXpRequired() * ((super.getStarRating() * 0.004) + 0.045)));
      mainAttribute.levelUp(1);
      if (super.getLevel() % 4 == 0) {
        Buff e = new Buff("");
        if (output) System.out.println("^ " + (e.getBuffString(e.getBuff()[0])) + " ^");
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

  public String getFancyStars() {
    String stars = "";
    for (int i = 0; i < super.getStarRating(); i++) {
      stars += "*";
    }
    return stars;
  }

  public void addXp(int amount) {
    amount += super.getXp();
    super.setXp(0);
    while (amount >= super.getXpRequired()) {
      super.levelUp(1);
      amount -= super.getPreviousXpRequired();
    }
    super.setXp(amount);
  }

  public String getFamily() {
    return family;
  }



  public double getValue(Buff buff) {
    double value;
    if (buff.getBuff()[1] == 0) {
      if (buff.getBuff()[0] == 4) {
        value = 1 + (super.getLevel() * 0.05) + (super.getStarRating() * 0.3) * (buff.getBuff()[2] * 0.5);
      } else {
        value = 1 + (!isSameAttribute(buff, mainAttribute, true) ? (super.getLevel() * 0.85) + (super.getStarRating() * 1.2) * (buff.getBuff()[2]): (int) (super.getStarRating() * 1.2) * (buff.getBuff()[2]));
      }
    } else {
      value = (2 * super.getStarRating()) + (super.getLevel() * 1.5);
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
    for(int i = 0; i < super.getStarRating(); i++){
      stars += "*";
    }
    String strAttributes = "";
    for(int i = 0; i < attributes.size(); i++){
      strAttributes += attributes.get(i) + " " + getValue(attributes.get(i)) + (attributes.get(i).getBuff()[1] == 1 ? "%" : "") + "\n";
    }

    float percent;
    if(super.getLevel() != super.getStarRating()*4) percent = (super.getXp() * 100.0f) / super.getXpRequired();
    else percent = 100;

    return super.getName() + " " + stars + "\nappart of: " + family + " set" + "\n" + "level: " + super.getLevel() + "/" + (super.getStarRating() * 4) + " (" + percent + "%)\n" + mainAttribute + " " + getValue(mainAttribute) + " " + (mainAttribute.getBuff()[1] == 1 ? "%" : "") + "\n" + strAttributes;
  }

  public JSONObject getData(){
    JSONObject data = new JSONObject();

    JSONObject stats = new JSONObject();
    JSONObject experience = new JSONObject();

    stats.put("main attribute", mainAttribute.getBuff());
    stats.put("attributes", attributes);

    experience.put("xp", super.getXp());
    experience.put("xp required", super.getXpRequired());
    experience.put("previous xp required", super.getPreviousXpRequired());
    experience.put("level", super.getLevel());

    data.put("name", super.getName());
    data.put("family", family);
    data.put("star rating", super.getStarRating());
    data.put("stats", stats);
    data.put("experience", experience);

    return data;
  }
}
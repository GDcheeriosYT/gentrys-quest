package artifact;

import java.util.ArrayList;

import buff.Buff;

public class Artifact {
  private final String name;
  private int starRating;
  private int level = 1;
  private final Buff mainAttribute;
  private final String family;
  private ArrayList<Buff> attributes = new ArrayList<Buff>();

  public Artifact(String name, Buff mainAttribute, String family){
    this.name = name;
    this.mainAttribute = mainAttribute;
    this.family = family;
  }

  public void levelUp(){
    if(level < starRating * 4){
      level += 1;
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
      System.out.println("you have reached the max level of this artifact!");
    }
  }

  public String getFamily() {
    return family;
  }

  public double getValue(Buff buff){
    double value;
    if(buff.getBuff()[0] == 4){
      value = (level * 0.05) + (starRating * 0.3) * (buff.getBuff()[1]);
    }
    else{
      value = (int)(level * 0.85) + (int)(starRating * 1.2) * (buff.getBuff()[1]);
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

  public String getName(){
    return name;
  }

  public int getStarRating(){
    return starRating;
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
    return name + " " + stars + "\n" + "level: " + level + "\n" + mainAttribute + " " +getValue(mainAttribute) + "\n" + strAttributes;
  }
}
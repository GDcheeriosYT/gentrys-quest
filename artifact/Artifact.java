package artifact;

import java.util.ArrayList;

public class Artifact {
  private String name;
  private int starRating;
  private int level = 1;
  private Buff mainAttribute;
  private ArrayList<Buff> attributes;

  public Artifact(String name, int starRating, Buff mainAttribute){
    this.name = name;
    this.starRating = starRating;
    this.mainAttribute = mainAttribute;
  }

  public void levelUp(){
    if(level < 20){
      level += 1;
      mainAttribute.levelUp(1);
      if(level % 4 == 0){
        Buff e = new Buff();
        for(Buff attribute: attributes){
          if(attribute.getBuff()[1] == e.getBuff()[1] && attribute.getBuff()[2] == e.getBuff()[2]){
            attribute.levelUp(1);
          }
          else{
            attributes.add(e);
          }
        }
      }
    }
  }

  private int getValue(Buff buff){
    int value = level * (buff.getBuff()[3]);
    return value;
  }
}
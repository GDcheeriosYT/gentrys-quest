package location;

import java.util.ArrayList;

public class Location {
  private String name;
  private ArrayList<BattleArea> battleAreas = new ArrayList<BattleArea>();

  public String toString(){
    return name + "\n" + battleAreas;
  }
}
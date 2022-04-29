package location;
import java.util.ArrayList;

public class Location {
  private final String name;
  private ArrayList<BattleArea> battleAreas = new ArrayList<BattleArea>();

  public Location(String name, ArrayList<BattleArea> battleAreas){
    this.name = name;
    this.battleAreas = battleAreas;
  }

  public String toString(){
    return name + "\n" + battleAreas;
  }
}
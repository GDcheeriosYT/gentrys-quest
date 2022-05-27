package location;
import java.util.ArrayList;

public class Location {
  private final String name;
  private ArrayList<BattleArea> battleAreas = new ArrayList<BattleArea>();

  public Location(String name, ArrayList<BattleArea> battleAreas){
    this.name = name;
    this.battleAreas = battleAreas;
  }

  public void listBattleAreas(){
    for(BattleArea battleArea: battleAreas){
      System.out.println(battleArea.getName());
    }
  }

  public String toString(){
    return name + battleAreas.size() + " battle areas\n";
  }
}
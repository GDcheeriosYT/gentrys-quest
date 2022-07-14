package location;
import java.util.ArrayList;

public class Location {
  private final String name;
  private ArrayList<BattleArea> battleAreas = new ArrayList<BattleArea>();

  public Location(String name, ArrayList<BattleArea> battleAreas){
    this.name = name;
    this.battleAreas = battleAreas;
  }

  public String getName() {
    return name;
  }

  public void listBattleAreas(){
    int i = 1;
    for(BattleArea battleArea: battleAreas){
      System.out.println(i + ". " + battleArea.getName());
      i++;
    }
  }

  public int battleAreaCount(){return battleAreas.size();}

  public BattleArea getBattleArea(int index){
    return battleAreas.get(index);
  }

  public String toString(){
    return name + " " + battleAreas.size() + " battle areas\n";
  }
}
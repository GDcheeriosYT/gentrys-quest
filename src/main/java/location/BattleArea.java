package location;
import java.util.ArrayList;
import enemy.Enemy;

public class BattleArea {
  private final String name;
  private final boolean isBossArea;
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  
  public BattleArea(String name, boolean isBossArea, ArrayList<Enemy> enemies){
    this.name = name;
    this.isBossArea = isBossArea;
    this.enemies = enemies;
  }
}

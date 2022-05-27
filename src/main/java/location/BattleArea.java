package location;
import java.util.ArrayList;

import artifact.Artifact;
import enemy.Enemy;

public class BattleArea {
  private final String name;
  private static boolean isBossArea;
  private static boolean isSingleBossArea;
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

  public BattleArea(String name, boolean isBossArea, boolean isSingleBossArea, ArrayList<Enemy> enemies, ArrayList<Artifact> artifacts){
    this.name = name;
    this.isBossArea = isBossArea;
    this.isSingleBossArea = isSingleBossArea;
    this.enemies = enemies;
    this.artifacts = artifacts;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Enemy> initializeEnemies(int difficulty){
    if(isBossArea) difficulty++;
    if(isSingleBossArea) return enemies;
    int enemyAmount = (int)(Math.random() *  (difficulty * 1.5) + 1);
    ArrayList<Enemy> enemiesToReturn = new ArrayList<Enemy>();
    for(int i = 0; i<enemyAmount; i++){
      enemiesToReturn.add(enemies.get((int) (Math.random()) * enemies.size()));
    }

    for(Enemy enemy: enemiesToReturn){
      enemy.setLevel((int)((20 * difficulty) - (Math.random() * 5) + 1));
    }

    return enemiesToReturn;
  }

  public ArrayList<Artifact> initializeArtifacts(int difficulty){
    if(isBossArea) difficulty++;
    ArrayList<Artifact> artifactsToReturn = new ArrayList<Artifact>();
    for(int i = 0; i<((Math.random() * difficulty*2) + 1);i++){
      Artifact artifact = artifacts.get((int) (Math.random()) * artifacts.size());
      int random = (int)(Math.random() * 1000) + 1;
      int rating = 0;
      if (random <= (difficulty*160)) rating = 1;
      if (random <= (difficulty*140)) rating = 2;
      if (random <= (difficulty*120)) rating = 3;
      if (random <= (difficulty*90)) rating = 4;
      if (random <= (difficulty*50)) rating = 5;

      artifact.setStarRating(rating);
      artifactsToReturn.add(artifact);
    }
    return artifactsToReturn;
  }

  public String toString(){
    return "";
  }
}

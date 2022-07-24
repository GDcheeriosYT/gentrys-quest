import java.util.ArrayList;

import artifact.Artifact;
import enemy.Enemy;

public class BattleArea {
  private final String name;
  private boolean isBossArea;
  private ArrayList<Enemy> enemies = new ArrayList<Enemy>();
  private ArrayList<Artifact> artifacts = new ArrayList<Artifact>();

  public BattleArea(String name, boolean isBossArea, ArrayList<Enemy> enemies, ArrayList<Artifact> artifacts){
    this.name = name;
    this.isBossArea = isBossArea;
    this.enemies = enemies;
    this.artifacts = artifacts;
  }

  public String getName() {
    return name;
  }

  public ArrayList<Artifact> getArtifacts() {
    return artifacts;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemies;
  }

  public ArrayList<Enemy> initializeEnemies(int difficulty, int maxLevel){
    if(isBossArea){
      difficulty++;
      System.out.println("!warning!\nthis area is very dangerous.");
    }
    int enemyAmount = (int)(Math.random() *  (difficulty * 1.5) + 1);
    ArrayList<Enemy> enemiesToReturn = new ArrayList<Enemy>();
    if(enemies.size() > 1){
      for(int i = 0; i<enemyAmount; i++){
        Enemy enemySelector = enemies.get((int) (Math.random() * enemies.size()));
        Enemy enemy = new Enemy(enemySelector.getName(), enemySelector.getHealth(), enemySelector.getAttack(), enemySelector.getDefense(), enemySelector.getWeapon(), enemySelector.getDescription());
        int levelToSet = (int)((20 * (difficulty - 1)) + (Math.random() * (maxLevel - (maxLevel * 0.5))) + (maxLevel * 0.5));
        enemy.setLevel(levelToSet == 0 ? 1 : levelToSet);
        enemiesToReturn.add(enemy);
      }
    }
    else{
      Enemy enemySelector = enemies.get((int) (Math.random() * enemies.size()));
      Enemy enemy = new Enemy(enemySelector.getName(), enemySelector.getHealth(), enemySelector.getAttack(), enemySelector.getDefense(), enemySelector.getWeapon(), enemySelector.getDescription());
      enemy.setLevel((int)((20 * (difficulty - 1)) + (Math.random() * 5) + 1));
      enemiesToReturn.add(enemy);
    }


    return enemiesToReturn;
  }

  public ArrayList<Artifact> initializeArtifacts(int difficulty){
    if(isBossArea) difficulty++;
    ArrayList<Artifact> artifactsToReturn = new ArrayList<Artifact>();
    int artifactToReturnAmount = (int)(Math.random() * difficulty*2)+1;
    for(int i = 0; i<artifactToReturnAmount; i++){
      Artifact artifactSelector = artifacts.get((int) (Math.random() * artifacts.size()));
      Artifact artifact = new Artifact(artifactSelector.getName(), artifactSelector.getMainAttribute(), artifactSelector.getFamily());
      int random = (int)(Math.random() * 1000) + 1;
      int rating = 1;
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

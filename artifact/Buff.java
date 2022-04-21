package artifact;

import java.util.Random;

public class Buff {
  private int level = 1;
  private int percentage;
  private boolean health;
  private boolean attack;
  private boolean defense;

  public Buff(){
    int random1 = (int)(Math.random() * 3 + 1);

    if(random1 == 1){
      health = true;
    }
    else if(random1 == 2){
      attack = true;
    }
    else if(random1 == 3){
      defense = true;
    }
  }

  public void levelUp(int amount){
    level += amount;
  }

  public int[] getBuff(){
    int[] values = new int[2];
    if(health == true){
      values[0] = 1;
      values[1] = level;
      return values;
    }
    else if(attack == true){
      values[0] = 2;
      values[1] = level;
      return values;
    }
    else{
      values[0] = 3;
      values[1] = level;
      return values;
    }
  }
  
}

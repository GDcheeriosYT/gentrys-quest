package artifact;

import java.util.Random;

public class Buff {
  private int level = 1;
  private int percentage;
  private boolean health;
  private boolean attack;
  private boolean defense;
  private boolean critRate;
  private boolean critDamage;

  public Buff(String mainAttribute){
    if(mainAttribute == "health"){
      health = true;
    }
    else if(mainAttribute == "attack"){
      attack = true;
    }
    else if(mainAttribute == "defense"){
      defense = true;
    }
    else if(mainAttribute == "critRate"){
      critRate = true;
    }
    else if(mainAttribute == "critDamage"){
      critDamage = true;
    }
    else{
      int random1 = (int)(Math.random() * 5 + 1);
  
      if(random1 == 1){
        health = true;
      }
      else if(random1 == 2){
        attack = true;
      }
      else if(random1 == 3){
        defense = true;
      }
      else if(random1 == 4){
        critRate = true;
      }
      else if(random1 == 5){
        critDamage = true;
      }
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
    else if (defense == true){
      values[0] = 3;
      values[1] = level;
      return values;
    }
    else if (critRate == true){
      values[0] = 4;
      values[1] = level;
      return values;
    }
    else{
      values[0] = 5;
      values[1] = level;
      return values;
    }
  }

  public String toString(){
    if(getBuff()[0] == 1){
      return "HP";
    }
    else if(getBuff()[0] == 2){
      return "Attack";
    }
    else if(getBuff()[0] == 3){
      return "Defense";
    }
    else if(getBuff()[0] == 4){
      return "Crit Rate";
    }
    else{
      return "Crit Damage";
    }
  }
}

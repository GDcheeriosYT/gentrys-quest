import java.util.Random;

public class Buff {
  private int level = 1;
  private boolean health;
  private boolean attack;
  private boolean defense;
  private boolean critRate;
  private boolean critDamage;
  private boolean percentage = false;

  public Buff(String mainAttribute){
    if((Math.random() * 100) + 1 < 50) percentage = true;
    switch (mainAttribute) {
      case "health" -> health = true;
      case "attack" -> attack = true;
      case "defense" -> defense = true;
      case "critRate" -> critRate = true;
      case "critDamage" -> critDamage = true;
      default -> {
        int random1 = (int) (Math.random() * 5 + 1);
        switch (random1) {
          case 1 -> health = true;
          case 2 -> attack = true;
          case 3 -> defense = true;
          case 4 -> critRate = true;
          case 5 -> critDamage = true;
        }
      }
    }
  }

  public Buff(String mainAttribute, boolean isPercentage){
    if(isPercentage) percentage = true;
    switch (mainAttribute) {
      case "health" -> health = true;
      case "attack" -> attack = true;
      case "defense" -> defense = true;
      case "critRate" -> critRate = true;
      case "critDamage" -> critDamage = true;
      default -> {
        int random1 = (int) (Math.random() * 5 + 1);
        switch (random1) {
          case 1 -> health = true;
          case 2 -> attack = true;
          case 3 -> defense = true;
          case 4 -> critRate = true;
          case 5 -> critDamage = true;
        }
      }
    }
  }

  public void levelUp(int amount){
    level += amount;
  }

  public int[] getBuff(){
    int[] values = new int[3];
    if(health){
      values[0] = 1;
      values[1] = percentage ? 1 : 0;
      values[2] = level;
      return values;
    }
    else if(attack){
      values[0] = 2;
      values[1] = percentage ? 1 : 0;
      values[2] = level;
      return values;
    }
    else if (defense){
      values[0] = 3;
      values[1] = percentage ? 1 : 0;
      values[2] = level;
      return values;
    }
    else if (critRate){
      values[0] = 4;
      values[1] = percentage ? 1 : 0;
      values[2] = level;
      return values;
    }
    else{
      values[0] = 5;
      values[1] = percentage ? 1 : 0;
      values[2] = level;
      return values;
    }
  }

  public String getBuffString(int number){
    return switch (number) {
      case 1 -> "health";
      case 2 -> "attack";
      case 3 -> "defense";
      case 4 -> "critRate";
      default -> "critDamage";
    };
  }

  public String toString(){
    return switch (getBuff()[0]) {
      case 1 -> "HP";
      case 2 -> "Attack";
      case 3 -> "Defense";
      case 4 -> "Crit Rate";
      default -> "Crit Damage";
    };
  }
}

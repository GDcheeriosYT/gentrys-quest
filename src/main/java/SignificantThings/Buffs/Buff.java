package SignificantThings.Buffs;

import SignificantThings.SignificantThing;
import org.json.JSONArray;

import java.util.ArrayList;

public class Buff extends SignificantThing {
  private boolean percentage = false;
  private boolean health = false;
  private boolean attack = false;
  private boolean defense = false;
  private boolean critRate = false;
  private boolean critDamage = false;

  public Buff(String mainAttribute) {
    super();
    if ((Math.random() * 100) + 1 < 50) percentage = true;
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

  public Buff(String mainAttribute, boolean isPercentage) {
    if (isPercentage) percentage = true;
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

  public int[] getBuff() {
    int[] values = new int[3];
    if (health) {
      values[0] = 1;
      values[1] = percentage ? 1 : 0;
      values[2] = super.getLevel();
      return values;
    } else if (attack) {
      values[0] = 2;
      values[1] = percentage ? 1 : 0;
      values[2] = super.getLevel();
      return values;
    } else if (defense) {
      values[0] = 3;
      values[1] = percentage ? 1 : 0;
      values[2] = super.getLevel();
      return values;
    } else if (critRate) {
      values[0] = 4;
      values[1] = percentage ? 1 : 0;
      values[2] = super.getLevel();
      return values;
    } else {
      values[0] = 5;
      values[1] = percentage ? 1 : 0;
      values[2] = super.getLevel();
      return values;
    }
  }

  public String getPercentString(){
    return percentage ? "%" : "";
  }

  public static String getBuffString(int number) {
    return switch (number) {
      case 1 -> "health";
      case 2 -> "attack";
      case 3 -> "defense";
      case 4 -> "critRate";
      default -> "critDamage";
    };
  }

  public static Buff createBuff(JSONArray buffArray){
    Buff buff = new Buff(getBuffString(buffArray.getInt(0)), buffArray.getInt(1) == 1 ? true : false);
    buff.levelUp(buffArray.getInt(2));
    return buff;
  }

  public String toString(){
    return switch (getBuff()[0]) {
      case 1 -> "HP" + getPercentString();
      case 2 -> "Attack" + getPercentString();
      case 3 -> "Defense" + getPercentString();
      case 4 -> "Crit Rate" + getPercentString();
      default -> "Crit Damage" + getPercentString();
    };
  }
}
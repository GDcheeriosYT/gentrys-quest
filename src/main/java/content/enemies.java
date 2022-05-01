package content;

import buff.Buff;
import enemy.Enemy;
import weapon.Verbs;
import weapon.Weapon;

import java.util.ArrayList;

public class enemies {
  private static ArrayList<Enemy> contentEnemies = new ArrayList<Enemy>();
  public enemies(){
      //empty constructor lol
  }

    public static ArrayList<Enemy> getContentEnemies() {
      Enemy evilGentry = new Enemy("Evil Gentry", 20, 1000, 30, 20, new Weapon("fists", 1, "hand", 1, new Buff("critRate"), new Verbs("punched", "slapped the absolute poop out of"), "Just your hands."), "The corrupted Mr.Gentry.");

      contentEnemies.add(evilGentry);

      return contentEnemies;
    }
}

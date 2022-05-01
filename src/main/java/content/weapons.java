package content;
import buff.Buff;
import weapon.Verbs;
import weapon.Weapon;
import java.util.ArrayList;

public class weapons {
  private static ArrayList<Weapon> contentWeapons = new ArrayList<Weapon>();

  public weapons(){
      //empty class
  }

    public static ArrayList<Weapon> getContentWeapons() {
      //1 star weapons
      Weapon sword = new Weapon("Sword", 1, "sword", 5, new Buff(""));
      Weapon bow = new Weapon("Bow", 1, "bow", 3, new Buff(""));
      Weapon spear = new Weapon("Spear", 1, "spear", 6, new Buff(""));
      Weapon hammer = new Weapon("Hammer", 1, "heavy", 8, new Buff(""));

      //2 star weapons

      //3 star weapons

      //4 star weapons

      //5 star weapons

      contentWeapons.add(sword);
      contentWeapons.add(bow);
      contentWeapons.add(spear);
      contentWeapons.add(hammer);
      
      return contentWeapons;
    }
}

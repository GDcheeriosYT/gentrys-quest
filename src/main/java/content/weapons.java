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
      Weapon sword = new Weapon("Sword", 1, "sword", 5, new Buff(""), new Verbs("swung at", "sliced up"), "Just a sword.");
      Weapon bow = new Weapon("Bow", 1, "bow", 3, new Buff(""), new Verbs("shot", "hit the bullseye of"), "Just a bow.");
      Weapon spear = new Weapon("Spear", 1, "spear", 6, new Buff(""), new Verbs("stabbed", "combo'd"), "Just a spear.");
      Weapon hammer = new Weapon("Hammer", 1, "heavy", 8, new Buff(""), new Verbs("smashed", "slammed"), "Just a hammer.");
      Weapon brodysBroadsword = new Weapon("Brody's Broadsword", 1, "Broadsword", 10, new Buff("attack"), new Verbs("swung", ""), "Brody the mighty warrior's broadsword.\nThe weapon was wielded for centuries by Brody himself, but was lost when the great calamity struck and he lost his life to the invading Waifu's."); //brody weapon

      //2 star weapons
      Weapon alecsRock = new Weapon("Alec's Rock", 2, "stone", 12, new Buff("attack"), new Verbs("hit", "immensely bashed"), "A small rock."); //alec weapon
      Weapon bone = new Weapon("Bone", 2, "sword", 3, new Buff(""), new Verbs("clobbered", "smushed"), "4 foot long dog bone"); //connor weapon

      //3 star weapons

      //4 star weapons
      Weapon dualSabers = new Weapon("Dual Sabers", 4, "Saber", 32, new Buff("critDamage"), new Verbs("slashed", "mollywhopped"), "The Dual Sabers, plucked from the depths of hell.");

      //5 star weapons
      Weapon cypireanScythe = new Weapon("Cypirean Scythe", 5, "Scythe", 26, new Buff(""), new Verbs("swung at", "did a sweeping 360 BayBlade scythe spin"), "Long black shafted with 死 imprinted on the blade."); //max weapon
      Weapon sharpThrowingCards = new Weapon("Sharp Throwing Cards", 5, "Playing Cards", 28, new Buff("critRate"), new Verbs("grazed", "sliced"), "Tactical throwing cards."); //spencer weapon
      Weapon masonator = new Weapon("Mason-ator", 5, "toothbrush", 30, new Buff("critDamage"), new Verbs("brushed", "squirted toothpaste"), "THE TOOTHBRUSH.\nThis toothbrush has been handed down for generations upon generations by the greek gods. You must be worthy of the brush to obtain this brush."); //mason weapon
      Weapon messerschmidter = new Weapon("The Messerschmidter", 5, "Sword", 40, new Buff("attack"), new Verbs("with your Messerschmidter tapped", "with your Messerschmidter spat on"), "A life size version of Brayden Messerschmidt but as a sword"); //benji weapon

      contentWeapons.add(sword);
      contentWeapons.add(bow);
      contentWeapons.add(spear);
      contentWeapons.add(hammer);
      contentWeapons.add(brodysBroadsword);
      contentWeapons.add(alecsRock);
      contentWeapons.add(bone);
      contentWeapons.add(cypireanScythe);
      contentWeapons.add(sharpThrowingCards);
      contentWeapons.add(masonator);
      contentWeapons.add(messerschmidter);

      return contentWeapons;
    }
}

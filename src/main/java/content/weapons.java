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

    public static void initializeContentWeapons() {
      //1 star weapons
      Weapon sword = new Weapon("Sword", 1, "Sword", 5, new Buff(""), new Verbs("swung at", "sliced up"), "Just a sword.");
      Weapon bow = new Weapon("Bow", 1, "Bow", 3, new Buff(""), new Verbs("shot", "hit the bullseye of"), "Just a bow.");
      Weapon spear = new Weapon("Spear", 1, "Spear", 6, new Buff(""), new Verbs("stabbed", "combo'd"), "Just a spear.");
      Weapon hammer = new Weapon("Hammer", 1, "Hammer", 8, new Buff(""), new Verbs("smashed", "slammed"), "Just a hammer.");
      Weapon brodysBroadsword = new Weapon("Brody's Broadsword", 1, "Broadsword", 10, new Buff("attack"), new Verbs("swung at", "whacked"), "Brody the mighty warrior's broadsword.\nThe weapon was wielded for centuries by Brody himself, but was lost when the great calamity struck and he lost his life to the invading Waifu's."); //brody weapon

      //2 star weapons
      Weapon alecsRock = new Weapon("Alec's Rock", 2, "Stone", 12, new Buff("attack"), new Verbs("hit", "immensely bashed"), "A small rock."); //alec weapon
      Weapon bone = new Weapon("Bone", 2, "Sword", 3, new Buff(""), new Verbs("clobbered", "smushed"), "4 foot long dog bone"); //connor weapon

      //3 star weapons
      Weapon homemadeStaffOfHoney = new Weapon("Homade Staff of Honey", 3, "Staff", 20, new Buff("critRate"), new Verbs("stabbed", "enlightened"), "A pointy staff of honey.");

      //4 star weapons
      Weapon dualSabers = new Weapon("Dual Sabers", 4, "Saber", 32, new Buff("critDamage"), new Verbs("slashed", "mollywhopped"), "The Dual Sabers, plucked from the depths of hell.");
      Weapon anubisBlade = new Weapon("Anubis Blade", 4, "Sword", 30, new Buff("attack"), new Verbs("quindavious bingleton smashed", "placed a goblin giant on the battlefield and it smacked the poop out of"), "Fried chicken muncher :)."); //joe nuts weapon
      Weapon nutBuster = new Weapon("Nut Buster", 4, "Mace", 25, new Buff("attack"), new Verbs("you busted", "busted their nuts"), "Perfect weapon to slide on your opps and bust their nuts."); //gavin weapon
      Weapon ichimonji = new Weapon("Ichimonji", 4, "Katana", 36, new Buff("attack"), new Verbs("sliced", "performed a 100 calibur slice on"), "A blade wielded by Zoro.\nIs sharp enough to slice the wind."); //nathan tenney weapon

      //5 star weapons
      Weapon cypireanScythe = new Weapon("Cypirean Scythe", 5, "Scythe", 38, new Buff(""), new Verbs("swung at", "did a sweeping 360 BayBlade scythe spin"), "Long black shaft with 死 imprinted on the blade."); //max weapon
      Weapon sharpThrowingCards = new Weapon("Sharp Throwing Cards", 5, "Playing Cards", 33, new Buff("critRate"), new Verbs("grazed", "sliced"), "Tactical throwing cards."); //spencer weapon
      Weapon masonator = new Weapon("Mason-ator", 5, "Toothbrush", 34, new Buff("critDamage"), new Verbs("brushed", "squirted toothpaste"), "THE TOOTHBRUSH.\nThis toothbrush has been handed down for generations upon generations by the greek gods. You must be worthy of the brush to obtain this brush."); //mason weapon
      Weapon messerschmidter = new Weapon("The Messerschmidter", 5, "Sword", 40, new Buff("attack"), new Verbs("with your Messerschmidter tapped", "with your Messerschmidter spat on"), "A life size version of Brayden Messerschmidt but as a sword"); //benji weapon
      Weapon coolWeapon = new Weapon("Cool Weapon", 5, "Sword", 43, new Buff("attack"), new Verbs("sweetified", "coolified"), "Super cool sword.\nOnly the coolest of the cool can wield this sword."); //lucas weapon
      Weapon masonKiller = new Weapon("Mason Killer", 5, "Dagger", 50, new Buff("attack"), new Verbs("penetrated", "hard penetrated"), "Two purple daggers."); //nolan anderson weapon
      Weapon knutsHammer = new Weapon("Knuts Hammer", 5, "Hammer", 50, new Buff("defense"), new Verbs("knut slammed", "atomically knut slammed"), "The Massive Knuts Hammer.\nWas picked up by the first great lord knuts and used to slay all the oppositions. lol ##"); //joe nuts weapon
      Weapon sirFarQuad = new Weapon("Sir Far Quad", 5, "Lance", 50, new Buff("critDamage"), new Verbs("impailed", "sliced"), "Long long sword."); //dylan weapon
      Weapon braydensOsuPen = new Weapon("Brayden's Osu Pen", 5, "Pen", 36, new Buff("critRate"), new Verbs("hit a circle on", "fc'ed the pattern on"), "Brayden's osu pen."); //brayden messerschmidt weapon
      Weapon quandaleDingle = new Weapon("Quandale Dingle", 5, "Person", 46, new Buff("attack"), new Verbs("quandale dingle'd", "dingle bombed"), "Long nose guy."); //bryce anderson weapon
      Weapon theBunnyGirl = new Weapon("The Bunny Girl", 5, "katana", 46, new Buff("critDamage"), new Verbs("tickled", "came inside"), "Born from the highest luxurious used bunny girl outfit fabric. A lustful weapon"); //hentai man weapon
      Weapon theMobyDick = new Weapon("The Moby Dick", 5, "adult toy", 50, new Buff(""), new Verbs("stuck", "inserted in"), "Toes? Na, it pulls hoes."); //also mason james weapon
      Weapon jasonsJunk = new Weapon("Jason's Junk", 5, "penis", 42, new Buff("health"), new Verbs("wanked", "cumblasted"), "it's Jason's. From Hy-vee. Estimated 14 inches.");

      contentWeapons.add(sword);
      contentWeapons.add(bow);
      contentWeapons.add(spear);
      contentWeapons.add(hammer);
      contentWeapons.add(brodysBroadsword);
      contentWeapons.add(alecsRock);
      contentWeapons.add(bone);
      contentWeapons.add(homemadeStaffOfHoney);
      contentWeapons.add(dualSabers);
      contentWeapons.add(anubisBlade);
      contentWeapons.add(nutBuster);
      contentWeapons.add(ichimonji);
      contentWeapons.add(cypireanScythe);
      contentWeapons.add(sharpThrowingCards);
      contentWeapons.add(masonator);
      contentWeapons.add(messerschmidter);
      contentWeapons.add(coolWeapon);
      contentWeapons.add(masonKiller);
      contentWeapons.add(knutsHammer);
      contentWeapons.add(sirFarQuad);
      contentWeapons.add(braydensOsuPen);
      contentWeapons.add(quandaleDingle);
      contentWeapons.add(theBunnyGirl);
      contentWeapons.add(theMobyDick);
      contentWeapons.add(jasonsJunk);
    }

  public static ArrayList<Weapon> getContentWeapons() {
    return contentWeapons;
  }

  public static Weapon getSpecificWeapon(String name){
    for(Weapon weapon: contentWeapons){
      if(weapon.getName() == name) return weapon;
    }
    return null;
  }
}

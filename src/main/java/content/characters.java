package content;
import java.util.ArrayList;

import artifact.Artifact;
import buff.Buff;
import character.Character;
import weapon.Verbs;
import weapon.Weapon;

public class characters {
  private static ArrayList<Character> contentCharacters = new ArrayList<Character>();

  public characters(){

  }
  
  public static void initializeContentCharacters(){
    //1 star characters
    Character brodyKrysa = new Character(1, "Brody Krysa", 0, 0, 0, 0.0, 0, "Mighty warrior. Known as wall climber.");
    Character davidNapier = new Character(1, "David Napier", 0, 0, 0, 0.0, 0, "6'4''.");
    Character matheuSliger = new Character(1, "Matheu Sliger", 0, 0, 0, 0.0, 0, "Big ninja.");

    //2 star characters
    Character gavinKnudsen = new Character(2, "Gavin Knudsen", 0, 1, 0, 0.0, 0, "description");
    Character ryanMartinez = new Character(2, "Ryan Martinez",  1, 0, 0, 0.0, 0, "an American former YouTuber known for his rant videos, vlogs, and for being a superfan of the American football team the Philadelphia Eagles.");
    Character connor = new Character(2, "Connor", 0, 0, 0, 1.0, 0, "A mutant shih tzu who loves cheese and belly rubs.");

    //3 star characters
    Character maxTramontina = new Character(3, "Max Tramontina", 1, 0, 0, 1.0, 0, "description");
    Character calebJallen = new Character(3, "Caleb Jallen", 1, 0, 0, 0.0, 1, "Dude I don't know.");
    Character charlieEddie = new Character(3, "Charlie Eddie", 0, 2, 0, 0.0, 0, "A lone hunter in the wild just trying to avenge his dead dog.");
    Character alecFerchen = new Character(3, "Alec Ferchen", 0, 2, 0, 0.0, 0, "Big sexy man.");
    Character dyllonForney = new Character(3, "Dyllon Forney", 0, 2, 0, 0, 0, "description");
    Character kolinCraig = new Character(3, "Kolin Craig", 1, 0, 1, 0.0, 0, "A super *tall* and handsome man.");
    Character connorFogarty = new Character(3, "Connor Fogarty", 0, 1, 1, 0.0, 0, "A mutant shih tzu who loves cheese and belly rubs.");
    Character asherLane = new Character(3, "Asher Lane", 0, 1, 0, 1.0, 0, "Pray to the goddess honey.");

    //4 star characters
    Character benji = new Character(4, "Benji", 0, 0, 0, 3.0, 0, "He was born a very lucky boy.");
    Character dylanTopic = new Character(4, "Dylan Topic", 3, 0, 0, 0.0, 0, "Cool uhm uhm uhm uhm uhm uhm oh tetris dude.");
    Character maxShrum = new Character(4, "Max Shrum", 2, 1, 0, 0.0, 0, "Minecraft player thing");
    Character joeNuts = new Character(4, "Joe Nuts", 0, 0, 3, 0.0, 0, "Massive man who like sausage.");
    Character hannaHardy = new Character(4, "Hanna Hardy", 1, 1, 0, 1.0, 0, "IDK");
    Character kellyKrysa = new Character(4, "Kelly Krysa", 1, 1, 1, 0.0, 0, "Apex predator.");
    
    //5 star characters
    Character gMoney = new Character(5, "Gmoney(Mr.Gentry)", 2, 2, 0, 0.0, 0, "Hyplains drifter.");
    Character braydenMesserschmidt = new Character(5, "Brayden Messerschmidt", 0, 4, 0, 0.0, 0, "An osu player who formed a contract with ppy(Dean Herbert) to not talk to females.");
    Character sethSmith = new Character(5, "Seth Smith", 1, 3, 0, 0.0, 0, "goat.");
    Character oliverStrauss = new Character(5, "Oliver Strauss", 0, 0, 0, 2.0, 2, "sneaky boi, has many females.");
    Character nathanTenney = new Character(5, "Nathan Tenney", 1, 1, 2, 0.0, 0, "description");
    Character nolanAnderson = new Character(5, "Nolan Anderson", 2, 2, 0, 0.0, 0, "Best character in the game.");
    Character grantArmstrong = new Character(5, "Grant Armstrong", 2, 1, 1, 0.0, 0, "");
    Character brianHightower = new Character(5, "Brian Hightower", 0, 2, 2, 0.0, 0, "description");
    Character masonJames = new Character(5, "Mason James", 0, 4, 0, 0.0, 0, "description");
    Character shrpe = new Character(5, "Shrpe", 1, 3, 0, 0.0, 0, "Child prodigy who also specializes in making cupcakes for the the once famous Philadelphia eagles superfan.");
    Character kevin = new Character(5, "Kevin", 0, 0, 0, 0.0, 4, "description");
    Character lucasSmidt = new Character(5, "Lucas Smidt", 1, 2, 1, 0.0, 0, "Totally rad guy who is super awesome.");
    Character danMesserschmidt = new Character(5, "Dan Messerschmidt", 1, 2, 1, 0.0, 0, "Very Ugly.");
    Character jackSmidt = new Character(5, "Jack Smidt", 0, 2, 1, 1.0, 0, "A dank wizard.");
    Character seanMcbroom = new Character(5, "Sean Mcbroom", 0, 2, 1, 0.0, 1, "Fart nuts");
    Character derekCorona = new Character(5, "Derek Corona", 2, 1, 0, 0.0, 1, "A mexican assassin who can't keep away from alcohol.");
    Character bryceAnderson = new Character(5, "Bryce Anderson", 2, 1, 0, 0.0, 1, "Tall guy.");
    Character spencerGeorge = new Character(5, "Spizzle", 0, 0, 0, 1.0, 3, "Gambling glass cannon.");
    Character willJohnson = new Character(5, "Wil \"longest\" johnson", 1, 2, 1, 0.0, 0, "He has teh longest johnson.");
    Character makDaddy = new Character(5, "Mak Daddy", 1, 2, 1, 0.0, 0, "4 foot 11 and 40 pounds but big strong.");
    Character kchuntMan = new Character(5, "KchuntMan", 0, 0, 0, 4.0, 0, "Stealth Mode.");
    Character hentaiMan = new Character(5, "Hentai Man", 0, 0, 0, 4.0, 0, "Weaponized hentai.");
    Character jayceeMaiers = new Character(5, "Jaycee Maiers", 2, 1, 1, 0.0, 0, "The booty builder.");
    Character jackBorland = new Character(5, "Jack Borland", 2, 0, 1, 0.0, 1, "The chicken wiener collector.");
    Character masonBorland = new Character(5, "Mason Borland", 0, 0, 0, 4.0, 0, "The beautiful nut haver.");
    Character charlieJohnson = new Character(5, "Charlie Johnson", 3, 0, 0, 1.0, 0, "He used to be skinny, but he ate too much kfc.");

    //6 star(divine) characters
    Character GDcheerios = new Character(6, "GDcheerios", 6, 6, 6, 6.0, 6, "The all mighty. He's Practically god...");
    Weapon quantumAPI = new Weapon("Quantum API", 6, "API", 100, new Buff("defense"), new Verbs("modified", "ripped apart and evaporized"), "The ability to change the atomic world around you.");
    GDcheerios.equipWeapon(quantumAPI, false);
    Artifact artifact0 = new Artifact("", new Buff("health"), "GDcheerios");
    artifact0.setStarRating(6);
    Artifact artifact1 = new Artifact("", new Buff("attack"), "GDcheerios");
    artifact1.setStarRating(6);
    Artifact artifact2 = new Artifact("", new Buff("defense"), "GDcheerios");
    artifact2.setStarRating(6);
    Artifact artifact3 = new Artifact("", new Buff("critRate"), "GDcheerios");
    artifact3.setStarRating(6);
    Artifact artifact4 = new Artifact("", new Buff("critDamage"), "GDcheerios");
    artifact4.setStarRating(6);
    GDcheerios.equipArtifact(0, artifact0);
    GDcheerios.equipArtifact(1, artifact1);
    GDcheerios.equipArtifact(2, artifact2);
    GDcheerios.equipArtifact(3, artifact3);
    GDcheerios.equipArtifact(4, artifact4);

    divinify(GDcheerios);


    //putting into the arraylist
    contentCharacters.add(brodyKrysa);
    contentCharacters.add(davidNapier);
    contentCharacters.add(gavinKnudsen);
    contentCharacters.add(matheuSliger);
    contentCharacters.add(ryanMartinez);
    contentCharacters.add(connor);
    contentCharacters.add(maxTramontina);
    contentCharacters.add(calebJallen);
    contentCharacters.add(charlieEddie);
    contentCharacters.add(alecFerchen);
    contentCharacters.add(dyllonForney);
    contentCharacters.add(kolinCraig);
    contentCharacters.add(connorFogarty);
    contentCharacters.add(asherLane);
    contentCharacters.add(benji);
    contentCharacters.add(dylanTopic);
    contentCharacters.add(maxShrum);
    contentCharacters.add(joeNuts);
    contentCharacters.add(hannaHardy);
    contentCharacters.add(kellyKrysa);
    contentCharacters.add(gMoney);
    contentCharacters.add(braydenMesserschmidt);
    contentCharacters.add(sethSmith);
    contentCharacters.add(oliverStrauss);
    contentCharacters.add(nathanTenney);
    contentCharacters.add(nolanAnderson);
    contentCharacters.add(grantArmstrong);
    contentCharacters.add(brianHightower);
    contentCharacters.add(masonJames);
    contentCharacters.add(shrpe);
    contentCharacters.add(kevin);
    contentCharacters.add(lucasSmidt);
    contentCharacters.add(danMesserschmidt);
    contentCharacters.add(jackSmidt);
    contentCharacters.add(seanMcbroom);
    contentCharacters.add(derekCorona);
    contentCharacters.add(bryceAnderson);
    contentCharacters.add(spencerGeorge);
    contentCharacters.add(willJohnson);
    contentCharacters.add(makDaddy);
    contentCharacters.add(kchuntMan);
    contentCharacters.add(hentaiMan);
    contentCharacters.add(jayceeMaiers);
    contentCharacters.add(jackBorland);
    contentCharacters.add(masonBorland);
    contentCharacters.add(charlieJohnson);
    contentCharacters.add(GDcheerios);
  }

  public static ArrayList<Character> getContentCharacters() {
    return contentCharacters;
  }

  public static Character getSpecificCharacter(String name){
    for(Character character: contentCharacters){
      if(character.getName().equals(name)) return character;
    }
    return null;
  }

  public static void divinify(Character character){
    character.getWeapon().levelUp(99);
    for(Artifact artifact: character.getArtifactList()){
      for(int i = 0; i<6*4; i++){
        artifact.levelUp(false);
    }
    }
    character.levelUp(99);
  }
}

import java.util.ArrayList;

public class characters {
  private static ArrayList<Character> contentCharacters = new ArrayList<Character>();

  public characters(){

  }

  public static void initializeContentCharacters(){
    //putting into the arraylist
    contentCharacters.add(brodyKrysa);
    contentCharacters.add(davidNapier);
    contentCharacters.add(gavinKnudsen);
    contentCharacters.add(matheuSliger);
    contentCharacters.add(grantWiseman);
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
    contentCharacters.add(oliviaMesserschmidt);
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
}
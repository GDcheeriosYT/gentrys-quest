package content;

import java.util.ArrayList;

import character.Character;

public class characters {
  private static ArrayList<Character> contentCharacters = new ArrayList<Character>();

  public characters(){

  }
  
  public static ArrayList<Character> getContentCharacters(){
    //1 star characters
    Character braydenMesserschmidt = new Character(1, "Brayden Messerschmidt");
    
    //2 star characters
    
    
    //3 star characters
    
    
    //4 star characters
    
    
    //5 star characters
    Character sethSmith = new Character(5, "Seth Smith");
    Character gentry = new Character(5, "Mr.Gentry");
    
    //putting into the arraylist
    contentCharacters.add(braydenMesserschmidt);
    contentCharacters.add(sethSmith);
    contentCharacters.add(gentry);
    return contentCharacters;
  }
}

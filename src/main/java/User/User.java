package User;

import Inventory.Inventory;
import SignificantThings.Characters.Character;

import java.util.ArrayList;
import java.lang.Math;

public class User {
    private String username;
    private int age;
    private int powerLevel;
    private Inventory inventory;

    public User(String username, int age, Inventory inventory){
        this.username = username;
        this.age = age;
        this.inventory = inventory;
        this.powerLevel = powerLevelGetter(inventory);
    }

    public int powerLevelGetter(Inventory inventory){
        ArrayList<Character> characters = insertionSort(inventory.getCharacters());
        int powerLevel = 0;
        for(Character character: characters){
            powerLevel += character.getLevel() * Math.pow(0.95, characters.indexOf(character));
        }
        return powerLevel;
    }

    public static ArrayList<Character> insertionSort(ArrayList<Character> array) {
        int i, j;
        for (i = 1; i < array.size(); i++) {
            Character tmp = array.get(i);
            j = i;
            while ((j > 0) && (array.get(j - 1).getLevel() > tmp.getLevel())) {
                array.set(j, array.get(j - 1));
                j--;
            }
            array.set(j, tmp);
        }
        return array;
    }
}

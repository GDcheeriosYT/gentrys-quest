package content;

import location.BattleArea;
import location.Location;
import java.util.ArrayList;
import java.util.List;

public class Locations {
    private static ArrayList<Location> contentLocations = new ArrayList<Location>();
    public Locations(){
        //empty constructor lol
    }

    private static BattleArea getBattleArea(String name){
        for(BattleArea battleArea: BattleAreas.getContentBattleAreas()){
            if(battleArea.getName().equals(name)) return battleArea;
        }
        return null;
    }

    public static void initializeContentLocations(){
        Location iowa = new Location(
            "Iowa",
            new ArrayList<BattleArea>(
                List.of(
                    getBattleArea("Brayden's House"),
                    getBattleArea("Unfinished Construction Site"),
                    getBattleArea("Down Town")
                )
            )
        );

        contentLocations.add(iowa);
    }

    public static ArrayList<Location> getContentLocations() {
        return contentLocations;
    }
}

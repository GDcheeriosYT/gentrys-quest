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

    public static ArrayList<Location> getContentLocations(){
        Location unitedStates = new Location(
            "United States",
            new ArrayList<BattleArea>(
                List.of(
                    getBattleArea("Brayden's House")
                )
            )
        );

        contentLocations.add(unitedStates);

        return contentLocations;
    }
}

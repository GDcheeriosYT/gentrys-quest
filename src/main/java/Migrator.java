import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

class Migrator{
    public static void migrator() throws FileNotFoundException {
        int step = 0;
        while(step<5){
            if(step == 0){
                System.out.println("migrating artifact sets");
                artifacts.initializeContentArtifacts();
                for(Artifact artifact: artifacts.getContentArtifacts()){
                    new File("content/ArtifactSets/" + artifact.getFamily());
                    JSONArray listOfArtifacts = new JSONArray();
                    for(Artifact artifact1: artifacts.getContentArtifacts()){
                        if(artifact1.getFamily().equals(artifact.getFamily())){
                            listOfArtifacts.put(artifact.getName());
                        }
                        Main.writeTo("content/ArtifactSets/" + artifact.getFamily(), listOfArtifacts.toString(4));
                    }
                }
            }
            if(step == 1){
                System.out.println("mirgrating battle areas");
                BattleAreas.initializeContentBattleAreas();
                for(BattleArea battleArea: BattleAreas.getContentBattleAreas()){
                    new File("content/ArtifactSets/" + battleArea.getFamily());
                    JSONArray listOfArtifacts = new JSONArray();    
                    for(BattleArea battleArea1: BattleAreas.getContentBattleAreas()){
                        if(battleArea1.getFamily().equals(battleArea.getFamily())){
                            listOfArtifacts.put(battleArea.getName());
                        }
                        Main.writeTo("content/ArtifactSets/" + artifact.getFamily(), listOfArtifacts.toString(4));
                    }
                }
            }
            }
            step++;
        }
    }
}
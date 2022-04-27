package content;
import java.util.ArrayList;
import artifact.Artifact;
import buff.Buff;

public class artifacts {
  private static ArrayList<Artifact> contentArtifacts = new ArrayList<Artifact>();

  public artifacts(){
    
  }

  public static ArrayList<Artifact> getContentArtifacts(){
    //1 star artifacts
    Artifact sock = new Artifact("sock", 1, new Buff("defense"));

    //2 star artifacts
    Artifact rubiksCube = new Artifact("Rubik's Cube", 2, new Buff("critRate"));

    //3 star artifacts


    //4 star artifacts


    //5 star artifacts


    contentArtifacts.add(sock);
    contentArtifacts.add(rubiksCube);

    return contentArtifacts;
  }
}

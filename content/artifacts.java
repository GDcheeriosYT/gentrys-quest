package content;
import java.util.ArrayList;
import artifact.Artifact;
import artifact.Buff;

public class artifacts {
  private static ArrayList<Artifact> contentArtifacts = new ArrayList<Artifact>();

  public artifacts(){
    
  }

  public static ArrayList<Artifact> getContentArtifacts(){
    //1 star artifacts
    Artifact sock = new Artifact("sock", 1, new Buff("defense"));

    //2 star artifacts


    //3 star artifacts


    //4 star artifacts


    //5 star artifacts


    contentArtifacts.add(sock);

    return contentArtifacts;
  }
}

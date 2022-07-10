package inventory;

import artifact.Artifact;
import character.Character;
import data.Inventory;
import org.junit.jupiter.api.Test;
import weapon.Weapon;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

public class InventoryTest {
    private boolean infiniteMoney;
    private Artifact artifact = mock(Artifact.class);
    private Character character = mock(Character.class);
    private Weapon weapon = mock(Weapon.class);
    private Inventory inventory = new Inventory();


    @Test
    void defaultConstructorTest() {
        assertThat(inventory).isNotNull();
    }

    @Test
    void addArtifactTest() {
        inventory.addArtifact(artifact);
        assertThat(inventory.getArtifacts()).containsExactly(artifact);
    }

    @Test
    void getArtifactTest() {
        assertThat(inventory.getArtifacts()).isEmpty();
    }

    @Test
    void removeArtifactTest() {
        inventory.addArtifact(artifact);
        inventory.removeArtifact(artifact);
        assertThat(inventory.getArtifacts()).isEmpty();
    }


    @Test
    void addCharacterTest() {
        inventory.addCharacter(character);
        assertThat(inventory.getCharacters()).containsExactly(character);
    }

    @Test
    void getCharacterTest() {
        assertThat(inventory.getCharacters()).isEmpty();
    }

}

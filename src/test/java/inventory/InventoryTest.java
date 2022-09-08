package inventory;

import artifact.Artifact;
import character.Character;
import data.Inventory;
import org.junit.jupiter.api.Test;
import weapon.Weapon;

import java.util.ArrayList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    void getCharactersTest() {
        assertThat(inventory.getCharacters()).isEmpty();
    }

    @Test
    void addWeaponTest() {
        inventory.addWeapon(weapon);
        assertThat(inventory.getWeapons()).containsExactly(weapon);
    }

    @Test
    void getWeaponsTest() {
        assertThat(inventory.getWeapons()).isEmpty();
    }
    @Test
    void addMoneyTest() {
        inventory.addMoney(50);
        assertThat(inventory.getMoney()).isEqualTo(50);
    }

    @Test
    void getMoneyInfiniteTest() {
        inventory.setInfiniteMoney(true);
        assertThat(inventory.getMoney()).isEqualTo(Integer.MAX_VALUE);
    }
    @Test
    void getMoneyNotInfiniteTest() {
        inventory.setInfiniteMoney(false);
        inventory.addMoney(100);
        assertThat(inventory.getMoney()).isEqualTo(100);
    }
    @Test
    void spendMoneyTest() {
        inventory.setInfiniteMoney(false);
        inventory.addMoney(100);
        inventory.spendMoney(20);
        assertThat(inventory.getMoney()).isEqualTo(100 - 20);
    }
    @Test
    void checkMoneyInfiniteTest() {
        inventory.setInfiniteMoney(true);
        assertThat(inventory.checkMoney(50)).isTrue();
    }
    @Test
    void checkMoneyNotInfiniteEqualToAmountTest() {
        inventory.setInfiniteMoney(false);
        inventory.addMoney(50);
        assertThat(inventory.checkMoney(50)).isTrue();
    }
    @Test
    void checkMoneyNotInfiniteGreaterThanAmountTest() {
        inventory.setInfiniteMoney(false);
        inventory.addMoney(60);
        assertThat(inventory.checkMoney(50)).isTrue();
    }

    @Test
    void checkMoneyNotInfiniteLessThanAmountTest() {
        inventory.setInfiniteMoney(false);
        inventory.addMoney(40);
        assertThat(inventory.checkMoney(50)).isFalse();
    }
    @Test
    void getLongestCharacterNameLengthTest() {
        Character ch1 = mock(Character.class);
        Character ch2 = mock(Character.class);
        Character ch3 = mock(Character.class);
        when(ch1.getName()).thenReturn("short");
        when(ch2.getName()).thenReturn("longer");
        when(ch3.getName()).thenReturn("the longest name"); // has length 16
        inventory.addCharacter(ch1);
        inventory.addCharacter(ch2);
        inventory.addCharacter(ch3);

        assertThat(inventory.getLongestCharacterNameLength(inventory.getCharacters())).isEqualTo(16);
    }
}

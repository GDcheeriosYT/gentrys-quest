package enemy;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import weapon.Weapon;
import character.Character;

public class EnemyTest {

    private Enemy e;
    private Weapon weapon;
    private String name, description;
    private int health, attack, defense;

    private

    @BeforeEach
    void setup() {
        this.name = "Vlad";
        this.health = 100;
        this.attack = 20;
        this.defense = 10;
        this.weapon = mock(Weapon.class);
        this.description = "Dummy description";
        // Enemy 'e' ONLY initialised here -> reduce code duplication
        e = new Enemy(this.name, this.health, this.attack, this.defense, weapon, this.description);
    }

    @Test
    void constructorTest() {
        assertThat(e).isNotNull();
    }

    @Test
    void getHealthTest() {
        assertThat(e.getHealth()).isEqualTo(1000);
    }

    @Test
    void setHealthTest() {
        e.setHealth(50);
        assertThat(e.getHealth()).isEqualTo(50);
    }

    @Test
    void getLevelTest() {
        assertThat(e.getLevel()).isEqualTo(1); // Initially all enemies are lvl.1
    }

    @Test
    void getNameTest() {
        assertThat(e.getName()).isEqualTo(name);
    }
    @Test
    void getAttackTest(){
        assertThat(e.getAttack()).isEqualTo(attack * (int)(1 * 0.9));
    }

    @Test
    void getDefenseTest(){
        assertThat(e.getDefense()).isEqualTo((int)(1 * (int)(1 * 0.85)));
    }

    @Test
    void getDescriptionTest(){
        assertThat(e.getDescription()).isEqualTo(description);
    }

    @Test
    void getWeaponTest(){
        assertThat(e.getWeapon()).isEqualTo(weapon);
    }
    @Test
    void toStringTest(){
        String str = e.toString();
       assertThat(str).contains("level")
                .contains("health")
                .contains("attack")
                .contains("weapon")
                .contains("defense")
                .contains("===============")
                .contains("\n");
    }
    @Test
    void attackTest() {
        Character character = mock(Character.class);
        when(character.getName()).thenReturn("John");
        when(character.getHealth()).thenReturn(100);

        boolean expected = e.attack(character);
        verify(character).setHealth(any(Integer.class));
        //As we mock 'character', we are interested only if character.setHealth() was called for ANY Integer argument
        assertThat(expected).isFalse();
    }

    @Test
    void attackDiedTest() {
        Character character = mock(Character.class);
        when(character.getName()).thenReturn("John");
        when(character.getHealth()).thenReturn(0); // character's health < 1 -> dies

        boolean expected = e.attack(character);
        verify(character).setHealth(any(Integer.class));
        //As we mock 'character', we are interested only if character.setHealth() was called for ANY Integer argument
        assertThat(expected).isTrue();
    }
}

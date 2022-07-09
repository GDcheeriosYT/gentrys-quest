package enemy;

import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import weapon.Weapon;

public class EnemyTest {

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

    }

    @Test
    void constructorTest() {
        Enemy e = new Enemy("Vlad", 100, 20, 10, weapon, "dummy description");
        assertThat(e).isNotNull();
    }
}

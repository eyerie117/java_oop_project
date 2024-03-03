import java.util.ArrayList;

public class Peasant extends BaseHero {
    private int stamina;

    public Peasant(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int stamina) {
        super(x, y, name, 1, health, maxHealth, strength, mind, 0, damage);
        this.stamina = stamina;
    }

    public Peasant(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sStamina: %d\n",super.getFullInfo(), this.stamina);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {

    }
}

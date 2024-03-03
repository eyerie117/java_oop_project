import java.util.ArrayList;

public class Wizard extends BaseHero {
    private int mana;
    private int intuition;

    public Wizard(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int mana, int intuition) {
        super(x, y, name, 1, health, maxHealth, strength, mind, 2, damage);
        this.mana = mana;
        this.intuition = intuition;
    }

    public Wizard(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sMana: %d\nIntuition: %d\n",super.getFullInfo(), this.mana, this.intuition);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {

    }
}

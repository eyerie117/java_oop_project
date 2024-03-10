package Heroes;

import java.util.ArrayList;

public class Wizard extends BaseHero {
    private int mana;
    private int intuition;

    public Wizard(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int mana, int intuition) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
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
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {

    }

    public String getInfo() {
        return "Волшебник";
    }
}

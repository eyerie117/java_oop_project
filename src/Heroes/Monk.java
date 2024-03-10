package Heroes;

import Heroes.BaseHero;

import java.util.ArrayList;

public class Monk extends BaseHero {
    private int healing;
    private int spellResistance;

    public Monk(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int healing, int spellResistance) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.healing = healing;
        this.spellResistance = spellResistance;
    }

    public Monk(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sHealing: %d\nSpell Resistance: %d\n",super.getFullInfo(), this.healing, this.spellResistance);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {

    }

    public String getInfo() {
        return "Монах";
    }
}
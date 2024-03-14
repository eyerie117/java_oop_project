package Heroes;

import Heroes.BaseHero;

import java.util.ArrayList;

public class Peasant extends BaseHero {
    private int stamina;
    boolean busy;

    public Peasant(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int stamina, boolean busy) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.stamina = stamina;
        this.busy = false;
    }

    public Peasant(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sStamina: %d\n",super.getFullInfo(), this.stamina);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Peasant.this)) {
            busy = false;
        }
    }

    public String getInfo() {
        return "Фермер";
    }
}

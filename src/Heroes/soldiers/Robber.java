package Heroes.soldiers;

import Heroes.BaseHero;
import Heroes.Position;

import java.util.ArrayList;

public class Robber extends Soldier {
    private int ability;
    private int luck;

    public Robber(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int ability, int luck) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.ability = ability;
        this.luck = luck;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAbility: %d\nLuck: %d\n",super.getFullInfo(), this.ability, this.luck);
    }

    public String getInfo() {
        return "Разбойник";
    }
}

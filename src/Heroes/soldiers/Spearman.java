package Heroes.soldiers;

import Heroes.BaseHero;
import Heroes.Position;

import java.util.ArrayList;

public class Spearman extends Soldier {
    private int armor;
    private int criticalHit;

    public Spearman(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int armor, int criticalHit) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.armor = armor;
        this.criticalHit = criticalHit;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sArmor: %d\nCritical Hit: %d\n",super.getFullInfo(), this.armor, this.criticalHit);
    }

    public String getInfo() {
        return "Копейщик";
    }
}

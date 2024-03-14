package Heroes;

import Heroes.BaseHero;

import java.util.ArrayList;
import java.util.TreeMap;

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
        if (!isDead(Monk.this)) {
            TreeMap<Double, BaseHero> targetList = new TreeMap<>();
            double ill = 0;
            for (BaseHero baseHero : friendTeam) {
                if (baseHero.getHealth() < baseHero.getMaxHealth() && baseHero.getHealth() > 0) {
                    ill = (double) (baseHero.getHealth() * 100) / baseHero.getMaxHealth();
                    targetList.put(ill, baseHero);
                }
            }
            if (targetList.isEmpty()) return;
            double minHealth = targetList.firstKey();
            BaseHero target = targetList.get(minHealth);
            heal(target, this.healing);
        }
    }

    public String getInfo() {
        return "Монах";
    }
}

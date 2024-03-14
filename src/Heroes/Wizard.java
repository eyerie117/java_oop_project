package Heroes;

import java.util.ArrayList;
import java.util.TreeMap;

public class Wizard extends BaseHero {
    private int healing;
    private int intuition;

    public Wizard(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int healing, int intuition) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.healing = healing;
        this.intuition = intuition;
    }

    public Wizard(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sMana: %d\nIntuition: %d\n",super.getFullInfo(), this.healing, this.intuition);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Wizard.this)) {
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
        return "Волшебник";
    }
}

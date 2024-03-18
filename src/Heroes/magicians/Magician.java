package Heroes.magicians;

import Heroes.BaseHero;

import java.util.ArrayList;
import java.util.TreeMap;

abstract class Magician extends BaseHero {
    private int healing;
    private int mana;
    private int maxMana;
    private boolean flag;

    public Magician(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int healing, int mana, int maxMana) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.healing = healing;
        this.mana = mana;
        this.maxMana = maxMana;
        flag = false;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sHealing: %d\nMana: %d\nMax Mana: %d",super.getFullInfo(), this.healing, this.mana, this.maxMana);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Magician.this)) {
            TreeMap<Double, BaseHero> targetList = new TreeMap<>();
            double ill;
            for (BaseHero baseHero : friendTeam) {
                if (baseHero.getHealth() < baseHero.getMaxHealth() && baseHero.getHealth() > 0) {
                    ill = (double) (baseHero.getHealth() * 100) / baseHero.getMaxHealth();
                    targetList.put(ill, baseHero);
                }
            }

            if (targetList.isEmpty()) return;

            int count = 0;
            for (BaseHero baseHero : friendTeam) {
                if (baseHero.isDead(baseHero)) count++;
            }
            if (count >= 3) flag = true;
            if (flag && mana == maxMana) {
                ArrayList<BaseHero> list = new ArrayList<>();
                for (BaseHero baseHero : friendTeam) {
                    if (baseHero.getHealth() == 0) list.add(baseHero);
                }
                list.getFirst().setHealth();
                mana = 0;
                flag = false;
                return;
            }
            if (flag) {
                mana++;
                return;
            }
            if (mana < 2) {
                mana++;
                return;
            }

            double minHealth = targetList.firstKey();
            BaseHero target = targetList.get(minHealth);
            heal(target, this.healing);
        }
    }
}

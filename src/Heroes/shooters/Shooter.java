package Heroes.shooters;

import Heroes.BaseHero;
import Heroes.Peasant;

import java.util.ArrayList;

abstract class Shooter extends BaseHero {
    private int accuracy;
    private int camouflage;
    private int arrows;

    public Shooter(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int camouflage, int arrows) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.accuracy = accuracy;
        this.camouflage = camouflage;
        this.arrows = arrows;
    }

    @Override
    public String toString() {
        return String.format("%s ➶: %d", super.toString(), this.arrows);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAccuracy: %d\nCamouflage: %d\nArrows: %d\n",super.getFullInfo(), this.accuracy, this.camouflage, this.arrows);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Shooter.this)) {
            if (getNearestEnemy(enemyTeam) == null) return;
            if (Shooter.this.arrows > 0) {
                attack(getNearestEnemy(enemyTeam));
                for (BaseHero baseHero : friendTeam) {
                    if (baseHero.getInfo().equals("Фермер") && !((Peasant)baseHero).busy) {
                        ((Peasant)baseHero).busy = true;
                        return;
                    }
                }
                this.arrows -= 1;
            }
        }
    }
}

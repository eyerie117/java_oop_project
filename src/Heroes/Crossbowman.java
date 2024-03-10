package Heroes;

import java.util.ArrayList;

public class Crossbowman extends BaseHero {
    private int accuracy;
    private int speed;
    private int arrows;

    public Crossbowman(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int speed, int arrows) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.accuracy = accuracy;
        this.speed = speed;
        this.arrows = arrows;
    }

    public Crossbowman(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String toString() {
        return String.format("%s ➶: %d", super.toString(), this.arrows);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAccuracy: %d\nSpeed: %d\nArrows: %d\n",super.getFullInfo(), this.accuracy, this.speed, this.arrows);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Crossbowman.this)) {
            if (Crossbowman.this.arrows > 0) {
                attack(getNearestEnemy(enemyTeam));
                this.arrows -= 1;
            }
        }
    }

    public String getInfo() {
        return "Арбалетчик";
    }
}

import java.util.ArrayList;

public class Sniper extends BaseHero {
    private int accuracy;
    private int camouflage;
    private int arrows;

    public Sniper(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int camouflage, int arrows) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.accuracy = accuracy;
        this.camouflage = camouflage;
        this.arrows = arrows;
    }

    public Sniper(int x, int y, String name) {
        super(x, y, name);
    }
    @Override
    public String getFullInfo() {
        return String.format("%sAccuracy: %d\nCamouflage: %d\nArrows: %d\n",super.getFullInfo(), this.accuracy, this.camouflage, this.arrows);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Sniper.this)) {
            if (Sniper.this.arrows > 0) {
                attack(getNearestEnemy(enemyTeam));
                this.arrows -= 1;
            } else {
                System.out.println("Give me more arrows!");
            }
        }
    }
}

import java.util.ArrayList;

public class Spearman extends BaseHero{
    private int armor;
    private int criticalHit;

    public Spearman(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int armor, int criticalHit) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.armor = armor;
        this.criticalHit = criticalHit;
    }

    public Spearman(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sArmor: %d\nCritical Hit: %d\n",super.getFullInfo(), this.armor, this.criticalHit);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Spearman.this)) {
            BaseHero enemy = this.getNearestEnemy(enemyTeam);
            if (heroPosition.getDistance(enemy.heroPosition) < 2) {
                attack(enemy);
                return;
            }

            Position diff = heroPosition.getDifference(enemy.heroPosition);
            Position newPosition = new Position(heroPosition.x, heroPosition.y);
            if (Math.abs(diff.x) > Math.abs(diff.y)) {
                newPosition.x += diff.x < 0 ? 1 : -1;
            } else {
                newPosition.y += diff.y < 0 ? 1 : -1;
            }
            for (BaseHero baseHero : friendTeam) {
                if (baseHero.heroPosition.equals(newPosition)) return;
            }
            this.heroPosition = newPosition;
        }
    }
}

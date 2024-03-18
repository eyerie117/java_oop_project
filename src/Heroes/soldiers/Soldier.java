package Heroes.soldiers;

import Heroes.BaseHero;
import Heroes.Position;

import java.util.ArrayList;

abstract class Soldier extends BaseHero {
    public Soldier(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam) {
        if (!isDead(Soldier.this)) {
            if (getNearestEnemy(enemyTeam) == null) return;
            BaseHero enemy = this.getNearestEnemy(enemyTeam);
            if (heroPosition.getDistance(enemy.heroPosition) < 2 && enemy.getHealth() > 0) {
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

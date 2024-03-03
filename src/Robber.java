import java.util.ArrayList;

public class Robber extends BaseHero {
    private int ability;
    private int luck;

    public Robber(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int ability, int luck) {
        super(x, y, name, 1, health, maxHealth, strength, mind, 1, damage);
        this.ability = ability;
        this.luck = luck;
    }

    public Robber(int x, int y, String name) {
        super(x, y, name);
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAbility: %d\nLuck: %d\n",super.getFullInfo(), this.ability, this.luck);
    }

    @Override
    public void step(ArrayList<BaseHero> enemyTeam) {

    }
}

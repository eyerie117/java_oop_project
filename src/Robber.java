public class Robber extends BaseHero {
    private int ability;
    private int luck;

    public Robber(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int ability, int luck) {
        super(name, level, health, maxHealth, strength, mind, reaction, damage);
        this.ability = ability;
        this.luck = luck;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAbility: %d\nLuck: %d\n",super.getFullInfo(), this.ability, this.luck);
    }
}
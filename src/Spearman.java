public class Spearman extends BaseHero{
    private int armor;
    private int criticalHit;

    public Spearman(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int armor, int criticalHit) {
        super(name, level, health, maxHealth, strength, mind, reaction, damage);
        this.armor = armor;
        this.criticalHit = criticalHit;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sArmor: %d\nCritical Hit: %d\n",super.getFullInfo(), this.armor, this.criticalHit);
    }
}

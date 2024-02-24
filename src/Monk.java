public class Monk extends BaseHero {
    private int healing;
    private int spellResistance;

    public Monk(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int healing, int spellResistance) {
        super(name, level, health, maxHealth, strength, mind, reaction, damage);
        this.healing = healing;
        this.spellResistance = spellResistance;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sHealing: %d\nSpell Resistance: %d\n",super.getFullInfo(), this.healing, this.spellResistance);
    }
}

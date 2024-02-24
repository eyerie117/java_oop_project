public class Wizard extends BaseHero {
    private int mana;
    private int intuition;

    public Wizard(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int mana, int intuition) {
        super(name, level, health, maxHealth, strength, mind, reaction, damage);
        this.mana = mana;
        this.intuition = intuition;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sMana: %d\nIntuition: %d\n",super.getFullInfo(), this.mana, this.intuition);
    }
}

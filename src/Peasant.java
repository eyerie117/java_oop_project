public class Peasant extends BaseHero {
    private int stamina;

    public Peasant(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int stamina) {
        super(name, level, health, maxHealth, strength, mind, reaction, damage);
        this.stamina = stamina;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sStamina: %d\n",super.getFullInfo(), this.stamina);
    }
}

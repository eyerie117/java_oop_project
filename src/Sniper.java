public class Sniper extends BaseHero {
    private int accuracy;
    private int camouflage;

    public Sniper(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int camouflage) {
        super(name, level, health, maxHealth, strength, mind, reaction, damage);
        this.accuracy = accuracy;
        this.camouflage = camouflage;
    }

    @Override
    public String getFullInfo() {
        return String.format("%sAccuracy: %d\nCamouflage: %d\n",super.getFullInfo(), this.accuracy, this.camouflage);
    }
}

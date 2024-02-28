public class Sniper extends BaseHero {
    private int accuracy;
    private int camouflage;

    public Sniper(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage, int accuracy, int camouflage) {
        super(x, y, name, level, health, maxHealth, strength, mind, reaction, damage);
        this.accuracy = accuracy;
        this.camouflage = camouflage;
    }

    public Sniper(int x, int y, String name) {
        super(x, y, name);
    }
    @Override
    public String getFullInfo() {
        return String.format("%sAccuracy: %d\nCamouflage: %d\n",super.getFullInfo(), this.accuracy, this.camouflage);
    }
}

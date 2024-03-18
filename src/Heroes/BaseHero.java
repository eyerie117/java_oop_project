package Heroes;/*
Абстрактный класс "Базовый персонаж":
1. Имя персонажа
2. Уровень персонажа
3. Здоровье
4. Сила
5. Интеллект
6. Скорость реакции (инициатива)
7. Наносимый урон

Крестьянин:
+ Выносливость

Разбойник
+ Ловкость
+ Удача

Снайпер
+ Меткость
+ Маскировка

Колдун
+ Мана
+ Интуиция

Копейщик
+ Броня
+ Критический удар

Арбалетчик
+ Меткость
+ Скорость

Монах
+ Исцеление
+ Сопротивление магии
 */

import java.util.ArrayList;
import java.util.TreeMap;

abstract public class BaseHero implements Step {
    private String name;
    private int level;
    private int health;
    private  int maxHealth;
    private int strength;
    private int mind;
    private int reaction;
    private int damage;
    public Position heroPosition;

    public BaseHero(int x, int y, String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.mind = mind;
        this.reaction = reaction;
        this.damage = damage;
        heroPosition = new Position(x, y);
    }

    public BaseHero(int x, int y, String name) {
        this.name = name;
        heroPosition = new Position(x, y);
    }

    @Override
    public String toString() {
        return String.format("Name: %s ♥: %d ⚔: %d", this.name, this.health, this.damage);
    }

    public String getInfo() {
        return "";
    }

    public String getFullInfo() {
        return String.format("\nName: %s\nType: %s\nLevel: %d\nHealth: %d\nMax Health: %d\nStrength: %d\nMind: %d\nReaction: %d\nDamage: %d\nHero Heroes.magicians.Wizard.Position: %d, %d\n",
                this.name, this.getClass().getSimpleName(), this.level, this.health, this.maxHealth, this.strength, this.mind, this.reaction, this.damage, this.heroPosition.getX(), this.heroPosition.getY());
    }

    public boolean isDead(BaseHero target) {
        return target.health <= 0;
    }

    public void getDamage(int damage) {
        if (this.health - damage > 0) this.health -= damage;
        else this.health = 0;
    }

    public void attack(BaseHero target) {
        int damage = this.damage;
        target.getDamage(damage);
    }

    public void heal(BaseHero target, int healing) {
        target.health = Math.min(target.health + healing, target.maxHealth);
    }

    public BaseHero getNearestEnemy(ArrayList<BaseHero> enemyTeam) {

        TreeMap<Double, BaseHero> target = new TreeMap<>();

        for (BaseHero baseHero : enemyTeam) {
            Position enemyPosition = new Position(baseHero.heroPosition.x, baseHero.heroPosition.y);
            Position myPosition = new Position(heroPosition.x, heroPosition.y);
            if (baseHero.getHealth() > 0) target.put(myPosition.getDistance(enemyPosition), baseHero);
        }
        if (target.isEmpty()) return null;
        double minDistance = target.firstKey();
        return target.get(minDistance);
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getReaction() {
        return reaction;
    }

    public int getDamage() {
        return damage;
    }

    public Position getHeroPosition() {
        return heroPosition;
    }

    public void setHealth() {
        this.health = this.maxHealth;
    }

    public interface Step {
        void step(ArrayList<BaseHero> enemyTeam, ArrayList<BaseHero> friendTeam);
    }
}

/*
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

abstract class BaseHero {
    private String name;
    private int level;
    private int health;
    private  int maxHealth;
    private int strength;
    private int mind;
    private int reaction;
    private int damage;

    public BaseHero(String name, int level, int health, int maxHealth, int strength, int mind, int reaction, int damage) {
        this.name = name;
        this.level = level;
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.mind = mind;
        this.reaction = reaction;
        this.damage = damage;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nType: %s\n",
                this.name, this.getClass().getSimpleName());
    }

    public String getFullInfo() {
        return String.format("\nName: %s\nType: %s\nLevel: %d\nHealth: %d\nMax Health: %d\nStrength: %d\nMind: %d\nReaction: %d\nDamage: %d\n",
                this.name, this.getClass().getSimpleName(), this.level, this.health, this.maxHealth, this.strength, this.mind, this.reaction, this.damage);
    }

    public void getDamage(int damage) {
        if (this.health - damage > 0) {
            this.health -= damage;
        } else {
            System.out.println(this.name + " die!");
        }
    }

    public void attack(BaseHero target) {
        int damage = this.damage;
        target.getDamage(damage);
    }

    public void heal(int addHealth) {
        if (this.health + addHealth > this.maxHealth) {
            this.health = this.maxHealth;
        } else {
            this.health = this.health + addHealth;
        }
    }
}

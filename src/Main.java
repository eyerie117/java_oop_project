/*
Урок 1. Задание 1.
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников.
Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.

Урок 2. Задание 2.
Добавить в проект класс, предназначенный для хранения координат. Добавить в абстрактный класс поле, экземпляр класс координат.
Пробросить координаты через конструкторы наследников так, чтобы создавая объекты вы передавали в параметрах имя и координаты.
Написать алгоритм заполнения команд. Кроме имён каждый персонаж должен иметь координаты. Одна команда находится с левой стороны другая с правой(у=0 и у=9).
В класс лучников добавить метод поиск ближайшего противника. Алгоритм расчёта расстояний реализовать в классе координат.
 */

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        ArrayList<BaseHero> teamRight = new ArrayList<>();
        ArrayList<BaseHero> teamLeft = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            switch (new Random().nextInt(7)) {
                case 0:
                    teamRight.add(new Peasant(i, 0, getName()));
                    break;
                case 1:
                    teamRight.add(new Robber(i, 0, getName()));
                    break;
                case 2:
                    teamRight.add(new Sniper(i, 0, getName()));
                    break;
                case 3:
                    teamRight.add(new Wizard(i, 0, getName()));
                    break;
                case 4:
                    teamRight.add(new Spearman(i, 0, getName()));
                    break;
                case 5:
                    teamRight.add(new Crossbowman(i, 0, getName()));
                    break;
                case 6:
                    teamRight.add(new Monk(i, 0, getName()));
                    break;
            }

            switch (new Random().nextInt(7)) {
                case 0:
                    teamLeft.add(new Peasant(i, 9, getName()));
                    break;
                case 1:
                    teamLeft.add(new Robber(i, 9, getName()));
                    break;
                case 2:
                    teamLeft.add(new Sniper(i, 9, getName()));
                    break;
                case 3:
                    teamLeft.add(new Wizard(i, 9, getName()));
                    break;
                case 4:
                    teamLeft.add(new Spearman(i, 9, getName()));
                    break;
                case 5:
                    teamLeft.add(new Crossbowman(i, 9, getName()));
                    break;
                case 6:
                    teamLeft.add(new Monk(i, 9, getName()));
                    break;
            }
        }

        printTeam(teamRight);
        printTeam(teamLeft);

        System.out.println("Your nearest enemy is:\n" + teamRight.get(5).getNearestEnemy(teamLeft));
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    public static void printTeam(ArrayList<BaseHero> team) {
        for (int i = 0; i < team.size(); i++) {
            System.out.println((i + 1) + ".\n" + team.get(i));
        }
    }
}

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

Урок 3. Задание 3.
Добавить в файл интерфейса метод void step() это будет основной метод взаимодействыия с объектами. Добавить интерфейс в базовый абстрактный класс.
Реализовать этот метод во всех классах наследниках. Для начала просто заглушкой.
Доработать классы лучников. Лучник должен во первых проверить жив ли он и есть ли у него стрелы, если нет то завершить метод.
Есль всё да, то найти ближайшего противника и выстрелить по немы и, соответственно потратить одну стрелу. Реализовать весь функционал лучников в методе step().
Добавить в абстрактный класс int поле инициатива. В классах наследников инициализировать это поле. Крестьянин = 0, маги=1, пехота=2, лучники=3.
В мэйне сделать так, чтобы сначала делали ход персонажи с наивысшей инициативой из обеих комманд а с наименьшей в конце.
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
                    teamRight.add(new Peasant(i, 0, getName(), 1, 100, 100, 10, 25, 0, 5, 15));
                    break;
                case 1:
                    teamRight.add(new Robber(i, 0, getName(), 1, 120, 120, 25, 40, 1, 15, 10, 25));
                    break;
                case 2:
                    teamRight.add(new Sniper(i, 0, getName(), 1, 150, 150, 40, 75, 3, 40, 70, 100, 5));
                    break;
                case 3:
                    teamRight.add(new Wizard(i, 0, getName(), 1, 250, 250, 80, 120, 2, 80, 150, 60));
                    break;
                case 4:
                    teamRight.add(new Spearman(i, 0, getName(), 1, 170, 170, 50, 50, 1, 40, 40, 60));
                    break;
                case 5:
                    teamRight.add(new Crossbowman(i, 0, getName(), 1, 140, 140, 30, 60, 3, 30, 50, 30, 10));
                    break;
                case 6:
                    teamRight.add(new Monk(i, 0, getName(), 1, 200, 200, 50, 100, 2, 35, 25, 70));
                    break;
            }

            switch (new Random().nextInt(7)) {
                case 0:
                    teamLeft.add(new Peasant(i, 0, getName(), 1, 100, 100, 10, 25, 0, 5, 15));
                    break;
                case 1:
                    teamLeft.add(new Robber(i, 0, getName(), 1, 120, 120, 25, 40, 1, 15, 10, 25));
                    break;
                case 2:
                    teamLeft.add(new Sniper(i, 0, getName(), 1, 150, 150, 40, 75, 3, 40, 70, 100, 5));
                    break;
                case 3:
                    teamLeft.add(new Wizard(i, 0, getName(), 1, 250, 250, 80, 120, 2, 80, 150, 60));
                    break;
                case 4:
                    teamLeft.add(new Spearman(i, 0, getName(), 1, 170, 170, 50, 50, 1, 40, 40, 60));
                    break;
                case 5:
                    teamLeft.add(new Crossbowman(i, 0, getName(), 1, 140, 140, 30, 60, 3, 30, 50, 30, 10));
                    break;
                case 6:
                    teamLeft.add(new Monk(i, 0, getName(), 1, 200, 200, 50, 100, 2, 35, 25, 70));
                    break;
            }
        }

        //printTeam(teamRight);
        //printTeam(teamLeft);

        //System.out.println("Your nearest enemy is:\n" + teamRight.get(5).getNearestEnemy(teamLeft));

        ArrayList<BaseHero> allHeroes = new ArrayList<>();
        allHeroes.addAll(teamLeft);
        allHeroes.addAll(teamRight);

        allHeroes.sort((o1, o2) -> o2.getReaction() - o1.getReaction());

        allHeroes.forEach(System.out::println);

    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }

    public static void printTeam(ArrayList<BaseHero> team) {
        for (int i = 0; i < team.size(); i++) {
            System.out.println((i + 1) + ".\n" + team.get(i).getFullInfo());
        }
    }
}

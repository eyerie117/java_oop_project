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

Урок 4. Задание 4.
Реализовать метод step() пехоты. Первое проверяем живы ли мы, потом ищем ближайшего противника.
Если противник в соседней клетке, наносим повреждение. Иначе двигаемся в сторну противника.
Алгоритм движения, если dX>dY двигаемся по x иначе по y. dX и dY (разница наших координат и ближайшего противника) знаковые, от знака зависит направление.

Урок 5. Задание 5.
Добавить в проект классы View и AnsiColors. Доработать проект так, чтобы выводилось состаяние в консоль.
Если в одной из комманд погибли все, приложение закрывается с поздравлением победившей команды.
 */

import Heroes.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static ArrayList<BaseHero> teamRight = new ArrayList<>();
    public static ArrayList<BaseHero> teamLeft = new ArrayList<>();
    public static ArrayList<BaseHero> allHeroes = new ArrayList<>();
    public static void main(String[] args) {

        for (int i = 1; i < 11; i++) {
            switch (new Random().nextInt(7)) {
                case 0:
                    teamRight.add(new Peasant(i, 1, getName(), 1, 100, 100, 10, 25, 0, 5, 15, false));
                    break;
                case 1:
                    teamRight.add(new Robber(i, 1, getName(), 1, 120, 120, 25, 40, 1, 15, 10, 25));
                    break;
                case 2:
                    teamRight.add(new Sniper(i, 1, getName(), 1, 150, 150, 40, 75, 3, 40, 70, 100, 10));
                    break;
                case 3:
                    teamRight.add(new Wizard(i, 1, getName(), 1, 100, 100, 80, 120, 2, 80, 15, 5, 5));
                    break;
                case 4:
                    teamRight.add(new Spearman(i, 1, getName(), 1, 170, 170, 50, 50, 1, 40, 40, 60));
                    break;
                case 5:
                    teamRight.add(new Crossbowman(i, 1, getName(), 1, 140, 140, 30, 60, 3, 30, 50, 30, 15));
                    break;
                case 6:
                    teamRight.add(new Monk(i, 1, getName(), 1, 80, 80, 50, 100, 2, 35, 10, 5, 5));
                    break;
            }

            switch (new Random().nextInt(7)) {
                case 0:
                    teamLeft.add(new Peasant(i, 10, getName(), 1, 100, 100, 10, 25, 0, 5, 15, false));
                    break;
                case 1:
                    teamLeft.add(new Robber(i, 10, getName(), 1, 120, 120, 25, 40, 1, 15, 10, 25));
                    break;
                case 2:
                    teamLeft.add(new Sniper(i, 10, getName(), 1, 150, 150, 40, 75, 3, 40, 70, 100, 10));
                    break;
                case 3:
                    teamLeft.add(new Wizard(i, 10, getName(), 1, 100, 100, 80, 120, 2, 80, 15, 5, 5));
                    break;
                case 4:
                    teamLeft.add(new Spearman(i, 10, getName(), 1, 170, 170, 50, 50, 1, 40, 40, 60));
                    break;
                case 5:
                    teamLeft.add(new Crossbowman(i, 10, getName(), 1, 140, 140, 30, 60, 3, 30, 50, 30, 15));
                    break;
                case 6:
                    teamLeft.add(new Monk(i, 10, getName(), 1, 80, 80, 50, 100, 2, 35, 10, 5, 5));
                    break;
            }
        }

        allHeroes.addAll(teamLeft);
        allHeroes.addAll(teamRight);
        allHeroes.sort((o1, o2) -> o2.getReaction() - o1.getReaction());

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (true) {
            View.view();
            scanner.nextLine();
            int teamRightHealth = 0;
            int teamLeftHealth = 0;
            for (BaseHero baseHero : teamRight) {
                teamRightHealth += baseHero.getHealth();
            }
            for (BaseHero baseHero : teamLeft) {
                teamLeftHealth += baseHero.getHealth();
            }
            if (teamRightHealth == 0) {
                System.out.println("teamLeft одержали победу!");
                flag = false;
                break;
            }
            if (teamLeftHealth == 0) {
                System.out.println("teamRight одержали победу!");
                flag = false;
                break;
            }
            for (BaseHero allHero : allHeroes) {
                if (teamRight.contains(allHero)) allHero.step(teamLeft, teamRight);
                else allHero.step(teamRight, teamLeft);
            }

        }
    }

    private static String getName() {
        return String.valueOf(Names.values()[new Random().nextInt(Names.values().length - 1)]);
    }
}

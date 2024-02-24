/*
Проанализировать персонажей "Крестьянин, Разбойник, Снайпер, Колдун, Копейщик, Арбалетчик, Монах".
Для каждого определит 8 полей данных(здоровье, сила итд) 3-4 поля поведения(методов атаковать, вылечить итд).
Создать абстрактный класс и иерархию наследников.
Расположить классы в пакет так, чтобы в основной программе небыло видно их полей.
В не абстрактных классах переопределить метод toString() так чтобы он возвращал название класса или имя.
Создать в основной программе по одному обьекту каждого не абстрактного класса и вывести в консоль его имя.
 */

public class Main {
    public static void main(String[] args) {
        Peasant peasant1 = new Peasant("Hero_1", 1, 100, 100, 50, 25, 50, 20, 40);
        Robber robber1 = new Robber("Hero_2", 1, 150, 150,100, 60, 70, 50, 40, 40);
        Sniper sniper1 = new Sniper("Hero_3", 1, 180, 180,150, 150, 100, 90, 80, 100);
        Wizard wizard1 = new Wizard("Hero_4", 1, 200, 200,250, 180, 80, 150, 300, 80);
        Spearman spearman1 = new Spearman("Hero_5", 1, 250, 250,200, 120, 90, 100, 50, 150);
        Crossbowman crossbowman1 = new Crossbowman("Hero_6", 1, 220, 220,180, 120, 90,70, 70, 90);
        Monk monk1 = new Monk("Hero_7", 1, 140, 140,180, 200, 90, 100, 70, 50);

        System.out.println(peasant1);
        System.out.println(robber1);
        System.out.println(sniper1);
        System.out.println(wizard1);
        System.out.println(spearman1);
        System.out.println(crossbowman1);
        System.out.println(monk1);

//        System.out.println(peasant1.getFullInfo());
//        System.out.println(robber1.getFullInfo());
//        System.out.println(sniper1.getFullInfo());
//        System.out.println(wizard1.getFullInfo());
//        System.out.println(spearman1.getFullInfo());
//        System.out.println(crossbowman1.getFullInfo());
//        System.out.println(monk1.getFullInfo());
    }
}

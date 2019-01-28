/* Project HumanitarianAid
     Returns the number of trucks and containers needed to load a given number of boxes.
 */

import java.util.Scanner;

public class Loader {

    public static void main(String[] args) {

        long truckNumber;
        long containerNumber;
        int BOX_PER_CONTAINER = 27;
        int CONTAINER_PER_TRUCK = 12;
        int BOX_PER_TRUCK = 324;

        //Защита от дурака, взял тут: http://qaru.site/questions/280/validating-input-using-javautilscanner
        Scanner sc = new Scanner(System.in);
        double boxNumber = 0.0;
        do {
            System.out.println("Введите число ящиков");
            while (!sc.hasNextInt()) {
                System.out.println("Хватит баловаться! Введите ещё раз число ящиков");
                sc.next();  // this is important!
            }
            boxNumber = sc.nextInt();
        } while (boxNumber <= 0);
        //*************************************************************************************************

        truckNumber = Math.round(Math.ceil(boxNumber/BOX_PER_TRUCK));
        containerNumber = Math.round(Math.ceil(boxNumber/BOX_PER_CONTAINER));
        System.out.println("Количество грузовиков: " + truckNumber);
        System.out.println("Количество контейнеров: " + containerNumber);
        System.out.println("================================");

        //Выводим в консоль грузовики, контейнеры, ящики
        int currentBox = 0;
        int currentContainer = 0;

        for (int i=1; i<=truckNumber; i++) {
            System.out.println("Грузовик " + i +":");
            do {
                currentContainer++;
                System.out.println("\tКонтейнер " + currentContainer + ":");
                do {
                    currentBox++;
                    boxNumber--;
                    System.out.println("\t\t\tЯщик " + currentBox);
                } while ((Math.floorMod(currentBox, BOX_PER_CONTAINER)) != 0 && boxNumber != 0);     //Пихаем коробки в контейнер пока их <=27
            } while ((Math.floorMod(currentContainer, CONTAINER_PER_TRUCK)) != 0 && boxNumber != 0); //Пихаем контейнеры в грузовик пока их <=12
        }
    }
}
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int intBox;

    public static void main(String[] args) {

        int truckAmount;
        int counterTruck = 0;
        int counterContainer = 0;
        int counterBox = 0;
        int boxInTruck = Constant.CONTAINER_IN_TRUCK * Constant.BOX_IN_CONTAINER;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество ящиков. ");

        do {
            System.out.print("Должно быть положительное число: ");
            while (!sc.hasNextInt()) {
                System.out.println();
                sc.next();
            }
            intBox = sc.nextInt();
        } while (intBox <= 0);

        truckAmount = intBox < boxInTruck ? 1 : (int) Math.ceil(intBox / (double) boxInTruck);
        exit:
        for (int i = 0; i < truckAmount; i++) {
            counterTruck++;
            System.out.println("\nГрузовик " + counterTruck);

            for (int j = 0; j < Constant.CONTAINER_IN_TRUCK; j++) {
                counterContainer++;
                System.out.println("\n____________________\n" + "\tКонтейнер " + counterContainer);

                for (int x = 0; x < Constant.BOX_IN_CONTAINER; x++) {
                    counterBox++;
                    System.out.println("\t\tЯщик " + counterBox);
                    if (counterBox == intBox) break exit;
                }
            }
        }
        System.out.println("\n##############################");
        System.out.println("Необходимо:" +
                "\n\tГрузовиков: " + counterTruck + " шт." +
                "\n\tКонтейнеров: " + counterContainer + " шт.");
    }
}

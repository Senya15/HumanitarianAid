import java.util.ArrayList;
import java.util.Scanner;

public class Main {

public static int intBox;

    public static void main(String[] args) {

        int truckAmount;
        int containerAmount;
        int boxAmount;
        int boxInTruck = Constant.CONTAINER_IN_TRUCK * Constant.BOX_IN_CONTAINER;

        ArrayList<Truck> trucks = new ArrayList<>();
        ArrayList<Container> containers = new ArrayList<>();
        ArrayList<Box> boxes = new ArrayList<>();


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


        int truckAmount2 = intBox < boxInTruck ? 1 : (intBox / boxInTruck);
        exit:
        for (int i = 0; ; i++)
        {
            Truck truck = new Truck();
            trucks.add(truck);
            truckAmount = (trucks.indexOf(truck) + 1);
            System.out.println("\nГрузовик " + truckAmount);

//            containerAmount = (int) Math.ceil((double) intBox / Container.BOX_IN_CONTAINER);
//            countContainerRemainder = intBox % Container.BOX_IN_CONTAINER;

            for (int j = 0; j < Constant.CONTAINER_IN_TRUCK; j++)
            {
                Container container = new Container();
                containers.add(container);
                containerAmount = (containers.indexOf(container) + 1);
                System.out.println("15____________________\n" + "\tКонтейнер " + containerAmount);

                for (int x = 0; x < Constant.BOX_IN_CONTAINER; x++)
                {
                    Box box = new Box();
                    boxes.add(box);
                    boxAmount = (boxes.indexOf(box) + 1);
                    System.out.println("\t\tЯщик " + boxAmount);
                    if (boxAmount == intBox) break exit;
                }
            }
        }
        System.out.println("\n##############################");
        System.out.println("Необходимо:" +
                "\n\tГрузовиков: " + truckAmount + " шт." +
                "\n\tКонтейнеров: " + containerAmount + " шт.");

        System.out.println("\n\nВЫЧЕСЛЕННОЕ КОЛИЧЕСТВО ГРУЗОВИКОВ: " + truckAmount2);
    }
    }

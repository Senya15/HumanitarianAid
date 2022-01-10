import java.util.ArrayList;
import java.util.Scanner;

public class Main {

//static final int CONTAINER_IN_TRUCK = 12;
//static final int BOX_IN_CONTAINER = 27;
public static int box;

    public static void main(String[] args) {

        int countTruck;
        int countContainer = 0;
        int countContainerRemainder = 0;
        double boxInTruck = Truck.CONTAINER_IN_TRUCK * Container.BOX_IN_CONTAINER;

        ArrayList<Truck> trucks = new ArrayList<>();
        ArrayList<Container> containers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите количество ящиков. ");

        do {
            System.out.print("Должно быть положительное число: ");
            while (!sc.hasNextInt()) {
                System.out.println();
                sc.next();
            }
            box = sc.nextInt();
        } while (box <= 0);


        countTruck = box < boxInTruck ? 1 : (int) Math.ceil(box / boxInTruck);

        for (int i = 0; i < countTruck; i++)
        {
            Truck truck = new Truck();
            trucks.add(truck);
            System.out.println("Грузовик " + (trucks.indexOf(truck) + 1));

            countContainer = (int) Math.ceil((double) box / Container.BOX_IN_CONTAINER);
            countContainerRemainder = box % Container.BOX_IN_CONTAINER;

            for (int x = 0; x < Truck.CONTAINER_IN_TRUCK; x++)
            {
                Container container = new Container();
                containers.add(container);
                System.out.println("Контейнер " + (containers.indexOf(container) + 1));
            }

        }

        System.out.println(countContainer);
        System.out.println(countContainerRemainder);
    }
    



}

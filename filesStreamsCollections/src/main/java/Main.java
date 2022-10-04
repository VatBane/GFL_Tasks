import controllers.ManufacturerController;
import controllers.SouvenirController;
import services.ManufacturerService;
import services.SouvenirService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private ManufacturerController mController;
    private SouvenirController sController;
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        this.sController = new SouvenirController();
        this.mController = new ManufacturerController();

        int key = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("""
                    Выберите действие:
                    1. Меню сувениров;
                    2. Меню производителей;
                    0. Выход""");

            key = sc.nextInt();

            switch (key) {
                case 1 -> souvenirsMenu(sc);
                case 2 -> manufacturersMenu(sc);
            }
        } while(key != 0);
    }

    private void manufacturersMenu(Scanner sc) {
        int key = 0;

        do {
            System.out.println("""
                    Выберите действие:
                    1. Посмотреть всех производителей;
                    2. Посмотреть производителей, чьи сувениры в пределах заданой цены;
                    3. Посмотреть всех производителей и их товары;
                    4. Добавить производителя;
                    5. Редактировать информацию о производителе;
                    6. Удалить производителя и все его сувениры;
                    
                    0. Назад""");

            key = sc.nextInt();

            switch (key) {
                case 1 -> mController.getAllManufacturers(); // DONE
                case 2 -> mController.getManufacturersByPrice(sc); // DONE
                case 3 -> mController.getManufacturersWithSouvenirs(); // DONE
                case 4 -> mController.createManufacturer(sc); // DONE
                case 5 -> mController.updateManufacturer(sc); // DONE
                case 6 -> mController.deleteManufacturer(sc); // DONE
            }
        } while(key != 0);
    }

    private void souvenirsMenu(Scanner sc) {
        int key = 0;

        do {
            System.out.println("""
                    Выберите действие:
                    1. Посмотреть все сувениры;
                    2. Посмотреть сувениры по производителю;
                    3. Посмотреть сувениры по стране-производителю;
                    4. Посмотерть сувениры произведенные в заданом году;
                    5. Посмотреть сувениры произведенные в этот год;
                    6. Посмотреть всех производителей заданого сувенира;
                    7. Добавить сувенир;
                    8. Редактировать сувенир4
                    9. Удалить сувенир;
                    
                    0. Назад""");

            try {
                key = sc.nextInt();
            } catch (InputMismatchException e) {
                e.printStackTrace();
                key = 0;
            }

            switch (key) {
                case 1 -> sController.getAllSouvenirs(); // DONE
                case 2 -> sController.getByManufacturer(sc); // DONE
                case 3 -> sController.getByCountry(sc); // DONE
                case 4 -> sController.getByYear(sc); // DONE
                case 5 -> sController.getLatest(); // DONE
                case 6 -> sController.getAllManufacturers(sc); // DONE
                case 7 -> sController.createSouvenir(sc); // DONE
                case 8 -> sController.updateSouvenir(sc); // DONE
                case 9 -> sController.deleteSouvenir(sc); // DONE
            }

        } while(key != 0);
    }
}

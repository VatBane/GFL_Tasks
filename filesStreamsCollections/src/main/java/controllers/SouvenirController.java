package controllers;

import model.Manufacturer;
import model.Souvenir;
import services.ManufacturerService;
import services.SouvenirService;

import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Scanner;

public class SouvenirController {
    private final ManufacturerService mService;
    private final SouvenirService sService;

    public SouvenirController() {
        sService = new SouvenirService("storage\\souvenirs.txt");
        mService = new ManufacturerService("storage\\manufacturers.txt");
    }

    public void getAllSouvenirs() {
        sService.getAllSouvenirs().forEach(System.out::println);
    }

    public void getByManufacturer(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите название производителя");
        String title = sc.nextLine();
        mService.getManufacturerByTitle(title);
        sService.getSouvenirsByManufacturer(title).forEach(System.out::println);
    }

    public void getByCountry(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите страну производителя: ");
        List<String> m = mService.getManufacturersByCountry(sc.nextLine());
        if (m.isEmpty()) {
            System.out.println("Нет производителей в этой стране");
            return;
        }
        sService.getAllSouvenirs().stream()
                .filter(s -> m.contains(s.getManufacturer())).forEach(System.out::println);
    }

    public void getByYear(Scanner sc) {
        System.out.println("Введите год производства:");
        int year = sc.nextInt();

        List<Souvenir> list = sService.getAllSouvenirs().stream()
                .filter(s -> s.getDate().getYear() == year)
                .toList();
        if (list.isEmpty()) System.out.println("В этот год не было произведено никаких сувениров");
        else list.forEach(System.out::println);
    }

    public void getLatest() {
        sService.getAllSouvenirs().stream()
                .filter(s -> s.getDate().getYear() == Year.now().getValue())
                .forEach(System.out::println);
    }

    public void createSouvenir(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите название сувенира: ");
        String title = sc.nextLine();
        System.out.println("Введите название производителя:");
        String manufacturerTitle = sc.nextLine();
        if (mService.getManufacturerByTitle(manufacturerTitle) == null) {
            System.out.println("Такого производителя нет. Возможно вам нужно его создать.");
            return;
        }
        List<Souvenir> list = sService.getAllSouvenirs().stream()
                .filter(s -> s.getTitle().equals(title) && s.getManufacturer().equals(manufacturerTitle))
                .toList();
        if (!list.isEmpty()) {
            System.out.println("Уже есть такой сувенир!");
            return;
        }
        System.out.println("Введите дату создания (год-месяц-день):");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Введите цену сувенира: ");
        double price = sc.nextDouble();

        sService.createSouvenir(title, manufacturerTitle, date, price);
    }

    public void updateSouvenir(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите старое название севенира: ");
        String oldTitle = sc.nextLine();
        System.out.println("Введите старого производителя: ");
        String manufacturerTitle = sc.nextLine();
        List<Souvenir> list = sService.getAllSouvenirs().stream()
                .filter(s -> s.getTitle().equals(oldTitle) && s.getManufacturer().equals(manufacturerTitle))
                .toList();
        if (list.isEmpty()) {
            System.out.println("Нет такого сувенира.");
            return;
        }
        System.out.println("Введите новое название сувенира: ");
        String title = sc.nextLine();
        System.out.println("Введите нового производителя: ");
        String manufacturer = sc.nextLine();
        list = sService.getAllSouvenirs().stream()
                .filter(s -> s.getTitle().equals(title) && s.getManufacturer().equals(manufacturer))
                .toList();
        if (!list.isEmpty()) {
            System.out.println("Такой сувенир уже существует.");
            return;
        }
        long newId = sService.getSouvenirsByManufacturer(manufacturer).stream()
                .filter(s -> s.getTitle().equals(oldTitle)).toList().get(0).getId();
        System.out.println("Введите дату создания (год-месяц-день):");
        LocalDate date = LocalDate.parse(sc.nextLine());
        System.out.println("Введите цену сувенира: ");
        double price = sc.nextDouble();

        sService.updateSouvenir(newId, title, manufacturer, date, price);
    }

    public void deleteSouvenir(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите старое название севенира: ");
        String title = sc.nextLine();
        System.out.println("Введите старого производителя: ");
        String manufacturerTitle = sc.nextLine();
        List<Souvenir> list = sService.getAllSouvenirs().stream()
                .filter(s -> s.getTitle().equals(title) && s.getManufacturer().equals(manufacturerTitle))
                .toList();
        if (list.isEmpty()) {
            System.out.println("Нет такого сувенира.");
            return;
        }

        sService.deleteSouvenir(list.get(0).getId());
    }

    public void getAllManufacturers(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите название сувенира:");
        String title = sc.nextLine();
        List<Souvenir> list = sService.getAllSouvenirs().stream().filter(s -> s.getTitle().equals(title)).toList();
        if (list.isEmpty()) {
            System.out.println("Такого сувенира нет");
            return;
        }
        List<String> ids = mService.getAllManufacturers().stream().map(Manufacturer::getTitle).toList();
        list.stream().filter(s -> ids.contains(s.getManufacturer())).forEach((s) -> System.out.println(s.getManufacturer()));
    }
}

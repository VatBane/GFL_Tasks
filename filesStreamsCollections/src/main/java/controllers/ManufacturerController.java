package controllers;

import model.Manufacturer;
import model.Souvenir;
import services.ManufacturerService;
import services.SouvenirService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManufacturerController {
    private final ManufacturerService mService;
    private final SouvenirService sService;

    public ManufacturerController() {
        mService = new ManufacturerService("storage\\manufacturers.txt");
        sService = new SouvenirService("storage\\souvenirs.txt");
    }

    /**
     * Prints all manufacturers
     */
    public void getAllManufacturers() {
        mService.getAllManufacturers().forEach(System.out::println);
    }

    /**
     * Prints all manufacturers that have the souvenirs
     * with price less than given
     */
    public void getManufacturersByPrice(Scanner sc) {
        System.out.println("Введите цену: ");
        float price = sc.nextFloat();

        List<Manufacturer> result = sService.getAllSouvenirs().stream()
                .filter(s -> s.getPrice() < price)
                .map(Souvenir::getManufacturer)
                .map(mService::getManufacturerByTitle)
                .toList();

        if (result.isEmpty()) {
            System.out.println("Таких производителей нет.");
        } else {
            result.forEach(System.out::println);
        }
    }

    /**
     * Print all manufacturers with their souvenirs
     */
    public void getManufacturersWithSouvenirs() {
        mService.getAllManufacturers().forEach(m -> {
            System.out.println("\nПроизводитель: ");
            System.out.println(m);
            System.out.println("Список товаров: ");
            sService.getSouvenirsByManufacturer(m.getTitle()).forEach(System.out::println);
        });
    }

    /**
     * Adds new manufacturer
     */
    public void createManufacturer(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите название компании производителя:");
        String title = sc.nextLine();
        System.out.println("Введите страну производителя:");
        String country = sc.nextLine();
        mService.createManufacturer(title, country);
    }

    /**
     * Changes info about some manufacturer
     */
    public void updateManufacturer(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите старое название компании:");
        String oldTitle = sc.nextLine();
        System.out.println("Введите новое название компании производителя:");
        String newTitle = sc.nextLine();
        System.out.println("Введите новую страну производителя:");
        String newCountry = sc.nextLine();
        mService.updateManufacturer(oldTitle, newTitle, newCountry);
    }

    /**
     * Deletes a manufacturer and all his souvenirs
     */
    public void deleteManufacturer(Scanner sc) {
        sc.nextLine();
        System.out.println("Введите название компании:");
        String name = sc.nextLine();
        sService.deleteSouvenirsOfManufacturer(name);
        mService.deleteManufacturer(name);
    }
}

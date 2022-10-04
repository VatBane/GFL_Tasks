package services;

import model.Manufacturer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManufacturerService {
    private final String path;
    private Map<String, Manufacturer> manufacturers;

    public ManufacturerService(String path) {
        this.path = path;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            manufacturers = stream.map(Manufacturer::fromLine).filter(Objects::nonNull).collect(Collectors.toMap(Manufacturer::getTitle, Function.identity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // GET
    public List<Manufacturer> getAllManufacturers() {
        return manufacturers.values().stream().toList();
    }

    // GET
    public Manufacturer getManufacturerByTitle(String title) {
        if (!isExist(title)) {
            System.out.println("Такого производителя нет.");
            return null;
        }
        return manufacturers.get(title);
    }

    public List<String> getManufacturersByCountry(String country) {
        return manufacturers.values().stream().filter(m -> m.getCountry().equals(country)).map(Manufacturer::getTitle).toList();
    }

    // POST
    public void createManufacturer(String name, String country) {
        if (isExist(name)) {
            System.out.println("Such a manufacturer already exists");
            return;
        }
        Manufacturer m = new Manufacturer( name, country);
        manufacturers.put(m.getTitle(), m);
        sendChanges();
    }

    // PUT
    public void updateManufacturer(String oldName, String newName, String country) {
        if (!isExist(oldName)) {
            System.out.println("Нет производителя, который вы хотите изменить.");
            return;
        }
        if (isExist(newName)) {
            System.out.println("Such a manufacturer already exists");
            return;
        }
        manufacturers.replace(oldName, new Manufacturer(newName, country));
        sendChanges();
    }

    // DELETE
    public void deleteManufacturer(String name) {
        if (!isExist(name)) {
            System.out.println("Такого производителя нет.");
            return;
        }
        manufacturers.remove(name);
        sendChanges();
    }

    private boolean isExist(String name) {
        for(Manufacturer m: manufacturers.values()) {
            if (m.getTitle().equals(name))
                return true;
        }
        return false;
    }

    private void sendChanges() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Path.of(path), StandardOpenOption.TRUNCATE_EXISTING);
            for (Manufacturer m: manufacturers.values()) {
                writer.write(m.toFile() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

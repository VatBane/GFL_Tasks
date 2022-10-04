package services;

import model.Manufacturer;
import model.Souvenir;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SouvenirService {
    private Map<Long, Souvenir> souvenirs;
    private final String path;

    public SouvenirService(String path) {
        ManufacturerService service = new ManufacturerService("storage/manufacturers.txt");
        List<Manufacturer> manufacturers = service.getAllManufacturers();
        this.path = path;
        try (Stream<String> stream = Files.lines(Paths.get(path))) {
            souvenirs = stream.map(Souvenir::fromLine)
                    .filter(Objects::nonNull)
                    .collect(Collectors.toMap(Souvenir::getId, Function.identity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Souvenir> getSouvenirsByYear() {
        return null;
    }

    /**
     * Deletes all the souvenirs by manufacturer's name
     */
    public void deleteSouvenirsOfManufacturer(String manufacturer) {
        souvenirs.entrySet().removeIf(s -> s.getValue().getManufacturer().equals(manufacturer));
        sendChanges();
    }

    /**
     * Returns list of souvenirs
     */
    public List<Souvenir> getAllSouvenirs() {
        return souvenirs.values().stream().toList();
    }

    private void sendChanges() {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Path.of(path), StandardOpenOption.TRUNCATE_EXISTING);
            for (Souvenir m: souvenirs.values()) {
                writer.write(m.toFile() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Souvenir> getSouvenirsByManufacturer(String manufacturer) {
        return souvenirs.values().stream().filter(s -> s.getManufacturer().equals(manufacturer)).toList();
    }

    public void createSouvenir(String title, String manufacturer, LocalDate date, double price) {
        Optional<Long> var = souvenirs.keySet().stream().max(Long::compare);
        long id = var.map(aLong -> aLong + 1).orElse(1L);
        Souvenir s = new Souvenir(id, title, manufacturer, date, price);
        souvenirs.put(s.getId(), s);
        sendChanges();
    }

    public void updateSouvenir(long id, String title, String manufacturer, LocalDate date, double price) {
        souvenirs.replace(id, new Souvenir(id, title, manufacturer, date, price));
        sendChanges();
    }

    public void deleteSouvenir(long id) {
        souvenirs.remove(id);
//        resetIDs();
        sendChanges();
    }
}

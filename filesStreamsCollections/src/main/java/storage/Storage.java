package storage;

import model.Manufacturer;
import model.Souvenir;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Storage {
    public static List<Souvenir> getSouvenirs() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("storage/manu.txt")));
        List<Manufacturer> manufacturers = getManufacturers(reader);

        reader = new BufferedReader(new FileReader(new File("storage/data.txt")));
        List<Souvenir> list = new ArrayList<>();

        List<String> lines = reader.lines().toList();
        for (String s: lines) {
            String[] line = s.split(",");
            list.add(new Souvenir(line[0], getSingleManufacturer(Integer.parseInt(line[1].trim()), manufacturers),
                    new SimpleDateFormat("dd-MM-yyyy").parse(line[2]), Double.parseDouble(line[3].trim())));
        }

        for (Souvenir s: list) {
            System.out.println(s);
        }

        return null;
    }

    private static List<Manufacturer> getManufacturers(BufferedReader reader) throws IOException  {
        List<Manufacturer> list = new ArrayList<>();

        List<String> lines = reader.lines().toList();
        for (String s: lines) {
            String[] line = s.split(",");
            list.add(new Manufacturer(Integer.parseInt(line[0]), line[1], line[2]));
        }

        return list;
    }

    private static Manufacturer getSingleManufacturer(int id, List<Manufacturer> manufacturers) {
        for (Manufacturer m: manufacturers) {
            if (m.getId() == id)
                return m;
        }

        return null;
    }

}

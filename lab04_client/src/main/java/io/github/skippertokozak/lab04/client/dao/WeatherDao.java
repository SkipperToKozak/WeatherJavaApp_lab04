package io.github.skippertokozak.lab04.client.dao;

import io.github.skippertokozak.lab04.client.data.Stacja;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WeatherDao implements Dao<Stacja> {
    private String pathS = "./database/skis.txt";

    @Override
    public List<Stacja> getAll() {
        List<Stacja> tempArray = new ArrayList<>();

        Path sciezkaDoPliku = Path.of(pathS);
        FileChannel channel = null;
        try {
            channel = FileChannel.open(sciezkaDoPliku);
            List<String> linie = Files.readAllLines(sciezkaDoPliku);
            linie.remove("\n");

            for (String linia : linie) {
                System.out.println(linia);
                String[] s = linia.split(" ");
                Integer id_stacji = Integer.parseInt(s[0]);
                String nazwa_stacji = s[1];
                LocalDate data_pomiaru = LocalDate.parse(s[2]);
                Integer godzina_pomiaru = Integer.parseInt(s[3]);
                Float temperatura = Float.parseFloat(s[4]);
                Integer predkosc_wiatru = Integer.parseInt(s[5]);
                Integer kierunek_wiatru = Integer.parseInt(s[6]);
                Float wilgotnosc_wzgledna = Float.parseFloat(s[7]);
                Float suma_opadu = Float.parseFloat(s[8]);
                Float cisnienie = Float.parseFloat(s[9]);

                tempArray.add(new Stacja(id_stacji, nazwa_stacji, data_pomiaru,
                        godzina_pomiaru, temperatura, predkosc_wiatru,
                        kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie));
                //System.out.println(linia);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (channel != null) {
                    channel.close(); // Ręczne zamknięcie kanału pliku
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tempArray;
    }

    @Override
    public void update(Stacja stacja) {

    }

    @Override
    public void delete(Stacja stacja) {

    }

    @Override
    public Optional<Stacja> get(Integer id) {
        return Optional.empty();
    }
}

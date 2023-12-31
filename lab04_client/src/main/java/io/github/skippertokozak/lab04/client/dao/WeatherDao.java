package io.github.skippertokozak.lab04.client.dao;

import com.google.gson.Gson;
import io.github.skippertokozak.lab04.client.data.Measurement;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class WeatherDao implements Dao<Measurement> {
    private String pathS = "./weather_data.txt";
    String apiURL = "https://danepubliczne.imgw.pl/api/data/synop";
    private Measurement[] downloadedData;
    private List<Measurement> localData = new ArrayList<>();



    @Override
    public List<Measurement> getAll() {


//        Path sciezkaDoPliku = Path.of(pathS);
//        FileChannel channel = null;
//        try {
//            channel = FileChannel.open(sciezkaDoPliku);
//            List<String> linie = Files.readAllLines(sciezkaDoPliku);
//            linie.remove("\n");
//            Gson g = new Gson();
//
//            for (String linia : linie) {
//
//                Measurement[] measurements = g.fromJson(linia, Measurement[].class);
//                List<Measurement> tempArray = new ArrayList<>(Arrays.asList(measurements));
//                local_data.addAll(tempArray);
////                System.out.println(linia);
////                String[] s = linia.split(" ");
////                Integer id_stacji = Integer.parseInt(s[0]);
////                String nazwa_stacji = s[1];
////                String data_pomiaru = s[2];
////                Integer godzina_pomiaru = Integer.parseInt(s[3]);
////                Float temperatura = Float.parseFloat(s[4]);
////                Integer predkosc_wiatru = Integer.parseInt(s[5]);
////                Integer kierunek_wiatru = Integer.parseInt(s[6]);
////                Float wilgotnosc_wzgledna = Float.parseFloat(s[7]);
////                Float suma_opadu = Float.parseFloat(s[8]);
////                Float cisnienie = Float.parseFloat(s[9]);
//
////                tempArray.add(new Measurement(id_stacji, nazwa_stacji, data_pomiaru,
////                        godzina_pomiaru, temperatura, predkosc_wiatru,
////                        kierunek_wiatru, wilgotnosc_wzgledna, suma_opadu, cisnienie));
//                //System.out.println(linia);
//            }
//            for (Measurement m : local_data){
//                System.out.println(m.toString());
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if (channel != null) {
//                    channel.close(); // Ręczne zamknięcie kanału pliku
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return localData;

    }

    @Override
    public void update(Measurement pomiar) {

    }

    @Override
    public void delete(Measurement pomiar) {

    }

    @Override
    public Optional<Measurement> get(Integer id) {
        return Optional.ofNullable((localData.get(id)));
    }
    public List<Measurement> getWeatherList(Integer id){
        List<Measurement> list = new ArrayList<>();
        for (Measurement m : getAll()){
            if (Objects.equals(m.getId_stacji(), id)){
                list.add(m);
            }
        }
        return list;


    }
    public void expand(String string){

        Path path = Path.of(pathS);

        try {
            // Sprawdzamy, czy plik istnieje, jeśli nie, to go tworzymy
            if (!Files.exists(path)) {
                Files.createFile(path);
            }

            // Tworzymy obiekt z tekstem do zapisania w pliku
            byte[] lineBytes = (string + System.lineSeparator()).getBytes();

            // Dopisujemy linię do pliku
            Files.write(path, lineBytes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void loadLocalData() {

        Path path = Path.of(pathS);
        FileChannel channel = null;

        try {
            if(Files.size(Path.of(pathS))!= 0) {


                channel = FileChannel.open(path);
                List<String> linie = Files.readAllLines(path);
                linie.remove("\n");
                Gson g = new Gson();

                for (String linia : linie) {

                    Measurement[] measurements = g.fromJson(linia, Measurement[].class);
                    addToLocalDate(measurements);
                }
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

    }
    public void checkIfUpToDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            loadLocalData();

        // Parsujemy stringa do obiektu LocalDate
        if(localData.size() == 0){

            System.out.println("Nie znaleziono danych lokalnych\nRozpoczynam pobieranie danych");
            addToLocalDate(downloadData());

        }

        LocalDate lastUpdate = LocalDate.parse(localData.get(localData.size()-1).getData_pomiaru(), formatter);
        if (!lastUpdate.equals(LocalDate.now())){

            System.out.println("Dane nie są aktualne");
            addToLocalDate(downloadData());

        }
        else {
            System.out.println("Dane są aktualne");
        }


    }
    public Measurement[] downloadData(){
        Gson g = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(getURI(apiURL))
                .header("Content-Type", "application/json")
                .build();
        try {
            HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                expand(responseBody);
                Measurement[] stations = g.fromJson(responseBody, Measurement[].class);
                return stations;
            } else {
                System.out.println("Failed to fetch data. Status code: " + response.statusCode());
                return null;
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }
        private static URI getURI(String url) {
            try {
                return new URI(url);
            } catch (URISyntaxException e) {
                throw new IllegalArgumentException("Invalid URL: " + url, e);         }
        }
        public void addToLocalDate(Measurement[] temp){
            localData.addAll(Arrays.asList(temp));
        }


//            URL url = new URL("https://danepubliczne.imgw.pl/api/data/synop");
//            InputStreamReader reader = new InputStreamReader(url.openStream());
//            Gson gson = new Gson();
//            PomiarExternal[] data =  gson.fromJson(reader, PomiarExternal[].class);
//            return data;
    }


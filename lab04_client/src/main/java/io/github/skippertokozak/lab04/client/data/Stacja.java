package io.github.skippertokozak.lab04.client.data;

import java.time.LocalDate;



public class Stacja {
    private Integer id_stacji, godzina_pomiaru, predkosc_wiatru, kierunek_wiatru;
    private LocalDate data_pomiaru;
    private String nazwa_stacji;
    private Float temperatura, wilgotnosc_wzgledna, suma_opadu, cisnienie;

    public Stacja(Integer id_stacji, String nazwa_stacji, LocalDate data_pomiaru, Integer godzina_pomiaru, Float temperatura, Integer predkosc_wiatru, Integer kierunek_wiatru, Float wilgotnosc_wzgledna, Float suma_opadu, Float cisnienie) {
        this.id_stacji = id_stacji;
        this.nazwa_stacji = nazwa_stacji;
        this.data_pomiaru = data_pomiaru;
        this.godzina_pomiaru = godzina_pomiaru;
        this.temperatura = temperatura;
        this.predkosc_wiatru = predkosc_wiatru;
        this.kierunek_wiatru = kierunek_wiatru;
        this.wilgotnosc_wzgledna = wilgotnosc_wzgledna;
        this.suma_opadu = suma_opadu;
        this.cisnienie = cisnienie;
    }
}

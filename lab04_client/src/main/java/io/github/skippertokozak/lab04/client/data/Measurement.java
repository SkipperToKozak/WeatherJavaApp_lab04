package io.github.skippertokozak.lab04.client.data;


public class Measurement {
    private Integer id_stacji, godzina_pomiaru, predkosc_wiatru, kierunek_wiatru;
    private String stacja, data_pomiaru;
    private Double temperatura, wilgotnosc_wzgledna, suma_opadu, cisnienie;


    public Measurement() {
        // No-args constructor
    }

    public Measurement(Integer id_stacji, String stacja,
                       String data_pomiaru, Integer godzina_pomiaru,
                       Double temperatura, Integer predkosc_wiatru,
                       Integer kierunek_wiatru, Double wilgotnosc_wzgledna,
                       Double suma_opadu, Double cisnienie) {

        this.id_stacji = id_stacji;
        this.stacja = stacja;
        this.data_pomiaru = data_pomiaru;
        this.godzina_pomiaru = godzina_pomiaru;
        this.temperatura = temperatura;
        this.predkosc_wiatru = predkosc_wiatru;
        this.kierunek_wiatru = kierunek_wiatru;
        this.wilgotnosc_wzgledna = wilgotnosc_wzgledna;
        this.suma_opadu = suma_opadu;
        this.cisnienie = cisnienie;
    }

    @Override
    public String toString() {
        return "Measurement{" +
                "id_stacji=" + id_stacji +
                ", godzina_pomiaru=" + godzina_pomiaru +
                ", predkosc_wiatru=" + predkosc_wiatru +
                ", kierunek_wiatru=" + kierunek_wiatru +
                ", data_pomiaru=" + data_pomiaru +
                ", nazwa_stacji='" + stacja + '\'' +
                ", temperatura=" + temperatura +
                ", wilgotnosc_wzgledna=" + wilgotnosc_wzgledna +
                ", suma_opadu=" + suma_opadu +
                ", cisnienie=" + cisnienie +
                '}';
    }
    public String getData_pomiaru() {
        return data_pomiaru;
    }

    public Integer getId_stacji() {
        return id_stacji;
    }

    public Integer getPredkosc_wiatru() {
        return predkosc_wiatru;
    }

    public Integer getKierunek_wiatru() {
        return kierunek_wiatru;
    }

    public String getStacja() {
        return stacja;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public Double getWilgotnosc_wzgledna() {
        return wilgotnosc_wzgledna;
    }

    public Double getSuma_opadu() {
        return suma_opadu;
    }

    public Double getCisnienie() {
        return cisnienie;
    }
}

package io.github.skippertokozak.lab04.gui.plots;

import io.github.skippertokozak.lab04.client.data.Measurement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYDotRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.util.ArrayList;
import java.util.List;

public class WindDirectionPlot {
    private JFreeChart chart;
    private List<Measurement> list;
    public WindDirectionPlot(List<Measurement> list){
        this.list = list;
        XYDataset dataset = createDataset();

        chart = ChartFactory.createPolarChart(
                "Wykres kierunku i siły wiatru",     // Tytuł wykresu
                dataset,              // Dane
                true,
                true,
                false
        );
        // Dodajemy TooltipGenerator do punktów
        PolarPlot plot = (PolarPlot) chart.getPlot();
        NumberAxis axis = (NumberAxis) plot.getAxis();
        // Ustawiamy TooltipGenerator dla punktów
        plot.setAngleTickUnit(new NumberTickUnit(15));
        axis.setTickUnit(new NumberTickUnit(1));

    }

    private XYDataset createDataset() {

        XYSeries series = new XYSeries("Prędkość i kierunek wiatru");
        // Dodajemy dane do serii
        for (Measurement m : list
        ) {
            if(m.getKierunek_wiatru()!= null && m.getPredkosc_wiatru()!= null) {
                series.add((double) m.getKierunek_wiatru(), m.getPredkosc_wiatru());
            }
        }


        // Tworzymy kolekcję serii danych
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series);
        return dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }
}


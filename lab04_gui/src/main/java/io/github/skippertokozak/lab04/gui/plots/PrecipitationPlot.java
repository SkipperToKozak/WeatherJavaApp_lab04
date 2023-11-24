package io.github.skippertokozak.lab04.gui.plots;

import io.github.skippertokozak.lab04.client.data.Measurement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class PrecipitationPlot {
    private JFreeChart chart;
    public PrecipitationPlot(List<Measurement> list){
        CategoryDataset dataset = createDataset(list);

        chart = ChartFactory.createBarChart(
                "Wykres sumy opadu",     // Tytuł wykresu
                "Data",               // Podpis osi X
                "Suma opadu (mm)",   // Podpis osi Y
                dataset,              // Dane
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

    }

    private CategoryDataset createDataset(List<Measurement> list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Measurement m : list
        ) {

            dataset.addValue(m.getSuma_opadu(),"Opady", m.getData_pomiaru());
        }


        return dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }
}

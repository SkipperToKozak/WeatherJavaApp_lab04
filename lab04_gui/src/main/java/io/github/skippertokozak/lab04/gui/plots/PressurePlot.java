package io.github.skippertokozak.lab04.gui.plots;

import io.github.skippertokozak.lab04.client.data.Measurement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import java.util.List;

public class PressurePlot {
    private JFreeChart chart;
    public PressurePlot(List<Measurement> list){
        CategoryDataset dataset = createDataset(list);

        chart = ChartFactory.createBarChart(
                "Wykres ciśnienia atmosferycznego",     // Tytuł wykresu
                "Data",               // Podpis osi X
                "Ciśnienie (hPa)",   // Podpis osi Y
                dataset,              // Dane
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();

        // Ustaw skalę początkową na 900
        rangeAxis.setRange(900.0, rangeAxis.getUpperBound());

    }

    private CategoryDataset createDataset(List<Measurement> list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Measurement m : list
        ) {
            if(m.getCisnienie()!= null) {
                dataset.addValue(m.getCisnienie(), "Ciśnienie", m.getData_pomiaru());
            }
        }


        return dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }
}

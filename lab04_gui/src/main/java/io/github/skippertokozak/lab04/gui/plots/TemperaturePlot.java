package io.github.skippertokozak.lab04.gui.plots;

import io.github.skippertokozak.lab04.client.data.Measurement;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TemperaturePlot {
    private JFreeChart chart;
    public TemperaturePlot(List<Measurement> list){
        CategoryDataset dataset = createDataset(list);

        chart = ChartFactory.createBarChart(
                "Wykres temperatury",     // Tytuł wykresu
                "Data",               // Podpis osi X
                "Temperatura (°C)",   // Podpis osi Y
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

            dataset.addValue(m.getTemperatura(),"Temperatura", m.getData_pomiaru());
        }


        return dataset;
    }

    public JFreeChart getChart() {
        return chart;
    }
}

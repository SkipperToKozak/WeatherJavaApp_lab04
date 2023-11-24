package io.github.skippertokozak.lab04.gui.window;

import io.github.skippertokozak.lab04.client.data.Measurement;
import io.github.skippertokozak.lab04.client.ClientRun;
import io.github.skippertokozak.lab04.gui.menu.PanelMenu;
import io.github.skippertokozak.lab04.gui.plots.TemperaturePlot;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WindowManager {
    private List<Measurement> stationDataList;

    public WindowManager(ClientRun clientRun) {
        JFrame window = new JFrame("Weather App");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelMenu panelMenu = new PanelMenu(clientRun);
        window.setContentPane(panelMenu);

        window.setMinimumSize(new Dimension(800, 400));
        window.pack();
        window.setVisible(true);

        creatingStationData(clientRun, 12295);


    }

    private void creatingStationData(ClientRun clientRun, Integer id) {
        stationDataList = clientRun.getWeatherDao().getWeatherList(id);
    }

    private ChartPanel weatherChart() {
        TemperaturePlot temperaturePlot = new TemperaturePlot(stationDataList);
        ChartPanel chartPanel = new ChartPanel(temperaturePlot.getChart());
        chartPanel.setPreferredSize(new Dimension(200, 300));
        return chartPanel;
    }
}

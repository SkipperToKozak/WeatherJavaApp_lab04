package io.github.skippertokozak.lab04.gui.menu;


import io.github.skippertokozak.lab04.client.ClientRun;
import io.github.skippertokozak.lab04.client.data.Measurement;
import io.github.skippertokozak.lab04.gui.plots.*;
import org.jfree.chart.ChartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

public class PanelMenu extends JPanel {

    private JPanel centerPanel;
    private JScrollPane scrollPane;
    private List<Measurement> stationDataList;
    private List<Measurement> allStationsDataList;
    private Integer id;
    private String stationName;
    private JTable tablePanel;
    private ChartPanel chartPanel;
    private JLabel errLbl;
    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public PanelMenu(ClientRun clientRun) {

        allStationsDataList = clientRun.getWeatherDao().getAll();
        id = allStationsDataList.get(0).getId_stacji();
        stationName = allStationsDataList.get(0).getStacja();

        creatingStationData(clientRun, id);
        setLayout(new BorderLayout(0, 0));

        JPanel westPanel = new JPanel();
        westPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(westPanel, BorderLayout.WEST);
        GridBagLayout gbl_westPanel = new GridBagLayout();
        gbl_westPanel.columnWidths = new int[]{0, 0};
        gbl_westPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_westPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_westPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        westPanel.setLayout(gbl_westPanel);




        JLabel stationNameLabel = new JLabel( id + " - " + stationName);
        stationNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_StationName_1 = new GridBagConstraints();
        gbc_StationName_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_StationName_1.insets = new Insets(0, 0, 5, 0);
        gbc_StationName_1.gridx = 0;
        gbc_StationName_1.gridy = 0;
        westPanel.add(stationNameLabel, gbc_StationName_1);

        JButton temperatureBtn = new JButton("Temperatura");
        GridBagConstraints gbc_temperatureBtn = new GridBagConstraints();
        gbc_temperatureBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_temperatureBtn.insets = new Insets(0, 0, 5, 0);
        gbc_temperatureBtn.gridx = 0;
        gbc_temperatureBtn.gridy = 2;
        westPanel.add(temperatureBtn, gbc_temperatureBtn);

        temperatureBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                creatingStationData(clientRun, id);
                centerPanel.removeAll();
                try {
                    errLbl.setText("");
                    chartPanel = newTemperatureChart();
            }
                catch (Exception er){
                errLbl.setText("Dane wykresu są nieprawidłowe");

            }
                centerPanel.add(chartPanel);
                scrollPane.revalidate();
            }
        });

        JButton windSpeedBtn = new JButton("Prędkość wiatru");
        GridBagConstraints gbc_windSpeedBtn = new GridBagConstraints();
        gbc_windSpeedBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_windSpeedBtn.insets = new Insets(0, 0, 5, 0);
        gbc_windSpeedBtn.gridx = 0;
        gbc_windSpeedBtn.gridy = 3;
        westPanel.add(windSpeedBtn, gbc_windSpeedBtn);

        windSpeedBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                try {
                    errLbl.setText("");
                    tablePanel = newWindSpeed();
            }
                catch (Exception er){
                errLbl.setText("Dane wykresu są nieprawidłowe");

            }

                centerPanel.add(tablePanel);
                scrollPane.revalidate();
            }
        });

        JButton windDirectionBtn = new JButton("Kierunek wiatru");
        GridBagConstraints gbc_windDirectionBtn = new GridBagConstraints();
        gbc_windDirectionBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_windDirectionBtn.insets = new Insets(0, 0, 5, 0);
        gbc_windDirectionBtn.gridx = 0;
        gbc_windDirectionBtn.gridy = 4;
        westPanel.add(windDirectionBtn, gbc_windDirectionBtn);

        windDirectionBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                try {
                    errLbl.setText("");
                    chartPanel = newWindDirection();
            }
                catch (Exception er){
                errLbl.setText("Dane wykresu są nieprawidłowe");

            }
                centerPanel.add(chartPanel);
                scrollPane.revalidate();
            }
        });

        JButton humidityBtn = new JButton("Wilgotność względna");
        GridBagConstraints gbc_humidityBtn = new GridBagConstraints();
        gbc_humidityBtn.insets = new Insets(0, 0, 5, 0);
        gbc_humidityBtn.gridx = 0;
        gbc_humidityBtn.gridy = 5;
        westPanel.add(humidityBtn, gbc_humidityBtn);
        humidityBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                try {
                    errLbl.setText("");
                    chartPanel = newHumidity();
            }
                catch (Exception er){
                errLbl.setText("Dane wykresu są nieprawidłowe");

            }
                centerPanel.add(chartPanel);
                scrollPane.revalidate();
            }
        });

        JButton precipitationBtn = new JButton("Suma opadu");
        GridBagConstraints gbc_precipitationBtn = new GridBagConstraints();
        gbc_precipitationBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_precipitationBtn.insets = new Insets(0, 0, 5, 0);
        gbc_precipitationBtn.gridx = 0;
        gbc_precipitationBtn.gridy = 6;
        westPanel.add(precipitationBtn, gbc_precipitationBtn);

        precipitationBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                try {
                    errLbl.setText("");
                    chartPanel = newPrecipitation();
            }
                catch (Exception er){
                errLbl.setText("Dane wykresu są nieprawidłowe");

            }
                centerPanel.add(chartPanel);
                scrollPane.revalidate();
            }
        });

        JButton pressureBtn = new JButton("Ciśnienie");
        GridBagConstraints gbc_pressureBtn = new GridBagConstraints();
        gbc_pressureBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_pressureBtn.insets = new Insets(0, 0, 5, 0);
        gbc_pressureBtn.anchor = GridBagConstraints.SOUTH;
        gbc_pressureBtn.gridx = 0;
        gbc_pressureBtn.gridy = 7;
        westPanel.add(pressureBtn, gbc_pressureBtn);

        pressureBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                centerPanel.removeAll();
                try {
                    errLbl.setText("");
                    chartPanel = newPressure();
                }
                catch (Exception er){
                    errLbl.setText("Dane wykresu są nieprawidłowe");

                }
                centerPanel.add(chartPanel);
                scrollPane.revalidate();
            }
        });

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);

        JLabel errorLabel = new JLabel("");
        errorLabel.setForeground(new Color(255, 0, 0));
        southPanel.add(errorLabel);
        errLbl = errorLabel;

        JPanel eastPanel = new JPanel();
        add(eastPanel, BorderLayout.EAST);
        GridBagLayout gbl_eastPanel = new GridBagLayout();
        gbl_eastPanel.columnWidths = new int[]{29, 0};
        gbl_eastPanel.rowHeights = new int[]{21, 0};
        gbl_eastPanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_eastPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        eastPanel.setLayout(gbl_eastPanel);


        JComboBox comboBox = new JComboBox();
        DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel();
        comboBoxModel.addElement(allStationsDataList.get(0).getStacja());
        for (int i = 1; (i<allStationsDataList.size()) && (!allStationsDataList.get(0).getId_stacji().equals(allStationsDataList.get(i).getId_stacji()));i++){
            comboBoxModel.addElement(allStationsDataList.get(i).getStacja());
        }
        comboBox.setModel(comboBoxModel);


        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 0;
        eastPanel.add(comboBox, gbc_comboBox);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                int selectedIndex = comboBox.getSelectedIndex();
                if (selectedIndex != -1) {
                    id = allStationsDataList.get(selectedIndex).getId_stacji();
                    stationName = allStationsDataList.get(selectedIndex).getStacja();
                    creatingStationData(clientRun, id);
                    centerPanel.remove(chartPanel);
                    chartPanel = newTemperatureChart();
                    centerPanel.add(chartPanel);
                    stationNameLabel.setText(id+" - "+stationName);

                }
            }
        });

        centerPanel = new JPanel();
        centerPanel.setBackground(Color.BLACK);
        centerPanel.setLayout(new CardLayout(0, 0));

        scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);


        JPanel northPanel = new JPanel();
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, new Color(0, 0, 0)));
        add(northPanel, BorderLayout.NORTH);

        chartPanel = newTemperatureChart();
        centerPanel.add(chartPanel);

        //window.setSize(new Dimension(800, 400));
        scrollPane.setViewportView(centerPanel);




    }

    private void creatingStationData(ClientRun clientRun, Integer id) {
        stationDataList = clientRun.getWeatherDao().getWeatherList(id);
    }

    private ChartPanel newTemperatureChart() {
        TemperaturePlot temperaturePlot = new TemperaturePlot(stationDataList);
        ChartPanel chartPanel = new ChartPanel(temperaturePlot.getChart());
        chartPanel.setPreferredSize(new Dimension(200, 300));
        return chartPanel;
    }
    private JTable newWindSpeed(){
        WindTable windTable = new WindTable(stationDataList);
        JTable jTable = windTable.getTable();
        jTable.setPreferredSize(new Dimension(200,300));
        return jTable;
    }
    private ChartPanel newWindDirection(){
        WindDirectionPlot windDirectionPlot = new WindDirectionPlot(stationDataList);
        ChartPanel chartPanel = new ChartPanel(windDirectionPlot.getChart());
        chartPanel.setPreferredSize(new Dimension(200, 300));
        return chartPanel;
    }
    private ChartPanel newHumidity(){
        HumidityPlot humidityPlot = new HumidityPlot(stationDataList);
        ChartPanel chartPanel = new ChartPanel(humidityPlot.getChart());
        chartPanel.setPreferredSize(new Dimension(200, 300));
        return chartPanel;
    }
    private ChartPanel newPrecipitation(){
        PrecipitationPlot precipitationPlot = new PrecipitationPlot(stationDataList);
        ChartPanel chartPanel = new ChartPanel(precipitationPlot.getChart());
        chartPanel.setPreferredSize(new Dimension(200, 300));
        return chartPanel;
    }
    private ChartPanel newPressure(){
        PressurePlot pressurePlot = new PressurePlot(stationDataList);
        ChartPanel chartPanel = new ChartPanel(pressurePlot.getChart());
        chartPanel.setPreferredSize(new Dimension(200, 300));
        return chartPanel;
    }

}

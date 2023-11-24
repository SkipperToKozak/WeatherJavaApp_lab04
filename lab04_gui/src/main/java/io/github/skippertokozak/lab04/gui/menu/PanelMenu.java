package io.github.skippertokozak.lab04.gui.menu;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLayeredPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;

public class PanelMenu extends JPanel {

    private static final long serialVersionUID = 1L;

    /**
     * Create the panel.
     */
    public PanelMenu() {
        setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(panel, BorderLayout.WEST);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JButton temperatureBtn = new JButton("Temperatura");
        temperatureBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });

        JLabel StationName_1 = new JLabel("ID - NAZWA");
        StationName_1.setHorizontalAlignment(SwingConstants.CENTER);
        GridBagConstraints gbc_StationName_1 = new GridBagConstraints();
        gbc_StationName_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_StationName_1.insets = new Insets(0, 0, 5, 0);
        gbc_StationName_1.gridx = 0;
        gbc_StationName_1.gridy = 0;
        panel.add(StationName_1, gbc_StationName_1);
        GridBagConstraints gbc_temperatureBtn = new GridBagConstraints();
        gbc_temperatureBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_temperatureBtn.insets = new Insets(0, 0, 5, 0);
        gbc_temperatureBtn.gridx = 0;
        gbc_temperatureBtn.gridy = 2;
        panel.add(temperatureBtn, gbc_temperatureBtn);

        JButton windSpeedBtn = new JButton("Prędkość wiatru");
        GridBagConstraints gbc_windSpeedBtn = new GridBagConstraints();
        gbc_windSpeedBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_windSpeedBtn.insets = new Insets(0, 0, 5, 0);
        gbc_windSpeedBtn.gridx = 0;
        gbc_windSpeedBtn.gridy = 3;
        panel.add(windSpeedBtn, gbc_windSpeedBtn);

        JButton windDirectionBtn = new JButton("Kierunek wiatru");
        GridBagConstraints gbc_windDirectionBtn = new GridBagConstraints();
        gbc_windDirectionBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_windDirectionBtn.insets = new Insets(0, 0, 5, 0);
        gbc_windDirectionBtn.gridx = 0;
        gbc_windDirectionBtn.gridy = 4;
        panel.add(windDirectionBtn, gbc_windDirectionBtn);

        JButton humidityBtn = new JButton("Wilgotność względna");
        GridBagConstraints gbc_humidityBtn = new GridBagConstraints();
        gbc_humidityBtn.insets = new Insets(0, 0, 5, 0);
        gbc_humidityBtn.gridx = 0;
        gbc_humidityBtn.gridy = 5;
        panel.add(humidityBtn, gbc_humidityBtn);

        JButton precipitationBtn = new JButton("Suma opadu");
        GridBagConstraints gbc_precipitationBtn = new GridBagConstraints();
        gbc_precipitationBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_precipitationBtn.insets = new Insets(0, 0, 5, 0);
        gbc_precipitationBtn.gridx = 0;
        gbc_precipitationBtn.gridy = 6;
        panel.add(precipitationBtn, gbc_precipitationBtn);

        JButton pressureBtn = new JButton("Ciśnienie");
        GridBagConstraints gbc_pressureBtn = new GridBagConstraints();
        gbc_pressureBtn.fill = GridBagConstraints.HORIZONTAL;
        gbc_pressureBtn.insets = new Insets(0, 0, 5, 0);
        gbc_pressureBtn.anchor = GridBagConstraints.SOUTH;
        gbc_pressureBtn.gridx = 0;
        gbc_pressureBtn.gridy = 7;
        panel.add(pressureBtn, gbc_pressureBtn);

        JLabel errorLabel = new JLabel("errorLabel");
        errorLabel.setForeground(new Color(255, 0, 0));
        GridBagConstraints gbc_errorLabel = new GridBagConstraints();
        gbc_errorLabel.gridx = 0;
        gbc_errorLabel.gridy = 9;
        panel.add(errorLabel, gbc_errorLabel);

        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
        add(panel_1, BorderLayout.EAST);
        GridBagLayout gbl_panel_1 = new GridBagLayout();
        gbl_panel_1.columnWidths = new int[]{29, 0};
        gbl_panel_1.rowHeights = new int[]{21, 0};
        gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
        gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
        panel_1.setLayout(gbl_panel_1);

        JComboBox comboBox = new JComboBox();
        GridBagConstraints gbc_comboBox = new GridBagConstraints();
        gbc_comboBox.anchor = GridBagConstraints.NORTHWEST;
        gbc_comboBox.gridx = 0;
        gbc_comboBox.gridy = 0;
        panel_1.add(comboBox, gbc_comboBox);

        JPanel centerPanel = new JPanel();
        add(centerPanel, BorderLayout.CENTER);
        centerPanel.setLayout(new CardLayout(0, 0));

        JPanel southPanel = new JPanel();
        add(southPanel, BorderLayout.SOUTH);

        JPanel northPanel = new JPanel();
        northPanel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
        add(northPanel, BorderLayout.NORTH);

    }
}

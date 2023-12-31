package io.github.skippertokozak.lab04.gui.plots;

import io.github.skippertokozak.lab04.client.data.Measurement;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class WindTable {
    private JTable windTable;
    public WindTable(List<Measurement> list){
        JTable table = new JTable();
        ArrayList<Object[]> tableDataList = new ArrayList<>();
        tableDataList.add(new Object[]{"PRĘDKOŚĆ WIATRU","KIERUNEK WIATRU", "DATA POMIARU"});
        for (Measurement m : list){
            tableDataList.add(new Object[]{m.getPredkosc_wiatru(),m.getKierunek_wiatru(), m.getData_pomiaru()});
        }

        Object[][] tableData = new Object[tableDataList.size()][];
        for (int i = 0; i < tableDataList.size(); i++) {
            tableData[i] = tableDataList.get(i);
        }
        // Nazwy kolumn
        String[] columnNames = {"Prędkość wiatru", "Kierunek wiatru", "Data pomiaru"};

        // Tworzymy model danych dla tabeli
        DefaultTableModel tableModel = new DefaultTableModel(tableData, columnNames);


        // Tworzymy tabelę na podstawie modelu danych
        windTable = new JTable(tableModel);
        windTable.setDefaultEditor(Object.class, null);
        table.setPreferredSize(new Dimension(200, 300));

    }

    private CategoryDataset createDataset(List<Measurement> list) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (Measurement m : list
        ) {

            dataset.addValue(m.getPredkosc_wiatru(),"Prędkość wiatru", m.getData_pomiaru());
        }


        return dataset;
    }

    public JTable getTable() {
        return windTable;
    }
}

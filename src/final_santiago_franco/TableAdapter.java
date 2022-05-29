/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_santiago_franco;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class TableAdapter {

    private DefaultTableModel defaultTableModel;

    public TableAdapter() {
        defaultTableModel = new DefaultTableModel();
    }

    public void setModel(JTable tableModel) {
        tableModel.setModel(defaultTableModel);
    }

    public void fillList(ArrayList<Hero> herosArray, String route) throws FileNotFoundException, IOException {
        String text;
        herosArray.clear();

        FileReader fileReader = new FileReader(route);
        BufferedReader bufferReader = new BufferedReader(fileReader);

        while ((text = bufferReader.readLine()) != null) {
            String points[] = text.split(";");

            herosArray.add(new Hero(
                    points[0],
                    Integer.parseInt(points[1]),
                    Integer.parseInt(points[2]),
                    Integer.parseInt(points[3]),
                    Integer.parseInt(points[4]),
                    Integer.parseInt(points[5]),
                    Integer.parseInt(points[6]),
                    Integer.parseInt(points[7])
            ));
        }
    }

    public void fillTable(ArrayList<Hero> herosList) {

    }

    public void generateResume(ArrayList<Hero> herosList) {

    }

}

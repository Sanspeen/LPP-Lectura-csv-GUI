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

    public void setTableModel(JTable tableModel) {
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

    public void fillHeader() {
        Object headers[] = {"Nombre", "Vida", "Aguante", "Ataque", "Defensa", "Presición", "Evasión", "Suma", "¿Es fuerte?"};
        defaultTableModel.setColumnIdentifiers(headers);
    }

    public void fillTable(ArrayList<Hero> herosList) {
        Object[] columns = new Object[defaultTableModel.getColumnCount()];
        defaultTableModel.setRowCount(0);
        for (Hero hero : herosList) {
            columns[0] = hero.getName();
            columns[1] = hero.getHealthPoints();
            columns[2] = hero.getResistencePoints();
            columns[3] = hero.getAtackPoints();
            columns[4] = hero.getDefensePoints();
            columns[5] = hero.getAccuracyPoints();
            columns[6] = hero.getEscapePoints();
            columns[7] = hero.getTotal();

            if (herosList.get(herosList.size() - 1).isStrong()) {
                columns[8] = "¡Es fuerte!";
            } else {
                columns[8] = "No es fuerte";
            }

            defaultTableModel.addRow(columns);
        }
    }

    public String generateResume(ArrayList<Hero> herosList) {
        //Determinate the hero with majority of HP.
        Hero majorityHPHero = new Hero("", 0, 0, 0, 0, 0, 0, 0);

        for (int i = 0; i < herosList.size(); i++) {
            if (majorityHPHero.getHealthPoints() < herosList.get(i).getHealthPoints()) {
                majorityHPHero = herosList.get(i);
            }
        }

        //Get average of resistance.
        int summation = 0;
        for (int i = 0; i < herosList.size(); i++) {
            summation += herosList.get(i).getResistencePoints();
        }

        double resistenceAvg = summation / herosList.size();

        //Get average where their name begin with C word.
        ArrayList<Hero> CHeros = new ArrayList<>();

        //Fill the array jut with Heros which their name inits with "C" word.
        for (int i = 0; i < herosList.size(); i++) {
            char initialNameWord = herosList.get(i).getName().charAt(0);
            if (initialNameWord == 'C' || initialNameWord == 'c') {
                CHeros.add(herosList.get(i));
            }
        }

        int summationDefenseCHeros = 0;
        for (int i = 0; i < CHeros.size(); i++) {
            summationDefenseCHeros += CHeros.get(i).getDefensePoints();
        }

        double defenseCHerosAvg = summationDefenseCHeros / CHeros.size();

        return  "<html><p>Resultados: <br><br>"
                + "-> Heroe con mas HP: " + majorityHPHero.getName() + "." + "<br><br>"
                + "-> Promedio de aguante: " + resistenceAvg + " puntos de aguante." + "<br><br>"
                + "-> Promedio de defensa de heroes que comienzan con C: " + defenseCHerosAvg + " puntos de defensa." + "</html>";
    }

}

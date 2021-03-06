/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_santiago_franco;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class MainJFrame extends javax.swing.JFrame {

    DefaultTableModel tableModel;

    ArrayList<Hero> herosArray = new ArrayList<>();

    private TableAdapter tableAdapter;

    private void upload(String route, ArrayList<Hero> herosArray) {
        try {
            String text;
            Object headers[] = {"Nombre", "Vida", "Aguante", "Ataque", "Defensa", "Presición", "Evasión", "Suma", "¿Es fuerte?"};
            tableModel = new DefaultTableModel(headers, 0);
            Object[] heros = new Object[9];
            herosArray.clear();

            if (true) {
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

                    //Separate in function.
                    String strongMessage;
                    if (herosArray.get(herosArray.size() - 1).isStrong()) {
                        strongMessage = "¡Es fuerte!";
                    } else {
                        strongMessage = "No es fuerte";
                    }

                    //Resume in a cicle.
                    heros[0] = points[0];
                    heros[1] = points[1];
                    heros[2] = points[2];
                    heros[3] = points[3];
                    heros[4] = points[4];
                    heros[5] = points[5];
                    heros[6] = points[6];
                    heros[7] = points[7];
                    heros[8] = strongMessage;

                    tableModel.addRow(heros);
                }
                tblHeros.setModel(tableModel);
            }
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    private void generateResume() {

        //Determinate the hero with majority of HP.
        Hero majorityHPHero = new Hero("", 0, 0, 0, 0, 0, 0, 0);

        for (int i = 0; i < herosArray.size(); i++) {
            if (majorityHPHero.getHealthPoints() < herosArray.get(i).getHealthPoints()) {
                majorityHPHero = herosArray.get(i);
            }
        }

        //Get average of resistance.
        int summation = 0;
        for (int i = 0; i < herosArray.size(); i++) {
            summation += herosArray.get(i).getResistencePoints();
        }

        double resistenceAvg = summation / herosArray.size();

        //Get average where their name begin with C word.
        ArrayList<Hero> CHeros = new ArrayList<>();

        //Fill the array jut with Heros which their name inits with "C" word.
        for (int i = 0; i < herosArray.size(); i++) {
            char initialNameWord = herosArray.get(i).getName().charAt(0);
            if (initialNameWord == 'C' || initialNameWord == 'c') {
                CHeros.add(herosArray.get(i));
            }
        }

        int summationDefenseCHeros = 0;
        for (int i = 0; i < CHeros.size(); i++) {
            summationDefenseCHeros += CHeros.get(i).getDefensePoints();
        }

        double defenseCHerosAvg = summationDefenseCHeros / CHeros.size();

        lblStats.setText("<html><p>Resultados: <br><br>"
                + "-> Heroe con mas HP: " + majorityHPHero.getName() + "." + "<br><br>"
                + "-> Promedio de aguante: " + resistenceAvg + " puntos de aguante." + "<br><br>"
                + "-> Promedio de defensa de heroes que comienzan con C: " + defenseCHerosAvg + " puntos de defensa." + "</html>");
    }

    /**
     * Creates new form MainJFrame
     */
    public MainJFrame() throws IOException {
        initComponents();
        tableAdapter = new TableAdapter();
        tableAdapter.setTableModel(tblHeros);
        tableAdapter.fillList(herosArray, "G:\\Programming codes\\Java\\Final_Santiago_Franco\\src\\final_santiago_franco\\documents\\Libro_heroes.csv");
        tableAdapter.fillHeader();
        tableAdapter.fillTable(herosArray);
        lblStats.setText(tableAdapter.generateResume(herosArray));

        /*upload("G:\\Programming codes\\Java\\Final_Santiago_Franco\\src\\final_santiago_franco\\documents\\Libro_heroes.csv", herosArray);
        generateResume();*/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblHeros = new javax.swing.JTable();
        lblDocumentUrl = new javax.swing.JLabel();
        txtDocumentUrl = new javax.swing.JTextField();
        btnUpload = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblStats = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblHeros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tblHeros);

        lblDocumentUrl.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        lblDocumentUrl.setText("URL del documento:");

        txtDocumentUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDocumentUrlActionPerformed(evt);
            }
        });

        btnUpload.setText("Actualizar datos");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnClear.setText("Limpiar");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        lblStats.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStats.setAlignmentX(0.5F);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDocumentUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDocumentUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpload, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addComponent(lblStats, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDocumentUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDocumentUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpload)
                    .addComponent(btnClear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lblStats, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(49, 49, 49))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDocumentUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDocumentUrlActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDocumentUrlActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed

        if (txtDocumentUrl.getText().equals("")) {
            System.out.println("Ingrese la url de su documento por favor.");
        } else {
            try {
                tableAdapter.fillList(herosArray, "G:\\Programming codes\\Java\\Final_Santiago_Franco\\src\\final_santiago_franco\\documents\\Libro_heroes.csv");
                tableAdapter.fillTable(herosArray);
            } catch (IOException ex) {
                Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        txtDocumentUrl.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MainJFrame().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(MainJFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnUpload;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDocumentUrl;
    private javax.swing.JLabel lblStats;
    private javax.swing.JTable tblHeros;
    private javax.swing.JTextField txtDocumentUrl;
    // End of variables declaration//GEN-END:variables
}

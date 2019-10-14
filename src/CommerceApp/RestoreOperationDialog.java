/*
 * la licence de ce projet est accorder 
 * a l'entreprise bbs benhaddou brother's software
 * marque deposer aupr�s des autorit�s responsable * 
 */
package CommerceApp;

import Adapters.DateAdapter;
import Adapters.FrameAdapter;
import Adapters.JDBCAdapter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import util.FileProcess;
import util.Operation;

/**
 *
 * @author DELL
 */
public class RestoreOperationDialog extends javax.swing.JDialog {
    Operation operation;
    int ida;
    JDialog parentFrame;
    private JDBCAdapter connect;
    /**
     * Creates new form RestoreOperationDialog
     */
    public RestoreOperationDialog(JFrame parent, Operation op) {
        super(parent, true);
        connect = JDBCAdapter.connect();
        initComponents();
        operation = op;
        initLocals();
        FrameAdapter.centerFrame(this);
        parentFrame = this;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popupMenu = new javax.swing.JPopupMenu();
        Restaurer = new javax.swing.JMenuItem();
        Consulter = new javax.swing.JMenuItem();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        dateChooserCombo2 = new datechooser.beans.DateChooserCombo();
        operatorTextField = new javax.swing.JTextField();
        operatorLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        Restaurer.setText("Restaurer");
        Restaurer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestaurerActionPerformed(evt);
            }
        });
        popupMenu.add(Restaurer);

        Consulter.setText("Consulter");
        Consulter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsulterActionPerformed(evt);
            }
        });
        popupMenu.add(Consulter);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        operatorLabel.setText("Operator");

        jLabel2.setText("Debut");

        jLabel3.setText("Fin");

        searchButton.setText("Recherche");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDENT", "DATE", "HEURE", "NOM", "OPERATION", "TOTAL"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jScrollPane2.setViewportView(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(operatorLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(operatorTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserCombo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dateChooserCombo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)))
                .addGap(36, 36, 36))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operatorLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(operatorTextField, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateChooserCombo2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        String sql = "SELECT IDSUPP as IDS,IDA ,D2 as DATE,T as HEURE,MODE,NOM,"
                        + "if(OPER=0,'MODIFIER','SUPPRIMER') as OPERATION,TOTAL"
                        + " FROM supp" + operation.getTableName();
        String sqlGroup = " GROUP BY IDSUPP";
        JDBCAdapter result = JDBCAdapter.connect();
        if (!operatorTextField.getText().equals("")){
            sqlGroup = " AND NOM LIKE '%" + operatorTextField.getText() + "%'"
                        + sqlGroup;
        }
        if (dateChooserCombo1.getText().equals(dateChooserCombo2.getText())){
            sql += " WHERE CAST(D2 as DATE)='" 
                    + DateAdapter.revertDate(
                            dateChooserCombo1.getText()) +"'"
                    + sqlGroup;
        }else{
            sql += " WHERE CAST(D2 as DATE)>='" + DateAdapter.revertDate(
                            dateChooserCombo1.getText()) +"' AND CAST(D2 AS DATE)"
                    + "<='" + DateAdapter.revertDate(
                                    dateChooserCombo2.getText())
                            + "'" + sqlGroup;
        }
        result.executeQuery(sql);
        if (result.getRowCount() <=0 ){
            JOptionPane.showMessageDialog(this, "la requête n'a abouti a aucun resultat");
        }else{
            table.setModel(result);
            table.getColumnModel().getColumn(5).setPreferredWidth(180);
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        if(evt.isPopupTrigger() && table.getRowCount()>0){
            popupMenu.show(this, evt.getX(), evt.getY()+ 100);
        }
    }//GEN-LAST:event_tableMouseReleased

    private void RestaurerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestaurerActionPerformed
        int row = table.getSelectedRow();
        int numero = (int)table.getValueAt(row, 0);
        String operationType = (String)table.getValueAt(row, 5);
        if (operationType.equals("SUPPRIMER")){
            if (row >= 0){
                JOptionPane.showMessageDialog(this, "Voulez vous vraiment restaurer "
                        + "l'operation selectionné");
                recordOperation(numero);
                recordSubOperation(numero);
                deleteOperationSup(numero);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Cette operation n'est pas autorisé");
        }
    }//GEN-LAST:event_RestaurerActionPerformed

    private void ConsulterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsulterActionPerformed
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                int row = (int)table.getSelectedRow();
                int ids = (int)table.getValueAt(row, 0);
                OperationDialogSupp f = new OperationDialogSupp(parentFrame,
                                                        operation,
                                                        FileProcess.RESTORE,
                                                        ids);
                f.setVisible(true);
            }
            
        });
    }//GEN-LAST:event_ConsulterActionPerformed

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
            java.util.logging.Logger.getLogger(RestoreOperationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RestoreOperationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RestoreOperationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RestoreOperationDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                RestoreOperationDialog dialog = new RestoreOperationDialog(
                        new javax.swing.JFrame(),
                        Operation.SELL);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Consulter;
    private javax.swing.JMenuItem Restaurer;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private datechooser.beans.DateChooserCombo dateChooserCombo2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel operatorLabel;
    private javax.swing.JTextField operatorTextField;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JButton searchButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    private void initLocals() {
        this.setTitle("RESTAURATION " + operation.getFrameTitle() + "S SUPPRIMEES");
        operatorLabel.setText(operation.getOperator().getFrameTitle());
    }

    private void recordOperation(int row) {
        String sql_ida = "SELECT IDA FROM " + operation.getTableName()
                    + " ORDER BY IDA DESC LIMIT 1";
        JDBCAdapter ida_sql = JDBCAdapter.connect();
        ida_sql.executeQuery(sql_ida);
        ida = (int)(ida_sql.getValueAt(0, 0)) + 1;
        String result_sql = "SELECT IDV,D,T,MODE,UTIL,TOTAL,NOM "                   
                    + "FROM supp"+operation.getTableName() 
                    + " WHERE IDA="+ row + " GROUP BY IDA";
        JDBCAdapter secondQuery = JDBCAdapter.connect();
        secondQuery.executeQuery(result_sql);
        String sql = "INSERT INTO " + operation.getTableName() 
                        + " SET IDA=" + ida
                        + ",IDV=" + secondQuery.getValueAt(0, 0)
                        + ",D='" + secondQuery.getValueAt(0, 1)
                        + "',T='" + secondQuery.getValueAt(0, 2)
                        + "',MODE='" + secondQuery.getValueAt(0, 3)
                        + "',UTIL='" + secondQuery.getValueAt(0, 4)
                        + "',TOTAL=" + secondQuery.getValueAt(0, 5)
                        + ",ID=(SELECT ID FROM " + operation.getOperator().getTableName() 
                        + " WHERE NOM='" + secondQuery.getValueAt(0, 6) +"')";                   
        JDBCAdapter query = JDBCAdapter.connect_C1();
        query.executeUpdate(sql);
    }

    private void recordSubOperation(int r) {
        int row = table.getSelectedRow();
        int id = (int)table.getValueAt(row, 0);
        String result_sql = "SELECT IDP,QTUA,QTEA,PRIXA FROM supp" 
                + operation.getTableName() + " WHERE IDA =" + r 
                + " ORDER BY IDA";
        JDBCAdapter firstResult = JDBCAdapter.connect();
        firstResult.executeQuery(result_sql);
        for (int i=0; i < firstResult.getRowCount(); i++){
            String sub_sql = "SELECT PRIXA FROM lachat WHERE IDP="
                    + firstResult.getValueAt(i, 0)
                    + " ORDER BY IDA DESC LIMIT 1";
            JDBCAdapter subResult = JDBCAdapter.connect();
            subResult.executeQuery(sub_sql);
            String sql = "INSERT INTO "+operation.getDetailTableName()
                    + " (IDA,IDP,QTUA,QTEA,PRIXA,IDD,TVA,ST) "
                    + "VALUES(" + ida + ","
                    + firstResult.getValueAt(i, 0) + ","
                    + firstResult.getValueAt(i, 1) + ","
                    + firstResult.getValueAt(i, 2) + ","
                    + firstResult.getValueAt(i, 3) + ","
                    + "1,17,"
                    + subResult.getValueAt(0, 0)
                    + ")";  
            JDBCAdapter result = JDBCAdapter.connect();
            result.executeUpdate(sql);
            System.out.println(sql);
        }
    }

    private void deleteOperationSup(int numero) {
        String deleteSql = "DELETE FROM supp" + operation.getTableName()
                            + " WHERE ida=" + numero;
        JDBCAdapter deletedResult = JDBCAdapter.connect();
        deletedResult.executeUpdate(deleteSql);
    }
}
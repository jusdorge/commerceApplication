/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CommerceApp;

import Adapters.FrameAdapter;
import Adapters.JDBCAdapter;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import util.FileProcess;
import util.Operation;
import util.Utilities;

/**
 *
 * @author DELL
 */
public class ListFrame extends javax.swing.JDialog {
    private String tableName;
    private String sql = "SELECT * from ";
    private JDBCAdapter table;
    private Operation operation;
    private JFrame parentFrame;

    /**
     * Creates new form ListFrame
     */
    public ListFrame(JFrame frm) {
        super(frm, true);
        parentFrame = frm;
        initComponents();  
    }
    public ListFrame(JFrame frm,Operation op){
        super(frm, true);
        parentFrame = frm;
        initComponents();
        operation = op;
        init();
    }
    
    private void init(){
        this.setTitle("LISTE DES " + operation.getFrameTitle() + "S");
        setIconImage(Utilities.setIconImage(this));
        FrameAdapter.centerFrame(this);
        this.setModalityType(DEFAULT_MODALITY_TYPE);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tableName = operation.getTableName();
                String orderField;
                if (operation == Operation.PRODUCT){
                    orderField = "IDP";
                }else{
                    orderField = "ID";
                }
                table = JDBCAdapter.connect();
                sql += tableName + " ORDER BY " + orderField;
                table.executeQuery(sql);   
                listTable.setModel(table);
                for (int i = 0; i < table.getColumnCount(); i++){
                    if (table.getColumnName(i).equals("DESIG") ||
                            table.getColumnName(i).equals("NOM")){
                            listTable.getColumnModel().getColumn(i).
                                    setPreferredWidth(350);
                    }
                }
                
            }
        });        
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
        NewMenuItem = new javax.swing.JMenuItem();
        ModifyMenuItem = new javax.swing.JMenuItem();
        DeleteMenuItem = new javax.swing.JMenuItem();
        ConsulterMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        PrintMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        OrderMenuItem = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        listTable = new javax.swing.JTable();

        NewMenuItem.setMnemonic('N');
        NewMenuItem.setText("Nouveau");
        NewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewMenuItemActionPerformed(evt);
            }
        });
        popupMenu.add(NewMenuItem);

        ModifyMenuItem.setMnemonic('M');
        ModifyMenuItem.setText("Modifier");
        ModifyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModifyMenuItemActionPerformed(evt);
            }
        });
        popupMenu.add(ModifyMenuItem);

        DeleteMenuItem.setMnemonic('S');
        DeleteMenuItem.setText("Supprimer");
        DeleteMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteMenuItemActionPerformed(evt);
            }
        });
        popupMenu.add(DeleteMenuItem);

        ConsulterMenuItem.setMnemonic('C');
        ConsulterMenuItem.setText("Consultation");
        ConsulterMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConsulterMenuItemActionPerformed(evt);
            }
        });
        popupMenu.add(ConsulterMenuItem);
        popupMenu.add(jSeparator1);

        PrintMenuItem.setMnemonic('I');
        PrintMenuItem.setText("Imprimer");
        popupMenu.add(PrintMenuItem);
        popupMenu.add(jSeparator2);

        OrderMenuItem.setText("Ordre de tri");
        popupMenu.add(OrderMenuItem);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        listTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                listTableMouseReleased(evt);
            }
        });
        listTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                listTableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(listTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 791, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NewMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewMenuItemActionPerformed
        switch(operation){
            case PRODUCT:
                ProductDialog f = new ProductDialog(parentFrame);
                f.setVisible(true);
            break;
            case CUSTOMER:
                NewOperatorDialog fn = new NewOperatorDialog(parentFrame,
                                                            Operation.CUSTOMER);
                fn.setVisible(true);
            break;
            case PROVIDER:
                NewOperatorDialog fp = new NewOperatorDialog(parentFrame,
                                                            Operation.PROVIDER);
                fp.setVisible(true);
            break;
        }
    }//GEN-LAST:event_NewMenuItemActionPerformed

    private void listTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listTableMouseReleased
        if(evt.isPopupTrigger()){
            popupMenu.show(this, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_listTableMouseReleased

    private void ModifyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModifyMenuItemActionPerformed
        if (listTable.getSelectedRow() >= 0){
            int idOperation = (int)listTable.getValueAt(listTable.getSelectedRow(),0);
            switch (operation){
                case PRODUCT:
                    OperateProductDialog p = new OperateProductDialog(parentFrame,
                            FileProcess.MODIFY,idOperation);
                    p.setVisible(true);
                break;
                case CUSTOMER:
                    ModifyOperatorDialog c = new ModifyOperatorDialog(parentFrame,
                            Operation.CUSTOMER,idOperation);
                    c.setVisible(true);
                break;
                case PROVIDER:
                    ModifyOperatorDialog pr = new ModifyOperatorDialog(parentFrame,
                            Operation.PROVIDER, idOperation);
                    pr.setVisible(true);
                break;
            }
            //menuItemActionPerformed(FileProcess.MODIFY, idOperation);
        }else{
            JOptionPane.showMessageDialog(this, "Aucune slection n'est faite!!!!");
        }    
    }//GEN-LAST:event_ModifyMenuItemActionPerformed

    private void DeleteMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteMenuItemActionPerformed
         if (listTable.getSelectedRow() >= 0){
            int idOperation = (int)listTable.getValueAt(listTable.getSelectedRow(),0);
            menuItemActionPerformed(FileProcess.DELETE, idOperation);
        }else{
            JOptionPane.showMessageDialog(this, "Aucune selection n'est faite!!!");
        }
    }//GEN-LAST:event_DeleteMenuItemActionPerformed

    private void ConsulterMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConsulterMenuItemActionPerformed
        if(listTable.getSelectedRow() >= 0){
            int idOperation = (int)listTable.getValueAt(listTable.getSelectedRow(),0);
            menuItemActionPerformed(FileProcess.CONSULT, idOperation);
        }else{
            JOptionPane.showMessageDialog(this, "Aucune selection n'est faite!!!");
        }
    }//GEN-LAST:event_ConsulterMenuItemActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
                java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                tableName = operation.getTableName();
                table = JDBCAdapter.connect();
                table.executeQuery(sql);   
                listTable.setModel(table);
                for (int i = 0; i < table.getColumnCount(); i++){
                    if (table.getColumnName(i).equals("DESIG") ||
                            table.getColumnName(i).equals("NOM")){
                            listTable.getColumnModel().getColumn(i).
                                    setPreferredWidth(350);
                    }
                }
                
            }
        });
    }//GEN-LAST:event_formWindowGainedFocus

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        keyPressed(evt);
    }//GEN-LAST:event_formKeyPressed

    private void listTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listTableKeyPressed
        keyPressed(evt);
    }//GEN-LAST:event_listTableKeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ConsulterMenuItem;
    private javax.swing.JMenuItem DeleteMenuItem;
    private javax.swing.JMenuItem ModifyMenuItem;
    private javax.swing.JMenuItem NewMenuItem;
    private javax.swing.JMenuItem OrderMenuItem;
    private javax.swing.JMenuItem PrintMenuItem;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JTable listTable;
    private javax.swing.JPopupMenu popupMenu;
    // End of variables declaration//GEN-END:variables

    private void menuItemActionPerformed(FileProcess fileProcess, int idOperation) {
        switch(operation){
            case PRODUCT:
                switch(fileProcess){
                    case MODIFY:
                        
                    break;
                    case DELETE:
                        JOptionPane.showMessageDialog(this, "pas encore traiter");
                    break;
                }
            break;
            case CUSTOMER:
                switch(fileProcess){
                    case MODIFY:
                        ModifyOperatorDialog mf = new ModifyOperatorDialog(parentFrame,
                                                                    Operation.CUSTOMER
                                                                   ,idOperation);
                        mf.setVisible(true);
                    break;
                    case DELETE:
                        JOptionPane.showMessageDialog(this,"pas encore traiter");
                    break;
                }

            break;
            case PROVIDER:
                switch(fileProcess){
                    case MODIFY:
                        ModifyOperatorDialog pf = new ModifyOperatorDialog(parentFrame,
                                                                    Operation.PROVIDER
                                                                   ,idOperation);
                        pf.setVisible(true);
                    break;
                    case DELETE:
                        JOptionPane.showMessageDialog(this,"pas encore traiter");
                    break;
                }
            break;
        }
    }

    private void keyPressed(KeyEvent evt) {
        if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
            dispose();
        }
    }
}

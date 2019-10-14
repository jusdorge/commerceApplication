package CommerceApp;
import Adapters.FrameAdapter;
import Adapters.JDBCAdapter;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import util.Operation;
import util.Utilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class ChoiceWindow extends javax.swing.JDialog {
	private JDBCAdapter table;
	private String [] columnNames;
	private String tableName;
	private boolean selection = false;
	private Operation type;
	private ArrayList<Object> result;
	private int frameWidth = 800;
        private boolean vide = true;
        private boolean remplie = false;
        
    /**
     * Creates new form ChoiceWindow
     */
    public ChoiceWindow(Operation t) {
        super(new JFrame(), true);
        initComponents();
        //setIconImage(Utilities.setIconImage(this));
        type = t;
	columnNames = t.getChoiceColumns();
	tableName = t.getTableName();
	table = new JDBCAdapter(Utilities.URL, 
                                Utilities.DRIVER_NAME,								
                                Utilities.USER, 
                                Utilities.PASSWORD);
        table.executeQuery(columnNames, tableName);
        table.setItNotEditable();
        setName(t.getTableName());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        //this.setUndecorated(true);

        myTable.setModel(table);
        
        //Sorting utilities.

        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myTable.getModel());
        List <RowSorter.SortKey> sortKeys = new ArrayList<RowSorter.SortKey>();
        //if ((type == Operation.CUSTOMER)||(type == Operation.PROVIDER)){
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        //}else{
        //	sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
        //}
        sorter.setSortKeys(sortKeys); 
        myTable.setRowSorter(sorter);

        //Font and size application to the view.
        //myTable.setFont(Utilities.tableFont());
        //myTable.getTableHeader().setFont(Utilities.headTablFont());
        //myTable.setRowHeight(Utilities.fontHeight());
        myTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //Adding key listener to the view
        myTable.addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                result = new ArrayList<Object>();
                // if Escape is not pressed process. else hide the choice view. 
                if (keyCode != KeyEvent.VK_ESCAPE){
                    int viewRow = myTable.getSelectedRow();
                    int viewColumn = myTable.getSelectedColumn();
                    int row = myTable.convertRowIndexToModel(viewRow);
                    int column = myTable.convertColumnIndexToModel(viewColumn);
                    if ((row != -1)&&(column != -1)){
                        // if Enter is pressed return the current row as the result.
                        if (keyCode == KeyEvent.VK_ENTER){
                            // returns the current choice to the object receiving the focus after this frame.
                            switch (type){
                                case PROVIDER:
                                case CUSTOMER:
                                        result.add(myTable.getValueAt(viewRow,0));
                                        result.add(myTable.getValueAt(viewRow,1));
                                break;
                                case PRODUCT:
                                case SELL_PRODUCT:
                                case BUY_PRODUCT:
                                        result.add(myTable.getValueAt(viewRow,0));
                                        result.add(myTable.getValueAt(viewRow,1));
                                        result.add(myTable.getValueAt(viewRow,2));
                                break;
                            }	
                            // affecter la valeur des colonnes à chercher a l'objet à retourner. 
                            setVisible(false);
                        }
                    }	
                }else{
                        // Escape is pressed so hide the view without result.
                        result = null;
                        dispose();
                }
        }			
        });
        myTable.changeSelection(0,0,false,false);
        myTable.setFillsViewportHeight(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();

        setUndecorated(true);

        myTable.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPane.setViewportView(myTable);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable myTable;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables
    

    
    /**
     * shows the frame in the specified location (x,y) with 
     * the first column width equals width passed parameter
     * and ristricted to the passed text field content passed.
     * @param x an int representing the X location of the parent frame.
     * @param y an int representing the X location of the parent frame.
     * @param width an int representing the width of the parent 
     * textField involved in the search criterium.
     * @param textFieldContent a String representing the content of the
     * text field involved in the search creteria.
     */
    public void show(int x, int y, int width, String textFieldContent){
            setLocation(x ,y);
            newFilter(textFieldContent);
            
            myTable.getColumnModel().getColumn(0).setPreferredWidth(width);
            myTable.changeSelection(0, 0, false, false);
            setVisible(true);
            pack();
            myTable.repaint();

    }
	
    public ArrayList<Object> getResult(){
	return result;
    }
	
    private void newFilter(String filterText) {
        String orderBy;
        
        switch(type){
            case PROVIDER:
            case CUSTOMER:
                orderBy = "NOM";
            break;
            case PRODUCT:
            case SELL_PRODUCT:
            case BUY_PRODUCT:
                orderBy = "DESIG";
            break;
            default:
                orderBy ="ID";
            break;
        }
        if ((filterText !="")||(filterText!=" ")){
            table.executeQuery(columnNames, tableName,orderBy,
                                    filterText, orderBy);
        }else{
            table.executeQuery(columnNames, tableName);
        }
        if (table.getRowCount()<=0){
            JOptionPane.showMessageDialog(this,    "la requête ne peut "
                    + " aboutir veuillez la reformuler..."
                    + filterText,
                                    "Message d'erreur", JOptionPane.ERROR_MESSAGE);
            this.dispose();
        }else{
            myTable.setModel(table);
        }       
    }
}
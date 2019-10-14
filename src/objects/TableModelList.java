/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import Adapters.JDBCAdapter;

/**
 *
 * @author DELL
 */
public class TableModelList extends JDBCAdapter{
    private String[] newColumnNames;
    public TableModelList(String url, String driverName, String user, String passwd) {
        super(url, driverName, user, passwd);
    }
    
    
    public String getColumnName(int column){
        return newColumnNames[column];
    }
    
    public void setColumnNames(String[] colNames){
        newColumnNames = colNames;
    }
}

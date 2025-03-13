package app;
import java.sql.*;
import java.util.*;
import java.util.logging.*;

public class Connect {
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;
    
    public Connect(){
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:store.db");
            stmt = conn.createStatement();
            stmt.execute("PRAGMA foreign_keys = ON;");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
    
    public void select(){
        
        String sql = "SELECT Pirvo_Ime, Familiq FROM Klient";
        
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
               System.out.println(rs.getString("Pirvo_Ime") + "\t" + rs.getString("Familiq"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<String> select(String[] columnsArray, String table){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ", columnsArray);
        String sql = "SELECT " + columns + " FROM " + table;

        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public ArrayList<String> selectWhere(String[] columnsArray, String table, String whereColumn, String whereValue, String operand){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ", columnsArray);
        String operation = "";
        
        if (operand.equals(">")) operation = ">";
        else if (operand.equals("<")) operation = "<";
        else if (operand.equals("=")) operation = "=";
        else if (operand.equals("LIKE")) operation = "LIKE";
        
        String sql = "SELECT " + columns + " FROM " + table 
                + " WHERE " + whereColumn + " "+operation+" '" + whereValue+"'";

        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    
    
    public ArrayList<String> selectWhereOr(String[] columnsArray, String table, String[] whereColumns, String[] whereValues){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ", columnsArray);
        
        String sql = "SELECT " + columns + " FROM " + table + " WHERE ";
        
        for (int i = 0; i < whereColumns.length; i++) {
            sql=sql+whereColumns[i]+" LIKE '" + whereValues[i]+"' OR ";
        }
        sql=sql.substring(0,sql.length()-4);
        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                String row = "";
                for (int i = 0; i < columnsArray.length; i++) {
                    row = row + rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
   
    public ArrayList<String> selectWhereAnd(String[] columnsArray, String table, String[] whereCols, String[] whereValues){
        ArrayList data = new ArrayList<String>();
        String columns = String.join(", ",columnsArray);

        String sql = "SELECT " + columns + " FROM " + table + " WHERE ";
        
        for(int i=0; i<whereCols.length; i++){
            sql = sql + whereCols[i] + " LIKE '" + whereValues[i] + "' AND ";
        }
        sql = sql.substring(0,sql.length()-5);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            System.out.println(sql);
            while(rs.next()){
                String row="";
                for (int i = 0; i < columnsArray.length; i++) {
                    row+=rs.getString(columnsArray[i])+"---";
                }
                row=row.substring(0, row.length()-3);
               data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return data;
    }
    
     
    public String insert(String table, String[] columnsArray, String[] valuesArray){
        String columns = String.join(", ", columnsArray);
        String values = String.join("', '", valuesArray);
        String sql = "Insert into " + table + " ("+columns+") values ('"+values+"')";
        String error = "";
        
        System.out.println(sql);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            error = e.getMessage();
            System.out.println(error);
        }
        
        return error;
    }
    
     
    public String update(String table, String[] columnsArray, String[] valuesArray, String whereCol, String whereVal){
        String sql = "update "+ table + " set ";
        String error = "";
        for (int i = 0; i < columnsArray.length; i++) {
            sql=sql+columnsArray[i]+" = '"+valuesArray[i]+"', ";
        }
        sql=sql.substring(0, sql.length()-2);
        sql = sql + " WHERE "+ whereCol + " = '"+whereVal+"'";
        System.out.println(sql);
        try{
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            error = e.getMessage();
            System.out.println(error);
        }
        
        return error;
    }
    
    
    public String delete(String table, String whereCol, String whereValue){
        String sql = "DELETE FROM " + table + " WHERE "+
                whereCol + " LIKE '"+whereValue+"'";
        String error = "";
        try{
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            error = e.getMessage();
            System.out.println(error);
        }
        
        return error;
    }
    
    public void close(){
        try {
            if (conn != null) {
                conn.close();     
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Throwable ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public ArrayList<String> getTableNames() {
        ArrayList<String> names = new ArrayList<String>();
        
        try
        {
            rs = conn.getMetaData().getTables(null, null, null, null);
            
            while (rs.next()) {
                names.add(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
        return names;
    }
    
    public Table loadTableData(String tableName) {
        ArrayList<Map<String, Object>> data = new ArrayList<>();
        ArrayList<String> columnNames = new ArrayList<>();
        stmt = null;
        rs = null;

        try {
            
            DatabaseMetaData metaData = conn.getMetaData();
            rs = metaData.getColumns(null, null, tableName, null);
            
            while (rs.next()) {
                columnNames.add(rs.getString("COLUMN_NAME"));
            }
            rs.close();
            
            String columns = String.join(", ",columnNames);
            
            String sql = "SELECT " + columns + " FROM " + tableName;
            System.out.println(sql);
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (String column : columnNames) {
                    row.put(column, rs.getObject(column));
                }
                data.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
         return new Table(columnNames, data);
    }
    
    public ArrayList<String> customQuery(String[] columnsArray, String sql){
        ArrayList data = new ArrayList<String>(); 
        
        try{
        System.out.println(sql);
        stmt = conn.createStatement();
        rs = stmt.executeQuery(sql);
        while(rs.next()){
            String row = "";
            for (int i = 0; i < columnsArray.length; i++) {
                row = row + rs.getString(columnsArray[i])+"---";
            }
            row=row.substring(0, row.length()-3);
            data.add(row);
        }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }  
        
        return data;
    }
}
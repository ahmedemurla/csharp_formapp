package app;
import java.util.*;


public class Table
{
    private ArrayList<String> columnNames;
    private List<Map<String, Object>> rows;

    public Table(ArrayList<String> columnNames, List<Map<String, Object>> rows) {
        this.columnNames = columnNames;
        this.rows = rows;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
    }

    public List<Map<String, Object>> getRows() {
        return rows;
    }
    
}

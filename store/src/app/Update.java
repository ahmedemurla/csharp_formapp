package app;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.DriverManager;

public class Update extends javax.swing.JFrame
{

    public Connect query = new Connect();
    DefaultTableModel table = new DefaultTableModel() {

        @Override
        public boolean isCellEditable(int row, int column) {
           
           return false;
        }
    };
    
    public Update()
    {
        initComponents();
        this.setTitle("Update");
        this.setLocationRelativeTo(null);
        jTable1.setModel(table);
        ArrayList<String> names = query.getTableNames();
        
        for (String name : names) {
            jComboBox1.addItem(name);
        }
 
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Open the next form
                new Admin().setVisible(true);
            }
        });
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter()
        {
            public void windowClosed(java.awt.event.WindowEvent evt)
            {
                formWindowClosed(evt);
            }
        });

        jComboBox1.addItemListener(new java.awt.event.ItemListener()
        {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {

            },
            new String []
            {

            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(115, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(114, 114, 114))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 743, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(25, 25, 25))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt)//GEN-FIRST:event_jComboBox1ItemStateChanged
    {//GEN-HEADEREND:event_jComboBox1ItemStateChanged

        if (table != null) {
            table.setRowCount(0);
            table.setColumnCount(0);
        }
        
        String choice = jComboBox1.getSelectedItem().toString();    
        
        if (choice.equals("Porichka_Produkt")) {
            query.customQuery(new String[]{}, "PRAGMA foreign_keys = OFF;");
        }
        
        query.select();
                
        Table data = query.loadTableData(choice);
            
        for (String column : data.getColumnNames()) {
            table.addColumn(column);
        }
            
        for (Map<String, Object> item : data.getRows()) {
            Object[] row = data.getColumnNames().stream()
                        .map(item::get)
                        .toArray();
            table.addRow(row);
        }
        
        for (Component component : jPanel1.getComponents()) {
                if (component instanceof JLabel || component instanceof JTextField) {
                    jPanel1.remove(component);
                }
            }
        
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_jTable1MouseClicked
    {//GEN-HEADEREND:event_jTable1MouseClicked
        for (Component component : jPanel1.getComponents()) {
                if (component instanceof JLabel || component instanceof JTextField) {
                    jPanel1.remove(component);
                }
            }
            
        int selectRow = jTable1.getSelectedRow();
        int choice = Integer.parseInt(jTable1.getValueAt(selectRow, 0).toString());
        
        System.out.println(choice);
        
        String selected = jComboBox1.getSelectedItem().toString();
       
        Table data = query.loadTableData(selected);
        ArrayList<String> temp = new ArrayList<String>();
        
        boolean skipFirst = true;
        
        int yPosition = 40;
        
        if (selected.equals("Porichka_Produkt")) skipFirst = false;
        
        for (String column : data.getColumnNames()) {
            
            if (skipFirst) {
                    skipFirst = false;
                    continue;
            }
            
            
            JLabel label = new JLabel();
            JTextField field = new JTextField();
            label.setText(column);
            field.setText("");

            label.setBounds(10, yPosition, 200, 30);
            field.setBounds(120, yPosition+5, 160, 25);
                    
            jPanel1.add(label);
            jPanel1.add(field);

            yPosition += 30;
            
            
        }
        
        skipFirst = true;
        
        if (selected.equals("Porichka_Produkt")) skipFirst = false;
        
        for (Map<String, Object> item : data.getRows()) {
                Object[] rows = data.getColumnNames().stream()
                            .map(item::get)
                            .toArray();
                int id = Integer.parseInt(rows[0].toString());
                
                if (id == choice) {
                    for (Object row : rows) {
                        if (skipFirst) {
                            skipFirst = false;
                            continue;
                        }
                        
                        if(row == null) temp.add("");
                        
                        else temp.add(row.toString());
                    }
                }
        }
        
        int counter = 0;
        
        for (Component component : jPanel1.getComponents()) {
               
                if (component instanceof JTextField) {
                    ((JTextField) component).setText(temp.get(counter));
                    counter++;
                }
            }
        
        this.revalidate();
        this.repaint();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed

        ArrayList<String> tempRows = new ArrayList<String>();
        ArrayList<String> tempColumns = new ArrayList<String>();
        String selected = jComboBox1.getSelectedItem().toString();
        int selectRow = jTable1.getSelectedRow();
        
        for (Component component : jPanel1.getComponents()) {
               
                if (component instanceof JTextField) {
                    tempRows.add(((JTextField) component).getText());
                }
                else if (component instanceof JLabel) {
                    tempColumns.add(((JLabel) component).getText());
                }
            }
        
        String[] columns = tempColumns.toArray(new String[0]);
        String[] rows = tempRows.toArray(new String[0]);
        
        String error = query.update(selected, columns, rows, String.valueOf(table.getColumnName(0)), jTable1.getValueAt(selectRow, 0).toString());
        
        if(error.equals("query does not return ResultSet")){
            JOptionPane.showMessageDialog(this, "Колоната бе обновена успешно!");
        }
        else {
            JOptionPane.showMessageDialog(this, "Възникна грешка с операцията: \n" + error);
        }
        
        for (Component component : jPanel1.getComponents()) {
                if (component instanceof JLabel || component instanceof JTextField) {
                    jPanel1.remove(component);
                }
            }
        
        this.revalidate();
        this.repaint();
        
        if (table != null) {
            table.setRowCount(0);
            table.setColumnCount(0);
        }
                
        Table data = query.loadTableData(selected);
            
        for (String column : data.getColumnNames()) {
            table.addColumn(column);
        }
            
        for (Map<String, Object> item : data.getRows()) {
            Object[] row = data.getColumnNames().stream()
                        .map(item::get)
                        .toArray();
            table.addRow(row);
        }
        
        query.customQuery(new String[]{}, "PRAGMA foreign_keys = ON;");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt)//GEN-FIRST:event_formWindowClosed
    {//GEN-HEADEREND:event_formWindowClosed
        query.close();
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}

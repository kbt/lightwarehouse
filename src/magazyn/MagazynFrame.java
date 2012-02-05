/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package magazyn;

import java.awt.Component;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kabot
 */
public class MagazynFrame extends javax.swing.JFrame {

    private Magazyn mag;
    private DefaultTableModel model;
    private HashMap<Integer, Integer> listaPosId = new HashMap<>();

    /**
     * Creates new form MagazynFrame
     */
    public MagazynFrame()
    {
      initComponents();

      DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
      rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
      jTable1.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);


      filter.requestFocus();

      mag = new Magazyn();

      model = (DefaultTableModel)jTable1.getModel();

      setMagList(mag.getList());
    }

    private void setMagList(Map<Integer, KeyValue> list)
    {
        for (Map.Entry<Integer, KeyValue> m : list.entrySet()) {
            magCombo.addItem(m.getValue());
        }
    }

    public void setProductTable()
    {
      DecimalFormat df0 = new DecimalFormat("0.00");
      int pos = 0;
      ArrayList<Product> list = mag.getProductList(
              ((KeyValue)magCombo.getSelectedItem()).key,
              filter.getText());

      listaPosId.clear();

      model.getDataVector().removeAllElements();
      model.fireTableDataChanged();

      for (Product p : list) {
        pos++;

        model.addRow(new Object[]{
          pos,
          p.name,
          p.um,
          p.vat,
          p.quantity,
          df0.format(p.price),
          p.date
        });

        listaPosId.put(pos, p.id);
      }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        magCombo = new javax.swing.JComboBox();
        filter = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Magazyn");

        jSplitPane1.setDividerSize(0);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        magCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                magListChange(evt);
            }
        });

        filter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filterChanged(evt);
            }
        });

        jButton1.setText("Szukaj");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                szukajAction(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(magCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filter, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(filter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jButton1)
                .addComponent(magCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jSplitPane1.setTopComponent(jPanel1);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Lp", "Nazwa", "Jm", "Vat", "Ilość", "Cena", "Data"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Float.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getColumn(0).setMinWidth(20);
        jTable1.getColumnModel().getColumn(0).setMaxWidth(50);
        jTable1.getColumnModel().getColumn(2).setMinWidth(20);
        jTable1.getColumnModel().getColumn(2).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(3).setMinWidth(20);
        jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(4).setMinWidth(20);
        jTable1.getColumnModel().getColumn(4).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(5).setMinWidth(20);
        jTable1.getColumnModel().getColumn(5).setMaxWidth(70);
        jTable1.getColumnModel().getColumn(6).setMinWidth(80);
        jTable1.getColumnModel().getColumn(6).setMaxWidth(120);

        jSplitPane1.setRightComponent(jScrollPane1);

        jMenu1.setText("Magazyn");

        jMenuItem2.setText("Dodaj nowy produkt");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNowyProdukt(evt);
            }
        });
        jMenu1.add(jMenuItem2);
        jMenu1.add(jSeparator1);

        jMenuItem1.setText("Wyjście");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 959, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void magListChange(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_magListChange
//        System.out.println("magListChange zmiana ");
        setProductTable();
    }//GEN-LAST:event_magListChange

    private void filterChanged(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_filterChanged
        setProductTable();
    }//GEN-LAST:event_filterChanged

    private void szukajAction(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_szukajAction
        setProductTable();
    }//GEN-LAST:event_szukajAction

    private void listaClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaClicked
      int row = jTable1.getSelectedRow();
      int id = listaPosId.get(row+1);

      new ProductDialog(this, id).setVisible(true);

      setProductTable();
      filter.requestFocus();
      filter.selectAll();
    }//GEN-LAST:event_listaClicked

  private void menuNowyProdukt(java.awt.event.ActionEvent evt)//GEN-FIRST:event_menuNowyProdukt
  {//GEN-HEADEREND:event_menuNowyProdukt
    new ProductDialog(this, 0).setVisible(true);

    setProductTable();
    filter.requestFocus();
    filter.selectAll();
  }//GEN-LAST:event_menuNowyProdukt

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new MagazynFrame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField filter;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox magCombo;
    // End of variables declaration//GEN-END:variables
}

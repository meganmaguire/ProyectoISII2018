/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import Código.ManagerProductos;
import Código.Producto;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author megan
 */
public class ListadoProductos extends javax.swing.JDialog {
    private JTextField nombre;
    private Producto producto;
    private DefaultTableModel modeloTablaListado;
    private List<Producto> listado = new ArrayList();
    
    /**
     * Creates new form ListadoProductos
     */
    public ListadoProductos(java.awt.Frame parent, boolean modal,JTextField nombre,Producto producto) {
        super(parent, modal);
        initComponents();
        //Seteo del model
        modeloTablaListado = (DefaultTableModel)tablaListado.getModel();
        tablaListado.setModel(modeloTablaListado);
        this.nombre = nombre;
        //Trae los productos
        ManagerProductos manager = new ManagerProductos();
        listado = manager.verCatálogo();
        //Los muestra
        for(Producto p : listado){
            Object [] row ={p.getId(),p.getNombreProducto(),p.instance(),p.getPrecioVenta()};
            modeloTablaListado.addRow(row);
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

        base = new javax.swing.JPanel();
        panelEncabezado = new javax.swing.JPanel();
        cerrar = new javax.swing.JLabel();
        panelTabla = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        labelListado = new javax.swing.JLabel();
        labelTitulo12 = new javax.swing.JLabel();
        comboBoxFiltro = new javax.swing.JComboBox();
        campoFiltro = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEncabezado.setBackground(new java.awt.Color(8, 8, 12));

        cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/icons/icons8_Multiply_32px.png"))); // NOI18N
        cerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cerrarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cerrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cerrarMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panelEncabezadoLayout = new javax.swing.GroupLayout(panelEncabezado);
        panelEncabezado.setLayout(panelEncabezadoLayout);
        panelEncabezadoLayout.setHorizontalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEncabezadoLayout.createSequentialGroup()
                .addContainerGap(905, Short.MAX_VALUE)
                .addComponent(cerrar)
                .addGap(13, 13, 13))
        );
        panelEncabezadoLayout.setVerticalGroup(
            panelEncabezadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEncabezadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(cerrar)
                .addContainerGap())
        );

        base.add(panelEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 56));

        panelTabla.setBackground(new java.awt.Color(32, 40, 51));

        tablaListado.setBackground(new java.awt.Color(32, 40, 51));
        tablaListado.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tablaListado.setForeground(new java.awt.Color(255, 255, 255));
        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Categoría", "Precio "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaListado.setGridColor(new java.awt.Color(69, 162, 158));
        tablaListado.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tablaListado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaListadoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tablaListado);

        labelListado.setFont(new java.awt.Font("Fira Sans Book", 1, 36)); // NOI18N
        labelListado.setForeground(new java.awt.Color(250, 250, 250));
        labelListado.setText("Listado");

        labelTitulo12.setFont(new java.awt.Font("Fira Sans Book", 0, 18)); // NOI18N
        labelTitulo12.setForeground(new java.awt.Color(250, 250, 250));
        labelTitulo12.setText("Filtro");

        comboBoxFiltro.setBackground(new java.awt.Color(36, 46, 59));
        comboBoxFiltro.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboBoxFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Nombre", "Categoría" }));
        comboBoxFiltro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(69, 162, 158)));

        campoFiltro.setBackground(new java.awt.Color(36, 46, 59));
        campoFiltro.setFont(new java.awt.Font("Fira Sans Book", 0, 18)); // NOI18N
        campoFiltro.setForeground(new java.awt.Color(197, 198, 199));
        campoFiltro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(69, 162, 158)));
        campoFiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                campoFiltroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                campoFiltroKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout panelTablaLayout = new javax.swing.GroupLayout(panelTabla);
        panelTabla.setLayout(panelTablaLayout);
        panelTablaLayout.setHorizontalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTablaLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLayout.createSequentialGroup()
                        .addComponent(labelListado, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(255, 255, 255)
                        .addComponent(labelTitulo12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboBoxFiltro, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        panelTablaLayout.setVerticalGroup(
            panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTablaLayout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTablaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelTitulo12)
                        .addComponent(comboBoxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(campoFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelListado))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        base.add(panelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_cerrarMouseClicked

    private void cerrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseEntered
        this.cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/icons/icons8_Multiply_32px_1.png")));
    }//GEN-LAST:event_cerrarMouseEntered

    private void cerrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cerrarMouseExited
        this.cerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaz/icons/icons8_Multiply_32px.png")));
    }//GEN-LAST:event_cerrarMouseExited

    private void campoFiltroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFiltroKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFiltroKeyReleased

    private void campoFiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_campoFiltroKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_campoFiltroKeyTyped

    private void tablaListadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaListadoMouseClicked
        ManagerProductos manager = new ManagerProductos(); 
        if(evt.getClickCount()==2){
            int i = tablaListado.getSelectedRow();
            if(i!=-1){
                nombre.setText(String.valueOf(tablaListado.getValueAt(i, 1)));
                producto = manager.instanciarProducto(Integer.parseInt(String.valueOf(tablaListado.getValueAt(i, 0))), String.valueOf(tablaListado.getValueAt(i, 1)), String.valueOf(tablaListado.getValueAt(i, 2)),Float.parseFloat(String.valueOf(tablaListado.getValueAt(i, 3))));
                this.dispose();
            }
        }
    }//GEN-LAST:event_tablaListadoMouseClicked

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
            java.util.logging.Logger.getLogger(ListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoProductos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                /*ListadoProductos dialog = new ListadoProductos(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
                */
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel base;
    private javax.swing.JTextField campoFiltro;
    private javax.swing.JLabel cerrar;
    private javax.swing.JComboBox comboBoxFiltro;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel labelListado;
    private javax.swing.JLabel labelTitulo12;
    private javax.swing.JPanel panelEncabezado;
    private javax.swing.JPanel panelTabla;
    private javax.swing.JTable tablaListado;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraProductos;
import Modelo.Producto;
import Modelo.miRenderer;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hatake
 */
public class jdProductosBuscar extends javax.swing.JDialog {

    private ControladoraProductos productos= new ControladoraProductos();
    private int x,y;
    
    public void cargarDatos(List<Producto> l)
    {        
        try
        {
            String col[] = {"Código", "Marca", "Nombre", "Descripción", "Precio", "Stock","Seleccionar"};            

            JButton seleccionar= new JButton("Seleccionar");
            seleccionar.setText("Seleccionar");
            seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Checkmark_20.png"))); 

            seleccionar.setBackground(new java.awt.Color(255,51,102));
            seleccionar.setFont(new java.awt.Font("Arial", 1, 14)); 
            seleccionar.setForeground(new java.awt.Color(255, 255, 255));                
            seleccionar.setBorderPainted(false);


           
            DefaultTableModel tableModel = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            jtProductos.setModel(tableModel);

            jtProductos.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                                  


            l.forEach((p) -> 
            {                                   
                Object[] datos = {p.getCodigoProducto(),p.getMarca(),p.getNombre(),p.getDescripcion(),"$"+p.getPrecio(),p.getStock(), seleccionar};            
                tableModel.addRow(datos);                   
            });                          
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void cargarDatos(Producto p)
    {        
        try
        {
            String col[] = {"Código", "Marca", "Nombre", "Descripción", "Precio", "Stock","Seleccionar"};            

            JButton seleccionar= new JButton("Seleccionar");
            seleccionar.setText("Seleccionar");
            seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Checkmark_20.png"))); 

            seleccionar.setBackground(new java.awt.Color(255,51,102));
            seleccionar.setFont(new java.awt.Font("Arial", 1, 14)); 
            seleccionar.setForeground(new java.awt.Color(255, 255, 255));                
            seleccionar.setBorderPainted(false);


           
            DefaultTableModel tableModel = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            jtProductos.setModel(tableModel);

            jtProductos.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                                  
           

            if(p!=null)
            {                                   
                Object[] datos = {p.getCodigoProducto(),p.getMarca(),p.getNombre(),p.getDescripcion(),"$"+p.getPrecio(),p.getStock(), seleccionar};            
                tableModel.addRow(datos);                   
            }                       
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    /**
     * Creates new form jdProductosBuscar
     */
    public jdProductosBuscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
            cargarDatos(productos.DevolverProductos());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }            
    }
    
    public jdProductosBuscar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
            cargarDatos(productos.DevolverProductos());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
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

        jpClientes = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jbtnCerrar = new javax.swing.JButton();
        jpSeparador = new javax.swing.JPanel();
        jpPrincipal = new javax.swing.JPanel();
        jlblBuscar = new javax.swing.JLabel();
        jcbFiltros = new javax.swing.JComboBox<>();
        jtxtFiltro = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jpPrincipal1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jbtnFiltros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpClientes.setBackground(new java.awt.Color(0, 0, 0));
        jpClientes.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jpClientesMouseDragged(evt);
            }
        });
        jpClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jpClientesMousePressed(evt);
            }
        });
        jpClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTitulo.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jlblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlblTitulo.setText("Seleccionar Producto");
        jlblTitulo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jlblTituloMouseDragged(evt);
            }
        });
        jlblTitulo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlblTituloMousePressed(evt);
            }
        });
        jpClientes.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 210, -1));

        jbtnCerrar.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jbtnCerrar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnCerrar.setText("x");
        jbtnCerrar.setBorder(null);
        jbtnCerrar.setBorderPainted(false);
        jbtnCerrar.setContentAreaFilled(false);
        jbtnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCerrarActionPerformed(evt);
            }
        });
        jpClientes.add(jbtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 40, 40));

        getContentPane().add(jpClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 40));

        jpSeparador.setBackground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jpSeparadorLayout = new javax.swing.GroupLayout(jpSeparador);
        jpSeparador.setLayout(jpSeparadorLayout);
        jpSeparadorLayout.setHorizontalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        jpSeparadorLayout.setVerticalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 880, 10));

        jpPrincipal.setBackground(java.awt.SystemColor.controlHighlight);
        jpPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jpPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblBuscar.setText("Filtrar por:");
        jpPrincipal.add(jlblBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 90, 30));

        jcbFiltros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Marca", "Nombre" }));
        jcbFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltrosActionPerformed(evt);
            }
        });
        jpPrincipal.add(jcbFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 140, 30));

        jtxtFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtxtFiltro.setText("Valor a buscar....");
        jtxtFiltro.setEnabled(false);
        jpPrincipal.add(jtxtFiltro, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 170, 30));

        jbtnBuscar.setBackground(new java.awt.Color(255, 51, 102));
        jbtnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search_More_20.png"))); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.setBorder(null);
        jbtnBuscar.setBorderPainted(false);
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jpPrincipal.add(jbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 110, 30));
        jpPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 830, 20));

        jpPrincipal1.setBackground(java.awt.SystemColor.controlShadow);

        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
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
        jtProductos.setRowHeight(24);
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductos);

        javax.swing.GroupLayout jpPrincipal1Layout = new javax.swing.GroupLayout(jpPrincipal1);
        jpPrincipal1.setLayout(jpPrincipal1Layout);
        jpPrincipal1Layout.setHorizontalGroup(
            jpPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipal1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 782, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jpPrincipal1Layout.setVerticalGroup(
            jpPrincipal1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipal1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jpPrincipal.add(jpPrincipal1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 830, 350));

        jbtnFiltros.setBackground(new java.awt.Color(255, 51, 102));
        jbtnFiltros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnFiltros.setForeground(new java.awt.Color(255, 255, 255));
        jbtnFiltros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Refresh_20p.png"))); // NOI18N
        jbtnFiltros.setText("Quitar Filtro");
        jbtnFiltros.setBorder(null);
        jbtnFiltros.setBorderPainted(false);
        jbtnFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFiltrosActionPerformed(evt);
            }
        });
        jpPrincipal.add(jbtnFiltros, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 20, 150, 30));

        getContentPane().add(jpPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 880, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        // TODO add your handling code here:
        try
        {

            int fila = jtProductos.rowAtPoint(evt.getPoint());
            int columna = jtProductos.columnAtPoint(evt.getPoint());

            if ((fila > -1) && (columna > -1))
            {
                
                if(columna==6)
                {
                    //obtener id del cliente..
                    int id=(int)jtProductos.getValueAt(fila,0);
                    jdFacturasAgregar.productoBuscado=productos.buscarProductoId(id);
                    this.dispose();                    
                }               
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtProductosMouseClicked

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
        try
        {
            int indice=jcbFiltros.getSelectedIndex();
            
            if(indice==0) //codigo
            {
                int id=Integer.parseInt(jtxtFiltro.getText());
                cargarDatos(productos.buscarProductoId(id));
            }
            
            if(indice==1)//marca
            {                
               cargarDatos(productos.buscarProductoPorMarca(jtxtFiltro.getText()));
            }

            if(indice==2)//nombre
            {
               cargarDatos(productos.buscarProductoPorNombre(jtxtFiltro.getText()));
            }            
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jcbFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFiltrosActionPerformed
        // TODO add your handling code here:
                try
        {
            jtxtFiltro.setText("");
            if (evt.getSource()==jcbFiltros)
            jtxtFiltro.setEnabled(true);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jcbFiltrosActionPerformed

    private void jbtnFiltrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFiltrosActionPerformed
        // TODO add your handling code here:
        try
        {
            cargarDatos(productos.DevolverProductos());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnFiltrosActionPerformed

    private void jpClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpClientesMousePressed
        // TODO add your handling code here:                
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jpClientesMousePressed

    private void jlblTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTituloMousePressed
        // TODO add your handling code here:                
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jlblTituloMousePressed

    private void jlblTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTituloMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y+ evt.getY()- y);                        
    }//GEN-LAST:event_jlblTituloMouseDragged

    private void jpClientesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpClientesMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y+ evt.getY()- y);                        
    }//GEN-LAST:event_jpClientesMouseDragged

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
            java.util.logging.Logger.getLogger(jdProductosBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdProductosBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdProductosBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdProductosBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdProductosBuscar dialog = new jdProductosBuscar(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnFiltros;
    private javax.swing.JComboBox<String> jcbFiltros;
    private javax.swing.JLabel jlblBuscar;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpPrincipal1;
    private javax.swing.JPanel jpSeparador;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField jtxtFiltro;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraProductos;
import Modelo.Producto;
import javax.swing.JOptionPane;

/**
 *
 * @author Hatake
 */
public class jdProductosAgregar extends javax.swing.JDialog {

    private ControladoraProductos productos= new ControladoraProductos();
    private Producto productoModificar;
    private int x,y;
    
    public boolean ingresoTexto(String texto)
    {        
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
            return false;           
        }
        else
        {
            return true;
        }
    }
    
    public jdProductosAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    public jdProductosAgregar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
            jbtnModificar.setVisible(false);

            jtxtCodigo.setText(String.valueOf(productos.proximoIdProducto()));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //constructor para usar el mismo form de agregar para modificar.. 
    public jdProductosAgregar(javax.swing.JDialog parent, boolean modal, int id) {
        super(parent, modal);
        initComponents();
        
        try
        {       
            productoModificar=productos.buscarProductoId(id);
            
            jtxtCodigo.setText(String.valueOf(productoModificar.getCodigoProducto()));
            jtxtCantidad.setText(String.valueOf(productoModificar.getStock()));
            jtxtPrecio.setText(String.valueOf(productoModificar.getPrecio()));
            
            jtxtNombre.setText(productoModificar.getNombre());
            jtxtMarca.setText(productoModificar.getMarca());
            jtxtADescripcion.setText(productoModificar.getDescripcion());
                                                
            jlblTitulo.setText("Modificar Producto");
            jbtnAgregar.setVisible(false);
                        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpClientes = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jbtnCerrar = new javax.swing.JButton();
        jpSeparador = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxtADescripcion = new javax.swing.JTextArea();
        jlblDescripcion = new javax.swing.JLabel();
        jlblCantidad = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jlbCodigoProducto = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jlblMarca = new javax.swing.JLabel();
        jtxtMarca = new javax.swing.JTextField();
        jlblNombre = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jlblPrecio = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jbtnModificar = new javax.swing.JButton();
        jlblProducto = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

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
        jlblTitulo.setText("Agregar Producto");
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
        jpClientes.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 200, -1));

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
        jpClientes.add(jbtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 40, 40));

        getContentPane().add(jpClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 40));

        jpSeparador.setBackground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jpSeparadorLayout = new javax.swing.GroupLayout(jpSeparador);
        jpSeparador.setLayout(jpSeparadorLayout);
        jpSeparadorLayout.setHorizontalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jpSeparadorLayout.setVerticalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 710, 10));

        jPanel1.setBackground(java.awt.SystemColor.controlHighlight);
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jtxtADescripcion.setColumns(20);
        jtxtADescripcion.setRows(5);
        jScrollPane1.setViewportView(jtxtADescripcion);

        jlblDescripcion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblDescripcion.setText("Descripción:");

        jlblCantidad.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblCantidad.setText("Cantidad:");

        jtxtCantidad.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlbCodigoProducto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlbCodigoProducto.setText("Código:");

        jtxtCodigo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlblMarca.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblMarca.setText("Marca:");

        jtxtMarca.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlblNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblNombre.setText("Nombre:");

        jtxtNombre.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        jlblPrecio.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblPrecio.setText("Precio:");

        jtxtPrecio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblCantidad)
                        .addGap(15, 15, 15)
                        .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jlbCodigoProducto)
                            .addGap(28, 28, 28)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jlblMarca)
                            .addGap(38, 38, 38)
                            .addComponent(jtxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jlblNombre)
                            .addGap(23, 23, 23)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jlblPrecio)
                            .addGap(35, 35, 35)
                            .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblDescripcion)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlblDescripcion)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbCodigoProducto))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblMarca)
                            .addComponent(jtxtMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblNombre))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblPrecio)
                            .addComponent(jtxtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblCantidad)
                            .addComponent(jtxtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 670, 210));

        jbtnAgregar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnAgregar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Barcode_20.png"))); // NOI18N
        jbtnAgregar.setText("Agregar");
        jbtnAgregar.setBorder(null);
        jbtnAgregar.setBorderPainted(false);
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 90, 30));

        jbtnModificar.setBackground(new java.awt.Color(0, 0, 0));
        jbtnModificar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnModificar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_20.png"))); // NOI18N
        jbtnModificar.setText("Modificar");
        jbtnModificar.setBorder(null);
        jbtnModificar.setBorderPainted(false);
        jbtnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarActionPerformed(evt);
            }
        });
        jPanel1.add(jbtnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 290, 110, 30));

        jlblProducto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblProducto.setText("Detalles del Producto:");
        jPanel1.add(jlblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 32, 670, 10));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 710, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        // TODO add your handling code here:

        try
        {
            boolean continuar=true;
            String codigo=jtxtCodigo.getText(), marca=jtxtMarca.getText(),nombre=jtxtNombre.getText(), precio=jtxtPrecio.getText(),
                    cantidad=jtxtCantidad.getText(),descripcion=jtxtADescripcion.getText();
            
            
            
            //validar campos no vacios
            if( !ingresoTexto(codigo) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese código de producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(marca) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese marca.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(nombre) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(precio) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese precio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(cantidad) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese cantidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(descripcion) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese descripcion.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            //si estan completos los campos anteriores continua
            if(continuar)
            {
                int cod=Integer.parseInt(codigo) , can=Integer.parseInt(cantidad);
                float pre=Float.parseFloat(precio);
                
                if(productos.AgregarProducto(cod, marca, nombre, descripcion, pre, can))
                {
                    JOptionPane.showMessageDialog(null, "Se agregó producto con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se agregó el producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Complete los datos del producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarActionPerformed
        // TODO add your handling code here:
         try
        {
            boolean continuar=true;
            String codigo=jtxtCodigo.getText(), marca=jtxtMarca.getText(),nombre=jtxtNombre.getText(), precio=jtxtPrecio.getText(),
                    cantidad=jtxtCantidad.getText(),descripcion=jtxtADescripcion.getText();
            int cod=Integer.parseInt(codigo) , can=Integer.parseInt(cantidad);
            float pre=Float.parseFloat(precio);
            
            
            //validar campos no vacios
            if( !ingresoTexto(codigo) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese código de producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(marca) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese marca.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(nombre) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(precio) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese precio.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(cantidad) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese cantidad.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(descripcion) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese descripcion.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            //si estan completos los campos anteriores continua
            if(continuar)
            {
                
                if(productos.ModificarProducto(cod, marca, nombre, descripcion, pre, can))
                {
                    JOptionPane.showMessageDialog(null, "Se modificó producto con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se modifico el producto. Ya existe producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Complete los datos del producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
    }//GEN-LAST:event_jbtnModificarActionPerformed

    private void jlblTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTituloMousePressed
        // TODO add your handling code here:                
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jlblTituloMousePressed

    private void jpClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpClientesMousePressed
        // TODO add your handling code here:
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jpClientesMousePressed

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
            java.util.logging.Logger.getLogger(jdProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdProductosAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdProductosAgregar dialog = new jdProductosAgregar(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnModificar;
    private javax.swing.JLabel jlbCodigoProducto;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JLabel jlblDescripcion;
    private javax.swing.JLabel jlblMarca;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JLabel jlblProducto;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpSeparador;
    private javax.swing.JTextArea jtxtADescripcion;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtMarca;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtPrecio;
    // End of variables declaration//GEN-END:variables
}

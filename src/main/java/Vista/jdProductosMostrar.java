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
public class jdProductosMostrar extends javax.swing.JDialog {

    private ControladoraProductos productos= new ControladoraProductos();
    private int x,y;
    
        
    public void cargarDatos(List<Producto> lista)
    {        
        try
        {
            String col[] = {"Código", "Marca", "Nombre", "Descripción", "Precio", "Stock","Modificar","Eliminar"};            

            JButton modificar= new JButton("Modificar");
            modificar.setText("Modificar");
            modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_20.png"))); 

            modificar.setBackground(new java.awt.Color(255,51,102));
            modificar.setFont(new java.awt.Font("Arial", 1, 14)); 
            modificar.setForeground(new java.awt.Color(255, 255, 255));                
            modificar.setBorderPainted(false);


            JButton eliminar= new JButton("Eliminar");
            eliminar.setText("Eliminar");
            eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trash_20.png"))); 

            eliminar.setBackground(new java.awt.Color(255,51,102));
            eliminar.setFont(new java.awt.Font("Arial", 1, 14)); 
            eliminar.setForeground(new java.awt.Color(255, 255, 255));                
            eliminar.setBorderPainted(false);

            DefaultTableModel tableModel = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            jtProductos.setModel(tableModel);

            jtProductos.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                      
            jtProductos.getColumnModel().getColumn(7).setCellRenderer(new miRenderer()); //funciona   


            lista.forEach((p) -> 
            {                                   
                Object[] datos = {p.getCodigoProducto(),p.getMarca(),p.getNombre(),p.getDescripcion(),"$"+p.getPrecio(),p.getStock(), modificar,eliminar};            
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
            String col[] = {"Código", "Marca", "Nombre", "Descripción", "Precio", "Stock","Modificar","Eliminar"};            

            JButton modificar= new JButton("Modificar");
            modificar.setText("Modificar");
            modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_20.png"))); 

            modificar.setBackground(new java.awt.Color(255,51,102));
            modificar.setFont(new java.awt.Font("Arial", 1, 14)); 
            modificar.setForeground(new java.awt.Color(255, 255, 255));                
            modificar.setBorderPainted(false);


            JButton eliminar= new JButton("Eliminar");
            eliminar.setText("Eliminar");
            eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trash_20.png"))); 

            eliminar.setBackground(new java.awt.Color(255,51,102));
            eliminar.setFont(new java.awt.Font("Arial", 1, 14)); 
            eliminar.setForeground(new java.awt.Color(255, 255, 255));                
            eliminar.setBorderPainted(false);

            DefaultTableModel tableModel = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            jtProductos.setModel(tableModel);

            jtProductos.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                      
            jtProductos.getColumnModel().getColumn(7).setCellRenderer(new miRenderer()); //funciona   


            if(p!=null)
            {                                   
                Object[] datos = {p.getCodigoProducto(),p.getMarca(),p.getNombre(),p.getDescripcion(),"$"+p.getPrecio(),p.getStock(), modificar,eliminar};            
                tableModel.addRow(datos);                   
            }                       
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Creates new form jdProductosMostrar
     */
    public jdProductosMostrar(java.awt.Frame parent, boolean modal) {
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
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpClientes = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jbtnCerrar = new javax.swing.JButton();
        jpSeparador = new javax.swing.JPanel();
        jpPrincipal = new javax.swing.JPanel();
        jbtnAgregar = new javax.swing.JButton();
        jlblBuscar = new javax.swing.JLabel();
        jcbFiltros = new javax.swing.JComboBox<>();
        jtxtFiltro = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jbtnFiltros = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jpProductos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jpSeparador1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(java.awt.SystemColor.controlHighlight);
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
        jlblTitulo.setText("Productos");
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
        jpClientes.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 110, -1));

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
        jpClientes.add(jbtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 0, 40, 40));

        getContentPane().add(jpClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 40));

        jpSeparador.setBackground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jpSeparadorLayout = new javax.swing.GroupLayout(jpSeparador);
        jpSeparador.setLayout(jpSeparadorLayout);
        jpSeparadorLayout.setHorizontalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jpSeparadorLayout.setVerticalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 960, 10));

        jpPrincipal.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jpPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

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

        jlblBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblBuscar.setText("Filtrar por:");

        jcbFiltros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Marca", "Nombre" }));
        jcbFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltrosActionPerformed(evt);
            }
        });

        jtxtFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtxtFiltro.setText("Valor a buscar....");
        jtxtFiltro.setEnabled(false);

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

        jpProductos.setBackground(java.awt.SystemColor.controlShadow);

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

        javax.swing.GroupLayout jpProductosLayout = new javax.swing.GroupLayout(jpProductos);
        jpProductos.setLayout(jpProductosLayout);
        jpProductosLayout.setHorizontalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpProductosLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jpProductosLayout.setVerticalGroup(
            jpProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpProductosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jlblBuscar)
                        .addGap(18, 18, 18)
                        .addComponent(jcbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jtxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(41, 41, 41)
                        .addComponent(jbtnFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addComponent(jpProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator1))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpPrincipalLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jlblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jcbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbtnFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jpPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 960, 460));

        jpSeparador1.setBackground(new java.awt.Color(255, 51, 102));

        javax.swing.GroupLayout jpSeparador1Layout = new javax.swing.GroupLayout(jpSeparador1);
        jpSeparador1.setLayout(jpSeparador1Layout);
        jpSeparador1Layout.setHorizontalGroup(
            jpSeparador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jpSeparador1Layout.setVerticalGroup(
            jpSeparador1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpSeparador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 780, 10));

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
            jdProductosAgregar productos= new jdProductosAgregar(this,true);
            productos.setLocationRelativeTo (null);
            productos.setVisible(true);
            this.dispose();;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        // TODO add your handling code here:
         try
        {

            int fila = jtProductos.rowAtPoint(evt.getPoint());
            int columna = jtProductos.columnAtPoint(evt.getPoint());
                        
            if ((fila > -1) && (columna > -1))
            {                         
                //modificar
                if(columna==6)
                {
                    //obtener id del cliente..
                    int id=(int)jtProductos.getValueAt(fila,0);
                    jdProductosAgregar miForm= new jdProductosAgregar(this,true,id);
                    this.dispose();
                    miForm.setLocationRelativeTo (null);
                    miForm.setVisible(true);                        
                    
                }
                if(columna==7)
                {            
                    int id=(int)jtProductos.getValueAt(fila,0);
                      if(productos.EliminarProducto(id)==true)
                      {
                          JOptionPane.showMessageDialog(null, "Se eliminó producto. ", "Información", JOptionPane.INFORMATION_MESSAGE);             
                          cargarDatos(productos.DevolverProductos());
                      }
                      else
                      {
                          JOptionPane.showMessageDialog(null, "No se puede eliminar producto porque tiene facturas emitidas. ", "Advertencia", JOptionPane.WARNING_MESSAGE);             
                      }
                }               
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtProductosMouseClicked

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
            java.util.logging.Logger.getLogger(jdProductosMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdProductosMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdProductosMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdProductosMostrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdProductosMostrar dialog = new jdProductosMostrar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnFiltros;
    private javax.swing.JComboBox<String> jcbFiltros;
    private javax.swing.JLabel jlblBuscar;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpProductos;
    private javax.swing.JPanel jpSeparador;
    private javax.swing.JPanel jpSeparador1;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField jtxtFiltro;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraClientes;
import Modelo.Cliente;
import Modelo.Telefono;
import Modelo.miRenderer;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hatake
 */
public class jdClientesBuscar extends javax.swing.JDialog {

    private int x,y;
    private ControladoraClientes clientes= new ControladoraClientes();
    
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpClientes = new javax.swing.JPanel();
        jlblTitulo = new javax.swing.JLabel();
        jbtnCerrar = new javax.swing.JButton();
        jpSeparador = new javax.swing.JPanel();
        jpPrincipal = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jlblBuscar = new javax.swing.JLabel();
        jcbFiltros = new javax.swing.JComboBox<>();
        jtxtFiltro = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jbtnFiltro = new javax.swing.JButton();
        jpDatos = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtClientes = new javax.swing.JTable();

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
        jlblTitulo.setText("Seleccionar Cliente");
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
        jpClientes.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 190, -1));

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
        jpClientes.add(jbtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 40, 40));

        getContentPane().add(jpClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 40));

        jpSeparador.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jpSeparadorLayout = new javax.swing.GroupLayout(jpSeparador);
        jpSeparador.setLayout(jpSeparadorLayout);
        jpSeparadorLayout.setHorizontalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 970, Short.MAX_VALUE)
        );
        jpSeparadorLayout.setVerticalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 970, 10));

        jpPrincipal.setBackground(java.awt.SystemColor.controlHighlight);
        jpPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));

        jlblBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblBuscar.setText("Filtrar por:");

        jcbFiltros.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jcbFiltros.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nro Cliente", "Apellido" }));
        jcbFiltros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFiltrosActionPerformed(evt);
            }
        });

        jtxtFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtxtFiltro.setText("Valor a buscar....");
        jtxtFiltro.setEnabled(false);

        jbtnBuscar.setBackground(new java.awt.Color(51, 102, 255));
        jbtnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Search_More_26.png"))); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.setBorder(null);
        jbtnBuscar.setBorderPainted(false);
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });

        jbtnFiltro.setBackground(new java.awt.Color(51, 102, 255));
        jbtnFiltro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnFiltro.setForeground(new java.awt.Color(255, 255, 255));
        jbtnFiltro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Refresh_20p.png"))); // NOI18N
        jbtnFiltro.setText("Quitar Filtro");
        jbtnFiltro.setBorder(null);
        jbtnFiltro.setBorderPainted(false);
        jbtnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnFiltroActionPerformed(evt);
            }
        });

        jpDatos.setBackground(java.awt.SystemColor.controlShadow);
        jpDatos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtClientes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jtClientes.setRowHeight(24);
        jtClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtClientes);

        jpDatos.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 880, 290));

        javax.swing.GroupLayout jpPrincipalLayout = new javax.swing.GroupLayout(jpPrincipal);
        jpPrincipal.setLayout(jpPrincipalLayout);
        jpPrincipalLayout.setHorizontalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jlblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jtxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(jpPrincipalLayout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator1)
                            .addComponent(jpDatos, javax.swing.GroupLayout.DEFAULT_SIZE, 923, Short.MAX_VALUE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jpPrincipalLayout.setVerticalGroup(
            jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jpPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlblBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(jpPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 970, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void cargarDatos(List<Cliente> lista)
    {        
        try
        {
        String col[] = {"Id","Apellido","Nombre","Dirección","Telefonos","Activo","Seleccionar"};            
        
        JButton seleccionar= new JButton("Seleccionar");
            seleccionar.setText("Seleccionar");
            seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Checkmark_20.png"))); 

            seleccionar.setBackground(new java.awt.Color(51, 102, 255));
            seleccionar.setFont(new java.awt.Font("Arial", 1, 14)); 
            seleccionar.setForeground(new java.awt.Color(255, 255, 255));                
            seleccionar.setBorderPainted(false);

        DefaultTableModel tableModel = new DefaultTableModel(col,0){
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        jtClientes.setModel(tableModel);
                                        
        jtClientes.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                      
        
        
        
            lista.forEach((cl) -> 
            {                   
                String listaTelefonos="";
                for(Telefono t: cl.getTelefonos())
                {
                    listaTelefonos=listaTelefonos + t.toString() +".  ";
                }

                String estado;
                if(cl.isActivo())
                    estado="Sí";
                else
                    estado="No";
                Object[] datos = {cl.getNroCliente(), cl.getApellido(),cl.getNombre(),cl.getDireccion(),listaTelefonos,estado, seleccionar};            
                tableModel.addRow(datos);                   
            });                          
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
        public void cargarDatos(Cliente cl)
    {        
        try
        {
        String col[] = {"Id","Apellido","Nombre","Dirección","Telefonos","Activo","Seleccionar"};            
        
        JButton seleccionar= new JButton("Seleccionar");
            seleccionar.setText("Seleccionar");
            seleccionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Checkmark_20.png"))); 

            seleccionar.setBackground(new java.awt.Color(51, 102, 255));
            seleccionar.setFont(new java.awt.Font("Arial", 1, 14)); 
            seleccionar.setForeground(new java.awt.Color(255, 255, 255));                
            seleccionar.setBorderPainted(false);


            
        DefaultTableModel tableModel = new DefaultTableModel(col,0){
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        jtClientes.setModel(tableModel);
                                        
        jtClientes.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                              
        
        
            
                String listaTelefonos="";
                for(Telefono t: cl.getTelefonos())
                {
                    listaTelefonos=listaTelefonos + t.toString() +".  ";
                }

                String estado;
                if(cl.isActivo())
                    estado="Sí";
                else
                    estado="No";
                Object[] datos = {cl.getNroCliente(), cl.getApellido(),cl.getNombre(),cl.getDireccion(),listaTelefonos,estado, seleccionar};            
                tableModel.addRow(datos);                   
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

        //constructores
    public jdClientesBuscar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {            
            cargarDatos(clientes.DevolverClientes());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public jdClientesBuscar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {            
            cargarDatos(clientes.DevolverClientes());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

        
    private void jlblTituloMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTituloMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y+ evt.getY()- y);
    }//GEN-LAST:event_jlblTituloMouseDragged

    private void jlblTituloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblTituloMousePressed
        // TODO add your handling code here:
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jlblTituloMousePressed

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jpClientesMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpClientesMouseDragged
        // TODO add your handling code here:
        this.setLocation(this.getLocation().x + evt.getX()-x, this.getLocation().y+ evt.getY()- y);
    }//GEN-LAST:event_jpClientesMouseDragged

    private void jpClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpClientesMousePressed
        // TODO add your handling code here:
        x= evt.getX();
        y= evt.getY();
    }//GEN-LAST:event_jpClientesMousePressed

    private void jtClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtClientesMouseClicked
        // TODO add your handling code here:
        try
        {

            int fila = jtClientes.rowAtPoint(evt.getPoint());
            int columna = jtClientes.columnAtPoint(evt.getPoint());

            if ((fila > -1) && (columna > -1))
            {
                if(columna==6)
                {
                    //obtener id del cliente..
                    int id=(int)jtClientes.getValueAt(fila,0);
                    jdFacturasAgregar.clienteBuscado= clientes.buscarClienteId(id);
                    this.dispose();                    
                }
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtClientesMouseClicked

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

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
        try
        {
            int indice=jcbFiltros.getSelectedIndex();
            if(indice==1)//apellido
            {
                cargarDatos(clientes.BuscarClientePorApellido(jtxtFiltro.getText()));
            }

            if(indice==0) //nro cliente
            {
                int id=Integer.parseInt(jtxtFiltro.getText());
                cargarDatos(clientes.buscarClienteId(id));
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

    private void jbtnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnFiltroActionPerformed
        // TODO add your handling code here:
        try
        {
            cargarDatos(clientes.DevolverClientes());
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnFiltroActionPerformed

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
            java.util.logging.Logger.getLogger(jdClientesBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdClientesBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdClientesBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdClientesBuscar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdClientesBuscar dialog = new jdClientesBuscar(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jbtnFiltro;
    private javax.swing.JComboBox<String> jcbFiltros;
    private javax.swing.JLabel jlblBuscar;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpDatos;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpSeparador;
    private javax.swing.JTable jtClientes;
    private javax.swing.JTextField jtxtFiltro;
    // End of variables declaration//GEN-END:variables
}

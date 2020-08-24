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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.hibernate.HibernateException;

/**
 *
 * @author Hatake
 */
public class jdClientesAgregar extends javax.swing.JDialog {

    private ControladoraClientes clientes= new ControladoraClientes();
    private ArrayList<Telefono> telefonos= new ArrayList<Telefono>();
            
    private Telefono.Numero num;
    private Telefono oTelefono;
    private int IdTelefonoLista;
    private Cliente clienteModificar=null;
    private int x,y;
    //MIS METODOS
    public void limpiarComponentesTelefonos()
    {
        jcbTipos.setSelectedIndex(0);
        jtxtArea.setText("");
        jtxtNumero.setText("");
    }
    
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
    
    public void cargarTelefonos(ArrayList<Telefono> telefonos)
    //public void cargarTelefonos(List<Telefono> telefonos)
    {
        try
        {
        String col[] = {"Tipo","Area","Numero","Modificar","Eliminar"};            
        
        JButton modificar= new JButton("Modificar");
        modificar.setText("Modificar");
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_20.png"))); 
        
        modificar.setBackground(new java.awt.Color(51, 102, 255));
        modificar.setFont(new java.awt.Font("Arial", 1, 14)); 
        modificar.setForeground(new java.awt.Color(255, 255, 255));                
        modificar.setBorderPainted(false);
                        
        
        JButton eliminar= new JButton("Eliminar");
        eliminar.setText("Eliminar");
        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/trash_20.png"))); 
        
        eliminar.setBackground(new java.awt.Color(51, 102, 255));
        eliminar.setFont(new java.awt.Font("Arial", 1, 14)); 
        eliminar.setForeground(new java.awt.Color(255, 255, 255));                
        eliminar.setBorderPainted(false);
        
        
        DefaultTableModel tableModel = new DefaultTableModel(col,0){
            @Override
            public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
        };
        jtTelefonos.setModel(tableModel);
                                        
        jtTelefonos.getColumnModel().getColumn(3).setCellRenderer(new miRenderer()); //funciona                                      
        jtTelefonos.getColumnModel().getColumn(4).setCellRenderer(new miRenderer()); //funciona                                      
        
        telefonos.forEach((t) -> 
        {                           
            Object[] datos = {t.getTipo(),t.getNumero().getCodigoArea(),t.getNumero().getNroTelefono(), modificar,eliminar};            
            tableModel.addRow(datos);                   
        });                          
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Creates new form jdClientesAgregar
     */
    public jdClientesAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
    
    //agregado este constructor para que pueda llamar un jdialog desde otro jdialog
    public jdClientesAgregar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
        jtxtNroCliente.setText(String.valueOf(clientes.proximoClienteId()));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //constructor para usar el mismo form de agregar para modificar.. 
    public jdClientesAgregar(javax.swing.JDialog parent, boolean modal, int idCliente) {
        super(parent, modal);
        initComponents();
        
        try
        {       
            clienteModificar=clientes.buscarClienteId(idCliente);
            jtxtNroCliente.setText(String.valueOf(clienteModificar.getNroCliente()));
            jtxtApellido.setText(clienteModificar.getApellido());
            jtxtNombre.setText(clienteModificar.getNombre());
            jtxtDireccion.setText(clienteModificar.getDireccion());
            jckbActivo.setSelected(clienteModificar.isActivo());
            
            telefonos.addAll(clienteModificar.getTelefonos());                                                            
            cargarTelefonos(telefonos);
            
            jlblTitulo.setText("Modificar Cliente");
            
            jbtnAgregarCliente.setEnabled(false);
            jbtnModificarCliente.setEnabled(true);
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
        jpDatosPersonales = new javax.swing.JPanel();
        jlblNroCliente = new javax.swing.JLabel();
        jtxtNroCliente = new javax.swing.JTextField();
        jlblApellido = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jlblNombre = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jlblDireccion = new javax.swing.JLabel();
        jtxtDireccion = new javax.swing.JTextField();
        jckbActivo = new javax.swing.JCheckBox();
        jpTelefonos = new javax.swing.JPanel();
        jlblTipoTelefono = new javax.swing.JLabel();
        jlblArea = new javax.swing.JLabel();
        jlblNumero = new javax.swing.JLabel();
        jcbTipos = new javax.swing.JComboBox<>();
        jbtnAgregarTelefono = new javax.swing.JButton();
        jbtnModificarTelefono = new javax.swing.JButton();
        jtxtArea = new javax.swing.JTextField();
        jtxtNumero = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTelefonos = new javax.swing.JTable();
        jbtnAgregarCliente = new javax.swing.JButton();
        jbtnModificarCliente = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jlblTelefono = new javax.swing.JLabel();
        jlblCliente1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jlblTelefonos = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

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
        jlblTitulo.setText("Agregar Cliente");
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
        jlblTitulo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlblTituloKeyPressed(evt);
            }
        });
        jpClientes.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 210, -1));

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
        jpClientes.add(jbtnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 0, 40, 40));

        getContentPane().add(jpClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 40));

        jpSeparador.setBackground(new java.awt.Color(51, 102, 255));

        javax.swing.GroupLayout jpSeparadorLayout = new javax.swing.GroupLayout(jpSeparador);
        jpSeparador.setLayout(jpSeparadorLayout);
        jpSeparadorLayout.setHorizontalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jpSeparadorLayout.setVerticalGroup(
            jpSeparadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jpSeparador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 760, 10));

        jpPrincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(0, 0, 0)));
        jpPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpDatosPersonales.setBackground(new java.awt.Color(204, 204, 204));
        jpDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblNroCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNroCliente.setText("Nro Cliente:");
        jpDatosPersonales.add(jlblNroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jtxtNroCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpDatosPersonales.add(jtxtNroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 100, -1));

        jlblApellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblApellido.setText("Apellido:");
        jpDatosPersonales.add(jlblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jtxtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtApellidoActionPerformed(evt);
            }
        });
        jpDatosPersonales.add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        jlblNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNombre.setText("Nombre:");
        jpDatosPersonales.add(jlblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, -1, 20));

        jtxtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });
        jpDatosPersonales.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 210, -1));

        jlblDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblDireccion.setText("Dirección:");
        jpDatosPersonales.add(jlblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jtxtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpDatosPersonales.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 299, -1));

        jckbActivo.setBackground(new java.awt.Color(204, 204, 204));
        jckbActivo.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jckbActivo.setText("Activo");
        jpDatosPersonales.add(jckbActivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jpPrincipal.add(jpDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 720, 120));

        jpTelefonos.setBackground(new java.awt.Color(204, 204, 204));
        jpTelefonos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlblTipoTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblTipoTelefono.setText("Tipo:");
        jpTelefonos.add(jlblTipoTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 59, -1));

        jlblArea.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblArea.setText("Código Area:");
        jpTelefonos.add(jlblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        jlblNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNumero.setText("Número:");
        jpTelefonos.add(jlblNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jcbTipos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jcbTipos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "F", "M" }));
        jpTelefonos.add(jcbTipos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 77, -1));

        jbtnAgregarTelefono.setBackground(new java.awt.Color(51, 102, 255));
        jbtnAgregarTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnAgregarTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add_Phone_20p.png"))); // NOI18N
        jbtnAgregarTelefono.setText("Agregar Tel");
        jbtnAgregarTelefono.setBorderPainted(false);
        jbtnAgregarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarTelefonoActionPerformed(evt);
            }
        });
        jpTelefonos.add(jbtnAgregarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jbtnModificarTelefono.setBackground(new java.awt.Color(51, 102, 255));
        jbtnModificarTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnModificarTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jbtnModificarTelefono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_20.png"))); // NOI18N
        jbtnModificarTelefono.setText("Modificar Tel");
        jbtnModificarTelefono.setBorderPainted(false);
        jbtnModificarTelefono.setEnabled(false);
        jbtnModificarTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarTelefonoActionPerformed(evt);
            }
        });
        jpTelefonos.add(jbtnModificarTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jtxtArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpTelefonos.add(jtxtArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 100, -1));

        jtxtNumero.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jpTelefonos.add(jtxtNumero, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 131, -1));

        jpPrincipal.add(jpTelefonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 720, 120));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jtTelefonos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtTelefonos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Tipo", "Código Area", "Número", "Modificar", "Eliminar"
            }
        ));
        jtTelefonos.setRowHeight(24);
        jtTelefonos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtTelefonosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtTelefonos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jpPrincipal.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 720, 150));

        jbtnAgregarCliente.setBackground(new java.awt.Color(51, 102, 255));
        jbtnAgregarCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnAgregarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Add_User_Male_20.png"))); // NOI18N
        jbtnAgregarCliente.setText("Agregar Cliente");
        jbtnAgregarCliente.setBorderPainted(false);
        jbtnAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarClienteActionPerformed(evt);
            }
        });
        jpPrincipal.add(jbtnAgregarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        jbtnModificarCliente.setBackground(new java.awt.Color(51, 102, 255));
        jbtnModificarCliente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnModificarCliente.setForeground(new java.awt.Color(255, 255, 255));
        jbtnModificarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Edit_20.png"))); // NOI18N
        jbtnModificarCliente.setText("Modificar Cliente");
        jbtnModificarCliente.setBorderPainted(false);
        jbtnModificarCliente.setEnabled(false);
        jbtnModificarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnModificarClienteActionPerformed(evt);
            }
        });
        jpPrincipal.add(jbtnModificarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, -1, -1));
        jpPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 720, 10));

        jlblTelefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblTelefono.setText("Teléfono:");
        jpPrincipal.add(jlblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 140, -1));

        jlblCliente1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblCliente1.setText("Datos del Cliente:");
        jpPrincipal.add(jlblCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, -1));
        jpPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 720, 10));

        jlblTelefonos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblTelefonos.setText("Lista de Teléfonos:");
        jpPrincipal.add(jlblTelefonos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 140, -1));
        jpPrincipal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 720, 10));

        getContentPane().add(jpPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 760, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarClienteActionPerformed
        // TODO add your handling code here:
        try
        {
            boolean continuar=true, activo=jckbActivo.isSelected();
            String nroCliente=jtxtNroCliente.getText(), apellido=jtxtApellido.getText(),nombre=jtxtNombre.getText(), direccion=jtxtDireccion.getText();
            int nro=Integer.parseInt(nroCliente);
            
            
            //validar campos no vacios
            if( !ingresoTexto(nroCliente) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese Nro de Cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(apellido) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese apellido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(nombre) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(direccion) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese dirección.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            //si estan completos los campos anteriores continua
            if(continuar)
            {
                JOptionPane.showMessageDialog(null,nro + " "+nombre+" "+apellido+" "+direccion , "Información", JOptionPane.INFORMATION_MESSAGE);
                if(clientes.AgregarCliente(nro, nombre, apellido, direccion, activo, telefonos))
                {
                    JOptionPane.showMessageDialog(null, "Se agregó cliente con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se agregó el cliente. Ya existe Cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Complete los datos del cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
    }//GEN-LAST:event_jbtnAgregarClienteActionPerformed

    private void jbtnAgregarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarTelefonoActionPerformed
        // TODO add your handling code here:
        try
        {
            boolean continuar=true;
            String area=jtxtArea.getText(), numero=jtxtNumero.getText(), tipo=jcbTipos.getSelectedItem().toString();
            int areaTelefono=Integer.parseInt(area), numeroTelefono=Integer.parseInt(numero);
            
            
            //validar campos no vacios
            if( !ingresoTexto(area) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese area de número de télefono.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(numero) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese número de télefono.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if(continuar)
            {
                num= new Telefono.Numero(areaTelefono,numeroTelefono);
                oTelefono= new Telefono(num,tipo);                                                                                
                
                
                telefonos.add(oTelefono);
                
                cargarTelefonos(telefonos);
                limpiarComponentesTelefonos();
                
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingrese los datos correspondientes al télefono.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(HibernateException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
        catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAgregarTelefonoActionPerformed

    private void jtTelefonosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtTelefonosMouseClicked
        // TODO add your handling code here:
        try
        {
            if(!telefonos.isEmpty())
            {
                int fila = jtTelefonos.rowAtPoint(evt.getPoint());
                int columna = jtTelefonos.columnAtPoint(evt.getPoint());
                
                String area=String.valueOf(jtTelefonos.getValueAt(fila,1)), numero=String.valueOf(jtTelefonos.getValueAt(fila,2));                        
                String tipo=jtTelefonos.getValueAt(fila,0).toString();
                        
                        
                //orden elementos en tabla: "Tipo","Area","Numero","Modificar","Eliminar"
                num= new Telefono.Numero(Integer.parseInt(area),Integer.parseInt(numero));
                oTelefono= new Telefono(num,tipo);
                
                if ((fila > -1) && (columna > -1))
                {         
                    if(columna==3) //modificar
                    {                                                
                        jcbTipos.setSelectedItem(tipo);
                        jtxtArea.setText(area);
                        jtxtNumero.setText(numero);
                        
                        jbtnAgregarTelefono.setEnabled(false);
                        jbtnModificarTelefono.setEnabled(true);                                                
                        
                        //obtengo la posicion de ese telefono en la lista para luego modificarlo
                        IdTelefonoLista= telefonos.indexOf(oTelefono);
                        
                    }
                    if(columna==4) //eliminar
                    {   
                        if(telefonos.remove(oTelefono))                                                  
                          {
                              JOptionPane.showMessageDialog(null, "Se eliminó télefono. ", "Información", JOptionPane.INFORMATION_MESSAGE);             
                              cargarTelefonos(telefonos);                              
                          }
                          else
                          {
                              JOptionPane.showMessageDialog(null, "No se eliminó telefono. "+ oTelefono.toString(), "Advertencia", JOptionPane.WARNING_MESSAGE);             
                          }                        
                        limpiarComponentesTelefonos();
                        jbtnAgregarTelefono.setEnabled(true);
                        jbtnModificarTelefono.setEnabled(false);                                        
                    }      
                    
                }
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtTelefonosMouseClicked

    private void jbtnModificarTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarTelefonoActionPerformed
        // TODO add your handling code here:
        try
        {
            boolean continuar=true;
            String area=jtxtArea.getText(), numero=jtxtNumero.getText(), tipo=jcbTipos.getSelectedItem().toString();
            int areaTelefono=Integer.parseInt(area), numeroTelefono=Integer.parseInt(numero);
            
            
            //validar campos no vacios
            if( !ingresoTexto(area) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese area de número de télefono.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(numero) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese número de télefono.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if(continuar)
            {
                num= new Telefono.Numero(areaTelefono,numeroTelefono);
                oTelefono= new Telefono(num,tipo);
                               
                telefonos.set(IdTelefonoLista, oTelefono);                                                                                        
                cargarTelefonos(telefonos);
                
                limpiarComponentesTelefonos();
                jbtnAgregarTelefono.setEnabled(true);
                jbtnModificarTelefono.setEnabled(false);
                
                JOptionPane.showMessageDialog(null, "Se modificó télefono.", "Información", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Ingrese los datos correspondientes al télefono.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
    }//GEN-LAST:event_jbtnModificarTelefonoActionPerformed

    private void jbtnModificarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnModificarClienteActionPerformed
        // TODO add your handling code here:
        
        try
        {
            boolean continuar=true, activo=jckbActivo.isSelected();
            String nroCliente=jtxtNroCliente.getText(), apellido=jtxtApellido.getText(),nombre=jtxtNombre.getText(), direccion=jtxtDireccion.getText();
            int nro=Integer.parseInt(nroCliente);
            
            
            //validar campos no vacios
            if( !ingresoTexto(nroCliente) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese Nro de Cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(apellido) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese apellido.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(nombre) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese nombre.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            if( !ingresoTexto(direccion) )
            {
                continuar=false;
                JOptionPane.showMessageDialog(null, "Ingrese dirección.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            
            //si estan completos los campos anteriores continua
            if(continuar)
            {
                
                if(clientes.ModificarCliente(nro, nombre, apellido, direccion, activo, telefonos))                
                {
                    JOptionPane.showMessageDialog(null, "Se modificó cliente con éxito.", "Información", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "No se modificó el cliente.Ya existe cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Complete los datos del cliente.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
    }//GEN-LAST:event_jbtnModificarClienteActionPerformed

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jtxtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtApellidoActionPerformed

    private void jlblTituloKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlblTituloKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlblTituloKeyPressed

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
            java.util.logging.Logger.getLogger(jdClientesAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdClientesAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdClientesAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdClientesAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdClientesAgregar dialog = new jdClientesAgregar(new javax.swing.JFrame(), true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton jbtnAgregarCliente;
    private javax.swing.JButton jbtnAgregarTelefono;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JButton jbtnModificarCliente;
    private javax.swing.JButton jbtnModificarTelefono;
    private javax.swing.JComboBox<String> jcbTipos;
    private javax.swing.JCheckBox jckbActivo;
    private javax.swing.JLabel jlblApellido;
    private javax.swing.JLabel jlblArea;
    private javax.swing.JLabel jlblCliente1;
    private javax.swing.JLabel jlblDireccion;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblNroCliente;
    private javax.swing.JLabel jlblNumero;
    private javax.swing.JLabel jlblTelefono;
    private javax.swing.JLabel jlblTelefonos;
    private javax.swing.JLabel jlblTipoTelefono;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpDatosPersonales;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpSeparador;
    private javax.swing.JPanel jpTelefonos;
    private javax.swing.JTable jtTelefonos;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtArea;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNroCliente;
    private javax.swing.JTextField jtxtNumero;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controladora.ControladoraFacturas;
import Modelo.Cliente;
import Modelo.DetalleFactura;
import Modelo.Factura;
import Modelo.Producto;
import Modelo.miRenderer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hatake
 */
public class jdFacturasAgregar extends javax.swing.JDialog {

    private ControladoraFacturas facturas= new ControladoraFacturas();
    //para poder guardar el cliente elegido desde el jdialog que sigue
    private Factura miFactura;
    public static Cliente clienteBuscado=null;
    public static Producto productoBuscado=null;
    private List<DetalleFactura> lista=new ArrayList<DetalleFactura>();
    private int cantidad;
    
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
    private int nroFactura;
    private Date fecha;
    private double iva;
    double totalSinIva=0, totalConIva=0, ivaCalculado=0;
    private int x,y;
    
    public void cargarDatos(List<DetalleFactura> listaDf)
    {                
        try
        {
            
            String col[] = {"Nro Item","Código Producto", "Nombre", "Precio", "Cantidad","Importe","Quitar"};            

            JButton quitar= new JButton("Quitar");
            quitar.setText("Quitar");
            quitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cancel_20.png"))); 

            quitar.setBackground(new java.awt.Color(255,204,51));
            quitar.setFont(new java.awt.Font("Arial", 1, 14)); 
            quitar.setForeground(new java.awt.Color(255, 255, 255));                
            quitar.setBorderPainted(false);


           
            DefaultTableModel tableModel = new DefaultTableModel(col,0){
                @Override
                public boolean isCellEditable(int rowIndex,int columnIndex){return false;}
            };
            jtProductos.setModel(tableModel);

            
            jtProductos.getColumnModel().getColumn(6).setCellRenderer(new miRenderer()); //funciona                                                  

            int nroItem=0;
            
            totalSinIva=0;  //agregado
            for(DetalleFactura df: listaDf)            
            {                         
                nroItem=nroItem+1;                                              
                cantidad=(int) df.getCantidad();
                Object[] datos = {nroItem,df.getProducto().getCodigoProducto() ,df.getProducto().getNombre(),"$"+df.getProducto().getPrecio(),cantidad,df.getProducto().getPrecio()* cantidad, quitar};                            
                tableModel.addRow(datos);                                   
                
                totalSinIva=totalSinIva+df.getProducto().getPrecio()*df.getCantidad();
                
            }   
            if(!listaDf.isEmpty())
            {
                jtxtTotalSinIva.setText(String.format( "%.2f",totalSinIva));
                ivaCalculado=totalSinIva*iva/100;
                totalConIva=totalSinIva+ ivaCalculado;
                jtxtIvaCalculado.setText(String.format( "%.2f",ivaCalculado));
                jtxtTotalConIva.setText(String.format( "%.2f",totalConIva));
            }
            else
            {
                jtxtTotalSinIva.setText(String.format( "%.2f",totalSinIva));
                jtxtTotalConIva.setText(String.format( "%.2f",totalSinIva));
                jtxtIvaCalculado.setText(String.format( "%.2f",totalSinIva));
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    public boolean buscarProductoEnLista(int codigoProducto)
    {
        boolean encontrado=false;
        try
        {            
            for(DetalleFactura df: lista)
            {
                if(df.getProducto().getCodigoProducto()==codigoProducto)
                    encontrado=true;
            }                                    
        }        
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
        
        return encontrado;        
    }
    
    /**
     * Creates new form jdFacturasAgregar
     */
    public jdFacturasAgregar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        try
        {
        clienteBuscado=null;
        productoBuscado=null;
        
        fecha= new Date();
        jtxtFecha.setText(formatoFecha.format(fecha));
                
        int ultimoNroFactura= facturas.proximoIdFactura();
        jtxtNroFactura.setText(String.valueOf( ultimoNroFactura));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public jdFacturasAgregar(javax.swing.JDialog parent, boolean modal) {
        super(parent, modal);
        initComponents();

        try
        {
        clienteBuscado=null;
        productoBuscado=null;
        
        fecha= new Date();
        jtxtFecha.setText(formatoFecha.format(fecha));
                
        int ultimoNroFactura= facturas.DevolverFacturas().size()+1;
        jtxtNroFactura.setText(String.valueOf( ultimoNroFactura));
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
        jpDatosPersonales = new javax.swing.JPanel();
        jtxtNroCliente = new javax.swing.JTextField();
        jlblApellido = new javax.swing.JLabel();
        jtxtApellido = new javax.swing.JTextField();
        jlblNombre = new javax.swing.JLabel();
        jtxtNombre = new javax.swing.JTextField();
        jlblDireccion = new javax.swing.JLabel();
        jtxtDireccion = new javax.swing.JTextField();
        jbtnBuscar = new javax.swing.JButton();
        jlblNroCliente1 = new javax.swing.JLabel();
        jlblNroCliente = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jlblProducto = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jpProducto = new javax.swing.JPanel();
        jlbCodigoProducto = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jlblNombre1 = new javax.swing.JLabel();
        jtxtNombreProducto = new javax.swing.JTextField();
        jlblPrecio = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jlblStock = new javax.swing.JLabel();
        jtxtStock = new javax.swing.JTextField();
        jlblCantidad = new javax.swing.JLabel();
        jtxtCantidad = new javax.swing.JTextField();
        jbtnBuscarProducto1 = new javax.swing.JButton();
        jbtnAgregarProducto = new javax.swing.JButton();
        jpLista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtProductos = new javax.swing.JTable();
        jlblLista = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jlblFactura = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jpFactura = new javax.swing.JPanel();
        jlblNroFactura = new javax.swing.JLabel();
        jtxtNroFactura = new javax.swing.JTextField();
        jlblFecha = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JTextField();
        jlblIva = new javax.swing.JLabel();
        jtxtIva = new javax.swing.JTextField();
        jtxtTotalSinIva = new javax.swing.JTextField();
        jlblTotalSinIva = new javax.swing.JLabel();
        jtxtTotalConIva = new javax.swing.JTextField();
        jlblTotalIva = new javax.swing.JLabel();
        jbtnAgregarFactura = new javax.swing.JButton();
        jlblIvaCalculado = new javax.swing.JLabel();
        jtxtIvaCalculado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setUndecorated(true);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });
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
        jlblTitulo.setText("Agregar Venta");
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
        jpClientes.add(jlblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 180, -1));

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

        jpSeparador.setBackground(new java.awt.Color(255, 204, 51));

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

        jpDatosPersonales.setBackground(new java.awt.Color(204, 204, 204));
        jpDatosPersonales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtNroCliente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNroCliente.setEnabled(false);
        jpDatosPersonales.add(jtxtNroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 70, -1));

        jlblApellido.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblApellido.setText("Apellido:");
        jpDatosPersonales.add(jlblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jtxtApellido.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtApellido.setEnabled(false);
        jpDatosPersonales.add(jtxtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 260, -1));

        jlblNombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNombre.setText("Nombre:");
        jpDatosPersonales.add(jlblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 20));

        jtxtNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtNombre.setEnabled(false);
        jpDatosPersonales.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 260, -1));

        jlblDireccion.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblDireccion.setText("Dirección:");
        jpDatosPersonales.add(jlblDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jtxtDireccion.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtDireccion.setEnabled(false);
        jpDatosPersonales.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 260, -1));

        jbtnBuscar.setBackground(new java.awt.Color(255, 204, 51));
        jbtnBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Customer_26.png"))); // NOI18N
        jbtnBuscar.setText("Seleccionar Cliente");
        jbtnBuscar.setBorder(null);
        jbtnBuscar.setBorderPainted(false);
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        jpDatosPersonales.add(jbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 185, 35));

        jlblNroCliente1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNroCliente1.setText("Nro Cliente:");
        jpDatosPersonales.add(jlblNroCliente1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jpPrincipal.add(jpDatosPersonales, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 390, 160));

        jlblNroCliente.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblNroCliente.setText("Cliente:");
        jpPrincipal.add(jlblNroCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));
        jpPrincipal.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 390, 20));

        jlblProducto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblProducto.setText("Producto:");
        jpPrincipal.add(jlblProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));
        jpPrincipal.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 440, 20));

        jpProducto.setBackground(new java.awt.Color(204, 204, 204));
        jpProducto.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbCodigoProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlbCodigoProducto.setText("Código:");
        jpProducto.add(jlbCodigoProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 14, -1, -1));

        jtxtCodigo.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtCodigo.setEnabled(false);
        jpProducto.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 83, -1));

        jlblNombre1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNombre1.setText("Nombre:");
        jpProducto.add(jlblNombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jtxtNombreProducto.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtNombreProducto.setEnabled(false);
        jpProducto.add(jtxtNombreProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 270, -1));

        jlblPrecio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblPrecio.setText("Precio:");
        jpProducto.add(jlblPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jtxtPrecio.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtPrecio.setEnabled(false);
        jpProducto.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 60, -1));

        jlblStock.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblStock.setText("Stock:");
        jpProducto.add(jlblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 50, -1));

        jtxtStock.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtStock.setEnabled(false);
        jpProducto.add(jtxtStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 50, -1));

        jlblCantidad.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblCantidad.setText("Cantidad:");
        jpProducto.add(jlblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, -1, -1));

        jtxtCantidad.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jpProducto.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 50, -1));

        jbtnBuscarProducto1.setBackground(new java.awt.Color(255, 204, 51));
        jbtnBuscarProducto1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnBuscarProducto1.setForeground(new java.awt.Color(255, 255, 255));
        jbtnBuscarProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Barcode_26.png"))); // NOI18N
        jbtnBuscarProducto1.setText("Seleccionar Producto");
        jbtnBuscarProducto1.setBorder(null);
        jbtnBuscarProducto1.setBorderPainted(false);
        jbtnBuscarProducto1.setPreferredSize(new java.awt.Dimension(167, 27));
        jbtnBuscarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarProducto1ActionPerformed(evt);
            }
        });
        jpProducto.add(jbtnBuscarProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 7, 185, 35));

        jbtnAgregarProducto.setBackground(new java.awt.Color(255, 204, 51));
        jbtnAgregarProducto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnAgregarProducto.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Shopping_Cart_26.png"))); // NOI18N
        jbtnAgregarProducto.setText("Agregar a Carrito");
        jbtnAgregarProducto.setBorder(null);
        jbtnAgregarProducto.setBorderPainted(false);
        jbtnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarProductoActionPerformed(evt);
            }
        });
        jpProducto.add(jbtnAgregarProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 185, 35));

        jpPrincipal.add(jpProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 440, 160));

        jpLista.setBackground(new java.awt.Color(204, 204, 204));

        jtProductos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jtProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nro Item", "Código Producto", "Producto", "Precio", "Cantidad", "Importe"
            }
        ));
        jtProductos.setRowHeight(20);
        jtProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtProductos);

        javax.swing.GroupLayout jpListaLayout = new javax.swing.GroupLayout(jpLista);
        jpLista.setLayout(jpListaLayout);
        jpListaLayout.setHorizontalGroup(
            jpListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 811, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );
        jpListaLayout.setVerticalGroup(
            jpListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                .addContainerGap())
        );

        jpPrincipal.add(jpLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 840, 170));

        jlblLista.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblLista.setText("Productos Seleccionados:");
        jpPrincipal.add(jlblLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));
        jpPrincipal.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 840, 20));

        jlblFactura.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblFactura.setText("Factura:");
        jpPrincipal.add(jlblFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));
        jpPrincipal.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 840, 20));

        jpFactura.setBackground(new java.awt.Color(204, 204, 204));

        jlblNroFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblNroFactura.setText("Nro Factura:");

        jtxtNroFactura.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jlblFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblFecha.setText("Fecha:");

        jtxtFecha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtFecha.setToolTipText("dd/mm/yyyy");

        jlblIva.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jlblIva.setText("IVA(%):");

        jtxtIva.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jtxtIva.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtIvaFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jpFacturaLayout = new javax.swing.GroupLayout(jpFactura);
        jpFactura.setLayout(jpFacturaLayout);
        jpFacturaLayout.setHorizontalGroup(
            jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFacturaLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jlblNroFactura)
                .addGap(7, 7, 7)
                .addComponent(jtxtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118)
                .addComponent(jlblFecha)
                .addGap(7, 7, 7)
                .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
                .addComponent(jlblIva)
                .addGap(7, 7, 7)
                .addComponent(jtxtIva, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );
        jpFacturaLayout.setVerticalGroup(
            jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpFacturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpFacturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblIva)
                    .addComponent(jtxtIva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblFecha)
                    .addComponent(jtxtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblNroFactura)
                    .addComponent(jtxtNroFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jpPrincipal.add(jpFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 840, 50));

        jtxtTotalSinIva.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtTotalSinIva.setEnabled(false);
        jpPrincipal.add(jtxtTotalSinIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 520, 150, -1));

        jlblTotalSinIva.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblTotalSinIva.setText("Total:");
        jpPrincipal.add(jlblTotalSinIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 520, -1, -1));

        jtxtTotalConIva.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtTotalConIva.setEnabled(false);
        jpPrincipal.add(jtxtTotalConIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 150, -1));

        jlblTotalIva.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblTotalIva.setText("Total c/IVA");
        jpPrincipal.add(jlblTotalIva, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 590, -1, -1));

        jbtnAgregarFactura.setBackground(new java.awt.Color(255, 204, 51));
        jbtnAgregarFactura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jbtnAgregarFactura.setForeground(new java.awt.Color(255, 255, 255));
        jbtnAgregarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Purchase_Order_26.png"))); // NOI18N
        jbtnAgregarFactura.setText("Agregar Factura");
        jbtnAgregarFactura.setBorder(null);
        jbtnAgregarFactura.setBorderPainted(false);
        jbtnAgregarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarFacturaActionPerformed(evt);
            }
        });
        jpPrincipal.add(jbtnAgregarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 630, 185, 30));

        jlblIvaCalculado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jlblIvaCalculado.setText("IVA:");
        jpPrincipal.add(jlblIvaCalculado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 560, -1, -1));

        jtxtIvaCalculado.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        jtxtIvaCalculado.setEnabled(false);
        jpPrincipal.add(jtxtIvaCalculado, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 560, 150, -1));

        getContentPane().add(jpPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 880, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jbtnCerrarActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        // TODO add your handling code here:
        try
        {                                       
            jdClientesBuscar clientes= new jdClientesBuscar(this,true);
//            this.dispose();
            clientes.setLocationRelativeTo (null);
            clientes.setVisible(true);                        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
        // TODO add your handling code here:
        try
        {                                    
            if(clienteBuscado!=null)                
            {
                jtxtApellido.setText(clienteBuscado.getApellido());
                jtxtNombre.setText(clienteBuscado.getNombre());
                jtxtDireccion.setText(clienteBuscado.getDireccion());
                jtxtNroCliente.setText(String.valueOf(clienteBuscado.getNroCliente()));
            }
            
            if(productoBuscado!=null)
            {
                jtxtCodigo.setText(String.valueOf(productoBuscado.getCodigoProducto()));
                jtxtNombreProducto.setText(productoBuscado.getNombre());
                jtxtPrecio.setText(String.valueOf(productoBuscado.getPrecio()));
                jtxtStock.setText(String.valueOf(productoBuscado.getStock()));
                
                
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowGainedFocus

    private void jbtnBuscarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarProducto1ActionPerformed
        // TODO add your handling code here:
        try
        {                                       
            jdProductosBuscar prod= new jdProductosBuscar(this,true);
            prod.setLocationRelativeTo (null);
            prod.setVisible(true);                        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnBuscarProducto1ActionPerformed

    private void jbtnAgregarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarFacturaActionPerformed
        // TODO add your handling code here:
        try
        {
            boolean continuar=true;                                   
            String mensaje="";            
            
            if(jtxtNroFactura.getText().isEmpty())
            {
                continuar=false;
                mensaje=mensaje+"Ingrese Nro de Factura.\n";
            }
            
            
            if(jtxtFecha.getText().isEmpty())
            {
                continuar=false;
                mensaje=mensaje+ "Ingrese Fecha válida.\n";
            }
            
            if(jtxtIva.getText().isEmpty())
            {
                continuar=false;
                mensaje=mensaje+"Ingrese IVA(valor entero).\n";
            }
                                    
            if(clienteBuscado==null)
            {
                continuar=false;
                mensaje=mensaje+ "Seleccione un cliente.\n";
            }
            
            if(lista.isEmpty())
            {
                continuar=false;
                mensaje=mensaje+ "Seleccione productos.\n";
            }
            
            
            
            if(continuar==true)
            {
                iva= Double.parseDouble(jtxtIva.getText());
                nroFactura= Integer.parseInt(jtxtNroFactura.getText());
                fecha = formatoFecha.parse(jtxtFecha.getText());    
                
                miFactura.setNroFactura(nroFactura);
                miFactura.setCliente(clienteBuscado);
                miFactura.setFecha(fecha);
                miFactura.setIva(iva);
                
                int i=0;
                
                for(DetalleFactura df:lista)
                {
                    i++;  
                    df.setFactura(miFactura);
                    df.setNroItem(i);
                         
                    //totalSinIva=totalSinIva+df.getProducto().getPrecio()*df.getCantidad();
                }
                
                miFactura.setTotalSinIva(totalSinIva);
                //totalConIva=totalSinIva+ totalSinIva*iva/100;
                miFactura.setTotalConIva(totalConIva);
                miFactura.setDetalleFactura(lista);
                
                
                if(facturas.AgregarFactura(nroFactura, fecha, totalSinIva, iva, totalConIva, clienteBuscado, lista))
                {
                    JOptionPane.showMessageDialog(null,"Se agregó Factura." , "Información", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
                else 
                {
                    JOptionPane.showMessageDialog(null,"No se agregó Factura." , "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null,mensaje , "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        }
        catch(ParseException e) // exception para simpledateformat
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAgregarFacturaActionPerformed

    private void jtProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtProductosMouseClicked
        // TODO add your handling code here:
        try
        {
            if(!lista.isEmpty())
            {
                int fila = jtProductos.rowAtPoint(evt.getPoint());
                int columna = jtProductos.columnAtPoint(evt.getPoint());
                
                int codigoProducto=(Integer)jtProductos.getValueAt(fila,1);
                
                
                if ((fila > -1) && (columna > -1))
                {                         
                    if(columna==6) //eliminar
                    {   
                        //JOptionPane.showMessageDialog(null, "Codigo producto: "+codigoProducto, "Información", JOptionPane.INFORMATION_MESSAGE);             
                        for(DetalleFactura df:lista)
                        {
                            if(df.getProducto().getCodigoProducto()==codigoProducto)
                            {                                
                                lista.remove(df);                                                                
                                break;
                            }
                        }
                        cargarDatos(lista);                        
                    }                          
                }
            }            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
         
    }//GEN-LAST:event_jtProductosMouseClicked

    private void jtxtIvaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtIvaFocusLost
        // TODO add your handling code here:
        try
        {
            if(jtxtIva.getText().isEmpty())
            {          
                JOptionPane.showMessageDialog(null, "Ingrese IVA(valor entero).", "Advertencia", JOptionPane.WARNING_MESSAGE);                
            }
            else
            {
                iva= Double.parseDouble(jtxtIva.getText());
                cargarDatos(lista);
            }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jtxtIvaFocusLost

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

    private void jbtnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarProductoActionPerformed
        // TODO add your handling code here:
        try
        {
            boolean continuar=true;            
            DetalleFactura miDetalle;
            String msj="";
            
            if(productoBuscado==null)
            {
                continuar=false;
                msj=msj+ "Seleccione un producto.\n";
            }
            
            if(jtxtCantidad.getText().isEmpty())
            {
                continuar=false;
                msj=msj+"Ingrese cantidad.\n";
            }
            
            if(jtxtIva.getText().isEmpty())
            {
                continuar=false;
                msj=msj+"Ingrese % Iva.\n";
            }
            
            
            if(continuar==true)
            {
                miFactura= new Factura();
                cantidad= Integer.parseInt(jtxtCantidad.getText());
                miDetalle= new DetalleFactura(miFactura,productoBuscado,0,cantidad);
                                                                               
                if(productoBuscado.getStock()<cantidad)
                {
                    JOptionPane.showMessageDialog(null, "Stock insuficiente.", "Advertencia", JOptionPane.WARNING_MESSAGE);                                        
                }
                else
                    if(this.buscarProductoEnLista(productoBuscado.getCodigoProducto() )==true)
                    {                
                        JOptionPane.showMessageDialog(null, "Ya se encuentra el producto seleccionado en lista.", "Advertencia", JOptionPane.WARNING_MESSAGE);                    
                    }                
                    else                                
                    {                
                        this.lista.add(miDetalle);                    
                        this.cargarDatos(lista);                
                    }
            }
            else
            {
                JOptionPane.showMessageDialog(null, msj, "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
                        
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Se ha producido un error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtnAgregarProductoActionPerformed

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
            java.util.logging.Logger.getLogger(jdFacturasAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jdFacturasAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jdFacturasAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jdFacturasAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                jdFacturasAgregar dialog = new jdFacturasAgregar(new javax.swing.JFrame(), true);
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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JButton jbtnAgregarFactura;
    private javax.swing.JButton jbtnAgregarProducto;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnBuscarProducto1;
    private javax.swing.JButton jbtnCerrar;
    private javax.swing.JLabel jlbCodigoProducto;
    private javax.swing.JLabel jlblApellido;
    private javax.swing.JLabel jlblCantidad;
    private javax.swing.JLabel jlblDireccion;
    private javax.swing.JLabel jlblFactura;
    private javax.swing.JLabel jlblFecha;
    private javax.swing.JLabel jlblIva;
    private javax.swing.JLabel jlblIvaCalculado;
    private javax.swing.JLabel jlblLista;
    private javax.swing.JLabel jlblNombre;
    private javax.swing.JLabel jlblNombre1;
    private javax.swing.JLabel jlblNroCliente;
    private javax.swing.JLabel jlblNroCliente1;
    private javax.swing.JLabel jlblNroFactura;
    private javax.swing.JLabel jlblPrecio;
    private javax.swing.JLabel jlblProducto;
    private javax.swing.JLabel jlblStock;
    private javax.swing.JLabel jlblTitulo;
    private javax.swing.JLabel jlblTotalIva;
    private javax.swing.JLabel jlblTotalSinIva;
    private javax.swing.JPanel jpClientes;
    private javax.swing.JPanel jpDatosPersonales;
    private javax.swing.JPanel jpFactura;
    private javax.swing.JPanel jpLista;
    private javax.swing.JPanel jpPrincipal;
    private javax.swing.JPanel jpProducto;
    private javax.swing.JPanel jpSeparador;
    private javax.swing.JTable jtProductos;
    private javax.swing.JTextField jtxtApellido;
    private javax.swing.JTextField jtxtCantidad;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtFecha;
    private javax.swing.JTextField jtxtIva;
    private javax.swing.JTextField jtxtIvaCalculado;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtNombreProducto;
    private javax.swing.JTextField jtxtNroCliente;
    private javax.swing.JTextField jtxtNroFactura;
    private javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxtStock;
    private javax.swing.JTextField jtxtTotalConIva;
    private javax.swing.JTextField jtxtTotalSinIva;
    // End of variables declaration//GEN-END:variables
}

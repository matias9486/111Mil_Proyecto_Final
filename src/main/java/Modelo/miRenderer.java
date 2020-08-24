/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Hatake
 */
public class miRenderer extends JButton implements  TableCellRenderer
{
//CONSTRUCTOR
    //clase necesaria para poder agregar un boton a una tabla..
    public miRenderer() 
    {
    //SET BUTTON PROPERTIES
    setOpaque(true);    
    }
    
    /*
    //recibe un objeto string y ese texto lo pone dentro de un boton comun pero no se puede modificar el boton porque recibe un objeto no un boton
    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj,boolean selected, boolean focused, int row, int col) 
    {
    //SET PASSED OBJECT AS BUTTON TEXT    
        setText((obj==null) ? "":obj.toString());                        
    return this;
    }
*/
    //recibe un boton con sus propiedades y lo dibuja dentro de una tabla
    @Override 
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {                        
            JButton button = (JButton)value;            
            return button;  
        }
        
    
    
   
}
    


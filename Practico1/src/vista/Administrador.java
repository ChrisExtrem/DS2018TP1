/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javax.swing.DefaultComboBoxModel;
import modelo.Color;
import modelo.Persistencia;
import modelo.Sucursal;
import modelo.Talle;

/**
 *
 * @author chris
 */
public class Administrador {
    
    private static VMenu vmenu;
    private static VSolicitud vsolicitud;
    private static VConsultar vconsultar;
    private static VExistencia vexistencia;
    private static VProcesar vprocesar;
    private static VPrenda vprenda;
    
    //Constructor
    public Administrador() {
    }
    
    //Metodos
    public static void abrirMenu()
    {
        vmenu=new VMenu(); //instancia la ventana
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
        for(Sucursal sucursal: Persistencia.getSucursales()){  //Utiliza un ForEach 
            modelo.addElement(sucursal.getNombre());   // para cargar OBJETOS SUCURSAL en el modelo de combobox  
        }
        vmenu.setComboBoxSucursal(modelo);//Setea(Reemplaza) el Modelo por defecto, por el ya definido aqui
        
        vmenu.setVisible(true); //hace visible la ventana
        vmenu.setLocationRelativeTo(null); //configura su posicion centrada
    }
    
    public static void abrirSolcitud()
    {
        vsolicitud=new VSolicitud(vmenu,true);//inicializa la ventana
        vsolicitud.setVisible(true);  //hace visible la ventana
    }
        
    public static void abrirConsultar()
    {
        vconsultar=new VConsultar(vmenu,true);
        vconsultar.setVisible(true);
    }
    
    public static void abrirExistencia()
    {
        vexistencia=new VExistencia(vmenu,true);
        vexistencia.setVisible(true);
    }
    
    public static void abrirProcesar()
    {
        vprocesar=new VProcesar(vconsultar,true);
        vprocesar.setVisible(true);
    }
    
    public static void abrirAgregarPrenda()
    {
        vprenda=new VPrenda(vsolicitud,true); //incializar ventana Vsolicitud
        
        //Carga con los datos Disponibles de Colores
                DefaultComboBoxModel modeloColor = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
                    for(Color color: Persistencia.getColores())
                    {  //Utiliza un ForEach 
                        modeloColor.addElement(color.getDescripcion());   // para cargar OBJETOS en el modelo de combobox  
                    }
                vprenda.setComboBoxColor(modeloColor);
        
        //Carga con los datos Disponibles de Talles
                DefaultComboBoxModel modeloTalle = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
                    for(Talle talle: Persistencia.getTalles())
                    {  //Utiliza un ForEach 
                        modeloTalle.addElement(talle.getDescripcion());   // para cargar OBJETOS en el modelo de combobox  
                    }
                vprenda.setComboBoxTalle(modeloTalle);
                
        vprenda.setVisible(true); //Hace Visible la Ventana
    }
    
    public static void abrirMdificarPrenda()
    {
        vprenda=new VPrenda(vsolicitud,true);
        vprenda.setVisible(true);
    }
    
}

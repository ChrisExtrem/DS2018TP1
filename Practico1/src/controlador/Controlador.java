/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Persistencia;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author grupo5
 */
public class Controlador {
    
    private Persistencia datos; //Clase para persistencia de Datos
    private VMenu vmenu; //Vista Menu Principal
    private VSolicitud vsolicitud; //Vista Generar Solicitudes
    private VConsultar vconsultar; //Vista Consultar Solicitudes
    private VExistencia vexistencia; //Vista Consultar Existencias
    private VPrenda vprenda;
    private VProcesar vprocesar;

    public Controlador() {
    }

    
    /*public void ejecutar(){  //Inicia el programa
        
        this.vmenu=new VMenu(this); //inicializa Menu Principal(VMenu) 
        this.vmenu.setVisible(true); //hace visible la Ventana
        this.vmenu.setLocationRelativeTo(null); //Setea la posicion en parametros x y
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
        for(Sucursal sucursal: this.datos.getSucursales()){  //Utiliza un ForEach 
            modelo.addElement(sucursal);   // para cargar OBJETOS SUCURSAL en el modelo de combobox  
        }
        this.vmenu.setComboBox(modelo);  //Setea(Reemplaza) el Modelo por defecto, por el ya definido aqui
        
    }*/

    
    
    public void llamadoMenu(String comando)  //llamada desde la ventana Menu Principal
    {
        switch(comando){ //comando contiene un String con un valor a interpretar
            /*case "MENU_GENERAR":  //Caso de Uso Realizar Solicitud
                this.vsolicitud=new VSolicitud(this, this.vmenu,true); //inicializa la ventana VSolicitud
           //aportandole: "El Controlador Mismo", "Ventana Padre", "Modal"(Pone esta ultima en primer plano)
                this.vsolicitud.setVisible(true); //Setea como visible la ventana
                this.vsolicitud.setLocationRelativeTo(null);  //Setea Posicion
                
                //Crea una Solicitud Temporal
                Solicitud solicitud = new Solicitud();
                
                
                break;*/
            
            case "MENU_CONSULTAR":
                //this.vconsultar = new VConsultar(this,this.vmenu,true);
                this.vconsultar.setVisible(true);
                this.vconsultar.setLocationRelativeTo(null);
                
                break;
            case "MENU_EXISTENCIAS":
                //this.vexistencia = new VExistencia(this,this.vmenu,true);
                this.vexistencia.setVisible(true);
                this.vexistencia.setLocationRelativeTo(null);
                
                break;                
            case "MENU_PRENDA":
                //this.vprenda=new VPrenda(this,this.vsolicitud,true);
                
                this.vprenda.setLocationRelativeTo(null);
                
                //Carga con los datos Disponibles de Prendas
                DefaultComboBoxModel modeloPrenda = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
                    for(Prenda prenda: this.datos.getPrendas())
                    {  //Utiliza un ForEach 
                        modeloPrenda.addElement(prenda);   // para cargar OBJETOS en el modelo de combobox  
                    }
                this.vprenda.setPrenda(modeloPrenda);
                
                //Carga con los datos Disponibles de Colores
                DefaultComboBoxModel modeloColor = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
                    for(Color color: this.datos.getColores())
                    {  //Utiliza un ForEach 
                        modeloColor.addElement(color);   // para cargar OBJETOS en el modelo de combobox  
                    }
                this.vprenda.setColor(modeloColor);
                
                //Carga con los datos Disponibles de Talles
                DefaultComboBoxModel modeloTalle = new DefaultComboBoxModel(); //Define un "Modelo" de ComboBox Vacio
                    for(Talle talle: this.datos.getTalles())
                    {  //Utiliza un ForEach 
                        modeloTalle.addElement(talle);   // para cargar OBJETOS en el modelo de combobox  
                    }
                this.vprenda.setTalle(modeloTalle);
                
                
                this.vprenda.setVisible(true);
                
                
                break;
            case "MENU_PROCESAR":
                //this.vprocesar=new VProcesar(this,this.vconsultar,true);
                this.vprocesar.setVisible(true);
                this.vprocesar.setLocationRelativeTo(null);
                
                break;
            case "AGREGAR_PRENDA":
                
               DefaultTableModel modeloTabla = (DefaultTableModel) this.vsolicitud.getTabla().getModel(); 
                modeloTabla.setColumnCount(0);
                modeloTabla.setNumRows(0);
                modeloTabla.addColumn("Prenda");
                modeloTabla.addColumn("Talle");
                modeloTabla.addColumn("Color");
                modeloTabla.addColumn("Cant Solicitada");
               Object[] fila = new Object[4];
               fila[0] = this.vprenda.getPrenda().getDescripcion();
               fila[1] =this.vprenda.getColor().getDescripcion();
               fila[2] =this.vprenda.getTalle().getDescripcion();
               fila[3] =this.vprenda.getCantidad();
               
               modeloTabla.addRow(fila);
               this.vsolicitud.setTabla(modeloTabla);
               
               this.vsolicitud.setVisible(true);
                break;
                
        }
    }
     
    
    public Persistencia getDatos() {
        return datos;
    }

    public void setDatos(Persistencia datos) {
        this.datos = datos;
    }
    
    
}



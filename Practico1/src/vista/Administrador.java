/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.time.LocalDate;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Color;
import modelo.Empresa;
import modelo.Existencia;
import modelo.LineaDeSolicitud;
import modelo.Persistencia;
import modelo.Solicitud;
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
        vconsultar=new VConsultar(vmenu,true); //inicializa la ventana
        
        //Carga la Tabla
        DefaultTableModel modeloTabla = (DefaultTableModel)vconsultar.getTabla().getModel();
        
        for(Solicitud solicitud:Persistencia.getSolicitudes()){
          
               Object[] fila = new Object[4];
               fila[0] = solicitud.getDate().toString();
               fila[1] = solicitud.getSucursalSolicitante().getNombre();
               fila[2] = solicitud.getSucursalProcesadora().getNombre();
               fila[3] = solicitud.getEstado().getTexto();
               modeloTabla.addRow(fila);
               
        }
        vconsultar.setTabla(modeloTabla);
        
        vconsultar.setVisible(true);
    }
    
    public static void abrirExistencia()
    {
        vexistencia=new VExistencia(vmenu,true);
        
        //Carga la Tabla
        DefaultTableModel modeloTabla = (DefaultTableModel)vexistencia.getTabla().getModel();
        
        for(Existencia existencia:Persistencia.buscarSucursal(vmenu.getSucursal()).getExistencias()){
          
               Object[] fila = new Object[4];
               fila[0] = existencia.getPrenda().getCodigo();
               fila[1] = existencia.getColor().getDescripcion();
               fila[2] = existencia.getTalle().getDescripcion();
               fila[3] = existencia.getCantidad();
               modeloTabla.addRow(fila);
               
        }
        vexistencia.setTabla(modeloTabla);
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
                
        vprenda.setTextFielCantidad(true); //Habilita los Campos
        vprenda.setTextFielPrenda(true);
                
        vprenda.setVisible(true); //Hace Visible la Ventana
    }
    
    public static void abrirMdificarPrenda()
    {
        vprenda=new VPrenda(vsolicitud,true);
        vprenda.setVisible(true);
    }
    
   public static void agregarLinea()
    {
        //Agregacion a la tabla
        DefaultTableModel modeloTabla = (DefaultTableModel)vsolicitud.getTabla().getModel(); 
               Object[] fila = new Object[4];
               fila[0] = vprenda.getPrenda();
               fila[1] =vprenda.getColor();
               fila[2] =vprenda.getTalle();
               fila[3] =vprenda.getCantidad();
               modeloTabla.addRow(fila);
               vsolicitud.setTabla(modeloTabla);
               
               //Agregacion de la Linea a vsolicitud.solicitud
               LineaDeSolicitud linea = new LineaDeSolicitud();
               linea.setPrenda(Persistencia.buscarPrenda(vprenda.getPrenda()));
               linea.setTalle(Persistencia.buscarTalle(vprenda.getTalle()));
               linea.setColor(Persistencia.buscarColor(vprenda.getColor()));
               linea.setCantidadSolicitada(vprenda.getCantidad());
               vsolicitud.getSolicitud().agregarLineaDeSolicitud(linea);
               System.out.println(vprenda.getPrenda());
    }
   
   public static void eliminarLinea()
   {
       DefaultTableModel modeloTabla = (DefaultTableModel)vsolicitud.getTabla().getModel();
       int lineaSelect = vsolicitud.getTabla().getSelectedRow();
       if(lineaSelect<0)
       {
           //Muestra un msj de error ya que la seleccion es invalida
           JOptionPane.showMessageDialog(vsolicitud, "Tabla Vacia o No Ha Seleccionado una fila");
       }else{
           //Rmueve la linea de la Tabla
       modeloTabla.removeRow(lineaSelect);
       vsolicitud.setTabla(modeloTabla);
       
       //Remueve la linea de vsolicitu.solicitud;
       vsolicitud.getSolicitud().getLista().remove(lineaSelect);
       }
   }
    
   public static void generarSolicitud()
   {
       Sucursal sucursalSolicitante = Persistencia.buscarSucursal(vmenu.getSucursal());
       LocalDate fecha =LocalDate.now();
       Solicitud solicitud = vsolicitud.getSolicitud();
       Empresa.generarSolicitud(sucursalSolicitante,fecha,solicitud);
   }
   
   //Funciones Auxiliares
   private static boolean isInteger(String cadena){
	try {
		Integer.parseInt(cadena);
		return true;
	} catch (NumberFormatException e){
		return false;
	}
}
}

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
    
    public static void abrirAgregarPrenda()
    {
        vprenda=new VPrenda(vsolicitud,true); //incializar ventana Vsolicitud
        Administrador.cargarCombosDeVentanaPrenda();
        vprenda.setHabilitaCantidad(true); //Habilita los Campos
        vprenda.setHabilitaPrenda(true);
        vprenda.setHabilitaColor(true);
        vprenda.setHabilitaTalle(true);
                
        vprenda.setVisible(true); //Hace Visible la Ventana
    }
    
   public static void agregarLinea()
    {
        if(!isInteger(vprenda.getPrenda()) || vprenda.getPrenda().isEmpty() || vprenda.getCantidad().isEmpty() || !isInteger(vprenda.getCantidad()))
        {
            //Muestra un msj de error ya que los datos son invalidos o los campos estan vacios
           JOptionPane.showMessageDialog(vprenda, "Campos Vacios o Datos incorrectos, por favor ingrese numeros");
        }else{
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
               linea.setPrenda(Persistencia.buscarPrenda(Integer.parseInt(vprenda.getPrenda())));
               linea.setTalle(Persistencia.buscarTalle(vprenda.getTalle()));
               linea.setColor(Persistencia.buscarColor(vprenda.getColor()));
               linea.setCantidadSolicitada(Integer.parseInt(vprenda.getCantidad()));
               vsolicitud.getSolicitud().agregarLineaDeSolicitud(linea);
               
               //Cierra la ventana
               vprenda.dispose();
        }
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
       if(!vsolicitud.getSolicitud().getLista().isEmpty())//Si la solicitud esta vacia, evita guardarla
       {
            Sucursal sucursalSolicitante = Persistencia.buscarSucursal(vmenu.getSucursal());
            LocalDate fecha =LocalDate.now();
            Solicitud solicitud = vsolicitud.getSolicitud();
            Empresa.generarSolicitud(sucursalSolicitante,fecha,solicitud);
       }
   }
   
   public static void abrirProcesar()
   {
       int lineaSelect =vconsultar.getTabla().getSelectedRow();//identifica que linea se ha Seleccionado
       
       if(lineaSelect<0)
       {
           //Muestra un msj de error ya que la seleccion es invalida
           JOptionPane.showMessageDialog(vconsultar, "Tabla Vacia o No Ha Seleccionado una Solicitud");
       }else{
           
           //Abre la ventana para editar la solicitud
           vprocesar=new VProcesar(vconsultar,true);
           Solicitud solicitudSelect = Persistencia.getSolicitudes().get(lineaSelect);
           
           //Carga los datos de la solicitud en ella
           vprocesar.setSolicitud(solicitudSelect);
           DefaultTableModel modeloTabla = (DefaultTableModel)vprocesar.getTabla().getModel();
        
           //Carga la tabla de LineaDeSolicitud
            for(LineaDeSolicitud linea:solicitudSelect.getLista()){
          
               Object[] fila = new Object[5];
               fila[0] = linea.getPrenda().getCodigo();
               fila[1] = linea.getColor().getDescripcion();
               fila[2] = linea.getTalle().getDescripcion();
               fila[3] = linea.getCantidadSolicitada();
               fila[4] = linea.getCantidadEnviada();
               modeloTabla.addRow(fila);
               
            }
            vprocesar.setTabla(modeloTabla);
            
            //Carga la Sucursal Solicitante y Procesadora
            vprocesar.setTxtSolicitante(solicitudSelect.getSucursalSolicitante().getNombre());
            vprocesar.setTxtProcesadora(solicitudSelect.getSucursalProcesadora().getNombre());
            
            //Hace visible la ventana
            vprocesar.setVisible(true);
            
       }
   }
   
   public static void abrirModificarLinea()
    {
        int lineaSelect =vprocesar.getTabla().getSelectedRow();//almacena la linea seleccionada
        
        if(lineaSelect<0)
       {
           //Muestra un msj de error ya que la seleccion es invalida
           JOptionPane.showMessageDialog(vsolicitud, "Tabla Vacia o No Ha Seleccionado una fila");
       }else{
           //Abre la ventana para modificarla
       vprenda=new VPrenda(vsolicitud,true); //instancia la ventana
       LineaDeSolicitud linea= vprocesar.getSolicitud().getLista().get(lineaSelect);
       
       Administrador.cargarCombosDeVentanaPrenda();
       vprenda.setPrenda(linea.getPrenda().getCodigo());
       vprenda.setColor(linea.getColor().getDescripcion());
       vprenda.setTalle(linea.getTalle().getDescripcion());
       vprenda.setHabilitaCantidad(true); //Habilita los Campos
       vprenda.setHabilitaPrenda(false);
       vprenda.setHabilitaColor(false);
       vprenda.setHabilitaTalle(false);
        
       vprenda.setVisible(true); //Hace visible la ventana
       }
    }
   
   //Funciones Auxiliares
   private static boolean isInteger(String cadena){
	try {
		Integer.parseInt(cadena.replaceAll("//S",""));
		return true;
	} catch (NumberFormatException e){
		return false;
	}
    }   
   
   private static void cargarCombosDeVentanaPrenda()
   {
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
   }
   
}

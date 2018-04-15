/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import controlador.Controlador;
import modelo.Persistencia;
import java.time.LocalDate;
import java.time.Month;
import modelo.*;
import vista.Administrador;
/**
 *
 * @author chris
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Controlador p1 =  new Controlador();
        Persistencia d1 = new Persistencia();
        
        //Crear Sucursales
        Sucursal suc1 =  new Sucursal(1,"Sucursal_1","Maipu 485");
        Sucursal suc2 =  new Sucursal(2,"Sucursal_2","25 de mayo 75");
        
        //Agregar Sucursales al Controlador
        d1.agregarSucursal(suc1);
        d1.agregarSucursal(suc2);
        
        //Crear Solicitudes Vacias
        Solicitud soli1 = new Solicitud();
        Solicitud soli2 = new Solicitud();
        
        //Agregar Solicitudes al Controlador
        d1.agregarSolicitud(soli1);
        d1.agregarSolicitud(soli2);
        
        //Crear Colores
        Color c1 = new Color("Rojo");
        Color c2 = new Color("Azul");
        
        //Agregar Colores al Controlador
        d1.agregarColor(c1);
        d1.agregarColor(c2);
        
        //Crear Talles
        Talle t1=new Talle("XL");
        Talle t2=new Talle("S");
        
        //Cargar Talles al Controlador
        d1.agregarTalle(t1);
        d1.agregarTalle(t2);
        
        //Crear Materiales
        Material m1 = new Material("Algodon");
        Material m2 = new Material("Poliester");
        
        
        //Agregar Materiales al Controlador
        d1.agregarMaterial(m1);
        d1.agregarMaterial(m2);
        
        //Crear Prendas
        Prenda prend1 = new Prenda(1,"Remera",250.56,m1);
        Prenda prend2 = new Prenda(2,"Pantalon",400.00,m2);
        
        //Agregar Prendas al Controlador
        d1.agregarPrenda(prend1);
        d1.agregarPrenda(prend2);
        
        /*LocalDate fecha =  LocalDate.now();
        System.out.println(fecha);
        LocalDate fecha2 = LocalDate.of(2018, Month.DECEMBER, 4);
        
        System.out.println(fecha2);
        System.out.println(fecha.compareTo(fecha2));
        
        System.out.println(fecha2.toString());*/
        
        /*p1.setDatos(d1);
        p1.ejecutar();*/
        
        Administrador.abrirMenu();
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.Persistencia;
import java.time.LocalDate;
import java.time.Month;
import modelo.*;
import vista.Administrador;
/**
 *
 * @author grupo5
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        //Crear Sucursales
        Sucursal suc1 =  new Sucursal(1,"Sucursal_1","Maipu 485");
        Sucursal suc2 =  new Sucursal(2,"Sucursal_2","25 de mayo 75");
        
        //Agregar Sucursales al Controlador
        Persistencia.agregarSucursal(suc1);
        Persistencia.agregarSucursal(suc2);
        
        //Crear Colores
        Color c1 = new Color("Rojo");
        Color c2 = new Color("Azul");
        
        //Agregar Colores al Controlador
        Persistencia.agregarColor(c1);
        Persistencia.agregarColor(c2);
        
        //Crear Talles
        Talle t1=new Talle("XL");
        Talle t2=new Talle("S");
        
        //Cargar Talles al Controlador
        Persistencia.agregarTalle(t1);
        Persistencia.agregarTalle(t2);
        
        //Crear Materiales
        Material m1 = new Material("Algodon");
        Material m2 = new Material("Poliester");
        
        
        //Agregar Materiales al Controlador
        Persistencia.agregarMaterial(m1);
        Persistencia.agregarMaterial(m2);
        
        //Crear Prendas
        Prenda prend1 = new Prenda(1,"Remera",250.56,m1);
        Prenda prend2 = new Prenda(2,"Pantalon",400.00,m2);
        
        //Agregar Prendas al Controlador
        Persistencia.agregarPrenda(prend1);
        Persistencia.agregarPrenda(prend2);
        
        //Crea Existencias
        Existencia ex1 = new Existencia(prend1,c1,t1,1);
        Existencia ex2 = new Existencia(prend2,c2,t2,2);
         
        //Agregar Existencias a las Sucursales;
        Persistencia.buscarSucursal("Sucursal_1").agregarExistencia(ex1);
        Persistencia.buscarSucursal("Sucursal_1").agregarExistencia(ex2);
        
        Existencia ex3 = new Existencia(prend2, c2, t2, 100);
        
        Persistencia.buscarSucursal("Sucursal_2").agregarExistencia(ex2);
        
        
        /*LocalDate fecha =  LocalDate.now();
        System.out.println(fecha);
        LocalDate fecha2 = LocalDate.of(2018, Month.DECEMBER, 4);
        
        System.out.println(fecha2);
        System.out.println(fecha.compareTo(fecha2));
        
        System.out.println(fecha2.toString());*/
        
        /*p1.setDatos(d1);
        p1.ejecutar();*/
        
        Administrador.abrirMenu();
        
        //System.out.println(Persistencia.getSolicitudes());
        //System.out.println(Persistencia.buscarSucursal("sucursal_1").getNombre());
    }
    
}

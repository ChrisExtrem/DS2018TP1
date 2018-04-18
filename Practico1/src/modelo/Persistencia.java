/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import modelo.Color;
import modelo.Material;
import modelo.Prenda;
import modelo.Solicitud;
import modelo.Sucursal;
import modelo.Talle;

/**
 *
 * @author grupo5
 */
public class Persistencia {
    
    private static ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>(); 
    private static ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
    private static ArrayList<Color> colores = new ArrayList<Color>();
    private static ArrayList<Talle> talles = new ArrayList<Talle>();
    private static ArrayList<Material> materiales = new ArrayList<Material>();
    private static ArrayList<Prenda> prendas = new ArrayList<Prenda>();

    //Constructor
    public Persistencia() {
    }
    
    //Metodos
    //Geters y Seters
    public static void agregarSucursal(Sucursal sucursal)
    {
        sucursales.add(sucursal);
    }
    
    public static void agregarSolicitud(Solicitud solicitud)
    {
        solicitudes.add(solicitud);
    }
    
    public static void agregarColor(Color color)
    {
        colores.add(color);
    }
    
    public static void agregarTalle(Talle talle)
    {
        talles.add(talle);
    }
    
    public static void agregarMaterial(Material material)
    {
        materiales.add(material);
    }
    
    public static void agregarPrenda(Prenda prenda)
    {
        prendas.add(prenda);
    }

    public static ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public static void setSucursales(ArrayList<Sucursal> sucursales) {
        Persistencia.sucursales = sucursales;
    }

    public static ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public static void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        Persistencia.solicitudes = solicitudes;
    }

    public static ArrayList<Color> getColores() {
        return colores;
    }

    public static void setColores(ArrayList<Color> colores) {
        Persistencia.colores = colores;
    }

    public static ArrayList<Talle> getTalles() {
        return talles;
    }

    public static void setTalles(ArrayList<Talle> talles) {
        Persistencia.talles = talles;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public static void setMateriales(ArrayList<Material> materiales) {
        Persistencia.materiales = materiales;
    }

    public ArrayList<Prenda> getPrendas() {
        return prendas;
    }

    public static void setPrendas(ArrayList<Prenda> prendas) {
        Persistencia.prendas = prendas;
    }
    
    //Busquedas
    public static Sucursal buscarSucursal(String sucursalBuscada)
    {
        Sucursal sucursalEncontrada= null;
        for(Sucursal sucursal: Persistencia.sucursales)
        {
            if(sucursal.getNombre().equals(sucursalBuscada))
            {
               sucursalEncontrada=sucursal;
            }
        }
        return sucursalEncontrada;
    }
    
    public static Prenda buscarPrenda(int prendaBuscada)
    {
        Prenda prendaEncontrada = new Prenda();
        
        return prendaEncontrada;
    }
    
    public static Talle buscarTalle(String talleBuscado)
    {
        Talle talleEncontrado = new Talle();
        
        return talleEncontrado;
    }
    
    public static Color buscarColor(String colorBuscado)
    {
        Color colorEncontrado = new Color();
        
        return colorEncontrado;
    }
}

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
    
    public void agregarMaterial(Material material)
    {
        this.materiales.add(material);
    }
    
    public void agregarPrenda(Prenda prenda)
    {
        this.prendas.add(prenda);
    }

    public static ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ArrayList<Color> getColores() {
        return colores;
    }

    public void setColores(ArrayList<Color> colores) {
        this.colores = colores;
    }

    public ArrayList<Talle> getTalles() {
        return talles;
    }

    public void setTalles(ArrayList<Talle> talles) {
        this.talles = talles;
    }

    public ArrayList<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(ArrayList<Material> materiales) {
        this.materiales = materiales;
    }

    public ArrayList<Prenda> getPrendas() {
        return prendas;
    }

    public void setPrendas(ArrayList<Prenda> prendas) {
        this.prendas = prendas;
    }
    
}

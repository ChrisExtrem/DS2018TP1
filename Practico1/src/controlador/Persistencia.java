/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.Color;
import modelo.Material;
import modelo.Prenda;
import modelo.Solicitud;
import modelo.Sucursal;
import modelo.Talle;

/**
 *
 * @author chris
 */
public class Persistencia {
    
    private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>(); 
    private ArrayList<Solicitud> solicitudes = new ArrayList<Solicitud>();
    private ArrayList<Color> colores = new ArrayList<Color>();
    private ArrayList<Talle> talles = new ArrayList<Talle>();
    private ArrayList<Material> materiales = new ArrayList<Material>();
    private ArrayList<Prenda> prendas = new ArrayList<Prenda>();

    public Persistencia() {
    }
    
    
    
    public void agregarSucursal(Sucursal sucursal)
    {
        this.sucursales.add(sucursal);
    }
    
    public void agregarSolicitud(Solicitud solicitud)
    {
        this.solicitudes.add(solicitud);
    }
    
    public void agregarColor(Color color)
    {
        this.colores.add(color);
    }
    
    public void agregarTalle(Talle talle)
    {
        this.talles.add(talle);
    }
    
    public void agregarMaterial(Material material)
    {
        this.materiales.add(material);
    }
    
    public void agregarPrenda(Prenda prenda)
    {
        this.prendas.add(prenda);
    }

    public ArrayList<Sucursal> getSucursales() {
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

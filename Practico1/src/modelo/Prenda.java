/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import modelo.Material;

/**
 *
 * @author chris
 */
public class Prenda {
    private int codigo;
    private String descripcion;
    private double precio;
    private Material material;

    public Prenda() {
    }


    public Prenda(int codigo, String descripcion, double precio, Material material) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.material = material;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return codigo + " - " + descripcion + ", precio: " + precio + ", material: " + material;
    }
    
    

}

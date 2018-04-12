/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author chris
 */
public class Existencia {
    
    private int cantidad;
    private Prenda prenda;
    private Color color;
    private Talle talle;

    public Existencia() {
    }

    public Existencia(int cantidad, Prenda prenda, Color color, Talle talle) {
        this.cantidad = cantidad;
        this.prenda = prenda;
        this.color = color;
        this.talle = talle;
    }

    
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }
    
    
    
}

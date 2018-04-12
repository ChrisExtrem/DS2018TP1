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
public class LineaDeSolicitud {
 
    private int cantidadSolicitada;
    private int cantidadEnviada;
    private Prenda prenda;
    private Talle talle;
    private Color color;

    public LineaDeSolicitud() {
    }

    public LineaDeSolicitud(int cantidadSolicitada, int cantidadEnviada, Prenda prenda, Talle talle, Color color) {
        this.cantidadSolicitada = cantidadSolicitada;
        this.cantidadEnviada = cantidadEnviada;
        this.prenda = prenda;
        this.talle = talle;
        this.color = color;
    }
    
    

    public int getCantidadSolicitada() {
        return cantidadSolicitada;
    }

    public void setCantidadSolicitada(int cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }

    public int getCantidadEnviada() {
        return cantidadEnviada;
    }

    public void setCantidadEnviada(int cantidadEnviada) {
        this.cantidadEnviada = cantidadEnviada;
    }

    public Prenda getPrenda() {
        return prenda;
    }

    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }

    public Talle getTalle() {
        return talle;
    }

    public void setTalle(Talle talle) {
        this.talle = talle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;

/**
 *
 * @author chris
 */
public class Solicitud {
    
    private Sucursal sucursalSolicitante;
    private LocalDate date;
    private Estado estado;
    
    private ArrayList<LineaDeSolicitud> lista = new ArrayList<LineaDeSolicitud>(); //Lista de la Linea de Solicitudes
    private Sucursal SucursalProcesadora;
    

    public Solicitud() {
    }

    public Solicitud(Sucursal sucursalSolicitante, LocalDate date, Estado estado) {
        this.sucursalSolicitante = sucursalSolicitante;
        this.date = date;
        this.estado = estado;
    }
    
    public Solicitud(Sucursal sucursalSolicitante, LocalDate date) {
        this.sucursalSolicitante = sucursalSolicitante;
        this.date = date;
    }

    //Metodos
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Sucursal getSucursalSolicitante() {
        return sucursalSolicitante;
    }

    public void setSucursalSolicitante(Sucursal sucursalSolicitante) {
        this.sucursalSolicitante = sucursalSolicitante;
    }

    public Sucursal getSucursalProcesadora() {
        return SucursalProcesadora;
    }

    public void setSucursalProcesadora(Sucursal SucursalProcesadora) {
        this.SucursalProcesadora = SucursalProcesadora;
    }

    public ArrayList<LineaDeSolicitud> getLista() {
        return lista;
    }

    public void setLista(ArrayList<LineaDeSolicitud> lista) {
        this.lista = lista;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public void agregarLineaDeSolicitud(LineaDeSolicitud linea)
    {
        this.lista.add(linea);
    }

    @Override
    public String toString() {
        return "Solicitud{" + "sucursalSolicitante=" + sucursalSolicitante + ", date=" + date + ", estado=" + estado + ", lista=" + lista + ", SucursalProcesadora=" + SucursalProcesadora + '}';
    }
    
    
}

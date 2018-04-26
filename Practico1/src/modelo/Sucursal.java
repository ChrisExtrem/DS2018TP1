/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author chris
 */
public class Sucursal{
    
    private int numero;
    private String nombre;
    private String direccion;
    private ArrayList<Existencia> existencias = new ArrayList<Existencia>();

    public Sucursal() {
    }

    public Sucursal(int numero, String nombre, String direccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Existencia> getExistencias() {
        return existencias;
    }

    public void setExistencias(ArrayList<Existencia> existencias) {
        this.existencias = existencias;
    }
    
    public void agregarExistencia(Existencia existencia)
    {
        this.existencias.add(existencia);
    }

    @Override
    public String toString() {
        return nombre;
    }
     
}

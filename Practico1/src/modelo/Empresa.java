/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author chris
 */
public class Empresa {

    public Empresa() {
    }
    
    public static void generarSolicitud(Sucursal sucursalSolicitante, LocalDate fecha, Solicitud solicitud)
    {
        solicitud.setSucursalSolicitante(sucursalSolicitante);
        solicitud.setDate(fecha);
        solicitud.setEstado(Estado.PENDIENTE);
        
        Persistencia.agregarSolicitud(solicitud);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author chris
 */
public class Administrador {
    
    private static VMenu vmenu;
    private static VSolicitud vsolicitud;
    private static VConsultar vconsultar;
    private static VExistencia vexistencia;
    private static VProcesar vprocesar;
    
    //Constructor
    public Administrador() {
    }
    
    //Metodos
    public static void abrirMenu()
    {
        vmenu=new VMenu();
        vmenu.setVisible(true);
        vmenu.setLocationRelativeTo(null);
    }
    
    public static void abrirSolcitud()
    {
        vsolicitud=new VSolicitud(vmenu,true);//inicializa la ventana VSolicitud
        vsolicitud.setVisible(true);
    }
        
    public static void abrirConsultar()
    {
        vconsultar=new VConsultar(vmenu,true);
        vconsultar.setVisible(true);
    }
    
    public static void abrirExistencia()
    {
        vexistencia=new VExistencia(vmenu,true);
        vexistencia.setVisible(true);
    }
    
    public static void abrirProcesar()
    {
        vprocesar=new VProcesar(vconsultar,true);
        vprocesar.setVisible(true);
    }
}

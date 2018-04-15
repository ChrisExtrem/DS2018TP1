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

    public Administrador() {
    }
    
    public static void generarSolcitud()
    {
        
    }
    
    public static void abrirMenu()
    {
        vmenu=new VMenu();
        vmenu.setVisible(true);
        vmenu.setLocationRelativeTo(null);
    }
    
    
}

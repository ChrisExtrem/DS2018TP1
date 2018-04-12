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
public enum Estado {
    
    PENDIENTE(0,"Pendiente"), RESUELTA(1,"Resuelta"), RESUELTAPARCIALMENTE(2,"Parcialmente");
    
    private int codigo;
    private String Texto;

    private Estado() {
    }
    
    

    private Estado(int codigo, String Texto) {
        this.codigo = codigo;
        this.Texto = Texto;
    }

    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTexto() {
        return Texto;
    }

    public void setTexto(String Texto) {
        this.Texto = Texto;
    }
    
    
}

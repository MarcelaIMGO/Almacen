/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Juan
 */
public class Almacen {
    
    private String nombre;
    
    /**
     * constructor
     * @param nombre 
     */
    public Almacen(String nombre){
        this.nombre = nombre;
    }
    
    public Almacen(){
        
    }

    /**
     * metodos set y get 
     * @return atributos
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}

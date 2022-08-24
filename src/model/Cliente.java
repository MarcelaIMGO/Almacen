package model;

import java.util.Objects;

public class Cliente {
    
    private String nombre, apellidos, direccion;
    private int id, telefono;
    private TipoCliente tipoCliente;

    /**
     * constructor
     * @param nombre
     * @param apellido
     * @param telefono
     * @param id
     * @param direccion
     * @param tipoCliente 
     */
    public Cliente(String nombre, String apellido, int telefono, int id, String direccion, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.apellidos = apellido;
        this.direccion = direccion;
        this.id = id;
        this.telefono = telefono;
        this.tipoCliente = tipoCliente;
    }

    public Cliente() {
        
    }

    /**
     * metodo set y get
     * @return atributos
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    /**
     * metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    /**
     * metodo equals
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.telefono != other.telefono) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (this.tipoCliente != other.tipoCliente) {
            return false;
        }
        return true;
    }

   
    
    
    
    
}

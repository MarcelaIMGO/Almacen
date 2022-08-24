package model;

import java.util.Objects;

public class Producto {
    
    private String nombre, descripcion;
    private int codigo, cantidadExistencia;
    private int valUnitario;
    private TipoProducto tipoProducto;

    /**
     * constructor
     * @param nombre
     * @param descripcion
     * @param codigo
     * @param cantidadExistencia
     * @param valUnitario
     * @param tipoProducto 
     */
    public Producto(String nombre, String descripcion, int codigo, int cantidadExistencia, int valUnitario, TipoProducto tipoProducto) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.codigo = codigo;
        this.cantidadExistencia = cantidadExistencia;
        this.valUnitario = valUnitario;
        this.tipoProducto = tipoProducto;
    }
    
    public Producto(){
        
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public void setCantidadExistencia(int cantidadExistencia) {
        this.cantidadExistencia = cantidadExistencia;
    }

    public int getValUnitario() {
        return valUnitario;
    }

    public void setValUnitario(int valUnitario) {
        this.valUnitario = valUnitario;
    }

    public TipoProducto getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(TipoProducto tipoProducto) {
        this.tipoProducto = tipoProducto;
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
        final Producto other = (Producto) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.cantidadExistencia != other.cantidadExistencia) {
            return false;
        }
        if (this.valUnitario != other.valUnitario) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (this.tipoProducto != other.tipoProducto) {
            return false;
        }
        return true;
    }

    
    
}

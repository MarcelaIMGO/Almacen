package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Venta {
    
    private int codigo;
    private LocalDate fecha;
    private String detalleVenta;
    private String clienteComprador;
    private float iva, total;

    /**
     * Constructor
     * @param codigo
     * @param fecha
     * @param detalleVenta
     * @param clienteComprador
     * @param iva
     * @param total 
     */
    public Venta(int codigo, LocalDate fecha, String detalleVenta, String clienteComprador, float iva, float total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.detalleVenta = detalleVenta;
        this.clienteComprador = clienteComprador;
        this.iva = iva;
        this.total = total;
    }
    
    public Venta(){
        
    }

    /** 
     * metodos set y get
     * @return atributos
     */
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDetalleVenta() {
        return detalleVenta;
    }

    public void setDetalleVenta(String detalleVenta) {
        this.detalleVenta = detalleVenta;
    }

    public String getClienteComprador() {
        return clienteComprador;
    }

    public void setClienteComprador(String clienteComprador) {
        this.clienteComprador = clienteComprador;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    /**
     * metodo hashcode
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Venta other = (Venta) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Float.floatToIntBits(this.iva) != Float.floatToIntBits(other.iva)) {
            return false;
        }
        if (Float.floatToIntBits(this.total) != Float.floatToIntBits(other.total)) {
            return false;
        }
        if (!Objects.equals(this.detalleVenta, other.detalleVenta)) {
            return false;
        }
        if (!Objects.equals(this.clienteComprador, other.clienteComprador)) {
            return false;
        }
        if (!Objects.equals(this.fecha, other.fecha)) {
            return false;
        }
        return true;
    }
    
    
    
    
    
}

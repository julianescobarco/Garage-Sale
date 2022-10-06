/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

/**
 *
 * @author usuario
 */
public class Producto {
    private int id;
    private String nombre;
    private String seccion;
    private String vendedor;
    private int inventario;
    private boolean novedad;

    public Producto(int id, String nombre, String seccion, String vendedor, int inventario, boolean novedad) {
        this.id = id;
        this.nombre = nombre;
        this.seccion = seccion;
        this.vendedor = vendedor;
        this.inventario = inventario;
        this.novedad = novedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public int getInventario() {
        return inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Producto{" + "id = " + id + ", nombre = " + nombre + ", seccion = " + seccion + ", vendedor = " + vendedor + ", inventario = " + inventario + ", novedad = " + novedad + '}';
    }

    public void add(String toJson) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

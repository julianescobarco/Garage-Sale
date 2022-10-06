/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;
import beans.Producto;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        
        listarProducto();
        
    }

    public static void actualizarProducto(int id, String seccion) {
        DBConnection con= new DBConnection();
        String sql = "UPDATE producto SET seccion = '" + seccion + " ' WHERE id = " + id;
        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarProducto() {
        DBConnection con = new DBConnection();
        String sql = "SELECT*FROM producto";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String seccion = rs.getString("seccion");
                String vendedor = rs.getString("vendedor");
                int inventario = rs.getInt("inventario");
                boolean novedad = rs.getBoolean("novedad");
                
                Producto producto = new Producto(id,nombre,seccion,vendedor,inventario,novedad);
                System.out.println(producto.toString());
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

}

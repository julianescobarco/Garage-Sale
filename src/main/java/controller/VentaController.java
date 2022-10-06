package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Venta;
import connection.DBConnection;

public class VentaController implements IVentaController {

    @Override
    public String listarVentas(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, l.nombre, l.seccion, l.novedad, a.fecha from producto l "
                + "inner join venta a on l.id = a.id inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> ventas = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String seccion = rs.getString("seccion");
                boolean novedad = rs.getBoolean("novedad");
                Date fechaVenta = rs.getDate("fecha");

                Venta venta = new Venta (id, nombre, fechaVenta, novedad, seccion);

                ventas.add(gson.toJson(venta));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(ventas);
    }
}
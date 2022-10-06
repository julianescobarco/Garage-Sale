package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombres, String apellidos, String email, double saldo, boolean premium);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevosNombres, String nuevosApellidos, String nuevoEmail,
            double nuevoSaldo, boolean nuevoPremium);

    public String verVenta(String username);

    public String devolverProducto(String username, Map<Integer, Integer> copias);

    public String eliminar(String username);

}

package controller;

public interface IProductoController {

    public String listar(boolean ordenar, String orden);

    public String devolver(int id, String username);

    public String sumarCantidad(int id);
}

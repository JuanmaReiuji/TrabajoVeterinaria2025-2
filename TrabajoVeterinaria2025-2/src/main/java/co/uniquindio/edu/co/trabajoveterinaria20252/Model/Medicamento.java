package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

public class Medicamento {
    private String nombre;
    private String cantidad;
    private String fabricante;
    private int codigo;

    public Medicamento(String nombre, String fabricante, String cantidad, int codigo) {
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre +
                ", cantidad: " + cantidad +
                ", fabricante: " + fabricante +
                ", codigo: " + codigo;
    }
}

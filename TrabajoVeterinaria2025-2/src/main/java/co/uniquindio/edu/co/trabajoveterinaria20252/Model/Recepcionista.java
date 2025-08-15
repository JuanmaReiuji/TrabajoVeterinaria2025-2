package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

public class Recepcionista extends Persona {
    private String contraseniaUnica;

    public Recepcionista(String nombre, int cedula, String direccion, int telefono, String contraseniaUnica) {
        super(nombre, cedula, direccion, telefono);
        this.contraseniaUnica = contraseniaUnica;
    }

    public String getContraseniaUnica() {
        return contraseniaUnica;
    }

    public void setContraseniaUnica(String contraseniaUnica) {
        this.contraseniaUnica = contraseniaUnica;
    }

    @Override
    public String toString() {
        return "Recepcionsta: " + super.toString();
    }

}

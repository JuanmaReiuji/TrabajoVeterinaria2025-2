package co.uniquindio.edu.co.trabajoveterinaria20252.ViewController;

import co.uniquindio.edu.co.trabajoveterinaria20252.App;
import co.uniquindio.edu.co.trabajoveterinaria20252.Model.Persona;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class pantallaLoginVeterinarioViewController {

    App app;
    ObservableList<Persona> listVeterinarios;

    @FXML
    TextField tfCedula;
    @FXML
    TextField tfContrasenia;

    public void setApp(App app) {
        this.app = app;
    }

    public void openPantallaBienvenida(){
        app.openPantallaBienvenida();
    }

    public void setListVeterinarios(ObservableList<Persona> listVeterinarios) {
        this.listVeterinarios = listVeterinarios;
    }

    public boolean validarDatos() {

        String cedulaStr = tfCedula.getText();
        String contrasenia = tfContrasenia.getText();
        int cedula;
        int codigoMascota;

        if (cedulaStr == null || cedulaStr.isEmpty()) {
            mostrarError("La cédula no puede estar vacía.");
            return false;
        }
        try {
            cedula = Integer.parseInt(cedulaStr);
        } catch (NumberFormatException e) {
            mostrarError("La cédula debe ser un número entero.");
            return false;
        }

        if (contrasenia == null || contrasenia.isEmpty()) {
            mostrarError("La Contrasenia no puede estar vacío.");
            return false;
        }
        boolean encontrado = false;

        for (Persona propietario: listVeterinarios) {
            if (propietario.getCedula() == cedula) {
                encontrado = true;
                if (propietario.getContrasenia().equals(contrasenia) && propietario.getContrasenia().equals(contrasenia)) {
                    app.openPantallaVeterinario();
                    return true;
                    
                } else {
                    mostrarError("Credenciales incorrectas.");
                    return false;
                }
            }
        }

        if (!encontrado) {
            mostrarError("No se ha encontrado la mascota.");
        }

        return false;
    }


    public void mostrarError(String error){
        app.mostrarError(error);
    }

}

package co.uniquindio.edu.co.trabajoveterinaria20252.ViewController;

import co.uniquindio.edu.co.trabajoveterinaria20252.App;
import co.uniquindio.edu.co.trabajoveterinaria20252.Model.Persona;
import co.uniquindio.edu.co.trabajoveterinaria20252.Model.Recepcionista;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class pantallaLoginRecepcionistaViewController {

    App app;
    Recepcionista recepcionista;

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

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public boolean validarDatos() {

        String cedulaStr = tfCedula.getText();
        String contrasenia = tfContrasenia.getText();
        int cedula;

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
            mostrarError("La contraseña no puede estar vacía.");
            return false;
        }

        if (this.recepcionista != null && this.recepcionista.getCedula() == cedula
                && this.recepcionista.getContrasenia().equals(contrasenia)) {
            return true;
        }

        mostrarError("Datos inválidos");
        return false;
    }


    public void mostrarError(String error){
        app.mostrarError(error);
    }

}

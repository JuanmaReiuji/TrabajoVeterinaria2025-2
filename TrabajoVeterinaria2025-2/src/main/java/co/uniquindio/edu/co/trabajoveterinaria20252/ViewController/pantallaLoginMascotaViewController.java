package co.uniquindio.edu.co.trabajoveterinaria20252.ViewController;

import co.uniquindio.edu.co.trabajoveterinaria20252.App;
import co.uniquindio.edu.co.trabajoveterinaria20252.Controller.VeterinariaController;
import co.uniquindio.edu.co.trabajoveterinaria20252.Model.Mascota;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class pantallaLoginMascotaViewController {
    App app;
    ObservableList<Mascota> listMascotas;

    @FXML
    TextField tfCedulaDuenio;
    @FXML
    TextField tfCodigo;


    VeterinariaController veterinariaController;

    public void setApp(App app) {
        this.app = app;
    }

    public void setListMascotas(ObservableList<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

    public void openPantallaBienvenida(){
        app.openPantallaBienvenida();
    }



    public boolean validarDatos() {

        String cedulaStr = tfCedulaDuenio.getText();
        String codigoStr = tfCodigo.getText();
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

        if (codigoStr == null || codigoStr.isEmpty()) {
            mostrarError("El código de la mascota no puede estar vacío.");
            return false;
        }
        try {
            codigoMascota = Integer.parseInt(codigoStr);
        } catch (NumberFormatException e) {
            mostrarError("El código de la mascota debe ser un número entero.");
            return false;
        }

        boolean encontrado = false;

        for (Mascota mascota : listMascotas) {
            if (mascota.getId() == codigoMascota) { // comparar con el código
                encontrado = true;
                if (mascota.getDuenio() != null && mascota.getDuenio().getCedula() == cedula) {
                    app.openPantallaMascota();
                    return true;
                } else {
                    mostrarError("El dueño no coincide con la cédula.");
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

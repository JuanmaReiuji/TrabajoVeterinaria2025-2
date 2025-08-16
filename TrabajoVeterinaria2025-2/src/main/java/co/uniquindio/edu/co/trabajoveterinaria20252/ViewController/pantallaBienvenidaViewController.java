package co.uniquindio.edu.co.trabajoveterinaria20252.ViewController;

import co.uniquindio.edu.co.trabajoveterinaria20252.App;

public class pantallaBienvenidaViewController {

    App app;

    public void setApp(App app) {
        this.app = app;
    }

    public void openPantallaLoginRecepcionista() {
        app.openPantallaLoginRecepcionista();
    }

    public void openPantallaLoginVeterinario() {
        app.openPantallaLoginVeterinario();
    }

    public void openPantallaLoginPropietario(){
        app.openPantallaLoginPropietario();
    }
    public void openPantallaLoginMascota() {
        app.openPantallaLoginMascota();
    }



    public void cerrarAplicacion() {
        app.cerrarAplicacion();
    }
}

package co.uniquindio.edu.co.trabajoveterinaria20252;


import co.uniquindio.edu.co.trabajoveterinaria20252.ViewController.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        inicializarData();
        this.stage = primaryStage;
        primaryStage.setTitle("Veterinaria");
        openPantallaBienvenida();

    }


    public void inicializarData() {}

    public void openPantallaBienvenida() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaBienvenida.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaBienvenidaViewController pantallaBienvenidaViewController = loader.getController();
            pantallaBienvenidaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


public void openPantallaLoginRecepcionista() {

    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaLoginRecepcionista.fxml"));
        AnchorPane rootLayout = loader.load();

        pantallaLoginRecepcionistaViewController pantallaLoginRecepcionistaViewController = loader.getController();
        pantallaLoginRecepcionistaViewController.setApp(this);

        Scene scene = new Scene(rootLayout);

        stage.setScene(scene);
        stage.setResizable(false);
        stage.centerOnScreen();

        stage.show();

    } catch (IOException ex) {
        ex.printStackTrace();
    }
}


    public void openPantallaLoginVeterinario() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaLoginVeterinario.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaLoginVeterinarioViewController pantallaLoginVeterinarioViewController = loader.getController();
            pantallaLoginVeterinarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaLoginPropietario() {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaLoginPropietario.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaLoginPropietarioViewController pantallaLoginPropietarioViewController = loader.getController();
            pantallaLoginPropietarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();

            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaLoginMascota() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaLoginMascota.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaLoginMascotaViewController pantallaLoginMascotaViewController = loader.getController();
            pantallaLoginMascotaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }




    public void cerrarAplicacion() {
         Platform.exit();

     }


}



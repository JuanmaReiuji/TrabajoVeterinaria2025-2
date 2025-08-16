package co.uniquindio.edu.co.trabajoveterinaria20252;


import co.uniquindio.edu.co.trabajoveterinaria20252.Model.*;
import co.uniquindio.edu.co.trabajoveterinaria20252.ViewController.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class App extends Application {
    private Stage stage;

    ObservableList<Persona> listVeterinarios = FXCollections.observableArrayList();
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    ObservableList<Persona> listPropietarios = FXCollections.observableArrayList();
    Recepcionista recepcionista;

    @Override
    public void start(Stage primaryStage) {
        inicializarData();
        this.stage = primaryStage;
        primaryStage.setTitle("Veterinaria");
        openPantallaBienvenida();

    }


    public void inicializarData() {
        Veterinaria veterinaria = new Veterinaria("Veterinaria",1234);
        Sede sede = new Sede("Armenia",1234,veterinaria);

        Recepcionista receptor = new Recepcionista("Pedro",123456789,"casa",12345,"pedro");

        Veterinario veterinario = new Veterinario("Juan",123456789,"casa",123456789, Especialidad.NEUROLOGÍA,"123");

        Propietario propietario = new Propietario("Pedro",123456789,"casa",12345,"pedro");
        Mascota mascota1 = new Mascota("Toby","Perro",3,2025,propietario);
        Mascota mascota2 = new Mascota("Luna","Gato",1,2024,propietario);

        veterinaria.registrarVeterinario(veterinario);
        veterinaria.registrarMascota(mascota1);
        veterinaria.registrarMascota(mascota2);
        veterinaria.registrarPropietario(propietario);
        this.recepcionista = receptor;

        listMascotas = FXCollections.observableArrayList(veterinaria.getListaMascotas());
        listVeterinarios = FXCollections.observableArrayList(veterinaria.getListaVeterinarios());
        listPropietarios = FXCollections.observableArrayList(veterinaria.getListaPropietarios());

    }

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
        pantallaLoginRecepcionistaViewController.setRecepcionista(recepcionista);

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
            pantallaLoginVeterinarioViewController.setListVeterinarios(listVeterinarios);

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
            pantallaLoginPropietarioViewController.setListPropietarios(listPropietarios);

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
            pantallaLoginMascotaViewController.setListMascotas(listMascotas);

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
    public void mostrarError(String error) {
        JOptionPane.showMessageDialog(null, error, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);

    }

    public ObservableList<Mascota> getListMascotas() {
        return listMascotas;
    }
    public ObservableList<Persona> getListPropietarios() {
        return listPropietarios;
    }
    public ObservableList<Persona> getListVeterinarios() {
        return listVeterinarios;
    }

    public void setListVeterinarios(ObservableList<Persona> listVeterinarios) {
        this.listVeterinarios = listVeterinarios;
    }
    public void setListPropietarios(ObservableList<Persona> listPropietarios) {
        this.listPropietarios = listPropietarios;
    }
    public void setListMascotas(ObservableList<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
    }

}



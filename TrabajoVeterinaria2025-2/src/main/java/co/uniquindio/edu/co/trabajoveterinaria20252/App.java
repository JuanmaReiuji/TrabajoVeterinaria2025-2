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
import java.time.LocalDate;

public class App extends Application {
    private Stage stage;

    ObservableList<Persona> listVeterinarios = FXCollections.observableArrayList();
    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    ObservableList<Persona> listPropietarios = FXCollections.observableArrayList();
    Recepcionista recepcionista;
    ObservableList<CitaAgendada> listCitasAgendadas = FXCollections.observableArrayList();
    ObservableList<CitaReporte> listCitasReporte = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        inicializarData();
        this.stage = primaryStage;
        primaryStage.setTitle("Veterinaria");
        openPantallaBienvenida();

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

    public void openPantallaRecepcionista() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaRecepcionista.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaRecepcionistaViewController pantallaRecepcionistaViewController = loader.getController();
            pantallaRecepcionistaViewController.setApp(this);
            pantallaRecepcionistaViewController.setListCitaAgendada(listCitasAgendadas);
            pantallaRecepcionistaViewController.setListCitaReporte(listCitasReporte);
            pantallaRecepcionistaViewController.setListMascotas(listMascotas);
            pantallaRecepcionistaViewController.setListVeterinarios(listVeterinarios);
            pantallaRecepcionistaViewController.setListDuenios(listPropietarios);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaPropietario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaPropietario.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaPropietarioViewController pantallaPropietarioViewController = loader.getController();
            pantallaPropietarioViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaMascota() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaMascota.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaMascotaViewController pantallaMascotaViewController = loader.getController();
            pantallaMascotaViewController.setApp(this);

            Scene scene = new Scene(rootLayout);

            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            stage.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void openPantallaVeterinario() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(
                    "/co/uniquindio/edu/co/trabajoveterinaria20252/pantallaVeterinario.fxml"));
            AnchorPane rootLayout = loader.load();

            pantallaVeterinarioViewController pantallaVeterinarioViewController = loader.getController();
            pantallaVeterinarioViewController.setApp(this);

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

    public void setListCitasAgendadas(ObservableList<CitaAgendada> listCitasAgendada) {
        this.listCitasAgendadas = listCitasAgendada;
    }

    public void setListCitasReportes(ObservableList<CitaReporte> listCitasReportes) {
        this.listCitasReporte = listCitasReportes;

    }

    public ObservableList<CitaReporte> getListCitasReportes() {
        return listCitasReporte;
    }

    public ObservableList<CitaAgendada> getListCitasAgendadas() {
        return listCitasAgendadas;
    }

    public void inicializarData() {
        Veterinaria veterinaria = new Veterinaria("Veterinaria Central", 1234);
        Sede sede = new Sede("Armenia", 1234, veterinaria);

        // Recepcionista único
        Recepcionista receptor = new Recepcionista("Pedro", 123456789, "Cra 10 #20-30", 12345, "pedro123");
        this.recepcionista = receptor;

        // ==== VETERINARIOS ====
        Veterinario vet1 = new Veterinario("Juan", 1111, "Armenia", 111, Especialidad.NEUROLOGÍA, "123");
        Veterinario vet2 = new Veterinario("María", 2222, "Calarcá", 222, Especialidad.CARDIOLOGÍA, "abc");
        Veterinario vet3 = new Veterinario("Luis", 3333, "Pereira", 333, Especialidad.OFTALMOLOGÍA, "pass1");
        Veterinario vet4 = new Veterinario("Ana", 4444, "Montenegro", 444, Especialidad.ANESTESIOLOGÍA, "pass2");
        Veterinario vet5 = new Veterinario("Carlos", 5555, "Circasia", 555, Especialidad.ONCOLOGÍA, "pass3");
        Veterinario vet6 = new Veterinario("Diana", 6666, "Quimbaya", 666, Especialidad.NEUROLOGÍA, "pass4");
        Veterinario vet7 = new Veterinario("Felipe", 7777, "Filandia", 777, Especialidad.CARDIOLOGÍA, "pass5");
        Veterinario vet8 = new Veterinario("Laura", 8888, "Córdoba", 888, Especialidad.OFTALMOLOGÍA, "pass6");
        Veterinario vet9 = new Veterinario("Mateo", 9999, "Sevilla", 999, Especialidad.ANESTESIOLOGÍA, "pass7");
        Veterinario vet10 = new Veterinario("Camila", 1010, "Caicedonia", 1010, Especialidad.ONCOLOGÍA, "pass8");

        // ==== PROPIETARIOS ====
        Propietario prop1 = new Propietario("Andrés", 201, "Calle 1", 1001, "andres");
        Propietario prop2 = new Propietario("Beatriz", 202, "Calle 2", 1002, "bea");
        Propietario prop3 = new Propietario("Claudia", 203, "Calle 3", 1003, "clau");
        Propietario prop4 = new Propietario("Daniel", 204, "Calle 4", 1004, "dan");
        Propietario prop5 = new Propietario("Elena", 205, "Calle 5", 1005, "ele");
        Propietario prop6 = new Propietario("Fernando", 206, "Calle 6", 1006, "fer");
        Propietario prop7 = new Propietario("Gabriela", 207, "Calle 7", 1007, "gaby");
        Propietario prop8 = new Propietario("Hernán", 208, "Calle 8", 1008, "her");
        Propietario prop9 = new Propietario("Isabel", 209, "Calle 9", 1009, "isa");
        Propietario prop10 = new Propietario("Jorge", 210, "Calle 10", 1010, "jor");

        // ==== MASCOTAS ====
        Mascota m1 = new Mascota("Toby", "Perro", 3, 2025, prop1);
        Mascota m2 = new Mascota("Luna", "Gato", 2, 2024, prop2);
        Mascota m3 = new Mascota("Rocky", "Perro", 5, 2023, prop3);
        Mascota m4 = new Mascota("Milo", "Gato", 1, 2025, prop4);
        Mascota m5 = new Mascota("Nina", "Perro", 4, 2022, prop5);
        Mascota m6 = new Mascota("Max", "Perro", 6, 2020, prop6);
        Mascota m7 = new Mascota("Kira", "Gato", 3, 2023, prop7);
        Mascota m8 = new Mascota("Simba", "Perro", 2, 2024, prop8);
        Mascota m9 = new Mascota("Coco", "Perro", 1, 2025, prop9);
        Mascota m10 = new Mascota("Sasha", "Gato", 7, 2019, prop10);

        // ==== CITAS AGENDADAS (futuras) ====
        CitaAgendada cita1 = new CitaAgendada(LocalDate.of(2025, 9, 20), "Vacunación", m1, vet1);
        CitaAgendada cita2 = new CitaAgendada(LocalDate.of(2025, 9, 21), "Chequeo general", m2, vet2);
        CitaAgendada cita3 = new CitaAgendada(LocalDate.of(2025, 9, 22), "Problemas de vista", m3, vet3);
        CitaAgendada cita4 = new CitaAgendada(LocalDate.of(2025, 9, 23), "Problemas neurológicos", m4, vet4);
        CitaAgendada cita5 = new CitaAgendada(LocalDate.of(2025, 9, 24), "Consulta de oncología", m5, vet5);
        CitaAgendada cita6 = new CitaAgendada(LocalDate.of(2025, 9, 25), "Chequeo anual", m6, vet6);
        CitaAgendada cita7 = new CitaAgendada(LocalDate.of(2025, 9, 26), "Dolor de corazón", m7, vet7);
        CitaAgendada cita8 = new CitaAgendada(LocalDate.of(2025, 9, 27), "Problema ocular", m8, vet8);
        CitaAgendada cita9 = new CitaAgendada(LocalDate.of(2025, 9, 28), "Cirugía programada", m9, vet9);
        CitaAgendada cita10 = new CitaAgendada(LocalDate.of(2025, 9, 29), "Control post-operatorio", m10, vet10);

        // ==== CITAS REPORTE (citas pasadas) ====
        CitaAgendada citaVieja1 = new CitaAgendada(LocalDate.of(2024, 12, 20), "Chequeo antiguo", m1, vet1);
        CitaReporte rep1 = new CitaReporte(true, vet1, citaVieja1, Tratamiento.CIRUGIA_DE_CATARATAS);

        CitaAgendada citaVieja2 = new CitaAgendada(LocalDate.of(2024, 11, 15), "Problema cardíaco", m2, vet2);
        CitaReporte rep2 = new CitaReporte(true, vet2, citaVieja2, Tratamiento.TRATAMIENTO_DE_INSUFICIENCIA_CARDIACA);

        CitaAgendada citaVieja3 = new CitaAgendada(LocalDate.of(2024, 10, 10), "Control cáncer", m3, vet5);
        CitaReporte rep3 = new CitaReporte(false, vet5, citaVieja3, null);

        CitaAgendada citaVieja4 = new CitaAgendada(LocalDate.of(2024, 9, 18), "Epilepsia", m4, vet6);
        CitaReporte rep4 = new CitaReporte(true, vet6, citaVieja4, Tratamiento.TRATAMIENTO_DE_EPILEPSIA);

        CitaAgendada citaVieja5 = new CitaAgendada(LocalDate.of(2024, 8, 12), "Anestesia", m5, vet4);
        CitaReporte rep5 = new CitaReporte(false, vet4, citaVieja5, null);

        CitaAgendada citaVieja6 = new CitaAgendada(LocalDate.of(2024, 7, 30), "Ulceras", m6, vet3);
        CitaReporte rep6 = new CitaReporte(true, vet3, citaVieja6, Tratamiento.TRATAMIENTO_DE_ULCERAS_CORNEALES);

        CitaAgendada citaVieja7 = new CitaAgendada(LocalDate.of(2024, 6, 25), "Oncología", m7, vet10);
        CitaReporte rep7 = new CitaReporte(false, vet10, citaVieja7, null);

        CitaAgendada citaVieja8 = new CitaAgendada(LocalDate.of(2024, 5, 22), "Hernias", m8, vet9);
        CitaReporte rep8 = new CitaReporte(true, vet9, citaVieja8, Tratamiento.CIRUGIA_DE_HERNIAS_DE_DISCO);

        CitaAgendada citaVieja9 = new CitaAgendada(LocalDate.of(2024, 4, 10), "Marcapasos", m9, vet7);
        CitaReporte rep9 = new CitaReporte(true, vet7, citaVieja9, Tratamiento.COLOCACION_DE_MARCAPASOS);

        CitaAgendada citaVieja10 = new CitaAgendada(LocalDate.of(2024, 3, 8), "Sedación", m10, vet8);
        CitaReporte rep10 = new CitaReporte(false, vet8, citaVieja10, null);

        // ==== REGISTROS ====
        veterinaria.registrarVeterinario(vet1); veterinaria.registrarVeterinario(vet2); veterinaria.registrarVeterinario(vet3);
        veterinaria.registrarVeterinario(vet4); veterinaria.registrarVeterinario(vet5); veterinaria.registrarVeterinario(vet6);
        veterinaria.registrarVeterinario(vet7); veterinaria.registrarVeterinario(vet8); veterinaria.registrarVeterinario(vet9);
        veterinaria.registrarVeterinario(vet10);

        veterinaria.registrarPropietario(prop1); veterinaria.registrarPropietario(prop2); veterinaria.registrarPropietario(prop3);
        veterinaria.registrarPropietario(prop4); veterinaria.registrarPropietario(prop5); veterinaria.registrarPropietario(prop6);
        veterinaria.registrarPropietario(prop7); veterinaria.registrarPropietario(prop8); veterinaria.registrarPropietario(prop9);
        veterinaria.registrarPropietario(prop10);

        veterinaria.registrarMascota(m1); veterinaria.registrarMascota(m2); veterinaria.registrarMascota(m3);
        veterinaria.registrarMascota(m4); veterinaria.registrarMascota(m5); veterinaria.registrarMascota(m6);
        veterinaria.registrarMascota(m7); veterinaria.registrarMascota(m8); veterinaria.registrarMascota(m9);
        veterinaria.registrarMascota(m10);

        listMascotas = FXCollections.observableArrayList(veterinaria.getListaMascotas());
        listVeterinarios = FXCollections.observableArrayList(veterinaria.getListaVeterinarios());
        listPropietarios = FXCollections.observableArrayList(veterinaria.getListaPropietarios());

        // Agendas y reportes
        listCitasAgendadas.addAll(cita1, cita2, cita3, cita4, cita5, cita6, cita7, cita8, cita9, cita10);
        listCitasReporte.addAll(rep1, rep2, rep3, rep4, rep5, rep6, rep7, rep8, rep9, rep10);
    }

}
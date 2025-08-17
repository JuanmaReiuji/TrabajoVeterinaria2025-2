package co.uniquindio.edu.co.trabajoveterinaria20252.ViewController;

import co.uniquindio.edu.co.trabajoveterinaria20252.App;
import co.uniquindio.edu.co.trabajoveterinaria20252.Model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.util.Random;



public class pantallaRecepcionistaViewController {

    App app;
    ObservableList<CitaAgendada> listCitaAgendada = FXCollections.observableArrayList();
    ObservableList<CitaReporte> listCitaReporte = FXCollections.observableArrayList();

    ObservableList<Mascota> listMascotas = FXCollections.observableArrayList();
    ObservableList<Persona> listVeterinarios = FXCollections.observableArrayList();

    ObservableList<Persona> listDuenios = FXCollections.observableArrayList();


    @FXML
    TextField tfNombreMascota;
    @FXML
    TextField tfEdad;
    @FXML
    TextField tfEspecie;
    private int contadorMascotas = 1;



    @FXML
    TableView<Mascota> tvMascotas;
    @FXML
    TableColumn<Mascota, String> tbNombreMascota;
    @FXML
    TableColumn<Mascota, String> tbEdadMascota;
    @FXML
    TableColumn<Mascota, String> tbEspecieMascota;
    @FXML
    TableColumn<Mascota, String> tbDuenio;


    @FXML
    ComboBox<Persona> cbDuenio;


    @FXML
    TextField tfNombreVeterinario;
    @FXML
    TextField tfCedulaVeterinario;
    @FXML
    TextField tfContraseniaVeterinario;
    @FXML
    TextField tfTelefonoVeterinario;

    @FXML
    ComboBox<Especialidad> cbEspecialidadVeterinario;

    @FXML
    TableView<Persona> tvVeterinarios;
    @FXML
    TableColumn<Persona, String> tbNombreVeterinario;
    @FXML
    TableColumn<Persona, String> tbCedulaVeterinario;
    @FXML
    TableColumn<Persona, String> tbTelefonoVeterinario;
    @FXML
    TableColumn<Persona, String> tbEspecialidadVeterinario;


    @FXML
    TableView<CitaReporte> tvCitasReporte;
    @FXML
    TableColumn<CitaReporte, String> tbMascotaReporte;
    @FXML
    TableColumn<CitaReporte, String> tbVeterinarioReporte;
    @FXML
    TableColumn<CitaReporte, String> tbFechaReporte;
    @FXML
    TableColumn<CitaReporte, String> tbTratamientoReporte;

    @FXML
    TableColumn<CitaReporte, String> tbAsistencia;




    @FXML
    DatePicker dpFecha;
    @FXML
    ComboBox<Mascota> cbMascota;
    @FXML
    ComboBox<Persona> cbVeterinario;
    @FXML
    TextArea tfMotivo;

    @FXML
    TableView<CitaAgendada> tvCitasAgendadas;
    @FXML
    TableColumn<CitaAgendada, String> tbVeterinarioAgendado;
    @FXML
    TableColumn<CitaAgendada, String> tbMascotaAgendada;
    @FXML
    TableColumn<CitaAgendada, String> tbFechaAgendada;
    @FXML
    TableColumn<CitaAgendada, String> tbMotivoAgendado;

    public void setListCitaReporte(ObservableList<CitaReporte> listCitaReporte) {
        this.listCitaReporte = listCitaReporte;
        tvCitasReporte.setItems(listCitaReporte);

    }
    public void setListCitaAgendada(ObservableList<CitaAgendada> listCitaAgendada) {
        this.listCitaAgendada = listCitaAgendada;
        this.tvCitasAgendadas.setItems(listCitaAgendada);
    }
    public void setListMascotas(ObservableList<Mascota> listMascotas) {
        this.listMascotas = listMascotas;
        cbMascota.setItems(listMascotas);
        tvMascotas.setItems(listMascotas);
    }
    public void setListVeterinarios(ObservableList<Persona> listVeterinarios) {
        this.listVeterinarios = listVeterinarios;
        cbVeterinario.setItems(listVeterinarios);
        tvVeterinarios.setItems(listVeterinarios);
    }
    public void setListDuenios(ObservableList<Persona> listDuenios) {
        this.listDuenios = listDuenios;
        cbDuenio.setItems(listDuenios);
    }

    public void setApp(App app) {
        this.app = app;

    }

    @FXML
    public void agregarVeterinario() {
        try {
            Veterinario v = new Veterinario(
                    tfNombreVeterinario.getText().trim(),
                    Integer.parseInt(tfCedulaVeterinario.getText().trim()),
                    "Sin dirección",
                    Integer.parseInt(tfTelefonoVeterinario.getText().trim()),
                    cbEspecialidadVeterinario.getValue(),
                    tfContraseniaVeterinario.getText().trim()
            );
            listVeterinarios.add(v);
           mostrarMensaje("Agregado correctamente");
        } catch (Exception e) {
            mostrarError("Error al crear veterinario: " + e.getMessage());
        }
    }

    public void agregarMascota() {
        try {
            String nombre = tfNombreMascota.getText();
            String especie = tfEspecie.getText();
            int edad = Integer.parseInt(tfEdad.getText());
            Persona duenio = cbDuenio.getValue();
            int id = 1000 + contadorMascotas;


            if (nombre.isEmpty() || especie.isEmpty() || duenio == null || edad < 0)
                throw new IllegalArgumentException("Datos inválidos.");

            Mascota nueva = new Mascota(nombre, especie, edad, id, duenio);
            app.getListMascotas().add(nueva);
            mostrarMensaje("Agregado correctamente");
            contadorMascotas ++;

        } catch (Exception e) {
            mostrarError("Error: " + e.getMessage());
        }
    }




    public void agendarCita() {
        try {
            // Validar que se seleccione una mascota
            Mascota mascota = cbMascota.getValue();
            if (mascota == null) {
                mostrarError("Debe seleccionar una mascota.");
                return;
            }

            // Validar que se seleccione un veterinario
            Persona veterinario = cbVeterinario.getValue();
            if (veterinario == null) {
                mostrarError("Debe seleccionar un veterinario.");
                return;
            }

            // Validar fecha
            LocalDate fecha = dpFecha.getValue();
            if (fecha == null) {
                mostrarError("Debe seleccionar una fecha.");
                return;
            }
            // La fecha debe ser desde mañana en adelante
            if (!fecha.isAfter(LocalDate.now())) {
                mostrarError("La fecha debe ser a partir de mañana.");
                return;
            }

            // Validar motivo
            String motivo = tfMotivo.getText();
            if (motivo == null || motivo.isEmpty()) {
                mostrarError("Debe ingresar un motivo.");
                return;
            }

            // Validar que la mascota no tenga ya una cita
            for (CitaAgendada cita : app.getListCitasAgendadas()) {
                if (cita.getMascotaAtendida().equals(mascota)) {
                    mostrarError("La mascota " + mascota.getNombre() + " ya tiene una cita agendada.");
                    return;
                }
            }

            // Crear la cita
            CitaAgendada nuevaCita = new CitaAgendada(fecha, motivo, mascota, veterinario);
            app.getListCitasAgendadas().add(nuevaCita);

            tvCitasAgendadas.refresh();

            // Mensaje de éxito
            mostrarMensaje("Cita agendada correctamente.");

        } catch (Exception e) {
            mostrarError("Ocurrió un error al agendar la cita: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void initialize() {

        tbFechaAgendada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        tbMascotaAgendada.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMascotaAtendida().getNombre()));
        tbMotivoAgendado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMotivo()));
        tbVeterinarioAgendado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getVeterinarioAsignado().getNombre()));


        tbFechaReporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDetallesCita().getFecha().toString()));
        tbMascotaReporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDetallesCita().getMascotaAtendida().getNombre()));
        tbVeterinarioReporte.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDetallesCita().getVeterinarioAsignado().getNombre()));

        tbNombreMascota.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getNombre()));
        tbEdadMascota.setCellValueFactory(cd -> new SimpleStringProperty(String.valueOf(cd.getValue().getEdad())));
        tbEspecieMascota.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getEspecie()));
        tbDuenio.setCellValueFactory(cd -> new SimpleStringProperty(cd.getValue().getDuenio().getNombre()));

        // Columna de asistencia (Sí / No)
        tbAsistencia.setCellValueFactory(cellData -> {
            boolean disponible = cellData.getValue().isAsistencia();
            String texto = disponible ? "Sí" : "No";
            return new SimpleStringProperty(texto);
        });

// Columna de tratamiento
        tbTratamientoReporte.setCellValueFactory(cellData -> {
            if (cellData.getValue().isAsistencia() && cellData.getValue().getTipoTratamiento() != null) {
                return new SimpleStringProperty(cellData.getValue().getTipoTratamiento().toString());
            } else {
                return new SimpleStringProperty("N/A");
            }
        });



        cbMascota.setConverter(new StringConverter<Mascota>() {
                @Override
                public String toString(Mascota mascota) {
                    return (mascota != null) ? mascota.getNombre() : "";
                }

                @Override
                public Mascota fromString(String s) {
                    return null;
                }
            });


        cbVeterinario.setConverter(new StringConverter<Persona>() {
            @Override
            public String toString(Persona persona) {
                return (persona != null) ? persona.getNombre() : "";
            }

            @Override
            public Persona fromString(String s) {
                return null;
            }
        });

        cbDuenio.setConverter(new StringConverter<Persona>() {
            @Override
            public String toString(Persona persona) {
                return (persona != null) ? persona.getNombre() : "";
            }

            @Override
            public Persona fromString(String s) {
                return null;
            }
        });

        tbNombreVeterinario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbCedulaVeterinario.setCellValueFactory(
                cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getCedula()))
        );

        tbEspecialidadVeterinario.setCellValueFactory(cellData -> {
            Persona persona = cellData.getValue();
            if (persona instanceof Veterinario veterinario) {
                // mostramos la especialidad como texto
                return new SimpleStringProperty(veterinario.getEspecialidad().toString());
            }
            // si no es Veterinario, mostrar vacío
            return new SimpleStringProperty("");
        });

        tbTelefonoVeterinario.setCellValueFactory(
                cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getTelefono()))
        );


    cbEspecialidadVeterinario.setItems(FXCollections.observableArrayList(Especialidad.values()));




    }
    public void mostrarError(String mensaje){
        app.mostrarError(mensaje);
    }
    public void mostrarMensaje(String mensaje){
        app.mostrarMensaje(mensaje);
    }
    public void openPantallaBienvenida(){
        app.openPantallaBienvenida();
    }
}

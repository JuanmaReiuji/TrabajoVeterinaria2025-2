package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Veterinaria {
    private String nombre;
    private int nit;
    private Recepcionista recepcionista;
    private List<Persona> listaPropietarios;
    private List<Persona> listaVeterinarios;
    private List<Mascota> listaMascotas;
    private List<CitaAgendada> citasAgendadas;
    private List<CitaReporte> listaReportesCitas;

    public Veterinaria(String nombre, int nit, Recepcionista recepcionista) {
        this.nombre = nombre;
        this.nit = nit;
        this.recepcionista = recepcionista;
        this.listaPropietarios = new ArrayList<>();
        this.listaVeterinarios = new ArrayList<>();
        this.listaMascotas = new ArrayList<>();
        this.citasAgendadas = new ArrayList<>();
        this.listaReportesCitas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public Recepcionista getRecepcionista() {
        return recepcionista;
    }

    public void setRecepcionista(Recepcionista recepcionista) {
        this.recepcionista = recepcionista;
    }

    public List<Persona> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(List<Persona> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }

    public List<Persona> getListaVeterinarios() {
        return listaVeterinarios;
    }

    public void setListaVeterinarios(List<Persona> listaVeterinarios) {
        this.listaVeterinarios = listaVeterinarios;
    }

    public List<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public void setListaMascotas(List<Mascota> listaMascotas) {
        this.listaMascotas = listaMascotas;
    }

    public List<CitaAgendada> getCitasAgendadas() {
        return citasAgendadas;
    }

    public void setCitasAgendadas(List<CitaAgendada> citasAgendadas) {
        this.citasAgendadas = citasAgendadas;
    }

    public List<CitaReporte> getListaReportesCitas() {
        return listaReportesCitas;
    }

    public void setListaReportesCitas(List<CitaReporte> listaReportesCitas) {
        this.listaReportesCitas = listaReportesCitas;
    }

    //Metodos relacionados a los propietarios
    public Optional<Persona> buscarPropietario(int cedula) {
        return listaPropietarios.stream().filter(p -> p.getCedula() == cedula).findFirst();
    }

    public boolean registrarPropietario(Persona nuevoPropietario) {
        Optional<Persona> propietarioAux = buscarPropietario(nuevoPropietario.getCedula());

        if (propietarioAux.isPresent()) {
            System.out.println("el propietario ya existe");
            return false;
        } else {
            listaPropietarios.add(nuevoPropietario);
            System.out.println("Propietario registrado");
            return true;
        }
    }

    //Metodos relacionados a las mascotas
    public Optional<Mascota> buscarMascota(int id) {
        return listaMascotas.stream().filter(m -> m.getId() == id).findFirst();
    }

    public boolean registrarMascota(Mascota nuevaMascota) {
        Optional<Mascota> MascotaAux = buscarMascota(nuevaMascota.getId());

        if (MascotaAux.isPresent()) {
            System.out.println("la mascota ya existe");
            return false;
        } else {
            listaMascotas.add(nuevaMascota);
            System.out.println("Mascota registrada");
            return true;
        }
    }


    //Metodos relacionados a los veterinarios
    public Optional<Persona> buscarVeterinario(int cedula) {
        return listaVeterinarios.stream().filter(v -> v.getCedula() == cedula).findFirst();
    }

    public boolean registrarVeterinario(Persona nuevoVeterinario) {
        Optional<Persona> veterinarioAux = buscarVeterinario(nuevoVeterinario.getCedula());

        if (veterinarioAux.isPresent()) {
            System.out.println("el veterinario ya existe");
            return false;
        } else {
            listaVeterinarios.add(nuevoVeterinario);
            System.out.println("Veterinario registrado");
            return true;
        }
    }

    //Metodos relacionados a la recepcionista
    public boolean loginRecepcionista(String cedula, String contraseniaUnica){
        return cedula.equals(recepcionista.getCedula()) && contraseniaUnica.equals(recepcionista.getContraseniaUnica());
    }


    //Metodos relacionados a las consultas
    public boolean agendarCita(CitaAgendada nuevaCita) {
        Optional<Persona> vAux = buscarVeterinario(nuevaCita.getVeterinarioAsignado().getCedula());
        Optional<Mascota> mAux = buscarMascota(nuevaCita.getMascotaAtendida().getId());

        if (!vAux.isPresent()) {
            System.out.println("El veterinario no existe");
            return false;
        }
        if (!mAux.isPresent()) {
            System.out.println("La mascota no existe");
            return false;
        }
        // Revisar si ya existe una cita igual
        for (CitaAgendada cita : citasAgendadas) {
            boolean mismaFecha = cita.getFecha().equals(nuevaCita.getFecha());
            boolean mismaMascota = cita.getMascotaAtendida().getId() == nuevaCita.getMascotaAtendida().getId();
            boolean mismoVet = cita.getVeterinarioAsignado().getCedula() == nuevaCita.getVeterinarioAsignado().getCedula();

            if (mismaFecha && mismaMascota && mismoVet) {
                System.out.println("La cita ya está agendada");
                return false;
            }
        }
        // Agregar si no existe
        citasAgendadas.add(nuevaCita);
        System.out.println("La cita se agendó correctamente");
        return true;


    }

    public boolean buscarCitasMascota(Mascota mascotaABuscar) {
        Optional<Mascota> mAux = buscarMascota(mascotaABuscar.getId());
        List<CitaAgendada> citasMascota = new ArrayList<>();

        if (!mAux.isPresent()) {
            System.out.println("La mascota no existe");
            return false;
        }

        for (CitaAgendada citaAux : citasAgendadas) {
            if (citaAux.getMascotaAtendida().getId() == mascotaABuscar.getId()) {
                citasMascota.add(citaAux);
            }
        }
        System.out.println("Citas de " + mascotaABuscar.getNombre() + ": \n" + citasMascota);
        return true;
    }

    public boolean buscarCitasPorFecha(LocalDate fechaBuscada) {
        List<CitaAgendada> citasDelDia = new ArrayList<>();

        for (CitaAgendada citaAux : citasAgendadas) {
            if (citaAux.getFecha().equals(fechaBuscada)) {
                citasDelDia.add(citaAux);
            }
        }

        if (citasDelDia.isEmpty()) {
            System.out.println("No hay citas para la fecha: " + fechaBuscada);
            return false;
        }

        System.out.println("Citas del " + fechaBuscada + ":\n" + citasDelDia);
        return true;
    }

    @Override
    public String toString() {
        return "Veterinaria" + nombre +
                ", nit: " + nit +
                ", recepcionista: " + recepcionista +
                ".\nLista de propietarios: " + listaPropietarios +
                ".\nLista de veterinarios: " + listaVeterinarios +
                ".\nLista de mascotas: " + listaMascotas +
                ".\nCitas agendadas: " + citasAgendadas +
                ". Citas reportadas : " + listaReportesCitas;
    }
}
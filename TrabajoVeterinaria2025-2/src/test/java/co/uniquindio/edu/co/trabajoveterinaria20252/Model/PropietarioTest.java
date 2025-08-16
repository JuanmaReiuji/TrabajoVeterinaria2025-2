package co.uniquindio.edu.co.trabajoveterinaria20252.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PropietarioTest {
    private Propietario propietario;
    private Mascota mascota;
    @BeforeEach
    void setUp() {
        propietario = new Propietario("Juan Pérez", 123, "Calle 1", 300111222);
        mascota = new Mascota("Milo", "Perro", 2, 321, propietario, null);
    }

    @Test
    void testGetNombre(){
        String esperado = "Juan Pérez";
        assertEquals(esperado, propietario.getNombre());
    }

    @Test
    void testSetNombre() {
        String nuevoNombre = "Pepito";
        propietario.setNombre(nuevoNombre);
        assertEquals(nuevoNombre, propietario.getNombre());
    }

    @Test
    void testGetListaMascotas() {
        int esperado = 0;
        assertEquals(0, propietario.getListaMascotas().size());
    }

    @Test
    void testSetListaMascotas() {
        ArrayList<Mascota> listaMascotasNueva = new ArrayList<>();
        listaMascotasNueva.add(mascota);

        propietario.setListaMascotas(listaMascotasNueva);

        assertEquals(1, propietario.getListaMascotas().size() );
    }

    @Test
    void testToString() {
        String esperado = "Propietario: " + "nombre: " + propietario.getNombre() +
                ", cedula: " + propietario.getCedula() +
                ", telefono: " + propietario.getTelefono() +
                ", direccion:" + propietario.getDireccion() +
                ". Lista de mascotas: " + propietario.getListaMascotas();

        assertEquals(esperado, propietario.toString());
    }
}
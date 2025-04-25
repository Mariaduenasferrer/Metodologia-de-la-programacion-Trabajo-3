

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Ejercicio1Test {

    @Test
    void leerAlumnoDesdeArchivoDebeCargarDatosCorrectos() {
        String rutaArchivo = "alumno.json";
        Ejercicio1.Alumno alumno = Ejercicio1.leerAlumnoDesdeArchivo(rutaArchivo);

        assertNotNull(alumno, "El alumno no debería ser nulo.");
        assertEquals("Juan Pérez", alumno.getNombre());
        assertEquals(20, alumno.getEdad());
        assertEquals("Informática", alumno.getCarrera());
        assertEquals(7.5, alumno.getNotaMedia(), 0.01);
        assertTrue(alumno.isMatriculado(), "El alumno debería estar matriculado.");
    }
}

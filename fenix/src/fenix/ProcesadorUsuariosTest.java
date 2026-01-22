package fenix;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class ProcesadorUsuariosTest {

    private procesadorUsuarios procesador;

    @BeforeEach
    void setUp() {
        // Inicializamos el objeto antes de cada test
        procesador = new procesadorUsuarios();
    }

    @Test
    void testProcesarLista_Exito() {
        List<String> datos = Arrays.asList("Hicham:1", "Ana:2", "Pedro:1");
        String resultado = procesador.procesarLista(datos);
        
        // Verificamos que los admins y los invitados estén en su lugar
        assertEquals("Admins: Hicham,Pedro, | Invitados: Ana,", resultado);
    }

    @Test
    void testProcesarLista_Vacia() {
        List<String> datos = new ArrayList<>();
        String resultado = procesador.procesarLista(datos);
        
        assertEquals("Admins:  | Invitados: ", resultado);
    }

    @Test
    void testProcesarLista_FormatoIncorrecto() {
        // Un elemento sin ":" no debería romper el programa ni añadir nada
        List<String> datos = Arrays.asList("UsuarioInvalido", "Juan:1");
        String resultado = procesador.procesarLista(datos);
        
        assertEquals("Admins: Juan, | Invitados: ", resultado);
    }

    @Test
    void testProcesarLista_RolDesconocido() {
        // Si el rol no es 1 ni 2, no debería aparecer en el string de salida
        List<String> datos = Arrays.asList("Extraño:99");
        String resultado = procesador.procesarLista(datos);
        
        assertEquals("Admins:  | Invitados: ", resultado);
    }
}
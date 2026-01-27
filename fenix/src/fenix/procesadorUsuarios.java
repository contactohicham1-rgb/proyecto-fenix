package fenix;

import java.util.List;

/**
 * Clase que se encarga de procesar listas de usuarios.
 */
public class procesadorUsuarios {

    /**
     * Constructor por defecto de la clase procesadorUsuarios.
     */
    public procesadorUsuarios() {
        // Constructor vacío
    }

    private static final int ROL_ADMIN = 1;
    private static final int ROL_INVITADO = 2;
    
    /**
     * Procesa una lista de cadenas con formato "nombre:rol" y devuelve 
     * un resumen agrupado.
     *
     * @param usuarios Lista de Strings que contienen los datos de usuario.
     * @return Una cadena formateada con los nombres de Admins e Invitados.
     */
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String usuario : usuarios) {
            String[] parts = usuario.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre = parts[0];
                int rol = Integer.parseInt(parts[1]);

                if (rol == ROL_ADMIN) {
                    admins += procesarAdmin(nombre);
                } else if (rol == ROL_INVITADO) {
                    invitados += procesarInvitado(nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }

    private String procesarAdmin(String nombre) {
        return nombre + ",";
    }

    private String procesarInvitado(String nombre) {
        return nombre + ",";
    }
}

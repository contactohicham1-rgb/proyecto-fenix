package fenix;

import java.util.List;
public class procesadorUsuarios {

    private static final int ROL_INVITADO = 2;
	private static final int ROL_ADMIN = 1;

	// Método con 'code smells': largo, números mágicos, malos nombres.
    public String procesarLista(List<String> usuarios) {
        String admins = "";
        String invitados = "";

        for (String usuario : usuarios) {
            String[] parts = usuario.split(":"); // Formato "nombre:rol"
            if (parts.length == 2) {
                String nombre= parts[0];
                int rol = Integer.parseInt(parts[1]);

                // Número Mágico: 1 es Admin
                if (rol == ROL_ADMIN) {
                    admins += procesarAdmin(nombre);
                }
                // Número Mágico: 2 es Invitado
                else if (rol == ROL_INVITADO) {
                    invitados += procesarInvitado(nombre);
                }
            }
        }
        return "Admins: " + admins + " | Invitados: " + invitados;
    }
    //prueba inicial

    private String procesarAdmin(String nombre) {
		return nombre + ",";
    }

    private String procesarInvitado(String nombre) {
		return nombre + ",";
	}
	}


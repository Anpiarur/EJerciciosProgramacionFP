package tareas.poo.tarea2asientos_aleatorios;

public class Comprobaciones {
  
    
    // Método para comprobar si se puede sentar un espectador en la sala
    public boolean sePuedeSentar(Espectador espectador, Sala sala) {
        // Verificar si el espectador tiene suficiente dinero
        if (espectador.getDineroDisponible() < sala.getPrecio()) {
            return false;
        }

        // Verificar si el espectador tiene la edad mínima para ver la película
        if (espectador.getEdad() < sala.getPelicula().getEdadMinima()) {
            return false;
        }

        // Verificar si hay asientos disponibles en la sala
        if (!sala.hayAsientosLibres()) {
            return false;
        }

        // Si el asiento aleatorio está ocupado, buscar uno libre
        while (true) {
            Asiento asientoAleatorio = sala.obtenerAsientoLibreAleatorio();
            if (asientoAleatorio != null) {
                return true;
            }
        }
    }
}
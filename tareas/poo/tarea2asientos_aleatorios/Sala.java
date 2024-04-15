package tareas.poo.tarea2asientos_aleatorios;

import java.util.Random;

public class Sala {

   
    // Constructor
    public Sala(double precio, Pelicula pelicula) {
        this.precio = precio;
        this.pelicula = pelicula;
        this.asientos = new Asiento[FILAS][COLUMNAS];
        rellenarAsientosAleatorios();
    }
    // Getter y Setter para precio y pelicula
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    // Método para rellenar la sala con asientos aleatorios
    private void rellenarAsientosAleatorios() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = new Asiento();
            }
        }
    }

    // Método para ocupar un asiento aleatorio con un espectador
    public void ocuparAsientoAleatorio(Espectador espectador) {
        Asiento asientoAleatorio = obtenerAsientoLibreAleatorio();
        if (asientoAleatorio != null) {
            asientoAleatorio.setEspectador(espectador);
        } else {
            System.out.println("Lo siento, no hay asientos disponibles.");
        }
    }

    // Método para obtener un asiento libre aleatorio
    public Asiento obtenerAsientoLibreAleatorio() {
        int intentos = FILAS * COLUMNAS;
        while (intentos > 0) {
            int filaAleatoria = random.nextInt(FILAS);
            int columnaAleatoria = random.nextInt(COLUMNAS);
            Asiento asiento = asientos[filaAleatoria][columnaAleatoria];
            if (!asiento.ocupado()) {
                return asiento;
            }
            intentos--;
        }
        return null; // Si no se encuentra ningún asiento libre
    }

    // Método para liberar un asiento ocupado por un espectador
    public void liberarAsiento(Espectador espectador) {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Asiento asiento = asientos[i][j];
                if (asiento.ocupado() && espectador.equals(asiento.getEspectador())) {
                    asiento.setEspectador(null);
                    return;
                }
            }
        }
    }

    // Método para verificar si hay algún asiento libre en la sala
    public boolean hayAsientosLibres() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                Asiento asiento = asientos[i][j];
                if (!asiento.ocupado()) {
                    return true;
                }
            }
        }
        return false;
    }

    // Método toString para representar la sala con la disposición de los asientos
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                sb.append(asientos[i][j]).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

     // Campos de clase
     private Asiento[][] asientos;
     private double precio;
     private Pelicula pelicula;
     private final int FILAS = 8;
     private final int COLUMNAS = 9;
     private final Random random = new Random();
 

    
}
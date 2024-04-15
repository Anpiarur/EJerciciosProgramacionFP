package tareas.poo.tarea2asientos_aleatorios;

import java.util.Random;

public class Asiento {
    // Constructor para crear un asiento aleatorio
    public Asiento() {
        this.fila = generarFilaAleatoria(1, 8);
        this.columna = generarColumnaAleatoria('A', 'I');
        this.espectador = null; // Asiento vacío por defecto
    }

    // Método para generar aleatoriamente una fila entre min y max
    private int generarFilaAleatoria(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }

    // Método para generar aleatoriamente una columna entre start y end
    private char generarColumnaAleatoria(char start, char end) {
        return (char) (random.nextInt(end - start + 1) + start);
    }

    // Getter y setter
    public int getFila() {
        return fila;
    }

    public char getColumna() {
        return columna;
    }

    public boolean ocupado() {
        return espectador != null;
    }

    // Método para asignar un espectador al asiento
    public void setEspectador(Espectador espectador) {
        this.espectador = espectador;
    }

    // Método para obtener el espectador asignado al asiento
    public Espectador getEspectador() {
        return espectador;
    }

   

    // Método toString para representar el estado del asiento
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (ocupado()) {
            sb.append("X"); // Asiento ocupado
        } else {
            sb.append(fila).append(columna); // Fila y columna del asiento
        }
        return sb.toString();
    }

    // Campos de clase
    private int fila;
    private char columna;
    private Espectador espectador;
    private static final Random random = new Random();

}

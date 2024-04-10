package tareas.poo.tarea1;

import java.util.Random;

public class Estudiante extends Persona {

    // Constructor
    public Estudiante(String nombre, int edad, Sexo sexo, int calificacion) {
        super(nombre, edad, sexo);
        this.calificacion = calificacion;
        generarAsistencia();
    }

    // Getter and setter
    public int getCalificacion() {
        return calificacion;
    }

    // vamos a acotar la calificación
    public void setCalificacion(int calificacion) {
        if (calificacion >= 0 && calificacion <= 10) {
            this.calificacion = calificacion;
        } else {
            System.out.println("La calificación debe estar entre 0 y 10, ambos inclusives");
        }

    }

    // Vamos a usar el polimorfismo para acotar la edad de un estudiante
    @Override
    public void setEdad(int edad) {
        if (edad >= 12 && edad <= 25) { // Estudiantes tienen entre 12 y 25 años
            super.setEdad(edad);
        } else {
            System.out.println("La edad del estudiante debe estar entre 12 y 25 años.");
        }
    }

    // Implementación del metodo generarAsistencia (polimorfismo)
    @Override
    protected void generarAsistencia() {
        Random rand = new Random();
        asistencia = rand.nextBoolean(); // Genera un booleano aleatorio (true o false) con 50% de probabilidad
    }

    // Campos de clase
    private int calificacion;

}

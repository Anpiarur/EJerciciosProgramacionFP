package tareas.poo.tarea1;

import java.util.Random;
import java.util.Scanner;

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

    

    //Implementación del metodo generarAsistencia (polimorfismo)
    @Override
    protected void generarAsistencia() {
        Random rand = new Random();
        asistencia = rand.nextBoolean(); // Genera un booleano aleatorio (true o false) con 50% de probabilidad
    }


    //Creación de metodo para crear estudiante por petición pantalla
    public static Estudiante crearEstudiante() {
        Scanner scanner = new Scanner(System.in);
        boolean correctoEdad = false;
        boolean correctoNota = false;
        System.out.println("Introduzca los datos del estudiante");
        while (!correctoEdad && !correctoNota) {

            System.out.println("Nombre del estudiante");
            String nombreEstudiante = scanner.nextLine();
            System.out.println("Edad del estudiante");
            int edadEstudiante = scanner.nextInt();
            if (edadEstudiante >= 12 && edadEstudiante <= 25) {
                correctoEdad = true;
            }
            scanner.nextLine();
            System.out.println("Introduzca el sexo del estudiante: 1-Hombre, 2-Mujer");
            Sexo sexoEstudiante;
            int sexo = scanner.nextInt();
            switch (sexo) {
                case 1:
                    sexoEstudiante = Sexo.HOMBRE;
                    break;
                case 2:
                    sexoEstudiante = Sexo.MUJER;
                    break;
                default:
                    System.out.println("Opción inválida. Se asignará HOMBRE por defecto.");
                    sexoEstudiante = Sexo.HOMBRE;
                    break;
            }
            System.out.println("Calificación del estudiante");
            int calificacionEstudiante = scanner.nextInt();
            if (calificacionEstudiante >= 0 && calificacionEstudiante >= 10) {
                correctoNota = true;
            }

            return new Estudiante(nombreEstudiante, edadEstudiante, sexoEstudiante, calificacionEstudiante);
        }
        return null; // Retornar null si ocurre un error
    }
    //Campos de clase
    private int calificacion;
    

}

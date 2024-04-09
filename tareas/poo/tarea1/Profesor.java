package tareas.poo.tarea1;
import java.util.Random;
import java.util.Scanner;
public class Profesor extends Persona {

    //Constructor
    public Profesor(String nombre, int edad, Sexo sexo, Materias materia){
        super(nombre, edad, sexo);
        this.materia=materia;
        generarAsistencia();
    }
    

//Getter and setter
public Materias getMateria() {
    return materia;
}

public void setMateria(Materias materia) {
    this.materia = materia;
}
//Polimorfismo de edad y asistencia
@Override
public void setEdad(int edad) {
    if (edad >= 25 && edad <= 65) { // Profesores tienen entre 25 y 65 años
        super.setEdad(edad);
    } else {
        System.out.println("La edad del profesor debe estar entre 25 y 65 años.");
    }
}

@Override
protected void generarAsistencia() {
    Random rand = new Random();
    int probabilidad = rand.nextInt(100); // Genera un número aleatorio entre 0 y 99

    // La asistencia será true si el número generado está en el rango de 21 a 100 (80%)
    asistencia = probabilidad > 20;
}

//Metodo para crear profesor por peticion pantalla
public static Profesor crearProfesor() {
    Scanner scanner = new Scanner(System.in);
    boolean correcto = false;
    System.out.println("Introduzca los datos del profesor");
    while (!correcto) {
        System.out.println("Nombre del profesor: ");
        String nombreProfesor = scanner.nextLine();
        System.out.println("Edad del profesor: ");
        int edadProfesor = scanner.nextInt();
        if (edadProfesor >= 25 && edadProfesor <= 65) {
            correcto = true;
        } else {
            System.out.println("La edad del profesor debe estar entre 25 y 65 años.");
        }
        scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt()
        System.out.println("Sexo del profesor: 1-HOMBRE, 2-MUJER");
        Sexo sexoProfesor;
        int sexo = scanner.nextInt();
        switch (sexo) {
            case 1:
                sexoProfesor = Sexo.HOMBRE;
                break;
            case 2:
                sexoProfesor = Sexo.MUJER;
                break;
            default:
                System.out.println("Opción inválida. Se asignará HOMBRE por defecto.");
                sexoProfesor = Sexo.HOMBRE;
                break;
        }
        scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt()
        System.out.println("Materia a impartir: ");
        System.out.println("1. MATEMATICAS");
        System.out.println("2. FILOSOFÍA");
        System.out.println("3. FÍSICA");
        System.out.print("Seleccione una opción: ");
        Materias materiaProfesor;
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea pendiente después de nextInt()
        switch (opcion) {
            case 1:
                materiaProfesor = Materias.MATEMATICAS;
                break;
            case 2:
                materiaProfesor = Materias.FILOSOFIA;
                break;
            case 3:
                materiaProfesor = Materias.FISICA;
                break;
            default:
                System.out.println("Opción inválida. Se asignará MATEMATICAS por defecto.");
                materiaProfesor = Materias.MATEMATICAS;
                break;
        }
        return new Profesor(nombreProfesor, edadProfesor, sexoProfesor, materiaProfesor);
    }
    return null; // Retornar null si ocurre un error
}


//Campos de clase
private Materias materia;
}

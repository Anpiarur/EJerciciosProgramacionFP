package tareas.poo.tarea2asientos_aleatorios;

import java.util.Scanner;

public class UsoSalaCine {
    

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            // Solicitar datos de la sala de cine y la película
            Sala salaCine = InputManager.crearSala();
            
    
            // Solicitar el número de espectadores
            int numEspectadores = InputManager.solicitarEntero("Número de espectadores:", 1, 100);
            Espectador[] espectadores = new Espectador[numEspectadores];
    
            // Crear cada espectador y asignarle un asiento aleatorio
            for (int i = 0; i < numEspectadores; i++) {
                System.out.println("Datos del espectador " + (i + 1) + ":");
                espectadores[i] = InputManager.crearEspectador();
                salaCine.ocuparAsientoAleatorio(espectadores[i]);
                System.out.println(); // Salto de línea para separar los datos de los espectadores
            }
    
            // Comprobar si cada espectador puede sentarse en la sala
            Comprobaciones comprobaciones = new Comprobaciones();
            for (Espectador espectador : espectadores) {
                boolean sePuedeSentar = comprobaciones.sePuedeSentar(espectador, salaCine);
                System.out.println(espectador.getNombre() + (sePuedeSentar ? " puede" : " no puede") + " sentarse en la sala.");
            }
    
            // Mostrar la etiqueta de los asientos de la sala
            System.out.println("Etiqueta de los asientos:");
            System.out.println(salaCine);
        }
    }
    

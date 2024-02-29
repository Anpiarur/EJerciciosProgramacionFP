package tareas.array4;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matrices3
 * Diseña un programa en Java que pide por pantalla una palabra de x caracteres.
 * Se
 * debe crear una matriz con el mismo número de celdas que letras tiene la
 * palabra.
 * Consideraciones:
 * Cada letra se debe almacenar en una celda.
 * Se debe comprobar si hay algún valor repetido en alguna celda.
 */
public class matrices3 {
    public static void main(String[] args) {

        // Objeto scanner para peticion de palabra
        Scanner sc = new Scanner(System.in);

        // Declaración de variables e inicialización
        String palabra = " ";
        char silaba = ' ';
        char silabaRepetida = ' ';

        // Boolean de comprobacion
        boolean correcto;
        boolean repetido;
        /*
         * Bloque de codigo para controlar excepciones.
         * En este caso quiero que se ingrese una palabra
         * que solo contengan letras entre A-Z.
         */

        do {
            try {
                // Petición de palabra
                System.out.println("Por favor, ingrese una palabra.");
                palabra = sc.nextLine();

                // Patrón regex para comprobar que solo tiene letras
                Pattern patron = Pattern.compile("^[a-zA-Z]+$");
                Matcher matcher = patron.matcher(palabra);

                // Inicialización del booleano
                correcto = matcher.matches();

                if (!correcto) {
                    System.out.println("Vuelva a ingresar una palabra. Solo se admiten letras (A-Z)");
                }

            } catch (InputMismatchException e) {
                System.out.println("Ocurrió un error de tipo: " + e.getMessage());
                sc.nextLine(); // Limpiar el búfer del escáner
                correcto = false; // Reinicializar para permitir al usuario ingresar una nueva palabra
            }
        } while (!correcto);

        // Array char con los caráctares de la palabra ingresada
        char letras[] = new char[palabra.length()];

        // Recorrido para rellenar el array
        // Inicializo repetido
        repetido = false;
        for (int i = 0; i < letras.length; i++) {
            repetido = false;// Reinicializo la bariable para cada recorrido
            silaba = palabra.charAt(i);
            for (int j = 0; j < letras.length; j++) {
                letras[j] = palabra.charAt(j);
                repetido = silaba == letras[j];
                if (repetido) {
                    silabaRepetida = silaba;
                }
            }
        }
        if (repetido) {
            System.out.printf("Se repiten la letra %s en la palabra ingresada", silabaRepetida);
        }else{
            System.out.println("No se repiten letras");
        }

        sc.close();
    }

}

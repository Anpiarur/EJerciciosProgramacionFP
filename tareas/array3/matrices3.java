package tareas.array3;
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
    
    

    //Objeto scanner  para peticion de palabra
    Scanner sc= new Scanner (System.in);

    //Petición de palabra
    System.out.println("Por favor, ingrese una palabra.");

    //booleano de comproboción 
    boolean correcto=false;
    
    while (!correcto) {
        
    
    try {
    String palabra=sc.nextLine();
    Pattern patron = Pattern.compile("^[a-zA-Z]+$");
    Matcher matcher= patron.matcher(palabra);
    if (matcher.matches()) {
        correcto=true;
    }else{
        System.out.println("Vuelva a ingresar una palabra. Solo se admiten letras (A-Z)");
    }
        
        
    } catch (InputMismatchException e) {
        sc.nextLine();
    }
}
}
}
package Tareas.Matrices;

/*
 * 4. Generar una matriz de 3×3 con números aleatorios sin repetirse.
 */
public class Ejercicio4 {
    public static void main(String[] args) {
        // Declaracion de array
        int numero[][] = new int[3][3];
        int aleatorio[][] = new int[3][3];

        // Variable booleana de control
        boolean correcto = false;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                numero[i][j] = (int) (Math.random() * 101);

            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    aleatorio[i][j] = (int) (Math.random() * 101);
                    if (aleatorio[i][j] != numero[i][j]) {
                        correcto = true;
                    }

                } while (!correcto);

            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(aleatorio[i][j] + " ");
            }
            System.out.println();
        }

    }

}

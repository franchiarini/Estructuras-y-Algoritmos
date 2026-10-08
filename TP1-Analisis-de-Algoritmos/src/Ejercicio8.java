public class Ejercicio8 {

    public static long sumarElementos(int[][] matriz) {
        long suma = 0;
        long operaciones = 0;

        // Una matriz nula se considera sin elementos para esta suma.
        if (matriz != null) {
            for (int fila = 0; fila < matriz.length; fila++) {
                // Las filas nulas se consideran sin elementos, igual que las vacias.
                if (matriz[fila] == null) {
                    continue;
                }
                for (int columna = 0; columna < matriz[fila].length; columna++) {
                    suma += matriz[fila][columna];
                    // Contamos solo una acumulacion por elemento sumado,
                    // no las comparaciones, los incrementos ni otros pasos.
                    operaciones++;
                }
            }
        }

        System.out.println("Operaciones de acumulacion: " + operaciones);
        return suma;
    }

    // Para matrices rectangulares con columnas: tiempo Theta(f * c),
    // espacio auxiliar O(1) y f * c operaciones de acumulacion.
    // Con filas vacias se revisan las filas, pero no se realizan acumulaciones.
    public static void main(String[] args) {
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}};
        System.out.println("Matriz:");
        for (int fila = 0; fila < matriz.length; fila++) {
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (columna > 0) {
                    System.out.print(" ");
                }
                System.out.print(matriz[fila][columna]);
            }
            System.out.println();
        }
        long suma = sumarElementos(matriz);
        System.out.println("Suma total: " + suma);
    }
}

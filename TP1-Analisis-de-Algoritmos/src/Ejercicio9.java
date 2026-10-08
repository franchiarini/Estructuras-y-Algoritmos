public class Ejercicio9 {

    public static int encontrarMaximo(int[][] matriz) {
        if (matriz == null) {
            throw new IllegalArgumentException("La matriz no puede ser nula.");
        }

        // Buscamos la primera fila con elementos para inicializar con un valor real.
        int primeraFila = 0;
        while (primeraFila < matriz.length
                && (matriz[primeraFila] == null || matriz[primeraFila].length == 0)) {
            primeraFila++;
        }
        if (primeraFila == matriz.length) {
            throw new IllegalArgumentException("La matriz debe contener al menos un elemento.");
        }

        int maximo = matriz[primeraFila][0];
        for (int fila = primeraFila; fila < matriz.length; fila++) {
            // Las filas nulas o vacias no contienen elementos para comparar.
            if (matriz[fila] == null) {
                continue;
            }
            for (int columna = 0; columna < matriz[fila].length; columna++) {
                if (matriz[fila][columna] > maximo) {
                    maximo = matriz[fila][columna];
                }
            }
        }

        // Se examinan todos los valores sin modificar la matriz.
        // Para matrices rectangulares con columnas: mejor, peor y promedio
        // Theta(f * c), con espacio auxiliar O(1).
        return maximo;
    }

    public static void main(String[] args) {
        int[][] matriz = {{8, 3, 12}, {1, 6, 4}};
        int[][] negativos = {{-8, -3}, {-12, -1}};
        System.out.println("Maximo de {{8, 3, 12}, {1, 6, 4}}: " + encontrarMaximo(matriz));
        System.out.println("Maximo de {{-8, -3}, {-12, -1}}: " + encontrarMaximo(negativos));
    }
}

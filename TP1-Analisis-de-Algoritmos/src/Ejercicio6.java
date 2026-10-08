public class Ejercicio6 {

    public static boolean sonIguales(int[] vector1, int[] vector2) {
        // Validamos los nulos antes de acceder a las longitudes.
        // Dos referencias nulas son iguales; solo una nula implica diferencia.
        if (vector1 == null || vector2 == null) {
            return vector1 == null && vector2 == null;
        }

        // Longitudes diferentes bastan para determinar que no son iguales.
        if (vector1.length != vector2.length) {
            return false;
        }

        // Comparamos elementos en la misma posicion, sin modificar los vectores.
        for (int i = 0; i < vector1.length; i++) {
            if (vector1[i] != vector2[i]) {
                // Una sola diferencia permite finalizar inmediatamente.
                return false;
            }
        }

        // No hubo diferencias. Esto incluye dos vectores vacios.
        return true;
    }

    // Mejor caso: Theta(1). Peor caso: Theta(n). Espacio auxiliar: O(1).
    // Promedio: Theta(n) si la primera diferencia se distribuye uniformemente
    // entre las n posiciones; depende de la distribucion de los datos.
    public static void main(String[] args) {
        int[][] primeros = {
            {1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3}, {1, 2, 3},
            {}, null, null, {}, {7}, {7}
        };
        int[][] segundos = {
            {1, 2, 3}, {1, 2}, {9, 2, 3}, {1, 9, 3}, {1, 2, 9},
            {}, null, {}, null, {7}, {8}
        };
        String[] casos = {
            "Vectores identicos", "Longitudes diferentes", "Diferencia al inicio",
            "Diferencia en el medio", "Diferencia al final", "Dos vectores vacios",
            "Dos referencias nulas", "Primero nulo", "Segundo nulo",
            "Un elemento igual", "Un elemento diferente"
        };

        for (int i = 0; i < primeros.length; i++) {
            System.out.println(casos[i] + ": " + sonIguales(primeros[i], segundos[i]));
        }
    }
}

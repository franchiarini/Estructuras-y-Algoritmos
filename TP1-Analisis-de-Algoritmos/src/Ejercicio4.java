import java.util.HashSet;

public class Ejercicio4 {

    public static boolean tieneDuplicadosAnidados(int[] vector) {
        // Se considera que un vector nulo, vacio o unitario no tiene duplicados.
        if (vector == null || vector.length < 2) {
            return false;
        }

        // Comparamos cada elemento solo con los posteriores, sin memoria auxiliar.
        for (int i = 0; i < vector.length - 1; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] == vector[j]) {
                    return true; // La primera coincidencia termina la busqueda.
                }
            }
        }
        return false;
    }

    public static boolean tieneDuplicadosHashSet(int[] vector) {
        if (vector == null || vector.length < 2) {
            return false;
        }

        HashSet<Integer> elementosVistos = new HashSet<>();
        for (int i = 0; i < vector.length; i++) {
            // add devuelve false si el valor ya existe en el conjunto.
            if (!elementosVistos.add(vector[i])) {
                return true;
            }
        }
        return false;
    }

    // Ninguna estrategia ordena ni modifica el vector original.
    // Anidados: mejor Theta(1), peor Theta(n^2), espacio O(1).
    // HashSet: mejor Theta(1), tiempo esperado Theta(n) al recorrer todo,
    // espacio O(n). El costo esperado depende de las operaciones del conjunto;
    // su peor caso teorico puede superar el tiempo lineal.
    public static void main(String[] args) {
        int[][] vectores = {
            {8, 3, 12, 1, 6},
            {8, 8, 3, 12},
            {8, 3, 3, 12},
            {8, 3, 12, 12},
            {8, 3, 12, 8},
            {-5, -2, -5, 0},
            {-5, -2, -1, 0},
            {},
            null,
            {7}
        };
        String[] casos = {
            "Sin duplicados", "Duplicados al inicio", "Duplicados en el medio",
            "Duplicados al final", "Duplicados separados",
            "Negativos con duplicados", "Negativos sin duplicados",
            "Vector vacio", "Vector nulo", "Un solo elemento"
        };

        for (int i = 0; i < vectores.length; i++) {
            System.out.println(casos[i] + ": anidados="
                    + tieneDuplicadosAnidados(vectores[i]) + ", HashSet="
                    + tieneDuplicadosHashSet(vectores[i]));
        }
    }
}

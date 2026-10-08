public class Ejercicio10 {

    public static void ordenarBurbuja(int[] vector) {
        long comparaciones = 0;
        long intercambios = 0;

        // Un vector nulo no se ordena; los vacios y unitarios no requieren pasos.
        if (vector != null) {
            for (int pasada = 0; pasada < vector.length - 1; pasada++) {
                boolean huboIntercambios = false;
                // Cada pasada deja el mayor elemento restante al final.
                for (int i = 0; i < vector.length - 1 - pasada; i++) {
                    // Contamos solo comparaciones entre elementos consecutivos,
                    // no las condiciones de los ciclos ni sus incrementos.
                    comparaciones++;
                    if (vector[i] > vector[i + 1]) {
                        int temporal = vector[i];
                        vector[i] = vector[i + 1];
                        vector[i + 1] = temporal;
                        // Un intercambio cuenta una vez, no por cada asignacion.
                        intercambios++;
                        huboIntercambios = true;
                    }
                }
                if (!huboIntercambios) {
                    break; // Sin intercambios, el vector ya esta ordenado.
                }
            }
        }

        System.out.println("Comparaciones entre elementos: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);
    }

    // Mejor Theta(n), peor y promedio Theta(n^2), espacio auxiliar O(1).
    // Es sencillo para aprender, pero resulta costoso para conjuntos grandes.
    public static void main(String[] args) {
        int[][] vectores = {
            {1, 2, 3, 4}, {4, 3, 2, 1}, {3, 1, 3, 1},
            {-1, -5, 0, -3}, {7}, {}, null
        };
        String[] casos = {
            "Ya ordenado", "Orden inverso", "Repetidos", "Negativos",
            "Un elemento", "Vacio", "Nulo"
        };
        for (int i = 0; i < vectores.length; i++) {
            System.out.println("Caso: " + casos[i]);
            System.out.print("Vector original: ");
            mostrarVector(vectores[i]);
            ordenarBurbuja(vectores[i]);
            System.out.print("Vector ordenado: ");
            mostrarVector(vectores[i]);
        }
    }

    private static void mostrarVector(int[] vector) {
        if (vector == null) {
            System.out.println("null");
            return;
        }
        System.out.print("{");
        for (int i = 0; i < vector.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(vector[i]);
        }
        System.out.println("}");
    }
}

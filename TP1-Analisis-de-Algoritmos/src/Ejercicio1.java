public class Ejercicio1 {

    public static int encontrarMinimo(int[] vector) {
        // Un vector nulo o vacio no tiene un valor minimo.
        if (vector == null || vector.length == 0) {
            throw new IllegalArgumentException("El vector no puede ser nulo ni estar vacio.");
        }

        // El primer elemento es el minimo inicial.
        int minimo = vector[0];

        // No es necesario ordenar: basta comparar cada elemento una sola vez.
        // Se comienza en la segunda posicion porque la primera ya fue considerada.
        for (int i = 1; i < vector.length; i++) {
            if (vector[i] < minimo) {
                minimo = vector[i];
            }
        }

        // Tiempo: Theta(n) en mejor y peor caso. Espacio auxiliar: O(1).
        return minimo;
    }

    public static void main(String[] args) {
        int[] vector = {8, 3, 12, 1, 6};

        System.out.print("Vector original: {");
        for (int i = 0; i < vector.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(vector[i]);
        }
        System.out.println("}");
        System.out.println("Minimo encontrado: " + encontrarMinimo(vector));
    }
}

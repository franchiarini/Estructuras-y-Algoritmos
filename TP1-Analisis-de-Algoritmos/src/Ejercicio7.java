public class Ejercicio7 {

    public static int[] invertirConAuxiliar(int[] vector) {
        // No hay un vector para invertir cuando la referencia es nula.
        if (vector == null) {
            return null;
        }

        int[] invertido = new int[vector.length];
        // Copiamos en orden inverso sin modificar el vector original.
        // Para un vector vacio, se devuelve un nuevo vector vacio.
        for (int i = 0; i < vector.length; i++) {
            invertido[i] = vector[vector.length - 1 - i];
        }
        return invertido;
    }

    public static void invertirInPlace(int[] vector) {
        // Los vectores nulos, vacios y unitarios no requieren intercambios.
        if (vector == null || vector.length < 2) {
            return;
        }

        int inicio = 0;
        int fin = vector.length - 1;
        while (inicio < fin) {
            // Intercambiamos los extremos con una sola variable temporal.
            int temporal = vector[inicio];
            vector[inicio] = vector[fin];
            vector[fin] = temporal;
            inicio++;
            fin--;
        }
    }

    // Ambas estrategias tardan Theta(n).
    // Auxiliar: O(n) de espacio, conserva el original, pero crea otro vector.
    // In-place: O(1) de espacio, evita otro vector, pero modifica el original.
    public static void main(String[] args) {
        int[] vector = {8, 3, 12, 1, 6};
        System.out.print("Vector original: ");
        mostrarVector(vector);

        int[] invertido = invertirConAuxiliar(vector);
        System.out.print("Invertido con auxiliar: ");
        mostrarVector(invertido);
        System.out.print("Original despues de usar auxiliar: ");
        mostrarVector(vector);

        invertirInPlace(vector);
        System.out.print("Invertido in-place: ");
        mostrarVector(vector);
    }

    private static void mostrarVector(int[] vector) {
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

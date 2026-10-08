public class Ejercicio5 {

    public static int contarOcurrencias(int[] vector, int valor) {
        // Un vector nulo no contiene apariciones del valor buscado.
        if (vector == null) {
            return 0;
        }

        int contador = 0;
        // Se recorre todo el vector: puede haber coincidencias hasta el final.
        // No se ordena ni se modifica el contenido del vector.
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] == valor) {
                contador++;
            }
        }

        // Si el vector esta vacio, el ciclo no se ejecuta y se devuelve cero.
        // Mejor, peor y promedio: Theta(n). Espacio auxiliar: O(1).
        return contador;
    }

    public static void main(String[] args) {
        int[] vector = {8, 3, 12, 3, 6, 3};
        int valor = 3;

        System.out.print("Vector: {");
        for (int i = 0; i < vector.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(vector[i]);
        }
        System.out.println("}");
        System.out.println("Valor buscado: " + valor);
        System.out.println("Cantidad de apariciones: " + contarOcurrencias(vector, valor));
    }
}

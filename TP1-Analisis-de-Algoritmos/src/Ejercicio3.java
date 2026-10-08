public class Ejercicio3 {

    // Se supone que el vector ya esta ordenado de menor a mayor.
    // Devuelve el indice encontrado o -1 si el elemento no existe.
    public static int buscarElemento(int[] vector, int valorBuscado) {
        if (vector == null) {
            System.out.println("El vector es nulo. No se puede realizar la busqueda.");
            return -1;
        }

        int inicio = 0;
        int fin = vector.length - 1;

        // El intervalo incluye ambos extremos. Si esta vacio, no se ingresa.
        while (inicio <= fin) {
            // Esta formula evita sumar directamente los dos extremos.
            int medio = inicio + (fin - inicio) / 2;
            System.out.println("inicio=" + inicio + ", fin=" + fin
                    + ", medio=" + medio + ", elemento=" + vector[medio]);

            if (vector[medio] == valorBuscado) {
                System.out.println("Elemento " + valorBuscado
                        + " encontrado en el indice " + medio + ".");
                return medio;
            }

            // El orden permite descartar la mitad que no contiene el valor.
            // No es necesario ordenar ni modificar el vector.
            if (vector[medio] < valorBuscado) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        // Tambien contempla el vector vacio y los valores ausentes.
        System.out.println("El elemento " + valorBuscado + " no existe en el vector.");
        return -1;
    }

    // Mejor caso: Theta(1). Peor y promedio: Theta(log n).
    // Espacio auxiliar: O(1).
    public static void main(String[] args) {
        int[] vector = {1, 3, 5, 7, 9, 11, 13};
        System.out.println("Vector ordenado: {1, 3, 5, 7, 9, 11, 13}");

        System.out.println("Caso: elemento al inicio");
        buscarElemento(vector, 1);

        System.out.println("Caso: elemento en el medio");
        buscarElemento(vector, 7);

        System.out.println("Caso: elemento al final");
        buscarElemento(vector, 13);

        System.out.println("Caso: elemento inexistente");
        buscarElemento(vector, 8);

        System.out.println("Caso: vector vacio");
        buscarElemento(new int[0], 7);

        System.out.println("Caso: vector nulo");
        buscarElemento(null, 7);
    }
}

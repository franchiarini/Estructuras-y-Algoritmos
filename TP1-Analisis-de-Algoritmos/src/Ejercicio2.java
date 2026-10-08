public class Ejercicio2 {

    // Devuelve el indice de la primera coincidencia o -1 si no se encuentra.
    public static int buscarElemento(int[] vector, int valorBuscado) {
        // Validamos antes de acceder al vector para evitar errores inesperados.
        if (vector == null) {
            System.out.println("El vector es nulo. Posiciones revisadas: 0.");
            return -1;
        }

        int posicionesRevisadas = 0;

        // Como el vector esta desordenado, no podemos usar busqueda binaria.
        // La busqueda lineal no necesita ordenar ni modificar el vector.
        for (int i = 0; i < vector.length; i++) {
            posicionesRevisadas++;
            if (vector[i] == valorBuscado) {
                System.out.println("Elemento " + valorBuscado + " encontrado en el indice "
                        + i + ". Posiciones revisadas: " + posicionesRevisadas + ".");
                // El retorno detiene el recorrido en la primera coincidencia.
                return i;
            }
        }

        // Tambien contempla el vector vacio: se revisan cero posiciones.
        System.out.println("El elemento " + valorBuscado + " no existe en el vector. "
                + "Posiciones revisadas: " + posicionesRevisadas + ".");
        return -1;
    }

    // Mejor caso: Theta(1). Peor caso: Theta(n).
    // Promedio: Theta(n), suponiendo posiciones equiprobables. Espacio: O(1).
    public static void main(String[] args) {
        int[] vector = {8, 3, 12, 1, 3, 6};
        System.out.println("Vector original: {8, 3, 12, 1, 3, 6}");

        System.out.println("Caso: elemento al inicio");
        buscarElemento(vector, 8);

        System.out.println("Caso: elemento al final");
        buscarElemento(vector, 6);

        System.out.println("Caso: elemento inexistente");
        buscarElemento(vector, 10);

        System.out.println("Caso: elemento repetido (primera coincidencia)");
        buscarElemento(vector, 3);

        System.out.println("Caso: vector vacio");
        buscarElemento(new int[0], 8);

        System.out.println("Caso: vector nulo");
        buscarElemento(null, 8);
    }
}

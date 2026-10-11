/*
Implementá en Java un sistema de ranking de jugadores que permita ordenar una colección de jugadores de mayor a menor puntaje utilizando MergeSort.

**Algoritmo elegido: MergeSort.**

**Estrategia:** representar cada jugador mediante un objeto que contenga su nombre y puntaje. Utilizar MergeSort para dividir recursivamente el arreglo de jugadores en dos mitades hasta llegar a segmentos individuales. Luego fusionar las mitades comparando los puntajes, colocando primero al jugador con mayor puntuación.

**Justificación:** MergeSort es una elección conveniente porque garantiza una complejidad temporal Θ(n log n), incluso en el peor caso. Además, permite mantener el orden original de los jugadores que tienen el mismo puntaje mediante una fusión estable. Esto resulta útil para construir un ranking predecible.

**Caso base:** cuando un segmento contiene cero o un jugador, ya se encuentra ordenado.

**Caso recursivo:** dividir el segmento en dos mitades, ordenar recursivamente cada una y fusionarlas según el puntaje descendente.

**Reducción del problema:** cada llamada recursiva procesa aproximadamente la mitad de los jugadores del segmento original.

**Complejidad:**
- Mejor caso: Θ(n log n).
- Caso promedio: Θ(n log n).
- Peor caso: Θ(n log n).
- Espacio auxiliar: O(n), debido al arreglo utilizado para fusionar los segmentos, además de la pila recursiva O(log n).

**Requisitos:**
- Crear `Ejercicio10.java` dentro de `TP3-Ordenamiento/src`, respetando la estructura existente.
- Definir una clase `Jugador` con los atributos `nombre` y `puntaje`, incluyendo un constructor y los métodos necesarios para consultar sus valores.
- Implementar un método `mergeSort(Jugador[] jugadores)` que ordene el arreglo de mayor a menor puntaje.
- Implementar manualmente MergeSort mediante métodos auxiliares recursivos y de fusión.
- Utilizar un único arreglo auxiliar reutilizable durante las fusiones, evitando crear arreglos auxiliares nuevos en cada llamada recursiva.
- Realizar las comparaciones utilizando el puntaje de cada jugador.
- Mantener juntos el nombre y el puntaje de cada jugador durante todo el proceso de ordenamiento.
- En caso de empate, conservar el orden original de aparición. Para garantizar la estabilidad, durante la fusión debe elegirse primero el jugador de la mitad izquierda cuando ambos puntajes sean iguales.
- No utilizar `Arrays.sort()`, `Collections.sort()`, `Comparator.sort()` ni otros métodos predefinidos de ordenamiento.
- Mostrar la lista original de jugadores.
- Mostrar el ranking final con número de posición, nombre y puntaje.
- Incorporar comentarios que expliquen el algoritmo elegido, el criterio descendente, la recursividad y el tratamiento de empates.
- Incluir un método `main` con ejemplos de funcionamiento.
- Utilizar como ejemplo principal estos jugadores:
  - `Jugador("Ana", 1200)`
  - `Jugador("Pedro", 900)`
  - `Jugador("Lucia", 1500)`
- Verificar que el ranking resultante sea:
  1. Lucia — 1500
  2. Ana — 1200
  3. Pedro — 900
- Realizar una prueba adicional agregando `Jugador("Martin", 1200)` después de los tres jugadores originales y verificar que Ana permanezca delante de Martin al tener ambos 1200 puntos.
- Probar jugadores ya ordenados, ordenados en sentido inverso, con puntajes repetidos, con puntajes negativos y con valores extremos de `int`.
- Probar arreglos vacíos y de un solo jugador.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Validar que los elementos Jugador no sean nulos y que los nombres no sean nulos ni vacíos, antes de comenzar a ordenar, evitando modificaciones parciales.
- Permitir puntajes enteros negativos, porque pueden representar penalizaciones.
- Verificar que se conserven todos los jugadores y sus respectivos puntajes.
- Verificar expresamente que los empates mantengan el orden original.
- Compilar y ejecutar con Java 21, documentando los resultados reales de las pruebas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio10 {
    public static class Jugador {
        private final String nombre;
        private final int puntaje;

        public Jugador(String nombre, int puntaje) {
            this.nombre = nombre;
            this.puntaje = puntaje;
        }

        public String getNombre() { return nombre; }
        public int getPuntaje() { return puntaje; }
    }

    public static void mergeSort(Jugador[] jugadores) {
        if (jugadores == null) {
            throw new IllegalArgumentException("El arreglo no puede ser nulo.");
        }
        // Validar todo antes de mover referencias: una entrada invalida no altera el arreglo.
        for (Jugador jugador : jugadores) {
            if (jugador == null || jugador.getNombre() == null || jugador.getNombre().isEmpty()) {
                throw new IllegalArgumentException("Cada jugador debe tener un nombre no nulo ni vacio.");
            }
        }
        Jugador[] auxiliar = new Jugador[jugadores.length];
        ordenar(jugadores, auxiliar, 0, jugadores.length - 1);
    }

    private static void ordenar(Jugador[] jugadores, Jugador[] auxiliar, int inicio, int fin) {
        // Caso base: cero o un jugador. Cada division reduce el segmento a la mitad.
        if (inicio >= fin) return;
        int medio = inicio + (fin - inicio) / 2;
        // La pila conserva el segmento pendiente hasta que ambas mitades esten ordenadas.
        ordenar(jugadores, auxiliar, inicio, medio);
        ordenar(jugadores, auxiliar, medio + 1, fin);
        fusionar(jugadores, auxiliar, inicio, medio, fin);
    }

    private static void fusionar(Jugador[] jugadores, Jugador[] auxiliar,
                                 int inicio, int medio, int fin) {
        for (int i = inicio; i <= fin; i++) auxiliar[i] = jugadores[i];
        int izquierda = inicio;
        int derecha = medio + 1;
        for (int destino = inicio; destino <= fin; destino++) {
            if (izquierda > medio) {
                jugadores[destino] = auxiliar[derecha++];
            } else if (derecha > fin) {
                jugadores[destino] = auxiliar[izquierda++];
            } else if (auxiliar[izquierda].getPuntaje() >= auxiliar[derecha].getPuntaje()) {
                // Descendente; en empates elegir la izquierda garantiza estabilidad.
                // Movemos el objeto completo, conservando juntos nombre y puntaje.
                jugadores[destino] = auxiliar[izquierda++];
            } else {
                jugadores[destino] = auxiliar[derecha++];
            }
        }
    }

    private static void mostrar(Jugador[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            System.out.println((i + 1) + ". " + jugadores[i].getNombre()
                    + " — " + jugadores[i].getPuntaje());
        }
    }

    public static void main(String[] args) {
        Jugador[][] ejemplos = {
            {new Jugador("Ana", 1200), new Jugador("Pedro", 900), new Jugador("Lucia", 1500)},
            {new Jugador("Ana", 1200), new Jugador("Pedro", 900), new Jugador("Lucia", 1500),
                    new Jugador("Martin", 1200)}
        };
        for (Jugador[] jugadores : ejemplos) {
            System.out.println("Lista original:");
            mostrar(jugadores);
            mergeSort(jugadores);
            System.out.println("Ranking final:");
            mostrar(jugadores);
        }
    }
}

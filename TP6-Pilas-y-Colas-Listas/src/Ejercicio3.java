/*
Implementar una pila enlazada genérica en Java mediante `Nodo<T>` y `Pila<T>`, siguiendo el principio LIFO, para almacenar `Integer`, `String` y objetos propios.

**Estructura y justificación:** utilizar nodos con un dato de tipo `T` y una referencia `Nodo<T> siguiente`. La pila mantiene `head` como tope, ya que insertar y retirar desde el inicio permite ejecutar `push` y `pop` en O(1). Los genéricos permiten reutilizar la misma estructura con distintos tipos sin modificar los algoritmos ni utilizar conversiones inseguras.

**Clases:**
- `Ejercicio3`: clase pública con `main`.
- `Nodo<T>`: atributos privados `T dato` y `Nodo<T> siguiente`.
- `Pila<T>`: referencia privada `Nodo<T> head`.
- `Alumno`: clase sencilla con identificador y nombre para probar objetos propios.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio3`, evitando conflictos con los otros ejercicios.

**Operaciones de `Pila<T>`:**
- `void push(T dato)`: crear un nodo, enlazarlo al antiguo `head` y actualizar `head`.
- `T pop()`: retirar y devolver el dato del tope, actualizando `head`.
- `T peek()`: consultar el dato del tope sin retirarlo.
- `boolean isEmpty()`: verificar `head == null`.
- `boolean contains(T dato)`: recorrer los nodos buscando una coincidencia mediante `Objects.equals()`.
- `void print()`: mostrar los elementos desde el tope hasta `null`.

**Casos especiales:** admitir elementos `null` de forma coherente. Si `pop()` o `peek()` se ejecutan sobre una pila vacía, lanzar `IllegalStateException`. Conservar el estado ante operaciones inválidas. Verificar que los nodos permanezcan correctamente enlazados, sin ciclos ni pérdidas.

**Comparación de objetos:** utilizar `Objects.equals()` para comparar valores, evitando `==`. Para `Alumno`, implementar `equals()` y `hashCode()` coherentemente según su identificador, permitiendo encontrar un alumno mediante un objeto diferente con el mismo identificador.

**Complejidad:** `push`, `pop`, `peek` e `isEmpty`: O(1). `contains` y `print`: O(n), suponiendo comparaciones y representaciones de costo constante. Espacio auxiliar por operación: O(1). Almacenamiento total: O(n).

**Ejemplos y pruebas:**
1. `Pila<Integer>`: apilar 10, 20 y 30; verificar que `pop()` devuelve 30, 20 y 10.
2. `Pila<String>`: apilar "Ana", "Luis" y "Marta"; verificar que el primer retiro devuelve "Marta".
3. `Pila<Alumno>`: apilar tres alumnos, consultar el tope y buscar uno mediante otro objeto con igual identificador.
4. Probar pila vacía, nodo único, duplicados, elementos `null`, búsquedas exitosas y fallidas.
5. Verificar que `peek`, `contains` y `print` no modifican la pila.
6. Comprobar orden LIFO, identidad de nodos y enlaces correctos después de las operaciones.

**Restricciones:** implementar la pila desde cero, sin arreglos ni colecciones predefinidas (`Stack`, `LinkedList`, `ArrayList`, `Deque`, etc.). No utilizar clases de otros ejercicios ni modificar archivos anteriores. No realizar commits ni push.

Compilar individualmente y conjuntamente con los ejercicios 1 y 2 usando Java 21, `--release 21` y `-Xlint:all`. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas.
*/
import java.util.Objects;

public class Ejercicio3 {
    public static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;
        public Nodo(T dato) { this.dato = dato; siguiente = null; }
        public T getDato() { return dato; }
        public Nodo<T> getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo<T> siguiente) { this.siguiente = siguiente; }
    }
    public static class Pila<T> {
        private Nodo<T> head = null;
        public void push(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setSiguiente(head); // Conservar el tope anterior antes de reemplazarlo.
            head = nuevo; // LIFO: el ultimo agregado es el primero en retirarse.
        }
        public T pop() {
            if (isEmpty()) throw new IllegalStateException("No se puede retirar de una pila vacia.");
            T dato = head.getDato();
            head = head.getSiguiente();
            return dato;
        }
        public T peek() {
            if (isEmpty()) throw new IllegalStateException("No se puede consultar una pila vacia.");
            return head.getDato(); // null tambien es un dato valido; no significa pila vacia.
        }
        public boolean isEmpty() { return head == null; }
        public boolean contains(T dato) {
            Nodo<T> actual = head;
            while (actual != null) {
                if (Objects.equals(actual.getDato(), dato)) return true;
                actual = actual.getSiguiente();
            }
            return false;
        }
        public void print() {
            Nodo<T> actual = head;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente();
            }
            System.out.println("null");
        }
    }
    public static final class Alumno {
        private final int identificador;
        private final String nombre;
        public Alumno(int identificador, String nombre) {
            this.identificador = identificador; this.nombre = nombre;
        }
        public int getIdentificador() { return identificador; }
        public String getNombre() { return nombre; }
        @Override public String toString() { return identificador + ": " + nombre; }
        // La igualdad logica depende del identificador, no de ser el mismo objeto.
        @Override public boolean equals(Object otro) {
            return otro instanceof Alumno alumno && identificador == alumno.identificador;
        }
        @Override public int hashCode() { return Integer.hashCode(identificador); }
    }
    private static <T> void retirarTodos(Pila<T> pila) {
        pila.print();
        while (!pila.isEmpty()) {
            System.out.println("pop(): " + pila.pop());
            pila.print();
        }
    }
    public static void main(String[] args) {
        Pila<Integer> numeros = new Pila<>();
        numeros.push(10); numeros.push(20); numeros.push(30);
        retirarTodos(numeros);
        Pila<String> nombres = new Pila<>();
        nombres.push("Ana"); nombres.push("Luis"); nombres.push("Marta");
        retirarTodos(nombres);
        Pila<Alumno> alumnos = new Pila<>();
        alumnos.push(new Alumno(1, "Ana")); alumnos.push(new Alumno(2, "Luis"));
        alumnos.push(new Alumno(3, "Marta"));
        alumnos.print();
        System.out.println("peek(): " + alumnos.peek());
        System.out.println("contains alumno con identificador 2: " + alumnos.contains(new Alumno(2, "Otro nombre")));
        retirarTodos(alumnos);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

/*
Implementar desde cero una cola enlazada genérica en Java mediante `Nodo<T>` y `Cola<T>`, que respete el principio FIFO y permita almacenar distintos tipos de objetos.

**Estructura y justificación:** utilizar nodos con un dato de tipo `T` y una referencia `Nodo<T> siguiente`. La cola mantiene dos referencias: `head` al primer nodo y `tail` al último. Insertar por `tail` y retirar por `head` permite realizar `enqueue` y `dequeue` en O(1). Sin `tail`, insertar al final requeriría un recorrido O(n). La lógica FIFO es independiente del tipo de dato almacenado.

**Clases:**
- `Ejercicio4`: clase pública con método `main`.
- `Nodo<T>`: atributos privados `T dato` y `Nodo<T> siguiente`.
- `Cola<T>`: referencias privadas `Nodo<T> head` y `Nodo<T> tail`.
- `Cliente`: clase sencilla con identificador y nombre, `toString()`, `equals()` y `hashCode()` basados coherentemente en el identificador.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio4`, sin depender de otros ejercicios.

**Operaciones de `Cola<T>`:**
- `void enqueue(T dato)`: agregar un nodo al final. Si la cola está vacía, `head` y `tail` deben apuntar al nuevo nodo; en caso contrario, enlazarlo desde el antiguo `tail` y actualizar `tail`.
- `T dequeue()`: devolver y retirar el primer elemento, actualizando `head`. Si se retira el último nodo, actualizar también `tail = null`.
- `T peek()`: consultar el dato de `head` sin modificar la estructura.
- `boolean isEmpty()`: verificar si `head == null`.
- `boolean contains(T dato)`: recorrer los nodos y comparar mediante `Objects.equals()`.
- `void print()`: mostrar los elementos desde `head` hasta `null`, en orden FIFO.

**Manejo de referencias:** mantener `head == null` y `tail == null` cuando la cola está vacía. Si contiene un solo nodo, ambas referencias deben apuntar al mismo objeto. En una cola no vacía, `tail.siguiente` siempre debe ser `null`. No perder nodos ni generar ciclos.

**Casos especiales:** aceptar datos `null` de manera coherente; `dequeue()` y `peek()` sobre una cola vacía deben lanzar `IllegalStateException` sin alterar su estado. Probar duplicados, búsquedas exitosas y fallidas y reinserción después de vaciar la cola.

**Comparación de objetos:** utilizar `Objects.equals()` para que `contains()` funcione con `String`, `Cliente` y `null`. En `Cliente`, dos objetos diferentes con el mismo identificador deben considerarse iguales.

**Complejidad:** `enqueue`, `dequeue`, `peek` e `isEmpty`: O(1). `contains` y `print`: O(n), considerando operaciones sobre datos de costo constante. Espacio auxiliar: O(1). Almacenamiento total: O(n).

**Ejemplos y pruebas:**
1. `Cola<String>`: encolar `"Ana"`, `"Luis"` y `"Marta"`; verificar que los retiros devuelvan Ana, Luis y Marta, en ese orden.
2. `Cola<Cliente>`: encolar tres clientes, verificar el primero mediante `peek()` y atenderlos en orden de llegada.
3. Buscar un cliente utilizando otro objeto con el mismo identificador.
4. Probar cola vacía, un único nodo, duplicados, datos `null`, búsquedas, excepciones y reinserción.
5. Verificar que `peek`, `contains` y `print` no modifican la cola.
6. Comprobar identidad de nodos, orden FIFO, enlaces, actualización de `head` y `tail`, y ausencia de ciclos.

**Restricciones:** no utilizar arreglos ni colecciones predefinidas (`Queue`, `LinkedList`, `ArrayList`, `Deque`, etc.) para implementar la cola. No usar tipos raw ni conversiones inseguras. No modificar ejercicios anteriores ni realizar commits o push.

Compilar individualmente y conjuntamente con los ejercicios 1 al 3 utilizando Java 21, `--release 21` y `-Xlint:all`. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas.
*/
import java.util.Objects;

public class Ejercicio4 {
    public static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;
        public Nodo(T dato) { this.dato = dato; siguiente = null; }
        public T getDato() { return dato; }
        public Nodo<T> getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo<T> siguiente) { this.siguiente = siguiente; }
    }
    public static class Cola<T> {
        private Nodo<T> head = null;
        private Nodo<T> tail = null;
        public void enqueue(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (isEmpty()) {
                head = nuevo;
                tail = nuevo;
            } else {
                tail.setSiguiente(nuevo); // Conectar antes de actualizar tail.
                tail = nuevo;
            }
        }
        public T dequeue() {
            if (isEmpty()) throw new IllegalStateException("No se puede retirar de una cola vacia.");
            T dato = head.getDato();
            head = head.getSiguiente(); // FIFO: retirar al primero que ingreso.
            if (head == null) tail = null;
            return dato;
        }
        public T peek() {
            if (isEmpty()) throw new IllegalStateException("No se puede consultar una cola vacia.");
            return head.getDato(); // null tambien es un dato valido; no significa cola vacia.
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
    public static final class Cliente {
        private final int identificador;
        private final String nombre;
        public Cliente(int identificador, String nombre) {
            this.identificador = identificador; this.nombre = nombre;
        }
        public int getIdentificador() { return identificador; }
        public String getNombre() { return nombre; }
        @Override public String toString() { return identificador + ": " + nombre; }
        // La igualdad logica depende del identificador, no de ser el mismo objeto.
        @Override public boolean equals(Object otro) {
            return otro instanceof Cliente cliente && identificador == cliente.identificador;
        }
        @Override public int hashCode() { return Integer.hashCode(identificador); }
    }
    private static <T> void retirarTodos(Cola<T> cola) {
        cola.print();
        while (!cola.isEmpty()) {
            System.out.println("dequeue(): " + cola.dequeue());
            cola.print();
        }
    }
    public static void main(String[] args) {
        Cola<String> nombres = new Cola<>();
        nombres.enqueue("Ana"); nombres.enqueue("Luis"); nombres.enqueue("Marta");
        System.out.println("peek(): " + nombres.peek());
        retirarTodos(nombres);
        Cola<Cliente> clientes = new Cola<>();
        clientes.enqueue(new Cliente(1, "Ana")); clientes.enqueue(new Cliente(2, "Luis"));
        clientes.enqueue(new Cliente(3, "Marta"));
        clientes.print();
        System.out.println("peek(): " + clientes.peek());
        System.out.println("contains cliente con identificador 2: " + clientes.contains(new Cliente(2, "Otro nombre")));
        retirarTodos(clientes);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

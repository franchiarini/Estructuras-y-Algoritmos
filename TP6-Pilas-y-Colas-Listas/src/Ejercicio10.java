/*
Implementar desde cero una lista doblemente enlazada genérica en Java, que permita insertar elementos al inicio y al final, eliminar un elemento y recorrer la lista en ambas direcciones.

**Estructura y justificación:** utilizar una lista doblemente enlazada con nodos `Nodo<T>`, donde cada nodo almacena un dato de tipo `T` y dos referencias: `anterior` y `siguiente`. Mantener `head` al primer nodo y `tail` al último. Esta estructura permite recorrer la lista hacia adelante y atrás e insertar en ambos extremos en O(1), a cambio de almacenar y actualizar más referencias que una lista simple.

**Clases:**
- `Ejercicio10`: clase pública con método `main`.
- `Nodo<T>`: atributos privados `T dato`, `Nodo<T> anterior` y `Nodo<T> siguiente`.
- `ListaDoble<T>`: referencias privadas `Nodo<T> head` y `Nodo<T> tail`, y contador `int size`.

Implementar las clases auxiliares como estáticas anidadas dentro de `Ejercicio10`, sin conflictos con otros ejercicios.

**Operaciones:**
- `void insertarAlInicio(T dato)`: crear un nodo, conectarlo al antiguo `head` en ambos sentidos y actualizar `head`. Si la lista estaba vacía, actualizar también `tail`.
- `void insertarAlFinal(T dato)`: crear un nodo, conectarlo al antiguo `tail` en ambos sentidos y actualizar `tail`. Si estaba vacía, actualizar también `head`.
- `boolean eliminar(T dato)`: buscar desde `head` y eliminar solamente la primera coincidencia, comparando mediante `Objects.equals()`. Devolver `true` si se eliminó y `false` si no se encontró.
- `void imprimirAdelante()`: recorrer desde `head` siguiendo `siguiente` hasta `null`.
- `void imprimirAtras()`: recorrer desde `tail` siguiendo `anterior` hasta `null`.
- `boolean estaVacia()` y `int getSize()`: consultar el estado sin recorrer la lista.

**Manejo de referencias:** al eliminar un nodo intermedio, conectar su vecino anterior con su vecino siguiente y actualizar ambos enlaces. Al eliminar `head`, actualizar el nuevo `head.anterior = null`; al eliminar `tail`, actualizar el nuevo `tail.siguiente = null`. Al eliminar el único nodo, establecer ambas referencias en `null`.

Mantener siempre:
- `head == null` si y solo si `tail == null` y `size == 0`.
- En listas no vacías, `head.anterior == null` y `tail.siguiente == null`.
- Los recorridos hacia adelante y atrás deben visitar exactamente los mismos nodos en orden inverso.
- `size` debe coincidir con la cantidad real de nodos.
- No generar ciclos, referencias inconsistentes ni nodos inaccesibles.

**Casos especiales:** lista vacía, nodo único, inserciones en ambos extremos, eliminación del primer nodo, último nodo e intermedio, dato inexistente, valores duplicados y elementos `null`. Permitir `null` como dato y utilizar `Objects.equals()` para comparar de forma segura. Eliminar solamente la primera aparición. Las eliminaciones fallidas no deben modificar la lista.

**Complejidad:** insertar al inicio y al final: O(1). Buscar y eliminar por valor: O(n) en el peor caso; una vez encontrado, desvincular un nodo cuesta O(1). Imprimir hacia adelante o atrás: O(n). Consultar vacío y tamaño: O(1). Espacio auxiliar por operación: O(1); almacenamiento total: O(n).

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar 20 y 30 al final, y 10 al inicio.
3. Verificar recorrido hacia adelante: `10 <-> 20 <-> 30`.
4. Verificar recorrido hacia atrás: `30 <-> 20 <-> 10`.
5. Eliminar 20 y comprobar ambos recorridos: `10 <-> 30` y `30 <-> 10`.
6. Eliminar 10 y luego 30, comprobando `head == null`, `tail == null` y `size == 0`.
7. Insertar nuevamente un elemento y verificar que la lista sigue funcionando.

**Pruebas adicionales:** usar `Integer`, `String` y objetos propios sencillos; verificar genéricos, duplicados, datos `null`, eliminaciones fallidas, eliminación del primer duplicado, operaciones sobre lista vacía y actualizaciones de `head`, `tail`, `anterior`, `siguiente` y `size`. Confirmar que los nodos conservados mantienen sus identidades y datos originales. Probar listas extensas y recorridos en ambos sentidos sin ciclos.

**Restricciones:** implementar los nodos y enlaces manualmente, sin utilizar `LinkedList`, `ArrayList`, `List`, `Deque`, arreglos ni colecciones predefinidas como almacenamiento de la lista. No usar tipos raw, recursividad ni copiar los nodos para simular eliminaciones. No depender de clases de otros ejercicios.

Compilar individualmente y conjuntamente con los ejercicios 1 al 9 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No modificar archivos anteriores ni realizar commits o push.
*/
import java.util.Objects;

public class Ejercicio10 {
    public static class Nodo<T> {
        private T dato;
        private Nodo<T> anterior;
        private Nodo<T> siguiente;
        public Nodo(T dato) { this.dato = dato; anterior = null; siguiente = null; }
    }
    public static class ListaDoble<T> {
        private Nodo<T> head = null;
        private Nodo<T> tail = null;
        private int size = 0;
        public void insertarAlInicio(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.siguiente = head;
            if (head == null) tail = nuevo;
            else head.anterior = nuevo;
            head = nuevo;
            size++;
        }
        public void insertarAlFinal(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.anterior = tail;
            if (tail == null) head = nuevo;
            else tail.siguiente = nuevo;
            tail = nuevo;
            size++;
        }
        public boolean eliminar(T dato) {
            Nodo<T> actual = head;
            while (actual != null) {
                if (Objects.equals(actual.dato, dato)) {
                    // Conectar ambos vecinos; si falta uno, actualizar el extremo.
                    if (actual.anterior == null) head = actual.siguiente;
                    else actual.anterior.siguiente = actual.siguiente;
                    if (actual.siguiente == null) tail = actual.anterior;
                    else actual.siguiente.anterior = actual.anterior;
                    size--;
                    return true; // Solo la primera coincidencia, sin copiar datos.
                }
                actual = actual.siguiente;
            }
            return false;
        }
        public void imprimirAdelante() {
            Nodo<T> actual = head;
            while (actual != null) {
                System.out.print(actual.dato);
                actual = actual.siguiente;
                if (actual != null) System.out.print(" <-> ");
            }
            System.out.println();
        }
        public void imprimirAtras() {
            Nodo<T> actual = tail;
            while (actual != null) {
                System.out.print(actual.dato);
                actual = actual.anterior;
                if (actual != null) System.out.print(" <-> ");
            }
            System.out.println();
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }
    private static void mostrar(ListaDoble<?> lista) {
        System.out.print("Adelante: "); lista.imprimirAdelante();
        System.out.print("Atras: "); lista.imprimirAtras();
        System.out.println("size = " + lista.getSize());
    }
    public static void main(String[] args) {
        ListaDoble<Integer> lista = new ListaDoble<>();
        lista.insertarAlFinal(20); lista.insertarAlFinal(30); lista.insertarAlInicio(10);
        mostrar(lista);
        for (int dato : new int[]{20, 10, 30}) {
            System.out.println("eliminar(" + dato + "): " + lista.eliminar(dato));
            mostrar(lista);
        }
        System.out.println("head == null: " + (lista.head == null) + ", tail == null: " + (lista.tail == null));
        lista.insertarAlFinal(40);
        mostrar(lista);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

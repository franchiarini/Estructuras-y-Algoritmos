/*
Implementar desde cero un sistema sencillo de historial de navegación mediante una pila enlazada, que permita visitar páginas, retroceder, consultar la página actual e imprimir el historial.

**Estructura y justificación:** utilizar una pila enlazada de `String` siguiendo LIFO. Las páginas anteriores se almacenan en nodos, con `head` como tope. La última página abandonada debe ser la primera recuperada cuando el usuario vuelve atrás.

**Clases:**
- `Ejercicio5`: clase pública con `main`.
- `Nodo`: contiene `String pagina` y `Nodo siguiente`.
- `PilaHistorial`: administra `head` e implementa `push`, `pop`, `isEmpty` y recorrido.
- `Navegador`: mantiene la página actual y utiliza `PilaHistorial` para guardar las anteriores.

Implementar las clases auxiliares como clases estáticas anidadas dentro de `Ejercicio5`.

**Operaciones:**
- `void visitar(String pagina)`: si existe una página actual, guardarla en la pila; luego establecer la nueva página como actual.
- `boolean volver()`: si hay historial, recuperar con `pop()` la última página anterior, convertirla en actual y devolver `true`. Si no existe historial, devolver `false` sin modificar el estado.
- `String consultarPaginaActual()`: devolver la página actual sin alterar referencias; devolver `null` si todavía no se visitó ninguna.
- `void imprimirHistorial()`: mostrar la página actual y las anteriores en orden de retorno, desde el tope hasta `null`, sin modificar la pila.

**Manejo de referencias:** `push` inserta un nodo al inicio mediante `nuevo.siguiente = head` y `head = nuevo`. `pop` recupera el dato del tope y avanza `head = head.siguiente`. No utilizar arreglos ni colecciones predefinidas para almacenar el historial.

**Casos especiales:** navegador recién creado, primer ingreso, retroceder sin historial, visitar la misma página dos veces, varias visitas y retrocesos consecutivos. Rechazar nombres de página `null`, vacíos o solo espacios con `IllegalArgumentException`, sin modificar el estado. No implementar navegación hacia adelante, porque no forma parte de la consigna.

**Complejidad:** visitar, volver y consultar página actual: O(1) respecto de la cantidad de páginas. Imprimir el historial: O(n). Espacio auxiliar por operación: O(1); almacenamiento total: O(n).

**Ejemplo principal:**
1. Crear un navegador sin página actual.
2. Visitar `"Google"`, `"YouTube"` y `"ChatGPT"`.
3. Comprobar que la página actual es `"ChatGPT"` y que el historial permite volver primero a `"YouTube"` y después a `"Google"`.
4. Ejecutar `volver()` y comprobar que la página actual pasa a `"YouTube"`.
5. Ejecutar nuevamente `volver()` y comprobar que pasa a `"Google"`.
6. Intentar otro retroceso y verificar que devuelve `false` sin modificar la página actual.
7. Visitar `"Wikipedia"` y comprobar que el historial vuelve a funcionar.

**Pruebas:** verificar LIFO, navegador vacío, visitas repetidas, nombres inválidos, conservación de referencias, ausencia de ciclos y que consultar o imprimir no modifica el estado.

**Restricciones:** implementar la pila manualmente mediante nodos. No utilizar `Stack`, `Deque`, `ArrayList`, `LinkedList` ni otras colecciones para el historial. No depender de clases de otros ejercicios ni modificar archivos anteriores.

Compilar individualmente y conjuntamente con los ejercicios 1 al 4 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Ejecutar pruebas reales e informar casos y verificaciones aprobadas y fallidas. No realizar commits ni push.
*/
public class Ejercicio5 {
    public static class Nodo {
        private final String pagina;
        private Nodo siguiente;
        public Nodo(String pagina) { this.pagina = pagina; siguiente = null; }
    }
    public static class PilaHistorial {
        private Nodo head = null;
        public void push(String pagina) {
            Nodo nuevo = new Nodo(pagina);
            nuevo.siguiente = head; // Preservar los nodos anteriores antes de mover el tope.
            head = nuevo;
        }
        public String pop() {
            if (isEmpty()) throw new IllegalStateException("Historial vacio.");
            String pagina = head.pagina;
            head = head.siguiente;
            return pagina;
        }
        public boolean isEmpty() { return head == null; }
        public void imprimir() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.pagina + " -> ");
                actual = actual.siguiente;
            }
            System.out.println("null");
        }
    }
    public static class Navegador {
        private String paginaActual = null;
        private final PilaHistorial historial = new PilaHistorial();
        public void visitar(String pagina) {
            // Validar antes de guardar la pagina anterior o cambiar la actual.
            if (pagina == null || pagina.isBlank()) {
                throw new IllegalArgumentException("La pagina no puede ser nula, vacia ni solo espacios.");
            }
            if (paginaActual != null) historial.push(paginaActual);
            paginaActual = pagina;
        }
        public boolean volver() {
            if (historial.isEmpty()) return false;
            // LIFO: recuperar la ultima pagina abandonada; no conservar avance.
            paginaActual = historial.pop();
            return true;
        }
        public String consultarPaginaActual() { return paginaActual; }
        public void imprimirHistorial() {
            System.out.println("Pagina actual: " + paginaActual);
            System.out.print("Anteriores (orden de retorno): ");
            historial.imprimir();
        }
    }
    public static void main(String[] args) {
        Navegador navegador = new Navegador();
        navegador.imprimirHistorial();
        for (String pagina : new String[]{"Google", "YouTube", "ChatGPT"}) {
            navegador.visitar(pagina);
            System.out.println("Visitar: " + pagina);
            navegador.imprimirHistorial();
        }
        for (int i = 0; i < 3; i++) {
            System.out.println("Volver: " + navegador.volver());
            navegador.imprimirHistorial();
        }
        navegador.visitar("Wikipedia");
        System.out.println("Visitar: Wikipedia");
        navegador.imprimirHistorial();
    }
}

// Ajustes al prompt: no fueron necesarios. Visitar es O(1) respecto de la cantidad
// de paginas; validar su nombre con isBlank cuesta O(L) en el peor caso.

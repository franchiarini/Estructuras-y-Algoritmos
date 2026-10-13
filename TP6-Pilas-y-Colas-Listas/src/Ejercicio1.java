/*
Implementá en Java una pila de números enteros mediante una lista enlazada simple construida desde cero, utilizando nodos y referencias en lugar de un arreglo.

**Estructura elegida:** pila enlazada de enteros, siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** implementar una clase `Nodo` que almacene un entero y una referencia al siguiente nodo. Implementar una clase `PilaEnteros` que mantenga una referencia `head` al nodo superior de la pila. Las operaciones de inserción y eliminación deben realizarse exclusivamente desde `head`, para mantener una complejidad O(1).

**Justificación:** una pila se caracteriza porque el último elemento que ingresa es el primero que se retira. Una lista enlazada permite implementar ese comportamiento agregando y quitando nodos desde el inicio. Como no es necesario recorrer los nodos, `push` y `pop` tienen complejidad O(1). A diferencia de una pila con arreglo de capacidad fija, la pila enlazada puede crecer dinámicamente mientras exista memoria disponible.

**Representación de los nodos:**
- Cada nodo almacena `int dato`.
- Cada nodo almacena una referencia `Nodo siguiente`.
- Al crearse, el siguiente nodo debe inicializarse en `null`.
- Los nodos se conectan mediante referencias.
- El último nodo de la pila debe apuntar a `null`.

**Representación de la pila:**
- Mantener una referencia privada `head`.
- `head` representa el tope de la pila.
- Inicializar `head = null`.
- Una pila estará vacía cuando `head == null`.
- No utilizar una referencia `tail` porque no resulta necesaria para administrar una pila LIFO desde el inicio.
- No utilizar arreglos como almacenamiento de la estructura.
- La pila no debe imponer una capacidad máxima artificial.

**Operaciones requeridas:**

1. `void push(int dato)`:
   - Crear un nuevo nodo con el dato recibido.
   - Hacer que el nuevo nodo apunte al `head` anterior.
   - Actualizar `head` para que apunte al nuevo nodo.
   - Mantener accesibles los nodos anteriores.
   - No recorrer la pila.

2. `int pop()`:
   - Verificar primero que la pila no esté vacía.
   - Obtener el valor almacenado en `head`.
   - Actualizar `head` para que apunte al siguiente nodo.
   - Devolver el valor retirado.
   - No recorrer el resto de la pila.
   - Si la pila queda vacía, `head` debe pasar a `null`.

3. `int peek()`:
   - Verificar que la pila no esté vacía.
   - Devolver el dato almacenado en `head`.
   - No retirar el nodo.
   - No modificar ninguna referencia.

4. `boolean isEmpty()`:
   - Devolver `true` si `head == null`.
   - Devolver `false` si existe al menos un nodo.

5. `boolean contains(int dato)`:
   - Recorrer la pila desde `head` utilizando una referencia auxiliar.
   - Comparar cada dato con el valor buscado.
   - Devolver `true` cuando se encuentre la primera coincidencia.
   - Si se alcanza `null` sin encontrar el valor, devolver `false`.
   - No modificar la pila.

6. `void print()`:
   - Recorrer desde `head` hasta `null`.
   - Mostrar los elementos comenzando por el tope.
   - Representar la pila utilizando flechas y terminar con `null`.
   - No modificar el contenido ni las referencias durante la impresión.

**Funcionamiento interno de push:**

Si la pila contiene:

`head -> 30 -> 20 -> 10 -> null`

Y ejecutamos `push(40)`, debemos:

1. Crear el nodo que almacena 40.
2. Conectar el nuevo nodo con el antiguo `head`.
3. Actualizar `head` al nodo 40.

Resultado:

`head -> 40 -> 30 -> 20 -> 10 -> null`

El orden de las referencias es fundamental:

`nuevo.setSiguiente(head);`

`head = nuevo;`

No invertir estas instrucciones, porque podríamos perder el acceso a los nodos originales.

**Funcionamiento interno de pop:**

Si la pila contiene:

`head -> 40 -> 30 -> 20 -> 10 -> null`

Al ejecutar `pop()`:

1. Verificar que `head` no sea `null`.
2. Guardar el valor 40.
3. Actualizar `head` para que apunte al nodo 30.
4. Devolver 40.

Resultado:

`head -> 30 -> 20 -> 10 -> null`

El nodo retirado deja de pertenecer a la pila. Cuando ya no existan referencias que lo hagan alcanzable, podrá ser recuperado posteriormente por el Garbage Collector de Java.

**Casos especiales:**
- Pila recién creada y vacía.
- Ejecutar `pop()` sobre una pila vacía.
- Ejecutar `peek()` sobre una pila vacía.
- Apilar el primer elemento.
- Retirar el único elemento.
- Apilar y desapilar varios elementos.
- Buscar en una pila vacía.
- Buscar el tope.
- Buscar un elemento intermedio.
- Buscar el último elemento.
- Buscar un valor inexistente.
- Valores repetidos.
- Números negativos, cero y extremos de `int`.
- Comprobar que `peek`, `contains` y `print` no modifican la estructura.
- Comprobar que una operación inválida no altera el estado.
- Verificar que los nodos restantes continúan enlazados correctamente después de cada `pop`.

**Política de errores:**
- `pop()` sobre una pila vacía debe lanzar `IllegalStateException`.
- `peek()` sobre una pila vacía debe lanzar `IllegalStateException`.
- Las excepciones no deben modificar `head` ni los enlaces.
- `contains()` sobre una pila vacía debe devolver `false`.
- `print()` sobre una pila vacía debe mostrar una representación clara de la estructura vacía, por ejemplo `null`.

**Complejidad:**
- `push`: O(1).
- `pop`: O(1).
- `peek`: O(1).
- `isEmpty`: O(1).
- `contains`: O(n) en el peor caso.
- `print`: O(n).
- Espacio auxiliar de las operaciones: O(1), sin contar la creación del nodo de `push`.
- Espacio total de almacenamiento: O(n), correspondiente a los nodos de la pila.

**Requisitos de implementación:**
- Crear `src/Ejercicio1.java` dentro de la carpeta real del TP6.
- Implementar una clase pública `Ejercicio1` con método `main`.
- Implementar una clase auxiliar `Nodo` con `dato` y `siguiente`.
- Implementar una clase auxiliar `PilaEnteros` con una referencia privada `head`.
- Preferir clases estáticas anidadas dentro de `Ejercicio1` para evitar conflictos de nombres con futuros ejercicios.
- Mantener privados los atributos internos.
- Implementar manualmente las seis operaciones solicitadas.
- No utilizar `Stack`, `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- No utilizar arreglos como estructura interna de almacenamiento.
- No utilizar recursividad para implementar `push`, `pop`, `peek`, `contains` o `print`.
- No depender de clases implementadas en otros trabajos prácticos.
- Incorporar comentarios que expliquen LIFO, el papel de `head`, el manejo de referencias y el Garbage Collector.
- Mostrar el contenido de la pila antes y después de las operaciones relevantes.
- Verificar que el último nodo siempre apunte a `null`.
- Verificar que no se generen ciclos ni nodos inaccesibles que deban continuar en la pila.

**Ejemplo principal:**
1. Crear una pila enlazada vacía.
2. Comprobar que `isEmpty()` devuelve `true`.
3. Ejecutar `push(10)`.
4. Ejecutar `push(20)`.
5. Ejecutar `push(30)`.
6. Mostrar `30 -> 20 -> 10 -> null`.
7. Consultar `peek()` y comprobar que devuelve 30.
8. Ejecutar `contains(20)` y comprobar que devuelve `true`.
9. Ejecutar `contains(99)` y comprobar que devuelve `false`.
10. Ejecutar `push(40)`.
11. Mostrar `40 -> 30 -> 20 -> 10 -> null`.
12. Ejecutar `pop()` y verificar que devuelve 40.
13. Ejecutar `pop()` y verificar que devuelve 30.
14. Ejecutar `pop()` y verificar que devuelve 20.
15. Ejecutar `pop()` y verificar que devuelve 10.
16. Verificar que `isEmpty()` devuelve `true`.
17. Comprobar que `head == null`.
18. Intentar ejecutar `pop()` y `peek()` sobre la pila vacía y verificar las excepciones correspondientes.
19. Comprobar que las operaciones inválidas conservaron el estado vacío.
20. Ejecutar `push(50)` después de vaciar la pila y comprobar que vuelve a funcionar correctamente.

**Pruebas adicionales:**
- Pila vacía.
- Pila de un nodo.
- Pila de múltiples nodos.
- Múltiples inserciones consecutivas.
- Múltiples retiros consecutivos.
- Alternancia de `push` y `pop`.
- Comprobación del orden LIFO.
- Consulta `peek()` sin eliminar.
- Búsqueda exitosa y fallida.
- Búsqueda de un dato repetido.
- Búsqueda de números negativos.
- Búsqueda del valor cero.
- Búsqueda de `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Rechazo de `pop()` sobre pila vacía.
- Rechazo de `peek()` sobre pila vacía.
- Conservación de identidad y datos de los nodos restantes.
- Comprobación de que `push` no pierde el antiguo `head`.
- Comprobación de que `pop` actualiza correctamente `head`.
- Comprobación de que el último nodo termina en `null`.
- Comprobación de ausencia de ciclos.
- Comprobación de que `contains` y `print` no modifican la pila.
- Verificar que puede volver a utilizarse después de quedar vacía.
- Verificar el comportamiento con secuencias largas de operaciones.

Compilar individualmente y ejecutar utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio1 {
    public static class Nodo {
        private final int dato;
        private Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; siguiente = null; }
        public int getDato() { return dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    public static class PilaEnteros {
        private Nodo head = null; // Tope: insertar y retirar aqui respeta LIFO.

        public void push(int dato) {
            Nodo nuevo = new Nodo(dato);
            nuevo.setSiguiente(head); // Preservar primero todos los nodos anteriores.
            head = nuevo;
        }
        public int pop() {
            if (isEmpty()) throw new IllegalStateException("No se puede retirar de una pila vacia.");
            int dato = head.getDato();
            head = head.getSiguiente(); // O(1), sin recorrer la pila.
            // Sin otras referencias, el nodo retirado puede ser recuperado posteriormente
            // por el Garbage Collector; no se libera manualmente ni de inmediato.
            return dato;
        }
        public int peek() {
            if (isEmpty()) throw new IllegalStateException("No se puede consultar una pila vacia.");
            return head.getDato(); // No modifica el tope ni los enlaces.
        }
        public boolean isEmpty() { return head == null; }
        public boolean contains(int dato) {
            Nodo actual = head;
            while (actual != null) {
                if (actual.getDato() == dato) return true;
                actual = actual.getSiguiente();
            }
            return false;
        }
        public void print() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente(); // Solo avanza la referencia local.
            }
            System.out.println("null");
        }
    }

    public static void main(String[] args) {
        PilaEnteros pila = new PilaEnteros();
        System.out.println("Vacia: " + pila.isEmpty());
        pila.print();
        for (int dato : new int[]{10, 20, 30}) {
            pila.push(dato);
            System.out.println("push(" + dato + ")");
            pila.print();
        }
        System.out.println("peek(): " + pila.peek());
        System.out.println("contains(20): " + pila.contains(20));
        System.out.println("contains(99): " + pila.contains(99));
        pila.push(40);
        System.out.println("push(40)");
        pila.print();
        while (!pila.isEmpty()) {
            System.out.println("pop(): " + pila.pop());
            pila.print();
        }
        System.out.println("Vacia: " + pila.isEmpty() + ", head == null: " + (pila.head == null));
        try { pila.pop(); }
        catch (IllegalStateException e) { System.out.println("pop(): " + e.getMessage()); }
        try { pila.peek(); }
        catch (IllegalStateException e) { System.out.println("peek(): " + e.getMessage()); }
        pila.print();
        pila.push(50);
        System.out.println("push(50) despues de vaciar:");
        pila.print();
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

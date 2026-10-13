/*
Implementá en Java una cola de números enteros mediante una lista enlazada simple construida desde cero, utilizando nodos conectados por referencias y manteniendo tanto `head` como `tail`.

**Estructura elegida:** cola enlazada de enteros, siguiendo el principio FIFO (First In, First Out).

**Estrategia:** implementar una clase `Nodo` que almacene un entero y una referencia al siguiente nodo. Implementar una clase `ColaEnteros` con dos referencias: `head`, que apunta al primer elemento de la cola, y `tail`, que apunta al último. Las inserciones se realizan en `tail` y los retiros en `head`, permitiendo resolver ambas operaciones en O(1).

**Justificación:** una cola FIFO debe retirar primero el elemento que ingresó antes. Utilizar solamente `head` permitiría retirar el primer nodo en O(1), pero insertar al final requeriría recorrer toda la lista en O(n). La referencia `tail` evita ese recorrido, porque permite acceder directamente al último nodo y agregar uno nuevo en O(1).

**Representación de los nodos:**
- Cada nodo almacena un atributo `int dato`.
- Cada nodo contiene una referencia `Nodo siguiente`.
- Al crear un nodo, `siguiente` debe inicializarse en `null`.
- Los nodos se conectan mediante referencias.
- El último nodo de la cola debe apuntar siempre a `null`.

**Representación de la cola:**
- Mantener una referencia privada `head` al primer nodo.
- Mantener una referencia privada `tail` al último nodo.
- Inicializar `head = null` y `tail = null`.
- La cola está vacía cuando `head == null`.
- Si está vacía, ambas referencias deben ser `null`.
- Si contiene un solo elemento, `head` y `tail` deben apuntar al mismo nodo.
- Si contiene varios elementos, `head` debe apuntar al primero y `tail` al último.
- No utilizar arreglos ni establecer una capacidad máxima artificial.
- La estructura debe crecer dinámicamente mediante nuevos nodos, mientras exista memoria disponible.

**Operaciones requeridas:**

1. `void enqueue(int dato)`:
   - Crear un nuevo nodo con el valor recibido.
   - Si la cola está vacía, actualizar tanto `head` como `tail` para que apunten al nuevo nodo.
   - Si no está vacía, conectar el antiguo `tail` con el nuevo nodo.
   - Actualizar `tail` para que apunte al nuevo nodo.
   - No recorrer la cola.
   - Conservar el orden FIFO.

2. `int dequeue()`:
   - Verificar que la cola no esté vacía.
   - Guardar el dato del nodo apuntado por `head`.
   - Actualizar `head` para que apunte al siguiente nodo.
   - Si la cola queda vacía, actualizar también `tail = null`.
   - Devolver el dato retirado.
   - No recorrer la cola.

3. `int peek()`:
   - Verificar que la cola no esté vacía.
   - Devolver el dato almacenado en `head`.
   - No modificar la estructura.

4. `boolean isEmpty()`:
   - Devolver `true` cuando `head == null`.
   - Devolver `false` cuando exista al menos un nodo.
   - Mantener coherencia con el estado de `tail`.

5. `boolean contains(int dato)`:
   - Recorrer desde `head` utilizando una referencia auxiliar.
   - Comparar cada nodo con el valor buscado.
   - Devolver `true` cuando se encuentra la primera coincidencia.
   - Devolver `false` cuando se llega a `null` sin encontrar el valor.
   - No modificar la cola.

6. `void print()`:
   - Recorrer la cola desde `head` hasta `null`.
   - Imprimir los elementos en el orden FIFO, comenzando por el primero que debe salir.
   - Representar los nodos separados por flechas y terminar con `null`.
   - No modificar ninguna referencia.

**Funcionamiento interno de enqueue:**

Si la cola contiene:

`head -> 10 -> 20 -> 30 -> null`

Y `tail` apunta al nodo 30, ejecutar `enqueue(40)` debe:

1. Crear el nodo 40, con `siguiente = null`.
2. Ejecutar `tail.setSiguiente(nuevo)`.
3. Ejecutar `tail = nuevo`.

El resultado debe ser:

`head -> 10 -> 20 -> 30 -> 40 -> null`

Ahora `tail` debe apuntar al nodo 40.

El orden correcto es importante: primero conectar el nodo nuevo y después actualizar `tail`. Si se modifica primero `tail` sin conservar el enlace desde la lista, podría perderse la conexión con el nuevo nodo.

**Caso especial de enqueue sobre cola vacía:**

Si `head == null` y `tail == null`, el primer nodo debe asignarse a ambas referencias.

`head = nuevo;`

`tail = nuevo;`

La cola debe quedar con un único nodo correctamente conectado.

**Funcionamiento interno de dequeue:**

Si la cola contiene:

`head -> 10 -> 20 -> 30 -> null`

Ejecutar `dequeue()` debe:

1. Guardar el dato 10.
2. Actualizar `head` para que apunte al nodo 20.
3. Devolver 10.
4. Mantener `tail` apuntando al nodo 30.

Resultado:

`head -> 20 -> 30 -> null`

Si se retira el único nodo de la cola, `head` pasa a `null` y también debe establecerse `tail = null`.

**Importancia de head y tail:**
- `head` permite consultar y retirar el primer nodo en O(1).
- `tail` permite insertar al final en O(1).
- Sin `tail`, insertar al final requiere recorrer desde `head` hasta el último nodo, con costo O(n).
- Ambas referencias deben permanecer coherentes después de cada inserción y eliminación.
- No utilizar `tail` para retirar elementos, porque eso no respetaría el funcionamiento solicitado de una cola FIFO.

**Casos especiales:**
- Cola recién creada y vacía.
- Primer `enqueue` sobre una cola vacía.
- `dequeue` del único nodo.
- `dequeue` de una cola con varios nodos.
- `peek` en una cola vacía.
- `dequeue` en una cola vacía.
- Agregar nuevos elementos después de vaciar la cola.
- Buscar en una cola vacía.
- Buscar el primer elemento.
- Buscar un elemento intermedio.
- Buscar el último elemento.
- Buscar un valor inexistente.
- Valores repetidos.
- Números negativos, cero, `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que `peek`, `contains` y `print` no modifican la cola.
- Comprobar que las operaciones inválidas no alteran las referencias.
- Verificar que `tail.getSiguiente() == null` cuando la cola no está vacía.

**Política de errores:**
- `dequeue()` sobre una cola vacía debe lanzar `IllegalStateException`.
- `peek()` sobre una cola vacía debe lanzar `IllegalStateException`.
- Las excepciones no deben modificar `head`, `tail` ni los enlaces.
- `contains()` sobre una cola vacía debe devolver `false`.
- `print()` sobre una cola vacía debe mostrar `null` o una representación equivalente.

**Gestión de memoria:**
- Al retirar un nodo, debe dejar de pertenecer a la cola.
- Java administra automáticamente la memoria mediante el Garbage Collector.
- Un nodo desvinculado podrá recuperarse cuando ya no existan referencias que lo hagan alcanzable.
- No utilizar liberación manual de memoria.
- No afirmar que la recolección ocurre inmediatamente.

**Complejidad esperada:**
- `enqueue`: O(1).
- `dequeue`: O(1).
- `peek`: O(1).
- `isEmpty`: O(1).
- `contains`: O(n) en el peor caso.
- `print`: O(n).
- Espacio auxiliar por operación: O(1), sin contar el nodo agregado.
- Espacio total: O(n), correspondiente a los nodos almacenados.

**Requisitos de implementación:**
- Crear `TP6-Pilas-y-Colas-Listas/src/Ejercicio2.java`.
- Implementar una clase pública `Ejercicio2` con método `main`.
- Implementar una clase auxiliar `Nodo` con los atributos `dato` y `siguiente`.
- Implementar una clase auxiliar `ColaEnteros` con las referencias `head` y `tail`.
- Preferir clases estáticas anidadas dentro de `Ejercicio2` para evitar conflictos con el Ejercicio 1.
- Mantener privados los atributos internos.
- Implementar manualmente las seis operaciones.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList`, `Stack` ni colecciones predefinidas para implementar la cola.
- No utilizar arreglos como almacenamiento de la estructura.
- No utilizar recursividad para implementar las operaciones.
- No agregar métodos o funcionalidades ajenos a la consigna, salvo auxiliares de prueba necesarios.
- No depender de las clases de otros ejercicios.
- Incorporar comentarios que expliquen FIFO, las funciones de `head` y `tail`, la actualización de referencias y los casos especiales.
- Mostrar por consola el contenido de la cola antes y después de las operaciones principales.
- Verificar que los enlaces sean correctos y que no existan ciclos.
- Comprobar que `tail` siempre apunte al último nodo cuando la cola no esté vacía.

**Ejemplo principal:**
1. Crear una cola enlazada vacía.
2. Comprobar `isEmpty() == true`.
3. Comprobar que `head == null` y `tail == null`.
4. Ejecutar `enqueue(10)`.
5. Verificar que `head` y `tail` apuntan al mismo nodo.
6. Ejecutar `enqueue(20)`.
7. Ejecutar `enqueue(30)`.
8. Mostrar `10 -> 20 -> 30 -> null`.
9. Consultar `peek()` y verificar que devuelve 10 sin retirar el nodo.
10. Ejecutar `contains(20)` y verificar que devuelve `true`.
11. Ejecutar `contains(99)` y verificar que devuelve `false`.
12. Ejecutar `enqueue(40)`.
13. Mostrar `10 -> 20 -> 30 -> 40 -> null`.
14. Verificar que `tail` apunta al nodo que contiene 40.
15. Ejecutar `dequeue()` cuatro veces y comprobar que los valores retirados son 10, 20, 30 y 40.
16. Comprobar que la cola queda vacía.
17. Verificar que `head == null` y `tail == null`.
18. Intentar `dequeue()` y `peek()` sobre la cola vacía y comprobar `IllegalStateException`.
19. Verificar que las operaciones inválidas no modificaron las referencias.
20. Ejecutar `enqueue(50)` y comprobar que la cola vuelve a funcionar, con `head` y `tail` apuntando al nuevo nodo.
21. Ejecutar `enqueue(60)` y comprobar que el orden de retiro continúa siendo FIFO.

**Pruebas adicionales:**
- Cola vacía.
- Cola de un nodo.
- Cola de varios nodos.
- Inserción del primer elemento.
- Retiro del único elemento.
- Inserciones consecutivas.
- Retiros consecutivos.
- Alternancia de inserciones y retiros.
- Verificación del orden FIFO.
- Verificación de `head` después de `dequeue`.
- Verificación de `tail` después de `enqueue`.
- Verificación de ambas referencias al vaciar la cola.
- Verificación de que `head == tail` cuando existe un único nodo.
- Comprobación de que `tail.siguiente == null`.
- Consulta `peek` sin modificaciones.
- Búsquedas exitosas y fallidas.
- Valores repetidos.
- Valores negativos, cero y extremos de `int`.
- Rechazo de `dequeue` y `peek` sobre cola vacía.
- Conservación de identidad y datos de los nodos restantes.
- Comprobación de ausencia de ciclos.
- Comprobación de que no se pierden nodos durante inserciones.
- Comprobación de que `contains` y `print` no modifican el estado.
- Reinserción después de vaciar completamente la cola.
- Secuencias extensas de inserciones y retiros para verificar los enlaces.
- Verificación de que las operaciones principales no requieren recorridos innecesarios.

Compilar individualmente y conjuntamente con el Ejercicio 1 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar separadamente la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio2 {
    public static class Nodo {
        private final int dato;
        private Nodo siguiente;
        public Nodo(int dato) { this.dato = dato; siguiente = null; }
        public int getDato() { return dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    public static class ColaEnteros {
        private Nodo head = null;
        private Nodo tail = null;

        public void enqueue(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (isEmpty()) {
                head = nuevo;
                tail = nuevo;
            } else {
                // Conectar antes de mover tail: conservar el acceso desde head.
                tail.setSiguiente(nuevo);
                tail = nuevo;
            }
        }
        public int dequeue() {
            if (isEmpty()) throw new IllegalStateException("No se puede retirar de una cola vacia.");
            int dato = head.getDato();
            head = head.getSiguiente(); // FIFO: retirar el primero que ingreso.
            if (head == null) tail = null; // No conservar un ultimo nodo de una cola vacia.
            // Sin referencias que lo hagan alcanzable, el nodo retirado puede ser
            // recuperado posteriormente por el Garbage Collector, no necesariamente ahora.
            return dato;
        }
        public int peek() {
            if (isEmpty()) throw new IllegalStateException("No se puede consultar una cola vacia.");
            return head.getDato();
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
                actual = actual.getSiguiente();
            }
            System.out.println("null");
        }
    }

    private static void mostrar(ColaEnteros cola) {
        cola.print();
        System.out.println("head = " + (cola.head == null ? "null" : cola.head.getDato())
                + ", tail = " + (cola.tail == null ? "null" : cola.tail.getDato()));
    }
    public static void main(String[] args) {
        ColaEnteros cola = new ColaEnteros();
        System.out.println("Vacia: " + cola.isEmpty());
        mostrar(cola);
        for (int dato : new int[]{10, 20, 30}) {
            cola.enqueue(dato);
            System.out.println("enqueue(" + dato + ")");
            mostrar(cola);
            if (dato == 10) System.out.println("head == tail: " + (cola.head == cola.tail));
        }
        System.out.println("peek(): " + cola.peek());
        System.out.println("contains(20): " + cola.contains(20));
        System.out.println("contains(99): " + cola.contains(99));
        cola.enqueue(40);
        System.out.println("enqueue(40)");
        mostrar(cola);
        while (!cola.isEmpty()) {
            System.out.println("dequeue(): " + cola.dequeue());
            mostrar(cola);
        }
        try { cola.dequeue(); }
        catch (IllegalStateException e) { System.out.println("dequeue(): " + e.getMessage()); }
        try { cola.peek(); }
        catch (IllegalStateException e) { System.out.println("peek(): " + e.getMessage()); }
        mostrar(cola);
        cola.enqueue(50);
        System.out.println("enqueue(50) despues de vaciar:");
        mostrar(cola);
        cola.enqueue(60);
        mostrar(cola);
        while (!cola.isEmpty()) {
            System.out.println("dequeue(): " + cola.dequeue());
            mostrar(cola);
        }
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

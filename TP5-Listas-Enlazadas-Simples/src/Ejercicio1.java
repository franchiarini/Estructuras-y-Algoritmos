/*
Implementá en Java una lista enlazada simple de números enteros desde cero, utilizando nodos conectados mediante referencias y sin emplear colecciones predefinidas de Java.

**Estructura elegida:** lista enlazada simple, formada por objetos `Nodo` que almacenan un entero y una referencia al siguiente nodo.

**Estrategia:** implementar una clase `Nodo` con los atributos `dato` y `siguiente`, y una clase `ListaEnlazada` con los atributos `head` y `size`. Utilizar `head` para acceder al primer nodo y recorrer la lista mediante referencias `siguiente`, hasta llegar a `null`.

**Justificación:** una lista enlazada simple permite almacenar elementos dinámicamente sin utilizar un arreglo de tamaño fijo. Cada nodo conoce al siguiente y los elementos pueden incorporarse modificando referencias. La lista no permite acceso directo por índice, por lo que determinadas operaciones requieren un recorrido secuencial.

**Representación de los nodos:**
- Cada nodo debe almacenar un atributo `int dato`.
- Cada nodo debe almacenar una referencia `Nodo siguiente`.
- Al crear un nodo, su referencia `siguiente` debe inicializarse en `null`.
- El último nodo de la lista siempre debe tener `siguiente == null`.

**Representación de la lista:**
- Utilizar una referencia `head` al primer nodo.
- Utilizar un atributo `size` para almacenar la cantidad de elementos.
- Inicializar `head = null` y `size = 0`.
- La lista estará vacía cuando `head == null`.
- Mantener la relación entre la cantidad de nodos alcanzables desde `head` y el atributo `size`.
- Utilizar solamente `head` y `size` como atributos de control; no agregar una referencia `tail` en esta implementación básica.

**Operaciones requeridas:**

1. `insertarAlInicio(int dato)`:
   - Crear un nuevo nodo.
   - Hacer que el nuevo nodo apunte al nodo actualmente referenciado por `head`.
   - Actualizar `head` para que apunte al nuevo nodo.
   - Incrementar `size` exactamente una vez.
   - Explicar por qué es importante actualizar las referencias en ese orden.

2. `insertarAlFinal(int dato)`:
   - Crear un nuevo nodo.
   - Si la lista está vacía, asignarlo directamente a `head`.
   - Si no está vacía, recorrer desde `head` hasta encontrar el último nodo.
   - Conectar el último nodo con el nuevo.
   - Incrementar `size` exactamente una vez.

3. `imprimir()`:
   - Recorrer la lista comenzando desde `head`.
   - Mostrar el dato de cada nodo seguido de `->`.
   - Terminar siempre con `null`.
   - Para una lista vacía, mostrar solamente `null`.
   - No modificar las referencias ni el tamaño durante el recorrido.

4. `estaVacia()`:
   - Devolver `true` cuando `head == null`.
   - Devolver `false` cuando exista al menos un nodo.

5. `getSize()`:
   - Devolver el valor del atributo `size`.
   - No recorrer la lista para calcular la cantidad de elementos.

**Orden correcto de las referencias:**

Al insertar al inicio debe realizarse primero:

`nuevo.setSiguiente(head);`

Y después:

`head = nuevo;`

Si se modifica primero `head`, se puede perder la referencia al comienzo original de la lista, dejando nodos inaccesibles.

**Complejidad:**
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque debe recorrerse la lista cuando no está vacía.
- `imprimir`: O(n).
- `estaVacia`: O(1).
- `getSize`: O(1).
- Espacio total de almacenamiento: O(n), correspondiente a los nodos.
- Espacio auxiliar de las operaciones: O(1), sin contar el nuevo nodo creado al insertar.

**Requisitos de implementación:**
- Crear `src/Ejercicio1.java` dentro de la carpeta real del TP5.
- Implementar una clase pública `Ejercicio1` con método `main`.
- Implementar las clases auxiliares `Nodo` y `ListaEnlazada`, preferentemente como clases estáticas anidadas dentro de `Ejercicio1`, evitando conflictos con los demás ejercicios.
- Utilizar referencias entre objetos para construir la lista.
- Mantener privados los atributos `dato`, `siguiente`, `head` y `size`.
- Incorporar los constructores y métodos de acceso necesarios.
- No utilizar arreglos como almacenamiento de la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue` ni colecciones predefinidas para implementar la estructura.
- No utilizar métodos de ordenamiento o estructuras auxiliares que sustituyan el recorrido enlazado.
- Incluir comentarios que expliquen qué es un nodo, qué representa `head`, cómo se conectan las referencias y cómo se administra `size`.
- Cada operación debe mantener la lista correctamente enlazada y terminar en `null`.
- No depender de clases de otros ejercicios.

**Ejemplo principal:**

1. Crear una lista vacía.
2. Verificar que `estaVacia()` devuelva `true` y `getSize()` devuelva 0.
3. Ejecutar `insertarAlInicio(30)`.
4. Ejecutar `insertarAlInicio(20)`.
5. Ejecutar `insertarAlInicio(10)`.
6. Mostrar la lista: `10 -> 20 -> 30 -> null`.
7. Verificar que el tamaño sea 3.
8. Ejecutar `insertarAlFinal(40)`.
9. Mostrar la lista: `10 -> 20 -> 30 -> 40 -> null`.
10. Ejecutar `insertarAlFinal(50)`.
11. Mostrar la lista: `10 -> 20 -> 30 -> 40 -> 50 -> null`.
12. Verificar que el tamaño sea 5 y `estaVacia()` devuelva `false`.

**Pruebas adicionales:**
- Lista recién creada y vacía.
- Insertar al inicio de una lista vacía.
- Insertar al final de una lista vacía.
- Insertar al inicio y al final de una lista con un solo elemento.
- Alternar inserciones al inicio y al final.
- Insertar números negativos.
- Insertar el valor cero.
- Insertar números repetidos.
- Insertar `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que el tamaño aumenta exactamente una unidad por inserción.
- Verificar que imprimir no altera la lista.
- Comprobar que el orden de los elementos es el esperado.
- Verificar que todos los nodos sean alcanzables desde `head`.
- Verificar que el último nodo apunta a `null` y que no se generan ciclos.

Compilar individualmente y ejecutar con Java 21, `--release 21` y `-Xlint:all`, sin advertencias. Realizar pruebas reales, informando los resultados obtenidos.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio1 {
    public static class Nodo {
        private final int dato;
        private Nodo siguiente;

        public Nodo(int dato) {
            this.dato = dato;
            siguiente = null;
        }
        public int getDato() { return dato; }
        public Nodo getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
    }

    public static class ListaEnlazada {
        private Nodo head = null; // Punto de entrada a todos los nodos de la lista.
        private int size = 0;

        public void insertarAlInicio(int dato) {
            Nodo nuevo = new Nodo(dato);
            // Conectar primero con el comienzo anterior para no perder sus nodos.
            nuevo.setSiguiente(head);
            head = nuevo;
            size++;
        }
        public void insertarAlFinal(int dato) {
            Nodo nuevo = new Nodo(dato);
            if (estaVacia()) {
                head = nuevo;
            } else {
                // Sin tail: seguir las referencias hasta el ultimo nodo.
                Nodo actual = head;
                while (actual.getSiguiente() != null) {
                    actual = actual.getSiguiente();
                }
                actual.setSiguiente(nuevo);
            }
            size++; // Una sola actualizacion, tanto en lista vacia como no vacia.
        }
        public void imprimir() {
            Nodo actual = head;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente(); // Cambia la referencia local, no los enlaces.
            }
            System.out.println("null");
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        System.out.println("Vacia: " + lista.estaVacia() + ", size = " + lista.getSize());
        lista.imprimir();
        lista.insertarAlInicio(30);
        lista.insertarAlInicio(20);
        lista.insertarAlInicio(10);
        lista.imprimir();
        System.out.println("size = " + lista.getSize());
        lista.insertarAlFinal(40);
        lista.imprimir();
        lista.insertarAlFinal(50);
        lista.imprimir();
        System.out.println("Vacia: " + lista.estaVacia() + ", size = " + lista.getSize());
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

/*
Implementá en Java un programa que permita buscar un número entero dentro de una lista enlazada simple, mediante el método `boolean buscar(int dato)`.

**Estructura elegida:** lista enlazada simple de enteros, formada por nodos conectados mediante referencias, con acceso desde `head`.

**Estrategia:** construir una lista enlazada manualmente, reutilizando conceptualmente la implementación desarrollada en el Ejercicio 1, pero manteniendo este ejercicio independiente. Incorporar un método `buscar(int dato)` que recorra secuencialmente los nodos desde `head`, comparando sus datos hasta encontrar el valor solicitado o llegar al final de la lista.

**Justificación:** a diferencia de un arreglo, una lista enlazada no permite acceder directamente a un elemento mediante un índice. Cada nodo almacena solamente su dato y una referencia al siguiente. Por eso, para buscar un valor debemos comenzar desde `head` y avanzar mediante las referencias `siguiente`, nodo por nodo.

**Estructura de clases:**
- `Nodo`: representa cada elemento de la lista, con los atributos `int dato` y `Nodo siguiente`.
- `ListaEnlazada`: administra la referencia `head`, el contador `size` y las operaciones sobre los nodos.
- `Ejercicio2`: clase pública con método `main` para demostrar la búsqueda y ejecutar las pruebas.

**Método principal:**

`boolean buscar(int dato)`

Su funcionamiento debe seguir estos pasos:

1. Crear una referencia auxiliar `actual` que inicialmente apunte a `head`.
2. Mientras `actual != null`, examinar el dato del nodo actual.
3. Si `actual.getDato() == dato`, devolver `true` inmediatamente.
4. Si no coincide, avanzar mediante `actual = actual.getSiguiente()`.
5. Si el recorrido llega a `null` sin encontrar el valor, devolver `false`.

**Manejo de referencias:**
- El recorrido debe comenzar siempre desde `head`.
- `actual` es una referencia auxiliar que permite desplazarse entre los nodos.
- No modificar `head` mientras se realiza la búsqueda.
- No modificar el atributo `siguiente` de ningún nodo.
- No cambiar los datos almacenados.
- No incrementar ni disminuir `size`.
- No crear ni eliminar nodos durante la búsqueda.
- Asegurar que `actual` avance en cada iteración para evitar ciclos infinitos.

**Operaciones auxiliares necesarias:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deberán seguir la lógica del Ejercicio 1 y servir para construir y verificar las listas utilizadas en las pruebas.

**Casos especiales:**
- Lista vacía: `buscar()` debe devolver `false`.
- Dato en el primer nodo: devolver `true` inmediatamente.
- Dato en un nodo intermedio: continuar el recorrido hasta encontrarlo.
- Dato en el último nodo: devolver `true`.
- Dato inexistente: recorrer hasta `null` y devolver `false`.
- Valores repetidos: devolver `true` cuando se encuentra la primera coincidencia.
- Permitir números negativos, cero y extremos de `int`.
- Buscar no debe modificar el estado de la lista.

**Complejidad:**
- Mejor caso de `buscar`: O(1), cuando el primer nodo contiene el dato.
- Peor caso de `buscar`: O(n), cuando el elemento está al final o no existe.
- Complejidad espacial auxiliar de `buscar`: O(1), porque solamente utiliza una referencia auxiliar.
- La lista completa requiere O(n) de espacio para almacenar sus nodos.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n) en esta implementación sin referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio2.java`.
- Implementar una clase pública `Ejercicio2` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` como clases auxiliares estáticas anidadas dentro de `Ejercicio2`, para evitar conflictos con las clases del Ejercicio 1.
- Implementar manualmente la estructura mediante referencias entre nodos.
- Mantener privados los atributos `dato`, `siguiente`, `head` y `size`.
- No utilizar arreglos ni colecciones predefinidas para almacenar o buscar los elementos de la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `HashSet`, `Map`, `Stream` ni otras estructuras que sustituyan el recorrido secuencial.
- No depender de las clases de otros ejercicios.
- Incluir comentarios que expliquen por qué la búsqueda no permite acceso directo por índice, cómo se utiliza la referencia `actual` y por qué se termina al llegar a `null`.
- Mantener el tamaño y los enlaces correctos.
- Mostrar resultados claros en consola.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`.
4. Ejecutar `buscar(10)` y verificar que devuelve `true`.
5. Ejecutar `buscar(30)` y verificar que devuelve `true`.
6. Ejecutar `buscar(50)` y verificar que devuelve `true`.
7. Ejecutar `buscar(99)` y verificar que devuelve `false`.
8. Ejecutar `buscar(-5)` y verificar que devuelve `false`.
9. Comprobar que la lista continúa conteniendo los mismos cinco nodos, en el mismo orden y con `size = 5`.

**Pruebas adicionales:**
- Buscar en una lista vacía.
- Buscar el único elemento de una lista de tamaño 1.
- Buscar un valor inexistente en una lista de tamaño 1.
- Buscar el primer nodo.
- Buscar un nodo intermedio.
- Buscar el último nodo.
- Buscar un elemento inexistente.
- Buscar valores repetidos.
- Buscar números negativos.
- Buscar el valor cero.
- Buscar `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Ejecutar múltiples búsquedas consecutivas.
- Comprobar que las búsquedas no modifican `head`.
- Comprobar que las búsquedas no modifican `size`.
- Comprobar que las búsquedas no alteran los enlaces ni los datos de los nodos.
- Comprobar que el recorrido termina correctamente en `null`.
- Verificar que no se generan ciclos.

Compilar con Java 21, `--release 21` y `-Xlint:all`, y ejecutar pruebas reales que permitan verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio2 {
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
        public boolean buscar(int dato) {
            // Sin acceso directo por indice: seguir los enlaces desde head.
            Nodo actual = head;
            while (actual != null) {
                if (actual.getDato() == dato) return true; // Primera coincidencia.
                actual = actual.getSiguiente(); // Solo avanza la referencia local.
            }
            // null indica que no quedan nodos por examinar.
            return false;
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 30, 40, 50}) lista.insertarAlFinal(dato);
        lista.imprimir();
        for (int dato : new int[]{10, 30, 50, 99, -5}) {
            System.out.println("buscar(" + dato + "): " + lista.buscar(dato));
        }
        System.out.println("Lista despues de buscar, size = " + lista.getSize() + ":");
        lista.imprimir();
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

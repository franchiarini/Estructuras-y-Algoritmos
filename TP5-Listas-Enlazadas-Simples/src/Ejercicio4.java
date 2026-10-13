/*
Implementá en Java un programa que permita insertar un nuevo nodo en una posición específica de una lista enlazada simple de enteros, utilizando el método `void insertarEnPosicion(int dato, int posicion)`.

**Estructura elegida:** lista enlazada simple formada por nodos que almacenan un entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, administrada mediante una referencia `head` y un atributo `size`. Para insertar en una posición, validar primero el índice, encontrar el nodo anterior cuando corresponda y modificar las referencias en el orden correcto, sin perder ninguno de los nodos existentes.

**Justificación:** en una lista enlazada simple, insertar un elemento no requiere desplazar físicamente los datos como en un arreglo. En su lugar, se crea un nuevo nodo y se modifican las referencias entre los nodos. Sin embargo, es fundamental preservar los enlaces existentes y actualizarlos en el orden adecuado para evitar perder parte de la lista o generar ciclos.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: contiene `head`, `size` y las operaciones de la lista.
- `Ejercicio4`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Método principal:**

`void insertarEnPosicion(int dato, int posicion)`

Debe permitir:
- Insertar al inicio de la lista.
- Insertar en una posición intermedia.
- Insertar al final de la lista.
- Insertar en una lista vacía cuando `posicion == 0`.

**Validación de posiciones:**
- Aceptar posiciones comprendidas entre 0 y `size`, inclusive.
- Rechazar `posicion < 0`.
- Rechazar `posicion > size`.
- Utilizar `IndexOutOfBoundsException` para informar posiciones inválidas.
- Validar la posición antes de crear el nodo o modificar referencias.
- Ante una posición inválida, conservar exactamente el estado previo de la lista.

**Inserción al inicio:**
1. Si `posicion == 0`, crear el nuevo nodo.
2. Hacer que el nuevo nodo apunte a `head`.
3. Actualizar `head` para que apunte al nuevo nodo.
4. Incrementar `size` una única vez.
5. No recorrer la lista.

La secuencia correcta es:

`nuevo.setSiguiente(head);`

`head = nuevo;`

Este orden conserva la referencia al primer nodo original.

**Inserción en el medio o al final:**
1. Si `posicion > 0`, comenzar desde `head`.
2. Recorrer hasta alcanzar el nodo ubicado en `posicion - 1`.
3. Crear un nuevo nodo para almacenar `dato`.
4. Hacer que el nuevo nodo apunte al que actualmente sigue al nodo anterior.
5. Hacer que el nodo anterior apunte al nuevo.
6. Incrementar `size` una única vez.

Las instrucciones centrales deben ejecutarse exactamente en este orden:

`nuevo.setSiguiente(actual.getSiguiente());`

`actual.setSiguiente(nuevo);`

Primero se preserva el enlace hacia la parte restante de la lista. Después se conecta el nodo nuevo al anterior.

Si se invierte el orden y se recupera después `actual.getSiguiente()`, esa referencia ya puede apuntar al nodo nuevo, generando un enlace incorrecto, un ciclo o la pérdida de acceso al resto de la lista.

**Inserción al final:**
- Se permite `posicion == size`.
- El recorrido llega al último nodo existente.
- Como su siguiente es `null`, el nuevo nodo debe quedar con `siguiente == null`.
- El último nodo original debe apuntar al nuevo.
- Si la lista está vacía, insertar en la posición 0 equivale a insertar al inicio.

**Manejo de referencias:**
- Mantener siempre accesibles todos los nodos desde `head`.
- No sobrescribir referencias antes de preservar el enlace siguiente.
- No generar ciclos.
- No eliminar ni modificar datos de los nodos existentes.
- Actualizar `head` únicamente cuando la inserción se realiza en la posición 0.
- Mantener el último nodo enlazado con `null`.
- Actualizar `size` exactamente una vez después de cada inserción válida.
- Utilizar una referencia auxiliar de recorrido, sin modificar `head` durante el recorrido.
- Evitar realizar recorridos innecesarios.

**Operaciones auxiliares necesarias:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deberán seguir la lógica de los ejercicios anteriores y permitir construir las listas utilizadas en las pruebas. Se puede reutilizar internamente `insertarAlInicio` en el caso de posición 0, siempre que no se incremente dos veces `size`.

**Casos especiales:**
- Lista vacía con posición 0: inserción válida.
- Lista vacía con otra posición: inserción inválida.
- Lista de un elemento: inserción antes o después del único nodo.
- Inserción en la primera posición de una lista con varios nodos.
- Inserción entre dos nodos existentes.
- Inserción en la última posición permitida (`posicion == size`).
- Posiciones negativas.
- Posiciones mayores que `size`.
- Valores repetidos.
- Números negativos, cero y extremos de `int`.
- Verificar que una posición inválida no altere los nodos, enlaces, `head` ni `size`.

**Complejidad:**
- Validación de posición: O(1).
- Inserción en posición 0: O(1).
- Inserción en posición intermedia: O(n) en el peor caso, por el recorrido.
- Inserción en posición `size`: O(n), porque la lista no mantiene una referencia `tail`.
- Creación del nodo y actualización de sus enlaces: O(1).
- Espacio auxiliar de la operación: O(1), sin contar el nuevo nodo.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n).
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio4.java`.
- Implementar una clase pública `Ejercicio4` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio4`, para evitar conflictos de nombres con los ejercicios anteriores.
- Implementar manualmente la lista mediante nodos y referencias.
- Mantener privados los atributos internos de las clases auxiliares.
- Utilizar solamente `head` y `size` como atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue` ni estructuras equivalentes.
- No utilizar conversiones a arreglos ni `Stream` para implementar la inserción.
- No depender de clases de otros ejercicios.
- Incluir comentarios que expliquen el orden de modificación de las referencias y qué ocurriría si se invirtiera.
- Mostrar claramente el contenido de la lista antes y después de cada inserción importante.
- Verificar que `size` coincida con la cantidad real de nodos.
- Verificar que la lista termine en `null` y no contenga ciclos.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Ejecutar `insertarAlFinal(10)`.
3. Ejecutar `insertarAlFinal(20)`.
4. Ejecutar `insertarAlFinal(30)`.
5. Mostrar `10 -> 20 -> 30 -> null`, con `size = 3`.
6. Ejecutar `insertarEnPosicion(15, 1)`.
7. Verificar `10 -> 15 -> 20 -> 30 -> null`, con `size = 4`.
8. Ejecutar `insertarEnPosicion(5, 0)`.
9. Verificar `5 -> 10 -> 15 -> 20 -> 30 -> null`, con `size = 5`.
10. Ejecutar `insertarEnPosicion(40, 5)`.
11. Verificar `5 -> 10 -> 15 -> 20 -> 30 -> 40 -> null`, con `size = 6`.
12. Intentar `insertarEnPosicion(99, -1)` y verificar `IndexOutOfBoundsException`.
13. Intentar `insertarEnPosicion(99, 7)` y verificar `IndexOutOfBoundsException`.
14. Comprobar que las inserciones inválidas conservaron el contenido, `head`, `size` y todos los enlaces.

**Pruebas adicionales:**
- Inserción en una lista vacía.
- Rechazo de posiciones inválidas en una lista vacía.
- Inserción al inicio de una lista de un nodo.
- Inserción al final de una lista de un nodo.
- Inserción al principio de una lista con varios nodos.
- Inserción en posiciones intermedias.
- Inserción exactamente en `size`.
- Rechazo de posiciones negativas.
- Rechazo de posiciones mayores que `size`.
- Inserciones consecutivas en la misma posición.
- Inserciones alternadas al inicio, medio y final.
- Valores duplicados.
- Valores negativos.
- Valor cero.
- `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que cada inserción válida incrementa `size` exactamente una vez.
- Comprobar que las inserciones inválidas no alteran el estado.
- Comprobar que el primer nodo sigue siendo alcanzable desde `head`.
- Comprobar que todos los nodos originales permanecen en orden relativo después de la inserción.
- Comprobar que el nodo nuevo aparece exactamente en la posición solicitada.
- Verificar que el último nodo apunte a `null`.
- Verificar que no se generan ciclos ni nodos inaccesibles.
- Comprobar que imprimir no modifica la lista.

Compilar individualmente y conjuntamente con los ejercicios 1, 2 y 3 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio4 {
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
        public void insertarEnPosicion(int dato, int posicion) {
            // Validar antes de crear nodos o modificar enlaces.
            if (posicion < 0 || posicion > size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
            if (posicion == 0) {
                insertarAlInicio(dato); // Incrementa size una vez y no recorre.
                return;
            }
            Nodo actual = head;
            for (int i = 0; i < posicion - 1; i++) actual = actual.getSiguiente();
            Nodo nuevo = new Nodo(dato);
            // Preservar primero el resto: invertir estas instrucciones podria crear un ciclo.
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
            size++;
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 30}) lista.insertarAlFinal(dato);
        mostrar(lista);
        System.out.println("insertarEnPosicion(15, 1)");
        lista.insertarEnPosicion(15, 1);
        mostrar(lista);
        System.out.println("insertarEnPosicion(5, 0)");
        lista.insertarEnPosicion(5, 0);
        mostrar(lista);
        System.out.println("insertarEnPosicion(40, 5)");
        lista.insertarEnPosicion(40, 5);
        mostrar(lista);
        for (int posicion : new int[]{-1, 7}) {
            try {
                lista.insertarEnPosicion(99, posicion);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException: " + e.getMessage());
            }
            mostrar(lista);
        }
    }

    private static void mostrar(ListaEnlazada lista) {
        lista.imprimir();
        System.out.println("size = " + lista.getSize());
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

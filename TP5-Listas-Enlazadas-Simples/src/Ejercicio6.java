/*
Implementá en Java un programa que permita eliminar el nodo ubicado en una posición específica de una lista enlazada simple de enteros, utilizando el método `void eliminarEnPosicion(int posicion)`.

**Estructura elegida:** lista enlazada simple formada por nodos que contienen un entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, administrada mediante los atributos `head` y `size`. Para eliminar un nodo por posición, validar primero el índice solicitado. Si corresponde al primer nodo, actualizar directamente `head`. En los demás casos, recorrer desde `head` hasta alcanzar el nodo anterior al que se desea eliminar y modificar su enlace para que apunte al nodo siguiente del eliminado.

**Justificación:** una lista enlazada simple no permite acceder directamente a una posición mediante un índice, como ocurre con un arreglo. Para eliminar un nodo que no está al inicio, primero es necesario encontrar su nodo anterior mediante recorrido secuencial. La eliminación consiste en modificar referencias, sin desplazar datos ni reconstruir la lista.

**Estructura de clases:**
- `Nodo`: contiene `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones sobre los nodos.
- `Ejercicio6`: clase pública con método `main` para demostrar el funcionamiento y ejecutar pruebas.

**Método principal:**

`void eliminarEnPosicion(int posicion)`

Debe eliminar exactamente un nodo de la posición indicada, considerando que las posiciones comienzan en 0.

**Validación de posiciones:**
- La primera posición válida es 0.
- La última posición válida es `size - 1`.
- Rechazar cualquier `posicion < 0`.
- Rechazar cualquier `posicion >= size`.
- En una lista vacía no existe ninguna posición válida.
- Utilizar `IndexOutOfBoundsException` para los índices inválidos.
- Validar antes de modificar `head`, enlaces o `size`.
- Toda operación inválida debe conservar íntegramente el estado anterior.

**Caso 1 — Eliminar el primer nodo:**
1. Si `posicion == 0`, identificar el nodo actual de `head`.
2. Hacer que `head` apunte al siguiente nodo.
3. Disminuir `size` exactamente una vez.
4. Terminar la operación sin recorrer el resto de la lista.

La instrucción principal es:

`head = head.getSiguiente();`

Si la lista contiene un solo elemento, `head` deberá quedar en `null` y `size` en 0.

**Caso 2 — Eliminar un nodo intermedio o final:**
1. Crear una referencia auxiliar `actual` que apunte inicialmente a `head`.
2. Recorrer hasta encontrar el nodo ubicado en `posicion - 1`.
3. Identificar mediante `actual.getSiguiente()` el nodo que se eliminará.
4. Hacer que el nodo anterior apunte directamente al sucesor del nodo eliminado.
5. Disminuir `size` exactamente una vez.
6. Terminar la operación conservando todos los demás nodos.

La instrucción principal es:

`actual.setSiguiente(actual.getSiguiente().getSiguiente());`

Esta operación saltea al nodo eliminado. Si era el último, la referencia del nodo anterior quedará en `null`.

**Orden de actualización de referencias:**
- Primero localizar el nodo anterior.
- Identificar el nodo que se quiere eliminar y su sucesor.
- Preservar el acceso al sucesor antes de modificar o descartar referencias.
- Actualizar el enlace del nodo anterior para saltear al eliminado.
- No modificar los datos de los nodos restantes.
- No reconstruir la lista mediante nuevas copias de nodos.
- Mantener el orden relativo de los elementos conservados.
- No generar ciclos ni perder nodos que deban continuar en la lista.
- Actualizar `head` solamente cuando se elimina la posición 0.

**Gestión de memoria en Java:**
- Explicar que eliminar un nodo consiste en desvincularlo de la lista.
- El nodo eliminado podrá ser recuperado posteriormente por el Garbage Collector cuando ya no existan referencias que lo hagan alcanzable.
- No utilizar liberación manual de memoria.
- No afirmar que la recolección ocurre inmediatamente.

**Manejo del atributo `size`:**
- Disminuirlo exactamente una vez después de una eliminación válida.
- No modificarlo ante posiciones inválidas.
- Asegurar que coincida con la cantidad de nodos alcanzables desde `head`.
- Cuando se elimina el único nodo, dejar `size = 0` y `head = null`.
- Evitar decrementos duplicados si se reutiliza un método auxiliar de eliminación al inicio.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben respetar la implementación básica de listas enlazadas de los ejercicios anteriores y permitir construir escenarios de prueba.

**Casos especiales:**
- Lista vacía: rechazar cualquier posición.
- Lista de un solo nodo: permitir únicamente posición 0.
- Eliminar el primer nodo de una lista con varios elementos.
- Eliminar un nodo intermedio.
- Eliminar el último nodo.
- Eliminar nodos consecutivos en operaciones sucesivas.
- Eliminar de manera repetida la posición 0 hasta vaciar la lista.
- Elementos repetidos: eliminar exclusivamente el nodo de la posición indicada, no todos los que tengan el mismo valor.
- Valores negativos, cero y extremos de `int`.
- Posiciones negativas.
- Posición igual a `size`.
- Posición mayor que `size`.
- Posiciones extremadamente grandes, como `Integer.MAX_VALUE`.
- Verificar que los intentos inválidos no alteren `head`, `size`, datos o enlaces.

**Complejidad:**
- Validación de posición: O(1), utilizando `size`.
- Eliminación en posición 0: O(1).
- Eliminación de un nodo intermedio: O(n) en el peor caso.
- Eliminación del último nodo: O(n).
- Cambio de enlaces una vez localizado el nodo anterior: O(1).
- Espacio auxiliar del método: O(1), utilizando referencias auxiliares.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque la implementación no mantiene una referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio6.java`.
- Implementar una clase pública `Ejercicio6` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio6`, para evitar conflictos de nombres con los ejercicios anteriores.
- Implementar manualmente la lista mediante referencias entre nodos.
- Mantener privados los atributos internos.
- Mantener `head` y `size` como únicos atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para resolver el ejercicio.
- No utilizar `Stream` ni conversiones a arreglos.
- No depender de clases implementadas en los ejercicios anteriores.
- Incorporar comentarios que expliquen la validación del índice, el recorrido hasta el nodo anterior, la actualización de referencias y el comportamiento del Garbage Collector.
- Mostrar los estados de la lista antes y después de las eliminaciones relevantes.
- Verificar que la lista termine en `null` y no tenga ciclos.
- Verificar que el tamaño coincida con los nodos realmente almacenados.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`, con `size = 5`.
4. Ejecutar `eliminarEnPosicion(2)`.
5. Verificar `10 -> 20 -> 40 -> 50 -> null`, con `size = 4`.
6. Ejecutar `eliminarEnPosicion(0)`.
7. Verificar `20 -> 40 -> 50 -> null`, con `size = 3`.
8. Ejecutar `eliminarEnPosicion(2)`.
9. Verificar `20 -> 40 -> null`, con `size = 2`.
10. Intentar `eliminarEnPosicion(-1)` y comprobar `IndexOutOfBoundsException`.
11. Intentar `eliminarEnPosicion(2)` y comprobar `IndexOutOfBoundsException`.
12. Verificar que las operaciones inválidas conservaron `20 -> 40 -> null`, con `size = 2`.
13. Ejecutar `eliminarEnPosicion(0)` y comprobar `40 -> null`, con `size = 1`.
14. Ejecutar nuevamente `eliminarEnPosicion(0)` y comprobar que la lista queda vacía, con `head = null` y `size = 0`.
15. Intentar `eliminarEnPosicion(0)` sobre la lista vacía y comprobar que lanza `IndexOutOfBoundsException`.

**Ejemplo adicional con valores repetidos:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `eliminarEnPosicion(2)`.
3. Verificar `10 -> 20 -> 30 -> 10 -> null`.
4. Comprobar que se eliminó solamente el segundo nodo que contenía 10 y que los demás nodos conservaron su identidad y orden.
5. Verificar que `size` disminuyó de 5 a 4.

**Pruebas adicionales:**
- Intentar eliminar en una lista vacía.
- Eliminar el único nodo de una lista.
- Rechazar posición 1 de una lista de un nodo.
- Eliminar la primera posición.
- Eliminar una posición intermedia.
- Eliminar la última posición.
- Eliminar sucesivamente todos los nodos.
- Eliminar posiciones distintas en una misma lista.
- Eliminar la posición correspondiente a un dato repetido.
- Comprobar que los duplicados restantes no se modifican.
- Rechazar posiciones negativas.
- Rechazar posiciones iguales o superiores a `size`.
- Rechazar `Integer.MIN_VALUE` e `Integer.MAX_VALUE` como posiciones.
- Comprobar que `head` cambia solamente al eliminar la primera posición.
- Comprobar que el tamaño disminuye exactamente una unidad por eliminación válida.
- Verificar que las excepciones no modifican el estado.
- Verificar que se preserva la identidad de todos los nodos restantes.
- Verificar que ningún dato restante se modifica.
- Verificar que el último nodo apunta a `null`.
- Verificar que no se generan ciclos.
- Comprobar que no quedan nodos inaccesibles que deberían permanecer.
- Alternar inserciones al inicio o al final con eliminaciones por posición.
- Comprobar que imprimir no modifica la lista.

Compilar individualmente y conjuntamente con los ejercicios 1 al 5 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio6 {
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
        public void eliminarEnPosicion(int posicion) {
            // Validar antes de modificar cualquier referencia o el contador.
            if (posicion < 0 || posicion >= size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
            if (posicion == 0) {
                head = head.getSiguiente(); // El primero no tiene nodo anterior.
            } else {
                Nodo actual = head;
                for (int i = 0; i < posicion - 1; i++) actual = actual.getSiguiente();
                // Obtener el sucesor antes de cambiar el enlace conserva el resto.
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            }
            size--; // Exactamente una vez por eliminacion valida.
        }
        // Desvincular no libera memoria manualmente: sin referencias que lo hagan
        // alcanzable, el nodo puede ser recuperado posteriormente por el Garbage Collector.
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    private static void mostrar(ListaEnlazada lista) {
        lista.imprimir();
        System.out.println("size = " + lista.getSize());
    }
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 30, 40, 50}) lista.insertarAlFinal(dato);
        mostrar(lista);
        for (int posicion : new int[]{2, 0, 2, -1, 2, 0, 0, 0}) {
            System.out.println("eliminarEnPosicion(" + posicion + ")");
            try {
                lista.eliminarEnPosicion(posicion);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException: " + e.getMessage());
            }
            mostrar(lista);
        }
        System.out.println("Ejemplo con duplicados:");
        ListaEnlazada duplicados = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 10, 30, 10}) duplicados.insertarAlFinal(dato);
        mostrar(duplicados);
        duplicados.eliminarEnPosicion(2);
        mostrar(duplicados);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

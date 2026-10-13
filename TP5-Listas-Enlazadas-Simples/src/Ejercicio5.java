/*
Implementá en Java un programa que permita eliminar la primera aparición de un valor entero en una lista enlazada simple, utilizando el método `boolean eliminar(int dato)`.

**Estructura elegida:** lista enlazada simple formada por nodos con un dato entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada con las clases `Nodo` y `ListaEnlazada`, utilizando `head` como referencia al primer nodo y `size` como contador de elementos. Para eliminar un valor, recorrer la lista hasta localizar su primera aparición y actualizar las referencias para que ese nodo deje de formar parte de la cadena.

**Justificación:** en una lista enlazada simple, eliminar un elemento no requiere desplazar datos como ocurre con un arreglo. La eliminación se realiza modificando los enlaces entre nodos. Es fundamental conservar la referencia al nodo siguiente del eliminado para no perder el acceso al resto de la lista.

**Estructura de clases:**
- `Nodo`: contiene `int dato` y `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones de la estructura.
- `Ejercicio5`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Método principal:**

`boolean eliminar(int dato)`

Debe eliminar únicamente la primera aparición del valor solicitado y devolver:
- `true` si encontró y eliminó un nodo.
- `false` si la lista estaba vacía o el valor no estaba presente.

**Caso 1 — Lista vacía:**
1. Verificar si `head == null`.
2. Si la lista está vacía, devolver `false`.
3. No modificar `head` ni `size`.

**Caso 2 — Eliminar el primer nodo:**
1. Verificar si `head.getDato() == dato`.
2. Actualizar `head` para que apunte al siguiente nodo.
3. Disminuir `size` exactamente una vez.
4. Devolver `true`.

La actualización principal es:

`head = head.getSiguiente();`

Esta operación debe funcionar tanto para una lista de varios elementos como para una lista que contiene un único nodo.

**Caso 3 — Eliminar un nodo intermedio o final:**
1. Crear una referencia auxiliar `actual` que comience en `head`.
2. Mientras `actual.getSiguiente() != null`, examinar el dato del nodo siguiente.
3. Si el nodo siguiente contiene el valor buscado, modificar el enlace de `actual` para que apunte directamente al sucesor del nodo eliminado.
4. Disminuir `size` exactamente una vez.
5. Devolver `true` inmediatamente, para eliminar solo la primera aparición.
6. Si el siguiente nodo no coincide, avanzar `actual` al próximo nodo.
7. Si se llega al final sin encontrar el valor, devolver `false`.

La actualización fundamental de referencias es:

`actual.setSiguiente(actual.getSiguiente().getSiguiente());`

Esta operación permite saltear el nodo que se quiere eliminar, conservando el enlace hacia el resto de la lista.

**Orden de actualización de referencias:**
- Localizar correctamente el nodo anterior al que se desea eliminar.
- Conservar la referencia hacia el sucesor del nodo eliminado.
- Actualizar el enlace del nodo anterior.
- Evitar modificar o perder las referencias necesarias antes de completar la eliminación.
- No modificar los datos de otros nodos para simular la eliminación.
- No reconstruir toda la lista ni copiar sus elementos a otra estructura.
- Mantener siempre accesibles desde `head` todos los nodos que deben continuar en la lista.

**Garbage Collector:**
- Explicar que en Java no se libera manualmente la memoria de un nodo eliminado.
- Al dejar de ser alcanzable desde la lista y no conservar otras referencias hacia él, el nodo queda disponible para que el Garbage Collector recupere su memoria posteriormente.
- No afirmar que el Garbage Collector libera el nodo inmediatamente.
- No utilizar operaciones manuales de liberación de memoria.

**Manejo de `size`:**
- Disminuir `size` solamente cuando efectivamente se elimina un nodo.
- Disminuirlo exactamente una vez por eliminación exitosa.
- Mantenerlo sin cambios cuando el dato no existe.
- Si se elimina el último elemento, la lista debe quedar con `head == null` y `size == 0`.
- Después de cualquier operación, `size` debe coincidir con la cantidad de nodos alcanzables desde `head`.

**Casos especiales:**
- Lista vacía: devolver `false`.
- Lista de un solo nodo con el dato buscado: eliminarlo y dejar la lista vacía.
- Lista de un solo nodo con otro dato: devolver `false` y conservarlo.
- Eliminar el primer nodo de una lista con varios elementos.
- Eliminar un nodo intermedio.
- Eliminar el último nodo.
- Eliminar un valor inexistente.
- Valores repetidos: eliminar solamente la primera coincidencia.
- Eliminar varias veces consecutivas el mismo valor cuando existen duplicados.
- Permitir números negativos, cero y extremos de `int`.
- La búsqueda fallida no debe alterar la lista.
- La eliminación exitosa no debe cambiar los datos ni el orden relativo de los nodos restantes.
- No generar ciclos ni dejar nodos que deberían permanecer inaccesibles.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Las operaciones auxiliares deben respetar la implementación básica de los ejercicios anteriores y servir para construir los escenarios de prueba.

**Complejidad:**
- Eliminar en lista vacía: O(1).
- Eliminar el primer nodo: O(1).
- Eliminar un nodo intermedio: O(n) en el peor caso.
- Eliminar el último nodo: O(n).
- Buscar un valor inexistente: O(n).
- Actualizar los enlaces una vez localizado el nodo: O(1).
- Espacio auxiliar de `eliminar`: O(1), porque se utilizan referencias auxiliares.
- Espacio total de la lista: O(n), correspondiente a sus nodos.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza una referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio5.java`.
- Implementar una clase pública `Ejercicio5` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio5`, evitando conflictos con los ejercicios anteriores.
- Utilizar referencias entre nodos, sin arreglos ni colecciones predefinidas para almacenar la lista.
- Mantener privados los atributos internos.
- Mantener exclusivamente `head` y `size` como atributos de control, sin agregar `tail`.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para implementar la eliminación.
- No depender de las clases de otros ejercicios.
- No utilizar conversiones a arreglos ni `Stream` para resolver el problema.
- Incorporar comentarios que expliquen el tratamiento especial de `head`, la búsqueda del nodo anterior, la actualización de referencias y el papel del Garbage Collector.
- Mostrar el estado de la lista antes y después de las eliminaciones.
- Mantener correctamente el tamaño, los enlaces y la ausencia de ciclos.
- No modificar elementos ajenos al nodo eliminado.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`, con `size = 5`.
4. Ejecutar `eliminar(30)` y verificar que devuelve `true`.
5. Comprobar `10 -> 20 -> 40 -> 50 -> null`, con `size = 4`.
6. Ejecutar `eliminar(10)` y verificar que devuelve `true`.
7. Comprobar `20 -> 40 -> 50 -> null`, con `size = 3`.
8. Ejecutar `eliminar(50)` y verificar que devuelve `true`.
9. Comprobar `20 -> 40 -> null`, con `size = 2`.
10. Ejecutar `eliminar(99)` y verificar que devuelve `false`.
11. Comprobar que la lista permanece `20 -> 40 -> null`, con `size = 2`.
12. Ejecutar `eliminar(20)` y comprobar `40 -> null`, con `size = 1`.
13. Ejecutar `eliminar(40)` y comprobar `null`, con `size = 0`.
14. Ejecutar `eliminar(40)` sobre la lista vacía y verificar que devuelve `false`.

**Ejemplo adicional con duplicados:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `eliminar(10)`.
3. Verificar que devuelve `true`.
4. Comprobar `20 -> 10 -> 30 -> 10 -> null`, con `size = 4`.
5. Verificar que solamente desapareció la primera aparición.
6. Ejecutar nuevamente `eliminar(10)` y comprobar `20 -> 30 -> 10 -> null`, con `size = 3`.

**Pruebas adicionales:**
- Eliminar en una lista vacía.
- Eliminar el único nodo.
- No encontrar un dato en una lista de un nodo.
- Eliminar repetidamente el primer nodo.
- Eliminar nodos intermedios.
- Eliminar el último nodo.
- Eliminar un valor inexistente.
- Eliminar la primera aparición entre valores repetidos.
- Eliminar valores repetidos en posiciones consecutivas.
- Eliminar valores negativos.
- Eliminar el valor cero.
- Eliminar `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Alternar inserciones y eliminaciones.
- Comprobar que `head` se actualiza correctamente al eliminar el primer nodo.
- Comprobar que `head` no cambia al eliminar un nodo intermedio o final.
- Comprobar que cada eliminación exitosa decrementa `size` exactamente una vez.
- Comprobar que las eliminaciones fallidas no modifican `size`.
- Verificar que se preserva el orden relativo de los nodos restantes.
- Verificar que no se modifica el dato de los nodos conservados.
- Verificar que el último nodo apunte a `null`.
- Verificar que no se generan ciclos ni nodos perdidos.
- Verificar que imprimir no modifica la estructura.

Compilar individualmente y conjuntamente con los ejercicios 1 al 4 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio5 {
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
        public boolean eliminar(int dato) {
            if (head == null) return false;
            // El primer nodo no tiene anterior: actualizar head directamente.
            if (head.getDato() == dato) {
                head = head.getSiguiente();
                size--;
                return true;
            }
            Nodo actual = head;
            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getDato() == dato) {
                    // Saltear el nodo conservando el enlace hacia su sucesor.
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    size--;
                    return true; // Solo eliminar la primera coincidencia.
                }
                actual = actual.getSiguiente();
            }
            return false; // Sin coincidencias: conservar la lista y su tamanio.
        }
        // Java no libera nodos manualmente. Sin otras referencias, el nodo retirado
        // queda disponible para el Garbage Collector, que no actua necesariamente de inmediato.
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
        for (int dato : new int[]{30, 10, 50, 99, 20, 40, 40}) {
            System.out.println("eliminar(" + dato + "): " + lista.eliminar(dato));
            mostrar(lista);
        }
        System.out.println("Ejemplo con duplicados:");
        ListaEnlazada duplicados = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 10, 30, 10}) duplicados.insertarAlFinal(dato);
        mostrar(duplicados);
        for (int i = 0; i < 2; i++) {
            System.out.println("eliminar(10): " + duplicados.eliminar(10));
            mostrar(duplicados);
        }
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

/*
Implementá en Java un programa que permita obtener el valor almacenado en una posición específica de una lista enlazada simple de números enteros, mediante el método `int obtener(int posicion)`.

**Estructura elegida:** lista enlazada simple formada por nodos que contienen un dato entero y una referencia al siguiente nodo.

**Estrategia:** construir una lista enlazada utilizando una clase `Nodo` con los atributos `dato` y `siguiente`, y una clase `ListaEnlazada` con `head` y `size`. Implementar `obtener(int posicion)` validando primero el índice solicitado y luego recorriendo secuencialmente desde `head` hasta alcanzar el nodo correspondiente.

**Justificación:** aunque el método recibe una posición, una lista enlazada simple no permite acceso directo por índice como ocurre con un arreglo. Cada nodo conoce solamente al siguiente. Por eso, acceder al elemento ubicado en una posición determinada requiere avanzar por las referencias desde el primer nodo.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones sobre la estructura.
- `Ejercicio3`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Método principal:**

`int obtener(int posicion)`

Debe realizar los siguientes pasos:

1. Validar que `posicion` esté comprendida entre 0 y `size - 1`.
2. Si `posicion < 0` o `posicion >= size`, lanzar `IndexOutOfBoundsException`.
3. Crear una referencia auxiliar `actual` que apunte a `head`.
4. Avanzar exactamente `posicion` veces mediante `actual = actual.getSiguiente()`.
5. Devolver el dato almacenado en el nodo alcanzado.
6. No modificar la lista durante la consulta.

**Validación de posiciones:**
- La primera posición válida es 0.
- La última posición válida es `size - 1`.
- Las posiciones negativas son inválidas.
- La posición igual a `size` es inválida.
- Las posiciones mayores a `size` son inválidas.
- En una lista vacía no existe ninguna posición válida.
- Las posiciones inválidas deben producir `IndexOutOfBoundsException`, no `NullPointerException`.

**Manejo de referencias:**
- El recorrido debe comenzar desde `head`.
- Utilizar una referencia auxiliar `actual` para avanzar entre los nodos.
- No cambiar `head`.
- No modificar las referencias `siguiente`.
- No crear ni eliminar nodos.
- No modificar los datos almacenados.
- No cambiar el atributo `size`.
- Evitar recorrer posiciones innecesarias: detenerse exactamente en el nodo solicitado.
- Explicar por qué obtener el elemento en la posición 0 no requiere recorrer enlaces.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben permitir construir listas para las pruebas y seguir la lógica de los ejercicios anteriores, manteniendo el Ejercicio 3 independiente.

**Casos especiales:**
- Lista vacía: cualquier posición solicitada debe producir `IndexOutOfBoundsException`.
- Lista de un solo elemento: únicamente es válida la posición 0.
- Primera posición: devolver el valor almacenado en `head`.
- Posición intermedia: recorrer los nodos necesarios.
- Última posición: devolver correctamente el último elemento.
- Posición negativa: rechazarla.
- Posición igual o mayor que `size`: rechazarla.
- Elementos repetidos: devolver el valor correspondiente a la posición, sin buscar por contenido.
- Permitir valores negativos, cero y extremos de `int`.
- Las consultas válidas e inválidas no deben alterar la estructura.

**Complejidad:**
- Validación de posición: O(1), utilizando el atributo `size`.
- `obtener(0)`: O(1).
- `obtener(posicion)`: O(posicion + 1), y O(n) en el peor caso.
- Espacio auxiliar de `obtener`: O(1), porque utiliza una sola referencia auxiliar.
- Espacio total de la lista: O(n), correspondiente a los nodos.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n) en una implementación sin `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio3.java`.
- Implementar una clase pública `Ejercicio3` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio3`, para evitar conflictos con los ejercicios anteriores.
- Implementar manualmente los nodos y referencias.
- Mantener privados `dato`, `siguiente`, `head` y `size`.
- No utilizar arreglos ni colecciones predefinidas para almacenar la lista.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue` ni estructuras equivalentes para implementar el acceso.
- No utilizar recorridos mediante `Stream` ni conversiones a arreglos.
- No depender de clases de otros ejercicios.
- Incorporar comentarios que expliquen la validación, el recorrido secuencial y la diferencia frente al acceso directo de los arreglos.
- Mostrar resultados claros en consola.
- Mantener correctamente los enlaces, el tamaño y la ausencia de ciclos.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los elementos 10, 20, 30, 40 y 50.
3. Mostrar `10 -> 20 -> 30 -> 40 -> 50 -> null`.
4. Ejecutar `obtener(0)` y verificar que devuelve 10.
5. Ejecutar `obtener(1)` y verificar que devuelve 20.
6. Ejecutar `obtener(2)` y verificar que devuelve 30.
7. Ejecutar `obtener(3)` y verificar que devuelve 40.
8. Ejecutar `obtener(4)` y verificar que devuelve 50.
9. Ejecutar `obtener(-1)` y verificar que lanza `IndexOutOfBoundsException`.
10. Ejecutar `obtener(5)` y verificar que lanza `IndexOutOfBoundsException`.
11. Ejecutar `obtener(100)` y verificar que lanza `IndexOutOfBoundsException`.
12. Comprobar que el contenido, los enlaces, `head` y `size` siguen intactos después de las consultas.

**Pruebas adicionales:**
- Obtener sobre una lista vacía.
- Obtener el único elemento de una lista de tamaño 1.
- Rechazar la posición 1 de una lista de tamaño 1.
- Rechazar posiciones negativas.
- Rechazar posiciones iguales a `size`.
- Rechazar posiciones mayores que `size`.
- Obtener el primer nodo.
- Obtener nodos intermedios.
- Obtener el último nodo.
- Obtener elementos repetidos en distintas posiciones.
- Obtener números negativos y cero.
- Obtener `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Alternar inserciones al inicio y al final antes de consultar.
- Realizar múltiples consultas consecutivas.
- Comprobar que `obtener()` no modifica `head`.
- Comprobar que `obtener()` no modifica `size`.
- Comprobar que no cambia ningún dato ni enlace.
- Comprobar que las excepciones conservan íntegramente la estructura.
- Verificar que no aparezcan ciclos ni nodos inaccesibles.

Compilar individualmente y conjuntamente con los ejercicios 1 y 2 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar la cantidad de casos y comprobaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio3 {
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
        public int obtener(int posicion) {
            // Validar con size antes de recorrer: nunca acceder a un nodo inexistente.
            if (posicion < 0 || posicion >= size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
            Nodo actual = head;
            // A diferencia del arreglo, seguimos enlaces: exactamente posicion avances.
            // Para la posicion cero no se recorre ningun enlace.
            for (int i = 0; i < posicion; i++) actual = actual.getSiguiente();
            return actual.getDato(); // No cambia datos, enlaces, head ni size.
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 30, 40, 50}) lista.insertarAlFinal(dato);
        lista.imprimir();
        for (int posicion = 0; posicion < lista.getSize(); posicion++) {
            System.out.println("obtener(" + posicion + "): " + lista.obtener(posicion));
        }
        for (int posicion : new int[]{-1, 5, 100}) {
            try {
                lista.obtener(posicion);
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException: " + e.getMessage());
            }
        }
        System.out.println("Lista despues de consultar, size = " + lista.getSize() + ":");
        lista.imprimir();
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

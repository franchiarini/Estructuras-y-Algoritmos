/*
Implementá en Java un programa que permita contar cuántas veces aparece un número entero dentro de una lista enlazada simple, mediante el método `int contarOcurrencias(int dato)`.

**Estructura elegida:** lista enlazada simple de enteros formada por nodos conectados mediante referencias `siguiente`, con acceso desde `head`.

**Estrategia:** implementar una lista enlazada mediante las clases `Nodo` y `ListaEnlazada`, administrando el primer nodo mediante `head` y la cantidad de elementos mediante `size`. El método `contarOcurrencias(int dato)` debe utilizar una referencia auxiliar `actual` y un contador entero inicializado en cero. Recorrer todos los nodos desde `head` hasta llegar a `null`, incrementando el contador cada vez que el dato almacenado coincida con el valor buscado.

**Justificación:** a diferencia de una búsqueda que solamente necesita determinar si existe un valor, contar ocurrencias requiere examinar todos los nodos. Un mismo dato puede aparecer varias veces y detener el recorrido en la primera coincidencia produciría un resultado incorrecto.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones de la lista.
- `Ejercicio8`: clase pública con método `main` para demostrar el funcionamiento y ejecutar pruebas.

**Método principal:**

`int contarOcurrencias(int dato)`

Debe funcionar de la siguiente manera:

1. Inicializar una variable entera `contador = 0`.
2. Crear una referencia auxiliar `actual` que inicialmente apunte a `head`.
3. Mientras `actual != null`, comparar el valor de `actual.getDato()` con el dato buscado.
4. Si ambos valores coinciden, incrementar `contador`.
5. Avanzar siempre al siguiente nodo mediante `actual = actual.getSiguiente()`.
6. Continuar el recorrido incluso después de encontrar una o varias coincidencias.
7. Al llegar a `null`, devolver `contador`.

**Diferencia respecto de buscar(int dato):**
- `buscar(int dato)` devuelve un booleano e interrumpe la búsqueda al encontrar la primera coincidencia.
- `contarOcurrencias(int dato)` devuelve un entero y debe recorrer toda la lista, incluso cuando ya encontró una coincidencia.
- No utilizar `return` dentro del recorrido para terminar al encontrar el primer valor.
- El resultado debe ser cero cuando no existe ninguna coincidencia.

**Manejo de referencias:**
- Comenzar el recorrido desde `head`.
- Utilizar `actual` como referencia auxiliar.
- Avanzar exactamente de un nodo al siguiente en cada iteración.
- No modificar `head`.
- No modificar ninguna referencia `siguiente`.
- No modificar datos almacenados.
- No crear ni eliminar nodos.
- No cambiar `size`.
- No utilizar arreglos para contar los valores.
- Mantener la identidad y el orden de todos los nodos.
- Finalizar correctamente el recorrido al llegar a `null`.

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben seguir la implementación básica utilizada en los ejercicios anteriores y servir para construir los casos de prueba.

**Casos especiales:**
- Lista vacía: devolver 0.
- Lista de un solo nodo que coincide: devolver 1.
- Lista de un solo nodo que no coincide: devolver 0.
- Valor inexistente: devolver 0.
- Valor presente una sola vez.
- Valor presente varias veces en posiciones consecutivas.
- Valor presente varias veces en posiciones separadas.
- Todas las posiciones contienen el valor buscado: devolver `size`.
- Primera posición coincidente.
- Última posición coincidente.
- Datos negativos, cero y extremos de `int`.
- Comprobar que contar ocurrencias no modifica la lista.

**Complejidad:**
- Lista vacía: O(1).
- Lista no vacía: O(n), porque debe examinar todos los nodos.
- El costo no disminuye aunque la primera posición contenga el valor buscado, ya que pueden existir otras coincidencias.
- Espacio auxiliar de `contarOcurrencias`: O(1), porque solo se utilizan un contador y una referencia auxiliar.
- Espacio total de la lista: O(n), correspondiente a los nodos almacenados.
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza una referencia `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio8.java`.
- Implementar una clase pública `Ejercicio8` con método `main`.
- Implementar `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio8`, para evitar conflictos de nombres.
- Implementar manualmente la estructura mediante nodos y referencias.
- Mantener privados los atributos internos.
- Utilizar `head` y `size` como únicos atributos de control de la lista, sin agregar `tail`.
- No utilizar arreglos ni colecciones predefinidas como estructura de almacenamiento o mecanismo de conteo.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Map`, `Set` ni estructuras equivalentes para implementar el ejercicio.
- No utilizar `Stream`, `Collections.frequency()` ni conversiones a arreglos para contar ocurrencias.
- No depender de clases implementadas en otros ejercicios.
- Incluir comentarios que expliquen el recorrido secuencial, el contador y por qué no se debe detener el recorrido en la primera coincidencia.
- Mostrar claramente el valor buscado y la cantidad de apariciones.
- Verificar que el atributo `size` coincida con la cantidad de nodos alcanzables desde `head`.
- Verificar que no existan ciclos y que el último nodo termine en `null`.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los valores 10, 20, 10, 30 y 10.
3. Mostrar `10 -> 20 -> 10 -> 30 -> 10 -> null`, con `size = 5`.
4. Ejecutar `contarOcurrencias(10)` y verificar que devuelve 3.
5. Ejecutar `contarOcurrencias(20)` y verificar que devuelve 1.
6. Ejecutar `contarOcurrencias(30)` y verificar que devuelve 1.
7. Ejecutar `contarOcurrencias(99)` y verificar que devuelve 0.
8. Ejecutar `contarOcurrencias(-5)` y verificar que devuelve 0.
9. Verificar que `head`, `size`, los datos, las identidades y los enlaces de los nodos permanecieron intactos.
10. Mostrar nuevamente la lista y comprobar que su contenido no cambió.

**Ejemplo adicional con todos los elementos repetidos:**
1. Construir `7 -> 7 -> 7 -> 7 -> null`.
2. Ejecutar `contarOcurrencias(7)` y comprobar que devuelve 4.
3. Ejecutar `contarOcurrencias(8)` y comprobar que devuelve 0.
4. Verificar que el método recorre correctamente la lista completa y que `size` sigue siendo 4.

**Pruebas adicionales:**
- Contar ocurrencias en una lista vacía.
- Lista de un solo nodo con coincidencia.
- Lista de un solo nodo sin coincidencia.
- Valor inexistente en una lista de varios nodos.
- Valor que aparece una sola vez.
- Valor que aparece varias veces consecutivas.
- Valor que aparece varias veces separadas.
- Valor repetido al inicio y al final.
- Todos los nodos con el mismo dato.
- Todos los nodos con datos diferentes.
- Valores negativos.
- Valor cero.
- `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Alternar inserciones al inicio y al final antes de contar.
- Realizar múltiples conteos consecutivos sobre la misma lista.
- Verificar que el resultado nunca sea negativo.
- Verificar que el resultado no sea mayor que `size`.
- Verificar que contar ocurrencias no modifica `head`.
- Verificar que contar ocurrencias no modifica `size`.
- Verificar que los datos y las referencias `siguiente` permanecen idénticos.
- Verificar que se conserva la identidad de los nodos.
- Verificar que no se generan ciclos ni nodos inaccesibles.
- Verificar que imprimir no altera la estructura.

Compilar individualmente y conjuntamente con los ejercicios 1 al 7 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar por separado la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio8 {
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
        public int contarOcurrencias(int dato) {
            int contador = 0;
            Nodo actual = head;
            // Recorrer todos los nodos: una coincidencia no excluye otras posteriores.
            while (actual != null) {
                if (actual.getDato() == dato) contador++;
                actual = actual.getSiguiente(); // Solo cambia la referencia local.
            }
            return contador; // null marca el final; una lista vacia devuelve cero.
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    private static void mostrarConteos(ListaEnlazada lista, int[] valores) {
        lista.imprimir();
        System.out.println("size = " + lista.getSize());
        for (int dato : valores) {
            System.out.println("contarOcurrencias(" + dato + "): " + lista.contarOcurrencias(dato));
        }
        System.out.println("Lista despues de contar:");
        lista.imprimir();
        System.out.println("size = " + lista.getSize());
    }
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 10, 30, 10}) lista.insertarAlFinal(dato);
        mostrarConteos(lista, new int[]{10, 20, 30, 99, -5});
        ListaEnlazada repetidos = new ListaEnlazada();
        for (int i = 0; i < 4; i++) repetidos.insertarAlFinal(7);
        mostrarConteos(repetidos, new int[]{7, 8});
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

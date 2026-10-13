/*
Implementá en Java un programa que permita invertir el orden de una lista enlazada simple de números enteros mediante el método `void invertir()`, modificando las referencias entre los nodos originales.

**Estructura elegida:** lista enlazada simple formada por nodos que almacenan un dato entero y una referencia al siguiente nodo.

**Estrategia:** implementar una lista enlazada mediante las clases `Nodo` y `ListaEnlazada`, administrada con `head` y `size`. Para invertirla, utilizar tres referencias auxiliares denominadas `anterior`, `actual` y `siguiente`. Recorrer los nodos una sola vez y modificar sus enlaces `siguiente` para invertir la dirección de la cadena sin crear una nueva lista ni reemplazar los nodos.

**Justificación:** una lista enlazada simple está organizada mediante referencias que conectan cada nodo con el siguiente. Para invertir su orden no es necesario intercambiar los datos ni copiar los elementos: basta con redirigir correctamente las referencias. Sin embargo, es fundamental guardar el siguiente nodo antes de modificar el enlace actual, porque de lo contrario podría perderse el acceso al resto de la lista.

**Estructura de clases:**
- `Nodo`: almacena `int dato` y una referencia `Nodo siguiente`.
- `ListaEnlazada`: administra `head`, `size` y las operaciones.
- `Ejercicio9`: clase pública con método `main` para demostrar la inversión y ejecutar pruebas.

**Método principal:**

`void invertir()`

Debe invertir físicamente las referencias entre los nodos de la lista, manteniendo sus identidades y datos originales.

**Referencias auxiliares:**
- `anterior`: indica el nodo que debe quedar después del nodo actual en la lista invertida.
- `actual`: identifica el nodo que se está procesando.
- `siguiente`: conserva temporalmente la referencia al próximo nodo de la lista original antes de modificar su enlace.

**Algoritmo requerido:**

1. Inicializar `anterior = null`.
2. Inicializar `actual = head`.
3. Mientras `actual != null`, repetir:
   - Guardar el nodo siguiente mediante `siguiente = actual.getSiguiente()`.
   - Invertir el enlace con `actual.setSiguiente(anterior)`.
   - Actualizar `anterior = actual`.
   - Avanzar mediante `actual = siguiente`.
4. Al terminar el recorrido, actualizar `head = anterior`.
5. Conservar `size` sin modificaciones.

**Orden correcto de actualización:**

La secuencia fundamental debe ser:

`Nodo siguiente = actual.getSiguiente();`

`actual.setSiguiente(anterior);`

`anterior = actual;`

`actual = siguiente;`

Primero se conserva la referencia al próximo nodo original. Después se invierte el enlace actual y finalmente avanzan las referencias auxiliares.

**Importancia del orden:**
- Si se modifica `actual.siguiente` antes de guardar el siguiente nodo, puede perderse el acceso a la parte de la lista que todavía no fue procesada.
- Si se avanza `actual` después de sobrescribir su referencia `siguiente`, puede recorrerse incorrectamente la cadena invertida.
- Si no se actualiza `head` al finalizar, la lista no tendrá como punto de entrada al nuevo primer nodo.
- Si no se inicializa `anterior` en `null`, el último nodo de la lista invertida puede quedar conectado incorrectamente.
- Si se cambian enlaces de forma incorrecta, pueden generarse ciclos o quedar nodos inaccesibles.

**Restricciones sobre los nodos:**
- No intercambiar los valores almacenados.
- No modificar el atributo `dato` de ningún nodo.
- No crear nodos nuevos para realizar la inversión.
- No eliminar nodos.
- No reconstruir una segunda lista.
- No utilizar arreglos, pilas, colas ni colecciones predefinidas para invertir.
- Conservar exactamente los mismos objetos Nodo, cambiando solamente sus referencias `siguiente`.
- Conservar `size` sin cambios.
- Después de la inversión, todos los nodos deben ser alcanzables desde el nuevo `head`.
- El último nodo debe apuntar a `null`.
- La lista no debe contener ciclos.

**Casos especiales:**
- Lista vacía: invertir debe conservar `head == null` y `size == 0`.
- Lista de un nodo: debe conservar el mismo nodo como `head`.
- Lista de dos nodos: invertir correctamente ambas referencias.
- Lista de tres o más nodos: invertir el orden completo.
- Valores repetidos: invertir los nodos respetando su identidad, sin confundirlos por tener el mismo dato.
- Valores negativos, cero y extremos de `int`.
- Invertir dos veces consecutivas: debe recuperar el orden y la identidad original de todos los nodos.
- Invertir varias veces: el resultado debe alternar entre el orden original y el inverso.
- Agregar elementos después de invertir: las operaciones de inserción deben seguir funcionando correctamente.
- Lista de gran tamaño: la inversión debe funcionar sin recurrir a recursividad ni agotar la pila de llamadas.

**Complejidad:**
- `invertir()` para una lista de n elementos: O(n) de tiempo.
- Lista vacía o de un solo nodo: O(1).
- Espacio auxiliar: O(1), porque solamente se utilizan tres referencias auxiliares.
- No utilizar espacio adicional proporcional a la cantidad de nodos.
- Espacio total de almacenamiento de la lista: O(n).
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), porque no se utiliza `tail`.
- `imprimir`: O(n).
- `estaVacia` y `getSize`: O(1).

**Operaciones auxiliares:**
- `insertarAlInicio(int dato)`.
- `insertarAlFinal(int dato)`.
- `imprimir()`.
- `estaVacia()`.
- `getSize()`.

Estas operaciones deben respetar la implementación básica de los ejercicios anteriores y servir para construir los escenarios de prueba.

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio9.java`.
- Implementar una clase pública `Ejercicio9` con método `main`.
- Implementar las clases `Nodo` y `ListaEnlazada` preferentemente como clases estáticas anidadas dentro de `Ejercicio9`, evitando conflictos con los ejercicios anteriores.
- Implementar manualmente la estructura con nodos y referencias.
- Mantener privados los atributos internos.
- Utilizar solamente `head` y `size` como atributos de control, sin agregar `tail`.
- Implementar `invertir()` mediante un algoritmo iterativo, no recursivo.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Stack`, `Queue`, `Deque`, `Map`, `Set`, arreglos auxiliares ni estructuras equivalentes para realizar la inversión.
- No utilizar `Stream` ni copiar los datos a otra estructura.
- No depender de clases de otros ejercicios.
- Incorporar comentarios que expliquen las tres referencias auxiliares, el orden de actualización y la importancia de preservar el nodo siguiente.
- Mostrar por consola el contenido de la lista antes y después de invertir.
- Mostrar claramente cómo cambia `head`.
- Comprobar que se conservan `size`, los datos y las identidades de todos los nodos.
- Verificar que no se generen ciclos ni queden nodos inaccesibles.

**Ejemplo principal:**
1. Crear una lista vacía.
2. Insertar al final los números 10, 20, 30 y 40.
3. Mostrar `10 -> 20 -> 30 -> 40 -> null`, con `size = 4`.
4. Ejecutar `invertir()`.
5. Verificar `40 -> 30 -> 20 -> 10 -> null`, con `size = 4`.
6. Comprobar que `head` ahora apunta al mismo nodo que originalmente contenía 40.
7. Comprobar que el nodo que contiene 10 ahora es el último y apunta a `null`.
8. Verificar que todos los nodos conservaron su identidad y su dato.
9. Ejecutar nuevamente `invertir()`.
10. Verificar `10 -> 20 -> 30 -> 40 -> null`, con `size = 4`.
11. Comprobar que se restauró el orden original de los mismos nodos.

**Ejemplo adicional con duplicados:**
1. Construir `10 -> 20 -> 10 -> 30 -> 10 -> null`.
2. Ejecutar `invertir()`.
3. Verificar `10 -> 30 -> 10 -> 20 -> 10 -> null`.
4. Comprobar que los cinco nodos originales fueron invertidos por identidad, no simplemente comparando valores.
5. Verificar que `size` sigue siendo 5.

**Pruebas adicionales:**
- Invertir una lista vacía.
- Invertir una lista de un nodo.
- Invertir una lista de dos nodos.
- Invertir listas de longitud par e impar.
- Invertir listas de varios elementos.
- Invertir listas con datos repetidos.
- Invertir listas con números negativos.
- Invertir listas que contienen cero.
- Invertir listas con `Integer.MIN_VALUE` e `Integer.MAX_VALUE`.
- Comprobar que invertir dos veces restaura el orden original.
- Comprobar que invertir tres veces equivale a una única inversión.
- Comprobar que `head` pasa a apuntar al último nodo original.
- Comprobar que el primer nodo original pasa a ser el último.
- Comprobar que el último nodo tiene `siguiente == null`.
- Verificar que todos los nodos siguen siendo alcanzables.
- Comprobar que no se generan ciclos.
- Verificar que no se crean nodos nuevos durante la inversión.
- Verificar que no se pierde ningún nodo.
- Verificar que los datos permanecen sin cambios dentro de cada objeto Nodo.
- Comprobar que `size` permanece constante.
- Alternar inserciones al inicio y al final con inversiones.
- Invertir una lista suficientemente larga para verificar que el método es iterativo.
- Comprobar que imprimir no modifica la estructura.

Para verificar identidades, enlaces y ausencia de ciclos durante las pruebas, pueden utilizarse referencias auxiliares y mecanismos de comprobación externos al algoritmo, sin cambiar la implementación de `invertir()` ni agregar colecciones como almacenamiento de la lista.

Compilar individualmente y conjuntamente con los ejercicios 1 al 8 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar por separado la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
public class Ejercicio9 {
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
        public void invertir() {
            Nodo anterior = null; // El primer nodo original terminara apuntando a null.
            Nodo actual = head;
            while (actual != null) {
                // Guardar el siguiente original antes de invertir: evita perder el resto.
                Nodo siguiente = actual.getSiguiente();
                actual.setSiguiente(anterior);
                anterior = actual; // Extremo de la parte ya invertida.
                actual = siguiente; // Continuar por la cadena original, no por la invertida.
            }
            head = anterior; // El ultimo nodo original es el nuevo primero; size no cambia.
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    private static void mostrar(ListaEnlazada lista) {
        lista.imprimir();
        System.out.println("size = " + lista.getSize() + ", head = "
                + (lista.head == null ? "null" : lista.head.getDato()));
    }
    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 30, 40}) lista.insertarAlFinal(dato);
        System.out.println("Original:");
        mostrar(lista);
        lista.invertir();
        System.out.println("Primera inversion:");
        mostrar(lista);
        lista.invertir();
        System.out.println("Segunda inversion:");
        mostrar(lista);
        ListaEnlazada duplicados = new ListaEnlazada();
        for (int dato : new int[]{10, 20, 10, 30, 10}) duplicados.insertarAlFinal(dato);
        System.out.println("Duplicados, antes:");
        mostrar(duplicados);
        duplicados.invertir();
        System.out.println("Duplicados, despues:");
        mostrar(duplicados);
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

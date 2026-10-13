/*
Implementá en Java una versión genérica de la lista enlazada simple desarrollada en los ejercicios anteriores, utilizando las clases `Nodo<T>` y `ListaEnlazada<T>`, de manera que pueda almacenar distintos tipos de objetos sin modificar los algoritmos de manejo de referencias.

**Estructura elegida:** lista enlazada simple genérica, formada por nodos `Nodo<T>` conectados mediante referencias `siguiente`, administrados desde una clase `ListaEnlazada<T>`.

**Estrategia:** transformar la implementación de enteros en una implementación parametrizada mediante `T`. Reemplazar el atributo `int dato` por `T dato` y las referencias `Nodo` por `Nodo<T>`. Mantener las operaciones sobre nodos utilizando exactamente los mismos principios de recorrido secuencial, inserción, modificación de referencias, eliminación e inversión.

**Justificación:** las operaciones de una lista enlazada dependen de cómo se conectan los nodos, no del tipo específico de información almacenada. La utilización de genéricos permite reutilizar una única implementación para `Integer`, `String`, `Alumno` y otros tipos de objetos, proporcionando comprobación de tipos durante la compilación.

**Estructura de clases:**
- `Nodo<T>`: contiene un dato de tipo `T` y una referencia `Nodo<T> siguiente`.
- `ListaEnlazada<T>`: administra `Nodo<T> head`, `int size` y las operaciones de la lista.
- `Alumno`: clase sencilla para demostrar el almacenamiento de objetos personalizados.
- `Ejercicio10`: clase pública con método `main` para ejecutar ejemplos y pruebas.

**Clase Nodo<T>:**
- Declarar `private T dato`.
- Declarar `private Nodo<T> siguiente`.
- Crear un constructor que reciba un dato de tipo `T`.
- Inicializar `siguiente` en `null`.
- Implementar los métodos de acceso necesarios para consultar y modificar el dato y la referencia siguiente.
- No utilizar tipos genéricos sin parametrizar ni conversiones inseguras.

**Clase ListaEnlazada<T>:**
- Declarar `private Nodo<T> head`.
- Declarar `private int size`.
- Inicializar `head = null` y `size = 0`.
- No incorporar una referencia `tail`, manteniendo la implementación básica trabajada durante la clase.
- Garantizar que `size` coincida siempre con la cantidad de nodos alcanzables desde `head`.

**Operaciones requeridas para integrar lo aprendido:**

1. `void insertarAlInicio(T dato)`:
   - Crear un nodo genérico.
   - Conectarlo con el `head` anterior.
   - Actualizar `head`.
   - Incrementar `size`.

2. `void insertarAlFinal(T dato)`:
   - Si la lista está vacía, asignar el nuevo nodo a `head`.
   - Si no está vacía, recorrer hasta el último nodo y enlazarlo.
   - Incrementar `size`.

3. `boolean buscar(T dato)`:
   - Recorrer desde `head` hasta encontrar el dato o llegar a `null`.
   - Comparar los valores mediante una igualdad lógica apropiada para objetos.
   - Devolver `true` cuando se encuentra la primera coincidencia y `false` si no existe.

4. `T obtener(int posicion)`:
   - Validar que la posición esté comprendida entre 0 y `size - 1`.
   - Recorrer hasta el nodo indicado.
   - Devolver el dato de tipo `T`.

5. `void insertarEnPosicion(T dato, int posicion)`:
   - Aceptar posiciones de 0 a `size`, inclusive.
   - Insertar al inicio o localizar el nodo anterior.
   - Preservar las referencias mediante el orden correcto:
     `nuevo.setSiguiente(actual.getSiguiente());`
     `actual.setSiguiente(nuevo);`
   - Incrementar `size` una sola vez.

6. `boolean eliminar(T dato)`:
   - Eliminar únicamente la primera aparición.
   - Devolver `true` si se eliminó un nodo y `false` si el dato no se encontró.
   - Actualizar `head` cuando se elimina el primer nodo.
   - Para los demás casos, modificar el enlace del nodo anterior.
   - Disminuir `size` exactamente una vez por eliminación exitosa.

7. `void eliminarEnPosicion(int posicion)`:
   - Validar el índice.
   - Eliminar `head` o encontrar el nodo anterior.
   - Actualizar el enlace sin perder el resto de la lista.
   - Disminuir `size` una sola vez.

8. `void modificar(int posicion, T nuevoDato)`:
   - Validar la posición.
   - Recorrer hasta el nodo correspondiente.
   - Cambiar únicamente el atributo `dato`.
   - Conservar todas las referencias y el tamaño.

9. `int contarOcurrencias(T dato)`:
   - Recorrer todos los nodos.
   - Contar las coincidencias sin detenerse en la primera.
   - Devolver cero cuando el valor no esté presente.

10. `void invertir()`:
    - Invertir la lista modificando las referencias de los nodos originales.
    - Utilizar `anterior`, `actual` y `siguiente`.
    - No intercambiar los datos.
    - No crear una segunda lista.
    - Actualizar `head` al finalizar.
    - Conservar `size`.

11. `void imprimir()`:
    - Recorrer desde `head` y mostrar los datos separados por `->`, finalizando con `null`.
    - Permitir imprimir los distintos tipos mediante su representación textual.

12. `boolean estaVacia()`:
    - Devolver `true` cuando `head == null`.

13. `int getSize()`:
    - Devolver el atributo `size` sin recorrer la lista.

**Igualdad de elementos genéricos:**
- No utilizar `==` para comparar el contenido lógico de objetos.
- Utilizar `java.util.Objects.equals(a, b)` en `buscar`, `eliminar` y `contarOcurrencias`, para comparar valores de forma segura.
- Admitir datos `null` como elementos válidos, utilizando una política coherente en todas las operaciones.
- Explicar que `Objects.equals` utiliza la semántica de igualdad del tipo almacenado.
- Para la clase `Alumno`, implementar `equals` y `hashCode` de forma coherente utilizando un identificador del alumno, y explicar brevemente el criterio elegido.
- No confundir igualdad de datos con identidad de nodos: para comprobar que no se reemplazaron nodos, utilizar identidad de referencias en las pruebas.

**Qué cambia con los genéricos:**
- El tipo del dato pasa de `int` a `T`.
- Los nodos pasan de `Nodo` a `Nodo<T>`.
- La lista pasa de `ListaEnlazada` a `ListaEnlazada<T>`.
- Los parámetros y retornos de operaciones que trabajan con datos utilizan `T`.
- Las comparaciones de valores deben funcionar correctamente con objetos.
- Almacenar enteros requiere `Integer`, porque los parámetros genéricos no admiten tipos primitivos como `int`.

**Qué se mantiene igual:**
- El significado de `head`.
- El atributo `size`.
- La referencia `siguiente`.
- El recorrido nodo por nodo.
- La inserción al inicio y al final.
- El orden de actualización de referencias al insertar en una posición.
- La eliminación mediante modificación de enlaces.
- La inversión iterativa con tres referencias.
- Las validaciones de posiciones.
- El principio de que el último nodo apunta a `null`.
- Las complejidades estructurales de las operaciones.

**Casos especiales:**
- Lista vacía.
- Lista de un solo nodo.
- Inserción y eliminación al inicio.
- Inserción y eliminación en posiciones intermedias.
- Inserción y eliminación al final.
- Valores repetidos.
- Elementos `null`.
- Búsquedas exitosas y fallidas.
- Posiciones negativas o fuera de rango.
- Modificación de elementos sin cambiar referencias.
- Eliminación de la primera coincidencia.
- Conteo de múltiples ocurrencias.
- Inversión de listas vacías, unitarias y de varios elementos.
- Dos inversiones consecutivas que restauren el orden original.
- Uso simultáneo de listas con diferentes parámetros genéricos.
- Verificar que ninguna operación inválida altere el estado.

**Política de excepciones:**
- Para posiciones inválidas en `obtener`, `insertarEnPosicion`, `eliminarEnPosicion` y `modificar`, lanzar `IndexOutOfBoundsException`.
- En una lista vacía, `buscar`, `eliminar` y `contarOcurrencias` deben devolver respectivamente `false`, `false` y 0.
- Mantener sin cambios el estado ante una operación rechazada.
- Las posiciones válidas para insertar son de 0 a `size`, inclusive.
- Las posiciones válidas para obtener, modificar o eliminar por posición son de 0 a `size - 1`.

**Complejidad:**
- `insertarAlInicio`: O(1).
- `insertarAlFinal`: O(n), al no utilizar `tail`.
- `buscar`: O(n) en el peor caso, considerando comparaciones de costo constante.
- `obtener`: O(n) en el peor caso.
- `insertarEnPosicion`: O(n) en el peor caso.
- `eliminar`: O(n) en el peor caso, considerando comparaciones de costo constante.
- `eliminarEnPosicion`: O(n) en el peor caso.
- `modificar`: O(n) en el peor caso.
- `contarOcurrencias`: O(n), considerando comparaciones de costo constante.
- `invertir`: O(n) de tiempo y O(1) de espacio auxiliar.
- `imprimir`: O(n) en cantidad de nodos, sin contar el costo de convertir los datos a texto.
- `estaVacia` y `getSize`: O(1).
- Espacio de almacenamiento de la lista: O(n).
- Explicar que el costo de `equals` depende del tipo `T` y puede afectar el tiempo total de las operaciones que comparan datos.

**Requisitos de implementación:**
- Crear `TP5-Listas-Enlazadas-Simples/src/Ejercicio10.java`.
- Implementar una clase pública `Ejercicio10` con método `main`.
- Implementar `Nodo<T>`, `ListaEnlazada<T>` y `Alumno` preferentemente como clases estáticas anidadas dentro de `Ejercicio10`, evitando conflictos con los demás ejercicios.
- Mantener privados los atributos internos.
- Utilizar exclusivamente referencias entre nodos como estructura de almacenamiento.
- No utilizar arreglos ni colecciones predefinidas para implementar la lista ni sus operaciones.
- No utilizar `ArrayList`, `LinkedList`, `List`, `Vector`, `Stack`, `Queue`, `Deque`, `Map`, `Set` ni estructuras equivalentes como almacenamiento.
- No utilizar `Stream` ni copiar datos a arreglos.
- No depender de clases implementadas en otros ejercicios.
- No utilizar tipos raw ni conversiones no comprobadas.
- No incorporar funcionalidades ajenas a la consigna.
- Incluir comentarios que expliquen los genéricos, las referencias, las diferencias entre `int` y `T` y las operaciones.
- Mantener correctamente `head`, `size`, identidades y enlaces.
- Evitar ciclos, nodos perdidos y modificaciones accidentales.

**Ejemplo principal con Integer:**
1. Crear `ListaEnlazada<Integer>`.
2. Insertar 10, 20, 30 y 40.
3. Verificar `10 -> 20 -> 30 -> 40 -> null`.
4. Buscar 30 y comprobar que devuelve `true`.
5. Obtener la posición 2 y comprobar que devuelve 30.
6. Insertar 15 en la posición 1.
7. Verificar `10 -> 15 -> 20 -> 30 -> 40 -> null`.
8. Modificar la posición 2 con 99.
9. Verificar `10 -> 15 -> 99 -> 30 -> 40 -> null`.
10. Eliminar 30 por valor.
11. Verificar `10 -> 15 -> 99 -> 40 -> null`.
12. Contar las ocurrencias de 10 y verificar que devuelve 1.
13. Invertir la lista.
14. Verificar `40 -> 99 -> 15 -> 10 -> null`.
15. Comprobar que los nodos originales se conservaron y que `size` es correcto.

**Ejemplo con String:**
1. Crear `ListaEnlazada<String>`.
2. Insertar `Ana`, `Luis` y `Marta`.
3. Verificar `Ana -> Luis -> Marta -> null`.
4. Buscar `Luis` y comprobar que devuelve `true`.
5. Modificar la posición 1 por `Pedro`.
6. Comprobar `Ana -> Pedro -> Marta -> null`.
7. Eliminar `Ana`.
8. Comprobar `Pedro -> Marta -> null`.
9. Invertir y comprobar `Marta -> Pedro -> null`.

**Ejemplo con Alumno:**
1. Implementar una clase sencilla `Alumno` con un identificador, nombre y un método `toString`.
2. Implementar `equals` y `hashCode` coherentemente según el identificador.
3. Crear `ListaEnlazada<Alumno>`.
4. Insertar tres alumnos diferentes.
5. Consultar los alumnos en sus posiciones.
6. Buscar un alumno mediante un objeto distinto pero con el mismo identificador.
7. Verificar que `buscar` funciona mediante igualdad lógica y no mediante identidad de referencia.
8. Eliminar un alumno por valor.
9. Comprobar que permanecen los otros dos alumnos, con los datos y enlaces correctos.
10. Invertir la lista y comprobar el orden final.

**Pruebas adicionales:**
- Lista vacía de Integer, String y Alumno.
- Listas de un solo elemento.
- Inserciones al inicio y final.
- Inserciones en distintas posiciones.
- Eliminaciones por valor y posición.
- Modificaciones por posición.
- Búsquedas de datos existentes e inexistentes.
- Conteo de ocurrencias.
- Inversión de listas de diferentes tamaños.
- Inversión doble.
- Valores duplicados.
- Elementos `null` y comparaciones seguras con `Objects.equals`.
- Números negativos, cero y extremos de Integer.
- Cadenas vacías y repetidas.
- Objetos Alumno con igual identificador.
- Listas con distintos tipos funcionando de manera independiente.
- Rechazo de posiciones inválidas sin cambios de estado.
- Conservación de referencias e identidad de nodos durante modificaciones e inversiones.
- Confirmación de que las eliminaciones modifican enlaces sin reconstruir nodos.
- Comprobación de `size` después de cada operación.
- Detección de ciclos y nodos perdidos.
- Ejecución de secuencias variadas de operaciones.
- Verificar que los resultados reales coincidan con los esperados.

Compilar individualmente y conjuntamente con los ejercicios 1 al 9 utilizando Java 21, `--release 21` y `-Xlint:all`, sin advertencias.

Ejecutar pruebas reales y documentar por separado la cantidad de casos y verificaciones aprobadas y fallidas.

No modificar otros ejercicios ni realizar commits o push.
*/
import java.util.Objects;

public class Ejercicio10 {
    public static class Nodo<T> {
        private T dato;
        private Nodo<T> siguiente;
        public Nodo(T dato) { this.dato = dato; siguiente = null; }
        public T getDato() { return dato; }
        public void setDato(T dato) { this.dato = dato; }
        public Nodo<T> getSiguiente() { return siguiente; }
        public void setSiguiente(Nodo<T> siguiente) { this.siguiente = siguiente; }
    }

    public static class ListaEnlazada<T> {
        private Nodo<T> head = null;
        private int size = 0;

        public void insertarAlInicio(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setSiguiente(head); // Preservar primero el comienzo original.
            head = nuevo;
            size++;
        }
        public void insertarAlFinal(T dato) {
            Nodo<T> nuevo = new Nodo<>(dato);
            if (estaVacia()) head = nuevo;
            else {
                Nodo<T> actual = head;
                while (actual.getSiguiente() != null) actual = actual.getSiguiente();
                actual.setSiguiente(nuevo);
            }
            size++;
        }
        public boolean buscar(T dato) {
            Nodo<T> actual = head;
            while (actual != null) {
                // Objects.equals admite null y utiliza la igualdad del tipo T.
                if (Objects.equals(actual.getDato(), dato)) return true;
                actual = actual.getSiguiente();
            }
            return false;
        }
        private void validarPosicion(int posicion) {
            if (posicion < 0 || posicion >= size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
        }
        private Nodo<T> nodoEn(int posicion) {
            Nodo<T> actual = head;
            for (int i = 0; i < posicion; i++) actual = actual.getSiguiente();
            return actual;
        }
        public T obtener(int posicion) {
            validarPosicion(posicion);
            return nodoEn(posicion).getDato();
        }
        public void insertarEnPosicion(T dato, int posicion) {
            if (posicion < 0 || posicion > size) {
                throw new IndexOutOfBoundsException("Posicion fuera de rango: " + posicion);
            }
            if (posicion == 0) { insertarAlInicio(dato); return; }
            Nodo<T> actual = nodoEn(posicion - 1);
            Nodo<T> nuevo = new Nodo<>(dato);
            nuevo.setSiguiente(actual.getSiguiente()); // Conservar el resto antes de enlazar.
            actual.setSiguiente(nuevo);
            size++;
        }
        public boolean eliminar(T dato) {
            if (estaVacia()) return false;
            if (Objects.equals(head.getDato(), dato)) {
                head = head.getSiguiente(); size--; return true;
            }
            Nodo<T> actual = head;
            while (actual.getSiguiente() != null) {
                if (Objects.equals(actual.getSiguiente().getDato(), dato)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    size--; return true; // Solo la primera coincidencia.
                }
                actual = actual.getSiguiente();
            }
            return false;
        }
        public void eliminarEnPosicion(int posicion) {
            validarPosicion(posicion);
            if (posicion == 0) head = head.getSiguiente();
            else {
                Nodo<T> actual = nodoEn(posicion - 1);
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
            }
            size--;
        }
        public void modificar(int posicion, T nuevoDato) {
            validarPosicion(posicion);
            nodoEn(posicion).setDato(nuevoDato); // Conserva identidad, enlaces y size.
        }
        public int contarOcurrencias(T dato) {
            int contador = 0;
            Nodo<T> actual = head;
            while (actual != null) {
                if (Objects.equals(actual.getDato(), dato)) contador++;
                actual = actual.getSiguiente(); // No detenerse en la primera coincidencia.
            }
            return contador;
        }
        public void invertir() {
            Nodo<T> anterior = null;
            Nodo<T> actual = head;
            while (actual != null) {
                Nodo<T> siguiente = actual.getSiguiente();
                actual.setSiguiente(anterior);
                anterior = actual;
                actual = siguiente;
            }
            head = anterior; // Mismos nodos y datos, size intacto.
        }
        public void imprimir() {
            Nodo<T> actual = head;
            while (actual != null) {
                System.out.print(actual.getDato() + " -> ");
                actual = actual.getSiguiente();
            }
            System.out.println("null");
        }
        public boolean estaVacia() { return head == null; }
        public int getSize() { return size; }
    }

    public static final class Alumno {
        private final int identificador;
        private final String nombre;
        public Alumno(int identificador, String nombre) {
            this.identificador = identificador; this.nombre = nombre;
        }
        public int getIdentificador() { return identificador; }
        public String getNombre() { return nombre; }
        @Override public String toString() { return identificador + ": " + nombre; }
        // El identificador determina la igualdad, aunque cambie el nombre mostrado.
        @Override public boolean equals(Object otro) {
            return otro instanceof Alumno alumno && identificador == alumno.identificador;
        }
        @Override public int hashCode() { return Integer.hashCode(identificador); }
    }

    public static void main(String[] args) {
        // T representa objetos: para enteros se utiliza Integer, no int.
        ListaEnlazada<Integer> enteros = new ListaEnlazada<>();
        for (int dato : new int[]{10, 20, 30, 40}) enteros.insertarAlFinal(dato);
        enteros.imprimir();
        System.out.println("buscar(30): " + enteros.buscar(30) + ", obtener(2): " + enteros.obtener(2));
        enteros.insertarEnPosicion(15, 1); enteros.imprimir();
        enteros.modificar(2, 99); enteros.imprimir();
        System.out.println("eliminar(30): " + enteros.eliminar(30)); enteros.imprimir();
        System.out.println("contarOcurrencias(10): " + enteros.contarOcurrencias(10));
        enteros.invertir(); enteros.imprimir();
        System.out.println("size = " + enteros.getSize());

        ListaEnlazada<String> nombres = new ListaEnlazada<>();
        nombres.insertarAlFinal("Ana"); nombres.insertarAlFinal("Luis"); nombres.insertarAlFinal("Marta");
        nombres.imprimir(); System.out.println("buscar(Luis): " + nombres.buscar("Luis"));
        nombres.modificar(1, "Pedro"); nombres.imprimir();
        System.out.println("eliminar(Ana): " + nombres.eliminar("Ana")); nombres.imprimir();
        nombres.invertir(); nombres.imprimir();

        ListaEnlazada<Alumno> alumnos = new ListaEnlazada<>();
        alumnos.insertarAlFinal(new Alumno(1, "Ana")); alumnos.insertarAlFinal(new Alumno(2, "Luis"));
        alumnos.insertarAlFinal(new Alumno(3, "Marta"));
        alumnos.imprimir();
        for (int i = 0; i < alumnos.getSize(); i++) System.out.println("obtener(" + i + "): " + alumnos.obtener(i));
        System.out.println("buscar alumno con identificador 2: " + alumnos.buscar(new Alumno(2, "Otro nombre")));
        System.out.println("eliminar alumno 2: " + alumnos.eliminar(new Alumno(2, "Luis")));
        alumnos.imprimir(); alumnos.invertir(); alumnos.imprimir();
    }
}

// Ajustes al prompt: no fueron necesarios. Se conserva el prompt original integro.

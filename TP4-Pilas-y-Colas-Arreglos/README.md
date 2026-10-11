# TP4 — Pilas y Colas con Arreglos

### Metodología de trabajo

ChatGPT actúa como agente analista: estudia las consignas, selecciona las estructuras, razona sobre los algoritmos y elabora los prompts. Codex actúa como agente desarrollador: implementa en Java, compila, ejecuta las pruebas y documenta los resultados reales.

Los prompts académicos se conservan literalmente en este README y al comienzo de cada archivo Java.

### Ejercicio 1 — Implementar una pila de enteros

**Estrategia:** implementar `PilaEnteros` como clase auxiliar estática dentro de `Ejercicio1`, con un arreglo privado de capacidad fija y un índice privado `top`, inicialmente -1. Las operaciones actúan sobre el extremo superior, sin desplazar elementos.

**Justificación:** el principio LIFO implica retirar primero el último valor agregado. El índice `top` permite localizar ese valor directamente.

**Operaciones:** `push(int valor)` incrementa el índice y agrega el valor; `pop()` devuelve el tope y decrementa el índice; `peek()` consulta sin retirar; `isEmpty()` comprueba `top == -1`; `isFull()` comprueba `top == capacidad - 1`; `size()` devuelve `top + 1`.

**Casos especiales:** `push()` sobre una pila llena produce overflow; `pop()` y `peek()` sobre una pila vacía producen underflow. Se lanza `IllegalStateException` antes de modificar el estado. Las capacidades menores o iguales a cero se rechazan mediante `IllegalArgumentException`.

**Complejidad:** las seis operaciones tienen tiempo O(1) y espacio auxiliar O(1). El arreglo interno ocupa O(C), donde C es la capacidad fija. El constructor reserva e inicializa ese arreglo en O(C). La visualización del estado lógico recorre los elementos almacenados y cuesta O(size), fuera de las seis operaciones de la pila.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una clase `PilaEnteros` utilizando exclusivamente un arreglo de enteros de tamaño fijo, que permita agregar, retirar y consultar elementos respetando el principio LIFO.

**Estructura elegida:** pila (Stack) implementada manualmente mediante `int[]`.

**Estrategia:** utilizar un arreglo interno de capacidad fija y una variable entera `top` para indicar el índice del último elemento agregado. Inicializar `top = -1` para representar que la pila está vacía. Las operaciones deben modificar o consultar exclusivamente el extremo superior de la pila.

**Justificación:** una pila sigue el principio LIFO (Last In, First Out), por lo que el último elemento agregado es el primero en retirarse. El índice `top` permite administrar esta regla sin desplazar los elementos del arreglo.

**Operaciones requeridas:**
- `push(int valor)`: agregar un elemento al tope. Incrementar `top` y almacenar el valor.
- `pop()`: retirar y devolver el elemento del tope. Decrementar `top` después de obtenerlo.
- `peek()`: consultar y devolver el elemento superior sin retirarlo.
- `isEmpty()`: devolver `true` cuando `top == -1`.
- `isFull()`: devolver `true` cuando `top == capacidad - 1`.
- `size()`: devolver la cantidad de elementos almacenados, calculada como `top + 1`.

**Casos especiales:**
- Overflow: cuando se intenta ejecutar `push()` sobre una pila llena, lanzar `IllegalStateException` sin modificar la estructura.
- Underflow: cuando se intenta ejecutar `pop()` o `peek()` sobre una pila vacía, lanzar `IllegalStateException` sin modificar la estructura.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.

**Complejidad:**
- `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio del arreglo interno: O(C), siendo C la capacidad fija de la pila.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-con-Arreglos/src/Ejercicio1.java`.
- Implementar una clase `PilaEnteros` con un constructor que reciba la capacidad.
- Definir el arreglo y la variable `top` como atributos privados.
- Inicializar correctamente la pila vacía.
- Implementar manualmente las seis operaciones solicitadas.
- Mantener la encapsulación, evitando que el código externo modifique directamente el arreglo o `top`.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la pila.
- Incorporar comentarios explicando el principio LIFO, el uso de `top`, las operaciones y los casos de overflow y underflow.
- Incluir un método `main` ejecutable para mostrar el funcionamiento.
- Mostrar por pantalla el estado lógico de la pila y sus cambios después de las operaciones importantes.
- No confundir `peek()` con `pop()`: consultar no debe eliminar elementos.

**Ejemplo principal:**

Crear una pila de capacidad 3 y ejecutar:

1. Mostrar pila vacía: `top = -1`, `size = 0`.
2. Ejecutar `push(10)`.
3. Ejecutar `push(20)`.
4. Ejecutar `push(30)`.
5. Consultar `peek()`: debe devolver 30 y conservar los tres elementos.
6. Intentar `push(40)`: debe producir overflow.
7. Ejecutar `pop()`: debe devolver 30.
8. Ejecutar `pop()`: debe devolver 20.
9. Ejecutar `pop()`: debe devolver 10.
10. Intentar `pop()` y `peek()` nuevamente: deben producir underflow.

**Pruebas adicionales:**
- Pila de capacidad 1.
- Pila parcialmente llena.
- Pila completamente llena.
- Pila vacía.
- Alternancia entre operaciones `push` y `pop`.
- Valores negativos, cero, valores repetidos y extremos de `int`.
- Comprobar que `peek()` no modifica el tamaño.
- Comprobar que las excepciones por overflow y underflow no alteran el estado.
- Comprobar que `isEmpty`, `isFull` y `size` coinciden con el estado real.
- Capacidades inválidas.

Compilar y ejecutar con Java 21 utilizando `-Xlint:all`, verificando los resultados y documentando las pruebas efectivamente realizadas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

Se utilizó la carpeta existente `TP4-Pilas-y-Colas-Arreglos` en lugar de crear `TP4-Pilas-y-Colas-con-Arreglos`, para respetar la estructura real y evitar duplicar el práctico. Este ajuste de ubicación está registrado también al final del archivo Java. El prompt inicial permanece literal; no se modificaron el algoritmo ni los requisitos funcionales.

#### Resultado

Se implementaron manualmente las seis operaciones con arreglo fijo, sin colecciones predefinidas. `Ejercicio1.main` muestra el segmento lógico desde la base al tope, el índice, el tamaño y los indicadores de pila vacía y llena.

Compilación correcta con Java 21.0.10, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias. Se ejecutaron el ejemplo principal y una prueba independiente con 8 escenarios y 498 verificaciones aprobadas, 0 fallidas:

- Ejemplo principal de capacidad 3: estados vacío, parcial y lleno; consulta, overflow, retiros, underflow y reutilización posterior.
- Capacidad 1: transiciones vacío/lleno, consulta sin retirar y rechazo de operaciones inválidas.
- Alternancia: 20 rondas de inserciones y retiros, comprobando tamaños, valores e indicadores de estado.
- Valores negativos, cero, repetidos y extremos de `int`, retirados en orden LIFO.
- Cuatro capacidades inválidas: 0, -1, -10 e `Integer.MIN_VALUE`.

En el ejemplo principal, `peek()` devolvió 30 conservando el tamaño 3. `push(40)` lanzó `IllegalStateException` y la pila conservó 10, 20 y 30. Los retiros devolvieron 30, 20 y 10. Los intentos posteriores de `pop()` y `peek()` lanzaron `IllegalStateException`; el estado permaneció vacío, con `top = -1` y `size = 0`.

Las pruebas verificaron que `peek()` no modifica el tamaño, que las excepciones no alteran el estado lógico y que `isEmpty()`, `isFull()` y `size()` coinciden con el contenido. Las pruebas y compilados quedaron en un directorio temporal fuera del repositorio. Sin pendientes funcionales.

### Ejercicio 2 — Simulador de torre de platos

**Estrategia:** representar los platos mediante una clase auxiliar `PilaPlatos`, independiente del Ejercicio 1, con arreglo `int[]` de capacidad fija e índice `top` privado, inicialmente -1. El simulador muestra el contenido lógico desde la base hasta la cima y el plato superior.

**Justificación:** una torre sigue LIFO: se retira primero el último plato colocado arriba. FIFO retiraría el plato más antiguo, ubicado debajo de los demás, y no representa este comportamiento.

**Operaciones:** `push(int plato)` agrega arriba; `pop()` retira y devuelve el superior; `peek()` consulta sin eliminar. `isEmpty()`, `isFull()` y `size()` informan el estado y la cantidad de platos.

**Casos especiales:** overflow al agregar a una torre llena y underflow al retirar o consultar una torre vacía producen `IllegalStateException` antes de modificar la estructura. Las capacidades menores o iguales a cero producen `IllegalArgumentException`.

**Complejidad:** las seis operaciones tienen tiempo O(1) y espacio auxiliar O(1). El arreglo ocupa O(C), siendo C la capacidad fija. El constructor reserva e inicializa el arreglo en O(C). Mostrar el estado lógico cuesta O(size), fuera de las operaciones de la pila.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un simulador de torre de platos utilizando una pila implementada manualmente mediante un arreglo de enteros de tamaño fijo.

**Estructura elegida:** pila (Stack), siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** representar cada plato mediante un número entero y almacenarlo en un arreglo. Utilizar una variable `top`, inicialmente igual a -1, para identificar el plato que se encuentra en la parte superior de la torre. Agregar platos mediante `push()`, retirarlos mediante `pop()` y consultar el plato superior mediante `peek()`.

**Justificación:** una torre de platos funciona según el principio LIFO: el último plato colocado arriba debe ser el primero en retirarse. Una cola FIFO no representa correctamente este comportamiento porque retiraría primero el plato agregado más antiguamente, que está debajo de los demás.

**Operaciones:**
- Agregar plato: colocar un nuevo plato en la parte superior de la torre mediante `push(int plato)`.
- Retirar plato: retirar y devolver el plato superior mediante `pop()`.
- Consultar plato superior: obtener el plato que está arriba mediante `peek()`, sin retirarlo.
- Consultar si la torre está vacía mediante `isEmpty()`.
- Consultar si la torre está llena mediante `isFull()`.
- Consultar cantidad de platos mediante `size()`.

**Casos especiales:**
- Overflow: cuando se intenta agregar un plato a una torre llena, lanzar `IllegalStateException` sin modificar la estructura.
- Underflow: cuando se intenta retirar o consultar un plato de una torre vacía, lanzar `IllegalStateException` sin modificar la estructura.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.

**Complejidad:**
- Agregar, retirar, consultar el superior, verificar vacío o lleno y consultar tamaño: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija de la torre.
- Espacio auxiliar por operación: O(1).

**Requisitos:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio2.java`.
- Implementar una clase pública `Ejercicio2` con método `main`.
- Implementar una clase auxiliar para representar la pila de platos mediante `int[]`, evitando conflictos de nombres con la clase `PilaEnteros` del Ejercicio 1.
- La implementación debe ser independiente y no depender de otras clases de los ejercicios anteriores.
- Mantener privados el arreglo interno y el índice `top`.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- Mostrar mediante mensajes claros cuándo se agrega, retira o consulta un plato.
- Mostrar el estado lógico de la torre después de cada operación importante, identificando el plato que está arriba.
- Incorporar comentarios explicando por qué la torre utiliza LIFO y por qué no corresponde utilizar FIFO.
- Incluir un ejemplo principal con una torre de capacidad 3.
- Agregar los platos 10, 20 y 30, en ese orden.
- Verificar que `peek()` devuelva 30 y conserve el tamaño.
- Intentar agregar el plato 40 y comprobar el overflow.
- Retirar los platos y verificar que salgan en el orden 30, 20 y 10.
- Intentar retirar o consultar un plato cuando la torre esté vacía y comprobar el underflow.
- Verificar que las excepciones no modifiquen el estado.
- Probar torres de capacidad 1, alternancia entre agregar y retirar, platos repetidos, valores negativos, cero y extremos de `int`.
- Verificar que los platos almacenados no se pierdan ni se alteren y que el orden LIFO se mantenga.
- Compilar y ejecutar con Java 21 y `-Xlint:all`, realizando pruebas que verifiquen los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva íntegramente y esta circunstancia se registra también al final del archivo Java.

#### Resultado

Se implementó `Ejercicio2` con una clase auxiliar estática `PilaPlatos`, sin dependencia de otros ejercicios ni colecciones predefinidas. El `main` muestra mensajes de agregado, retiro y consulta, junto con el estado lógico y la identificación del plato superior después de cada operación importante.

Compilación correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias. Se verificaron la compilación independiente del Ejercicio 2 y la compilación conjunta con el Ejercicio 1, sin conflictos de clases.

Se ejecutó el `main` y una prueba independiente con 8 escenarios y 498 verificaciones aprobadas, 0 fallidas:

- Ejemplo principal de capacidad 3: torre vacía, parcial y llena, consulta, overflow, retiros, underflow y reutilización posterior.
- Torre de capacidad 1, con transiciones vacío/lleno y rechazo de operaciones inválidas.
- Veinte rondas alternando agregados y retiros, comprobando valores, tamaño e indicadores de estado.
- Platos repetidos, negativos, cero y extremos de `int`, verificando su conservación y retiro en orden LIFO.
- Cuatro capacidades inválidas: 0, -1, -10 e `Integer.MIN_VALUE`.

En el ejemplo, se agregaron 10, 20 y 30. `peek()` devolvió 30 y conservó el tamaño 3. El intento de agregar 40 produjo overflow y mantuvo los tres platos. Los retiros devolvieron 30, 20 y 10. Los intentos posteriores de retirar y consultar produjeron underflow, manteniendo la torre vacía. También se comprobó que `isEmpty()`, `isFull()` y `size()` coinciden con el estado real.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 3 — Validar paréntesis balanceados

**Estrategia:** recorrer la expresión de izquierda a derecha y guardar las aperturas en una pila manual `char[]`, administrada por `top`, inicialmente -1. Cada cierre retira una apertura; un cierre sin apertura devuelve inmediatamente `false`. Al terminar, la pila debe estar vacía.

**Justificación:** LIFO permite cerrar primero la última apertura pendiente y respetar los paréntesis anidados.

**Operaciones:** `push(char parentesis)` agrega una apertura verificando capacidad; `pop()` retira la última apertura; `isEmpty()` identifica cierres sin apertura y comprueba que no queden aperturas pendientes al finalizar. Cada operación cuesta O(1).

**Casos especiales:** cierres sin apertura y aperturas sin cierre producen `false`. Las cadenas vacías y sin paréntesis producen `true`. `null` genera `IllegalArgumentException`. Se ignoran todos los caracteres distintos de `(` y `)`, sin validar sintaxis matemática ni otros delimitadores. El arreglo de capacidad igual a la longitud admite también longitud cero.

**Complejidad:** tiempo O(n) y espacio auxiliar O(n). La reserva e inicialización del arreglo de longitud n también cuesta O(n), incluso cuando el recorrido finaliza anticipadamente. Las operaciones individuales de la pila utilizan O(1) de tiempo y espacio auxiliar.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que determine si los paréntesis de una expresión matemática están correctamente balanceados, utilizando una pila implementada manualmente mediante un arreglo de caracteres.

**Estructura elegida:** pila (Stack) de caracteres, que respeta el principio LIFO (Last In, First Out).

**Estrategia:** recorrer la expresión de izquierda a derecha, analizando sus caracteres. Cada vez que aparezca un paréntesis de apertura `(`, agregarlo a la pila mediante `push()`. Cuando aparezca un paréntesis de cierre `)`, retirar un paréntesis abierto mediante `pop()`. Si aparece un cierre cuando la pila está vacía, devolver inmediatamente `false`. Al finalizar el recorrido, devolver `true` solamente si la pila quedó vacía.

**Justificación:** el principio LIFO permite que cada paréntesis de cierre corresponda con el último paréntesis de apertura pendiente. Una pila resulta apropiada porque las aperturas anidadas deben cerrarse en el orden inverso al que se agregaron.

**Operaciones utilizadas:**
- `push(char parentesis)`: almacenar un paréntesis de apertura.
- `pop()`: retirar la apertura correspondiente cuando se encuentra un cierre.
- `isEmpty()`: comprobar si existen aperturas pendientes de cerrar.

**Casos especiales:**
- Un cierre `)` cuando la pila está vacía indica una expresión inválida.
- Si al finalizar quedan aperturas en la pila, la expresión es inválida.
- Si no quedan aperturas pendientes, la expresión es válida.
- Una expresión vacía se considera balanceada.
- Una expresión sin paréntesis se considera balanceada.
- Una entrada `null` debe rechazarse mediante `IllegalArgumentException`.
- El programa debe evaluar exclusivamente los paréntesis redondos `(` y `)`, tal como solicita la consigna. No necesita validar la sintaxis matemática ni otros tipos de delimitadores.

**Complejidad:**
- Tiempo: O(n), porque cada carácter se analiza una sola vez.
- Espacio auxiliar: O(n) en el peor caso, debido al arreglo utilizado para almacenar paréntesis abiertos.
- Las operaciones individuales `push()`, `pop()` e `isEmpty()` deben ejecutarse en O(1).

**Requisitos:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio3.java`.
- Implementar una clase pública `Ejercicio3` con un método `main`.
- Implementar un método `validarParentesis(String expresion)` que devuelva `boolean`.
- Implementar manualmente una pila auxiliar mediante `char[]` y una variable `top`, inicialmente igual a -1.
- La capacidad de la pila puede determinarse a partir de la longitud de la expresión, permitiendo también el caso de longitud cero.
- Incrementar `top` al agregar una apertura y disminuirlo al retirar una apertura.
- Evitar desbordamientos verificando los límites del arreglo antes de agregar elementos.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- No utilizar métodos de validación de paréntesis predefinidos.
- Ignorar los caracteres que no sean `(` o `)`, como números, espacios y operadores.
- Incluir comentarios que expliquen el principio LIFO, el uso del arreglo y de `top`, los casos inválidos y la comprobación final de pila vacía.
- Mostrar cada expresión evaluada y si sus paréntesis están balanceados.

**Ejemplos principales:**
1. `(5 + 3) * (2 + 1)` debe ser válida.
2. `(5 + 3)) * (2 + 1` debe ser inválida.
3. `((2 + 3) * (4 - 1))` debe ser válida.
4. `((5 + 3)` debe ser inválida.
5. `5 + 3` debe ser válida.
6. La cadena vacía debe ser válida.

**Pruebas adicionales:**
- Un único paréntesis de apertura.
- Un único paréntesis de cierre.
- Varios paréntesis anidados correctamente.
- Varios pares de paréntesis consecutivos.
- Más cierres que aperturas.
- Más aperturas que cierres.
- Un cierre que aparece antes de una apertura, como `)(`.
- Expresiones largas con anidamiento.
- Expresiones con letras, espacios y operadores.
- Entrada `null`, verificando la excepción esperada.

Comprobar que todas las expresiones válidas devuelvan `true` y todas las inválidas devuelvan `false`.

Compilar y ejecutar con Java 21 y `-Xlint:all`, documentando las pruebas realmente realizadas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se indica también al final del archivo Java.

#### Resultado

Se implementaron `validarParentesis(String expresion)`, una pila auxiliar privada `PilaParentesis` y un `main` con ejemplos. La pila utiliza exclusivamente un arreglo de caracteres e índice `top`, sin colecciones predefinidas.

Compilación conjunta de los ejercicios 1, 2 y 3 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos de clases. Se ejecutó el `main` y una prueba independiente con 23 casos aprobados y 0 fallidos: 22 expresiones con resultado esperado verificado y el rechazo de `null` mediante `IllegalArgumentException`.

| Expresión principal | Resultado observado |
|---|---|
| `(5 + 3) * (2 + 1)` | `true` |
| `(5 + 3)) * (2 + 1` | `false` |
| `((2 + 3) * (4 - 1))` | `true` |
| `((5 + 3)` | `false` |
| `5 + 3` | `true` |
| Cadena vacía | `true` |

También se comprobaron aperturas y cierres aislados, anidamiento, pares consecutivos, exceso de aperturas o cierres, `)(`, letras y operadores, espacios y otros delimitadores ignorados. `([)]` devolvió `true` porque únicamente se evalúan los paréntesis redondos, conforme a la consigna. Las pruebas largas incluyeron 10 000 aperturas y 10 000 cierres correctamente balanceados, una cadena con un cierre faltante y otra con un cierre inicial sin apertura.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 4 — Historial de navegación

**Estrategia:** administrar las URLs con una clase auxiliar independiente `HistorialNavegacion`, un arreglo privado `String[]` de capacidad fija y un índice privado `top`, inicialmente -1. Las visitas agregan al tope y los retrocesos retiran la página actual y consultan la anterior.

**Justificación:** LIFO permite abandonar primero la última página visitada y recuperar las anteriores en orden inverso. No se implementa navegación hacia adelante.

**Operaciones:** `visitar(String url)` valida y agrega mediante `push`; `volverAtras()` verifica que haya al menos dos páginas, retira mediante `pop` y devuelve la anterior mediante `peek`; `paginaActual()` consulta sin eliminar. `isEmpty()`, `isFull()` y `size()` informan el estado. `vaciarHistorial()` reinicia el índice lógico a -1.

**Casos especiales:** consultar un historial vacío, retroceder con cero o una página y visitar un historial lleno producen `IllegalStateException`, conservando el estado. Las URLs nulas, vacías o compuestas únicamente por espacios se rechazan mediante `IllegalArgumentException`, al igual que las capacidades no positivas. Vaciar un historial ya vacío está permitido.

**Complejidad:** las operaciones de pila, consultas y retrocesos tienen tiempo y espacio auxiliar O(1). El reinicio lógico también es O(1), sin recorrer ni limpiar todo el arreglo; las referencias fuera del segmento lógico dejan de formar parte del historial. El almacenamiento ocupa O(C) y su inicialización cuesta O(C). La inserción de una referencia cuesta O(1), pero `visitar` completo tiene peor caso O(L) por la validación de una URL de longitud L mediante `isBlank()`, con espacio auxiliar O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un simulador simple del historial de navegación de un navegador web, utilizando una pila de URLs construida manualmente mediante un arreglo de cadenas String de tamaño fijo.

**Estructura elegida:** pila (Stack) de URLs, siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** representar cada página visitada mediante su URL y almacenarla en un arreglo `String[]`. Utilizar una variable `top`, inicialmente igual a -1, para identificar la última página visitada. Cada nueva visita agrega una URL mediante `push()`. Para volver a la página anterior, retirar la página actual mediante `pop()` y consultar la nueva página del tope mediante `peek()`.

**Justificación:** el historial de navegación funciona bajo el principio LIFO porque, al retroceder, primero abandonamos la página visitada más recientemente. Una pila permite recuperar las páginas en orden inverso al de sus visitas.

**Operaciones:**
- `visitar(String url)`: agregar una nueva página al historial mediante `push()`.
- `volverAtras()`: retirar la página actual mediante `pop()` y devolver la URL de la página anterior mediante `peek()`.
- `paginaActual()`: consultar la URL en el tope sin modificar la estructura.
- `isEmpty()`: indicar si no hay páginas visitadas.
- `isFull()`: indicar si el historial alcanzó su capacidad máxima.
- `size()`: devolver la cantidad de páginas almacenadas.
- `vaciarHistorial()`: dejar el historial vacío para permitir una nueva secuencia de navegación.

**Casos especiales:**
- Historial vacío: no existe una página actual ni es posible retroceder.
- Una sola página: no se puede volver atrás porque no existe una página anterior.
- Historial lleno: si se intenta visitar una nueva página, debe producirse overflow.
- URLs inválidas: rechazar entradas `null`, vacías o compuestas únicamente por espacios mediante `IllegalArgumentException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Ante operaciones inválidas, conservar íntegramente el estado anterior del historial.

**Política de errores:**
- `paginaActual()` sobre un historial vacío debe lanzar `IllegalStateException`.
- `volverAtras()` con cero o una página debe lanzar `IllegalStateException`.
- `visitar()` sobre un historial lleno debe lanzar `IllegalStateException`.
- `vaciarHistorial()` puede ejecutarse incluso cuando el historial ya esté vacío.

**Complejidad:**
- `visitar`, `volverAtras`, `paginaActual`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- `vaciarHistorial`: O(1) si solamente reinicia el índice lógico `top`.
- Espacio del arreglo interno: O(C), siendo C la capacidad fija del historial.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio4.java`.
- Implementar una clase pública `Ejercicio4` con método `main`.
- Implementar una clase auxiliar propia para administrar el historial mediante `String[]` y `top`, evitando conflictos de nombres con las clases de los ejercicios anteriores.
- Mantener privados el arreglo y el índice `top`.
- No depender de las clases de otros ejercicios.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar el historial.
- No implementar funcionalidades adicionales no solicitadas, como navegación hacia adelante o manejo de pestañas.
- Incorporar comentarios que expliquen la relación entre el historial y LIFO, el funcionamiento de `push`, `pop` y `peek`, y las validaciones.
- Mostrar las URLs visitadas, la página actual y los retrocesos realizados.
- Mostrar mensajes claros cuando una operación no puede efectuarse.

**Ejemplo principal:**
1. Crear un historial con capacidad 3.
2. Visitar `google.com`.
3. Visitar `youtube.com`.
4. Visitar `github.com`.
5. Consultar la página actual: debe ser `github.com`.
6. Intentar visitar `stackoverflow.com`: debe producir overflow.
7. Volver atrás: debe devolver `youtube.com`.
8. Volver atrás nuevamente: debe devolver `google.com`.
9. Intentar volver atrás por tercera vez: debe producir underflow lógico porque no hay una página anterior.
10. Vaciar el historial y comprobar que queda vacío.
11. Intentar consultar la página actual sobre el historial vacío: debe producir `IllegalStateException`.

**Pruebas adicionales:**
- Historial de capacidad 1.
- Visitas y retrocesos alternados.
- URLs repetidas.
- Comprobación de que consultar la página actual no elimina elementos.
- Comprobación del orden LIFO.
- Comprobación de que overflow y retrocesos inválidos no alteran el historial.
- Rechazo de URLs nulas, vacías y con espacios.
- Rechazo de capacidades inválidas.
- Comprobación de que es posible volver a visitar páginas después de retroceder.
- Comprobación de que `vaciarHistorial()` reinicia el estado lógico.

Compilar y ejecutar con Java 21 utilizando `-Xlint:all`, verificando el funcionamiento mediante pruebas reales y documentando sus resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No se modificaron el prompt literal ni el algoritmo. Se aclaró el costo de validar URLs: O(1) corresponde a la inserción en la pila, mientras que verificar si una cadena contiene únicamente espacios requiere O(L) en el peor caso. Esta precisión también se registra al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio4`, la clase auxiliar estática `HistorialNavegacion`, las siete operaciones solicitadas y los auxiliares privados `push`, `pop` y `peek`, sin dependencia de otros ejercicios ni colecciones predefinidas.

Compilación conjunta de los ejercicios 1, 2, 3 y 4 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos de nombres. Se ejecutaron el `main` y una prueba independiente: 360 verificaciones aprobadas y 0 fallidas.

Secuencia principal observada:

1. Visitas a `google.com`, `youtube.com` y `github.com`; página actual `github.com`, tamaño 3.
2. Visita a `stackoverflow.com` rechazada por overflow, conservando las tres páginas.
3. Primer retroceso: `youtube.com`, tamaño 2.
4. Segundo retroceso: `google.com`, tamaño 1.
5. Tercer retroceso rechazado mediante `IllegalStateException`, conservando `google.com`.
6. Vaciado: tamaño 0, historial vacío.
7. Consulta de página actual rechazada mediante `IllegalStateException`.

También se verificaron capacidad 1, veinte rondas de visitas y retrocesos alternados, URLs repetidas, consulta sin eliminación, visitas después de retroceder y reutilización después de vaciar. Se rechazaron URLs nulas, vacías, de espacios y de tabulación/salto de línea; se verificó el rechazo sin cambios también estando lleno. Se rechazaron capacidades 0, -1 e `Integer.MIN_VALUE`. Se comprobaron el orden LIFO, la conservación de las páginas anteriores y los indicadores de estado después de las operaciones y errores.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes funcionales ni pendientes.

### Ejercicio 5 — Implementar una pila genérica

**Estrategia:** implementar una clase estática anidada `Pila<T>` con arreglo privado `Object[]` de capacidad fija y un índice privado `top`, inicialmente -1. Las conversiones a `T` se limitan a variables locales de `pop` y `peek`, con `@SuppressWarnings("unchecked")` aplicado únicamente a esas declaraciones. Son seguras con uso genérico tipado porque solamente `push(T)` escribe en el arreglo encapsulado.

**Justificación:** los genéricos permiten reutilizar la estructura para `Integer`, `String` y objetos propios, con comprobaciones de tipos durante la compilación, sin duplicar la implementación para cada tipo.

**Operaciones:** `push(T elemento)` agrega al tope; `pop()` retira y devuelve el último elemento, limpiando la celda con `null`; `peek()` consulta sin retirar. `isEmpty()` comprueba `top == -1`, `isFull()` comprueba el límite de capacidad y `size()` devuelve `top + 1`.

**Casos especiales:** overflow y underflow producen `IllegalStateException` antes de modificar el estado. Las capacidades no positivas y `push(null)` producen `IllegalArgumentException`. Se admiten elementos repetidos y cadenas vacías. Se valida el elemento nulo antes de comprobar si la pila está llena.

**Complejidad:** las seis operaciones tienen tiempo y espacio auxiliar O(1). El arreglo ocupa O(C), siendo C la capacidad fija, y su inicialización cuesta O(C). Mostrar el contenido lógico requiere O(size) iteraciones, además del costo de representar los elementos como texto.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una pila genérica `Pila<T>` utilizando un arreglo de tamaño fijo, capaz de almacenar diferentes tipos de datos, como `Integer`, `String` y objetos definidos por el usuario.

**Estructura elegida:** pila genérica implementada manualmente mediante un arreglo, siguiendo el principio LIFO (Last In, First Out).

**Estrategia:** utilizar una clase parametrizada `Pila<T>` para definir una estructura que pueda almacenar elementos de distintos tipos sin duplicar su implementación. Internamente, utilizar un arreglo `Object[]` de capacidad fija y una variable entera `top`, inicializada en -1. Los elementos deben agregarse, retirarse y consultarse exclusivamente por el extremo superior.

**Justificación:** una pila limitada a `int` solo permite almacenar enteros primitivos. El uso de genéricos permite reutilizar la misma estructura para números, textos y objetos, manteniendo comprobaciones de tipos durante la compilación y evitando crear una clase diferente para cada tipo de dato.

**Operaciones requeridas:**
- `push(T elemento)`: agregar un elemento al tope de la pila.
- `pop()`: retirar y devolver el elemento del tope.
- `peek()`: consultar el elemento superior sin retirarlo.
- `isEmpty()`: indicar si la pila está vacía.
- `isFull()`: indicar si se alcanzó la capacidad máxima.
- `size()`: devolver la cantidad de elementos almacenados.

**Manejo del arreglo interno:**
- Crear el almacenamiento mediante `new Object[capacidad]`, porque Java no permite crear directamente un arreglo con `new T[capacidad]`.
- Realizar las conversiones necesarias de `Object` a `T` únicamente dentro de la implementación de la pila.
- Si se utiliza `@SuppressWarnings("unchecked")`, aplicarlo exclusivamente a los métodos o expresiones que lo requieran y explicar por qué la conversión es segura.
- Mantener el arreglo encapsulado, sin exponerlo al código que utiliza la pila.
- Al ejecutar `pop()`, limpiar la posición liberada asignándole `null` para evitar conservar referencias innecesarias.

**Casos especiales:**
- Overflow: `push()` sobre una pila llena debe lanzar `IllegalStateException` sin modificar el estado.
- Underflow: `pop()` o `peek()` sobre una pila vacía deben lanzar `IllegalStateException` sin modificar el estado.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Elemento nulo: para mantener una política clara y evitar ambigüedades, rechazar `push(null)` mediante `IllegalArgumentException`, sin modificar la pila.
- Permitir elementos repetidos.

**Complejidad:**
- `push`, `pop`, `peek`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio5.java`.
- Implementar una clase pública `Ejercicio5` con un método `main`.
- Implementar una clase genérica `Pila<T>` de forma independiente, preferentemente como clase estática anidada en `Ejercicio5` para evitar conflictos de nombres con otros ejercicios.
- Utilizar exclusivamente un arreglo como estructura interna de almacenamiento.
- Mantener privados el arreglo y el índice `top`.
- Implementar manualmente las seis operaciones.
- No utilizar `Stack`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la pila.
- Incorporar comentarios explicando el principio LIFO, la variable `top`, los genéricos, el arreglo `Object[]` y las conversiones controladas.
- Mostrar por pantalla el contenido lógico de la pila y los resultados de las operaciones.
- No depender de clases implementadas en otros ejercicios.

**Ejemplo principal con Integer:**
1. Crear `Pila<Integer>` de capacidad 3.
2. Ejecutar `push(10)`, `push(20)` y `push(30)`.
3. Comprobar que `peek()` devuelve 30 sin alterar el tamaño.
4. Retirar los elementos mediante `pop()` y verificar el orden 30, 20 y 10.

**Ejemplo con String:**
1. Crear `Pila<String>` de capacidad 3.
2. Agregar `"Ana"`, `"Juan"` y `"Lucia"`.
3. Verificar que los elementos se retiran en orden `"Lucia"`, `"Juan"` y `"Ana"`.

**Ejemplo con objetos:**
1. Crear una clase sencilla `Producto` con nombre y precio.
2. Crear `Pila<Producto>` de capacidad 3.
3. Agregar tres productos diferentes.
4. Verificar que `peek()` y `pop()` devuelvan los objetos correctos, respetando el orden LIFO.
5. Comprobar que el producto mantiene asociados su nombre y precio.

**Pruebas adicionales:**
- Pilas vacías y completamente llenas.
- Capacidad 1.
- Alternancia de `push` y `pop`.
- Elementos repetidos.
- Enteros negativos, cero y extremos de `int` mediante `Integer`.
- Cadenas vacías, si se desea almacenarlas como elementos válidos.
- Comprobar `isEmpty`, `isFull` y `size`.
- Verificar que `peek()` no modifica el estado.
- Verificar que overflow y underflow no alteran la pila.
- Rechazar capacidades inválidas y elementos nulos.
- Comprobar que las pilas de distintos tipos funcionan de manera independiente.
- Comprobar que no existan errores de tipos en tiempo de ejecución durante los casos válidos.

Compilar y ejecutar con Java 21 utilizando `-Xlint:all`, verificando los resultados y documentando las pruebas realmente realizadas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original permanece literal y esta circunstancia se registra al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio5`, la pila genérica anidada `Pila<T>` y una clase anidada `Producto` con nombre, precio y métodos de consulta. El `main` muestra contenido lógico, consultas y retiros para tres tipos, sin depender de otros ejercicios ni colecciones predefinidas.

Compilación individual y conjunta de los ejercicios 1 al 5 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 1319 verificaciones aprobadas y 0 fallidas.

Resultados de los ejemplos:

| Tipo | Orden de retiro |
|---|---|
| `Integer` | 30, 20, 10 |
| `String` | Lucia, Juan, Ana |
| `Producto` | Regla ($800), Lapiz ($500), Cuaderno ($2500) |

`peek()` devolvió respectivamente 30, Lucia y el objeto Regla, sin alterar el tamaño. Las pruebas comprobaron identidad de los objetos retirados y la conservación del nombre y precio de cada producto.

Se probaron seis conjuntos de datos: enteros principales, nombres principales, productos, enteros negativos/cero/repetidos/extremos, cadenas vacías y repetidas, y capacidad 1. En cada conjunto se verificaron estados vacíos y llenos, consultas sin cambios, overflow, underflow, rechazo de nulos incluso estando lleno y veinte rondas alternadas de inserción/retiro. Se comprobó mediante inspección del arreglo privado en la prueba temporal que cada posición liberada por `pop()` queda en `null`. También se verificaron independencia entre pilas de distintos tipos y rechazo de capacidades 0, -1 e `Integer.MIN_VALUE`.

Todos los casos válidos finalizaron sin errores de tipos en tiempo de ejecución. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 6 — Implementar una cola simple de enteros

**Estrategia:** implementar una clase estática anidada `ColaEnteros` con arreglo privado `int[]`, índices privados `front = 0` y `rear = -1`, y contador privado `cantidad = 0`. Los índices avanzan hacia la derecha, sin desplazamientos, módulo ni reinicios automáticos.

**Justificación:** FIFO retira los elementos en el orden de ingreso, a diferencia de LIFO, que retiraría primero el último agregado. Los índices permiten localizar ambos extremos directamente.

**Operaciones:** `enqueue(int valor)` incrementa `rear`, almacena el valor y aumenta la cantidad; `dequeue()` devuelve el elemento de `front`, avanza ese índice y disminuye la cantidad; `front()` consulta sin retirar. `isEmpty()` comprueba cantidad cero; `isFull()` comprueba que `rear` llegó a la última posición, y `size()` devuelve la cantidad activa.

**Casos especiales:** overflow cuando se agotaron las posiciones de inserción; underflow al retirar o consultar sin elementos. Ambos producen `IllegalStateException` sin cambiar el estado. Capacidades no positivas producen `IllegalArgumentException`. Las posiciones liberadas no se reutilizan; por ello `isEmpty()` e `isFull()` pueden ser simultáneamente verdaderos.

**Complejidad:** las seis operaciones tienen tiempo y espacio auxiliar O(1). El arreglo ocupa O(C), siendo C la capacidad fija; su inicialización cuesta O(C). Mostrar el contenido lógico requiere O(size) iteraciones, fuera del costo de las operaciones de la cola.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una clase `ColaEnteros` utilizando un arreglo de enteros de tamaño fijo, que permita agregar, retirar y consultar elementos respetando el principio FIFO.

**Estructura elegida:** cola simple o lineal (Queue), implementada manualmente mediante `int[]`.

**Estrategia:** utilizar un arreglo interno de capacidad fija y dos índices: `front`, que identifica el primer elemento disponible, y `rear`, que identifica la última posición utilizada para insertar. Inicializar `front = 0`, `rear = -1` y `cantidad = 0`. Agregar elementos por el extremo posterior y retirarlos por el extremo anterior, sin desplazar los elementos restantes.

**Justificación:** una cola sigue el principio FIFO (First In, First Out), por lo que los elementos deben retirarse en el mismo orden en que ingresaron. Los índices `front` y `rear` permiten administrar esta regla sin recorrer el arreglo en cada operación.

**Operaciones requeridas:**
- `enqueue(int valor)`: agregar el elemento al final de la cola, incrementando `rear` y almacenando el valor.
- `dequeue()`: retirar y devolver el elemento que está en `front`, incrementando `front` y disminuyendo `cantidad`.
- `front()`: consultar y devolver el primer elemento sin retirarlo.
- `isEmpty()`: devolver `true` cuando `cantidad == 0`.
- `isFull()`: devolver `true` cuando `rear == capacidad - 1`, porque se agotaron las posiciones disponibles al final de esta cola lineal.
- `size()`: devolver la cantidad de elementos activos almacenados.

**Manejo de índices y espacio:**
- Esta implementación debe ser estrictamente lineal, NO circular.
- Los índices avanzan solamente hacia la derecha.
- No utilizar el operador módulo `%` para mover `front` o `rear`.
- No desplazar elementos hacia el inicio después de ejecutar `dequeue()`.
- No reiniciar automáticamente `front` ni `rear` cuando la cola quede vacía, porque el objetivo es observar la limitación de reutilización de espacio de una cola simple.
- Diferenciar correctamente una cola vacía de una cola con espacio disponible al final: `isEmpty()` puede ser `true` al mismo tiempo que `isFull()` si el arreglo ya agotó sus posiciones de inserción.
- Cuando se hayan utilizado todas las posiciones del arreglo, nuevos intentos de `enqueue()` deben producir overflow aunque existan posiciones liberadas al comienzo.

**Casos especiales:**
- Overflow: intentar `enqueue()` cuando `rear` ya está en la última posición debe lanzar `IllegalStateException` sin modificar la estructura.
- Underflow: intentar `dequeue()` o `front()` cuando `cantidad == 0` debe lanzar `IllegalStateException` sin modificar el estado.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Permitir valores negativos, cero, repetidos y extremos de `int`.

**Complejidad:**
- `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija del arreglo.
- Espacio auxiliar por operación: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio6.java`.
- Implementar una clase `ColaEnteros` con constructor que reciba una capacidad fija.
- Implementar `ColaEnteros` como clase auxiliar propia de `Ejercicio6` para evitar conflictos con otros ejercicios.
- Implementar una clase pública `Ejercicio6` con método `main`.
- Mantener privados el arreglo, los índices y el contador de elementos.
- Implementar manualmente las seis operaciones solicitadas.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- Incorporar comentarios que expliquen FIFO, la función de `front` y `rear`, la diferencia entre consultar y retirar, y los casos de overflow y underflow.
- Mostrar el contenido lógico de la cola y el valor de los índices después de las operaciones importantes.
- Mostrar también, cuando corresponda, las posiciones físicas liberadas al comienzo del arreglo.
- No depender de clases de ejercicios anteriores.

**Ejemplo principal:**

Crear una cola de capacidad 5 y ejecutar:

1. Mostrar el estado inicial: `front = 0`, `rear = -1`, `size = 0`.
2. Ejecutar `enqueue(10)`.
3. Ejecutar `enqueue(20)`.
4. Ejecutar `enqueue(30)`.
5. Consultar `front()`: debe devolver 10 sin modificar la cantidad de elementos.
6. Ejecutar `dequeue()`: debe devolver 10.
7. Comprobar que `front()` ahora devuelve 20.
8. Ejecutar `enqueue(40)`.
9. Ejecutar `enqueue(50)`.
10. Comprobar que la cola lógica contiene `{20, 30, 40, 50}`, con `front = 1` y `rear = 4`.
11. Intentar `enqueue(60)`: debe producir overflow, aunque la posición 0 esté liberada.
12. Retirar los elementos restantes en orden 20, 30, 40 y 50.
13. Comprobar que la cola queda vacía y `size()` devuelve 0.
14. Intentar `dequeue()` y `front()` sobre la cola vacía: deben producir underflow.
15. Comprobar que, al no reiniciar los índices, un nuevo `enqueue(70)` continúa rechazándose porque `rear` llegó al final del arreglo. Explicar que este comportamiento representa la limitación de la cola lineal y que se resolverá con una cola circular.

**Pruebas adicionales:**
- Cola de capacidad 1.
- Cola recién creada.
- Cola parcialmente ocupada.
- Cola con todas las posiciones de inserción utilizadas.
- Secuencias alternadas de `enqueue` y `dequeue`.
- Valores negativos, cero, repetidos y extremos de `int`.
- Verificar que `front()` no modifica la cola.
- Verificar que `dequeue()` respeta estrictamente FIFO.
- Verificar que `size()` refleja únicamente los elementos activos.
- Verificar que overflow y underflow no alteran el estado.
- Verificar que las posiciones liberadas al inicio no se reutilizan.
- Verificar el rechazo de capacidades inválidas.

Compilar y ejecutar con Java 21 y `-Xlint:all`, realizando pruebas reales y documentando sus resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esta circunstancia se registra al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio6`, la clase auxiliar independiente `ColaEnteros` y las seis operaciones requeridas. El `main` muestra contenido lógico, índices, cantidad e indicadores de estado, además del intervalo de posiciones físicas liberadas al comienzo.

Compilación individual y conjunta de los ejercicios 1 al 6 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos de clases. Se ejecutaron el `main` y una prueba independiente con 438 verificaciones aprobadas y 0 fallidas.

| Momento del ejemplo principal | Contenido lógico | front | rear | size |
|---|---|---:|---:|---:|
| Inicial | `{}` | 0 | -1 | 0 |
| Insertar 10, 20 y 30 | `{10, 20, 30}` | 0 | 2 | 3 |
| Retirar 10 | `{20, 30}` | 1 | 2 | 2 |
| Insertar 40 y 50 | `{20, 30, 40, 50}` | 1 | 4 | 4 |
| Intentar insertar 60 | `{20, 30, 40, 50}` | 1 | 4 | 4 |
| Retirar 20, 30, 40 y 50 | `{}` | 5 | 4 | 0 |
| Intentar insertar 70 | `{}` | 5 | 4 | 0 |

La consulta inicial devolvió 10 sin modificar el estado, y después del primer retiro devolvió 20. El orden completo de retiro fue 10, 20, 30, 40 y 50. Insertar 60 produjo overflow pese a tener la posición 0 liberada. Al terminar, `dequeue()` y `front()` produjeron underflow; insertar 70 siguió produciendo overflow. Los errores conservaron el estado. La cola quedó vacía y sin posiciones disponibles al final; una cola circular permitiría reutilizar el espacio, pero no se implementa en este ejercicio.

También se probaron capacidad 1, cola recién creada, ocupación parcial, agotamiento de posiciones, veinte rondas alternadas de inserción/retiro, negativos, cero, repetidos y extremos de `int`. Se verificaron el orden FIFO, consultas sin modificación, tamaño activo, conservación de valores e índices sin reinicios mediante inspección en la prueba temporal. Se rechazaron capacidades 0, -1 e `Integer.MIN_VALUE`.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 7 — Sistema de turnos para atención

**Estrategia:** implementar las clases anidadas `Turno` y `SistemaTurnos`, con arreglo privado `Turno[]`, índices `front = 0` y `rear = -1` y contador `cantidad = 0`. Las llegadas insertan al final y las atenciones retiran al frente. Los números correlativos comienzan en 1 y se confirman solamente después de insertar correctamente.

**Justificación:** FIFO respeta el orden de llegada; una pila LIFO favorecería a quienes llegaron más recientemente. Cada objeto mantiene asociados su número original y su nombre.

**Operaciones:** `agregarPersona(String nombre)` valida el nombre, crea el turno y lo inserta mediante `enqueue`, devolviendo el turno asignado; `atenderSiguiente()` devuelve el turno retirado mediante `dequeue`; `consultarPrimero()` consulta sin retirar. `isEmpty()`, `isFull()` y `size()` informan el estado. Al retirar se limpia la referencia almacenada.

**Casos especiales:** atender o consultar sin personas produce underflow; insertar después de agotar las posiciones produce overflow. Se utiliza `IllegalStateException`. Nombres nulos, vacíos o compuestos solo por espacios y capacidades no positivas producen `IllegalArgumentException`. Los errores no alteran el contenido, los índices, la cantidad ni la numeración. Se permiten nombres repetidos. La cola es lineal: no reutiliza posiciones ni reinicia índices, incluso cuando queda vacía.

**Complejidad:** inserción física, atención, consulta e indicadores de estado tienen tiempo O(1). La validación del nombre cuesta O(L) en el peor caso, siendo L su longitud; por ello `agregarPersona` completo tiene peor caso O(L). Espacio de almacenamiento O(C), con inicialización del arreglo O(C). Espacio auxiliar por operación O(1), sin contar los objetos de turno almacenados.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un sistema de turnos para una oficina, utilizando una cola de capacidad fija implementada manualmente mediante un arreglo.

**Estructura elegida:** cola simple o lineal (Queue), siguiendo el principio FIFO (First In, First Out).

**Estrategia:** representar cada turno mediante un objeto que contenga el nombre de la persona y su número de turno. Administrar los turnos mediante una cola implementada con un arreglo interno, utilizando índices `front` y `rear` y un contador `cantidad`. Cada persona que llega recibe un número correlativo y se agrega al final. Cuando se atiende a alguien, se retira a la persona que se encuentra al frente de la cola.

**Justificación:** un sistema de atención debe respetar el orden de llegada. FIFO permite que la primera persona que solicita un turno sea la primera en recibir atención. Utilizar una pila LIFO invertiría el orden y favorecería a las personas que llegaron más recientemente.

**Representación de los turnos:**
- Cada turno debe almacenar el número asignado y el nombre de la persona.
- Los números deben asignarse de forma correlativa, comenzando desde 1.
- Cada turno debe conservar su número original hasta ser atendido.
- La asignación de un número debe completarse solamente cuando el turno se agregue correctamente a la cola.

**Operaciones:**
- `agregarPersona(String nombre)`: validar el nombre, asignar el siguiente número disponible y agregar el turno al final mediante `enqueue`.
- `atenderSiguiente()`: retirar mediante `dequeue` y devolver el turno de la primera persona que llegó.
- `consultarPrimero()`: devolver el turno que se encuentra al frente sin retirarlo.
- `isEmpty()`: indicar si no quedan personas esperando.
- `isFull()`: indicar si se agotaron las posiciones de inserción de la cola lineal.
- `size()`: devolver la cantidad de personas esperando.

**Manejo del arreglo:**
- Utilizar un arreglo de objetos `Turno[]` de tamaño fijo.
- Inicializar `front = 0`, `rear = -1` y `cantidad = 0`.
- Avanzar `rear` al insertar y `front` al retirar.
- No desplazar los elementos después de atender a una persona.
- No utilizar una implementación circular ni el operador módulo para administrar los índices.
- No reutilizar posiciones liberadas al principio del arreglo.
- No reiniciar los índices cuando la cola quede vacía.
- Considerar que la cola puede estar vacía y, al mismo tiempo, no admitir nuevas inserciones si `rear` llegó al final del arreglo.
- Limpiar la referencia de cada turno retirado para evitar conservar objetos innecesariamente en memoria.

**Casos especiales:**
- Oficina sin personas: intentar atender o consultar el primer turno debe producir underflow mediante `IllegalStateException`.
- Cola llena: intentar agregar otra persona cuando `rear` llegó al final debe producir overflow mediante `IllegalStateException`.
- Nombre inválido: rechazar nombres nulos, vacíos o compuestos únicamente por espacios mediante `IllegalArgumentException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Las operaciones inválidas no deben modificar la cola ni consumir números de turno.
- Permitir nombres repetidos porque diferentes personas pueden tener el mismo nombre.

**Complejidad:**
- Inserción física mediante `enqueue`: O(1).
- Atención mediante `dequeue`: O(1).
- Consulta del primer turno: O(1).
- `isEmpty`, `isFull` y `size`: O(1).
- Validación de nombres: O(L), donde L es la longitud del nombre.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija de la cola.
- Espacio auxiliar por operación: O(1), sin contar los objetos de turno almacenados.

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio7.java`.
- Implementar una clase pública `Ejercicio7` con método `main`.
- Implementar una clase simple `Turno`, con número y nombre de la persona.
- Implementar una clase auxiliar para administrar los turnos mediante `Turno[]`, `front`, `rear` y `cantidad`.
- Utilizar clases anidadas en `Ejercicio7` para evitar conflictos de nombres con los demás ejercicios.
- Mantener privados los atributos internos.
- No depender de las clases de otros ejercicios.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- Incorporar comentarios explicando FIFO, los índices, la asignación correlativa de turnos y las validaciones.
- Mostrar en consola cuándo llega una persona, qué turno recibe, quién está primero y quién es atendido.
- Mostrar la cantidad de personas esperando después de las operaciones relevantes.
- Verificar que consultar el primer turno no lo elimine.

**Ejemplo principal:**
1. Crear un sistema con capacidad 4.
2. Agregar a Ana y asignarle el turno 1.
3. Agregar a Pedro y asignarle el turno 2.
4. Agregar a Lucia y asignarle el turno 3.
5. Consultar quién está primero: debe ser Ana, turno 1.
6. Atender a Ana y verificar que ahora el primero sea Pedro.
7. Agregar a Martin y asignarle el turno 4.
8. Atender a Pedro, Lucia y Martin, en ese orden.
9. Comprobar que la cola queda vacía.
10. Intentar atender nuevamente: debe producir underflow.
11. Intentar agregar una quinta persona: debe producir overflow porque la cola lineal agotó sus posiciones, aunque esté vacía.

**Pruebas adicionales:**
- Sistema de capacidad 1.
- Cola inicialmente vacía.
- Cola parcialmente ocupada.
- Alternancia de llegadas y atenciones.
- Personas con nombres repetidos.
- Consultar el primer turno sin modificar la cantidad.
- Verificar que los turnos se asignen correlativamente.
- Verificar que una operación rechazada no consuma un número de turno.
- Rechazar nombres nulos, vacíos y compuestos por espacios.
- Rechazar capacidades inválidas.
- Verificar el agotamiento de posiciones de la cola lineal.
- Verificar que las personas sean atendidas estrictamente en orden FIFO.
- Verificar que overflow y underflow no alteren el estado.

Compilar y ejecutar con Java 21 y `-Xlint:all`, documentando las pruebas realmente realizadas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial permanece literal y esta circunstancia se registra al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio7`, las clases anidadas `Turno` y `SistemaTurnos` y las seis operaciones solicitadas, sin dependencia de otros ejercicios ni colecciones predefinidas.

Compilación individual y conjunta de los ejercicios 1 al 7 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos de nombres. Se ejecutaron el `main` y una prueba independiente con 969 verificaciones aprobadas y 0 fallidas.

| Persona | Turno asignado | Orden de atención |
|---|---:|---:|
| Ana | 1 | 1 |
| Pedro | 2 | 2 |
| Lucia | 3 | 3 |
| Martin | 4 | 4 |

La consulta inicial devolvió el mismo objeto de Ana, turno 1, sin eliminarlo. Después de atenderla, Pedro quedó al frente y Martin recibió el turno 4. Al terminar, quedaron `front = 4`, `rear = 3` y `size = 0`. Intentar atender nuevamente produjo underflow; agregar una quinta persona produjo overflow por agotamiento de posiciones, aunque la cola estaba vacía.

Se probaron capacidad 1, estados inicial/parcial/lleno, nombres repetidos, veinte rondas alternadas de llegada y atención, consultas sin cambios y asignación correlativa. Se rechazaron nombres nulos, vacíos, de espacios y de tabulación/salto de línea, y capacidades 0, -1 e `Integer.MIN_VALUE`.

La prueba temporal verificó expresamente que las operaciones fallidas conservan todos los elementos, índices, cantidad y siguiente número de turno. Los nombres rechazados no generaron saltos en la numeración. También se comprobaron identidad y orden FIFO de los turnos, conservación de nombres y números, y limpieza de las referencias retiradas mediante inspección del almacenamiento privado en la prueba.

Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 8 — Cola de impresión

**Estrategia:** administrar objetos `Documento` mediante una clase anidada independiente `ColaImpresion`, con arreglo privado `Documento[]`, índices `front = 0`, `rear = -1` y contador `cantidad = 0`. Se insertan documentos al final y se retiran del frente, sin desplazar elementos ni reiniciar índices.

**Justificación:** FIFO procesa primero el documento enviado más antiguamente. LIFO invertiría ese orden y daría prioridad a los documentos más recientes.

**Operaciones:** `agregarDocumento(String nombre, int paginas)` valida, crea e inserta un documento mediante `enqueue`; `imprimirSiguiente()` retira mediante `dequeue`, muestra sus datos y devuelve el objeto; `consultarSiguiente()` consulta sin retirar. `isEmpty()`, `isFull()` y `size()` informan el estado. Al retirar se limpia la referencia con `null`.

**Casos especiales:** imprimir o consultar sin documentos produce underflow; insertar sin posiciones disponibles al final produce overflow, incluso si la cola quedó vacía. Se lanza `IllegalStateException`. Nombres nulos, vacíos o compuestos solo por espacios, páginas no positivas y capacidades no positivas producen `IllegalArgumentException`. Las validaciones preceden a las modificaciones. Se permiten nombres repetidos y no se reutilizan posiciones liberadas.

**Complejidad:** inserción física, retiro, consulta e indicadores tienen tiempo O(1). Validar el nombre cuesta O(L) en el peor caso; `agregarDocumento` completo incluye ese costo. Espacio de almacenamiento O(C), con inicialización del arreglo O(C), y espacio auxiliar por operación O(1), sin contar el documento creado. Los mensajes incluyen el costo de representar y emitir sus textos. El tiempo real de impresión depende de las páginas y no forma parte de las operaciones de la cola; este programa solamente simula el procesamiento mediante mensajes.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un simulador de cola de impresión utilizando una cola FIFO construida manualmente mediante un arreglo de objetos de tamaño fijo.

**Estructura elegida:** cola simple o lineal (Queue), siguiendo el principio FIFO (First In, First Out).

**Estrategia:** representar cada documento mediante un objeto que almacene su nombre y cantidad de páginas. Utilizar un arreglo interno `Documento[]`, con índices `front` y `rear` y un contador `cantidad`. Agregar nuevos documentos al final de la cola e imprimirlos retirándolos desde el frente, respetando el orden de llegada.

**Justificación:** los trabajos de impresión deben procesarse en el mismo orden en que fueron enviados. Una cola FIFO representa este comportamiento porque el primer documento agregado es el primero en retirarse. Una pila LIFO invertiría el orden y permitiría que los documentos más recientes se imprimieran antes que los anteriores.

**Representación de documentos:**
- Cada documento debe tener un nombre y una cantidad de páginas.
- El nombre debe ser un `String` no nulo ni vacío.
- La cantidad de páginas debe ser un entero estrictamente positivo.
- Los atributos deben conservarse asociados al mismo documento durante todo el proceso.

**Operaciones requeridas:**
- `agregarDocumento(String nombre, int paginas)`: validar los datos, crear el documento y agregarlo al final de la cola mediante `enqueue`.
- `imprimirSiguiente()`: retirar y devolver el documento que está al frente mediante `dequeue`, mostrando su nombre y cantidad de páginas.
- `consultarSiguiente()`: consultar el documento que se imprimirá primero, sin retirarlo.
- `isEmpty()`: indicar si no quedan documentos pendientes.
- `isFull()`: indicar si se agotaron las posiciones de inserción del arreglo lineal.
- `size()`: devolver la cantidad de documentos pendientes.

**Manejo del arreglo:**
- Implementar una cola estrictamente lineal, no circular.
- Inicializar `front = 0`, `rear = -1` y `cantidad = 0`.
- Incrementar `rear` al agregar e incrementar `front` al retirar.
- No desplazar los elementos restantes después de una impresión.
- No utilizar módulo `%` para reutilizar posiciones.
- No reiniciar automáticamente los índices cuando la cola quede vacía.
- Limpiar con `null` cada posición liberada para no conservar referencias innecesarias.
- Reconocer que, cuando `rear` alcanza la última posición, la cola ya no admite nuevas inserciones aunque existan posiciones liberadas al inicio.

**Casos especiales:**
- Cola vacía: intentar imprimir o consultar el siguiente documento debe lanzar `IllegalStateException`.
- Cola sin posiciones de inserción: intentar agregar otro documento debe lanzar `IllegalStateException`, sin alterar su estado.
- Nombre inválido: rechazar `null`, cadenas vacías o compuestas únicamente por espacios mediante `IllegalArgumentException`.
- Cantidad de páginas inválida: rechazar valores menores o iguales a cero mediante `IllegalArgumentException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Las operaciones fallidas no deben modificar el contenido ni los índices de la cola.
- Permitir documentos con nombres repetidos, porque diferentes trabajos pueden tener el mismo nombre.

**Complejidad:**
- Inserción física en la cola mediante `enqueue`: O(1).
- Retiro mediante `dequeue`: O(1).
- Consulta del frente: O(1).
- `isEmpty`, `isFull` y `size`: O(1).
- Validación de nombre: O(L), siendo L la longitud del nombre.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija del arreglo.
- Espacio auxiliar por operación: O(1), sin contar el objeto Documento creado.
- Aclarar que el tiempo real de impresión depende de la cantidad de páginas y no forma parte del costo de las operaciones de la cola.

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio8.java`.
- Implementar una clase pública `Ejercicio8` con método `main`.
- Implementar una clase `Documento` que almacene nombre y número de páginas.
- Implementar una clase auxiliar para administrar la cola mediante `Documento[]`, `front`, `rear` y `cantidad`.
- Preferir clases estáticas anidadas dentro de `Ejercicio8` para evitar conflictos de nombres con los demás ejercicios.
- Mantener privados los atributos internos.
- No depender de clases implementadas en otros ejercicios.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- Incorporar comentarios que expliquen el principio FIFO, el significado de los índices y la relación entre llegada e impresión.
- Mostrar el nombre y la cantidad de páginas de cada documento al agregarse y al imprimirse.
- Mostrar el documento siguiente mediante una consulta que no lo retire.
- Mostrar la cantidad de documentos pendientes después de las operaciones relevantes.
- Mostrar mensajes claros cuando una operación no puede realizarse.

**Ejemplo principal:**
1. Crear una cola de impresión de capacidad 3.
2. Agregar `Trabajo practico.pdf`, con 12 páginas.
3. Agregar `Resumen.docx`, con 5 páginas.
4. Agregar `Apuntes.pdf`, con 20 páginas.
5. Consultar el siguiente documento y verificar que sea `Trabajo practico.pdf`, sin retirarlo.
6. Intentar agregar un cuarto documento y verificar el overflow.
7. Imprimir los tres documentos en el mismo orden en que ingresaron.
8. Verificar que la cola quede vacía.
9. Intentar imprimir nuevamente y verificar underflow.
10. Intentar agregar otro documento después de vaciar la cola y comprobar que se rechace porque se agotaron las posiciones físicas de inserción.

**Pruebas adicionales:**
- Cola de capacidad 1.
- Cola inicialmente vacía.
- Cola parcialmente ocupada.
- Cola completamente ocupada.
- Documentos de una página y documentos de muchas páginas.
- Nombres repetidos.
- Alternancia de agregar e imprimir.
- Verificar que consultar no elimina el documento.
- Verificar que se conserva el nombre y la cantidad de páginas.
- Verificar que el orden de impresión sea FIFO.
- Verificar que las referencias liberadas se limpien.
- Rechazar nombres nulos, vacíos y compuestos por espacios.
- Rechazar cantidades de páginas iguales a cero o negativas.
- Rechazar capacidades inválidas.
- Comprobar que overflow y underflow no alteran el estado.
- Verificar que no se reutilicen posiciones liberadas en la cola lineal.

Compilar y ejecutar con Java 21 y `-Xlint:all`, verificando el funcionamiento y documentando las pruebas realizadas.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original se conserva literalmente y esto se registra también al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio8`, las clases anidadas `Documento` y `ColaImpresion` y las seis operaciones solicitadas, sin dependencia de otros ejercicios ni colecciones predefinidas.

Compilación individual y conjunta de los ejercicios 1 al 8 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 567 verificaciones aprobadas y 0 fallidas.

| Orden de impresión | Documento | Páginas |
|---|---|---:|
| 1 | Trabajo practico.pdf | 12 |
| 2 | Resumen.docx | 5 |
| 3 | Apuntes.pdf | 20 |

La consulta devolvió `Trabajo practico.pdf` sin retirarlo. El cuarto documento produjo overflow conservando los tres pendientes. Después de imprimirlos en orden FIFO, la cola quedó vacía; imprimir nuevamente produjo underflow y agregar otro documento siguió produciendo overflow por agotamiento de posiciones físicas.

Se probaron capacidad 1, estados vacío/parcial/lleno, documentos de una página y de muchas páginas (incluido `Integer.MAX_VALUE`), nombres repetidos y veinte rondas alternadas de agregado e impresión. Se verificaron consulta sin cambios, identidad del objeto consultado e impreso, conservación del nombre y las páginas, orden FIFO y limpieza de las referencias retiradas. Se rechazaron nombres nulos, vacíos, de espacios y de tabulación/salto de línea; páginas 0, -1 e `Integer.MIN_VALUE`; y capacidades 0, -1 e `Integer.MIN_VALUE`.

La prueba temporal inspeccionó el almacenamiento y los índices privados para comprobar que las operaciones fallidas no cambian contenido, índices ni cantidad, y que las posiciones liberadas no se reutilizan. Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 9 — Problema de desperdicio de espacio en cola simple

**Estrategia:** implementar una clase anidada independiente `ColaLineal` con arreglo privado `int[]`, índices `front = 0`, `rear = -1` y contador `cantidad = 0`. Mostrar el arreglo completo y el contenido activo en orden FIFO. El intervalo entre `front` y `rear` identifica las celdas activas sin necesitar un arreglo auxiliar ni confundir cero con una posición libre.

**Justificación:** al avanzar únicamente hacia la derecha, las posiciones anteriores a `front` quedan liberadas pero no pueden reutilizarse. Si `rear` llegó al final, una nueva inserción produce overflow aunque existan celdas físicamente libres.

**Operaciones:** `enqueue` inserta al final; `dequeue` retira del frente; `front()` consulta sin retirar; `isEmpty()`, `isFull()` y `size()` informan el estado. `mostrarEstado()` muestra todas las celdas, el contenido lógico, los índices, la cantidad activa y los recuentos de posiciones libres y disponibles.

**Casos especiales:** overflow al agotar las posiciones al final y underflow al retirar o consultar sin elementos producen `IllegalStateException`, sin cambios. Capacidades no positivas producen `IllegalArgumentException`. No se desplazan elementos, no se aplica módulo y no se reinician índices. Una cola vacía puede seguir sin admitir inserciones.

**Complejidad:** las seis operaciones básicas tienen tiempo y espacio auxiliar O(1). La visualización completa requiere O(C) iteraciones y espacio auxiliar O(1), sin contar los buffers de salida. Almacenamiento O(C), con inicialización del arreglo O(C). Las posiciones libres se calculan como `C - cantidad`, las liberadas al inicio como `front` y las disponibles para insertar como `C - rear - 1`.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java un programa que demuestre el problema de desperdicio de posiciones en una cola simple o lineal implementada manualmente mediante un arreglo de tamaño fijo.

**Estructura elegida:** cola simple (Queue) implementada mediante `int[]`, respetando FIFO (First In, First Out).

**Estrategia:** utilizar un arreglo de capacidad fija y administrar los elementos mediante los índices `front` y `rear` y un contador `cantidad`. Mostrar el estado físico del arreglo después de cada operación importante, para visualizar cómo las posiciones liberadas al comienzo no pueden reutilizarse cuando el índice `rear` llega al final.

**Justificación:** una cola lineal permite insertar por el final y retirar por el frente sin desplazar elementos. Sin embargo, al avanzar los índices únicamente hacia la derecha, las posiciones liberadas al principio quedan inutilizables para futuras inserciones. Esto puede producir overflow incluso cuando el arreglo contiene espacios físicamente libres.

**Variables de control:**
- `front`: índice del primer elemento activo.
- `rear`: índice de la última posición utilizada para insertar.
- `cantidad`: número de elementos que permanecen en la cola.
- Inicialmente: `front = 0`, `rear = -1` y `cantidad = 0`.

**Operaciones:**
- `enqueue(int valor)`: insertar al final incrementando `rear`, siempre que exista una posición disponible a la derecha.
- `dequeue()`: retirar el elemento ubicado en `front`, avanzar el índice y disminuir `cantidad`.
- `front()`: consultar el primer elemento activo sin retirarlo.
- `isEmpty()`: devolver `true` cuando `cantidad == 0`.
- `isFull()`: devolver `true` cuando `rear == capacidad - 1`, incluso si existen posiciones liberadas al inicio.
- `size()`: devolver la cantidad de elementos activos.
- `mostrarEstado()`: mostrar todas las posiciones físicas del arreglo e indicar `front`, `rear`, `cantidad`, posiciones libres y posiciones disponibles para nuevas inserciones.

**Manejo del arreglo:**
- Utilizar una implementación estrictamente lineal, NO circular.
- No aplicar módulo `%` para actualizar índices.
- No reiniciar automáticamente `front` ni `rear` cuando la cola quede vacía.
- No desplazar elementos hacia el inicio.
- No reutilizar las posiciones que quedaron detrás de `front`.
- Identificar explícitamente en la salida la diferencia entre posiciones físicamente libres y posiciones utilizables para nuevas inserciones.
- Para representar visualmente posiciones libres, administrar su estado lógico sin confundir el valor 0 con una celda vacía.
- Si se utiliza un arreglo auxiliar `boolean[]` únicamente para marcar las posiciones activas o una representación equivalente, justificarlo y mantener la estructura principal almacenada en `int[]`.
- Evitar que la visualización modifique el funcionamiento de la cola.

**Casos especiales:**
- Overflow: al intentar insertar cuando `rear` llegó a la última posición, lanzar `IllegalStateException` y conservar el estado.
- Underflow: al intentar retirar o consultar cuando `cantidad == 0`, lanzar `IllegalStateException`.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Permitir números negativos, cero, repetidos y extremos de `int`.
- Comprobar que las operaciones inválidas no alteren el arreglo lógico ni sus índices.

**Complejidad:**
- `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Visualización completa del arreglo: O(C), porque deben examinarse sus posiciones.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija.
- Espacio auxiliar por operación básica: O(1).

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio9.java`.
- Implementar una clase pública `Ejercicio9` con método `main`.
- Implementar una clase auxiliar propia para la cola simple, preferentemente anidada dentro de `Ejercicio9`.
- Utilizar `int[]` como estructura principal de almacenamiento.
- Mantener privados el arreglo, los índices y el contador.
- No depender de clases implementadas en ejercicios anteriores.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni otras colecciones predefinidas para implementar la cola.
- Mostrar cada operación realizada y el estado físico completo del arreglo, identificando índices y celdas libres.
- Mostrar también el contenido lógico de la cola en orden FIFO.
- Incorporar comentarios que expliquen los índices `front` y `rear`, las posiciones liberadas y la imposibilidad de reutilizarlas.
- Explicar claramente en consola por qué el intento final de inserción produce overflow a pesar de que existen espacios libres.

**Ejemplo principal:**

Crear una cola lineal de capacidad 5 y ejecutar:

1. Mostrar el estado inicial: arreglo vacío, `front = 0`, `rear = -1`, `size = 0`.
2. Ejecutar `enqueue(10)`, `enqueue(20)` y `enqueue(30)`.
3. Mostrar el arreglo: `{10, 20, 30, libre, libre}`.
4. Ejecutar `dequeue()` y comprobar que devuelve 10.
5. Mostrar el arreglo: `{libre, 20, 30, libre, libre}`, con `front = 1`.
6. Ejecutar `dequeue()` y comprobar que devuelve 20.
7. Mostrar el arreglo: `{libre, libre, 30, libre, libre}`, con `front = 2`.
8. Ejecutar `enqueue(40)` y `enqueue(50)`.
9. Mostrar el arreglo: `{libre, libre, 30, 40, 50}`, con `front = 2`, `rear = 4` y `size = 3`.
10. Intentar `enqueue(60)` y verificar que produce overflow.
11. Mostrar que existen dos posiciones libres al principio, pero ninguna posición disponible al final.
12. Comprobar que los tres elementos activos siguen siendo 30, 40 y 50.
13. Retirar los elementos restantes en orden FIFO.
14. Verificar que la cola queda vacía y que un nuevo intento de inserción continúa rechazándose porque `rear` permanece en la última posición.

**Pruebas adicionales:**
- Cola inicialmente vacía.
- Cola de capacidad 1.
- Cola parcialmente ocupada.
- Cola con todas las posiciones de inserción utilizadas.
- Alternancia entre inserciones y retiros.
- Números repetidos.
- Números negativos, cero y extremos de `int`.
- Comprobar que `front()` no modifica la cola.
- Comprobar que `size()` coincide con la cantidad de elementos activos.
- Comprobar que el número de posiciones libres se calcula correctamente.
- Comprobar que las posiciones libres y las posiciones disponibles para nuevas inserciones no se confunden.
- Comprobar que overflow y underflow no alteran el estado.
- Verificar que la visualización no modifica los datos.
- Rechazar capacidades inválidas.
- Verificar que el orden de retiro siempre sea FIFO.

Compilar y ejecutar con Java 21 y `-Xlint:all`, realizando pruebas reales y documentando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt original permanece literal y esto se indica al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio9`, la clase auxiliar `ColaLineal`, las seis operaciones básicas y `mostrarEstado()`, sin dependencia de otros ejercicios ni colecciones predefinidas. Una celda mostrada como libre puede conservar un valor antiguo en el arreglo, pero está fuera del intervalo activo y no pertenece a la cola lógica.

Compilación individual y conjunta de los ejercicios 1 al 9 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 237 verificaciones aprobadas y 0 fallidas.

| Momento | Estado físico | front | rear | size | Libres | Disponibles para insertar |
|---|---|---:|---:|---:|---:|---:|
| Inicial | `{libre, libre, libre, libre, libre}` | 0 | -1 | 0 | 5 | 5 |
| Insertar 10, 20 y 30 | `{10, 20, 30, libre, libre}` | 0 | 2 | 3 | 2 | 2 |
| Retirar 10 | `{libre, 20, 30, libre, libre}` | 1 | 2 | 2 | 3 | 2 |
| Retirar 20 | `{libre, libre, 30, libre, libre}` | 2 | 2 | 1 | 4 | 2 |
| Insertar 40 y 50 | `{libre, libre, 30, 40, 50}` | 2 | 4 | 3 | 2 | 0 |
| Intentar insertar 60 | `{libre, libre, 30, 40, 50}` | 2 | 4 | 3 | 2 | 0 |
| Retirar 30, 40 y 50 | `{libre, libre, libre, libre, libre}` | 5 | 4 | 0 | 5 | 0 |

El intento de insertar 60 produjo overflow con dos posiciones libres al inicio y ninguna disponible al final, conservando 30, 40 y 50. Los retiros respetaron FIFO. Después de vaciarla, insertar 70 también produjo overflow, conservando `front = 5`, `rear = 4` y tamaño 0.

Se probaron capacidad 1, estados inicial/parcial/agotado, veinte rondas alternadas, repetidos, negativos, cero y extremos de `int`. Se compararon exactamente las salidas físicas y lógicas y los recuentos de posiciones libres y disponibles en los estados verificados. Se comprobó que consultar y visualizar no modifican el arreglo, los índices ni la cantidad, y que overflow y underflow tampoco los alteran. Se rechazaron capacidades 0, -1 e `Integer.MIN_VALUE`.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

### Ejercicio 10 — Cola circular

**Estrategia:** implementar una clase anidada independiente `ColaCircularEnteros` con arreglo privado `int[]`, índices `front = 0`, `rear = -1` y contador `cantidad = 0`. Avanzar mediante `(indice + 1) % capacidad` y utilizar el contador para distinguir vacío y lleno, aprovechando todas las posiciones.

**Justificación:** los índices circulares reutilizan las posiciones liberadas sin desplazar elementos, resolviendo el desperdicio de espacio de la cola lineal y conservando FIFO.

**Operaciones:** `enqueue(int valor)` valida capacidad disponible, avanza `rear`, almacena e incrementa la cantidad; `dequeue()` retira en `front`, avanza ese índice y disminuye la cantidad; `front()` consulta sin retirar. `isEmpty()` comprueba cantidad cero, `isFull()` comprueba cantidad igual a capacidad, y `size()` devuelve la cantidad. La visualización muestra celdas físicas con sus índices y contenido lógico en orden FIFO.

**Casos especiales:** overflow y underflow producen `IllegalStateException` antes de modificar el estado. Capacidades no positivas producen `IllegalArgumentException`. Se admiten negativos, cero, repetidos y extremos de `int`. Los índices no se reinician al vaciarse: el módulo permite continuar insertando y retirando. La distancia circular desde `front` identifica las celdas activas sin confundir cero con una celda libre.

**Complejidad:** las seis operaciones básicas tienen tiempo y espacio auxiliar O(1). Almacenamiento O(C), con inicialización del arreglo O(C). La visualización completa requiere O(C) iteraciones y espacio auxiliar O(1), sin contar los buffers de salida.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una cola circular de números enteros utilizando un arreglo de capacidad fija, que respete el principio FIFO y reutilice las posiciones liberadas al comienzo del arreglo.

**Estructura elegida:** cola circular (Circular Queue), implementada manualmente mediante `int[]`.

**Estrategia:** utilizar un arreglo de capacidad fija y administrar sus elementos mediante los índices `front` y `rear`, junto con un contador `cantidad`. Cuando un índice llegue al final del arreglo, debe volver al comienzo mediante el operador módulo `%`, permitiendo reutilizar las posiciones que fueron liberadas.

**Justificación:** una cola lineal puede agotar sus posiciones de inserción aun cuando existan celdas libres al inicio. La cola circular resuelve este problema porque permite que los índices recorran nuevamente el arreglo, sin desplazar los elementos ni perder el orden FIFO.

**Variables de control:**
- `front`: índice del primer elemento activo de la cola.
- `rear`: índice de la última posición en la que se insertó un elemento.
- `cantidad`: número de elementos activos.
- `capacidad`: tamaño fijo del arreglo interno.
- Inicialmente: `front = 0`, `rear = -1` y `cantidad = 0`.

**Operaciones requeridas:**
- `enqueue(int valor)`: verificar que la cola no esté llena, avanzar `rear` de forma circular, almacenar el valor e incrementar `cantidad`.
- `dequeue()`: verificar que la cola no esté vacía, devolver el elemento ubicado en `front`, avanzar `front` de forma circular y disminuir `cantidad`.
- `front()`: consultar y devolver el primer elemento sin retirarlo.
- `isEmpty()`: devolver `true` cuando `cantidad == 0`.
- `isFull()`: devolver `true` cuando `cantidad == capacidad`.
- `size()`: devolver la cantidad de elementos activos.

**Movimiento circular:**
- Para avanzar el índice posterior: `rear = (rear + 1) % capacidad`.
- Para avanzar el índice anterior: `front = (front + 1) % capacidad`.
- Cuando `rear` pasa del último índice al índice 0, se reutiliza una posición liberada.
- Cuando `front` pasa del último índice al índice 0, continúa retirando elementos en orden FIFO.
- No desplazar elementos físicamente para liberar posiciones.
- Utilizar `cantidad` para distinguir correctamente los estados vacío y lleno.
- La cola debe poder ocupar todas las posiciones del arreglo.

**Política de índices:**
- Mantener los índices de manera coherente después de cada operación.
- Cuando la cola quede vacía, `cantidad` debe valer 0. No es necesario reiniciar `front` ni `rear`, porque ambos seguirán funcionando correctamente mediante módulo.
- El arreglo debe poder reutilizarse indefinidamente mediante nuevas operaciones `enqueue` y `dequeue`, mientras se respete su capacidad.
- No confundir las posiciones físicas del arreglo con el orden lógico de los elementos.

**Casos especiales:**
- Overflow: intentar insertar cuando `cantidad == capacidad` debe lanzar `IllegalStateException` sin modificar el estado.
- Underflow: intentar retirar o consultar cuando `cantidad == 0` debe lanzar `IllegalStateException` sin modificar el estado.
- Capacidad inválida: rechazar capacidades menores o iguales a cero mediante `IllegalArgumentException`.
- Permitir números negativos, cero, repetidos y extremos de `int`.
- Comprobar que cualquier operación fallida preserve íntegramente los elementos, índices y contador.

**Complejidad:**
- `enqueue`, `dequeue`, `front`, `isEmpty`, `isFull` y `size`: O(1) de tiempo.
- Espacio de almacenamiento: O(C), siendo C la capacidad fija del arreglo.
- Espacio auxiliar por operación básica: O(1).
- La visualización completa del arreglo requiere O(C) de tiempo.

**Requisitos de implementación:**
- Crear `TP4-Pilas-y-Colas-Arreglos/src/Ejercicio10.java`.
- Implementar una clase pública `Ejercicio10` con método `main`.
- Implementar una clase auxiliar `ColaCircularEnteros` mediante un arreglo `int[]`.
- Preferir una clase estática anidada dentro de `Ejercicio10` para evitar conflictos con otros ejercicios.
- Mantener privados el arreglo interno, los índices y el contador.
- Implementar manualmente todas las operaciones solicitadas.
- No utilizar `Queue`, `Deque`, `ArrayDeque`, `LinkedList`, `ArrayList` ni colecciones predefinidas para implementar la cola.
- No depender de las clases de ejercicios anteriores.
- Incorporar comentarios explicando FIFO, la función de `front` y `rear`, el operador módulo, los casos de overflow y underflow y la diferencia con una cola lineal.
- Mostrar el arreglo físico con sus índices después de las operaciones importantes.
- Mostrar también el contenido lógico de la cola en orden FIFO.
- Distinguir visualmente las celdas activas de las libres sin confundir el valor 0 con una posición vacía.
- Evitar que la visualización modifique el contenido de la cola.
- Mostrar claramente cuándo `rear` y `front` vuelven al índice 0 mediante el operador módulo.

**Ejemplo principal:**

Crear una cola circular de capacidad 5 y ejecutar:

1. Mostrar el estado inicial: `front = 0`, `rear = -1`, `size = 0`.
2. Ejecutar `enqueue(10)`, `enqueue(20)` y `enqueue(30)`.
3. Mostrar el arreglo físico: `{10, 20, 30, libre, libre}`.
4. Ejecutar `dequeue()` dos veces y comprobar que se retiran 10 y 20.
5. Mostrar el arreglo físico: `{libre, libre, 30, libre, libre}`, con `front = 2`, `rear = 2` y `size = 1`.
6. Ejecutar `enqueue(40)` y `enqueue(50)`.
7. Comprobar que el arreglo contiene `{libre, libre, 30, 40, 50}`, con `front = 2`, `rear = 4` y `size = 3`.
8. Ejecutar `enqueue(60)`. Verificar que `rear` vuelve al índice 0 y que el arreglo queda `{60, libre, 30, 40, 50}`.
9. Ejecutar `enqueue(70)`. Verificar que `rear = 1`, `size = 5` y que el arreglo queda `{60, 70, 30, 40, 50}`.
10. Comprobar que `isFull()` devuelve `true`.
11. Intentar `enqueue(80)` y verificar overflow, sin modificar el estado.
12. Consultar `front()` y verificar que devuelve 30, sin retirarlo.
13. Ejecutar `dequeue()` repetidamente y comprobar que los elementos salen en orden 30, 40, 50, 60 y 70.
14. Verificar que `front` también atraviesa el final del arreglo y vuelve al índice 0.
15. Comprobar que la cola queda vacía y que `isEmpty()` devuelve `true`.
16. Intentar `dequeue()` y `front()` sobre la cola vacía y verificar underflow.
17. Agregar un nuevo elemento después de vaciarla y comprobar que la cola circular continúa funcionando, a diferencia de la cola lineal del Ejercicio 9.

**Pruebas adicionales:**
- Cola recién creada.
- Capacidad 1.
- Cola parcialmente ocupada.
- Cola completamente ocupada.
- Alternancia repetida de inserciones y retiros.
- Múltiples vueltas completas de los índices sobre el arreglo.
- Verificar que `rear` regrese al inicio.
- Verificar que `front` regrese al inicio.
- Insertar después de vaciar completamente la cola.
- Números repetidos, negativos, cero y extremos de `int`.
- Comprobar que `front()` no modifica la estructura.
- Comprobar que `size()` coincide con la cantidad real de elementos.
- Verificar que `isEmpty()` e `isFull()` funcionen correctamente incluso cuando los índices coincidan.
- Verificar que se utilice la capacidad completa del arreglo.
- Comprobar que overflow y underflow no alteran los elementos, índices ni contador.
- Rechazar capacidades inválidas.
- Verificar el orden FIFO después de múltiples vueltas circulares.
- Comprobar que la visualización del arreglo no modifica los datos.

Compilar y ejecutar con Java 21 y `-Xlint:all`, verificando el funcionamiento mediante pruebas reales y documentando sus resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Ajustes al prompt

No fueron necesarios ajustes. El prompt inicial se conserva literalmente y esto se indica al final del archivo Java.

#### Resultado

Se implementaron `Ejercicio10`, la clase auxiliar `ColaCircularEnteros`, las seis operaciones solicitadas y la visualización física y lógica, sin depender de otros ejercicios ni colecciones predefinidas.

Compilación individual y conjunta de los ejercicios 1 al 10 correcta con Java 21, `--release 21`, `-encoding UTF-8` y `-Xlint:all`, sin advertencias ni conflictos. Se ejecutaron el `main` y una prueba independiente con 37 426 verificaciones aprobadas y 0 fallidas, incluyendo 4000 operaciones aleatorias reproducibles (semilla 2026) sobre capacidades 1, 2, 5 y 7.

| Momento | Estado físico | front | rear | size |
|---|---|---:|---:|---:|
| Inicial | `{libre, libre, libre, libre, libre}` | 0 | -1 | 0 |
| Insertar 10, 20 y 30 | `{10, 20, 30, libre, libre}` | 0 | 2 | 3 |
| Retirar 10 y 20 | `{libre, libre, 30, libre, libre}` | 2 | 2 | 1 |
| Insertar 40 y 50 | `{libre, libre, 30, 40, 50}` | 2 | 4 | 3 |
| Insertar 60, rear vuelve a 0 | `{60, libre, 30, 40, 50}` | 2 | 0 | 4 |
| Insertar 70 | `{60, 70, 30, 40, 50}` | 2 | 1 | 5 |
| Retirar 30, 40 y 50, front vuelve a 0 | `{60, 70, libre, libre, libre}` | 0 | 1 | 2 |
| Retirar 60 y 70 | `{libre, libre, libre, libre, libre}` | 2 | 1 | 0 |
| Insertar 90 después de vaciar | `{libre, libre, 90, libre, libre}` | 2 | 2 | 1 |

Insertar 80 produjo overflow sin modificar el estado lleno. La consulta devolvió 30 y conservó el tamaño 5. Los retiros posteriores devolvieron 30, 40, 50, 60 y 70 en orden FIFO. Sobre la cola vacía, retirar y consultar produjeron underflow; una nueva inserción de 90 funcionó correctamente.

Las operaciones aleatorias se compararon con un modelo FIFO independiente utilizado exclusivamente en la prueba temporal. Se verificaron valores retirados, consultas sin cambios, cantidad, estados vacío/lleno, índices esperados, múltiples vueltas y contenido lógico mostrado. También se comprobaron estados físicos principales, capacidad completa, capacidad 1, negativos, cero, repetidos y extremos de `int`. Los errores conservaron arreglo, índices y contador; la visualización tampoco modificó el estado. Se rechazaron capacidades 0, -1 e `Integer.MIN_VALUE`.

Las pruebas y compilados quedaron fuera del repositorio. Sin inconvenientes ni pendientes.

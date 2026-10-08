# TP1 — Análisis de Algoritmos

## Metodología de trabajo

Para la resolución de este práctico se utilizaron dos agentes de inteligencia artificial:

- **Agente analista (ChatGPT):** encargado del análisis de las consignas, la evaluación de estrategias, el razonamiento sobre la complejidad algorítmica y la elaboración de los prompts a partir de las decisiones tomadas.
- **Agente desarrollador (Codex):** encargado de implementar los algoritmos en Java, ejecutar las pruebas y verificar su funcionamiento.
- **Agente documentador (Codex):** encargado de documentar el codigo y modificar el readme con las estrategias, justificacion, complejidad, prompt literal y resultados reales.

Cada ejercicio fue analizado previamente a la generación del código, siguiendo la metodología propuesta en clase.

---

### Ejercicio 1 — Encontrar el mínimo de un vector

**Estrategia:** Recorrido secuencial, almacenando y actualizando el menor valor encontrado.

**Justificación:** No es necesario ordenar el vector, ya que podemos encontrar el mínimo recorriéndolo una sola vez.

**Complejidad:**

- Temporal: Θ(n).
- Espacial auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
## TP1 — Ejercicio 1: Encontrar el mínimo de un vector

Implementá en Java el Ejercicio 1 del Trabajo Práctico de Análisis de Algoritmos.

**Ubicación:** `TP1-Analisis-Algoritmos/src/Ejercicio1.java`. Verificá la estructura existente antes de crear el archivo y utilizá el nombre real de la carpeta correspondiente.

### Problema

Encontrar el valor mínimo de un vector de números enteros.

### Estrategia elegida

Utilizar un recorrido secuencial del vector.

1. Verificar que el vector no sea nulo ni esté vacío.
2. Inicializar una variable `minimo` con el primer elemento.
3. Recorrer el vector desde la segunda posición.
4. Comparar cada elemento con el mínimo actual.
5. Actualizar `minimo` si encontramos un valor menor.
6. Al finalizar, devolver el mínimo encontrado.

### Justificación

Esta estrategia es adecuada porque para determinar el mínimo de un vector desordenado necesitamos examinar todos sus elementos.

No resulta necesario ordenar el vector, ya que un único recorrido permite encontrar el mínimo con menor costo algorítmico que ordenar primero todo el conjunto.

### Complejidad esperada

- Temporal: O(n).
- Espacial auxiliar: O(1).
- Mejor y peor caso: Θ(n), porque el recorrido examina todos los elementos.

### Requisitos de implementación

- Utilizar Java.
- Crear una clase `Ejercicio1`.
- Implementar un método `encontrarMinimo(int[] vector)`.
- Utilizar un ciclo `for` y comparaciones simples.
- No utilizar métodos predefinidos como `Arrays.sort()` ni `Collections.min()`.
- Incorporar comentarios claros explicando la lógica del algoritmo.
- Incluir un método `main` para probar su funcionamiento.
- Utilizar como ejemplo el vector `{8, 3, 12, 1, 6}`.
- Mostrar el vector original y el mínimo encontrado.
- Explicar mediante comentarios por qué no es necesario ordenar el vector.
- Manejar correctamente el caso de un vector vacío o nulo.

### Verificación

Compilá y ejecutá el programa si el entorno lo permite.

Probá además los siguientes casos:

- Vector con números positivos.
- Vector con números negativos.
- Vector con elementos repetidos.
- Vector con un único elemento.

### Restricciones

No modifiques archivos de otros ejercicios, no realices commits ni push y no agregues funcionalidades innecesarias.

Al finalizar, informame qué archivo creaste, si compiló correctamente y qué resultados obtuviste en las pruebas.
~~~

#### Resultado

El algoritmo se implementó correctamente en `Ejercicio1.java` y superó las pruebas con números positivos, negativos, repetidos, valores extremos y vectores de un único elemento.

### Ejercicio 2 — Buscar un elemento en un vector desordenado

**Estrategia:** Búsqueda lineal, recorriendo el vector hasta encontrar el elemento o llegar al final.

**Justificación:** Al no estar ordenados los elementos, no podemos utilizar directamente búsqueda binaria. La búsqueda secuencial permite encontrar el valor sin modificar el vector.

**Complejidad:**

- Mejor caso: Θ(1).
- Peor caso: Θ(n).
- Caso promedio: Θ(n).
- Espacial auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 2 del TP1 de Análisis de Algoritmos: buscar un elemento en un vector desordenado.

Estrategia: utilizar una búsqueda lineal, recorriendo el vector desde el inicio y comparando cada elemento con el valor buscado. El recorrido debe detenerse al encontrar la primera coincidencia o al llegar al final.

Justificación: al estar desordenado, no podemos descartar posiciones mediante búsqueda binaria. La búsqueda lineal permite resolver el problema sin ordenar ni modificar el vector.

Complejidad: mejor caso Θ(1), peor caso Θ(n), caso promedio Θ(n) suponiendo posiciones equiprobables y espacio auxiliar O(1).

Requisitos:
- Crear TP1-Analisis-de-Algoritmos/src/Ejercicio2.java, respetando la estructura existente.
- Utilizar un ciclo for y comparaciones simples, sin métodos predefinidos de búsqueda.
- Informar si el elemento fue encontrado, su índice y cuántas posiciones fueron recorridas.
- Si no se encuentra, informar que no existe y la cantidad total de posiciones revisadas.
- Incluir comentarios explicativos y un método main con ejemplos.
- Contemplar vectores vacíos y nulos sin provocar errores inesperados.
- Probar un elemento al inicio, al final, inexistente y repetido; también un vector vacío.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push. Al finalizar, informar qué archivo se creó y los resultados de las pruebas.
~~~

#### Resultado

El algoritmo fue implementado correctamente en `Ejercicio2.java`, utilizando búsqueda lineal con finalización anticipada.

Se verificaron los siguientes casos:

- Elemento al inicio: 1 posición recorrida.
- Elemento al final: 6 posiciones recorridas.
- Elemento inexistente: 6 posiciones recorridas.
- Elemento repetido: se encuentra la primera aparición.
- Vector vacío o nulo: 0 posiciones recorridas.

**Compilación y ejecución:** correctas con Java. El vector original no se modifica.

### Ejercicio 3 — Buscar un elemento en un vector ordenado

**Estrategia:** Búsqueda binaria iterativa, utilizando las variables inicio, fin y medio para dividir progresivamente el intervalo de búsqueda.

**Justificación:** Al encontrarse ordenado el vector, podemos descartar la mitad de los elementos en cada iteración. Esto permite realizar menos comparaciones que una búsqueda lineal para conjuntos grandes.

**Complejidad:**

- Mejor caso: Θ(1).
- Peor caso: Θ(log n).
- Caso promedio: Θ(log n).
- Espacial auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 3 del TP1 de Análisis de Algoritmos: búsqueda binaria en un vector ordenado.

**Estrategia:** utilizar búsqueda binaria iterativa, manteniendo tres variables: `inicio`, `fin` y `medio`. En cada iteración se compara el elemento central con el valor buscado y se descarta la mitad del vector que no puede contenerlo, hasta encontrar el elemento o agotar el intervalo.

**Justificación:** como el vector está ordenado, podemos descartar la mitad de los elementos en cada comparación. Esto resulta más eficiente que una búsqueda lineal, que en el peor caso debe revisar los n elementos.

**Complejidad:** mejor caso Θ(1), peor caso Θ(log n), caso promedio Θ(log n) y espacio auxiliar O(1).

**Requisitos:**

- Crear `Ejercicio3.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar la búsqueda mediante un ciclo `while`, sin utilizar métodos predefinidos de búsqueda.
- Calcular el índice central mediante `inicio + (fin - inicio) / 2`.
- Mostrar en cada iteración los valores de `inicio`, `fin`, `medio` y el elemento comparado.
- Informar si el elemento fue encontrado y su índice; devolver `-1` si no existe.
- Utilizar comentarios explicativos e incluir un método `main` con ejemplos.
- Considerar vectores vacíos, nulos y valores ausentes.
- Suponer que el vector recibido ya está ordenado de menor a mayor, sin ordenarlo ni modificarlo.
- Probar búsquedas al inicio, en el medio, al final y de un elemento inexistente.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push. Al finalizar, informar el archivo creado y los resultados de las pruebas.
~~~

#### Resultado

El algoritmo fue implementado correctamente en `Ejercicio3.java` mediante búsqueda binaria iterativa.

Se verificaron los siguientes casos:

- Elemento al inicio: índice 0, 3 iteraciones.
- Elemento central: índice 3, 1 iteración.
- Elemento al final: índice 6, 3 iteraciones.
- Elemento inexistente: índice -1, 3 iteraciones.
- Vector vacío o nulo: índice -1, 0 iteraciones.
- Casos adicionales: vector de un elemento, longitud par, valores fuera del intervalo y extremos de `int`.

**Compilación y ejecución:** correctas con Java 21. Se superaron 12 pruebas y el vector original no se modifica.

### Ejercicio 4 — Detectar elementos duplicados

**Estrategia:** Se implementaron dos soluciones independientes: ciclos `for` anidados que comparan cada elemento con los posteriores y un recorrido con `HashSet<Integer>` que detecta repeticiones cuando `add()` devuelve `false`. Ambas terminan inmediatamente al detectar un duplicado.

**Justificación:** Ambas estrategias evitan ordenar o modificar el vector. Los ciclos anidados utilizan memoria constante, pero pueden comparar todos los pares. HashSet almacena los valores vistos y utiliza memoria adicional para reducir el tiempo esperado.

**Complejidad:**

- Ciclos anidados: mejor caso Θ(1), peor caso Θ(n²) y espacio auxiliar O(1).
- HashSet: mejor caso Θ(1), tiempo esperado Θ(n) cuando se recorre todo el vector y espacio auxiliar O(n). Este tiempo supone operaciones de inserción de costo esperado amortizado O(1). Su peor caso teórico puede ser superior al lineal, dependiendo del costo de las operaciones y las colisiones; no se garantiza un peor caso Θ(n).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 4 del TP1 de Análisis de Algoritmos: detectar elementos duplicados en un vector mediante dos estrategias diferentes.

**Estrategia A — Ciclos anidados:** utilizar dos ciclos `for` para comparar cada elemento con los elementos posteriores. Si dos valores coinciden, informar que existen duplicados y finalizar la búsqueda.

**Estrategia B — HashSet:** recorrer el vector incorporando sus elementos a un `HashSet<Integer>`. Si un elemento ya está presente, detectar el duplicado y finalizar la búsqueda.

**Justificación:** ambas estrategias permiten resolver el problema sin modificar ni ordenar el vector. Los ciclos anidados requieren memoria constante, pero pueden realizar una cantidad cuadrática de comparaciones. HashSet utiliza memoria adicional para reducir el tiempo esperado de búsqueda.

**Complejidad:**

- Ciclos anidados: mejor caso Θ(1), peor caso Θ(n²), espacio auxiliar O(1).
- HashSet: mejor caso Θ(1), tiempo esperado Θ(n) si se recorre todo el vector, espacio auxiliar O(n).
- Aclarar que el rendimiento esperado de HashSet depende del costo de sus operaciones y que su peor caso teórico puede ser superior al lineal.

**Requisitos:**

- Crear `Ejercicio4.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura real del proyecto.
- Implementar dos métodos independientes: `tieneDuplicadosAnidados(int[] vector)` y `tieneDuplicadosHashSet(int[] vector)`.
- Ambos métodos deben devolver un valor booleano que indique si existen duplicados.
- En la primera solución utilizar exclusivamente comparaciones mediante ciclos anidados, sin estructuras auxiliares.
- En la segunda utilizar `HashSet<Integer>`, aprovechando que el método `add()` devuelve `false` cuando el elemento ya existe.
- Finalizar inmediatamente al detectar un duplicado.
- No ordenar ni modificar el vector original.
- Incorporar comentarios claros explicando las estrategias.
- Incluir un método `main` que ejecute ambas soluciones con los mismos vectores y muestre los resultados.
- Contemplar vectores vacíos, nulos y de un solo elemento.
- Probar vectores con duplicados, sin duplicados, con números negativos y con duplicados en diferentes posiciones.
- Compilar, ejecutar y verificar que ambas soluciones produzcan los mismos resultados.

No modifiques otros ejercicios ni realices commits o push.
~~~

#### Resultado

Se implementaron `tieneDuplicadosAnidados(int[] vector)` y `tieneDuplicadosHashSet(int[] vector)` en `Ejercicio4.java`. Ambos devuelven un booleano; para vectores nulos, vacíos o de un solo elemento devuelven `false`.

Se ejecutaron 14 pruebas:

- Sin duplicados y con duplicados al inicio, en el medio, al final y en posiciones separadas.
- Números negativos con y sin duplicados.
- Vectores vacíos, nulos y de un solo elemento.
- Vectores de dos elementos con y sin duplicados.
- Valores extremos de `int` con y sin duplicados.

Ambas estrategias devolvieron los resultados esperados en los 14 casos. Se verificó que cada método conserva intacto el vector original. El método `main` también se ejecutó correctamente y muestra los resultados de ambas estrategias para los mismos vectores.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

### Ejercicio 5 — Contar ocurrencias

**Estrategia:** Recorrido secuencial mediante un ciclo `for` y un contador inicializado en cero, que se incrementa por cada coincidencia con el valor buscado.

**Justificación:** Es necesario recorrer completamente el vector para contar todas las apariciones, incluidas las que pueden estar en la última posición. Encontrar una coincidencia no permite finalizar el recorrido.

**Complejidad:**

- Mejor caso: Θ(n).
- Peor caso: Θ(n).
- Caso promedio: Θ(n).
- Espacio auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 5 del TP1 de Análisis de Algoritmos: contar cuántas veces aparece un valor determinado dentro de un vector de números enteros.

**Estrategia:** utilizar un recorrido secuencial mediante un ciclo `for`, inicializando un contador en cero e incrementándolo cada vez que un elemento coincida con el valor buscado.

**Justificación:** es necesario recorrer completamente el vector porque el valor buscado puede aparecer varias veces, incluso en la última posición. No podemos detenernos al encontrar la primera coincidencia, ya que necesitamos contabilizar todas las apariciones.

**Complejidad:**

- Mejor caso: Θ(n).
- Peor caso: Θ(n).
- Caso promedio: Θ(n).
- Espacio auxiliar: O(1).

**Requisitos:**

- Crear `Ejercicio5.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar un método `contarOcurrencias(int[] vector, int valor)` que devuelva la cantidad de apariciones.
- Utilizar un ciclo `for` y comparaciones simples, sin métodos predefinidos para contar.
- Recorrer siempre el vector completo.
- No ordenar ni modificar el vector original.
- Incorporar comentarios explicativos.
- Incluir un método `main` que muestre el vector, el valor buscado y la cantidad de apariciones.
- Contemplar vectores vacíos y nulos, devolviendo cero.
- Probar valores repetidos, inexistentes, números negativos, un solo elemento y vectores vacíos.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `contarOcurrencias(int[] vector, int valor)` en `Ejercicio5.java`. El método recorre completamente el vector sin ordenarlo ni modificarlo y devuelve cero para vectores vacíos o nulos.

Se ejecutaron 11 pruebas:

- Valor repetido, incluida la última posición: 3 apariciones.
- Valor inexistente: 0 apariciones.
- Números negativos: 3 apariciones.
- Un solo elemento coincidente o distinto: 1 y 0 apariciones, respectivamente.
- Vector vacío y vector nulo: 0 apariciones en ambos casos.
- Todos los elementos coincidentes: 3 apariciones.
- Coincidencia únicamente al final: 1 aparición.
- Valor cero: 2 apariciones.
- Valores extremos de `int`: 2 apariciones de `Integer.MIN_VALUE`.

Todas las pruebas devolvieron los resultados esperados y se verificó que los vectores originales permanecen intactos. También se ejecutó y verificó la salida del `main`: vector `{8, 3, 12, 3, 6, 3}`, valor buscado `3` y cantidad de apariciones `3`.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

### Ejercicio 6 — Comparar dos vectores

**Estrategia:** Comparación secuencial con finalización anticipada. Se manejan explícitamente las referencias nulas, se comparan las longitudes y, si coinciden, se recorren las posiciones mediante un ciclo `for`. Se devuelve `false` ante la primera diferencia y `true` si no hay diferencias.

**Justificación:** La igualdad requiere la misma longitud y los mismos valores en cada posición. Una diferencia basta para descartar la igualdad, por lo que no es necesario continuar comparando.

**Complejidad:**

- Mejor caso: Θ(1), cuando las longitudes difieren o la primera comparación detecta una diferencia.
- Peor caso: Θ(n), cuando todos los elementos son iguales o la diferencia está en la última posición.
- Caso promedio: Θ(n), suponiendo que la primera diferencia está distribuida uniformemente entre las n posiciones. Depende de la distribución de los datos.
- Espacio auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 6 del TP1 de Análisis de Algoritmos: determinar si dos vectores de números enteros son iguales.

**Estrategia:** utilizar una comparación secuencial con finalización anticipada. Primero comparar las longitudes de ambos vectores y, si coinciden, recorrerlos mediante un ciclo `for`, comparando los elementos que ocupan la misma posición. Ante la primera diferencia, finalizar inmediatamente devolviendo `false`. Si no se encuentran diferencias, devolver `true`.

**Justificación:** dos vectores son iguales cuando tienen la misma longitud y los mismos elementos en las mismas posiciones. No es necesario seguir comparando cuando se detecta una diferencia, porque ya sabemos que los vectores no son iguales.

**Complejidad:**

- Mejor caso: Θ(1), cuando las longitudes difieren o la primera comparación detecta una diferencia.
- Peor caso: Θ(n), cuando todos los elementos son iguales o la diferencia está en la última posición.
- Caso promedio: Θ(n), suponiendo que la primera diferencia está distribuida uniformemente entre las n posiciones. Aclarar que depende de la distribución de los datos.
- Espacio auxiliar: O(1).

**Requisitos:**

- Crear `Ejercicio6.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar un método `sonIguales(int[] vector1, int[] vector2)` que devuelva un booleano.
- Comprobar primero las longitudes para evitar comparaciones innecesarias.
- Utilizar un ciclo `for` y comparaciones simples, sin métodos predefinidos como `Arrays.equals()`.
- Finalizar inmediatamente al encontrar la primera diferencia.
- Considerar dos vectores vacíos como iguales.
- Manejar vectores nulos explícitamente: dos referencias nulas se consideran iguales, mientras que una nula y otra no nula se consideran diferentes.
- No ordenar ni modificar los vectores originales.
- Incorporar comentarios explicativos e incluir un método `main` con ejemplos.
- Probar vectores idénticos, longitudes diferentes, diferencia al inicio, al medio, al final, vectores vacíos, nulos y de un único elemento.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `sonIguales(int[] vector1, int[] vector2)` en `Ejercicio6.java`, sin ordenar ni modificar los vectores y con retorno inmediato ante la primera diferencia.

Se ejecutaron 17 pruebas:

- Vectores idénticos: `true`.
- Longitudes diferentes y diferencias al inicio, en el medio o al final: `false`.
- Dos vectores vacíos: `true`.
- Dos referencias nulas: `true`.
- Una referencia nula y otra vacía o no vacía, en ambos órdenes: `false`.
- Vectores de un único elemento igual o diferente: `true` y `false`, respectivamente.
- Vectores iguales con negativos y cero, y con extremos de `int`: `true`.
- Vector vacío frente a uno no vacío, en ambos órdenes: `false`.

Todas las pruebas dieron los resultados esperados y se verificó que ambos vectores permanecen intactos. También se ejecutó y verificó la salida de los 11 ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

### Ejercicio 7 — Invertir un vector

**Estrategia:** La solución con auxiliar crea un nuevo vector y copia los elementos en orden inverso mediante un ciclo `for`. La solución in-place utiliza dos índices desde los extremos hacia el centro e intercambia cada par mediante una variable temporal.

**Justificación:** Ambas generan el mismo orden invertido. El vector auxiliar conserva el original, pero utiliza memoria proporcional a su longitud. La inversión in-place ahorra memoria al modificar directamente el vector recibido.

**Complejidad:**

- Vector auxiliar: tiempo Θ(n), espacio auxiliar O(n). Ventaja: conserva el original. Desventaja: requiere otro vector.
- Inversión in-place: tiempo Θ(n), espacio auxiliar O(1). Ventaja: utiliza memoria constante. Desventaja: modifica el original.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 7 del TP1 de Análisis de Algoritmos: invertir un vector de números enteros mediante dos estrategias diferentes.

**Estrategia A — Vector auxiliar:** crear un nuevo vector del mismo tamaño y copiar los elementos del original en orden inverso, sin modificar el vector recibido.

**Estrategia B — Inversión in-place:** invertir el propio vector intercambiando los elementos de los extremos y avanzando hacia el centro, utilizando únicamente una variable temporal para realizar cada intercambio.

**Justificación:** ambas estrategias permiten invertir correctamente el orden de los elementos. La primera conserva el vector original, pero requiere memoria adicional proporcional a su tamaño. La segunda evita crear otro vector y utiliza memoria constante, aunque modifica el vector recibido.

**Complejidad:**

- Vector auxiliar: tiempo Θ(n), espacio auxiliar O(n).
- Inversión in-place: tiempo Θ(n), espacio auxiliar O(1).
- Explicar las ventajas y desventajas de ambas implementaciones.

**Requisitos:**

- Crear `Ejercicio7.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar dos métodos independientes: `invertirConAuxiliar(int[] vector)` e `invertirInPlace(int[] vector)`.
- El primer método debe devolver un nuevo vector invertido sin modificar el original.
- El segundo método debe modificar directamente el vector recibido, sin crear otro vector auxiliar.
- Para la inversión in-place, utilizar dos índices que avancen desde los extremos hacia el centro.
- Utilizar ciclos y operaciones básicas, sin métodos predefinidos para invertir.
- Incorporar comentarios explicativos e incluir un método `main` que muestre los resultados de ambas estrategias.
- Manejar explícitamente vectores nulos y vacíos.
- Probar vectores de longitud par e impar, un único elemento, números negativos, elementos repetidos y vectores vacíos.
- Verificar que ambas estrategias generen el mismo orden invertido y que la primera conserve el vector original.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementaron `invertirConAuxiliar(int[] vector)`, que devuelve un nuevo vector invertido, e `invertirInPlace(int[] vector)`, que modifica el recibido sin crear otro vector. Ante `null`, el primero devuelve `null` y el segundo retorna sin hacer cambios. Para un vector vacío, el primero devuelve un nuevo vector vacío y el segundo no realiza intercambios.

Se ejecutaron 9 pruebas: longitud par, longitud impar, un único elemento, números negativos, elementos repetidos, vector vacío, vector nulo, dos elementos y extremos de `int`.

En todos los casos se verificó el orden esperado, la coincidencia entre ambas estrategias, la conservación del vector original por la primera y la creación de un vector distinto para cada entrada no nula. También se comprobó que aplicar dos veces la inversión in-place recupera el original.

El `main` se ejecutó correctamente: ambas estrategias produjeron `{6, 1, 12, 3, 8}` a partir de `{8, 3, 12, 1, 6}`, y el original permaneció intacto después de usar el auxiliar.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

### Ejercicio 8 — Sumar todos los elementos de una matriz

**Estrategia:** Recorrido por filas y columnas mediante dos ciclos `for` anidados. Un acumulador `long` guarda la suma y un contador `long` registra una operación de acumulación por cada elemento procesado.

**Justificación:** Cada elemento contribuye a la suma total, por lo que es necesario visitar todas las posiciones. El recorrido no modifica la matriz ni requiere estructuras auxiliares.

**Complejidad:**

- Temporal: Θ(f × c) para matrices rectangulares con columnas, siendo f la cantidad de filas y c la cantidad de columnas.
- Espacio auxiliar: O(1).
- Operaciones de acumulación: f × c, una por elemento sumado. No se cuentan comparaciones, incrementos ni otros pasos.
- Para f filas vacías, se revisan las filas en Θ(f), sin realizar acumulaciones. Una matriz nula o sin filas se procesa en tiempo constante.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 8 del TP1 de Análisis de Algoritmos: calcular la suma de todos los elementos de una matriz de números enteros.

**Estrategia:** recorrer la matriz mediante dos ciclos `for` anidados. El ciclo externo recorrerá las filas y el interno recorrerá las columnas. En cada iteración se sumará el elemento actual a una variable acumuladora y se incrementará un contador de operaciones.

**Justificación:** es necesario visitar todas las posiciones de la matriz para obtener la suma total. Los ciclos anidados permiten recorrer sistemáticamente las filas y columnas sin utilizar estructuras auxiliares.

**Complejidad:**

- Temporal: Θ(f × c), siendo `f` la cantidad de filas y `c` la cantidad de columnas.
- Espacio auxiliar: O(1).
- Cantidad de operaciones de acumulación: f × c, considerando una suma por cada elemento procesado.

**Requisitos:**

- Crear `Ejercicio8.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar un método que reciba una matriz `int[][]` y calcule la suma de sus elementos.
- Utilizar dos ciclos `for` anidados para recorrer filas y columnas.
- Contabilizar e informar las operaciones de acumulación realizadas, considerando una operación por cada elemento sumado.
- Explicar mediante comentarios qué operaciones se están contabilizando.
- Utilizar un acumulador de tipo `long` para reducir el riesgo de desbordamiento al sumar valores `int`.
- No utilizar métodos predefinidos para sumar matrices.
- No modificar la matriz original.
- Incorporar un método `main` que muestre la matriz, la suma total y la cantidad de operaciones.
- Contemplar matrices vacías, nulas y filas vacías. Suponer matrices rectangulares para el análisis Θ(f × c).
- Probar matrices cuadradas, rectangulares, con números negativos, de un único elemento y vacías.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `sumarElementos(int[][] matriz)` en `Ejercicio8.java`. Devuelve la suma como `long` e informa la cantidad de operaciones de acumulación. Las matrices nulas o vacías devuelven cero con cero acumulaciones; las filas vacías o nulas se omiten.

Se ejecutaron 11 pruebas:

| Caso | Suma | Acumulaciones |
|---|---:|---:|
| Cuadrada 2 × 2 | 10 | 4 |
| Rectangular 2 × 3 | 21 | 6 |
| Con números negativos | -10 | 4 |
| Un único elemento | 7 | 1 |
| Sin filas | 0 | 0 |
| Matriz nula | 0 | 0 |
| Dos filas vacías | 0 | 0 |
| Dos valores `Integer.MAX_VALUE` | 4294967294 | 2 |
| Dos valores `Integer.MIN_VALUE` | -4294967296 | 2 |
| Una fila nula y una con elementos | 5 | 2 |
| Filas de diferentes longitudes | 6 | 3 |

Todas las sumas y cantidades de acumulaciones coincidieron con los resultados esperados. Se verificó que las matrices originales permanecen intactas. El `main` mostró la matriz `{{1, 2, 3}, {4, 5, 6}}`, suma total `21` y `6` operaciones de acumulación.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

### Ejercicio 9 — Encontrar el mayor elemento de una matriz

**Estrategia:** Se inicializa `maximo` con el primer elemento válido y se recorre la matriz mediante dos ciclos `for` anidados. Solo se actualiza cuando se encuentra un valor mayor.

**Justificación:** El máximo puede estar en cualquier posición, por lo que deben examinarse todos los elementos. Inicializar con un valor real permite trabajar correctamente con matrices cuyos valores son todos negativos.

**Complejidad:**

- Mejor caso: Θ(f × c).
- Peor caso: Θ(f × c).
- Caso promedio: Θ(f × c).
- Espacio auxiliar: O(1).

El análisis supone matrices rectangulares con elementos, con f filas y c columnas. Si todas las filas están vacías o son nulas, se revisan las f filas en Θ(f) antes de lanzar una excepción.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 9 del TP1 de Análisis de Algoritmos: encontrar el mayor elemento de una matriz de números enteros.

**Estrategia:** recorrer todos los elementos mediante dos ciclos `for` anidados, utilizando una variable `maximo` que almacene el mayor valor encontrado. Inicializarla con el primer elemento válido de la matriz y actualizarla cuando se encuentre uno mayor.

**Justificación:** es necesario recorrer completamente la matriz porque el mayor elemento puede encontrarse en cualquier posición. No podemos finalizar anticipadamente sin haber examinado todos los valores, ya que podría existir uno mayor.

**Complejidad:**

- Mejor caso: Θ(f × c).
- Peor caso: Θ(f × c).
- Caso promedio: Θ(f × c).
- Espacio auxiliar: O(1).

Donde `f` representa la cantidad de filas y `c` la cantidad de columnas de una matriz rectangular.

**Requisitos:**

- Crear `Ejercicio9.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar un método `encontrarMaximo(int[][] matriz)` que devuelva el valor máximo.
- Recorrer la matriz mediante dos ciclos `for` anidados.
- No utilizar métodos predefinidos como `Math.max()` o algoritmos de ordenamiento.
- Inicializar el máximo con un elemento real de la matriz, no con cero, para contemplar matrices con números negativos.
- Actualizar el máximo únicamente cuando se encuentre un elemento mayor.
- No modificar la matriz original.
- Incorporar comentarios que expliquen el recorrido y la complejidad.
- Incluir un método `main` con ejemplos de funcionamiento.
- Contemplar matrices nulas y vacías mediante `IllegalArgumentException`, ya que no existe un máximo definido en esos casos.
- Probar matrices cuadradas, rectangulares, con números negativos, de un único elemento, con valores repetidos y con extremos de `int`.
- Compilar, ejecutar y verificar los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `encontrarMaximo(int[][] matriz)` en `Ejercicio9.java`. Devuelve un `int`, no modifica la matriz y lanza `IllegalArgumentException` si la matriz es nula o no contiene elementos. Las filas vacías o nulas se omiten al buscar el primer elemento y durante el recorrido.

Se ejecutaron 14 pruebas:

| Caso válido | Máximo |
|---|---:|
| Cuadrada 2 × 2 | 9 |
| Rectangular 2 × 3 | 12 |
| Todos negativos | -1 |
| Un único elemento | 7 |
| Valores repetidos | 5 |
| Ambos extremos de `int` | 2147483647 |
| Único elemento `Integer.MIN_VALUE` | -2147483648 |
| Primera fila vacía | -2 |
| Primera fila nula | -1 |
| Filas de diferentes longitudes | 10 |

También se verificó `IllegalArgumentException` en cuatro casos: matriz nula, matriz sin filas, dos filas vacías y una fila nula junto a una vacía.

Todos los resultados fueron los esperados y las matrices válidas permanecieron intactas. El `main` se ejecutó correctamente y mostró máximos `12` y `-1` para sus dos ejemplos.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

### Ejercicio 10 — Ordenamiento burbuja

**Estrategia:** Bubble Sort mediante dos ciclos `for` anidados, comparando elementos consecutivos e intercambiándolos cuando están en orden incorrecto. Cada pasada reduce el límite interno y una variable booleana permite finalizar cuando no se realizan intercambios.

**Justificación:** Es sencillo de comprender e implementar con fines didácticos y para conjuntos pequeños. Su costo cuadrático promedio y de peor caso lo hace poco conveniente para conjuntos grandes frente a algoritmos como Merge Sort.

**Complejidad:**

- Mejor caso: Θ(n), con el vector ordenado y finalización anticipada.
- Peor caso: Θ(n²), con orden inverso.
- Caso promedio: Θ(n²).
- Espacio auxiliar: O(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java el Ejercicio 10 del TP1 de Análisis de Algoritmos: ordenar un vector de números enteros utilizando el algoritmo Bubble Sort.

**Estrategia:** utilizar ordenamiento burbuja mediante dos ciclos anidados que comparen elementos consecutivos e intercambien sus posiciones cuando estén en orden incorrecto. Incorporar una variable booleana que detecte si se realizaron intercambios durante una pasada, para finalizar anticipadamente cuando el vector ya esté ordenado.

**Justificación:** Bubble Sort es sencillo de comprender e implementar, por lo que resulta útil con fines didácticos y para conjuntos pequeños. Sin embargo, no suele ser conveniente para conjuntos grandes porque su complejidad temporal promedio y de peor caso es cuadrática, a diferencia de algoritmos más eficientes como Merge Sort.

**Complejidad:**

- Mejor caso: Θ(n), cuando el vector ya está ordenado y se utiliza finalización anticipada.
- Peor caso: Θ(n²), para un vector ordenado en sentido inverso.
- Caso promedio: Θ(n²).
- Espacio auxiliar: O(1).

**Requisitos:**

- Crear `Ejercicio10.java` dentro de `TP1-Analisis-de-Algoritmos/src`, respetando la estructura existente.
- Implementar Bubble Sort manualmente mediante ciclos `for` anidados.
- Ordenar los valores de menor a mayor.
- Comparar elementos consecutivos e intercambiarlos cuando corresponda.
- Incorporar una variable booleana para detectar pasadas sin intercambios y finalizar anticipadamente.
- Reducir el límite del ciclo interno a medida que las últimas posiciones quedan ordenadas.
- Contabilizar por separado la cantidad de comparaciones entre elementos y la cantidad de intercambios.
- Mostrar el vector original, el vector ordenado y ambos contadores.
- Explicar mediante comentarios qué operaciones se contabilizan.
- No utilizar métodos predefinidos de ordenamiento como `Arrays.sort()`.
- Incorporar un método `main` con ejemplos.
- Manejar explícitamente vectores vacíos y nulos.
- Probar vectores ya ordenados, inversamente ordenados, con repetidos, negativos, de un solo elemento y vacíos.
- Compilar, ejecutar y verificar el funcionamiento y los contadores.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `ordenarBurbuja(int[] vector)` en `Ejercicio10.java`, que ordena de menor a mayor sobre el propio vector e informa dos contadores `long`. Se cuenta una comparación por cada evaluación entre elementos consecutivos y un intercambio por cada par cambiado, sin contar condiciones de ciclos ni asignaciones individuales.

Se ejecutaron 12 pruebas y se verificaron tanto el orden esperado como los contadores exactos:

| Vector original | Vector ordenado | Comparaciones | Intercambios |
|---|---|---:|---:|
| `{1, 2, 3, 4}` | `{1, 2, 3, 4}` | 3 | 0 |
| `{4, 3, 2, 1}` | `{1, 2, 3, 4}` | 6 | 6 |
| `{3, 1, 3, 1}` | `{1, 1, 3, 3}` | 6 | 3 |
| `{-1, -5, 0, -3}` | `{-5, -3, -1, 0}` | 6 | 3 |
| `{7}` | `{7}` | 0 | 0 |
| `{}` | `{}` | 0 | 0 |
| `null` | `null` | 0 | 0 |
| `{2, 1}` | `{1, 2}` | 1 | 1 |
| `{1, 2}` | `{1, 2}` | 1 | 0 |
| `{5, 5, 5}` | `{5, 5, 5}` | 2 | 0 |
| `{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}` | `{Integer.MIN_VALUE, 0, Integer.MAX_VALUE}` | 3 | 3 |
| `{2, 1, 3, 4}` | `{1, 2, 3, 4}` | 5 | 1 |

Los vectores nulos se omiten; los vacíos y unitarios no requieren comparaciones ni intercambios. También se ejecutaron correctamente los siete ejemplos del `main`, que muestran el original, el resultado y los contadores.

**Compilación y ejecución:** correctas con Java 21. Sin errores ni aspectos pendientes.

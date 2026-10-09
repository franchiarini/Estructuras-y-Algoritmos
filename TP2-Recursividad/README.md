# TP2 — Recursividad

### Metodología de trabajo

Para la resolución de este práctico se utilizaron dos agentes de inteligencia artificial:

- **Agente analista (ChatGPT):** encargado del análisis de las consignas, la elección de estrategias, el razonamiento sobre los casos base y recursivos, el análisis de complejidad y la elaboración de los prompts.
- **Agente desarrollador (Codex):** encargado de implementar los algoritmos en Java, ejecutar las pruebas y documentar los resultados.

Cada ejercicio fue analizado previamente a su implementación. Los prompts utilizados se encuentran documentados tanto en este README como al comienzo de cada archivo Java, siguiendo las indicaciones de la cátedra.

### Ejercicio 1 — Factorial

**Estrategia:** Recursividad mediante `n * factorial(n - 1)`, con casos base 0 y 1.

**Justificación:** El factorial depende del factorial del número anterior. Disminuir n en una unidad permite alcanzar un caso base conocido.

**Caso base:** cuando n vale 0 o 1, devolver 1, porque 0! = 1 y 1! = 1.

**Caso recursivo:** cuando n es mayor que 1, devolver `n * factorial(n - 1)`, reduciendo el problema en una unidad en cada llamada.

**Complejidad:**

- Temporal: Θ(n).
- Espacial auxiliar: O(n), debido a la pila de llamadas recursivas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que calcule el factorial de un número natural.

**Estrategia:** utilizar recursividad, expresando el factorial de n como n multiplicado por el factorial de n - 1.

**Justificación:** el factorial puede resolverse recursivamente porque el resultado de un número depende del factorial del número inmediatamente anterior, hasta alcanzar un caso sencillo que conocemos.

**Caso base:** cuando n vale 0 o 1, devolver 1, porque matemáticamente 0! = 1 y 1! = 1.

**Caso recursivo:** devolver `n * factorial(n - 1)` cuando n sea mayor que 1.

**Reducción del problema:** en cada llamada se disminuye n en una unidad, acercándose progresivamente al caso base.

**Complejidad:**

- Temporal: Θ(n).
- Espacial auxiliar: O(n), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio1.java` dentro de `TP2-Recursividad/src`, verificando primero la estructura real del proyecto.
- Implementar un método recursivo `factorial(int n)`.
- Utilizar `long` como tipo de retorno, para calcular correctamente factoriales hasta 20!.
- No utilizar ciclos `for` ni `while` para calcular el factorial.
- No utilizar bibliotecas que reemplacen el algoritmo recursivo.
- Manejar números negativos mediante `IllegalArgumentException`.
- Rechazar valores mayores que 20, ya que producirían desbordamiento del tipo long.
- Incorporar comentarios explicando el caso base, el caso recursivo y cómo funciona la pila de llamadas.
- Incluir un método `main` con ejemplos que muestren los resultados.
- Probar factorial(0), factorial(1), factorial(4), factorial(5), factorial(10) y factorial(20), además de entradas negativas y mayores que 20.
- Compilar y ejecutar el código con Java 21 y verificar los resultados.

No modificar ejercicios anteriores ni realizar commits o push.
~~~

#### Resultado

Se implementó `factorial(int n)` con retorno `long`, sin ciclos para calcular el factorial. Las entradas negativas o mayores que 20 lanzan `IllegalArgumentException`. El comentario inicial del archivo Java conserva el prompt académico completo, sin modificaciones.

Se ejecutaron 10 pruebas:

| Entrada | Resultado |
|---|---:|
| 0 | 1 |
| 1 | 1 |
| 4 | 24 |
| 5 | 120 |
| 10 | 3628800 |
| 20 | 2432902008176640000 |

Las entradas `-1`, `21`, `Integer.MIN_VALUE` e `Integer.MAX_VALUE` lanzaron `IllegalArgumentException`, como se esperaba. Todos los resultados fueron correctos. También se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Los archivos de prueba y compilados se generaron fuera del repositorio.


### Ejercicio 2 — Suma de los primeros N números

**Estrategia:** Suma recursiva del valor n y la suma de los naturales anteriores, sin ciclos ni fórmula cerrada.

**Justificación:** La suma de los primeros n naturales se descompone en n más la suma hasta n - 1, delegando el resto a una llamada con un problema más pequeño.

**Caso base:** Cuando n vale 0, se devuelve 0.

**Caso recursivo:** Para n mayor que 0, se devuelve `n + suma(n - 1)`. Cada llamada reduce n en una unidad hasta alcanzar cero. Las llamadas pendientes se almacenan en el Call Stack y completan sus sumas al retornar.

**Complejidad:**

- Temporal: Θ(n).
- Espacial auxiliar: O(n), debido a la pila de llamadas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que calcule la suma de los primeros N números naturales, desde n hasta 1.

**Estrategia:** utilizar recursividad para descomponer la suma de los primeros n números en el valor n más la suma de los números anteriores.

**Justificación:** la suma puede resolverse recursivamente porque `suma(n)` equivale a `n + suma(n - 1)`. De esta manera, cada llamada resuelve una parte del problema y delega el resto a una versión más pequeña de la misma función.

**Caso base:** cuando `n == 0`, devolver 0, porque no quedan números por sumar.

**Caso recursivo:** cuando `n > 0`, devolver `n + suma(n - 1)`.

**Reducción del problema:** en cada llamada se disminuye n en una unidad hasta alcanzar el caso base.

**Complejidad:**

- Temporal: Θ(n), porque se realizan n llamadas recursivas más el caso base.
- Espacial auxiliar: O(n), debido a la pila de llamadas.

**Requisitos:**

- Crear `Ejercicio2.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `suma(int n)` que devuelva un `long`.
- Utilizar exclusivamente recursividad para calcular la suma, sin ciclos `for` ni `while`.
- No utilizar la fórmula matemática `n * (n + 1) / 2` como implementación, ya que el objetivo es demostrar la recursividad. Puede utilizarse para verificar los resultados.
- Manejar los números negativos mediante `IllegalArgumentException`.
- Establecer un límite superior conservador de `n = 1000` para evitar una pila de llamadas excesivamente profunda.
- Incluir comentarios explicativos sobre el caso base, el caso recursivo y el funcionamiento del Call Stack.
- Incorporar un método `main` con ejemplos.
- Probar suma(0), suma(1), suma(4), suma(5), suma(10), suma(100) y suma(1000).
- Verificar que suma(5) devuelva 15 y suma(100) devuelva 5050.
- Probar entradas negativas y mayores que 1000, verificando que se rechacen correctamente.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `suma(int n)` con retorno `long` y validación del rango 0–1000 mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio2.java` conserva literalmente el prompt académico, sin modificaciones.

Se ejecutaron 11 pruebas:

| Entrada | Resultado |
|---|---:|
| 0 | 0 |
| 1 | 1 |
| 4 | 10 |
| 5 | 15 |
| 10 | 55 |
| 100 | 5050 |
| 1000 | 500500 |

Las entradas `-1`, `1001`, `Integer.MIN_VALUE` e `Integer.MAX_VALUE` lanzaron `IllegalArgumentException`, como se esperaba. Todos los resultados fueron correctos y también se ejecutaron los ejemplos del `main`. La llamada con n = 1000 se completó correctamente en este entorno.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y los compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 3 — Multiplicación mediante sumas

**Estrategia:** Sumar recursivamente el primer factor a tantas veces como indica b, manteniendo a constante y reduciendo exclusivamente b.

**Justificación:** La multiplicación equivale a sumas repetidas. Cada llamada suma una copia del primer factor y delega las restantes a un problema más pequeño.

**Caso base:** Cuando b vale cero, se devuelve `0L`.

**Caso recursivo:** Se devuelve `a + multiplicar(a, b - 1)`. Las llamadas pendientes se almacenan en la pila y completan sus sumas al retornar.

**Complejidad:**

- Temporal: Θ(b + 1), para b no negativo.
- Espacial auxiliar: O(b + 1), debido a la pila de llamadas recursivas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que permita multiplicar dos números enteros mediante sumas repetidas, sin utilizar el operador de multiplicación `*`.

**Estrategia:** interpretar la multiplicación como la suma repetida del primer factor. Mantener constante el parámetro `a` y disminuir el segundo parámetro `b` en cada llamada recursiva.

**Justificación:** una multiplicación puede representarse como sumas sucesivas. Por ejemplo, multiplicar 4 por 3 equivale a sumar 4 tres veces. Esto permite reducir progresivamente el problema hasta llegar a una multiplicación por cero.

**Caso base:** cuando `b == 0`, devolver 0, porque cualquier número multiplicado por cero es igual a cero.

**Caso recursivo:** cuando `b > 0`, devolver `a + multiplicar(a, b - 1)`.

**Reducción del problema:** en cada llamada disminuye `b` en una unidad, hasta llegar al caso base, mientras `a` permanece constante.

**Complejidad:**

- Temporal: Θ(b + 1), siendo b el segundo factor no negativo.
- Espacial auxiliar: O(b + 1), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio3.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar el método recursivo `multiplicar(int a, int b)` con retorno `long`.
- Utilizar exclusivamente sumas y llamadas recursivas para calcular la multiplicación.
- No utilizar el operador `*`, ciclos `for`, `while` ni métodos predefinidos de multiplicación dentro del algoritmo.
- Reducir exclusivamente el segundo parámetro `b`.
- Permitir que `a` sea positivo, negativo o cero.
- Admitir valores de `b` entre 0 y 1000, rechazando los negativos y superiores a 1000 mediante `IllegalArgumentException`, para evitar una profundidad de recursión excesiva.
- Incorporar comentarios que expliquen el caso base, el caso recursivo y el comportamiento de la pila de llamadas.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar multiplicar(4, 3), multiplicar(5, 0), multiplicar(0, 5), multiplicar(-4, 3), multiplicar(7, 1) y multiplicar(10, 10).
- Probar también valores grandes de `a`, incluyendo los extremos de `int`, para verificar que el resultado `long` sea correcto.
- Comprobar que los valores negativos y superiores a 1000 de `b` sean rechazados.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `multiplicar(int a, int b)` con retorno `long`, sin operador de multiplicación ni ciclos dentro del algoritmo. El parámetro a admite cualquier valor `int`; b se valida en el rango 0–1000 mediante `IllegalArgumentException`. El comentario inicial del archivo conserva literalmente el prompt académico, sin modificaciones.

Se ejecutaron 15 pruebas:

| a | b | Resultado |
|---|---:|---:|
| 4 | 3 | 12 |
| 5 | 0 | 0 |
| 0 | 5 | 0 |
| -4 | 3 | -12 |
| 7 | 1 | 7 |
| 10 | 10 | 100 |
| Integer.MAX_VALUE | 1000 | 2147483647000 |
| Integer.MIN_VALUE | 1000 | -2147483648000 |
| Integer.MAX_VALUE | 2 | 4294967294 |
| Integer.MIN_VALUE | 2 | -4294967296 |
| 0 | 1000 | 0 |

Los valores de b `-1`, `1001`, `Integer.MIN_VALUE` e `Integer.MAX_VALUE` lanzaron `IllegalArgumentException`, como se esperaba. Todos los resultados fueron correctos. También se ejecutaron los ejemplos del `main`; las llamadas con b = 1000 se completaron correctamente en este entorno.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 4 — Potencia

**Estrategia:** Multiplicaciones sucesivas mediante recursividad, manteniendo la base constante y disminuyendo el exponente en cada llamada. Se utiliza `Math.multiplyExact()` para detectar desbordamientos de `long`.

**Justificación:** Una potencia con exponente positivo se expresa como la base multiplicada por la potencia de exponente inmediatamente anterior, reduciendo el problema hasta llegar a cero.

**Caso base:** Para exponente cero se devuelve `1L`, incluida la convención adoptada para `potencia(0, 0)`.

**Caso recursivo:** Se multiplica la base por `potencia(base, exponente - 1)`. Las llamadas pendientes se almacenan en la pila y realizan sus multiplicaciones al retornar.

**Complejidad:**

- Temporal: Θ(n + 1), siendo n el exponente no negativo.
- Espacial auxiliar: O(n + 1), debido a la pila de llamadas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que calcule la potencia de un número entero, sin utilizar `Math.pow()`.

**Estrategia:** representar una potencia como multiplicaciones sucesivas de la base. Utilizar recursividad, manteniendo constante la base y disminuyendo el exponente en cada llamada.

**Justificación:** una potencia puede expresarse como la multiplicación de una base por sí misma tantas veces como indique el exponente. Esto permite dividir el problema en una multiplicación y una potencia con exponente menor.

**Caso base:** cuando `exponente == 0`, devolver 1, porque toda base distinta de cero elevada a cero es igual a uno. Para esta implementación también se adopta la convención de devolver 1 cuando base y exponente son ambos cero.

**Caso recursivo:** cuando `exponente > 0`, devolver `base * potencia(base, exponente - 1)`.

**Reducción del problema:** disminuir el exponente en una unidad por cada llamada, manteniendo constante la base hasta alcanzar el caso base.

**Complejidad:**

- Temporal: Θ(n + 1), siendo n el exponente no negativo.
- Espacial auxiliar: O(n + 1), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio4.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar el método recursivo `potencia(int base, int exponente)` con retorno `long`.
- Utilizar multiplicaciones sucesivas y llamadas recursivas, sin ciclos `for` ni `while` dentro del algoritmo.
- No utilizar `Math.pow()` ni otros métodos predefinidos de potenciación.
- Manejar exponentes negativos mediante `IllegalArgumentException`.
- Verificar que las multiplicaciones no produzcan desbordamiento del tipo `long`, utilizando `Math.multiplyExact()` para detectar el error si resulta necesario.
- Limitar el exponente a un máximo de 1000 para evitar una profundidad excesiva de recursión.
- Incorporar comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
- Incluir un método `main` con ejemplos que muestren los resultados.
- Probar potencia(2, 4), potencia(3, 3), potencia(5, 0), potencia(0, 5), potencia(-2, 3), potencia(-2, 4) y potencia(1, 1000).
- Probar también exponentes negativos, valores que produzcan desbordamiento y el caso potencia(0, 0).
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `potencia(int base, int exponente)` con retorno `long`, sin ciclos ni métodos predefinidos de potenciación. Se validan exponentes entre 0 y 1000 mediante `IllegalArgumentException`; `Math.multiplyExact()` lanza `ArithmeticException` ante desbordamiento. El comentario inicial del archivo conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 22 pruebas:

| Base | Exponente | Resultado |
|---|---:|---:|
| 2 | 4 | 16 |
| 3 | 3 | 27 |
| 5 | 0 | 1 |
| 0 | 5 | 0 |
| -2 | 3 | -8 |
| -2 | 4 | 16 |
| 1 | 1000 | 1 |
| 0 | 0 | 1 |
| 2 | 62 | 4611686018427387904 |
| -2 | 63 | -9223372036854775808 |
| Integer.MAX_VALUE | 2 | 4611686014132420609 |
| Integer.MIN_VALUE | 2 | 4611686018427387904 |
| -1 | 1000 | 1 |
| 0 | 1000 | 0 |

Los exponentes `-1`, `1001`, `Integer.MIN_VALUE` e `Integer.MAX_VALUE` lanzaron `IllegalArgumentException`. Las entradas `(2, 63)`, `(-2, 64)`, `(Integer.MAX_VALUE, 3)` y `(Integer.MIN_VALUE, 3)` lanzaron `ArithmeticException` por desbordamiento.

Todos los resultados fueron correctos. También se ejecutaron los ejemplos del `main`; las llamadas de exponente 1000 se completaron correctamente en este entorno.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 5 — Conteo regresivo

**Estrategia:** Función recursiva `void` que imprime el valor actual antes de llamar con un valor menor. No devuelve un resultado porque su propósito es imprimir la secuencia.

**Justificación:** Cada llamada reduce el conteo pendiente en una unidad, acercándose a cero.

**Caso base:** Cuando n vale cero, se imprime 0 y se retorna sin otra llamada.

**Caso recursivo:** Se imprime n y se ejecuta `conteoRegresivo(n - 1)`. Las llamadas permanecen en la pila hasta alcanzar el caso base y luego retornan en orden inverso. Utilizar n + 1 alejaría el problema de cero y, sin validación superior, podría provocar `StackOverflowError`; con la validación implementada se rechazaría 1001.

**Complejidad:**

- Temporal: Θ(n + 1).
- Espacial auxiliar: O(n + 1), debido a la pila de llamadas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que imprima un conteo regresivo desde un número entero n hasta cero.

**Estrategia:** utilizar una función recursiva de tipo `void` que imprima el número actual antes de llamar nuevamente a la función con un valor menor.

**Justificación:** el conteo regresivo puede resolverse recursivamente porque cada número da lugar al mismo problema con un valor reducido en una unidad, hasta llegar a cero. La función no necesita devolver un valor, ya que su propósito es imprimir números en pantalla.

**Caso base:** cuando `n == 0`, imprimir el número 0 y finalizar sin realizar otra llamada recursiva.

**Caso recursivo:** cuando `n > 0`, imprimir el valor actual y ejecutar `conteoRegresivo(n - 1)`.

**Reducción del problema:** disminuir n en una unidad en cada llamada hasta alcanzar el caso base. Si se utilizara `n + 1`, la función se alejaría de cero y podría producir un `StackOverflowError` por no alcanzar el caso base.

**Complejidad:**

- Temporal: Θ(n + 1), porque se imprimen todos los números desde n hasta cero.
- Espacial auxiliar: O(n + 1), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio5.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `conteoRegresivo(int n)` con retorno `void`.
- Imprimir los números desde n hasta cero, incluyendo ambos extremos.
- Utilizar exclusivamente recursividad, sin ciclos `for` ni `while` para generar el conteo.
- Manejar números negativos mediante `IllegalArgumentException`.
- Limitar n a un máximo de 1000 para evitar una profundidad de recursión excesiva.
- Incorporar comentarios explicando el caso base, el caso recursivo y la pila de llamadas.
- Explicar mediante comentarios por qué se utiliza `void` y qué sucedería si se llamara con `n + 1`.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar conteoRegresivo(0), conteoRegresivo(1), conteoRegresivo(4), conteoRegresivo(5) y conteoRegresivo(10).
- Verificar que la secuencia impresa sea correcta, incluyendo el cero.
- Probar entradas negativas y superiores a 1000, verificando que se rechacen correctamente.
- No ejecutar intencionalmente una recursión infinita para demostrar el error.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `conteoRegresivo(int n)` con retorno `void`, sin ciclos para generar el conteo y con validación del rango 0–1000 mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio5.java` conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 10 pruebas, capturando la salida y comparándola completamente con la secuencia esperada, con un número por línea:

| Entrada válida | Secuencia verificada | Cantidad de números |
|---|---|---:|
| 0 | 0 | 1 |
| 1 | 1, 0 | 2 |
| 4 | 4, 3, 2, 1, 0 | 5 |
| 5 | 5, 4, 3, 2, 1, 0 | 6 |
| 10 | Del 10 al 0, sin omisiones | 11 |
| 1000 | Del 1000 al 0, sin omisiones | 1001 |

Las entradas `-1`, `1001`, `Integer.MIN_VALUE` e `Integer.MAX_VALUE` lanzaron `IllegalArgumentException` sin imprimir una secuencia parcial. Todas las pruebas fueron correctas y también se ejecutaron los ejemplos del `main`. No se ejecutó ninguna recursión infinita.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 6 — Contar dígitos

**Estrategia:** División entera sucesiva por 10 mediante recursividad, sin ciclos ni conversión del número a texto para contar.

**Justificación:** Cada división entera por 10 elimina el último dígito y reduce el problema hasta llegar a una sola cifra.

**Caso base:** Para n menor que 10, después de validar que no sea negativo, se devuelve 1. El cero tiene un dígito.

**Caso recursivo:** Se devuelve `1 + contarDigitos(n / 10)`. Cada llamada espera en la pila el conteo del número reducido; al retornar, suma el dígito eliminado.

**Complejidad:**

- Temporal: Θ(log₁₀ n), para n >= 10.
- Espacial auxiliar: O(log₁₀ n), debido a la pila de llamadas.
- Para n entre 0 y 9, tiempo y espacio son Θ(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que cuente la cantidad de dígitos de un número entero no negativo.

**Estrategia:** utilizar división entera sucesiva por 10 para eliminar el último dígito del número en cada llamada recursiva.

**Justificación:** un número puede descomponerse eliminando progresivamente su último dígito. Cada división entera por 10 reduce la cantidad de dígitos hasta llegar a un número de una sola cifra.

**Caso base:** cuando `n < 10`, devolver 1, ya que cualquier número entero no negativo menor que 10 tiene un solo dígito.

**Caso recursivo:** cuando `n >= 10`, devolver `1 + contarDigitos(n / 10)`.

**Reducción del problema:** dividir n por 10 utilizando división entera. Esto elimina el último dígito y acerca el problema al caso base.

**Complejidad:**

- Temporal: Θ(log₁₀ n) para n >= 10, porque se elimina un dígito en cada llamada.
- Espacial auxiliar: O(log₁₀ n), debido a la pila de llamadas.
- Para n entre 0 y 9, ambas complejidades son Θ(1).

**Requisitos:**

- Crear `Ejercicio6.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `contarDigitos(int n)` que devuelva un `int`.
- Utilizar división entera por 10 y llamadas recursivas.
- No utilizar ciclos `for` ni `while` para contar los dígitos.
- No convertir el número a `String` ni utilizar métodos predefinidos para obtener su longitud.
- Manejar números negativos mediante `IllegalArgumentException`.
- Considerar que el número cero tiene un dígito.
- Incorporar comentarios explicando el caso base, el caso recursivo y cómo funciona la pila de llamadas.
- Incluir un método `main` con ejemplos.
- Probar contarDigitos(0), contarDigitos(5), contarDigitos(10), contarDigitos(5832), contarDigitos(10000) y contarDigitos(2147483647).
- Verificar que los resultados sean respectivamente 1, 1, 2, 4, 5 y 10.
- Probar entradas negativas y comprobar que se rechacen correctamente.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `contarDigitos(int n)` con retorno `int` y rechazo de negativos mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio6.java` conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 14 pruebas:

| Entrada válida | Dígitos |
|---|---:|
| 0 | 1 |
| 5 | 1 |
| 10 | 2 |
| 5832 | 4 |
| 10000 | 5 |
| 2147483647 | 10 |
| 9 | 1 |
| 99 | 2 |
| 100 | 3 |
| 999999999 | 9 |
| 1000000000 | 10 |

Las entradas `-1`, `-10` e `Integer.MIN_VALUE` lanzaron `IllegalArgumentException`, como se esperaba. Todas las pruebas fueron correctas y también se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 7 — Sumar dígitos

**Estrategia:** Obtener el último dígito con `n % 10` y sumar recursivamente los restantes usando división entera `n / 10`.

**Justificación:** El número se descompone en su último dígito y el resto. Cada división elimina una cifra y acerca el problema al caso base.

**Caso base:** Para n menor que 10, después de validar que no sea negativo, se devuelve n. La suma de los dígitos de cero es cero.

**Caso recursivo:** Se devuelve `n % 10 + sumarDigitos(n / 10)`. Al regresar por la pila de llamadas, cada llamada agrega su último dígito al resultado del número reducido.

**Complejidad:**

- Temporal: Θ(log₁₀ n), para n >= 10.
- Espacial auxiliar: O(log₁₀ n), debido a la pila de llamadas.
- Para n entre 0 y 9, tiempo y espacio son Θ(1).

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que calcule la suma de los dígitos de un número entero no negativo.

**Estrategia:** utilizar el operador módulo `%` para obtener el último dígito y la división entera `/ 10` para eliminarlo en cada llamada recursiva.

**Justificación:** un número puede descomponerse en su último dígito y los dígitos restantes. Esto permite sumar el último dígito al resultado obtenido recursivamente del número reducido.

**Caso base:** cuando `n < 10`, devolver n, porque un número de una sola cifra tiene como suma de sus dígitos su propio valor.

**Caso recursivo:** cuando `n >= 10`, devolver `n % 10 + sumarDigitos(n / 10)`.

**Reducción del problema:** dividir n entre 10 mediante división entera, eliminando el último dígito en cada llamada hasta alcanzar un número menor que 10.

**Complejidad:**

- Temporal: Θ(log₁₀ n), para n >= 10.
- Espacial auxiliar: O(log₁₀ n), debido a la pila de llamadas.
- Para n entre 0 y 9, ambas complejidades son Θ(1).

**Requisitos:**

- Crear `Ejercicio7.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `sumarDigitos(int n)` que devuelva un `int`.
- Utilizar exclusivamente operaciones de módulo, división entera y llamadas recursivas para calcular la suma.
- No utilizar ciclos `for` ni `while` dentro del algoritmo.
- No convertir el número a `String` ni utilizar métodos predefinidos para procesar sus dígitos.
- Manejar números negativos mediante `IllegalArgumentException`.
- Considerar que sumar los dígitos de cero devuelve cero.
- Incorporar comentarios que expliquen el caso base, el caso recursivo y cómo se combinan los resultados al regresar por la pila de llamadas.
- Incluir un método `main` con ejemplos.
- Probar sumarDigitos(0), sumarDigitos(5), sumarDigitos(10), sumarDigitos(5832), sumarDigitos(9999), sumarDigitos(10000) y sumarDigitos(2147483647).
- Verificar que los resultados sean respectivamente 0, 5, 1, 18, 36, 1 y 46.
- Probar entradas negativas y comprobar que sean rechazadas correctamente.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `sumarDigitos(int n)` con retorno `int`, sin ciclos ni conversión a texto para procesar los dígitos. Los negativos se rechazan mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio7.java` conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 14 pruebas:

| Entrada válida | Suma de dígitos |
|---|---:|
| 0 | 0 |
| 5 | 5 |
| 10 | 1 |
| 5832 | 18 |
| 9999 | 36 |
| 10000 | 1 |
| 2147483647 | 46 |
| 9 | 9 |
| 10101 | 3 |
| 999999999 | 81 |
| 1000000000 | 1 |

Las entradas `-1`, `-10` e `Integer.MIN_VALUE` lanzaron `IllegalArgumentException`, como se esperaba. Todas las pruebas fueron correctas y también se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 8 — Invertir una palabra

**Estrategia:** Separar el primer carácter, invertir recursivamente el resto mediante `substring(1)` y agregar al final el carácter obtenido con `charAt(0)`.

**Justificación:** La inversión de una cadena más pequeña permite reconstruir la palabra en orden inverso durante el retorno de las llamadas.

**Caso base:** Una cadena vacía o de un solo carácter se devuelve directamente.

**Caso recursivo:** Se devuelve `invertir(palabra.substring(1)) + palabra.charAt(0)`, reduciendo la longitud en una unidad por llamada.

**Complejidad:**

- Temporal: O(n²), por las operaciones de substring y concatenación.
- Espacial auxiliar: O(n²), considerando las cadenas intermedias y la pila de llamadas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que invierta una palabra representada mediante un String.

**Estrategia:** separar el primer carácter de la cadena y resolver recursivamente la inversión del resto utilizando `substring(1)`. Cuando la llamada recursiva devuelva su resultado, agregar el primer carácter al final.

**Justificación:** una palabra puede invertirse resolviendo primero la inversión de una cadena más pequeña y colocando después el carácter que se separó inicialmente. Este procedimiento permite construir el resultado en orden inverso durante el retorno de las llamadas.

**Caso base:** cuando la cadena está vacía o contiene un único carácter, devolverla directamente porque ya está invertida.

**Caso recursivo:** devolver `invertir(palabra.substring(1)) + palabra.charAt(0)`.

**Reducción del problema:** en cada llamada se elimina el primer carácter, reduciendo la longitud de la cadena en una unidad hasta alcanzar el caso base.

**Complejidad:**

- Temporal: O(n²), debido a las operaciones de substring y concatenación de cadenas.
- Espacial auxiliar: O(n²), considerando las cadenas intermedias generadas durante la recursión y la pila de llamadas.

**Requisitos:**

- Crear `Ejercicio8.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método recursivo `invertir(String palabra)` que devuelva un `String`.
- Utilizar `substring(1)` y `charAt(0)` para construir la solución recursiva.
- No utilizar ciclos `for` ni `while` dentro del algoritmo.
- No utilizar `StringBuilder.reverse()` ni métodos predefinidos para invertir cadenas.
- Considerar como casos base las cadenas vacías y las cadenas de un carácter.
- Manejar entradas nulas mediante `IllegalArgumentException`.
- Incorporar comentarios explicando el caso base, el caso recursivo y el funcionamiento de la pila de llamadas.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar invertir("HOLA"), invertir("Java"), invertir("recursion"), invertir("a") e invertir("").
- Verificar los resultados esperados: "ALOH", "avaJ", "noisrucer", "a" y "".
- Probar también palabras palíndromas, cadenas con espacios y caracteres repetidos.
- Verificar que el String original no se modifica.
- Compilar y ejecutar con Java 21, comprobando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó `invertir(String palabra)` sin ciclos ni métodos predefinidos de inversión. Las entradas nulas se rechazan mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio8.java` conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 12 pruebas:

| Entrada válida | Resultado |
|---|---|
| `"HOLA"` | `"ALOH"` |
| `"Java"` | `"avaJ"` |
| `"recursion"` | `"noisrucer"` |
| `"a"` | `"a"` |
| `""` | `""` |
| `"reconocer"` | `"reconocer"` |
| `"hola mundo"` | `"odnum aloh"` |
| `"aabb"` | `"bbaa"` |
| `"   "` | `"   "` |
| `" ab "` | `" ba "` |
| `"aaaa"` | `"aaaa"` |

La entrada `null` lanzó `IllegalArgumentException`. Todos los resultados fueron correctos; se verificó que las cadenas originales permanecen intactas y que invertir dos veces recupera cada original válido. También se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 9 — Palíndromo

**Estrategia:** Comparar recursivamente los caracteres de ambos extremos mediante los índices inicio y fin, respetando mayúsculas, minúsculas y espacios.

**Justificación:** Si los extremos coinciden, basta comprobar el interior. Una diferencia permite finalizar inmediatamente con `false`.

**Caso base:** Cuando `inicio >= fin`, se devuelve `true`, porque quedan cero o un carácter por comparar.

**Caso recursivo:** Si los extremos coinciden, se comprueba la misma cadena con `inicio + 1` y `fin - 1`. El resultado se propaga al retornar por la pila de llamadas.

**Complejidad:**

- Mejor caso: Θ(1), cuando los extremos son distintos.
- Peor caso: Θ(n), cuando se comparan todos los pares.
- Espacio auxiliar: O(n), debido a la pila de llamadas recursivas.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que determine si una palabra es un palíndromo, es decir, si se lee igual desde ambos extremos.

**Estrategia:** comparar el primer carácter con el último. Si son iguales, continuar recursivamente con los caracteres interiores mediante dos índices que se acercan al centro.

**Justificación:** una palabra es palíndroma si sus caracteres extremos coinciden y la parte interior también es palíndroma. Si encontramos una diferencia, podemos finalizar inmediatamente porque ya sabemos que la palabra no cumple la condición.

**Caso base:** cuando `inicio >= fin`, devolver `true`, porque quedan cero o un carácter por comparar.

**Caso de diferencia:** si `palabra.charAt(inicio) != palabra.charAt(fin)`, devolver `false` inmediatamente.

**Caso recursivo:** cuando ambos caracteres coinciden, devolver el resultado de comparar las posiciones interiores, llamando a la función con `inicio + 1` y `fin - 1`.

**Reducción del problema:** en cada llamada se descartan los dos caracteres extremos y se reduce el intervalo de búsqueda hasta alcanzar el centro de la palabra.

**Complejidad:**

- Mejor caso: Θ(1), cuando los extremos son distintos.
- Peor caso: Θ(n), cuando es necesario comparar todos los pares.
- Espacio auxiliar: O(n), debido a la pila de llamadas recursivas.

**Requisitos:**

- Crear `Ejercicio9.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método público `esPalindromo(String palabra)` y un método auxiliar recursivo que reciba la cadena y los índices `inicio` y `fin`.
- Utilizar exclusivamente recursividad para comprobar los caracteres, sin ciclos `for` ni `while`.
- No utilizar `StringBuilder.reverse()` ni métodos predefinidos que resuelvan directamente el problema.
- Comparar los caracteres respetando mayúsculas y minúsculas; no normalizar ni eliminar espacios.
- Considerar que una cadena vacía y una cadena de un solo carácter son palíndromos.
- Manejar entradas nulas mediante `IllegalArgumentException`.
- Incorporar comentarios que expliquen el caso base, la comparación de extremos, el caso recursivo y la pila de llamadas.
- Incluir un método `main` con ejemplos.
- Probar las palabras "radar", "reconocer", "oso", "casa" y "Java".
- Probar también cadenas vacías, de un carácter, con longitud par, con longitud impar y con caracteres repetidos.
- Verificar que la cadena original no se modifica.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó el método público `esPalindromo(String palabra)` y un auxiliar privado recursivo que recibe la cadena y los índices inicio y fin. No se utilizan ciclos ni inversión de cadenas. Las entradas nulas se rechazan mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio9.java` conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 17 pruebas:

| Entrada válida | Resultado |
|---|---|
| `"radar"` | true |
| `"reconocer"` | true |
| `"oso"` | true |
| `"casa"` | false |
| `"Java"` | false |
| `""` | true |
| `"a"` | true |
| `"abba"` | true |
| `"aaaa"` | true |
| `"Radar"` | false |
| `" oso"` | false |
| `"a a"` | true |
| `"abca"` | false |
| `"ab"` | false |
| `"aa"` | true |
| `"   "` | true |

La entrada `null` lanzó `IllegalArgumentException`. Todos los resultados fueron correctos y se verificó que las cadenas originales permanecen intactas. También se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.


### Ejercicio 10 — Buscar un elemento en un arreglo

**Estrategia:** Búsqueda lineal recursiva desde el índice 0, avanzando una posición por llamada y finalizando en la primera coincidencia.

**Justificación:** Cada llamada examina una posición y delega la búsqueda restante a la siguiente, reemplazando una iteración de un ciclo.

**Caso base:** Primero se verifica el final del arreglo y se devuelve -1 para evitar accesos fuera de sus límites. Si el elemento actual coincide, se devuelve inmediatamente su índice. Un arreglo vacío devuelve -1.

**Caso recursivo:** Si no hay coincidencia, se llama al auxiliar con `indice + 1`, reduciendo la cantidad de posiciones pendientes. Al regresar por la pila se propaga el índice encontrado o -1.

**Complejidad:**

- Mejor caso: Θ(1), si el elemento está al inicio.
- Peor caso: Θ(n), si está al final o no existe.
- Caso promedio: Θ(n), suponiendo posiciones equiprobables.
- Espacio auxiliar: O(n), debido a la pila de llamadas en el peor caso.

#### Prompt generado por el agente analista

~~~markdown
Implementá en Java una función recursiva que busque un número entero dentro de un arreglo, sin utilizar ciclos.

**Estrategia:** utilizar búsqueda lineal recursiva, comenzando desde el índice 0 y avanzando de una posición a la siguiente mediante llamadas recursivas.

**Justificación:** podemos recorrer un arreglo recursivamente porque, después de examinar una posición, el problema se reduce a buscar el elemento en las posiciones restantes. No necesitamos utilizar ciclos, ya que cada llamada recursiva reemplaza una iteración.

**Caso base 1 — Elemento encontrado:** si el elemento ubicado en el índice actual coincide con el valor buscado, devolver ese índice inmediatamente.

**Caso base 2 — Fin del arreglo:** si el índice alcanza la longitud del arreglo, devolver -1, indicando que el valor no fue encontrado.

**Caso recursivo:** si el elemento actual no coincide, llamar nuevamente a la función aumentando el índice en una unidad.

**Reducción del problema:** comenzar en la primera posición y avanzar mediante `indice + 1`, reduciendo la cantidad de elementos pendientes de revisar hasta encontrar una coincidencia o llegar al final.

**Complejidad:**

- Mejor caso: Θ(1), si el elemento está en la primera posición.
- Peor caso: Θ(n), si está al final o no existe.
- Caso promedio: Θ(n), suponiendo que el elemento buscado puede estar en cualquiera de las posiciones con igual probabilidad.
- Espacio auxiliar: O(n), debido a la pila de llamadas recursivas en el peor caso.

**Requisitos:**

- Crear `Ejercicio10.java` dentro de `TP2-Recursividad/src`, respetando la estructura existente.
- Implementar un método público `buscar(int[] arreglo, int valor)` y un método auxiliar recursivo que reciba el arreglo, el valor buscado y el índice actual.
- Comenzar siempre la búsqueda desde el índice 0.
- No utilizar ciclos `for`, `while` ni métodos predefinidos de búsqueda dentro del algoritmo.
- Devolver el índice de la primera aparición del elemento o -1 si no existe.
- Verificar primero si se alcanzó el final del arreglo, para evitar accesos fuera de sus límites.
- Finalizar inmediatamente al encontrar el valor buscado.
- Considerar que un arreglo vacío devuelve -1.
- Manejar arreglos nulos mediante `IllegalArgumentException`.
- Incorporar comentarios que expliquen los dos casos base, el caso recursivo, la reducción del problema y el funcionamiento de la pila de llamadas.
- Incluir un método `main` con ejemplos de funcionamiento.
- Probar un valor al inicio, en el medio, al final, inexistente y repetido.
- Probar también arreglos vacíos, de un único elemento, números negativos y extremos de `int`.
- Verificar que el arreglo original no se modifica.
- Compilar y ejecutar con Java 21, verificando los resultados.

No modificar otros ejercicios ni realizar commits o push.
~~~

#### Resultado

Se implementó el método público `buscar(int[] arreglo, int valor)` y un auxiliar privado recursivo que recibe el índice actual. No se utilizan ciclos ni métodos predefinidos de búsqueda dentro del algoritmo. Los arreglos nulos se rechazan mediante `IllegalArgumentException`. El comentario inicial de `Ejercicio10.java` conserva el prompt académico literal, sin modificaciones.

Se ejecutaron 15 pruebas. Para `{8, 3, 12, 1, 3, 6}`:

| Valor buscado | Caso | Índice |
|---|---|---:|
| 8 | Inicio | 0 |
| 12 | Medio | 2 |
| 6 | Final | 5 |
| 10 | Inexistente | -1 |
| 3 | Repetido | 1 |

También se verificaron: arreglo vacío (-1), un elemento coincidente (0) o distinto (-1), negativos (índice 1), ambos extremos de `int` (índices 0 y 1), todos los elementos iguales (primera posición 0), cero repetido (primera posición 0) y un valor ausente en un arreglo de diez elementos (-1).

La entrada `null` lanzó `IllegalArgumentException`. Todas las pruebas dieron los resultados esperados y se verificó que los arreglos originales permanecen intactos. También se ejecutaron los ejemplos del `main`.

**Compilación y ejecución:** correctas con Java 21, usando `--release 21` y `-Xlint:all`, sin advertencias. Las pruebas y compilados se generaron fuera del repositorio. Sin inconvenientes.

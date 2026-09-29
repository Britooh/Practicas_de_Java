# Bitácora del capitán

Te damos la bienvenida a Bitácora del capitán en el track Java de Exercism.
Si necesitas ayuda para ejecutar las pruebas o enviar tu código, consulta `HELP.md`.
Si te atascas con el ejercicio, consulta `HINTS.md`, pero primero intenta resolverlo sin usarlos :)

## Introduction

## Aleatoriedad

Una instancia de la clase `java.util.Random` se puede usar para generar números aleatorios en Java.

### Números enteros aleatorios

Un número entero aleatorio se puede generar con el método `nextInt()`.
Esto generará un valor en el rango de `Integer.MIN_VALUE` a `Integer.MAX_VALUE`.

```java
Random random = new Random();

random.nextInt();
// => -1169335537
```

Para limitar el rango de los valores generados, usa `nextInt(int)`.
Esto generará un valor en el rango de `0` (inclusive) hasta el límite superior dado (exclusive).

Por ejemplo, esto generará un número aleatorio del `0` al `9`.

```java
Random random = new Random();

random.nextInt(10);
// => 6
```

Y esto generará un número aleatorio del `10` al `19`.

```java
Random random = new Random();

10 + random.nextInt(10);
// => 11
```

### Números de punto flotante aleatorios

Un número de punto flotante aleatorio se puede generar con el método `nextDouble()`.
Esto generará un valor en el rango de `0.0` a `1.0`.

```java
Random random = new Random();

random.nextDouble();
// => 0.19250004204021398
```

Y esto generará un número aleatorio de `100.0` a `200.0`.

```java
Random random = new Random();

100.0 + 100.0 * random.nextDouble();
// => 111.31849856260328
```

## Instructions

Mary es una gran fan de la serie de televisión _Star Trek: The Next Generation_.
A menudo juega juegos de rol de lápiz y papel, en los que ella y sus amigos fingen ser la tripulación de la _Starship Enterprise_.
El personaje de Mary es el capitán Picard, lo que significa que tiene que llevar el registro del capitán.
Le encanta la parte creativa del juego, pero no le gusta generar datos aleatorios sobre la marcha.

Ayuda a Mary creando generadores aleatorios para los datos que aparecen con frecuencia en el registro del capitán.

~~~~exercism/note
La implementación inicial de este ejercicio recibe una instancia de `java.util.Random` como argumento del constructor.
Esto permite que las pruebas del ejercicio pasen una instancia con una semilla predefinida, lo que hace que los resultados de las pruebas sean predecibles.

Por lo tanto, se espera que uses la instancia de `java.util.Random` proporcionada en tu implementación.
~~~~

## 1. Genera un planeta aleatorio

La _Starship Enterprise_ se encuentra con muchos planetas en sus viajes.
Los planetas del universo de Star Trek se dividen en categorías según sus propiedades.
Por ejemplo, la Tierra es un planeta de clase `M`.
Todas las clases planetarias posibles son: `D`, `H`, `J`, `K`, `L`, `M`, `N`, `R`, `T` y `Y`.

Implementa el método `randomPlanetClass()`.
Debe devolver una de las clases planetarias al azar.

```java
captainsLog.randomPlanetClass();
// => "K"
```

## 2. Genera un número de registro de nave aleatorio

¡La Enterprise (número de registro `NCC-1701`) no es la única nave que vuela por ahí!
Cuando se encuentra con otra nave, Mary necesita registrar el número de registro de esa nave.

Los números de registro empiezan con el prefijo «NCC-» y luego usan un número del `1000` al `9999` (inclusive).

Implementa el método `randomShipRegistryNumber()` que devuelve un número de registro de nave aleatorio.

```java
captainsLog.randomShipRegistryNumber();
// => "NCC-1947"
```

## 3. Genera una fecha estelar aleatoria

¿De qué sirve un registro si no incluye fechas?

Una fecha estelar es un número de punto flotante.
Las aventuras de la _Starship Enterprise_ de la primera temporada de _The Next Generation_ transcurren entre las fechas estelares `41000.0` y `42000.0`.
El «4» representa el siglo XXIV y el «1», la primera temporada.

Implementa el método `randomStardate()` que devuelve un número de punto flotante entre `41000.0` (inclusive) y `42000.0` (exclusive).

```java
captainsLog.randomStardate();
// => 41458.15721310934
```

## Source

### Created by

- @sanderploegsma

### Contributed to by

- @santialb
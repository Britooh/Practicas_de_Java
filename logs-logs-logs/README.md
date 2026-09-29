# ¡Registros, registros, registros!

Te damos la bienvenida a ¡Registros, registros, registros! en el track Java de Exercism.
Si necesitas ayuda para ejecutar las pruebas o enviar tu código, consulta `HELP.md`.
Si te atascas con el ejercicio, consulta `HINTS.md`, pero primero intenta resolverlo sin usarlos :)

## Introduction

## Tipos enum

Un _tipo enum_ es un tipo de dato especial que permite que una variable sea un conjunto de constantes predefinidas.
La variable debe ser igual a uno de los valores que se han predefinido para ella.
Los ejemplos comunes incluyen direcciones de la brújula (valores de `NORTH`, `SOUTH`, `EAST` y `WEST`) y los días de la semana.

Como son constantes, los nombres de los campos de un tipo enum se escriben en mayúsculas.

### Definir un tipo enum

En el lenguaje de programación Java, defines un tipo enum usando la palabra clave `enum`.
Por ejemplo, puedes especificar un tipo enum para los días de la semana así:

```java
public enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY
}
```

Usa tipos enum cada vez que necesites representar un conjunto fijo de constantes.
Eso incluye tipos enum naturales, como los planetas de nuestro sistema solar, y conjuntos de datos en los que conoces todos los valores posibles en tiempo de compilación; por ejemplo, las opciones de un menú, las banderas de línea de comandos y etcétera.

### Usar un tipo enum

Aquí tienes un código que te muestra cómo usar el enum `DayOfWeek` definido anteriormente:

```java
public class Shop {
    public String getOpeningHours(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                return "9am - 5pm";
            case SATURDAY:
                return "10am - 4pm"
            case SUNDAY:
                return "Closed.";
        }
    }
}
```

```java
var shop = new Shop();
shop.getOpeningHours(DayOfWeek.WEDNESDAY);
// => "9am - 5pm"
```

### Agregar métodos y campos

Los tipos enum del lenguaje de programación Java son mucho más potentes que sus equivalentes en otros lenguajes.
La declaración `enum` define una _clase_ (llamada _tipo enum_).
El cuerpo de la clase enum puede incluir métodos y otros campos:

```java
public enum Rating {
    GREAT(5),
    GOOD(4),
    OK(3),
    BAD(2),
    TERRIBLE(1);

    private final int numberOfStars;

    Rating(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }

    public int getNumberOfStars() {
        return this.numberOfStars;
    }
}
```

Llamar al método `getNumberOfStars` en un miembro del tipo enum `Rating`:

```java
Rating.GOOD.getNumberOfStars();
// => 4
```

## Instructions

En este ejercicio vas a procesar líneas de log.

Cada línea de log es un string con el siguiente formato: `"[<LVL>]: <MESSAGE>"`.

Estos son los diferentes niveles de log:

- `TRC` (trace)
- `DBG` (debug)
- `INF` (info)
- `WRN` (warning)
- `ERR` (error)
- `FTL` (fatal)

Tienes tres tareas.

## 1. Analizar el nivel de log

Define una enumeración `LogLevel` que tenga seis elementos correspondientes a los niveles de log anteriores.

- `TRACE`
- `DEBUG`
- `INFO`
- `WARNING`
- `ERROR`
- `FATAL`

Luego, implementa el método `LogLine.getLogLevel()` que devuelve el nivel de log analizado de una línea de log:

```java
var logLine = new LogLine("[INF]: File deleted");
logLine.getLogLevel();
// => LogLevel.INFO
```

## 2. Admitir un nivel de log desconocido

Lamentablemente, de vez en cuando algunas líneas de log tienen un nivel de log desconocido.
Para manejar estas líneas de log de forma elegante, agrega un elemento `UNKNOWN` a la enumeración `LogLevel`, el cual se debe devolver al analizar un nivel de log desconocido:

```java
var logLine = new LogLine("[XYZ]: Overly specific, out of context message");
logLine.getLogLevel();
// => LogLevel.UNKNOWN
```

## 3. Convertir la línea de log al formato corto

El nivel de log de una línea de log es bastante verboso.
Para reducir el espacio en disco necesario para almacenar las líneas de log, se desarrolló un formato corto: `"[<ENCODED_LEVEL>]:<MESSAGE>"`.

El nivel de log codificado es una correspondencia simple entre un nivel de log y un número:

- `UNKNOWN` - `0`
- `TRACE` - `1`
- `DEBUG` - `2`
- `INFO` - `4`
- `WARNING` - `5`
- `ERROR` - `6`
- `FATAL` - `42`

Implementa el método `LogLine.getOutputForShortLog()` que puede generar el formato corto de la línea de log:

```java
var logLine = new LogLine("[ERR]: Stack Overflow");
logLine.getOutputForShortLog();
// => "6:Stack Overflow"
```

## Source

### Created by

- @sanderploegsma
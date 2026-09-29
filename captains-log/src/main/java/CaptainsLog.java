import java.util.Random;

class CaptainsLog {

    // Este arreglo (array) guarda todas las posibles "clases" de
    // planetas que existen en el universo de Star Trek (D, H, J, etc.).
    // Es "static" porque es un dato fijo, compartido por todas las
    // instancias de CaptainsLog (no cambia de un registro a otro),
    // y "final" porque su contenido nunca se va a modificar.
    private static final char[] PLANET_CLASSES = new char[]{'D', 'H', 'J', 'K', 'L', 'M', 'N', 'R', 'T', 'Y'};

    // Guarda la instancia de Random que se usara para generar
    // TODOS los datos aleatorios de esta clase. Segun la nota del
    // ejercicio, se recibe desde afuera (en vez de crear un "new
    // Random()" adentro) para que las pruebas puedan usar una
    // semilla predefinida y obtener resultados predecibles.
    private final Random random;

    // Constructor: sirve para crear un registro del capitan,
    // guardando la instancia de Random que se va a usar despues
    // en los tres metodos de abajo.
    CaptainsLog(Random random) {
        this.random = random;
    }

    // ================= TAREA 1: Genera un planeta aleatorio =================
    // Sirve para elegir al azar una de las clases de planeta
    // guardadas en PLANET_CLASSES.
    char randomPlanetClass() {
        // random.nextInt(PLANET_CLASSES.length) genera un numero
        // aleatorio entre 0 (incluido) y la cantidad de elementos
        // del arreglo (sin incluir ese ultimo numero), que es
        // justo el rango valido de posiciones (indices) del arreglo.
        return PLANET_CLASSES[random.nextInt(PLANET_CLASSES.length)];
    }

    // ================= TAREA 2: Genera un número de registro de nave aleatorio =================
    // Sirve para generar un codigo de nave con el formato tipico
    // de Star Trek, por ejemplo "NCC-1701".
    String randomShipRegistryNumber() {
        // random.nextInt(9000) genera un numero aleatorio entre
        // 0 y 8999. Le sumamos 1000 para que el resultado final
        // siempre quede entre 1000 y 9999 (un numero de 4 digitos).
        // Luego lo concatenamos con el prefijo fijo "NCC-".
        return "NCC-" + (1000 + random.nextInt(9000));
    }

    // ================= TAREA 3: Genera una fecha estelar aleatoria =================
    // Sirve para generar una "fecha estelar" (stardate), que en
    // Star Trek es un numero decimal en vez de una fecha normal.
    double randomStardate() {
        // random.nextDouble() genera un numero decimal aleatorio
        // entre 0.0 (incluido) y 1.0 (sin incluir). Lo multiplicamos
        // por 1000.0 para expandir ese rango a "entre 0 y 1000",
        // y le sumamos 41000.0 como punto de partida, para que el
        // resultado final quede siempre entre 41000.0 y 42000.0
        // (un rango tipico de las fechas estelares de la serie).
        return 41000.0 + random.nextDouble() * 1000.0;
    }

    // Metodo principal: sirve para probar los tres generadores
    // aleatorios de arriba y ver los resultados impresos en consola.
    public static void main(String[] args) {
        // Creamos el registro del capitan pasandole un Random
        // "normal" (sin semilla fija), asi que cada vez que se
        // ejecute el programa, los resultados seran distintos.
        CaptainsLog captainsLog = new CaptainsLog(new Random());

        // Imprimimos una clase de planeta aleatoria (una sola letra).
        System.out.println("Clase planetaria: " + captainsLog.randomPlanetClass());

        // Imprimimos un numero de registro de nave aleatorio.
        System.out.println("Registro de nave: " + captainsLog.randomShipRegistryNumber());

        // Imprimimos una fecha estelar aleatoria.
        System.out.println("Fecha estelar: " + captainsLog.randomStardate());
    }
}
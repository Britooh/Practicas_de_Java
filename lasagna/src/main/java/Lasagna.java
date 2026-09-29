public class Lasagna {

    // Esta función simplemente devuelve cuánto tiempo, en minutos, tiene que estar
    // la lasaña en el horno según la receta. Es un número fijo porque siempre
    // se cocina el mismo tiempo, no depende de nada más.
    public int expectedMinutesInOven() {
        return 40;
    }

    // Esta función calcula cuánto tiempo le queda a la lasaña en el horno,
    // sabiendo cuánto tiempo ya lleva cocinándose.
    // Por ejemplo, si ya lleva 30 minutos, le quedan 40 - 30 = 10 minutos.
    // Usamos expectedMinutesInOven() en vez de escribir "40" de nuevo, así si el tiempo
    // total cambia algún día, solo lo cambiamos en un lugar y todo lo demás se actualiza solo.
    public int remainingMinutesInOven(int minutesInOven) {
        return expectedMinutesInOven() - minutesInOven;
    }

    // Esta función calcula cuánto tiempo lleva preparar la lasaña ANTES de meterla al horno,
    // según cuántas capas tenga. La idea es que cada capa toma 2 minutos armarla,
    // entonces si tiene 3 capas, son 3 x 2 = 6 minutos de preparación.
    public int preparationTimeInMinutes(int numberOfLayers) {
        return numberOfLayers * 2;
    }

    // Esta función suma todo: el tiempo que se tardó en preparar la lasaña (armar las capas)
    // más el tiempo que ya lleva en el horno. Te da el tiempo total invertido hasta el momento,
    // contando desde que empezaste a cocinar hasta ahora.
    public int totalTimeInMinutes(int numberOfLayers, int minutesInOven) {
        return preparationTimeInMinutes(numberOfLayers) + minutesInOven;
    }

    // Este es el punto de entrada del programa: acá es donde Java empieza a ejecutar
    // todo cuando corrés la clase. Lo usamos para probar que las funciones de arriba
    // realmente funcionan, llamándolas con valores concretos y viendo qué devuelven.
    public static void main(String[] args) {

        // Como las funciones de arriba no son "static", no las podemos llamar directamente.
        // Necesitamos crear un objeto de la clase Lasagna primero (como sacar una copia
        // de la receta) para poder usar sus métodos.
        Lasagna lasagna = new Lasagna();

        // Le preguntamos al objeto cuánto tiempo total va en el horno según la receta,
        // y lo imprimimos en la consola para verlo.
        System.out.println("Tiempo esperado en horno: " + lasagna.expectedMinutesInOven());
        // Resultado esperado: 40

        // Le decimos que ya pasaron 30 minutos en el horno, y le preguntamos
        // cuánto tiempo falta todavía.
        System.out.println("Tiempo restante (con 30 min ya cocinados): " + lasagna.remainingMinutesInOven(30));
        // Resultado esperado: 10 (porque 40 - 30 = 10)

        // Le preguntamos cuánto tiempo de preparación lleva una lasaña de 3 capas.
        System.out.println("Tiempo de preparación (3 capas): " + lasagna.preparationTimeInMinutes(3));
        // Resultado esperado: 6 (porque 3 capas x 2 minutos cada una = 6)

        // Por último, le preguntamos el tiempo total combinando preparación (3 capas)
        // más el tiempo que ya lleva en el horno (30 minutos).
        System.out.println("Tiempo total (3 capas, 30 min en horno): " + lasagna.totalTimeInMinutes(3, 30));
        // Resultado esperado: 36 (porque 6 minutos de preparación + 30 minutos de horno = 36)
    }
}
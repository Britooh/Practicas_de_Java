public class NeedForSpeed {

    // Velocidad del auto: cuantos metros avanza cada vez que se llama a drive().
    // Es "final" porque una vez creado el auto, su velocidad no cambia.
    private final int speed;

    // Cuanto porcentaje de bateria consume el auto cada vez que se conduce.
    // Tambien es "final" porque es una caracteristica fija de cada auto.
    private final int batteryDrain;

    // Guarda la distancia total recorrida hasta el momento.
    // Empieza en 0 porque un auto recien creado no ha avanzado nada.
    private int distanceDriven = 0;

    // Guarda el nivel de bateria actual, de 0 a 100.
    // Empieza en 100 porque, segun el enunciado, los coches
    // arrancan con las baterias llenas.
    private int batteryLevel = 100;

    // ================= TAREA 1: Creación de un coche controlado a distancia =================
    // Constructor: sirve para crear un auto indicando su velocidad
    // y cuanto gasta de bateria por cada viaje. El "this." se usa
    // para diferenciar el atributo de la clase (this.speed) del
    // parametro que llega al constructor (speed).
    NeedForSpeed(int speed, int batteryDrain) {
        this.speed = speed;
        this.batteryDrain = batteryDrain;
    }

    // Getter: sirve para poder leer la velocidad del auto desde
    // fuera de la clase, ya que el atributo "speed" es privado.
    public int speed() {
        return speed;
    }

    // Getter: sirve para poder leer cuanto gasta de bateria el auto
    // desde fuera de la clase, ya que "batteryDrain" es privado.
    public int batteryDrain() {
        return batteryDrain;
    }

    // ================= TAREA 4: Compruebe si hay una batería agotada =================
    // Sirve para saber si al auto ya no le queda bateria suficiente
    // para hacer otro viaje. Segun el enunciado, si la bateria esta
    // por debajo de lo que consume por viaje, ya no puede conducirse.
    public boolean batteryDrained() {
        return batteryLevel < batteryDrain;
    }

    // Getter: sirve para leer cuantos metros ha recorrido el auto
    // hasta el momento.
    public int distanceDriven() {
        return distanceDriven;
    }

    // ================= TAREA 3: Conduce el coche =================
    // Sirve para simular que el auto se mueve una vez con el mando a distancia.
    public void drive() {
        // Antes de mover el auto, revisamos si le queda bateria
        // suficiente para completar el viaje (evita quedar en negativo).
        if (batteryLevel >= batteryDrain) {
            // Si hay bateria suficiente, sumamos la velocidad del coche
            // a la distancia recorrida...
            distanceDriven += speed;
            // ...y restamos lo que se gasta de bateria en el viaje.
            batteryLevel -= batteryDrain;
        }
        // Si no hay bateria suficiente, no pasa nada: el auto
        // simplemente no avanza ni gasta mas bateria.
    }

    // ================= TAREA 5: Crea el coche con mando a distancia Nitro =================
    // Metodo "de fabrica" (static) que sirve para crear un auto
    // ya configurado con valores especiales de "nitro":
    // velocidad muy alta (50) pero tambien gasta mucha bateria (4).
    // Es un atajo para no tener que escribir "new NeedForSpeed(50, 4)"
    // cada vez que se quiera un auto con estas caracteristicas.
    public static NeedForSpeed nitro() {
        return new NeedForSpeed(50, 4);
    }

    // Metodo principal: sirve para probar todo el codigo de arriba
    // y ver los resultados impresos en la consola.
    public static void main(String[] args) {
        // Creamos un auto normal: avanza 10 metros y gasta 2% de bateria por viaje.
        NeedForSpeed car = new NeedForSpeed(10, 2);

        // Creamos una pista de carreras de 100 metros de distancia total.
        RaceTrack track = new RaceTrack(100);

        // Mostramos la distancia antes de conducir (deberia ser 0).
        System.out.println("Distancia inicial: " + car.distanceDriven());

        // Conducimos una vez.
        car.drive();

        // Mostramos la distancia despues de conducir (deberia ser 10).
        System.out.println("Distancia después de conducir: " + car.distanceDriven());

        // Revisamos si la bateria ya esta agotada (todavia deberia decir false).
        System.out.println("Batería agotada: " + car.batteryDrained());

        // Preguntamos a la pista si este auto tiene bateria suficiente
        // para llegar hasta el final de la carrera.
        System.out.println("¿Puede terminar la carrera? " + track.canFinishRace(car));

        // Creamos un auto especial usando el metodo de fabrica nitro().
        NeedForSpeed nitroCar = NeedForSpeed.nitro();

        // Lo conducimos una vez para ver como se comporta.
        nitroCar.drive();

        // Mostramos su distancia recorrida (deberia ser 50, por la velocidad alta).
        System.out.println("Nitro: distancia = " + nitroCar.distanceDriven());

        // Mostramos si ya se quedo sin bateria (gasta 4% por viaje, asi que no todavia).
        System.out.println("Nitro: batería agotada = " + nitroCar.batteryDrained());
    }
}

// Clase que representa una pista de carreras, con una distancia
// total que hay que recorrer para terminarla.
class RaceTrack {

    // Guarda la distancia total de la pista. Es "final" porque
    // una pista no cambia de tamaño una vez creada.
    private final int distance;

    // ================= TAREA 2: Creando una pista de carreras =================
    // Constructor: sirve para crear una pista indicando su distancia total.
    RaceTrack(int distance) {
        this.distance = distance;
    }

    // ================= TAREA 6: Comprueba si un coche a control remoto puede terminar una carrera =================
    // Sirve para calcular si un auto dado tiene bateria suficiente
    // para recorrer toda la pista sin quedarse a mitad de camino.
    public boolean canFinishRace(NeedForSpeed car) {
        // Calculamos cuantas veces puede conducir el auto antes de
        // quedarse sin bateria (100 / batteryDrain), y multiplicamos
        // eso por la velocidad para saber la distancia MAXIMA que
        // el auto puede recorrer en total.
        int maxDistance = (100 / car.batteryDrain()) * car.speed();

        // Si esa distancia maxima alcanza o supera la distancia
        // de la pista, entonces el auto SI puede terminar la carrera.
        return maxDistance >= this.distance;
    }
}
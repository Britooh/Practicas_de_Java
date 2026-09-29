public class JedliksToyCar {

    // Guarda cuantos metros ha recorrido el carrito en total.
    // Sirve para llevar un registro acumulado de la distancia,
    // y lo usamos despues en distanceDisplay() para mostrarlo.
    public int metersDriven;

    // Guarda cuanta bateria le queda al carrito (de 0 a 100).
    // Sirve para saber si el carrito todavia puede moverse
    // o si ya se quedo sin energia.
    public int batteryPercentage;

    // El constructor sirve para definir los valores iniciales
    // que tendra CADA carrito nuevo que se cree. Se ejecuta
    // automaticamente al hacer "new JedliksToyCar()".
    public JedliksToyCar() {
        // Un carrito recien creado no ha recorrido nada todavia,
        // por eso empieza en 0.
        metersDriven = 0;

        // Un carrito recien comprado sale con la bateria llena,
        // por eso empieza en 100.
        batteryPercentage = 100;
    }

    // ===== TAREA 1: Comprar un coche nuevo con mando a distancia =====
    // Este metodo sirve como "fabrica" de carritos: es la unica forma
    // pensada para obtener un carrito nuevo, simulando que lo compras.
    // Es "static" porque no necesitas tener un carrito ya creado
    // para poder llamarlo (se llama directo sobre la clase).
    public static JedliksToyCar buy() {
        // Creamos un carrito nuevo usando el constructor de arriba.
        JedliksToyCar car = new JedliksToyCar();

        // Devolvemos el carrito recien creado para que quien
        // llamo a buy() pueda usarlo.
        return car;
    }

    // ===== TAREA 2: Mostrar la distancia recorrida =====
    // Este metodo sirve para generar el texto que se veria
    // en la pantalla LED del carrito, indicando la distancia total.
    public String distanceDisplay() {
        // Concatenamos (unimos) el texto fijo con el valor
        // actual de metersDriven, para armar el mensaje completo.
        String texto = "Driven " + metersDriven + " meters";

        // Devolvemos el texto ya armado.
        return texto;
    }

    // ===== TAREA 3: Mostrar el porcentaje de bateria =====
    // Este metodo sirve para generar el texto de la pantalla
    // que indica cuanta bateria le queda al carrito.
    public String batteryDisplay() {
        // Este "if" sirve para detectar el caso especial en que
        // la bateria ya se agoto completamente.
        if (batteryPercentage == 0) {
            // Si la bateria esta en 0, mostramos un mensaje
            // distinto en vez del porcentaje, como pide el enunciado.
            return "Battery empty";
        } else {
            // Si todavia queda bateria, mostramos el porcentaje normal.
            return "Battery at " + batteryPercentage + "%";
        }
    }

    // ===== TAREA 4, 5 y 6: Conducir el carrito =====
    // Este metodo sirve para simular que el carrito avanza
    // una vez usando el control remoto.
    public void drive() {

        // TAREA 6: Esta condicion sirve como "freno de seguridad".
        // Antes de mover el carrito, revisamos si ya no tiene bateria.
        if (batteryPercentage == 0) {
            // Si no queda bateria, el "return" sirve para salir
            // del metodo inmediatamente, sin ejecutar el resto
            // del codigo de abajo (no se mueve, no gasta bateria).
            return;
        }

        // TAREA 4: Esta linea sirve para actualizar la distancia
        // total recorrida, sumando los 20 metros que avanza
        // el carrito en cada viaje con el control remoto.
        metersDriven = metersDriven + 20;

        // TAREA 5: Esta linea sirve para actualizar la bateria,
        // restando el 1% que se consume cada vez que se conduce.
        batteryPercentage = batteryPercentage - 1;
    }

    // El metodo main() sirve como punto de entrada del programa:
    // es lo que se ejecuta cuando corremos la clase, y aqui
    // probamos que todo funcione como esperamos.
    public static void main(String[] args) {
        // Compramos un carrito nuevo usando el metodo de la TAREA 1.
        JedliksToyCar car = JedliksToyCar.buy();

        // Mostramos el estado inicial del carrito (0 metros, 100% bateria)
        // para confirmar que el constructor funciono bien.
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());

        // Conducimos el carrito una vez, para probar que drive()
        // actualiza correctamente los metros y la bateria.
        car.drive();

        // Volvemos a mostrar el estado del carrito, esperando ver
        // 20 metros recorridos y 99% de bateria.
        System.out.println(car.distanceDisplay());
        System.out.println(car.batteryDisplay());
    }
}
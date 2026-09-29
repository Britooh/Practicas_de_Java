import java.util.List;

public class TestTrack {

    // Ejemplo ejecutable: hace correr ambos modelos y muestra cuánto avanzó cada uno.
    public static void main(String[] args) {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();

        // La pista recibe ambos coches mediante el tipo común RemoteControlCar.
        race(productionCar);
        race(experimentalCar);

        System.out.println("Coche de producción: " + productionCar.getDistanceTravelled() + " unidades");
        System.out.println("Coche experimental: " + experimentalCar.getDistanceTravelled() + " unidades");
    }

    // Tarea 3: inicia una carrera haciendo que el coche avance una vez.
    public static void race(RemoteControlCar car) {
        car.drive();
    }

    // Tarea 4: ordena los coches según su orden natural, definido por sus victorias.
    public static List<ProductionRemoteControlCar> getRankedCars(List<ProductionRemoteControlCar> cars) {
        // Ordena la lista recibida de mayor a menor número de victorias.
        cars.sort(null);
        return cars;
    }
}

// Tareas 1 y 2: el modelo experimental implementa la interfaz y avanza 20 unidades por uso.
public class ExperimentalRemoteControlCar implements RemoteControlCar {

    // Conserva la distancia acumulada durante la vida del coche.
    private int distanceTravelled;

    @Override
    public void drive() {
        // Cada llamada a drive añade 20 unidades a la distancia total.
        distanceTravelled += 20;
    }

    @Override
    public int getDistanceTravelled() {
        // Informa de la distancia acumulada hasta el momento.
        return distanceTravelled;
    }
}

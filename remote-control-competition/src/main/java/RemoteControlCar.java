// Tarea 1: contrato común para que la pista pueda trabajar con cualquier modelo.
public interface RemoteControlCar {
    // Hace que el coche avance.
    void drive();

    // Devuelve la distancia total recorrida por este coche.
    int getDistanceTravelled();
}

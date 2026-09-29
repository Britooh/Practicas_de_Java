// Tareas 1 y 2: el coche de producción implementa la interfaz y avanza 10 unidades por uso.
class ProductionRemoteControlCar implements RemoteControlCar, Comparable<ProductionRemoteControlCar> {

    // Estado de conducción y número de victorias del coche.
    private int distanceTravelled;
    private int numberOfVictories;

    @Override
    public void drive() {
        // Cada llamada a drive añade 10 unidades a la distancia total.
        distanceTravelled += 10;
    }

    @Override
    public int getDistanceTravelled() {
        // Devuelve la distancia total acumulada.
        return distanceTravelled;
    }

    public int getNumberOfVictories() {
        return numberOfVictories;
    }

    public void setNumberOfVictories(int numberOfVictories) {
        this.numberOfVictories = numberOfVictories;
    }

    // Tarea 4: el orden natural pone primero el coche con más victorias.
    @Override
    public int compareTo(ProductionRemoteControlCar other) {
        // Se invierten los operandos para ordenar las victorias de forma descendente.
        return Integer.compare(other.numberOfVictories, numberOfVictories);
    }
}

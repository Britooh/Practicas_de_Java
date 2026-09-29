public class CarsAssemble {

    public double productionRatePerHour(int speed) {
        double base = speed * 221.0;
        double result = 0.0;

        if (speed >= 1 && speed <= 4) {
            result = base;
        } else if (speed >= 5 && speed <= 8) {
            result = base * 0.9;
        } else if (speed == 9) {
            result = base * 0.8;
        } else if (speed == 10) {
            result = base * 0.77;
        } else {
            result = 0.0;
        }

        return result;
    }

    public int workingItemsPerMinute(int speed) {
        double perHour = productionRatePerHour(speed);
        double perMinute = perHour / 60;
        int resultado = (int) perMinute;
        return resultado;
    }

    public static void main(String[] args) {
        CarsAssemble carsAssemble = new CarsAssemble();

        System.out.println(carsAssemble.productionRatePerHour(6));
        System.out.println(carsAssemble.workingItemsPerMinute(6));
    }
}
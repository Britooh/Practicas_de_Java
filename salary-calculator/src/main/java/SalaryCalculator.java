public class SalaryCalculator {

    // ================= TAREA 1: Determinar el multiplicador salarial =================
    // Sirve para calcular por cuanto hay que multiplicar el salario base,
    // dependiendo de si el empleado falto demasiados dias al trabajo.
    // Usamos el operador ternario (condicion ? valorSiTrue : valorSiFalse)
    // en vez de un if/else, tal como pide el enunciado.
    public double salaryMultiplier(int daysSkipped) {
        // Si el empleado falto 5 dias o mas, se le paga solo el 85%
        // de su salario base (0.85). Si falto menos de 5 dias,
        // se le paga el 100% completo (1.0).
        return daysSkipped >= 5 ? 0.85 : 1.0;
    }

    // Sirve para saber cuanto dinero vale cada producto vendido,
    // dependiendo de que tan buen vendedor fue el empleado ese mes.
    // Este metodo es un paso intermedio que usaremos en la TAREA 2.
    public int bonusMultiplier(int productsSold) {
        // Si vendio 20 productos o mas, cada producto vale 13
        // (un bono mas alto, como premio por vender mucho).
        // Si vendio menos de 20, cada producto vale 10.
        return productsSold >= 20 ? 13 : 10;
    }

    // ================= TAREA 2: Calcula el bono por los productos vendidos =================
    // Sirve para calcular el bono TOTAL en dinero que gana el empleado
    // segun cuantos productos vendio. Multiplicamos la cantidad de
    // productos vendidos por el valor de cada uno (que ya calculamos
    // arriba con bonusMultiplier).
    public double bonusForProductsSold(int productsSold) {
        return productsSold * bonusMultiplier(productsSold);
    }

    // ================= TAREA 3: Calcular el salario final del empleado =================
    // Sirve para juntar todo lo anterior y calcular cuanto dinero
    // recibe el empleado al final del mes.
    public double finalSalary(int daysSkipped, int productsSold) {
        // Tomamos un salario base fijo de 1000, lo multiplicamos por
        // el multiplicador segun los dias faltados (TAREA 1),
        // y le sumamos el bono ganado por ventas (TAREA 2).
        double salary = 1000.0 * salaryMultiplier(daysSkipped) + bonusForProductsSold(productsSold);

        // Aplicamos un "tope maximo": sin importar cuanto haya ganado
        // el empleado, nunca puede cobrar mas de 2000. Si el salario
        // calculado supera ese limite, se le paga 2000; si no,
        // se le paga el salario tal cual se calculo.
        return salary > 2000.0 ? 2000.0 : salary;
    }

    // Metodo principal: sirve para probar el calculo completo
    // y ver el resultado impreso en la consola.
    public static void main(String[] args) {
        // Creamos un calculador de salarios.
        SalaryCalculator calculator = new SalaryCalculator();

        // Calculamos el salario final de un empleado que falto 2 dias
        // (menos de 5, asi que cobra el 100% del salario base) y
        // vendio 3 productos (menos de 20, asi que cada uno vale 10).
        // Resultado esperado: 1000 * 1.0 + (3 * 10) = 1030.0
        System.out.println(calculator.finalSalary(2, 3));
    }
}
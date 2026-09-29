public class FootballMatchReports {

    // ================= TAREA 1: Descripciones de salida de los jugadores según su número de camiseta =================
    // Sirve para traducir el numero de camiseta de un jugador a la
    // posicion que ocupa en la cancha, para generar los reportes
    // del partido de forma automatica.
    public static String onField(int shirtNum) {

        // El "switch" sirve para comparar shirtNum contra varios
        // valores posibles, evitando tener que escribir una cadena
        // larga de if/else if para cada numero.
        switch (shirtNum) {

            // La camiseta 1 siempre es del portero (arquero).
            case 1:
                return "goalie";

            // La camiseta 2 es del lateral izquierdo.
            case 2:
                return "left back";

            // Las camisetas 3 y 4 son de defensa central.
            // Como no tienen "break" ni "return" entre ellas, el 3
            // "cae" hasta el 4 y ambas comparten el mismo resultado
            // (esto se llama fall-through).
            case 3:
            case 4:
                return "center back";

            // La camiseta 5 es del lateral derecho.
            case 5:
                return "right back";

            // Las camisetas 6, 7 y 8 son todas de mediocampista,
            // usando el mismo truco de fall-through de arriba.
            case 6:
            case 7:
            case 8:
                return "midfielder";

            // La camiseta 9 es del extremo izquierdo.
            case 9:
                return "left wing";

            // La camiseta 10 es del delantero (striker), normalmente
            // el numero mas famoso en el futbol.
            case 10:
                return "striker";

            // La camiseta 11 es del extremo derecho.
            case 11:
                return "right wing";

            // ================= TAREA 2: Salida "inválida" si el número de camiseta no forma parte de la lista oficial =================
            // "default" sirve para capturar CUALQUIER numero que no
            // coincida con ninguno de los casos de arriba (por ejemplo
            // 0, 12, 13, o numeros negativos), y devolver "invalid"
            // en vez de dejar el metodo sin una respuesta.
            default:
                return "invalid";
        }
    }

    // Metodo principal: sirve para probar el metodo onField()
    // con varios numeros de camiseta y ver los resultados en consola.
    public static void main(String[] args) {

        // Este "for" sirve para repetir el proceso de impresion
        // desde la camiseta 1 hasta la 13, sin tener que escribir
        // 13 lineas de System.out.println a mano.
        for (int shirtNum = 1; shirtNum <= 13; shirtNum++) {

            // Imprimimos el numero de camiseta junto con la posicion
            // que le corresponde (o "invalid" si no es un numero
            // valido, como pasaria con 12 y 13).
            System.out.println(shirtNum + " -> " + onField(shirtNum));
        }
    }
}
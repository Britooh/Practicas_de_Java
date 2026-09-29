// Definimos una clase llamada Greeter. En Java, todo el código vive dentro de una clase,
// así que esta es como el "contenedor" de todo lo que hace nuestro programa.
class Greeter {

    // Este es el punto de entrada del programa: cuando corrés esta clase,
    // Java busca este método exacto (main) y empieza a ejecutar desde acá.
    public static void main(String[] args) {

        // Acá pasan dos cosas en una sola línea:
        // 1- "new Greeter()" crea un objeto nuevo de la clase Greeter (como sacar
        //    una copia utilizable de la clase para poder usar sus métodos).
        // 2- ".getGreeting()" le pregunta a ese objeto cuál es el saludo,
        //    y lo que devuelva se imprime en la consola con println.
        System.out.println(new Greeter().getGreeting());
    }

    // Este método simplemente devuelve un texto fijo: el saludo "Hello, World!".
    // No necesita recibir nada porque siempre da la misma respuesta.
    String getGreeting() {
        return "Hello, World!";
    }

}
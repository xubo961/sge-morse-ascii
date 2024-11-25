import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Crear el mapa con las letras y su código Morse
        HashMap<String, String> morseCastellano = new HashMap<>();
        morseCastellano.put("a", "._");
        morseCastellano.put("b", "_...");
        morseCastellano.put("c", "_._.");
        morseCastellano.put("d", "_..");
        morseCastellano.put("e", ".");
        morseCastellano.put("f", ".._.");
        morseCastellano.put("g", "--.");
        morseCastellano.put("h", "....");
        morseCastellano.put("i", "..");
        morseCastellano.put("j", ".---");
        morseCastellano.put("k", "_._");
        morseCastellano.put("l", "._..");
        morseCastellano.put("m", "--");
        morseCastellano.put("n", "_.");
        morseCastellano.put("o", "---");
        morseCastellano.put("p", ".--.");
        morseCastellano.put("q", "--._");
        morseCastellano.put("r", "._.");
        morseCastellano.put("s", "...");
        morseCastellano.put("t", "_");
        morseCastellano.put("u", ".._");
        morseCastellano.put("v", "..._");
        morseCastellano.put("w", ".__");
        morseCastellano.put("x", "_.._");
        morseCastellano.put("y", "_.__");
        morseCastellano.put("z", "__..");

        morseCastellano.put("0", "_____");
        morseCastellano.put("1", ".____");
        morseCastellano.put("2", "..___");
        morseCastellano.put("3", "...__");
        morseCastellano.put("4", "...._");
        morseCastellano.put("5", ".....");
        morseCastellano.put("6", "_....");
        morseCastellano.put("7", "__...");
        morseCastellano.put("8", "___..");
        morseCastellano.put("9", "____.");
        
        while (true) {
            System.out.println("Introduce un código morse para traducir o escribe 'salir' para terminar:");
            String respuesta = scanner.nextLine();
            
            if (respuesta.equalsIgnoreCase("salir")) {
                break;
            }

            String[] codigoMorse = respuesta.split(" / ");
            String traduccion = "";
            
            for (String palabra : codigoMorse) {
                String[] characters = palabra.split(" ");
                for (String character : characters) {
                    String letra = obtenerLetraDeMorse(morseCastellano, character);
                    if (letra != null) {
                        traduccion = letra;
                    } else {
                        traduccion = "Escribe un  código morse válido";  
                    }
                }
            }

            System.out.println("Traducción: " + traduccion);
        }

        // Cerrar el scanner
        scanner.close();
        System.out.println("Programa terminado.");
    }

    // Método para obtener la letra de Morse
    private static String obtenerLetraDeMorse(HashMap<String, String> morseMap, String morseCode) {
        // Recorremos el mapa y comparamos el código Morse
        for (String letra : morseMap.keySet()) {
            if (morseMap.get(letra).equals(morseCode)) {
                return letra;
            }
        }
        return null;  // Si no encontramos el código Morse, devolver null
    }
}

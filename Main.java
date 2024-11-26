import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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
            System.out.println("Seleccione una opción:");
            System.out.println("1. Traducir Morse a texto.");
            System.out.println("2. Traducir texto a Morse.");
            System.out.println("3. Salir.");
            String opcion = scanner.nextLine();

            if (opcion.equals("3")) {
                System.out.println("Programa terminado.");
                break;
            }

            switch (opcion) {
                case "1":
                    System.out.println("Introduce un código Morse para traducir (usa '/' para separar palabras):");
                    String respuesta = scanner.nextLine();
                    String[] codigoMorse = respuesta.split(" / ");
                    String traduccion = "";

                    for (String palabra : codigoMorse) {
                        String[] characters = palabra.split(" ");
                        for (String character : characters) {
                            String letra = obtenerLetraDeMorse(morseCastellano, character);
                            if (letra != null) {
                                traduccion += letra;
                            } else {
                                traduccion += "?";
                            }
                        }
                        traduccion += " ";
                    }

                    System.out.println("Traducción: " + traduccion.trim());
                    break;

                case "2":
                    System.out.println("Introduce el texto (sin tildes) para traducir a código Morse:");
                    String texto = scanner.nextLine().toLowerCase();
                    String morseTraducido = traducirTextoAMorse(texto, morseCastellano);
                    System.out.println("Traducción a Morse: " + morseTraducido);
                    break;

                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        }

        scanner.close();
    }

    private static String obtenerLetraDeMorse(HashMap<String, String> morseMap, String morseCode) {
        for (String letra : morseMap.keySet()) {
            if (morseMap.get(letra).equals(morseCode)) {
                return letra;
            }
        }
        return null;
    }

    private static String traducirTextoAMorse(String texto, HashMap<String, String> morseTable) {
        StringBuilder morse = new StringBuilder();
        for (char c : texto.toCharArray()) {
            String caracter = String.valueOf(c);
            if (caracter.equals(" ")) {
                morse.append("/ ");
            } else if (morseTable.containsKey(caracter)) {
                morse.append(morseTable.get(caracter)).append(" ");
            } else {
                morse.append("? ");
            }
        }
        return morse.toString().trim();
    }
}


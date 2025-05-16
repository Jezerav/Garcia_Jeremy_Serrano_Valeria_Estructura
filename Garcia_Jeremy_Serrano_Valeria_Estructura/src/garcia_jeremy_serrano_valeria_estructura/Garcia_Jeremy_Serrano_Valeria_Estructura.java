
package garcia_jeremy_serrano_valeria_estructura;
//Pareja: Jeremy Garcia y Valeria Serrano

import java.util.Scanner;
public class Garcia_Jeremy_Serrano_Valeria_Estructura {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n"); 
        
        int opcion; 
        // Menú principal que se ejecuta hasta que el usuario seleccione la opción 5 para salir
        do {
            System.out.println("\n------MENU------");
            System.out.println("1. Cifrado");
            System.out.println("2. Filtrar");
            System.out.println("3. Código Enigma");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lea.nextInt(); // Lee la opción seleccionada por el usuario
            
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese una frase a cifrar: ");
                    String fraseInicial = lea.next();
                    System.out.print("Ingrese la cantidad de posiciones a desplazar: ");
                    int desplazar = lea.nextInt();
                    
                    if (desplazar <= 0) {
                    System.out.println("El desplazamiento debe ser un número entero positivo.");
                    break;
                    }
                    
                    // Variable para almacenar la frase cifrada
                    String fraseCifrada = "";

                    // Iterar sobre cada carácter de la frase original
                    for (int i = 0; i < fraseInicial.length(); i++) {
                        char letraInicial = fraseInicial.charAt(i);
                        char letraCifrada;

                        // Verificar si el carácter es una letra
                        if ((letraInicial >= 'a' && letraInicial <= 'z') || (letraInicial >= 'A' && letraInicial <= 'Z')) {
                        char base = Character.isLowerCase(letraInicial) ? 'a' : 'A';
                        int nuevaPosicion = (letraInicial - base + desplazar) % 26;
                        letraCifrada = (char) (base + nuevaPosicion);
                        } else {
                            // Si no es una letra, mantener el carácter original
                            letraCifrada = letraInicial;
                        }
                        // Concatenar el carácter cifrado a la frase cifrada
                        fraseCifrada = fraseCifrada + letraCifrada;
                    }

                    // Mostrar la frase cifrada
                    System.out.println("Frase cifrada: " + fraseCifrada);
                    break;
                
                case 2: 
                    for (int conta = 0; conta < frase.length(); conta++) {
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    System.out.println("\nPrograma finalizado."); 
                    break;
                
                default:
                    System.out.println("Opción inválida."); // Si la opción no es válida
            }
        } while (opcion != 4);
    }
    
}

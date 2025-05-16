
package garcia_jeremy_serrano_valeria_estructura;
// Pareja: Jeremy Garcia y Valeria Serrano

import java.util.Scanner;

public class Garcia_Jeremy_Serrano_Valeria_Estructura {

    public static void main(String[] args) {
        Scanner lea = new Scanner(System.in);
        lea.useDelimiter("\n"); 

        int opcion; // Aquí se guarda la opción que el usuario elige del menú

        // Ciclo que se repite hasta que el usuario elija la opción 4 (Salir)
        do {
            // Se muestra el menú principal
            System.out.println("\n------MENU------");
            System.out.println("1. Cifrado");
            System.out.println("2. Filtrar");
            System.out.println("3. Código Enigma");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = lea.nextInt(); // Se guarda la opción elegida por el usuario

            switch (opcion) {

                // ====== OPCIÓN 1: CIFRADO ======
                case 1:
                    System.out.print("\nIngrese una frase a cifrar: ");
                    String fraseInicial = lea.next();
                    // Variable donde se guardará el número de desplazamiento
                    int desplazar;

                    // Bucle que se repite hasta que se ingrese un número positivo
                    do {
                        System.out.print("Ingrese la cantidad de posiciones a desplazar: ");
                        desplazar = lea.nextInt(); // Lee el número ingresado

                        // Si es inválido, se muestra un mensaje y se repite
                        if (desplazar <= 0) {
                            System.out.println("El desplazamiento debe ser un número positivo. Intente de nuevo.");
                        }
                    } while (desplazar <= 0); // Repetir mientras el número no sea válido


                    String fraseCifrada = ""; // Aquí se guardará el resultado
                    
                    
                    // Recorremos cada letra de la frase
                    for (int conta = 0; conta < fraseInicial.length(); conta++) {
                        char letraInicial = fraseInicial.charAt(conta); // Sacamos una letra
                        char letraCifrada;

                        // Verificamos si la letra es del alfabeto
                        if ((letraInicial >= 'a' && letraInicial <= 'z') || (letraInicial >= 'A' && letraInicial <= 'Z')) {
                            // Verificamos si es mayúscula o minúscula
                            char base = Character.isLowerCase(letraInicial) ? 'a' : 'A';

                            // Calculamos la nueva letra desplazada
                            int nuevaPosicion = (letraInicial - base + desplazar) % 26;
                            letraCifrada = (char) (base + nuevaPosicion);
                        } else {
                            // Si no es letra (espacio, número, etc.), se deja igual
                            letraCifrada = letraInicial;
                        }

                        fraseCifrada += letraCifrada; // Se agrega al resultado
                    }

                    System.out.println("Frase cifrada: " + fraseCifrada);
                    break;

                // ====== OPCIÓN 2: FILTRAR PALABRAS SEGÚN SU LONGITUD ======
                case 2:
                    // Se le pide al usuario que escriba una frase
                    System.out.print("Ingrese una frase: ");
                    String frase = lea.next(); 

                    // Se le pide al usuario que escriba un número que será el mínimo de letras por palabra
                    System.out.print("Ingrese una longitud minima: ");
                    int longitud = lea.nextInt(); 

                    // Es para guardar las palabras que cumplan con la longitud mínima
                    String palabraFiltro = "";
                    // Esta variable es para ir construyendo palabra por palabra
                    String palabraNormal = "";

                    // Este ciclo recorre toda la frase letra por letra
                    for (int conta = 0; conta < frase.length(); conta++) {
                        char letra = frase.charAt(conta); // Sacamos una letra de la frase

                        // Si la letra es un espacio o no es una letra (ni minúscula ni mayúscula)
                        if (letra == ' ' || !(letra >= 'a' && letra <= 'z') || !(letra >= 'A' || letra <= 'Z')) {
                            // Revisamos si la palabra que llevamos construida es igual o más larga que el mínimo
                            if (palabraNormal.length() >= longitud) {
                                palabraFiltro += palabraNormal + " "; // Si se cumple el filtro la agregamos a las filtradas
                            }
                            palabraNormal = ""; // Reiniciamos para empezar otra palabra
                        } else {
                            // Si la letra sí es válida, se la agregamos a la palabra en construcción
                            palabraNormal += letra;
                        }
                    }

                    // Al salir del ciclo, revisamos si la última palabra también cumple con el mínimo
                    if (palabraNormal.length() >= longitud) {
                        palabraFiltro += palabraNormal;
                    }
                    
                    System.out.println("Palabras con longitud mínima de " + longitud + ":");
                    System.out.println(palabraFiltro);

                // ====== OPCIÓN 3: CÓDIGO ENIGMA (ENCRIPTAR Y DESENCRIPTAR) ======
                case 3:
                    boolean sesion = true; // Esta variable sirve para controlar si el menú sigue repitiéndose o no

                    // El ciclo se repite mientras "sesion" sea true
                    do {
                        // Se muestra el menú del Código Enigma
                        System.out.println("\n--------------------------    MENÚ CÓDIGO ENIGMA   ------------------------");
                        System.out.println("Elige una de las siguientes opciones: \n    1) Encriptación \n    2) Desencriptación \n    3)Salir");
                        System.out.print("Ingrese opción: ");
                        int opcionEncrip = lea.nextInt(); // El usuario ingresa una opción

                        // Se evalúa la opción ingresada
                        switch (opcionEncrip) {

                            case 1: // Encriptación
                                String par = "";    // Aquí se guardan las letras que están en posición par 
                                String impar = "";  // Aquí se guardan las letras en posición impar

                                System.out.println("--------------------------    MENÚ ENCRIPTACIÓN   ------------------------");

                                System.out.print("Ingrese la palabra a encriptar: ");
                                String palabra = lea.next(); // El usuario escribe la palabra a encriptar

                                // Recorremos la palabra letra por letra
                                for (int i = 0; i < palabra.length(); i++) {
                                    char letra = palabra.charAt(i); // Sacamos la letra en la posición i (contador)

                                    if (i % 2 == 0) {
                                        par += letra; // Si la posición es par, se agrega a la variable par
                                    } else {
                                        impar += letra; // Si es impar, se agrega a impar
                                    }
                                }

                                // Se forma la palabra encriptada uniendo primero las letras pares y luego las impares
                                String encriptado = par + impar;

                                // resultado encriptado
                                System.out.println("Palabra encriptada: " + encriptado);
                                break;

                            case 2: // Desencriptación
                                System.out.println("\n--------------------------    MENÚ DESENCRIPTACIÓN   ------------------------");

                                System.out.println("Ingrese palabra a desencriptar: ");
                                encriptado = lea.next(); // Se recibe la palabra encriptada

                                System.out.println("Encriptado: " + encriptado);

                                // Calculamos el punto medio para separar la palabra
                                int mitad = (encriptado.length() + 1) / 2;

                                // mitad1 tendrá las letras pares (al inicio del encriptado)
                                String mitad1 = encriptado.substring(0, mitad);
                                System.out.println(mitad1);

                                // mitad2 tendrá las letras impares (al final del encriptado)
                                String mitad2 = encriptado.substring(mitad);
                                System.out.println(mitad2);

                                String result = ""; // Aquí se guardará la palabra desencriptada
                                int l = 0; // índce para mitad1
                                int k = 0; // índice para mitad2

                                // Vamos combinando las letras una por una para armar la original
                                for (int j = 0; j <= encriptado.length(); j++) {
                                    if (j % 2 == 0 && l < mitad1.length()) {
                                        result += mitad1.charAt(l);
                                        l++;
                                    }
                                    if (j % 2 != 0 && k < mitad2.length()) {
                                        result += mitad2.charAt(k);
                                        k++;
                                    }
                                }

                                // Resultado final desencriptado
                                System.out.println("Palabra Desencriptada: " + result);
                                break;

                            case 3: // Salir
                                System.out.println("\nSaliste");
                                System.out.println("Byeeeeeeeeee");
                                sesion = false; // Cambiamos la variable para que el ciclo ya no se repita
                                break;
                        }

                    } while (sesion == true); // El menú se repite mientras sesion sea verdadero


                    break;

                // SALIR DEL PROGRAMA 
                case 4:
                    System.out.println("\nPrograma finalizado.");
                    break;

                // Si el usuario ingresa una opción que no existe
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4); // El ciclo se repite mientras no se elija la opción 4
    }

}


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
                    System.out.print("Ingrese la cantidad de posiciones a desplazar: ");
                    int desplazar = lea.nextInt(); // Cantidad de letras que se moverán

                    if (desplazar <= 0) {
                        System.out.println("El desplazamiento debe ser un número entero positivo.");
                        break;
                    }

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
                    System.out.print("Ingrese una frase: ");
                    String frase = lea.next();
                    System.out.print("Ingrese una longitud minima: ");
                    int longitud = lea.nextInt();

                    String palabraFiltro ="";
                    String palabraNormal ="";
                    
                    for (int conta = 0; conta < frase.length(); conta++) {
                        char letra = frase.charAt(conta);
                        if (letra == ' ' || !(letra >= 'a' && letra <= 'z') || !(letra >= 'A' || letra <= 'Z')) {
                            if (palabraNormal.length() >= longitud) {
                                palabraFiltro += palabraNormal + " ";
                            }
                            palabraNormal = "";
                        } else 
                        
                        {
                            palabraNormal += letra;
                        }
                    }

                    if (palabraNormal.length() >= longitud) {
                        palabraFiltro += palabraNormal;
                    }

                    System.out.println("Palabras con longitud mínima de " + longitud + ":");
                    System.out.println(palabraFiltro);

                // ====== OPCIÓN 3: CÓDIGO ENIGMA (ENCRIPTAR Y DESENCRIPTAR) ======
                case 3:
                    boolean sesion=true;
                    

                    do
                    {
                    System.out.println("\n--------------------------    MENÚ CÓDIGO ENIGMA   ------------------------");
                    System.out.println("Elige una de las siguientes opciones: \n    1) Encriptación \n    2) Desencriptación \n    3)Salir");
                        System.out.print("Ingrese opción: ");
                        int opcionEncrip=lea.nextInt();

                    switch (opcionEncrip)
                    { 

                        case 1:

                        String par="";
                        String impar="";
                             
                            System.out.println("--------------------------    MENÚ ENCRIPTACIÓN   ------------------------");

                            System.out.print("Ingrese la palabra a encriptar: ");
                            String palabra=lea.next();

                            char letra;
                            for(int i=0; i<palabra.length(); i++)
                            {
                            letra=palabra.charAt(i);
                            if (i%2==0)
                            {
                            par +=letra;
                            }
                            else
                            {
                            impar +=letra;
                            }
                            }
                            String encriptado= par+impar;
                            System.out.println("Palabra encriptada: " + encriptado);

                        break;
                        case 2:
                            System.out.println("\n--------------------------    MENÚ DESENCRIPTACIÓN   ------------------------");

                            System.out.println("Ingrese palabra a desencriptar: ");
                            encriptado=lea.next();
                            System.out.println("Encriptado: "+ encriptado);
                            int mitad= (encriptado.length()+1)/2;

                            String mitad1= encriptado.substring(0,mitad);
                                System.out.println(mitad1);
                            String mitad2= encriptado.substring(mitad);
                                System.out.println(mitad2);

                            String result="";

                            int l=0; int k=0;

                            for(int j=0; j<=encriptado.length(); j++)
                            {
                                if (j % 2 ==0 &&  l< mitad1.length()) {
                                result += mitad1.charAt(l);
                                l++;

                                } 
                                if (j % 2 != 0 && k < mitad2.length()) {
                                  result += mitad2.charAt(k);
                                  k++;
                                }


                            } 
                            System.out.println("Palabra Desencriptada: " + result); 
                        
                    break;
                    
                    case 3:
                        System.out.println("\nSaliste");
                        System.out.println("Byeeeeeeeeee");
                        sesion=false;
                }
                }while (sesion==true);

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

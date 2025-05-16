
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

                    // Evaluar sobre cada carácter de la frase original
                    for (int conta = 0; conta < fraseInicial.length(); conta++) {
                        char letraInicial = fraseInicial.charAt(conta);
                        char letraCifrada;

                        // Verificar si el carácter es una letra
                        if ((letraInicial >= 'a' && letraInicial <= 'z') || (letraInicial >= 'A' && letraInicial <= 'Z')) {
                        char base = Character.isLowerCase(letraInicial) ? 'a' : 'A'; // Si es minúscula ('a' base) o mayúscula ('A' base).
                        int nuevaPosicion = (letraInicial - base + desplazar) % 26; // Para ver la nueva posicion con 'desplazar' lugares y volviendo al inicio si pasa la 'z' o 'Z' por eso el Mod.
                        letraCifrada = (char) (base + nuevaPosicion); // Se convierte a la nueva letra cifrada (manteniendo mayúscula o minúscula).
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
                    System.out.print("Ingrese una frase: ");
                    String frase = lea.next();
                    System.out.print("Ingrese una longitud minima: ");
                    int longitud = lea.nextInt();

                    String palabraFiltro ="";
                    String palabraNormal ="";

                    for (int conta = 0; conta < frase.length(); conta++) {
                        char letra = frase.charAt(conta);
                        if (letra == ' ') {
                            if (palabraNormal.length() >= longitud) {
                                palabraFiltro += palabraNormal + " ";
                            }
                            palabraNormal = "";
                        } else {
                            palabraNormal += letra;
                        }
                    }

                    if (palabraNormal.length() >= longitud) {
                        palabraFiltro += palabraNormal;
                    }

                    System.out.println("Palabras con longitud mínima de " + longitud + ":");
                    System.out.println(palabraFiltro);

                    break;
                    
                case 3:
                     boolean sesion=true;
                    String encriptado="";

                    do
                    {
                    System.out.println("-------------------------- BIENVENIDO A TIENDA  -------------------------");
                    System.out.println("--------------------------    MENÚ PRINCIPAL    ------------------------");
                    System.out.println("Elige una de las siguientes opciones: \n    1) Encriptación \n    2) Desencriptación \n    3)Salir");
                        System.out.print("Ingrese opción: ");
                        int opcionEncrip=lea.nextInt();

                    switch (opcionEncrip)
                    { 

                        case 1:

                        String par="";
                        String impar="";

                            System.out.print("palabra:");
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
                            encriptado= par+impar;
                            System.out.println("encriptado " + encriptado);

                        break;
                        case 2:
                        if (encriptado.isEmpty())
                        {
                            System.out.println("no se ha encriptado ningun mensaje");
                        }
                        else
                        {
                        System.out.println("Encriptado "+ encriptado);
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
                        System.out.println("Desencriptado: " + result); 
                        }
                        break;

                        case 3:
                            System.out.println("Saliste");
                            System.out.println("Byeeeeeeeeee");
                            sesion=false;
                    }
                    }while (sesion==true);
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

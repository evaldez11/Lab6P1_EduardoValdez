/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_eduardovaldez;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author guali
 */
public class Lab6P1_EduardoValdez {

    static Scanner leer = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("**********Menu**********\n1. Conjuntos \n2. ¿Cuantos Primos tienes? \n3. Salir del Programa");
        int opcion = leer.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Size SET 1: ");
                int size = leer.nextInt();
                System.out.println("Size SET 2: ");
                int size2 = leer.nextInt();
                char num[] = new char[size];
                char num2[] = new char[size2];
                System.out.println("Conjuntos Generados");
                System.out.print("Set 1: ");
                imprimir(num = random(size));
                System.out.print("\nSet 2: ");
                imprimir(num2 = random(size2));
                System.out.println("");
                System.out.println("Operaciones\n1. Interseccion\n2. Diferencia\nIngrese una opcion: ");
                int Operacion = leer.nextInt();
                switch (Operacion) {
                    case 1:
                        imprimir(Intersection(num, num2));
                        break;
                    case 2:
                        break;

                }

                break;
            case 2:
                System.out.println("Ingrese tamaño del arreglo: ");
                int tamaño = leer.nextInt();
                System.out.println("Ingrese limite inferior: ");
                int inferior = leer.nextInt();
                System.out.println("Ingrese limite superior: ");
                int superior = leer.nextInt();
                int arreglo1[] = new int[tamaño];
                int arreglo2[] = new int[tamaño];
                if ((inferior < superior) && tamaño >= 0) {
                    System.out.println("");
                    imprimir2(arreglo1 = genRandarray(tamaño, inferior, superior));
                    System.out.println("");
                    imprimir2(arreglo2 = getTotal(arreglo1));
                }

                break;
            case 3:
                System.out.println("Salio del programa");
                break;
            default:
                break;

        }
    }

    public static void imprimir(char[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static char[] random(int size) {
        char temporal[] = new char[size];
        int num;
        for (int i = 0; i < size; i++) {
            num = rand.nextInt(9) + 65;
            char letra = (char) num;

            temporal[i] = letra;

        }
        return temporal;
    }

    public static int[] size(int size) {
        int temporal[] = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Ingresar posicion " + i);
            temporal[i] = leer.nextInt();
        }
        return temporal;
    }

    public static char[] Intersection(char[] A, char[] B) {
        char  num = 0;
        if (A.length > B.length){
        num = (char) B.length;
        }else if (B.length>A.length){
           num = (char) A.length; 
        }
        char inter[] = new char[num];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {
                    inter[i] = A[i];
                }
            }
        }
        return inter;
    }

    public static void imprimir2(int[] arreglo) {
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("[" + arreglo[i] + "]");
        }
        System.out.println("");
    }

    public static int[] genRandarray(int A, int B, int C) {
        int num;
        int temporal[] = new int[A];
        for (int i = 0; i < A; i++) {
            num = rand.nextInt((C - B) + 1) + B;
            temporal[i] = num;
        }
        return temporal;
    }

    public static boolean isPrime(int num) {
        boolean primo = false;
        int cont = 0;
        for (int i = 1; i < num + 1; i++) {
            if (num % i == 0) {
                cont++;
            }
        }
        if (cont != 2) {
            primo = false;
        } else {
            primo = true;
        }
        return primo;
    }

    public static int countPrimeFactors(int num) {
        int contprim = 0;
        for (int i = 2; i <= num; i++) {
            if (isPrime(i) && (num % i == 0)) {
                contprim++;
            }
        }
        return contprim;
    }

    public static int[] getTotal(int[] arreglo) {
        int temporal[] = new int[arreglo.length];
        for (int i = 0; i < arreglo.length; i++) {
            temporal[i] = countPrimeFactors(arreglo[i]);
        }
        return temporal;
    }
}

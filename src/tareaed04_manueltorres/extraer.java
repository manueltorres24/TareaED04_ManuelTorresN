/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaed04_manueltorres;

import TareaED04_ManuelTorres.TareaED04_ManuelTorres;
import java.util.Scanner;

/**
 *
 * @author Manuel
 */
public class extraer {

    public static void main(String[] args) {
        //las variables monedaUno y monedaDos servirán para guardar el resultado de la tirada de dos monedas
        int monedaUno;
        int monedaDos;
        int contadorCaras = 0;
        int contadorCruces = 0;
        int numTiradas;
        //las variables contador1 y contador2 servirán para guardar el número de caras y cruces dobles consecutivas
        int caraDobleConsecutiva = 0;
        int cruzDobleConsecutiva = 0;
        int maximoCarasDoblesConsecutivas = 0;
        int maximoCrucesDoblesConsecutivas = 0;
        boolean esCruzDoble = false;
        boolean esCaraDoble = false;
        String tirada1;
        String tirada2;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.print("Introduce el n\u00famero de veces que se van a lanzar las monedas (max 50): ");
            numTiradas = teclado.nextInt();
        } while (numTiradas < 1 || numTiradas > 50);
        for (int i = 0; i < numTiradas; i++) {
            monedaUno = (int) (Math.random() * 2);
            monedaDos = (int) (Math.random() * 2);
            if (monedaUno == 0) {
                contadorCaras++;
                tirada1 = "cara";
            } else {
                contadorCruces++;
                tirada1 = "cruz";
            }
            if (monedaDos == 0) {
                contadorCaras++;
                tirada2 = "cara";
            } else {
                contadorCruces++;
                tirada2 = "cruz";
            }
            System.out.println("Moneda 1: " + tirada1 + ", Moneda 2: " + tirada2);
            if (monedaUno == monedaDos) {
                if (monedaUno == 0) {
                    esCaraDoble = true;
                    esCruzDoble = false;
                } else {
                    esCaraDoble = false;
                    esCruzDoble = true;
                }
            } else {
                esCaraDoble = false;
                esCruzDoble = false;
            }
            if (esCaraDoble) {
                caraDobleConsecutiva++;
                if (caraDobleConsecutiva > maximoCarasDoblesConsecutivas) {
                    maximoCarasDoblesConsecutivas = caraDobleConsecutiva;
                }
            } else {
                caraDobleConsecutiva = 0;
            }
            if (esCruzDoble) {
                cruzDobleConsecutiva++;
                if (cruzDobleConsecutiva > maximoCrucesDoblesConsecutivas) {
                    maximoCrucesDoblesConsecutivas = cruzDobleConsecutiva;
                }
            } else {
                cruzDobleConsecutiva = 0;
            }
        }
        TareaED04_ManuelTorres.imprime(contadorCaras, contadorCruces, maximoCarasDoblesConsecutivas, maximoCrucesDoblesConsecutivas);
    }
    
}

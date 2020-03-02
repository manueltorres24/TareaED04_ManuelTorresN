package TareaED04_ManuelTorres;

import java.util.Scanner;

public class TareaED04_ManuelTorres {

    public static void main(String[] args) {
//las variables monedaUno y monedaDos servirán para guardar el resultado de la tirada de dos monedas
        int monedaUno, monedaDos;
        int contadorCaras = 0, contadorCruces = 0, numTiradas;
//las variables contador1 y contador2 servirán para guardar el número de caras y cruces dobles consecutivas
        int caraDobleConsecutiva = 0, cruzDobleConsecutiva = 0;
        int maximoCarasDoblesConsecutivas = 0, maximoCrucesDoblesConsecutivas = 0;
        boolean esCruzDoble = false, esCaraDoble = false;
        String tirada1;
        String tirada2;
        Scanner teclado = new Scanner(System.in);

        do {
            System.out.print("Introduce el número de veces que se van a lanzar las monedas (max 50): ");
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

        imprime(contadorCaras, contadorCruces, maximoCarasDoblesConsecutivas, maximoCrucesDoblesConsecutivas);
    }

    /**
     *
     * @param contadorCaras the value of contadorCaras
     * @param contadorCruces the value of contadorCruces
     * @param maximoCarasDoblesConsecutivas the value of maximoCarasDoblesConsecutivas
     * @param maximoCrucesDoblesConsecutivas the value of maximoCrucesDoblesConsecutivas
     */
    public static void imprime(int contadorCaras, int contadorCruces, int maximoCarasDoblesConsecutivas, int maximoCrucesDoblesConsecutivas) {
        System.out.println("Caras: " + contadorCaras + ", Cruces: " + contadorCruces);
        System.out.println("Maximo de caras dobles consecutivas: " + maximoCarasDoblesConsecutivas);
        System.out.println("Maximo de cruces dobles consecutivas: " + maximoCrucesDoblesConsecutivas);
    }
}

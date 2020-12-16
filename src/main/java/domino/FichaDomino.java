package domino;

/**
 * @author Alberto López Puertas
 * <alopezp90@gmail.com>
 */
import java.util.Random;

public class FichaDomino {

    private int valorA, valorB;

    //Constructor por defecto
    public FichaDomino() {
        this.valorA = 0;
        this.valorB = 0;
    }

    //Constructor parametrizado
    public FichaDomino(int a, int b) {
        this.valorA = valorValido(a);
        this.valorB = valorValido(b);
    }

    //metodo para comprobar si a y b son validos y sustituir si no lo son
    private int valorValido(int a) {
        if (a < 0 || a > 6) {
            if (a % 2 == 0) {
                a = 6;
            } else {
                a = 5;
            }
        }
        return a;
    }

    //Setter y getter, teniendo en cuenta la restriccion
    public int getValorA() {
        return valorA;
    }

    public void setValorA(int valorA) {
        this.valorA = valorValido(valorA);
    }

    public int getValorB() {
        return valorB;
    }

    public void setValorB(int valorB) {
        this.valorB = valorValido(valorB);
    }

    //método toString con formato pedido
    @Override
    public String toString() {
        String salida = "[" + valorA + "|" + valorB + "]";
        return salida.replaceAll("0", " ");
    }

    //metodo de suma de ambas partes de a ficha
    public byte getValorTotal() {
        return (byte) (valorA + valorB);
    }

    //metodo de clase que genere fichas aleatorias
    public static FichaDomino aleatoria() {
        Random rd = new Random();
        //return new FichaDomino(rd.nextInt(6) + 1, rd.nextInt(6) + 1);
        return new FichaDomino(rd.nextInt(7), rd.nextInt(7));
    }
}

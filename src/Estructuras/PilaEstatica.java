package Estructuras;

public class PilaEstatica {

    private int[] pila;
    private int tamano = 10;
    private int tope;

    public PilaEstatica() {
        pila = new int[tamano];
        tope = -1;
    }

    public PilaEstatica(int tam) {
        tamano = tam;
        tope = -1;
        pila = new int[tamano];
    }

    public boolean apilar(int nuevo) {
        boolean seApilo = false;

        if (tope != tamano - 1) {
            tope++;
            pila[tope] = nuevo;
            seApilo = true;
        }

        return seApilo;
    }

    public boolean desapilar() {
        boolean seDesapilo = false;

        if (!esVacia()) {
            tope--;
            seDesapilo = true;
        }

        return seDesapilo;
    }

    public int getTope() {
        return pila[tope];
    }

    public int getTamano() {
        return this.tamano;
    }

    public boolean esVacia() {
        return (tope == -1);
    }

    public PilaEstatica clonar() {
        PilaEstatica clon = new PilaEstatica(this.tamano);
        PilaEstatica holder = new PilaEstatica(this.tamano);
        int index = this.tope;

        //desapilar this y apilar holder
        for (int i = 0; i <= index; i++) {
            holder.apilar(this.getTope());
            this.desapilar();
        }
        //desapilar holder y apilar this y clon
        for (int i = 0; i <= index; i++) {
            this.apilar(holder.getTope());
            clon.apilar(holder.getTope());
            holder.desapilar();
        }
        return clon;
    }

    @Override
    public String toString() {
        String cadena = "Vacia!";
        if (!esVacia()) {
            cadena = "Datos: ";
            for (int i = 0; i <= tope; i++) {
                cadena = cadena + pila[i] + ", ";
            }
        }
        return cadena;
    }
}

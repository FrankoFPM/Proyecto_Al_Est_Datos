package Structures.ListasEnlazadas;

import java.io.Serializable;
import javax.swing.JTextArea;

public class ListaEnlazada implements Serializable {

    private Nodo ini;
    private Nodo fin;
    private int ctotal;

    public ListaEnlazada() {
        ini = fin = null;
    }

    //metodo que agrega un objeto al inicio de la lista
    public void AgregarAlInicio(Nodo nuevo) {
        if (ini == null && fin == null) {
            ini = fin = nuevo;
        } else {
            nuevo.sig = ini;
            ini = nuevo;
        }
    }

    //metodo que agrega un nodo al inicio de la lista
    public void AgregarAlFinal(Nodo nuevo) {
        if (ini == null && fin == null) {
            ini = fin = nuevo;
        } else {
            fin.sig = nuevo;
        }
        fin = nuevo;
        fin.sig = null;
    }

    /* public Nodo BuscarPorID(int idBuscado) {
        Nodo aux = ini;
        while (aux != null) {
         
            if (idBuscado == aux.inf.getID()) {
                return aux;
            }
            aux = aux.sig;
        }
        return null;
    }*/
    public Nodo BuscarPorID(int idBuscado) {
        Nodo aux = ini;
        int index = 1;  

        while (aux != null) {
            
            if (idBuscado == index) {
                return aux;
            }
            aux = aux.sig;
            index++;  // Aumenta el índice para cada nodo
        }
        return null;  // Si no se encuentra el informe
    }

    public void EliminarNodo(Nodo nodoEliminar) {
        if (ini == null) {
            return;
        }

        if (ini == nodoEliminar) {
            ini = ini.sig;
            if (ini == null) {
                fin = null;
            }
            return;
        }

        Nodo anterior = ini;
        Nodo actual = ini.sig;
        while (actual != null) {
            if (actual == nodoEliminar) {
                anterior.sig = actual.sig;
                if (actual == fin) {
                    fin = anterior;
                }
                return;
            }
            anterior = actual;
            actual = actual.sig;
        }
    }

    public void MostrarResumen(JTextArea txa) {
        int contEnProceso = 0, contAtendido = 0, contDerivado = 0;
        ctotal = 0;
        for (Nodo aux = ini; aux != null; aux = aux.sig) {
            ctotal++;
            switch (aux.inf.getAccionesTomadas()) {
                case "EN PROCESO":
                    contEnProceso++;
                    break;
                case "ATENDIDO":
                    contAtendido++;
                    break;
                case "DERIVADO":
                    contDerivado++;
                    break;
            }

        }//fin for
        txa.setText("\nCantidad informes          : " + ctotal);

    }

    public Nodo getIni() {
        return ini;
    }

    public void setIni(Nodo ini) {
        this.ini = ini;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public int getCtotal() {
        return ctotal;
    }

    public void setCtotal(int ctotal) {
        this.ctotal = ctotal;
    }

}

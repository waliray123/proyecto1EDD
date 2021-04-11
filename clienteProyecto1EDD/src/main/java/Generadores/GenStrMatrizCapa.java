/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generadores;

import estructuras.ListaEnlSim;
import estructuras.MatrizDispersa;
import nodos.NodoMatriz;
import objetos.Pixel;

/**
 *
 * @author user-ubunto
 */
public class GenStrMatrizCapa {

    private MatrizDispersa matrizC;
    private String strMat;

    public GenStrMatrizCapa(MatrizDispersa matrizC) {
        this.matrizC = matrizC;
        this.strMat = "";
        generarStrMatriz();
    }

    private void generarStrMatriz() {
        strMat = "digraph matC {";
        strMat += "node [shape=box] \n";
        strMat += "e0[ shape = point, width = 0 ];\n e1[ shape = point, width = 0 ];\n";
        strMat += "//Total filas " + matrizC.totalFilas + "\n";
        strMat += "//Total columnas " + matrizC.totalColumnas + "\n";
        insPixeles();
        strMat += "}";
    }

    private void insPixeles() {
        for (int i = 0; i <= matrizC.totalColumnas; i++) {
            String nodoAnt = "";
            strMat += "nodoCC" + i + "[label = \" C" + i + "\", group = " + String.valueOf(i) + "] ;\n";
            nodoAnt = "nodoCC" + i;
            for (int j = 0; j <= matrizC.totalFilas; j++) {
                if (i == 0 && j != 0) {
                    strMat += "nodoCF" + j + "[label = \" F" + j + "\", group = " + String.valueOf(i) + "] ;\n";
                    strMat += "nodoCF" + j + " -> " + nodoAnt + ";\n";
                    strMat += nodoAnt + " -> " + "nodoCF" + j + ";\n";
                    nodoAnt = "nodoCF" + j;
                }
                NodoMatriz<Pixel> nodoIns = matrizC.buscarNodo(i, j);
                if (nodoIns != null) {
                    Pixel pixelIns = nodoIns.getInfo();
                    if (pixelIns != null) {
                        String nombN = "nodo" + String.valueOf(j) + String.valueOf(i);
                        String color = nodoIns.getInfo().getColor();
                        strMat += nombN + "[label = \"" + color + "\", group = " + String.valueOf(i) + "] ;\n";
                        strMat += nodoAnt + " -> " + nombN + ";\n";
                        strMat += nombN + " -> " + nodoAnt + ";\n";
                        nodoAnt = nombN;
                    }
                }
            }
        }
        insRanks();
    }

    private void insRanks() {
        strMat += "{ rank = same; ";
        for (int x = 0; x <= matrizC.totalColumnas; x++) {
            strMat += "nodoCC" + x + " ; ";
        }
        strMat += "}\n";
        String nodoAntCol = "nodoCC" + 0;
        for (int x = 1; x <= matrizC.totalColumnas; x++) {
            strMat += nodoAntCol + " -> " + "nodoCC"+x + ";\n";
            strMat += "nodoCC"+x + " -> " + nodoAntCol + ";\n";
            nodoAntCol = "nodoCC"+x;
        }
        for (int i = 0; i <= matrizC.totalFilas; i++) {
            String nodoAnt = "nodoCF" + i;
            ListaEnlSim<String> nombresIns = new ListaEnlSim<>();
            for (int j = 0; j <= matrizC.totalColumnas; j++) {
                NodoMatriz<Pixel> nodoIns = matrizC.buscarNodo(j, i);
                if (nodoIns != null) {
                    Pixel pixelIns = nodoIns.getInfo();
                    if (pixelIns != null) {
                        String nombN = "nodo" + String.valueOf(i) + String.valueOf(j);
                        strMat += nodoAnt + " -> " + nombN + ";\n";
                        strMat += nombN + " -> " + nodoAnt + ";\n";
                        nodoAnt = nombN;
                        nombresIns.add(nombresIns, nombN);
                    }
                }
            }
            if (nombresIns.isEmpty() == false) {
                strMat += "{ rank = same; nodoCF" + i + " ; ";
                ListaEnlSim ultimo = nombresIns;
                while (ultimo != null) {
                    Object objErr = ultimo.getVal();
                    if (objErr != null) {
                        //Validar que no esten repeditos los id TODO
                        String nombIns = (String) ultimo.getVal();
                        strMat += nombIns + "; ";
                    }
                    ultimo = ultimo.getSig();
                }
                strMat += "}\n";
            }
        }
    }

    public MatrizDispersa getMatrizC() {
        return matrizC;
    }

    public void setMatrizC(MatrizDispersa matrizC) {
        this.matrizC = matrizC;
    }

    public String getStrMat() {
        return strMat;
    }

    public void setStrMat(String strMat) {
        this.strMat = strMat;
    }

}

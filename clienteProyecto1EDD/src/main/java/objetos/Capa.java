/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import estructuras.ListaEnlSim;
import estructuras.MatrizDispersa;

/**
 *
 * @author user-ubunto
 */
public class Capa {
    private int idCapa;
    private ListaEnlSim<Pixel> pixelesIns;
    private MatrizDispersa<Pixel> matrizPixeles;

    public int getIdCapa() {
        return idCapa;
    }

    public void setIdCapa(int idCapa) {
        this.idCapa = idCapa;
    }

    public ListaEnlSim<Pixel> getPixelesIns() {
        return pixelesIns;
    }

    public void setPixelesIns(ListaEnlSim<Pixel> pixelesIns) {
        this.pixelesIns = pixelesIns;
    }

    public MatrizDispersa<Pixel> getMatrizPixeles() {
        return matrizPixeles;
    }

    public void setMatrizPixeles(MatrizDispersa<Pixel> matrizPixeles) {
        this.matrizPixeles = matrizPixeles;
    }
        
    
}

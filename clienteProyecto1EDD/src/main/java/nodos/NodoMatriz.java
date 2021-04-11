/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodos;

/**
 *
 * @author user-ubunto
 * @param <Tipo>
 */
public class NodoMatriz<Tipo> {
    int x;
    int y;
    Tipo info;
    NodoMatriz antColumna,antFila,sigColumna,sigFila;

    public NodoMatriz(int x, int y, Tipo info) {
        this.x = x;
        this.y = y;
        this.info = info;
    }
        

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Tipo getInfo() {
        return info;
    }

    public void setInfo(Tipo info) {
        this.info = info;
    }

    public NodoMatriz getAntColumna() {
        return antColumna;
    }

    public void setAntColumna(NodoMatriz antColumna) {
        this.antColumna = antColumna;
    }

    public NodoMatriz getAntFila() {
        return antFila;
    }

    public void setAntFila(NodoMatriz antFila) {
        this.antFila = antFila;
    }

    public NodoMatriz getSigColumna() {
        return sigColumna;
    }

    public void setSigColumna(NodoMatriz sigColumna) {
        this.sigColumna = sigColumna;
    }

    public NodoMatriz getSigFila() {
        return sigFila;
    }

    public void setSigFila(NodoMatriz sigFila) {
        this.sigFila = sigFila;
    }
    
    
    
}

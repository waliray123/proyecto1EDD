/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;

import nodos.NodoMatriz;

/**
 *
 * @author user-ubunto
 * @param <Tipo>
 */
public class MatrizDispersa<Tipo> {
    private int totalNodos;
    public int totalFilas;
    public int totalColumnas;
    private NodoMatriz<Tipo> inicio;

    public MatrizDispersa() {
        inicio = new NodoMatriz<>(0,0,null);
        totalNodos = 0;
        totalFilas = 0;
        totalColumnas = 0;
    }
    
    public NodoMatriz<Tipo> crearNodo(int x, int y, Tipo info){
        return new NodoMatriz<>(x,y,info);
    }
    
    public NodoMatriz<Tipo> insertarFila(int fila){
        NodoMatriz<Tipo> cabeza = inicio.getSigFila();
        NodoMatriz<Tipo> nuevo = new NodoMatriz<>(0,fila,null);
        if (cabeza == null) {
            inicio.setSigFila(nuevo);
            nuevo.setAntColumna(inicio);
        }else{
            if (cabeza.getY() > fila) {
                nuevo.setSigFila(cabeza);
                cabeza.setAntFila(nuevo);
                inicio.setSigFila(nuevo);
                nuevo.setAntFila(inicio);
            }else{
                NodoMatriz<Tipo> aux = cabeza;
                while(aux.getSigFila() != null){
                    if (aux.getSigFila().getY() < fila) {
                        nuevo.setSigFila(aux.getSigFila());
                        aux.getSigFila().setAntFila(nuevo);
                        nuevo.setAntFila(aux);
                        aux.setSigFila(nuevo);
                        totalFilas++;
                        return nuevo;
                    }
                    aux = aux.getSigFila();
                }
                aux.setSigFila(nuevo);
                nuevo.setAntFila(aux);
            }        
        }
        
        if (fila > totalFilas) {
            totalFilas = fila;
        }
        
        return nuevo;
    }
    
    public NodoMatriz<Tipo> insertarColumna(int columna){
        NodoMatriz<Tipo> cabeza = inicio.getSigColumna();
        NodoMatriz<Tipo> nuevo = new NodoMatriz<>(columna,0,null);
        if (cabeza == null) {
            inicio.setSigColumna(nuevo);
            nuevo.setAntColumna(inicio);
        }else{
            if (cabeza.getX() > columna) {
                nuevo.setSigColumna(cabeza);
                cabeza.setAntColumna(nuevo);
                inicio.setSigColumna(nuevo);
                nuevo.setAntColumna(inicio);
            }else{
                NodoMatriz<Tipo> aux = cabeza;
                while(aux.getSigColumna() != null){
                    if (aux.getSigColumna().getX() < columna) {
                        nuevo.setSigColumna(aux.getSigColumna());
                        aux.getSigColumna().setAntColumna(nuevo);
                        nuevo.setAntColumna(aux);
                        aux.setSigColumna(nuevo);
                        totalColumnas++;
                        return nuevo;
                    }
                    aux = aux.getSigColumna();
                }
                aux.setSigColumna(nuevo);
                nuevo.setAntColumna(aux);
            }        
        }
        
        if (columna > totalColumnas) {
            totalColumnas = columna;
        }
        
        return nuevo;
    }
    
    public void insertar(int columna, int fila, Tipo info){
        NodoMatriz<Tipo> nuevo = new NodoMatriz(columna,fila,info);
        insertarNodo(nuevo);
    }
    
    public void insertarNodo(NodoMatriz<Tipo> nodoI){
        NodoMatriz<Tipo> nuevo = nodoI;
        int fila = nodoI.getY();
        int columna = nodoI.getX();
        NodoMatriz<Tipo> inicioFila = obtenerFila(fila,true);
        NodoMatriz<Tipo> inicioColumna = obtenerColumna(columna,true);
        
        NodoMatriz<Tipo> cabeza = inicioColumna.getSigFila();
        if (cabeza == null) {
            inicioColumna.setSigFila(nuevo);
            nuevo.setAntFila(inicioColumna);
        }else{
            if (cabeza.getY() > fila) {
                nuevo.setSigFila(cabeza);
                cabeza.setAntFila(nuevo);
                inicioColumna.setSigFila(nuevo);
                nuevo.setAntFila(inicioColumna);
            }else{
                NodoMatriz<Tipo> aux = cabeza;
                boolean insertado = false;
                while(aux.getSigFila() != null){
                    if (aux.getSigFila().getY() < fila) {
                        nuevo.setSigFila(aux.getSigFila());
                        aux.getSigFila().setAntFila(nuevo);
                        nuevo.setAntFila(aux);
                        aux.setSigFila(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getSigFila();
                }
                if (!insertado) {
                    aux.setSigFila(nuevo);
                    nuevo.setAntFila(aux);
                }
            }        
        }
        
        
        cabeza = inicioFila.getSigColumna();
        if (cabeza == null) {
            inicioFila.setSigColumna(nuevo);
            nuevo.setAntColumna(inicioFila);
        }else{
            if (cabeza.getX() > columna) {
                nuevo.setSigColumna(cabeza);
                cabeza.setAntColumna(nuevo);
                inicioFila.setSigColumna(nuevo);
                nuevo.setAntColumna(inicioFila);
            }else{
                NodoMatriz<Tipo> aux = cabeza;
                boolean insertado = false;
                while(aux.getSigColumna() != null){
                    if (aux.getSigColumna().getX() < columna) {
                        nuevo.setSigColumna(aux.getSigColumna());
                        aux.getSigColumna().setAntColumna(nuevo);
                        nuevo.setAntColumna(aux);
                        aux.setSigColumna(nuevo);
                        insertado = true;
                        break;
                    }
                    aux = aux.getSigColumna();
                }
                if (!insertado) {
                    aux.setSigColumna(nuevo);
                    nuevo.setAntColumna(aux);
                }
            }        
        }
        
    }
    
    public NodoMatriz<Tipo> obtenerFila(int fila, boolean bandera){
        NodoMatriz<Tipo> aux = inicio.getSigFila();
        while(aux != null){
            if (aux.getY() == fila) {
                return aux;
            }
            aux = aux.getSigFila();
        }
        if (bandera) {
            return insertarFila(fila);
        }
        return null;
    }
    
    public NodoMatriz<Tipo> obtenerColumna(int columna, boolean bandera){
        NodoMatriz<Tipo> aux = inicio.getSigColumna();
        while(aux != null){
            if (aux.getX() == columna) {
                return aux;
            }
            aux = aux.getSigColumna();
        }
        if (bandera) {
            return insertarColumna(columna);
        }
        return null;
    }
    
    public NodoMatriz<Tipo> buscarNodo(int columna, int fila){
        NodoMatriz<Tipo> nodoColumna = obtenerColumna(columna,false);
        if (nodoColumna != null) {
            NodoMatriz<Tipo> aux = nodoColumna;
            while(aux != null){
                if (aux.getY() == fila) {
                    return aux;
                }
                aux = aux.getSigFila();
            }
            return null;
        }else{
            return null;
        }
    }

    public int getTotalNodos() {
        return totalNodos;
    }

    public NodoMatriz<Tipo> getInicio() {
        return inicio;
    }
    
    
}

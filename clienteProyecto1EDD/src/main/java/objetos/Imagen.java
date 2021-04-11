/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import estructuras.ListaEnlSim;
import nodos.NodoAvl;

/**
 *
 * @author user-ubunto
 */
public class Imagen {
    private int idImagen;
    private ListaEnlSim<String> idCapasIns;
    private ListaEnlSim<NodoAvl<Capa>> nodosCapas;

    public Imagen() {
        this.idCapasIns = new ListaEnlSim<>();
        this.nodosCapas = new ListaEnlSim<>();
    }
    
    public int getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public ListaEnlSim<String> getIdCapasIns() {
        return idCapasIns;
    }

    public void setIdCapasIns(ListaEnlSim<String> idCapasIns) {
        this.idCapasIns = idCapasIns;
    }
            
    public void setNuevoIdCapaIns(String idCapa){
        idCapasIns.add(idCapasIns, idCapa);
    }
    
    public void setNuevaCapa(NodoAvl<Capa> nodo){
        nodosCapas.add(nodosCapas, nodo);
    }

    public ListaEnlSim<NodoAvl<Capa>> getNodosCapas() {
        return nodosCapas;
    }
    
    
}

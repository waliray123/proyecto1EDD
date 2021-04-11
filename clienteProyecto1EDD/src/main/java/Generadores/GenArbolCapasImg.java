/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generadores;

import estructuras.ArbolAvl;
import estructuras.ListaEnlSim;
import nodos.NodoAvl;
import objetos.Capa;
import objetos.Imagen;

/**
 *
 * @author user-ubunto
 */
public class GenArbolCapasImg {
    private ArbolAvl<Capa> arbolCapas;
    private String strArbol;
    private Imagen imgIns;

    public GenArbolCapasImg(ArbolAvl<Capa> arbolCapas, Imagen imgIns) {
        this.arbolCapas = arbolCapas;
        this.imgIns = imgIns;
        this.strArbol = "";
        genStrArbol();
    }
    
    private void genStrArbol(){        
        NodoAvl<Capa> raiz = arbolCapas.getRaiz();
        strArbol = "digraph G {\n";
        strArbol += "node [shape=record];\n";
        inOrden(raiz,null,null);
        insertarImagen();
        strArbol += "}\n";
    }    
    
    private void inOrden(NodoAvl<Capa> nodo,NodoAvl<Capa> nodoPadre,String lado){        
        if (nodo == null) {
            return;
        }
        strArbol += "nodeU"+nodo.getInfo().getIdCapa()+"[label=\"<f0> |<f1> Capa: "+ nodo.getInfo().getIdCapa() + "|<f2>\"];\n";
        if (nodoPadre != null) {
            strArbol += "nodeU"+nodoPadre.getInfo().getIdCapa()+": "+lado+" -> nodeU"+nodo.getInfo().getIdCapa()+":f1;\n";
        }        
        inOrden(nodo.getIzq(),nodo,"f0");        
        inOrden(nodo.getDer(),nodo,"f2");
    }
    
    private void insertarImagen(){
        String idImg = String.valueOf(imgIns.getIdImagen());
        strArbol += "nodeI" + idImg +" [label = \" Id Imagen: "+ idImg+"\"]" + ";\n";        
        String nombI = String.valueOf(imgIns.getIdImagen());
//        strArbol += "subgraph cluster_capasImg"+nombI +"{ \n";
        String nodoAnt = "nodeI" + String.valueOf(imgIns.getIdImagen());
        ListaEnlSim<NodoAvl<Capa>> nodosCapas = imgIns.getNodosCapas();
        ListaEnlSim ultimo = nodosCapas;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {               
                NodoAvl<Capa> nodoCapa = (NodoAvl<Capa>) ultimo.getVal();
                String nodoP = "nodeU"+nodoCapa.getInfo().getIdCapa() + nombI;
                strArbol += nodoP + " [label = \" Id Capa: "+ nodoCapa.getInfo().getIdCapa()+"\"]" +";\n";
                strArbol += nodoP + " -> " + "nodeU"+nodoCapa.getInfo().getIdCapa()+":<f1>" + ";\n";
                strArbol += nodoAnt + " -> "+ nodoP +";\n";
                nodoAnt = nodoP;
            }
            ultimo = ultimo.getSig();
        }
//        strArbol += "} \n";
    }

    public String getStrArbol() {
        return strArbol;
    }
}

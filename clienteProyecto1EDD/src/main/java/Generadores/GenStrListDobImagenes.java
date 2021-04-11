/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generadores;

import estructuras.ListaDobEnl;
import estructuras.ListaEnlSim;
import nodos.NodoAvl;
import nodos.NodoListDob;
import objetos.Capa;
import objetos.Imagen;

/**
 *
 * @author user-ubunto
 */
public class GenStrListDobImagenes {

    private ListaDobEnl<Imagen> imagenes;
    private String strImg;

    public GenStrListDobImagenes(ListaDobEnl<Imagen> imagenes) {
        this.imagenes = imagenes;
        strImg = "";
        crearStrImg();
    }

    private void crearStrImg() {
        strImg = "digraph Img {\n";
//        strImg += "rankdir=LR\n";
        strImg += "node [shape=box]\n";
        insImagenes();
        strImg += "}";
    }
    
    //TODO por cada imagen que muestra sus capas
    private void insImagenes() {
        NodoListDob<Imagen> raiz = imagenes.getRaiz();
        String idImg = String.valueOf(raiz.getInfo().getIdImagen());
        strImg += "nodeI" + idImg +" [label = \" Id Imagen: "+ idImg+"\"]" + ";\n";
        //insertarCapas(raiz.getInfo());
        NodoListDob<Imagen> ultimo = raiz;
        while (ultimo.getSig() != null) {
            String nombS = String.valueOf(ultimo.getSig().getInfo().getIdImagen());
            String nombU = String.valueOf(ultimo.getInfo().getIdImagen());
            insertarCapas(ultimo.getInfo());
            strImg += "nodeI" + nombS +" [label = \" Id Imagen: "+ nombS+"\"]" +";\n";            
            strImg += "nodeI" + nombU + " ->"+" nodeI" + nombS +";\n";            
            if (ultimo.getSig().getAnt() != null) {
                String nombA = String.valueOf(ultimo.getSig().getAnt().getInfo().getIdImagen());                
                strImg += "nodeI" + nombS + " ->"+" nodeI" + nombA +";\n";
            }
            ultimo = ultimo.getSig();
        }
        insertarCapas(ultimo.getInfo());
    }
    
    private void insertarCapas(Imagen imgIns){        
        String nombI = String.valueOf(imgIns.getIdImagen());
        strImg += "subgraph cluster_capasImg"+nombI +"{ \n";
        String nodoAnt = "nodeI" + String.valueOf(imgIns.getIdImagen());
        ListaEnlSim<NodoAvl<Capa>> nodosCapas = imgIns.getNodosCapas();
        ListaEnlSim ultimo = nodosCapas;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {               
                NodoAvl<Capa> nodoCapa = (NodoAvl<Capa>) ultimo.getVal();
                String nodoP = "nodeU"+nodoCapa.getInfo().getIdCapa() + nombI;
                strImg += nodoP + " [label = \" Id Capa: "+ nodoCapa.getInfo().getIdCapa()+"\"]" +";\n";
                strImg += nodoAnt + " -> "+ nodoP +";\n";
                nodoAnt = nodoP;
            }
            ultimo = ultimo.getSig();
        }
        strImg += "} \n";
    }

    public String getStrImg() {
        return strImg;
    }

    public void setStrImg(String strImg) {
        this.strImg = strImg;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generadores;

import estructuras.ArbolAvl;
import nodos.NodoAvl;
import objetos.Usuario;

/**
 *
 * @author user-ubunto
 */
public class GenStrArbolUsuarios {
    private ArbolAvl<Usuario> arbolUsuarios;
    private String strArbol;

    public GenStrArbolUsuarios(ArbolAvl<Usuario> arbolUsuarios) {
        this.arbolUsuarios = arbolUsuarios;
        this.strArbol = "";
        genStrArbol();
    }
    
    private void genStrArbol(){
        int cont = 0;
        NodoAvl<Usuario> raiz = arbolUsuarios.getRaiz();
        strArbol = "digraph G {\n";
        strArbol += "node [shape=record];\n";
        inOrden(raiz,null,null);
        strArbol += "}\n";
    }
    
//    private void inOrden(NodoAvl<Usuario> nodo,NodoAvl<Usuario> nodoPadre){        
//        if (nodo == null) {
//            return;
//        }
//        strArbol += "nodeU"+nodo.getInfo().getNombreUsuario()+";\n";
//        if (nodoPadre != null) {
//            strArbol += "nodeU"+nodoPadre.getInfo().getNombreUsuario()+" -> nodeU"+nodo.getInfo().getNombreUsuario()+";\n";
//        }        
//        inOrden(nodo.getIzq(),nodo);        
//        inOrden(nodo.getDer(),nodo);
//    }
    
    private void inOrden(NodoAvl<Usuario> nodo,NodoAvl<Usuario> nodoPadre,String lado){        
        if (nodo == null) {
            return;
        }
        strArbol += "nodeU"+nodo.getInfo().getNombreUsuario()+"[label=\"<f0> |<f1>"+ nodo.getInfo().getNombreUsuario() + "|<f2>\"];\n";
        if (nodoPadre != null) {
            strArbol += "nodeU"+nodoPadre.getInfo().getNombreUsuario()+": "+lado+" -> nodeU"+nodo.getInfo().getNombreUsuario()+":f1;\n";
        }        
        inOrden(nodo.getIzq(),nodo,"f0");        
        inOrden(nodo.getDer(),nodo,"f2");
    }

    public String getStrArbol() {
        return strArbol;
    }
    
}

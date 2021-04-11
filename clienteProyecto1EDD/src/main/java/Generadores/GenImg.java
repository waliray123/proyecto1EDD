/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Generadores;

import estructuras.MatrizDispersa;
import nodos.NodoMatriz;
import objetos.Capa;
import objetos.Pixel;

/**
 *
 * @author user-ubunto
 */
public class GenImg {
    
    private Capa capaMos;
    private String strImg;
    private MatrizDispersa<Pixel> matrizPixeles;
    private int totalFilas;
    private int totalColumnas;

    public GenImg(Capa capaMos) {        
        this.capaMos = capaMos;
        this.matrizPixeles = capaMos.getMatrizPixeles();
        this.totalFilas = matrizPixeles.totalFilas;
        this.totalColumnas = matrizPixeles.totalColumnas;
        this.strImg = "";
        generarStr();
    }
    
    private void generarStr(){
        strImg = "digraph G{\n";        
        strImg += "graph [truecolor=true bgcolor=\"transparent\"];\n";
        strImg += "nodeMat [\n";
        strImg += "shape = none\n" +
"        label = <<table border=\"0\" cellspacing=\"0\">\n";
        insertarPixeles();
        strImg += "</table>>\n";        
        strImg += "]\n";
        strImg += "}\n";
    }
    
    private void insertarPixeles(){
        for (int i = 1; i <= this.totalFilas; i++) {
            strImg += "<tr>\n";
            for (int j = 1; j <= this.totalColumnas; j++) {
                //<td border="0" bgcolor="blue">    </td>
                NodoMatriz<Pixel> nodoPixl = matrizPixeles.buscarNodo(j, i);
                if (nodoPixl != null) {
                    Pixel pixelIns = nodoPixl.getInfo();
                    String color = pixelIns.getColor();
                    strImg += "<td border=\"0\" bgcolor=\""+color+"\">    </td>\n";
                }else{
                    strImg += "<td border=\"0\" bgcolor=\"white\">    </td>\n";
                }
                
                
            } 
            strImg += "</tr>\n";
        }
    }

    public String getStrImg() {
        return strImg;
    }

    public void setStrImg(String strImg) {
        this.strImg = strImg;
    }
    
    
    
}

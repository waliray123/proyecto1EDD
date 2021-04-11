/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import GUI.JFMostrarImagen;
import Generadores.GenImg;
import estructuras.ArbolAvl;
import estructuras.ListaEnlSim;
import estructuras.MatrizDispersa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.swing.JOptionPane;
import nodos.NodoAvl;
import nodos.NodoMatriz;
import objetos.Capa;
import objetos.Imagen;
import objetos.Pixel;

/**
 *
 * @author user-ubunto
 */
public class ControlGenImagen {

    private ControlDatos controlDatos;
    private String pathGuardado;
    private Capa capaMost;
    private MatrizDispersa<Pixel> matrizPixeles;

    public ControlGenImagen(ControlDatos controlDatos, String pathGuardado) {
        this.controlDatos = controlDatos;
        this.pathGuardado = pathGuardado;
    }

    public void generarImagenPorCapa(Capa capaMostr) {
        GenImg genImg = new GenImg(capaMostr);
        String entrada = genImg.getStrImg();
        try {
            String ruta = this.pathGuardado + "/imagenPix.dot";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(entrada);
            bw.close();
//            //Generar Imagen creada por .dot
            ControlTerminal controlTer = new ControlTerminal(ruta,this.pathGuardado+"/imagenPix.png");             
//            //Mostrar Imagen Guardada
//            JFMostrarImagen jfMI = new JFMostrarImagen(this.pathGuardado + "/imagenPix.png");
//            jfMI.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generarImagenPorIdImagen(Imagen imagenIns) {
        capaMost = new Capa();
        matrizPixeles = new MatrizDispersa<>();
        capaMost.setMatrizPixeles(matrizPixeles);
        ListaEnlSim<NodoAvl<Capa>> nodosCapas = imagenIns.getNodosCapas();
        if (nodosCapas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay capas que graficar");
        } else {
            insCapa(nodosCapas);
            generarImagenPorCapa(this.capaMost);
        }
    }
    
    private void insCapa(ListaEnlSim<NodoAvl<Capa>> ultimo){
        if (ultimo.getSig() != null) {
            insCapa(ultimo.getSig());
        }
        NodoAvl<Capa> nodoCapa = ultimo.getVal();
        if (nodoCapa != null) {
            Capa capaIns = nodoCapa.getInfo();
            if (capaIns != null) {
                sobrePonerCapa(capaIns);
            }            
        }
        
    }

    private void sobrePonerCapa(Capa capaSob) {
        MatrizDispersa<Pixel> matPixMost = capaMost.getMatrizPixeles();
        MatrizDispersa<Pixel> matPixSob = capaSob.getMatrizPixeles();
        for (int i = 1; i <= matPixSob.totalFilas; i++) {            
            for (int j = 1; j <= matPixSob.totalColumnas; j++) {                
                NodoMatriz<Pixel> nodoPixl = matPixSob.buscarNodo(j, i);
                NodoMatriz<Pixel> nodoPixlMost = matPixMost.buscarNodo(j, i);
                if (nodoPixl != null) {
                    Pixel pixelIns = nodoPixl.getInfo();
                    if (nodoPixlMost != null) {
                        Pixel nuevoPix = new Pixel();
                        nuevoPix.setColor(pixelIns.getColor());
                        nodoPixlMost.setInfo(nuevoPix);
                    }else{
                        matPixMost.insertar(j, i, pixelIns);
                    }                    
                } else {
                    
                }
            }            
        }
    }
    
    public void generarArbolCapas(String tipoOrden, ListaEnlSim<String> idCapas){
        capaMost = new Capa();
        matrizPixeles = new MatrizDispersa<>();
        capaMost.setMatrizPixeles(matrizPixeles);
        ArbolAvl<Capa> arbolCapasMost = new ArbolAvl<>();
        ListaEnlSim<String> ultimo = idCapas;
        while(ultimo != null){
            String idC = ultimo.getVal();
            if (idC != null) {
                //Buscar capa
                Capa capaIns = this.controlDatos.buscarCapaEnArbol(idC);
                if (capaIns != null) {
                    //Ingresar capa en arbol
                    arbolCapasMost.insertar(idC, capaIns);
                }
            }
            ultimo = ultimo.getSig();
        }
        if (tipoOrden.equals("inOrder")) {
            inOrden(arbolCapasMost.getRaiz());
        }else if (tipoOrden.equals("preOrder")) {
            preOrden(arbolCapasMost.getRaiz());
        }else if (tipoOrden.equals("postOrder")) {
            postOrden(arbolCapasMost.getRaiz());
        }
        generarImagenPorCapa(this.capaMost);
    }
    
    
    private void inOrden(NodoAvl<Capa> nodo){
        if (nodo == null) {
            return;
        }        
        inOrden(nodo.getIzq());
        Capa capaSob = nodo.getInfo();
        sobrePonerCapa(capaSob);
        inOrden(nodo.getDer());   
    }
    
    private void preOrden(NodoAvl<Capa> nodo){
        if (nodo == null) {
            return;
        }
        Capa capaSob = nodo.getInfo();
        sobrePonerCapa(capaSob);
        preOrden(nodo.getIzq());
        preOrden(nodo.getDer());        
    }
    
    private void postOrden(NodoAvl<Capa> nodo){
        if (nodo == null) {
            return;
        }
        postOrden(nodo.getIzq());
        postOrden(nodo.getDer());
        Capa capaSob = nodo.getInfo();
        sobrePonerCapa(capaSob);
    }

}

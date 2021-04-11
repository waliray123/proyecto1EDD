/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Generadores.GenArbolCapasImg;
import Generadores.GenStrArbolCapas;
import Generadores.GenStrArbolUsuarios;
import Generadores.GenStrListDobImagenes;
import Generadores.GenStrMatrizCapa;
import estructuras.ArbolAvl;
import estructuras.ListaDobEnl;
import estructuras.MatrizDispersa;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import nodos.NodoAvl;
import nodos.NodoListDob;
import objetos.Capa;
import objetos.Imagen;
import objetos.Usuario;

/**
 *
 * @author user-ubunto
 */
public class ControlEstadoMemoria {

    private ControlDatos controlDatos;
    private String pathGuardado;

    public ControlEstadoMemoria(ControlDatos controlDatos, String pathG) {
        this.controlDatos = controlDatos;
        this.pathGuardado = pathG;
    }

    public void generarArbolUsuarios() {
        ArbolAvl<Usuario> arbolUsuarios = controlDatos.getArbolUsuarios();
        GenStrArbolUsuarios genStrArbol = new GenStrArbolUsuarios(arbolUsuarios);
        String strArbol = genStrArbol.getStrArbol();
        try {
            String ruta = this.pathGuardado + "/grafico.dot";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strArbol);
            bw.close();
            ControlTerminal controlTer = new ControlTerminal(ruta,this.pathGuardado+"/grafico.png");             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generarListaImagenes() {
        ListaDobEnl<Imagen> imagenes = controlDatos.getImagenes();
        GenStrListDobImagenes genStrImg = new GenStrListDobImagenes(imagenes);
        String strImg = genStrImg.getStrImg();
        try {
            String ruta = this.pathGuardado + "/graficoImg.dot";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strImg);
            bw.close();
            ControlTerminal controlTer = new ControlTerminal(ruta,this.pathGuardado+"/graficoImg.png");  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generarArbolCapas() {
        ArbolAvl<Capa> arbolCapas = controlDatos.getArbolCapas();
        GenStrArbolCapas genStrArbol = new GenStrArbolCapas(arbolCapas);
        String strArbol = genStrArbol.getStrArbol();
        try {
            String ruta = this.pathGuardado + "/graficoCapa.dot";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(strArbol);
            bw.close();
            ControlTerminal controlTer = new ControlTerminal(ruta,this.pathGuardado+"/graficoCapa.png");  
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generarMatrizCapa(String idCapa) {
        ArbolAvl<Capa> arbolCapas = controlDatos.getArbolCapas();
        NodoAvl<Capa> nodoCapa = arbolCapas.buscar(idCapa);
        if (nodoCapa != null) {
            //Capa si existe
            Capa capaDib = nodoCapa.getInfo();
            MatrizDispersa matrizC = capaDib.getMatrizPixeles();
            GenStrMatrizCapa genMC = new GenStrMatrizCapa(matrizC);
            String strMat = genMC.getStrMat();
            try {
                String ruta = this.pathGuardado + "/graficoMat.dot";
                File file = new File(ruta);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(strMat);
                bw.close();
                ControlTerminal controlTer = new ControlTerminal(ruta,this.pathGuardado+"/graficoMat.png");  
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //Capa no existe 
            JOptionPane.showMessageDialog(null,"El id de capa no existe");
        }
    }
    
    public void generarArbolCapasImagen(String idImagen){
        Imagen imgIns = this.controlDatos.buscarImagenEnLista(idImagen);
        if (imgIns != null) {
            GenArbolCapasImg genStrArbolImg = new  GenArbolCapasImg(this.controlDatos.getArbolCapas(),imgIns);
            String strMat = genStrArbolImg.getStrArbol();
            try {
                String ruta = this.pathGuardado + "/graficoArbolImg.dot";
                File file = new File(ruta);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(strMat);
                bw.close();
                ControlTerminal controlTer = new ControlTerminal(ruta,this.pathGuardado+"/graficoArbolImg.png");  
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null,"La imagen no existe");
        }
    
    }

}

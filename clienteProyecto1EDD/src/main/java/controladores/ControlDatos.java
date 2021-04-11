/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import GUI.JFErrores;
import analizadores.LexerCapas;
import analizadores.LexerImg;
import analizadores.LexerUsers;
import analizadores.ParserCapas;
import analizadores.ParserImg;
import analizadores.ParserUsers;
import estructuras.ArbolAvl;
import estructuras.ListaDobEnl;
import estructuras.ListaEnlSim;
import estructuras.MatrizDispersa;
import java.io.StringReader;
import javax.swing.JOptionPane;
import nodos.NodoAvl;
import nodos.NodoListDob;
import objetos.Capa;
import objetos.ErrorCom;
import objetos.Imagen;
import objetos.Pixel;
import objetos.Usuario;

/**
 *
 * @author user-ubunto
 */
public class ControlDatos {

    private ArbolAvl<Usuario> arbolUsuarios;
    private ArbolAvl<Capa> arbolCapas;
    private ListaEnlSim<ErrorCom> erroresComp;
    private ListaDobEnl<Imagen> imagenes;
    private int contUsuarios;

    public ControlDatos() {
        this.arbolUsuarios = new ArbolAvl();
        this.arbolCapas = new ArbolAvl();
        this.imagenes = new ListaDobEnl<>();
        this.erroresComp = new ListaEnlSim<>();
        contUsuarios = 1;
    }

    public void leerCapas(String entrada) {
        ListaEnlSim<Capa> capasIns = new ListaEnlSim<>();
        StringReader reader = new StringReader(entrada);
        LexerCapas lexico = new LexerCapas(reader);
        ParserCapas parser = new ParserCapas(lexico);
        try {
            parser.parse();
            erroresComp = parser.getErroresCom();
            capasIns = parser.getTodasCapas();
//            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error irrecuperable");
            System.out.println("Causa: " + ex.getCause());
            System.out.println("Causa2: " + ex.toString());
        }
        if (erroresComp.isEmpty()) {
            //No hay errores y puede insertar los pixeles en las capas
            if (capasIns.isEmpty() == false) {
                insertarCapas(capasIns);
            } else {
                //No hay capas que insertar
            }
        } else {
            //Hay errores mostrar errores en un JF
            JFErrores jfErrores = new JFErrores(erroresComp);
            jfErrores.setVisible(true);
        }
    }

    private void insertarPixelesEnCapas(Capa capaIns) {
        ListaEnlSim<Pixel> pixelesIns = capaIns.getPixelesIns();
        MatrizDispersa<Pixel> matrizPixeles = new MatrizDispersa<>();
        ListaEnlSim<Pixel> auxPix = pixelesIns;
        while (auxPix != null) {
            Object objErr = auxPix.getVal();
            if (objErr != null) {
                Pixel pixelIns = (Pixel) auxPix.getVal();
                int fila = pixelIns.getFila();
                int columna = pixelIns.getColumna();
                matrizPixeles.insertar(columna, fila, pixelIns);
            }
            auxPix = auxPix.getSig();
        }
        capaIns.setMatrizPixeles(matrizPixeles);
    }

    private void insertarCapas(ListaEnlSim<Capa> capasIns) {
        ListaEnlSim ultimo = capasIns;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {
                Capa capaIns = (Capa) ultimo.getVal();
                String idCapa = String.valueOf(capaIns.getIdCapa());
                //TODO Validar que el id de la capa no exista en el arbol 
                insertarPixelesEnCapas(capaIns);
                this.arbolCapas.insertar(idCapa, capaIns);
            }
            ultimo = ultimo.getSig();
        }
    }

    public void leerImagenes(String entrada) {
        ListaEnlSim<Imagen> imagenesIns = new ListaEnlSim<>();
        StringReader reader = new StringReader(entrada);
        LexerImg lexico = new LexerImg(reader);
        ParserImg parser = new ParserImg(lexico);
        try {
            parser.parse();
            erroresComp = parser.getErroresCom();
            imagenesIns = parser.getTodasImagenes();
//            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error irrecuperable");
            System.out.println("Causa: " + ex.getCause());
            System.out.println("Causa2: " + ex.toString());
        }
        if (erroresComp.isEmpty()) {
            //No hay errores y puede insertar las imagenes
            if (imagenesIns.isEmpty() == false) {
                //TODO: Insertar imagenes en lista e insertar capas en imagenes                
                insertarImagenes(imagenesIns);
            } else {
                //No hay Imagenes que insertar
            }

        } else {
            //Hay errores mostrar errores en un JF
            JFErrores jfErrores = new JFErrores(erroresComp);
            jfErrores.setVisible(true);
        }

    }

    public void leerUsuarios(String entrada) {
        ListaEnlSim<Usuario> usuariosIns = new ListaEnlSim<>();
        StringReader reader = new StringReader(entrada);
        LexerUsers lexico = new LexerUsers(reader);
        ParserUsers parser = new ParserUsers(lexico);
        try {
            parser.parse();
            erroresComp = parser.getErroresCom();
            usuariosIns = parser.getTodosUsuarios();
//            System.out.println("");
        } catch (Exception ex) {
            System.out.println("Error irrecuperable");
            System.out.println("Causa: " + ex.getCause());
            System.out.println("Causa2: " + ex.toString());
        }
        if (erroresComp.isEmpty()) {
            //No hay errores y puede insertar las imagenes
            if (usuariosIns.isEmpty() == false) {
                //TODO insertar usuarios en arbol
//                MostrarUsuarios(usuariosIns);
                insertarUsuarios(usuariosIns);
            } else {
                //No hay Imagenes que insertar
            }

        } else {
            //Hay errores mostrar errores en un JF
            JFErrores jfErrores = new JFErrores(erroresComp);
            jfErrores.setVisible(true);
        }

    }

    private void MostrarImagenes(ListaEnlSim<Imagen> imagenesIns) {
        ListaEnlSim ultimo = imagenesIns;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {
                Imagen imgIns = (Imagen) ultimo.getVal();
                System.out.println("Id Imagen: " + imgIns.getIdImagen());
                ListaEnlSim<String> idCapas = imgIns.getIdCapasIns();
                ListaEnlSim ultimo2 = idCapas;
                while (ultimo2 != null) {
                    Object objErr2 = ultimo2.getVal();
                    if (objErr2 != null) {
                        String idCapa = (String) ultimo2.getVal();
                        System.out.println("    Id CapaIns: " + idCapa);
                    }
                    ultimo2 = ultimo2.getSig();
                }
            }
            ultimo = ultimo.getSig();
        }
    }

    private void MostrarUsuarios(ListaEnlSim<Usuario> usuariosIns) {
        ListaEnlSim ultimo = usuariosIns;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {
                Usuario userIns = (Usuario) ultimo.getVal();
                System.out.println("Nombre Usuario: " + userIns.getNombreUsuario());
            }
            ultimo = ultimo.getSig();
        }
    }

    private void insertarUsuarios(ListaEnlSim<Usuario> usuariosIns) {
        ListaEnlSim ultimo = usuariosIns;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {
                //Validar que no esten repeditos los id TODO                           
                Usuario userIns = (Usuario) ultimo.getVal();
                insertarImagenesUsuario(userIns);
                this.arbolUsuarios.insertar(userIns.getNombreUsuario(), userIns);
                this.contUsuarios++;
            }
            ultimo = ultimo.getSig();
        }
    }

    private void insertarImagenesUsuario(Usuario usuarioIns) {
        ListaEnlSim<String> idImagenesIns = usuarioIns.getIdImagenesIns();
        if (idImagenesIns.isEmpty() == false) {
            ListaEnlSim ultimo = idImagenesIns;
            while (ultimo != null) {
                Object objErr = ultimo.getVal();
                if (objErr != null) {
                    String idImagen = (String) ultimo.getVal();
                    Imagen img = buscarImagen(idImagen);
                    if (img != null) {
                        usuarioIns.setNuevaImagen(img);
                    } else {
                        //La imagen no existe
                    }
                }
                ultimo = ultimo.getSig();
            }
        }
    }

    private Imagen buscarImagen(String idImagen) {
        Imagen imgR = null;
        NodoListDob<Imagen> ultimo = this.imagenes.getRaiz();
        while (ultimo != null) {
            Imagen img = ultimo.getInfo();
            if (img != null) {
                String idImg = String.valueOf(img.getIdImagen());
                if (idImagen.equals(idImg)) {
                    return img;
                }
            }
            ultimo = ultimo.getSig();
        }
        return imgR;
    }

    private void insertarImagenes(ListaEnlSim<Imagen> imagenesIns) {
        ListaEnlSim ultimo = imagenesIns;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {
                //Validar que no esten repeditos los id TODO                          
                Imagen imgIns = (Imagen) ultimo.getVal();
                insertarCapasEnImagen(imgIns);
                this.imagenes.insertar(imgIns);
            }
            ultimo = ultimo.getSig();
        }
    }

    private void insertarCapasEnImagen(Imagen imgIns) {
        ListaEnlSim<String> idCapasIns = imgIns.getIdCapasIns();
        if (idCapasIns.isEmpty() == false) {
            ListaEnlSim ultimo = idCapasIns;
            while (ultimo != null) {
                Object objErr = ultimo.getVal();
                if (objErr != null) {
                    String idCapa = (String) ultimo.getVal();
                    NodoAvl<Capa> nodoCapa = arbolCapas.buscar(String.valueOf(idCapa));
                    if (nodoCapa != null) {
                        imgIns.setNuevaCapa(nodoCapa);
                    } else {
                        //La capa no existe
                    }
                }
                ultimo = ultimo.getSig();
            }
        }
    }

    public void insertarNuevoUsuario(String idUsuario) {
        Usuario usuarioNuevo = new Usuario();
        usuarioNuevo.setNombreUsuario(idUsuario);
        this.arbolUsuarios.insertar(usuarioNuevo.getNombreUsuario(), usuarioNuevo);
        this.contUsuarios++;
    }

    public Usuario buscarUsuarioEnArbol(String idUsuario) {
        NodoAvl<Usuario> nodoU = this.arbolUsuarios.buscar(idUsuario);
        if (nodoU != null) {
            Usuario usuarioR = nodoU.getInfo();
            return usuarioR;
        }
        return null;
    }

    public Capa buscarCapaEnArbol(String idCapa) {
        NodoAvl<Capa> nodoU = this.arbolCapas.buscar(idCapa);
        if (nodoU != null) {
            Capa capaR = nodoU.getInfo();
            return capaR;
        }
        return null;
    }

    public int buscarIndexImagenEnLista(String id) {
        int index = 0;
        NodoListDob<Imagen> aux = imagenes.getRaiz();
        while (aux != null) {
            Imagen img = aux.getInfo();
            if (img != null) {
                String idImg = String.valueOf(img.getIdImagen());
                if (idImg.equals(id)) {
                    return index;
                }
            }
            index++;
            aux = aux.getSig();
        }

        return -1;
    }
    
    public Imagen buscarImagenEnLista(String id) {        
        NodoListDob<Imagen> aux = imagenes.getRaiz();
        while (aux != null) {
            Imagen img = aux.getInfo();
            if (img != null) {
                String idImg = String.valueOf(img.getIdImagen());
                if (idImg.equals(id)) {
                    return img;
                }
            }            
            aux = aux.getSig();
        }

        return null;
    }

    public void eliminarImagenListaDobl(String id) {
        int index = buscarIndexImagenEnLista(id);
        if (index >= 0) {
            this.imagenes.remove(index);
        }
    }

    public void insertarNuevaImg(String idUsuario, String entradaImg) {
        leerImagenes(entradaImg);
        Usuario usuarioIns = buscarUsuarioEnArbol(idUsuario);
        String idImagen = getIdImagenInsertar(entradaImg);
        if (idImagen.equals("") == false) {
            Imagen img = buscarImagen(idImagen);
            if (img != null) {
                usuarioIns.setNuevaImagen(img);
                JOptionPane.showMessageDialog(null, "Imagen ingresada");
            } else {
                //La imagen no existe
                JOptionPane.showMessageDialog(null, "La imagen no fue insertada");
            }
        }
    }

    private String getIdImagenInsertar(String entrada) {
        ListaEnlSim<Imagen> imagenesIns = new ListaEnlSim<>();
        StringReader reader = new StringReader(entrada);
        LexerImg lexico = new LexerImg(reader);
        ParserImg parser = new ParserImg(lexico);
        try {
            parser.parse();
            erroresComp = parser.getErroresCom();
            imagenesIns = parser.getTodasImagenes();
        } catch (Exception ex) {
            System.out.println("Error irrecuperable");
            System.out.println("Causa: " + ex.getCause());
            System.out.println("Causa2: " + ex.toString());
        }
        if (erroresComp.isEmpty()) {
            //No hay errores y puede insertar las imagenes
            if (imagenesIns.isEmpty() == false) {
                ///////////////////////////////////////////////
                ListaEnlSim ultimo = imagenesIns;
                while (ultimo != null) {
                    Object objErr = ultimo.getVal();
                    if (objErr != null) {
                        //Validar que no esten repeditos los id TODO                          
                        Imagen imgIns = (Imagen) ultimo.getVal();
                        return String.valueOf(imgIns.getIdImagen());
                    }
                    ultimo = ultimo.getSig();
                }
            } else {
                //No hay Imagenes que insertar
            }

        } else {
            //Hay errores mostrar errores en un JF
//            JFErrores jfErrores = new JFErrores(erroresComp);
//            jfErrores.setVisible(true);
        }
        return "";
    }
    
    public ListaEnlSim<Usuario> getTodosUsuarios(){
        ListaEnlSim<Usuario> usuarios = new ListaEnlSim<>();
        inOrden(usuarios,this.arbolUsuarios.getRaiz());
        return usuarios;
    }
    
    private void inOrden(ListaEnlSim<Usuario> usuarios,NodoAvl<Usuario> nodo){
        if (nodo == null) {
            return;
        }        
        inOrden(usuarios, nodo.getIzq());
        if (nodo.getInfo() != null) {
            usuarios.add(usuarios, nodo.getInfo());
        }        
        inOrden(usuarios, nodo.getDer());   
    }
    
    public void insertarUsuariosEnArbol(ListaEnlSim<Usuario> usuarios){
        this.arbolUsuarios = new ArbolAvl();
        ListaEnlSim ultimo = usuarios;
        while (ultimo != null) {
            Object objErr = ultimo.getVal();
            if (objErr != null) {                                         
                Usuario userIns = (Usuario) ultimo.getVal();               
                this.arbolUsuarios.insertar(userIns.getNombreUsuario(), userIns);
                this.contUsuarios++;
            }
            ultimo = ultimo.getSig();
        }
    }

    public ArbolAvl<Usuario> getArbolUsuarios() {
        return arbolUsuarios;
    }

    public ListaDobEnl<Imagen> getImagenes() {
        return imagenes;
    }

    public ArbolAvl<Capa> getArbolCapas() {
        return arbolCapas;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import estructuras.ListaEnlSim;

/**
 *
 * @author user-ubunto
 */
public class Usuario {
    private String nombreUsuario;
    private ListaEnlSim<String> idImagenesIns;
    private ListaEnlSim<Imagen> imagenes;        

    public Usuario() {
        this.idImagenesIns = new ListaEnlSim<>();
        this.imagenes = new ListaEnlSim<>();
    }
        
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public ListaEnlSim<String> getIdImagenesIns() {
        return idImagenesIns;
    }

    public void setIdImagenesIns(ListaEnlSim<String> idImagenesIns) {
        this.idImagenesIns = idImagenesIns;
    }
    
    public void insertarNuevoIdImagenIns(String idImagenIns){
        this.idImagenesIns.add(idImagenesIns, idImagenIns);
    }
    
    public void setNuevaImagen(Imagen img){
        this.imagenes.add(imagenes, img);
    }

    public ListaEnlSim<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ListaEnlSim<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
    
    
}

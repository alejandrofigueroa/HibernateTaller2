/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplo.hibernate.controller;

import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import ejemplo.hibernate.dao.UsuariosDao;
import ejemplo.hibernate.entidad.Usuarios;


/**
 *
 * @author elcon
 */
@ManagedBean
@ViewScoped
public class UsuarioController {

    /**
     * Creates a new instance of UsuariosControl
     */
    private List<Usuarios> listaUsuarioss;
    private Usuarios usuario;

    public UsuarioController() {
        usuario = new Usuarios();
    }

    public List<Usuarios> getListaUsuarioss() {
        UsuariosDao ad = new UsuariosDao();
        listaUsuarioss = ad.listarUsuarios();
        return listaUsuarioss;
    }

    public void setListaUsuarioss(List<Usuarios> listaUsuarioss) {
        this.listaUsuarioss = listaUsuarioss;
    }

    public Usuarios getUsuarios() {
        return usuario;
    }

    public void setUsuarios(Usuarios usuario) {
        this.usuario = usuario;
    }

    public void limpiarUsuarios() {
        usuario = new Usuarios();
    }

    public void agregarUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        ad.agregar(usuario);
    }

    public void modificarUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        ad.modificar(usuario);
        limpiarUsuarios();
    }

    public void eliminarUsuarios() {
        UsuariosDao ad = new UsuariosDao();
        ad.eliminar(usuario);
        limpiarUsuarios();
    }
}

package br.com.ifms.restauranteV1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.Usuario;

@ManagedBean(name = "userBean")
@SessionScoped
public class UsuarioController implements Serializable{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  Usuario user = new Usuario();

  GenericDAO<Usuario> userDAO;

  List<Usuario> list;

  long id;
  String msg;

  public UsuarioController() {
    user = new Usuario();
    msg = "";

  }
    
  public Usuario getUser() {
    return this.user;

  }

  public void setUser(Usuario p) {
    this.user = p;

  }

  public String getMsg() {
    return this.msg;

  }

  public void setMsg(String s) {
    this.msg = s;

  }

  public long getId() {
    return this.id;

  }

  public void setId(long id) {
    this.id = id;

  }


  public void salvar() {

    this.userDAO = new GenericDAO<>();
    userDAO.novo(this.user);
    this.msg = "Usuário cadastrado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }

  public void alterar() {

    this.userDAO = new GenericDAO<>();
    userDAO.alterar(this.user);
    this.msg = "Usuário alterado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletar() {

    this.userDAO = new GenericDAO<>();
    userDAO.deletar(this.user);
    this.msg = "Usuário deletado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletarPorID() {

    this.userDAO = new GenericDAO<>();
    userDAO.deletarPorId(Usuario.class, this.id); 

  }

  public List<Usuario> listarTodos() {

    this.userDAO = new GenericDAO<>();
    this.list = new ArrayList<>();
    this.list = userDAO.listarTodos(Usuario.class);
    return this.list;

  }
  
  public Usuario encontrarPorID() {

    this.userDAO = new GenericDAO<>();
    Usuario p1 = new Usuario();
    p1 = userDAO.encontrarPorID(Usuario.class, this.id);
    return p1;

  }
  
}
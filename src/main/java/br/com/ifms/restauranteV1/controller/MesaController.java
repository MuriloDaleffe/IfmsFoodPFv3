package br.com.ifms.restauranteV1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.Mesa;

@ManagedBean(name = "mesaBean")
@SessionScoped
public class MesaController {
    
  Mesa mesa = new Mesa();

  GenericDAO<Mesa> mesaDAO;

  List<Mesa> list;

  long id;
  String msg;

  public MesaController() {
    this.mesa = new Mesa();
    msg = "";

  }
    
  public Mesa getMesa() {
    return this.mesa;

  }

  public void setMesa(Mesa mesa) {
    this.mesa = mesa;

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

    this.mesaDAO = new GenericDAO<>();
    mesaDAO.novo(this.mesa);
    this.msg = "Mesa cadastrado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }

  public void alterar() {

    this.mesaDAO = new GenericDAO<>();
    mesaDAO.alterar(this.mesa);
    this.msg = "Mesa alterado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletar() {

    this.mesaDAO = new GenericDAO<>();
    mesaDAO.deletar(this.mesa);
    this.msg = "Mesa deletado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletarPorID() {

    this.mesaDAO = new GenericDAO<>();
    mesaDAO.deletarPorId(Mesa.class, this.id); 

  }

  public List<Mesa> listarTodos() {

    this.mesaDAO = new GenericDAO<>();
    this.list = new ArrayList<>();
    this.list = mesaDAO.listarTodos(Mesa.class);
    return this.list;

  }
  
  public Mesa encontrarPorID() {

    this.mesaDAO = new GenericDAO<>();
    Mesa m1 = new Mesa();
    m1 = mesaDAO.encontrarPorID(Mesa.class, this.id);
    return m1;

  }
    
}
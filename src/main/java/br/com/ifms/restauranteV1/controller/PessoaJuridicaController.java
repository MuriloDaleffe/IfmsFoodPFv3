package br.com.ifms.restauranteV1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.PessoaJuridica;

@ManagedBean(name = "pesJurBean")
@SessionScoped
public class PessoaJuridicaController implements Serializable{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  PessoaJuridica peJuridica = new PessoaJuridica();

  GenericDAO<PessoaJuridica> pjDAO;

  List<PessoaJuridica> list;

  long id;
  String msg;

  public PessoaJuridicaController() {
    peJuridica = new PessoaJuridica();
    msg = "";

  }
    
  public PessoaJuridica getPeJuridica() {
    return this.peJuridica;

  }

  public void setPeJuridica(PessoaJuridica p) {
    this.peJuridica = p;

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

    this.pjDAO = new GenericDAO<>();
    pjDAO.novo(this.peJuridica);
    this.msg = "Pessoa Jurídica cadastrada com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }

  public void alterar() {

    this.pjDAO = new GenericDAO<>();
    pjDAO.alterar(this.peJuridica);
    this.msg = "Pessoa Jurídica alterada com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletar() {

    this.pjDAO = new GenericDAO<>();
    pjDAO.deletar(this.peJuridica);
    this.msg = "Pessoa Jurídica deletada com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletarPorID() {

    this.pjDAO = new GenericDAO<>();
    pjDAO.deletarPorId(PessoaJuridica.class, this.id); 

  }

  public List<PessoaJuridica> listarTodos() {

    this.pjDAO = new GenericDAO<>();
    this.list = new ArrayList<>();
    this.list = pjDAO.listarTodos(PessoaJuridica.class);
    return this.list;

  }
  
  public PessoaJuridica encontrarPorID() {

    this.pjDAO = new GenericDAO<>();
    PessoaJuridica p1 = new PessoaJuridica();
    p1 = pjDAO.encontrarPorID(PessoaJuridica.class, this.id);
    return p1;

  }
  
}
package br.com.ifms.restauranteV1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.PessoaFisica;

@ManagedBean(name = "pesFisBean")
@SessionScoped
public class PessoaFisicaController implements Serializable{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  PessoaFisica peFisica = new PessoaFisica();

  GenericDAO<PessoaFisica> pfDAO;

  List<PessoaFisica> list;

  long id;
  String msg;

  public PessoaFisicaController() {
    peFisica = new PessoaFisica();
    msg = "";

  }
    
  public PessoaFisica getPeFisica() {
    return this.peFisica;

  }

  public void setPeFisica(PessoaFisica p) {
    this.peFisica = p;

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

    this.pfDAO = new GenericDAO<>();
    pfDAO.novo(this.peFisica);
    this.msg = "Pessoa Fisica cadastrada com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }

  public void alterar() {

    this.pfDAO = new GenericDAO<>();
    pfDAO.alterar(this.peFisica);
    this.msg = "Pessoa Fisica alterada com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletar() {

    this.pfDAO = new GenericDAO<>();
    pfDAO.deletar(this.peFisica);
    this.msg = "Pessoa Fisica deletada com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletarPorID() {

    this.pfDAO = new GenericDAO<>();
    pfDAO.deletarPorId(PessoaFisica.class, this.id); 

  }

  public List<PessoaFisica> listarTodos() {

    this.pfDAO = new GenericDAO<>();
    this.list = new ArrayList<>();
    this.list = pfDAO.listarTodos(PessoaFisica.class);
    return this.list;

  }
  
  public PessoaFisica encontrarPorID() {

    this.pfDAO = new GenericDAO<>();
    PessoaFisica p1 = new PessoaFisica();
    p1 = pfDAO.encontrarPorID(PessoaFisica.class, this.id);
    return p1;

  }
  
}
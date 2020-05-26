package br.com.ifms.restauranteV1.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.Produto;

@ManagedBean(name = "produtoBean")
@SessionScoped
public class ProdutoController implements Serializable{

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  Produto p = new Produto();

  GenericDAO<Produto> produtoDAO = new GenericDAO<>();

  List<Produto> list;

  long id;
  String msg;

  public ProdutoController() {
    p = new Produto();
    msg = "";

  }
    
  public Produto getP() {
    return this.p;

  }

  public void setP(Produto p) {
    this.p = p;

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
    System.out.println("id= "+id);
    this.id = id;
    System.out.println("id= "+this.id);
    this.p = encontrarPorID();
  }


  public String salvar() {

    this.produtoDAO = new GenericDAO<>();
    if(p != null){
      produtoDAO.novo(this.p);
      FacesContext.getCurrentInstance().addMessage("msg:ok", 
      new FacesMessage("Produto cadastrado com sucesso!"));
      return "/sucesso";
    } else {
      FacesContext.getCurrentInstance().addMessage("msg:erro", 
      new FacesMessage("Produto não cadastrado!"));
      return "/erro";
    }

  }

  public String alterar(Produto p) {

    this.produtoDAO = new GenericDAO<>();
    if(p != null){
      produtoDAO.alterar(p);
      FacesContext.getCurrentInstance().addMessage("msg:ok", 
      new FacesMessage("Produto alterado com sucesso!"));
      return "/sucesso";
    } else {
      FacesContext.getCurrentInstance().addMessage("msg:erro", 
      new FacesMessage("Produto não alterado!"));
      return "/erro";
    }

  }
  
  public String deletar(Produto p) {

    if(p != null){
      produtoDAO.deletar(p);
      FacesContext.getCurrentInstance().addMessage("msg:ok", 
      new FacesMessage("Produto deletado com sucesso!"));
      return "sucesso";
    } else {
      FacesContext.getCurrentInstance().addMessage("msg:erro", 
      new FacesMessage("Produto não deletado!"));
      return "erro";
    }

  }
  
  public void deletarPorID() {

    this.produtoDAO = new GenericDAO<>();
    produtoDAO.deletarPorId(Produto.class, this.id); 

  }

  public List<Produto> listarTodos() {

    this.produtoDAO = new GenericDAO<>();
    this.list = new ArrayList<>();
    this.list = produtoDAO.listarTodos(Produto.class);
    return this.list;

  }
  
  public Produto encontrarPorID() {

    System.out.println("___________________________________________________");
    System.out.println("id =="+this.id);

    this.produtoDAO = new GenericDAO<>();
    Produto p1 = new Produto();
    p1 = produtoDAO.encontrarPorID(Produto.class, id);
    return p1;

  }

  // public void cadProd() {

  //   Map<String,Object> options = new HashMap<String, Object>();
  //   options.put("modal", true);
  //   options.put("width", 640);
  //   options.put("height", 340);
  //   options.put("contentWidth", "100%");
  //   options.put("contentHeight", "100%");
  //   options.put("headerElement", "customheader");
  //   PrimeFaces.current().dialog().openDynamic("sucesso.xhtml", options, null);
  //   System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
  //   //return "/cadastro/cadastroProduto";
  // }

  // public String cadastrar() {
  //   System.out.println("111111111111111111111111111");
  //   return "/cadastro/cadastroProduto";
  // }
  
}
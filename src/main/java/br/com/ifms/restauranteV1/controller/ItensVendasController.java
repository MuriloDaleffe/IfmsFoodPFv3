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
import org.primefaces.event.SelectEvent;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.ItemsVendas;
import br.com.ifms.restauranteV1.model.Produto;

@ManagedBean(name = "itensVendasBean")
@SessionScoped
public class ItensVendasController implements Serializable {
    
  ItemsVendas itens; 

  GenericDAO<ItemsVendas> itensDAO;

  List<ItemsVendas> list;

  long id;
  String msg;

  public ItensVendasController() {
    this.itens = new ItemsVendas();
    msg = "";

  }
    
  public ItemsVendas getItens() {
    return this.itens;

  }

  public void setItens(ItemsVendas itens) {
    this.itens = itens;

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

    this.itensDAO = new GenericDAO<>();
    itensDAO.novo(this.itens);
    this.msg = "Item cadastrado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }

  public void alterar() {

    this.itensDAO = new GenericDAO<>();
    itensDAO.alterar(this.itens);
    this.msg = "Item alterado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletar() {

    this.itensDAO = new GenericDAO<>();
    itensDAO.deletar(this.itens);
    this.msg = "Item deletado com sucesso!";
    System.out.println(getMsg());
    this.msg = "";

  }
  
  public void deletarPorID() {

    this.itensDAO = new GenericDAO<>();
    itensDAO.deletarPorId(ItemsVendas.class, this.id); 

  }

  public List<ItemsVendas> listarTodos() {

    this.itensDAO = new GenericDAO<>();
    this.list = new ArrayList<>();
    this.list = itensDAO.listarTodos(ItemsVendas.class);
    return this.list;

  }

  public void escolherItem() {
    Map<String,Object> options = new HashMap<String, Object>();
    options.put("resizable", false);
    options.put("draggable", false);
    options.put("modal", true);
    PrimeFaces.current().dialog().openDynamic("listarProduto2", options, null);
  }

  public void aoEscolherItem(SelectEvent event) {
    Produto produto = (Produto) event.getObject();
    FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto selecionado", "Id:" + produto.getId());
     
    FacesContext.getCurrentInstance().addMessage(null, message);
  }
    
}
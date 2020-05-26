package br.com.ifms.restauranteV1.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ifms.restauranteV1.model.Login;


@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginController implements Serializable {

  Login user;

  public Login getUser() {
    return this.user;
  }

  public void setUser(Login user) {
    this.user = user;
  }

  public LoginController() {
    user = new Login();

  }
    
  public String loginUser() {
    if(this.user.getLogin().equals("murilodl") && this.user.getPwd().equals("qwert")) {
      System.out.println("2222222222222222222222222222");
      return "/listar/listarProduto";
    }else {
      System.out.println("3333333333333333333333333333");
      return "index";
    }
  }
    
}
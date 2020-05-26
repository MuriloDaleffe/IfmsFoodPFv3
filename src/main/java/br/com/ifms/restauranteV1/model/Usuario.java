package br.com.ifms.restauranteV1.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Usuario extends Pessoa implements Serializable {

  private String login;
  private String pwd;


  /**
   * @return String return the login
   */
  public String getLogin() {
      return login;
  }

  /**
   * @param login the login to set
   */
  public void setLogin(String login) {
      this.login = login;
  }

  /**
   * @return String return the pwd
   */
  public String getPwd() {
      return pwd;
  }

  /**
   * @param pwd the pwd to set
   */
  public void setPwd(String pwd) {
      this.pwd = pwd;
  }

}

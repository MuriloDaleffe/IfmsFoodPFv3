package br.com.ifms.restauranteV1.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Cliente implements Serializable {

  private int cpf;
  private String rg;


  /**
   * @return int return the cpf
   */
  public int getCpf() {
      return cpf;
  }

  /**
   * @param cpf the cpf to set
   */
  public void setCpf(int cpf) {
      this.cpf = cpf;
  }

  /**
   * @return String return the rg
   */
  public String getRg() {
      return rg;
  }

  /**
   * @param rg the rg to set
   */
  public void setRg(String rg) {
      this.rg = rg;
  }

}

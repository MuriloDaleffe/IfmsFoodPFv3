package br.com.ifms.restauranteV1.model;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class PessoaJuridica extends Cliente implements Serializable {

  private int cnpj;
  private String razSoc;


  /**
   * @return int return the cnpj
   */
  public int getCnpj() {
      return cnpj;
  }

  /**
   * @param cnpj the cnpj to set
   */
  public void setCnpj(int cnpj) {
      this.cnpj = cnpj;
  }

  /**
   * @return String return the razSoc
   */
  public String getRazSoc() {
      return razSoc;
  }

  /**
   * @param razSoc the razSoc to set
   */
  public void setRazSoc(String razSoc) {
      this.razSoc = razSoc;
  }

}

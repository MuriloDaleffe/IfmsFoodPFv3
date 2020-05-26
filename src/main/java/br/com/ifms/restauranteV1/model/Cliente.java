package br.com.ifms.restauranteV1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Cliente extends Pessoa {

  private LocalDate dtCadastro;

  /**
   * @return LocalDate return the dtCadastro
   */
  public LocalDate getDtCadastro() {
      return dtCadastro;
  }

  /**
   * @param dtCadastro the dtCadastro to set
   */
  public void setDtCadastro(LocalDate dtCadastro) {
      this.dtCadastro = dtCadastro;
  }

}

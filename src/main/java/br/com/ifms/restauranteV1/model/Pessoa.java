package br.com.ifms.restauranteV1.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nome;
  private String endereco;
  private String email;
  private String fone;
  private LocalDate dataNasc;



  /**
   * @return Long return the id
   */
  public Long getId() {
      return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return String return the nome
   */
  public String getNome() {
    return nome;
  }

  /**
   * @param nome the nome to set
   */
  public void setNome(final String nome) {
    this.nome = nome;
  }

  /**
   * @return String return the endereco
   */
  public String getEndereco() {
    return endereco;
  }

  /**
   * @param endereco the endereco to set
   */
  public void setEndereco(final String endereco) {
    this.endereco = endereco;
  }

  /**
   * @return String return the email
   */
  public String getEmail() {
    return email;
  }

  /**
   * @param email the email to set
   */
  public void setEmail(final String email) {
    this.email = email;
  }

  /**
   * @return String return the fone
   */
  public String getFone() {
    return fone;
  }

  /**
   * @param fone the fone to set
   */
  public void setFone(final String fone) {
    this.fone = fone;
  }

  /**
   * @return LocalDate return the dataNasc
   */
  public LocalDate getDataNasc() {
    return dataNasc;
  }

  /**
   * @param dataNasc the dataNasc to set
   */
  public void setDataNasc(final LocalDate dataNasc) {
      this.dataNasc = dataNasc;
  }

}

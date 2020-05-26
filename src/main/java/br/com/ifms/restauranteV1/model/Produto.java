package br.com.ifms.restauranteV1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String descricao;
  private int estoqueMin;
  private int estoqueMax;
  private double valor;


  /**
   * @return Long return the id
   */
  public Long getId() {
      return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(Long id) {
      this.id = id;
  }

  /**
   * @return String return the descricao
   */
  public String getDescricao() {
      return descricao;
  }

  /**
   * @param descricao the descricao to set
   */
  public void setDescricao(String descricao) {
      this.descricao = descricao;
  }

  /**
   * @return int return the estoqueMin
   */
  public int getEstoqueMin() {
      return estoqueMin;
  }

  /**
   * @param estoqueMin the estoqueMin to set
   */
  public void setEstoqueMin(int estoqueMin) {
      this.estoqueMin = estoqueMin;
  }

  /**
   * @return int return the estoqueMax
   */
  public int getEstoqueMax() {
      return estoqueMax;
  }

  /**
   * @param estoqueMax the estoqueMax to set
   */
  public void setEstoqueMax(int estoqueMax) {
      this.estoqueMax = estoqueMax;
  }

  /**
   * @return double return the valor
   */
  public double getValor() {
      return valor;
  }

  /**
   * @param valor the valor to set
   */
  public void setValor(double valor) {
      this.valor = valor;
  }

}

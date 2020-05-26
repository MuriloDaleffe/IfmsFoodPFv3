package br.com.ifms.restauranteV1.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ItemsVendas implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int qtd;

  private boolean status = true;

  @ManyToOne
  private Cliente cliente;

  @ManyToOne
  private Mesa mesa;

  @ManyToOne
  private Produto produtos;


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
   * @return int return the qtd
   */
  public int getQtd() {
      return qtd;
  }

  /**
   * @param qtd the qtd to set
   */
  public void setQtd(int qtd) {
      this.qtd = qtd;
  }

  /**
   * @return ProdutosModel return the produtos
   */
  public Produto getProdutos() {
      return produtos;
  }

  /**
   * @param produtos the produtos to set
   */
  public void setProdutos(Produto produtos) {
      this.produtos = produtos;
  }

    /**
     * @return Cliente return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return Mesa return the mesa
     */
    public Mesa getMesa() {
        return mesa;
    }

    /**
     * @param mesa the mesa to set
     */
    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }


    /**
     * @return boolean return the status
     */
    public boolean isStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

}

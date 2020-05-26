package br.com.ifms.restauranteV1.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Venda implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate data;
  private LocalTime time;
  private float totalVenda;
  

//   @OneToOne
//   private Cliente cliente;
  
  @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
  private List<ItemsVendas> itensVenda;


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
   * @return LocalDate return the data
   */
  public LocalDate getData() {
      return data;
  }

  /**
   * @param data the data to set
   */
  public void setData(LocalDate data) {
      this.data = data;
  }

  /**
   * @return float return the totalVenda
   */
  public float getTotalVenda() {
      return totalVenda;
  }

  /**
   * @param totalVenda the totalVenda to set
   */
  public void setTotalVenda(float totalVenda) {
      this.totalVenda = totalVenda;
  }

//   /**
//    * @return ClienteModel return the cliente
//    */
//   public Cliente getCliente() {
//       return cliente;
//   }

//   /**
//    * @param cliente the cliente to set
//    */
//   public void setCliente(Cliente cliente) {
//       this.cliente = cliente;
//   }

  /**
   * @return ArrayList<ProdutosModel> return the itensVenda
   */
  public List<ItemsVendas> getItensVenda() {
      return itensVenda;
  }

  /**
   * @param itensVenda the itensVenda to set
   */
  public void setItensVenda(List<ItemsVendas> itensVenda) {
      this.itensVenda = itensVenda;
  }


    /**
     * @return LocalTime return the time
     */
    public LocalTime getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public float fechaConta(List<ItemsVendas> itensVenda) {

        float total = 0;
        for( ItemsVendas item : itensVenda ) {
            total += item.getQtd()*item.getProdutos().getValor();
        }

        return total;
    }

}

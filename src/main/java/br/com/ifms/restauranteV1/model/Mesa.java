package br.com.ifms.restauranteV1.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Mesa implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private int num;
  private boolean status = false;

//   @OneToMany
//   private List<Venda> vendas;


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
   * @return int return the num
   */
  public int getNum() {
      return num;
  }

  /**
   * @param num the num to set
   */
  public void setNum(int num) {
      this.num = num;
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

    // /**
    //  * @return List<Venda> return the vendas
    //  */
    // public List<Venda> getVendas() {
    //     return vendas;
    // }

    // /**
    //  * @param vendas the vendas to set
    //  */
    // public void setVendas(List<Venda> vendas) {
    //     this.vendas = vendas;
    // }

}

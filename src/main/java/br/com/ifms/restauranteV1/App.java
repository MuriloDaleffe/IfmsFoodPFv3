package br.com.ifms.restauranteV1;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.ifms.restauranteV1.jpautil.GenericDAO;
import br.com.ifms.restauranteV1.model.ItemsVendas;
import br.com.ifms.restauranteV1.model.Mesa;
import br.com.ifms.restauranteV1.model.PessoaFisica;
import br.com.ifms.restauranteV1.model.PessoaJuridica;
import br.com.ifms.restauranteV1.model.Produto;
import br.com.ifms.restauranteV1.model.Usuario;
import br.com.ifms.restauranteV1.model.Venda;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sys_restaurante");
        EntityManager manager = factory.createEntityManager();

        //preencher();

        //listAlt();

        //testar();
    }

    public static void preencher() {

        boolean status = false;
        Mesa m = new Mesa();
        m.setNum(1);
        m.setStatus(status);

        status = true;
        m.setStatus(status);

        Produto p1 = new Produto();
        p1.setDescricao("Hamburguer 1");
        p1.setEstoqueMin(50);
        p1.setEstoqueMax(150);
        p1.setValor(15.5);

        Produto p2 = new Produto();
        p2.setDescricao("Cerveja 1");
        p2.setEstoqueMin(100);
        p2.setEstoqueMax(250);
        p2.setValor(10.5);

        Produto p3 = new Produto();
        p3.setDescricao("Hamburguer 2");
        p3.setEstoqueMin(10);
        p3.setEstoqueMax(50);
        p3.setValor(25.5);

        Produto p4 = new Produto();
        p4.setDescricao("Cerveja 2");
        p4.setEstoqueMin(10);
        p4.setEstoqueMax(25);
        p4.setValor(20.5);

        PessoaFisica pf = new PessoaFisica();
        pf.setCpf(123456789);
        pf.setDataNasc(LocalDate.of(1991, 9, 17));
        pf.setDtCadastro(LocalDate.now());
        pf.setEmail("murilodl@gmail.com");
        pf.setEndereco("Rua: A, Numero: 1234, Bairro: Bairro 1");
        pf.setFone("6735211234");
        pf.setNome("Murilo Daleffe");
        pf.setRg("987654321");

        PessoaJuridica pj = new PessoaJuridica();
        pj.setCnpj(1234567896);
        pj.setDataNasc(LocalDate.of(1986, 10, 7));
        pj.setDtCadastro(LocalDate.now());
        pj.setEmail("fibria@fibria.com");
        pj.setEndereco("Bloco: 109, Numero: 567, Bairro: Bairro Industrial");
        pj.setFone("6732094567");
        pj.setNome("Fibria");
        pj.setRazSoc("Fibria Papel e Celulose");

        Usuario us = new Usuario();
        us.setDataNasc(LocalDate.of(1986, 8, 7));
        us.setEmail("joaoalmeida@gmail.com");
        us.setEndereco("Rua: b, Numero: 1234, Bairro: Bairro 2");
        us.setFone("6735214567");
        us.setNome("Joao Almeida");
        us.setLogin("JoaoAlmeida");
        us.setPwd("qwert");

        ItemsVendas iv1 = new ItemsVendas();
        iv1.setProdutos(p1);
        iv1.setCliente(pf);
        iv1.setMesa(m);
        iv1.setQtd(4);

        ItemsVendas iv2 = new ItemsVendas();
        iv2.setProdutos(p2);
        iv2.setCliente(pf);
        iv2.setQtd(3);
        iv2.setMesa(m);

        ItemsVendas iv3 = new ItemsVendas();
        iv3.setProdutos(p3);
        iv3.setCliente(pf);
        iv3.setQtd(2);
        iv3.setMesa(m);

        ItemsVendas iv4 = new ItemsVendas();
        iv4.setProdutos(p4);
        iv4.setCliente(pf);
        iv4.setQtd(1);
        iv4.setMesa(m);

        List<ItemsVendas> itensVenda = new ArrayList<>();

        itensVenda.add(iv1);
        itensVenda.add(iv2);
        itensVenda.add(iv3);
        itensVenda.add(iv4);
        

        Venda venda = new Venda();
        //venda.setCliente(pf);
        venda.setData(LocalDate.now());
        venda.setItensVenda(itensVenda);
        venda.setTime(LocalTime.now());
        venda.setTotalVenda(venda.fechaConta(itensVenda));


        GenericDAO<Mesa> mesaDAO = new GenericDAO<>();
        mesaDAO.novo(m);

        GenericDAO<Produto> produtoDAO = new GenericDAO<>();
        produtoDAO.novo(p1);
        produtoDAO.novo(p2);
        produtoDAO.novo(p3);
        produtoDAO.novo(p4);

        // GenericDAO<Produto> produtoDAO2 = new GenericDAO<>();
        // produtoDAO2.novo(p2);

        // GenericDAO<Produto> produtoDAO3 = new GenericDAO<>();
        // produtoDAO3.novo(p3);

        // GenericDAO<Produto> produtoDAO4 = new GenericDAO<>();
        // produtoDAO4.novo(p4);

        GenericDAO<PessoaFisica> pfDAO = new GenericDAO<>();
        pfDAO.novo(pf);

        GenericDAO<PessoaJuridica> pjDAO = new GenericDAO<>();
        pjDAO.novo(pj);

        GenericDAO<Usuario> usuarioDAO = new GenericDAO<>();
        usuarioDAO.novo(us);

        GenericDAO<ItemsVendas> ivDAO = new GenericDAO<>();
        ivDAO.novo(iv1);
        ivDAO.novo(iv2);
        ivDAO.novo(iv3);
        ivDAO.novo(iv4);

        // GenericDAO<ItemsVendas> ivDAO2 = new GenericDAO<>();
        // ivDAO2.novo(iv2);

        // GenericDAO<ItemsVendas> ivDAO3 = new GenericDAO<>();
        // ivDAO3.novo(iv3);

        // GenericDAO<ItemsVendas> ivDAO4 = new GenericDAO<>();
        // ivDAO4.novo(iv4);

        GenericDAO<Venda> vendaDAO = new GenericDAO<>();
        vendaDAO.novo(venda);

    }

    public static void listAlt() {

        // GenericDAO<Produto> prdDao = new GenericDAO<>();
        // List<Produto> listaProduto = prdDao.listarTodos(Produto.class);

        // for (Produto produto : listaProduto) {
        //     if(produto.getId() == 1) {
        //         produto.setDescricao("Hamburguer");
        //         GenericDAO<Produto> prdDao1 = new GenericDAO<>();
        //         prdDao1.alterar(produto);

        //     }else if(produto.getId() == 2) {
        //         produto.setDescricao("Cerveja");
        //         GenericDAO<Produto> prdDao1 = new GenericDAO<>();
        //         prdDao1.alterar(produto);
        //     }
        // }

        GenericDAO<Produto> prd = new GenericDAO<>();
        List<Produto> listaProduto2 = prd.listarTodos(Produto.class);


        for (Produto produto : listaProduto2) {
            produto.setDescricao(produto.getDescricao().toString() + " 1");

        }

        GenericDAO<Produto> prd1 = new GenericDAO<>();
        prd1.alterar(listaProduto2.remove(0));
        GenericDAO<Produto> prd2 = new GenericDAO<>();
        prd2.alterar(listaProduto2.remove(0));


        GenericDAO<Venda> vendaDAO = new GenericDAO<>();
        List<Venda> listaVenda = vendaDAO.listarTodos(Venda.class);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(listaVenda.isEmpty());
        System.out.println(listaVenda.size());
        for (Venda venda : listaVenda) {
            //System.out.println("Cliente: " + venda.getCliente().getNome());
            for (ItemsVendas item : venda.getItensVenda()) {
                System.out.println("Item consumido: " + item.getProdutos().getDescricao());
                System.out.println("Valor: " + item.getProdutos().getValor());
                System.out.println("Qtdade: " + item.getQtd());
            }
        }
    }

    public static void testar() {

        Produto tequila = new Produto();
        tequila.setDescricao("Tequila");
        tequila.setEstoqueMax(10);
        tequila.setEstoqueMin(2);
        tequila.setValor(70);

        GenericDAO<Produto> prDao1 = new GenericDAO<>();
        prDao1.novo(tequila);

        GenericDAO<Produto> prdDao = new GenericDAO<>();
        List<Produto> listaProduto = prdDao.listarTodos(Produto.class);

        Long id = listaProduto.get(2).getId();
        System.out.println(id);
        System.out.println(listaProduto.size());

        for (Produto produto : listaProduto) {
            System.out.println(produto.getDescricao());
        }
        System.out.println();
        System.out.println();

        GenericDAO<Produto> prdDao2 = new GenericDAO<>();
        prdDao2.deletarPorId(Produto.class, id);

        GenericDAO<Produto> prdDao3 = new GenericDAO<>();
        List<Produto> listaProduto2 = prdDao3.listarTodos(Produto.class);

        for (Produto produto : listaProduto2) {
            System.out.println(produto.getDescricao());
        }
    }
}

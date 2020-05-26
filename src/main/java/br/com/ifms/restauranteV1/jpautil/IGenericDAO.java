package br.com.ifms.restauranteV1.jpautil;

import java.util.List;

public interface IGenericDAO<E> {

    public void novo(E entidade);

    public void alterar(E entidade);

    public void deletar(E entidade);

    public List<E> listarTodos(Class<E> entidade);

    public E encontrarPorID(Class<E> entidade, Long id);

    public void deletarPorId(Class<E> entidade, long id);
}

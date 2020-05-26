package br.com.ifms.restauranteV1.jpautil;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDAO<E> implements IGenericDAO<E>, Serializable {

    EntityManager em;

    public GenericDAO() {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("sys_restaurante");
        em = factory.createEntityManager();

    }

    @Override
    public void novo(final E entidade) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.persist(entidade);
        et.commit();
        //em.close();
    }

    @Override
    public void alterar(final E entidade) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(entidade);
        et.commit();
        //em.close();

    }

    @Override
    public void deletar(final E entidade) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(entidade);
        et.commit();
        //em.close();

    }

    @Override
    public List<E> listarTodos(Class<E> entidade) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        List<E> retorno = em.createQuery("from " + entidade.getName()).getResultList();
        et.commit();
        //em.close();
        return retorno;
    }

    @Override
    public E encontrarPorID(Class<E> entidade, Long id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        E retorno = em.find(entidade, id);
        return retorno;
    }

    @Override
    public void deletarPorId(Class<E> entidade, long id) {
        EntityTransaction et = em.getTransaction();
        et.begin();
        E obj = em.find(entidade, id);
        em.remove(obj);
        et.commit();
        em.close();
    }

}

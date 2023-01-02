package br.edu.ifg.luziania.tiii.model.dao.impl;

import br.edu.ifg.luziania.tiii.model.entity.Marca;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Dependent
public class MarcaDAO {

    @Inject
    EntityManager entityManager;

    public void save(Object entity) {
        entityManager.persist(entity);
    }

    public <T> T getById(Integer id){
        return (T) entityManager.find(Marca.class, id);
    }

    public <T> List<T> searchByNome(String nome){
        //language=HQL
        String jpql = "from Marca where nome like :param";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("param", "%"+nome+"%");
        return (List<T>) query.getResultList();
    }

    public Marca getByNome(String nome){
        //language=HQL
        String jpql = "from Marca where nome = :param";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("param", nome);
        return (Marca) query.getSingleResult();
    }
}

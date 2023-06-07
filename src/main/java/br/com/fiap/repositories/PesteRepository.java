package br.com.fiap.repositories;

import br.com.fiap.PestDetect.Peste;
import jakarta.persistence.*;

import java.util.List;

public class PesteRepository {
    private EntityManager entityManager;

    public PesteRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Peste> findAll() {
        String jpql = "SELECT p FROM Peste p";
        Query query = entityManager.createQuery(jpql, Peste.class);
        return query.getResultList();
    }

    public List<Peste> findByNomePopular(String nomePopular){
        String jpql = "SELECT p FROM Peste p WHERE p.nomePopular LIKE :nomePopular";
        Query query = entityManager.createQuery(jpql, Peste.class);
        query.setParameter("nomePopular", "%" + nomePopular + "%");
        return query.getResultList();
    }

    public List<Peste> findByNomeCientifico(String nomeCientifico){
        String jpql = "SELECT p FROM Peste p WHERE p.nomeCientifico LIKE :nomeCientifico";
        Query query = entityManager.createQuery(jpql, Peste.class);
        query.setParameter("nomeCientifico", "%" + nomeCientifico + "%");
        return query.getResultList();
    }

    public List<Peste> findByTipo(String tipo) {
        String jpql = "SELECT p FROM Peste p INNER JOIN Tipo t WHERE t.tipo = :tipo";
        Query query = entityManager.createQuery(jpql, Peste.class);
        query.setParameter("tipo", tipo);
        return query.getResultList();
    }

    public void deleteById(int id){
        entityManager.getTransaction().begin();

        try{
            Peste peste = entityManager.find(Peste.class, id);
            if(peste != null){
                entityManager.remove(peste);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}

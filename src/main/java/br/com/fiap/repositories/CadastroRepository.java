package br.com.fiap.repositories;

import br.com.fiap.PestDetect.Cadastro;
import jakarta.persistence.*;

import java.util.List;
public class CadastroRepository {
    private EntityManager entityManager;

    public CadastroRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Cadastro> findAll(){
        String jpql = "SELECT c FROM Cadastro c";
        Query query = entityManager.createQuery(jpql, Cadastro.class);
        return query.getResultList();
    }

    public Cadastro findById(int id){
        Cadastro cadastro = entityManager.find(Cadastro.class, id);
        if(cadastro == null){
            throw new EntityNotFoundException("Cadastro não encontrado");
        }
        return cadastro;
    }

    public List<Cadastro> findByEmail(String email){
        String jpql = "SELECT c FROM Cadastro c WHERE c.login.email LIKE :email";
        Query query = entityManager.createQuery(jpql, Cadastro.class);
        query.setParameter("email", "%" + email + "%");
        return  query.getResultList();
    }

    public void deleteById(int id){
        entityManager.getTransaction().begin();

        try {
            Cadastro cadastro = entityManager.find(Cadastro.class, id);
            if(cadastro != null){
                entityManager.remove(cadastro);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e){
            entityManager.getTransaction().rollback();
            throw e;
        }
    }
}

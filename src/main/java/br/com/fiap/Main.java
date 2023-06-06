package br.com.fiap;

import br.com.fiap.repositories.CadastroRepository;
import br.com.fiap.repositories.PesteRepository;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        var pesteRepository = new PesteRepository(entityManager);
        var cadastroRepository = new CadastroRepository(entityManager);

        pesteRepository.findAll();
        cadastroRepository.findByEmail("mateus@fiap.com.br");


        entityManager.close();
        entityManagerFactory.close();
    }
}
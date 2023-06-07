package br.com.fiap;

import br.com.fiap.repositories.*;
import jakarta.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        var pesteRepository = new PesteRepository(entityManager);
        var cadastroRepository = new CadastroRepository(entityManager);

        pesteRepository.findByNomePopular("Pulgão");
        pesteRepository.findByNomeCientifico("Spodoptera frugiperda");
        cadastroRepository.findById(1);
        cadastroRepository.findByEmail("mateus@fiap.com.br");


        entityManager.close();
        entityManagerFactory.close();
    }
}
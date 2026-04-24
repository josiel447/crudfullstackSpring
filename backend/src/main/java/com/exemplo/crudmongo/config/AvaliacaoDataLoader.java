package com.exemplo.crudmongo.config;

import com.exemplo.crudmongo.Model.Avaliacao;
import com.exemplo.crudmongo.repository.AvaliacaoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.github.javafaker.Faker;


import java.util.Locale;
@Configuration
public class AvaliacaoDataLoader {

    @Bean
    CommandLineRunner loadDatabase(AvaliacaoRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Faker faker = new Faker(new Locale("pt-BR"));
                for (int i = 0; i < 200; i++) {
                    Avaliacao avaliacao = new Avaliacao();

                    avaliacao.setPessoaId(faker.number().randomNumber());// Gera um ID aleatório para pessoa
                    avaliacao.setDisciplinaId((long)(faker.number().numberBetween(20, 200)));
                    avaliacao.setNota(faker.number().randomDouble(1, 0, 10)); // Gera nota de 0.0 a 10.0
                    avaliacao.setData("2026-04-23"); // Ou use o faker para gerar datas
                    repository.save(avaliacao);
                }

                System.out.println("✅ Banco de avaliações populado com 200 registros!");
            } else {
                System.out.println("ℹ️ Banco de avaliações já contém dados, não foi necessário repopular.");
            }
        };
    }



    
}

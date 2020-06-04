package br.com.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.test.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    
    Pessoa findByEmail(String email);

}
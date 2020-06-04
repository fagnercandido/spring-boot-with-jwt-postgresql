package br.com.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.test.models.Pessoa;
import br.com.test.repositories.PessoaRepository;

@RestController
@RequestMapping("/auth")
public class PessoaController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping(path = "/register", consumes = "application/json")
    public void register(@RequestBody Pessoa pessoa) {
        pessoa.setPassword(bCryptPasswordEncoder.encode(pessoa.getPassword()));
        pessoaRepository.save(pessoa);
    }


}
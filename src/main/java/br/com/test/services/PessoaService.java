package br.com.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.test.models.Pessoa;
import br.com.test.repositories.PessoaRepository;

import org.springframework.security.core.userdetails.User;
import static java.util.Collections.emptyList;

@Service
public class PessoaService implements UserDetailsService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Pessoa pessoa = pessoaRepository.findByEmail(email);
        if (pessoa == null) {
            throw new UsernameNotFoundException(email);
        }
        return new User(pessoa.getEmail(), pessoa.getPassword(), emptyList());
    }

}
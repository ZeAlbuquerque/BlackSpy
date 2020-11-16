package br.com.fiap.BlackSpy.service;

import br.com.fiap.BlackSpy.domain.Usuario;
import br.com.fiap.BlackSpy.repository.UsuarioRepository;
import br.com.fiap.BlackSpy.service.exeption.RegraNegocioException;
import br.com.fiap.BlackSpy.service.exeption.SenhaInvalidaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private UsuarioRepository repository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        try {
            return repository.save(usuario);
        }
        catch (Exception e){
            throw new RegraNegocioException("Usuário já cadastrado");
        }
    }

    public UserDetails autenticar (Usuario user){
        UserDetails usuario = loadUserByUsername(user.getLogin());
        boolean senhasBatem = encoder.matches(user.getSenha(), usuario.getPassword());
        if(senhasBatem){
            return usuario;
        }
        throw new SenhaInvalidaException();
    }

    @Override
    public UserDetails loadUserByUsername(String username ) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado na base de dados"));

        String[] roles = new String[]{"USER"};

        return User
                .builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(roles)
                .build();

    }

}

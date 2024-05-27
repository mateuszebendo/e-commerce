package org.br.serratec.ecommerce.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.br.serratec.ecommerce.entities.Role;
import org.br.serratec.ecommerce.entities.User;
import org.br.serratec.ecommerce.entities.UserDetailsImpl;
import org.br.serratec.ecommerce.enums.RoleEnum;
import org.br.serratec.ecommerce.records.CredenciaisLoginRecord;
import org.br.serratec.ecommerce.records.JwtTokenRecord;
import org.br.serratec.ecommerce.records.UserRecord;
import org.br.serratec.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder encoder;

    // Método responsável por autenticar um usuário e retornar um token JWT
    public JwtTokenRecord authenticateUser(CredenciaisLoginRecord credenciaisLoginRecord) {
        // Cria um objeto de autenticação com o email e a senha do usuário
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(credenciaisLoginRecord.login(), credenciaisLoginRecord.password());

        // Autentica o usuário com as credenciais fornecidas
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        // Obtém o objeto UserDetails do usuário autenticado
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        // Gera um token JWT para o usuário autenticado
        return new JwtTokenRecord(jwtTokenService.generateToken(userDetails));
    }

    public User createUser(UserRecord userRecord) {

        Set<String> strRoles = userRecord.role();
        List<Role> roles = new ArrayList<>();

        for(String strRole : strRoles) {
            Role role = new Role(RoleEnum.valueOf(strRole));
            roles.add(role);
        }

        User newUser = new User(userRecord.login(),
                encoder.encode(userRecord.password()),
                roles
        );

        // Salva o novo usuário no banco de dados
        return userRepository.save(newUser);
    }
}
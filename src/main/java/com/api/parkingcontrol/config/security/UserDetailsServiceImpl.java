package com.api.parkingcontrol.config.security;

import com.api.parkingcontrol.model.UserModel;
import com.api.parkingcontrol.repository.IUserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional /* Quando buscarmos os dados no banco de dados, durante a transição (troca de informações)
ele vai conceder acesso a essas coleções de roles que precisamos
(Nível de classe) — serve para classe e suas subclasses
*/
public class UserDetailsServiceImpl implements UserDetailsService {

    final IUserRepository iUserRepository;

    public UserDetailsServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }


    @Override //Carregar usuário por nome de usuário
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = iUserRepository.findByUserName(username) //Query method
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
        //User - do tipo user details onde preenchemos oque o construtor já espera
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true, true, userModel.getAuthorities());
    }

}

package javabuoi3.minhlong.serrvices;

import javabuoi3.minhlong.entity.CustomUserDetail;
import javabuoi3.minhlong.entity.User;
import javabuoi3.minhlong.respository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = userRepository.findByUsername(username);
        if (user == null)
            throw new UsernameNotFoundException("User bot found");
        return new CustomUserDetail(user, userRepository);
    }
}

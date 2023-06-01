package javabuoi3.minhlong.serrvices;

import javabuoi3.minhlong.entity.User;
import javabuoi3.minhlong.respository.IuserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IuserRepository userRepository;
    public  void  save(User user) {
        userRepository.save(user);
    }
}

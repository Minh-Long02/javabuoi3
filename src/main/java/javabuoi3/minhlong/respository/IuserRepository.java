package javabuoi3.minhlong.respository;

import javabuoi3.minhlong.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IuserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u From User u WHERE u.username =?1")
    User findByUsername(String username);
}

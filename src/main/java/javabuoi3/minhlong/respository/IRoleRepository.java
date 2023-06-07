package javabuoi3.minhlong.respository;

import javabuoi3.minhlong.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query("Select r.id FROM Role r WHERE r.name = ?1")
    Long getRoleIdByName(String roleName);
}

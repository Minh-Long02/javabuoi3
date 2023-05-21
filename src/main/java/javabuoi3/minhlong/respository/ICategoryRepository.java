package javabuoi3.minhlong.respository;

import javabuoi3.minhlong.entity.Categogy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Categogy, Long> {
}

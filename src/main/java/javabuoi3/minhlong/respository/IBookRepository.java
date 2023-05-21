package javabuoi3.minhlong.respository;

import javabuoi3.minhlong.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository  extends JpaRepository<Book, Long> {
}

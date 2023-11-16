package Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}

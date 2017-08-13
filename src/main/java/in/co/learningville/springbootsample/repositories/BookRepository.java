package in.co.learningville.springbootsample.repositories;

import in.co.learningville.springbootsample.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pra_pri on 13-Aug-17.
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}

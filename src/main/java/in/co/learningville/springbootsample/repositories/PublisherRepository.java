package in.co.learningville.springbootsample.repositories;

import in.co.learningville.springbootsample.model.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pra_pri on 13-Aug-17.
 */
public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}

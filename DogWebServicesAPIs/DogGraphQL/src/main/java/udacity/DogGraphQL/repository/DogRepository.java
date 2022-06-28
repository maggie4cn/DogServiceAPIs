package udacity.DogGraphQL.repository;

import org.springframework.data.repository.CrudRepository;
import udacity.DogGraphQL.entity.Dog;

public interface DogRepository extends CrudRepository<Dog, Long> {

}

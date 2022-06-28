package udacity.DogMicroservice.repository;

import org.springframework.data.repository.CrudRepository;
import udacity.DogMicroservice.entity.Dog;

//This repository is for creating, reading, updating, and deleting Dog objects.
//This repository will not need to implement anything beyond an interface.
public interface DogRepository extends CrudRepository<Dog, Long>{
}

package udacity.DogGraphQL.mutator;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.stereotype.Component;
import udacity.DogGraphQL.entity.Dog;
import udacity.DogGraphQL.exception.BreedNotFoundException;
import udacity.DogGraphQL.exception.DogNotFoundException;
import udacity.DogGraphQL.repository.DogRepository;

import java.util.Optional;

public class Mutation implements  GraphQLMutationResolver {
    private DogRepository dogRepository;

    public Mutation(DogRepository dogRepository) {
        this.dogRepository = dogRepository;
    }

    public boolean deleteDogBreed(String breed) {
        boolean deleted = false;
        Iterable<Dog> allDogs = dogRepository.findAll();
        //loop through all dogs to check their beed
        for (Dog d : allDogs) {
            if (d.getBreed().equals(breed)) {
                dogRepository.delete(d);
                deleted = true;
            }
        }

        //throw an exception if the breed doesn't exist
        if (!deleted) {
            throw new BreedNotFoundException("Breed Not Found", breed);
        }

        return deleted;
    }

    public Dog updateDogName(String newName, Long id) {
        Optional<Dog> optionalDog = dogRepository.findById(id);
        if (optionalDog.isPresent()) {
            Dog dog = optionalDog.get();
            dog.setName(newName);
            dogRepository.save(dog);
            return  dog;
        } else {
            throw new DogNotFoundException("Dog Not Found", id);
        }
    }

}

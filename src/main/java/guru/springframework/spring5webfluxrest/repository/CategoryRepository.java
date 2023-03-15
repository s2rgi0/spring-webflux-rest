package guru.springframework.spring5webfluxrest.repository;

import guru.springframework.spring5webfluxrest.domian.Category;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoryRepository extends ReactiveMongoRepository <Category, String> {



}

package guru.springframework.spring5webfluxrest.repository;

import guru.springframework.spring5webfluxrest.domian.Vendor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface VendorRepository extends ReactiveMongoRepository<Vendor, String> {
}

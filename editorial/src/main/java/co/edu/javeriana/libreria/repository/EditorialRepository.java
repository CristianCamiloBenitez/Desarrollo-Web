package co.edu.javeriana.libreria.repository;

import co.edu.javeriana.libreria.entity.Editorial;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Integer>{

}

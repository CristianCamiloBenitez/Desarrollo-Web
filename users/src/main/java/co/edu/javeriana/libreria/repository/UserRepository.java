package co.edu.javeriana.libreria.repository;

import co.edu.javeriana.libreria.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findUserByUsername(String username);
}

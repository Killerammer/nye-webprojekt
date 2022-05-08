package hu.nye.webapp.books.repository;

import hu.nye.webapp.books.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}

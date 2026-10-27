package org.example.bookmyshow.repository;

import org.example.bookmyshow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    // we don't need to declare method related to id because we pass int id
    // we can implement our own method here that we may need in the future.
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}

package br.com.todentropass.backend.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.todentropass.backend.users.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}

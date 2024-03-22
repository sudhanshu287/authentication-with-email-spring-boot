package com.userService.userService.repository;

import com.userService.userService.model.Confirmation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfirmationRepository extends JpaRepository<Confirmation,Long> {
    Confirmation findByToken(String  token);
}

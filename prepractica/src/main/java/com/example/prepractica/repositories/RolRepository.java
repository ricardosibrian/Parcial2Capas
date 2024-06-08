package com.example.prepractica.repositories;

import com.example.prepractica.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RolRepository extends JpaRepository<Rol, String>  {
}

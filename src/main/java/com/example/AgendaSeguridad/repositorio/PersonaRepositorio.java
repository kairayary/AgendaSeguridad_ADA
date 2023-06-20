package com.example.AgendaSeguridad.repositorio;

import com.example.AgendaSeguridad.entidad.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonaRepositorio extends JpaRepository<Persona, Integer> {
}

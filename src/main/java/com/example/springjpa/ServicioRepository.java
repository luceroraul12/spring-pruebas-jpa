package com.example.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {
    List<Servicio> findByIdAndNombre(@Nullable Long id, @Nullable String nombre);

    List<Servicio> findByIdOrNombre(@Nullable Long id, @Nullable String nombre);



}

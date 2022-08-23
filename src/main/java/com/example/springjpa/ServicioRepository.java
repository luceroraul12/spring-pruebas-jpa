package com.example.springjpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    List<Servicio> findByIdAndNombre(Long id, String nombre);

    //:email is null or s.email = :email
    @Query("select s from Servicio s " +
            "where (:id is null or s.id = :id) " +
            "and (:nombre is null or s.nombre = :nombre)")
    List<Servicio> busquedaFiltrada(@Param("id") Long id, @Param("nombre") String nombre);











    List<Servicio> findByNombreAndId(@NonNull String nombre, @NonNull Long id);






}

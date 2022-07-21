package com.tads.api_eletrodomestico_web.repository;

import com.tads.api_eletrodomestico_web.domain.Eletrodomestico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EletrodomesticoRepository extends JpaRepository<Eletrodomestico, Long> {
    @Query(value = "SELECT * FROM eletrodomestico WHERE deleted is null", nativeQuery = true)
    List<Eletrodomestico> listProdutosNotDeleted();
}

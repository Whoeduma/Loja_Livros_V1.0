package com.loja.livros.repository;

import com.loja.livros.model.VendaLivrosEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaLivrosRepository extends JpaRepository<VendaLivrosEntity, Long> {

    @Modifying
    @Transactional
    @Query ("DELETE FROM VendaLivrosEntity v WHERE v.venda.id = :idVenda")
    void deleteByVendaId(@Param("idVenda") Long idVenda);
}

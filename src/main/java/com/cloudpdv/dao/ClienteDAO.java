/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cloudpdv.dao;

import com.cloudpdv.entidade.Cliente;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rogerio Xonchim Alves Correa
 */
@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c order by c.id")
    Page<Cliente> findAll(Pageable pageable);

    @Query("SELECT c FROM Cliente c WHERE c.id =:id AND c.empresa =:empresa AND c.loja =:loja")
    Optional<Cliente> findById(@Param("id") Long id, @Param("empresa") Long empresa, @Param("loja") Long loja);

    @Query("SELECT c FROM Cliente c WHERE c.numCPF =:numCPF AND c.empresa =:empresa AND c.loja =:loja")
    Optional<Cliente> findByDocumento(@Param("numCPF") String documento, @Param("empresa") Long empresa, @Param("loja") Long loja);

}

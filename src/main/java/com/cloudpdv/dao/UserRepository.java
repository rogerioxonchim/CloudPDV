package com.cloudpdv.dao;

import com.cloudpdv.entidade.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName =:userName")
    User findByUsername(@Param("userName") String userName);
    
    @Query("SELECT u FROM User u WHERE u.userName =:userName and u.password =:password")
    User findByLogin(@Param("userName") String userName, @Param("password") String passowrd);

    @Query("SELECT u FROM User u WHERE u.empresa =:empresa and u.loja =:loja")
    Page<User> findAll(@Param("empresa") Long empresa, @Param("loja") Long loja, Pageable pageable);

    @Query("SELECT u FROM User u WHERE u.id =:id and u.empresa =:empresa and u.loja =:loja")
    Optional<User> findById(@Param("id") Long id, @Param("empresa") Long empresa, @Param("loja") Long loja);
}

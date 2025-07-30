package com.jishiniao.jms1.repository;

import com.jishiniao.jms1.entity.Todo;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface TodoRepository extends CrudRepository<Todo, UUID> {

    @Query(value = "SELECT * FROM Todo WHERE user_id = :userId", nativeQuery = true)
    List<Todo> findByUserId(Long userId);

    void deleteById(UUID id);

    @Modifying
    @Transactional
    @Query("UPDATE Todo t SET t.status = :status WHERE t.id = :id")
    int updateStatusById(@Param("status") String status, @Param("id") UUID id);

    @Modifying
    @Transactional
    @Query("UPDATE Todo t SET t.name = :name WHERE t.id = :id")
    int updateNameById(@Param("newName") String name, @Param("id") UUID id);

}

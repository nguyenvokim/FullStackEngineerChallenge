package com.nguyenvk.common.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T, V> extends CrudRepository<T, V>, JpaRepository<T, V> {
    @Override
    Page<T> findAll(Pageable pageable);

    @Override
    List<T> findAll();

    @Override
    Optional<T> findById(V v);

    @Override
    <S extends T> S save(S entity);

    @Override
    void delete(T entity);
}

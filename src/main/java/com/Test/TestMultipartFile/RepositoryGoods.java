package com.Test.TestMultipartFile;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositoryGoods extends JpaRepository<Goods, Long> {

    public Optional<Goods> findById(Long id);
}

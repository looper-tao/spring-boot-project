package com.boot.learn.repository;

import com.boot.learn.entity.OperationTest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationTestRepository extends JpaRepository<OperationTest,Long> {
}

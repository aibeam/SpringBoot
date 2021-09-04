package org.zerock.ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.ex2.entity.MemoEntity;

public interface MemoRepository extends JpaRepository<MemoEntity, Long> {

}

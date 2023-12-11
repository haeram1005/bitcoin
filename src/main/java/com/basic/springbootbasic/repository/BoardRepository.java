package com.basic.springbootbasic.repository;

import com.basic.springbootbasic.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    //NOTE : 만든 entity 와 pk 타입을 넣어주면 된다
}

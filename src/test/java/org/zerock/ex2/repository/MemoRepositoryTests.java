package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex2.entity.Memo;

import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired // new 생성 하지 않아도 자동 생성.
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        System.out.println("testClass::"+memoRepository.getClass().getName());
    }
    @Test
    public void testInsert(){
        IntStream.rangeClosed(1,100).forEach(i->{
            Memo memo = Memo.builder().memoText("Sample..."+i).build(); //Memo.builder()=생성자 만들기
            memoRepository.save(memo);
        });
    }
}

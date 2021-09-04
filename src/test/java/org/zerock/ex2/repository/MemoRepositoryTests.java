package org.zerock.ex2.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.zerock.ex2.entity.MemoEntity;

import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
public class MemoRepositoryTests {
    @Autowired
    MemoRepository memoRepository;

    @Test
    public void testClass(){
        IntStream.rangeClosed(1,50).forEach(i->{
            MemoEntity memoEntity = MemoEntity.builder().text("Write no."+i).build();
            memoRepository.save(memoEntity);
        });
    }
    @Test
    public void testSelect(){
        Long no = 20L;
        Optional<MemoEntity> result = memoRepository.findById(no);
        if(result.isPresent()){
            MemoEntity memoEntity = result.get();
            System.out.println(memoEntity);
        }
    }
    @Test
    public void testUpdate(){
        MemoEntity memoEntity = MemoEntity.builder().no(50L).text("Changed!!").build();
        System.out.println(memoRepository.save(memoEntity));
    }

    @Test
    public void testDelete(){
        Long no = 5L;
        memoRepository.deleteById(no);
    }

    @Test
    public void testPageDefault(){
        Pageable pageable = PageRequest.of(1,10);
        Page<MemoEntity> result = memoRepository.findAll(pageable);
        System.out.println(result);
    }

    @Test
    public void testSort(){
        Sort sort = Sort.by("no").descending();
        Pageable pageable = PageRequest.of(0,10, sort);
        Page<MemoEntity> result = memoRepository.findAll(pageable);
        result.get().forEach(memoEntity -> {
            System.out.println(memoEntity);
        });
    }
}

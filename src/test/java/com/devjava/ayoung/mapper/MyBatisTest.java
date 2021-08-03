package com.devjava.ayoung.mapper;

import com.devjava.ayoung.dto.BoardDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

@SpringBootTest
public class MyBatisTest {

    @Autowired
    private BoardMapper boardMapper;

    @Test
    void 정상적인_입력_Not_Secure() {

        String title = "test";
        List<BoardDto> boardList = boardMapper.boardSearch_NotSecure(title);

        assertThat(boardList.size(), is(4)); // 4

    }

    @Test
    void 잘못된_입력_Not_Secure() {

        int expectedCount = 0;
        int wrongCount = 5;
        String title = "test%' or title like '%";
        List<BoardDto> boardList = boardMapper.boardSearch_NotSecure(title);

        assertThat(boardList.size(), not(expectedCount)); // 0이 나와야 하지만 틀림
        assertThat(boardList.size(), is(wrongCount)); // 전체 게시판의 수가 출력됨

    }

    @Test
    void 정상적인_입력_Secure() {

        String title = "test";
        List<BoardDto> boardList = boardMapper.boardSearch_Secure(title);

        assertThat(boardList.size(), is(4)); // 4

    }

    @Test
    void 잘못된_입력_Secure() {

        int expectedCount = 0;
        String title = "test%' or title like '%";
        List<BoardDto> boardList = boardMapper.boardSearch_Secure(title);

        assertThat(boardList.size(), is(expectedCount)); // 0 출력

    }
}

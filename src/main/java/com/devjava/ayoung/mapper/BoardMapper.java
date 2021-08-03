package com.devjava.ayoung.mapper;

import com.devjava.ayoung.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    List<BoardDto> boardSearch_NotSecure(String keyword);

    List<BoardDto> boardSearch_Secure(String keyword);

}

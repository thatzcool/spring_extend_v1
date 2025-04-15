package com.ssg.spring_extend_v1.mappers;

import com.ssg.spring_extend_v1.domain.BoardVO;
import com.ssg.spring_extend_v1.domain.Criteria;

public interface BoardMapper {

  java.util.List<BoardVO> getList();

  java.util.List<BoardVO> getPage(Criteria criteria);

  int getTotal(Criteria criteria);


  int insert(BoardVO boardVO);

  BoardVO select(Long bno);

  int update(BoardVO boardVO);

}

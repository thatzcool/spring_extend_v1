package com.ssg.spring_extend_v1.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssg.spring_extend_v1.domain.BoardVO;
import com.ssg.spring_extend_v1.domain.Criteria;
import com.ssg.spring_extend_v1.mappers.BoardMapper;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardService {

  private final BoardMapper boardMapper;

  public java.util.List<BoardVO> getList(Criteria criteria){

    return boardMapper.getPage(criteria);
  }

  public int getTotal(Criteria criteria){

    return boardMapper.getTotal(criteria);
  }

  public Long register(BoardVO boardVO){

    log.info("--------------"+ boardVO);

    int count = boardMapper.insert(boardVO);

    return boardVO.getBno();

  }

  public java.util.List<BoardVO> list() {

    return boardMapper.getList();

  }

  public BoardVO get(Long bno) {

    return boardMapper.select(bno);
  }

  public boolean modify(BoardVO vo){

    return boardMapper.update(vo) == 1;
  }

  public boolean remove(Long bno) {
    return true;
  }
}

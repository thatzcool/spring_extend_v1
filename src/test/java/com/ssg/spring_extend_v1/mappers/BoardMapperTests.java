package com.ssg.spring_extend_v1.mappers;


import com.ssg.spring_extend_v1.mappers.BoardMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.ssg.spring_extend_v1.domain.BoardVO;
import com.ssg.spring_extend_v1.domain.Criteria;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class BoardMapperTests {

  @Autowired(required = false)
  BoardMapper boardMapper;

  @Test
  public void test1() {
    log.info(boardMapper);
  }

  @Test
  public void testList() {

    boardMapper.getList().forEach(boardVO -> log.info(boardVO));

  }

  @Test
  public void testInsert() {

    BoardVO boardVO = new BoardVO();
    boardVO.setTitle("NewTest");
    boardVO.setContent("New Test...");
    boardVO.setWriter("newbie");

    log.info("COUNT: " + boardMapper.insert(boardVO));

    log.info("BNO: " + boardVO.getBno());

  }

  @Test
  public void testSelect() {

    Long bno = 9L;

    log.info(boardMapper.select(bno));

  }

  @Test
  public void testUpdate() {

    BoardVO boardVO = new BoardVO();
    boardVO.setTitle("Updated Title");
    boardVO.setContent("Updated Content");
    boardVO.setBno(9L);

    int updateCount = boardMapper.update(boardVO);

    log.info("update: " + updateCount);

  }

  @Test
  public void testPage() {

    Criteria criteria = new Criteria();
    criteria.setPageNum(2);
    criteria.setTypes(new String[]{"T"});
    criteria.setKeyword("1");
    java.util.List<BoardVO> list = boardMapper.getPage(criteria);

    list.forEach(boardVO -> log.info(boardVO));

  }

}

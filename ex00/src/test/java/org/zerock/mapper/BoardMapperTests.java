package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j

public class BoardMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
//	@Test
//	public void testGetList() {
//		mapper.getList().forEach(board -> log.info(board));
//	}
//	
//	@Test
//	public void testInsert() {
//		BoardVO bVO = new BoardVO();
//		bVO.setTitle("새로 작성하는 글");
//		bVO.setContent("새로 작성하는 내용");
//		bVO.setWriter("newbie");
//		
//		mapper.insert(bVO);
//		log.info(bVO);
//	}
//	@Test
//	public void read() {
//		BoardVO bVO = mapper.read(1L);
//		
//		log.info(bVO);
//	}
	
	@Test
	public void testDelete() {
		mapper.delete(7L);
	}
	
	
}

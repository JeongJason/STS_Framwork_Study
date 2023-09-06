package com.example.board.domain.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.board.domain.vo.Criteria;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ReplyDAOTests {
	
	private Long[] arBno = {4722L,4710L,4709L,4708L,4707L};
	
	@Autowired
	private ReplyDAO replyDAO;
	
	@Test
	public void daoTest() {
		log.info("===========================================");
		log.info(replyDAO);
		log.info("===========================================");
	}
	
//	@Test
//	public void registerTest() {
//		//5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(11, 20).forEach(i->{
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i%5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("작성자" + i);
//			
//			replyDAO.register(replyVO);
//		});
//	}
	
//	@Test
//	public void findByRNOTest() {
//		log.info(replyDAO.findByRNO(16L));	
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(replyDAO.remove(16L));
//	}
	
//	@Test
//	public void removeAllByBNOTest() {
//		log.info("===========================================");
//		log.info(replyDAO.removeAllByBNO(4709L));
//		log.info("===========================================");
//	}
	
//	@Test
//	public void modify() {
//		ReplyVO replyVO = replyDAO.findByRNO(20L);
//		replyVO.setReply("수정된 댓글 테스트2");
//		
//		log.info(replyDAO.modify(replyVO));
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyDAO.findAllByBNO(new Criteria(), 4722L).forEach(log::info);
	}
	
	
	
}
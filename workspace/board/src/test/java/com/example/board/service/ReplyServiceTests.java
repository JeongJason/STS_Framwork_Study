package com.example.board.service;

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
public class ReplyServiceTests {
	
	private Long[] arBno = {4722L,4710L,4709L,4708L,4707L};
	
	@Autowired
	private ReplyService replyService;
	
	@Test
	public void replyServiceTest() {
		log.info("===========================================");
		log.info(replyService);
		log.info("===========================================");
	}
	
//	@Test
//	public void registerTest() {
//		//5개의 게시글에 2개씩 댓글 달기
//		IntStream.rangeClosed(21, 30).forEach(i->{
//			ReplyVO replyVO = new ReplyVO();
//			replyVO.setBno(arBno[i%5]);
//			replyVO.setReply("댓글 테스트" + i);
//			replyVO.setReplier("작성자" + i);
//			
//			replyService.register(replyVO);
//		});
//	}
	
//	@Test
//	public void findByRNOTest() {
//		log.info(replyService.findByRNO(26L));	
//	}
	
//	@Test
//	public void removeTest() {
//		log.info(replyService.remove(26L));
//	}
	
//	@Test
//	public void removeAllByBNOTest() {
//		log.info("===========================================");
//		log.info(replyService.removeAllByBNO(4708L));
//		log.info("===========================================");
//	}
	
//	@Test
//	public void modify() {
//		ReplyVO replyVO = replyService.findByRNO(24L);
//		replyVO.setReply("수정된 댓글 테스트2");
//		
//		log.info(replyService.modify(replyVO));
//	}
	
	@Test
	public void findAllByBNOTest() {
		replyService.findAllByBNO(new Criteria(), 4722L).forEach(log::info);
	}
}
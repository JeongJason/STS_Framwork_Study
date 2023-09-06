package com.example.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;

@Mapper
public interface BoardMapper {
//	전체 리스트 가져오기
	public List<BoardVO> getList(Criteria criteria);
//	게시물 추가
	public void insert(BoardVO board);
//	1개의 게시물 가져오기
	public BoardVO read(Long bno);
//	게시글 삭제	
	public int delete(Long bno);
//	게시글 수정
	public int update(BoardVO board);
	
	public int getTotal(Criteria criteria);
}

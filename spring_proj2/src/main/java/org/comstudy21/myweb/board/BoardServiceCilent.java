package org.comstudy21.myweb.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class BoardServiceCilent {
	public static void main(String[] args) {
		boardListTest();
	}
	public static void insertBoardTest() {
		// 스프링 컨테이너 구동
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		// BoardSericeImpl 객체를 Lookup 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 글등록 테스트
		BoardVO vo = new BoardVO();
		vo.setTitle("글 등록 테스트2");
		vo.setWriter("길동이");
		vo.setContent("테스트 글 내용2");
		boardService.insertBoard(vo);

		container.close();

	}

	public static void boardListTest() {
		// 스프링 컨테이너 구동
		AbstractApplicationContext container = 
				new GenericXmlApplicationContext("applicationContext.xml");
		// BoardSericeImpl 객체를 Lookup 한다.
		BoardService boardService = (BoardService) container.getBean("boardService");

		// 글 목록 검색
		List<BoardVO> boardList = boardService.getBoardList(null);
		for (BoardVO board : boardList) {
			System.out.println(board);
		}
		container.close();
	}

}

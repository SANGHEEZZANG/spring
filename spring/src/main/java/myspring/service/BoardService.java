package myspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myspring.dao.BoardDao;
import myspring.model.Board;

@Service
public class BoardService {
	
	@Autowired
	private BoardDao dao;
	
	public int insert(Board board) {
		return dao.insert(board);
	}
	
	public List<Board> getBoardList(){
		return dao.getBoardList();
	}
	
	public void readcount(int no) {
		dao.readcount(no);
	}

	public Board getBoard(int no) {
		return dao.getBoard(no);
	}
	
	public int update(Board board) {
		return dao.update(board);
	}
	
	public int delete(int no) {
		return dao.delete(no);
	}
	
}

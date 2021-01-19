package myspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import myspring.model.Board;
import myspring.service.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService service;
	
	// ���ۼ� ��
	@RequestMapping("boardform.do")
	public String boardform() {
		return "board/boardform";
	}
	
	//���ۼ�
	@RequestMapping("boardwrite.do")
	public String boardwrite(Board board, Model model) {
		System.out.println("board:"+board.getWriter());
		
		int result = service.insert(board);
		System.out.println("result:"+result); // 1
		
		model.addAttribute("result", result);		
		
		return "board/insertresult";
		
//		return "redirect:boardlist.do";
	}
	
	//�۸��
	@RequestMapping("boardlist.do")
	public String boardlist(Model model) {
		System.out.println("boardlist");
		
		List<Board> list = service.getBoardList();
		System.out.println("list:"+list);
		
		model.addAttribute("list", list);		
		
		return "board/boardlist";
	}
	
	// �� ������ : ��ȸ�� ���� + ������ ���ϱ�
	@RequestMapping("boardcontent.do")
	public String boardcontent(int no, Model model) {
		
		service.readcount(no);				// ��ȸ�� ����
		Board board = service.getBoard(no); // �� ���� ���ϱ�
		String content = board.getContent().replace("\n","<br>");
		
		model.addAttribute("board", board);
		model.addAttribute("content", content);
		
		return "board/boardcontent";
	}
	
	// ���� ��
	@RequestMapping("boardupdateform.do")
	public String boardupdateform(int no, Model model) {
		
		Board board = service.getBoard(no);		// �� ����
		model.addAttribute("board", board);
		
		return "board/boardupdateform";
	}
	
	// �ۼ���
	@RequestMapping("boardupdate.do")
	public String boardupdate(Board board, Model model) {
		Board old = service.getBoard(board.getNo());
		int result = 0;
		if(old.getPasswd().equals(board.getPasswd())){ // ��� ��ġ	
			result = service.update(board);
		} else {									  // ��� ����ġ
			result = -1;
		}
		model.addAttribute("result", result);
		model.addAttribute("board", old);
		
		return "board/updateresult";
	}
	
	// �ۻ��� ��
	@RequestMapping("boarddeleteform.do")
	public String boarddeleteform() {
		return "board/boarddeleteform";
	}
	
	// �ۻ���
	@RequestMapping("boarddelete.do")
	public String boarddelete(Board board, Model model) {
		Board old = service.getBoard(board.getNo());
		int result = 0;
		if(old.getPasswd().equals(board.getPasswd())) { // ��� ��ġ
			result = service.delete(board.getNo());
		}else {										// ��� ����ġ
			result = -1;
		}
		model.addAttribute("result", result);
		
		return "board/deleteresult";
	}
	
	// 메인페이지
	@RequestMapping("main.do")
	public String main() {
		return "/board/main";
	}
	
	// 테스트페이지
	@RequestMapping("test.do")
	public String test() {
		return "/board/test";
	}
	
	// 로그인페이지
	@RequestMapping("loginform.do")
	public String login() {
		return "/board/loginform";
	}
	
	// 회원가입
	@RequestMapping("memberform.do")
	public String memberform() {
		return "/board/memberform";
	}
	
	// 오시는길
	@RequestMapping("map.do")
	public String map() {
		return "/board/map";
	}
	
}

package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.data.BoardDao;
import board.data.BoardDto;

@Controller
public class BoardListController {

	@Autowired
	BoardDao dao;
	
	
	//여기서 list에 데이터를 담아서 넘겨줌
	@GetMapping("/board/list")
	public ModelAndView list(
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		
		//데이터를 넣고 넘겨줄 모델 선언
		ModelAndView mview = new ModelAndView();
		
		//총 글의 갯수
		int totalCount = dao.getTotalCount();
		
		
		//페이징 처리에 필요한 변수
		int totalPage; //총페이지수
		int startPage; //각블럭의 시작페이지
		int endPage; //각블럭의 끝페이지
		int start; //각페이지의 시작번호
		int perPage=5; //한페이지에 보여질 글의개수
		int perBlock=5; //한페이지에 보여지는 페이지 개수
		
		//총페이지개수구하기
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);		
		
		
		//각블럭의 시작페이지
		//예: 현재페이지:3 startPage:1, endpge=5 
		//예: 현재페이지:6 startPage:6, endpge=10
		startPage=(currentPage-1)/perBlock*perBlock+1;
		
		endPage=startPage+perBlock-1;

		
		//만약 총페이지 수가 8일경우 
		//2번재 블럭은 st:6 endPage:10이 되야한다
		//이때는 endPage를 8로 수정해 주어야 한다
			if(endPage>totalPage)
				endPage=totalPage;
			
			
		//각페이지에서 불러올시작번호
		//현재페이지가  1 일경우 start는 1,2일경우 6....
		start=(currentPage-1)*perPage;
		
		
		//각페이지에서 필요한 게시글 가져오기...dao에서 만들었음
		List<BoardDto> list=dao.getList(start, perPage);

		
		//각글앞에 붙힐 시작번호 구하기
		//총글이 20개일겨웅 1페이지 20,2페이지 15부터
		//출력해서 1씩 감소해가면서 출력할것
		int no = totalCount-(currentPage-1)*perPage;		

		
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		mview.addObject("startPage", startPage);
		mview.addObject("endPage", endPage);
		mview.addObject("totalPage", totalPage);
		mview.addObject("no", no);
		mview.addObject("currentPage", currentPage);
		
		
		//포워드
		mview.setViewName("/board/boardlist");
		
		return mview;
	}
	
	
	//리스트 2로 이동
	@GetMapping("/board/list2")
	public String list2() {
		
		return "/board/ajaxlist";
	}
}

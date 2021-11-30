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
	
	
	//���⼭ list�� �����͸� ��Ƽ� �Ѱ���
	@GetMapping("/board/list")
	public ModelAndView list(
			@RequestParam(value = "currentPage", defaultValue = "1") int currentPage) {
		
		//�����͸� �ְ� �Ѱ��� �� ����
		ModelAndView mview = new ModelAndView();
		
		//�� ���� ����
		int totalCount = dao.getTotalCount();
		
		
		//����¡ ó���� �ʿ��� ����
		int totalPage; //����������
		int startPage; //�������� ����������
		int endPage; //�������� ��������
		int start; //���������� ���۹�ȣ
		int perPage=5; //���������� ������ ���ǰ���
		int perBlock=5; //���������� �������� ������ ����
		
		//���������������ϱ�
		totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);		
		
		
		//�������� ����������
		//��: ����������:3 startPage:1, endpge=5 
		//��: ����������:6 startPage:6, endpge=10
		startPage=(currentPage-1)/perBlock*perBlock+1;
		
		endPage=startPage+perBlock-1;

		
		//���� �������� ���� 8�ϰ�� 
		//2���� ������ st:6 endPage:10�� �Ǿ��Ѵ�
		//�̶��� endPage�� 8�� ������ �־�� �Ѵ�
			if(endPage>totalPage)
				endPage=totalPage;
			
			
		//������������ �ҷ��ý��۹�ȣ
		//������������  1 �ϰ�� start�� 1,2�ϰ�� 6....
		start=(currentPage-1)*perPage;
		
		
		//������������ �ʿ��� �Խñ� ��������...dao���� �������
		List<BoardDto> list=dao.getList(start, perPage);

		
		//���۾տ� ���� ���۹�ȣ ���ϱ�
		//�ѱ��� 20���ϰܿ� 1������ 20,2������ 15����
		//����ؼ� 1�� �����ذ��鼭 ����Ұ�
		int no = totalCount-(currentPage-1)*perPage;		

		
		mview.addObject("totalCount", totalCount);
		mview.addObject("list", list);
		mview.addObject("startPage", startPage);
		mview.addObject("endPage", endPage);
		mview.addObject("totalPage", totalPage);
		mview.addObject("no", no);
		mview.addObject("currentPage", currentPage);
		
		
		//������
		mview.setViewName("/board/boardlist");
		
		return mview;
	}
	
	
	//����Ʈ 2�� �̵�
	@GetMapping("/board/list2")
	public String list2() {
		
		return "/board/ajaxlist";
	}
}
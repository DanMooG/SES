package com.ses.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ses.service.QnaService;
import com.ses.dto.QnaDTO;
import com.ses.dto.Criteria;
import com.ses.dto.PageMaker;
import com.ses.dto.SearchCriteria;

public class QnaController {
private static final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	@Inject
	QnaService service;	
	
	// �����ϱ� �� �ۼ�ȭ��
	@RequestMapping(value = "/qnawrite", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("QnaWrite");
		
	}
	
	// �����ϱ� �� �ۼ�
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(QnaDTO qnaDTO) throws Exception{
		logger.info("write");
		
		service.write(qnaDTO);
		
		return "redirect:/qna";
	}
	
	// �����ϱ� ��� ��ȸ
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public String list(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception{
		logger.info("qna");
		
		model.addAttribute("qna", service.qna(scri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.qnaCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/qna";
		
	}
	
	// �����ϱ� ���� ��
	@RequestMapping(value = "/qnaupdateView", method = RequestMethod.GET)
	public String updateView(QnaDTO qnaDTO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception{
		logger.info("qnaupdateView");
		
		model.addAttribute("update", service.read(qnaDTO.getBid()));
		model.addAttribute("scri", scri);
		
		return "board/qnaupdateView";
	}
	
	// �����ϱ� ����
	@RequestMapping(value = "/qnaupdate", method = RequestMethod.POST)
	public String update(QnaDTO boardDTO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("update");
		
		service.update(boardDTO);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}

	// �Խ��� ����
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardDTO boardDTO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception{
		logger.info("delete");
		
		service.delete(boardDTO.getBid());
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/list";
	}
	
	
	//��� �ۼ�
	@RequestMapping(value="/replyWrite", method = RequestMethod.POST)
	public String replyWrite(ReplyDTO dto, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("reply Write");
		
		replyService.writeReply(dto);
		
		rttr.addAttribute("bid", dto.getBid());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	//��� ���� GET
	@RequestMapping(value="/replyUpdateView", method = RequestMethod.GET)
	public String replyUpdateView(ReplyDTO dto, SearchCriteria scri, Model model) throws Exception {
		logger.info("reply Write");
		
		model.addAttribute("replyUpdate", replyService.selectReply(dto.getRid()));
		model.addAttribute("scri", scri);
		
		return "board/replyUpdateView";
	}
	
	//��� ���� POST
	@RequestMapping(value="/replyUpdate", method = RequestMethod.POST)
	public String replyUpdate(ReplyDTO dto, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("reply Write");
		
		replyService.updateReply(dto);
		
		rttr.addAttribute("bid", dto.getBid());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/readView";
	}
	
	//��� ���� GET
	@RequestMapping(value="/replyDeleteView", method = RequestMethod.GET)
	public String replyDeleteView(ReplyDTO dto, SearchCriteria scri, Model model) throws Exception {
		logger.info("reply Write");
		
		model.addAttribute("replyDelete", replyService.selectReply(dto.getRid()));
		model.addAttribute("scri", scri);
		

		return "board/replyDeleteView";
	}
	
	//��� ����
	@RequestMapping(value="/replyDelete", method = RequestMethod.POST)
	public String replyDelete(ReplyDTO dto, SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		logger.info("reply Write");
		
		replyService.deleteReply(dto);
		
		rttr.addAttribute("bid", dto.getBid());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/readView";
	}
}
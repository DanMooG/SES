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
	public void writeView() throws Exception {
		logger.info("QnaWrite");

	}

	// �����ϱ� �� �ۼ�
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(QnaDTO qnaDTO) throws Exception {
		logger.info("write");

		service.write(qnaDTO);

		return "redirect:/qna";
	}

	// �����ϱ� ��� ��ȸ
	@RequestMapping(value = "/qna", method = RequestMethod.GET)
	public String qna(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		logger.info("qna");

		model.addAttribute("qna", service.qna(scri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(service.qnaCount(scri));

		model.addAttribute("pageMaker", pageMaker);

		return "board/qna";

	}

	// �����ϱ� ��ȸ
	@RequestMapping(value = "/qnaread", method = RequestMethod.GET)
	public String read(QnaDTO qnaDTO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("read");

		model.addAttribute("read", service.read(qnaDTO.getBid()));
		model.addAttribute("scri", scri);

		List<ReplyDTO> replyList = replyService.readReply(QnaDTO.getBid());
		model.addAttribute("replyList", replyList);

		return "board/readView";
	}

	// �����ϱ� ���� ��
	@RequestMapping(value = "/qnaupdateView", method = RequestMethod.GET)
	public String updateView(QnaDTO qnaDTO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		logger.info("qnaupdateView");

		model.addAttribute("update", service.read(qnaDTO.getBid()));
		model.addAttribute("scri", scri);

		return "board/qnaupdateView";
	}

	// �����ϱ� ����
	@RequestMapping(value = "/qnaupdate", method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr)
			throws Exception {
		logger.info("update");

		service.update(qnaDTO);

		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/qna";
	}

	// �����ϱ� ����
	@RequestMapping(value = "/qnadelete", method = RequestMethod.POST)
	public String delete(QnaDTO qnaDTO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr)
			throws Exception {
		logger.info("qnadelete");

		service.delete(qnaDTO.getBid());

		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());

		return "redirect:/qna";
	}
}
package com.ses.dto;

public class PageDTO {
	private int TotalCnt; // ��ü �Խù� ����
	private int PageNum; // ���� ������ ��ȣ
	private int ContentNum; // �� �������� ǥ���� ������ ��
	private int StartPage; // ���� ������ ������ ���� ������
	private int EndPage; // ���� ������ ������ ������ ������
	private boolean Prev; // ���� �������� ���� ȭ��ǥ
	private boolean Next; // ���� �������� ���� ȭ��ǥ
	private int CurBlock; // ���� ������ ����
	private int LastBlock; // ������ ������ ����
	
	public PageDTO() {}

	public void prevnext(int PageNum) {
		if(PageNum > 0 && PageNum < 6) {
			setPrev(false);
			setNext(true);
		} else if(getLastBlock() == getCurBlock()) {
			setPrev(true);
			setNext(false);
		} else {
			setPrev(true);
			setNext(true);
		}
	}
	
	// ��ü ������ �� ���
	public int CalcPage(int TotalCnt, int ContentNum) {
		int total;
		total = TotalCnt / ContentNum;
		if (TotalCnt % ContentNum > 0) {
			total++;
		}
		return total;
	}

	public int getTotalCnt() {
		return TotalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		TotalCnt = totalCnt;
	}

	public int getPageNum() {
		return PageNum;
	}

	public void setPageNum(int pageNum) {
		PageNum = pageNum;
	}

	public int getContentNum() {
		return ContentNum;
	}

	public void setContentNum(int contentNum) {
		ContentNum = contentNum;
	}

	public int getStartPage() {
		return StartPage;
	}

	public void setStartPage(int CurrBlock) {
		StartPage = (CurrBlock*5)-4;
	}

	public int getEndPage() {
		return EndPage;
	}

	public void setEndPage(int GetLastBlock, int GetCurrBlock) {
		if(GetLastBlock == GetCurrBlock) {
			EndPage = CalcPage(getTotalCnt(), getContentNum());
		} else {
			EndPage = getStartPage() + 4;
		}
	}

	public boolean isPrev() {
		return Prev;
	}

	public void setPrev(boolean prev) {
		Prev = prev;
	}

	public boolean isNext() {
		return Next;
	}

	public void setNext(boolean next) {
		Next = next;
	}

	public int getCurBlock() {
		return CurBlock;
	}

	public void setCurBlock(int pageNum) {
		CurBlock = pageNum / 5;
		if(pageNum%5>0) {
			CurBlock++;
		}
	}

	public int getLastBlock() {
		return LastBlock;
	}

	public void setLastBlock(int TotalCnt) {
		LastBlock = TotalCnt / (5*ContentNum);
		if(TotalCnt % (5 * this.ContentNum) > 0) {
			LastBlock++;
		}
	}
}
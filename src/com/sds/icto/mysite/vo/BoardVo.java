package com.sds.icto.mysite.vo;

import java.sql.Date;

public class BoardVo {
	private long no;
	private String title;
	private String content;
	private long memberno;
	private String membername;
	private long viewcnt;
	private Date regdate;
	public BoardVo() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardVo(String title, String content, long memberno,
			String membername) {
		super();
		this.title = title;
		this.content = content;
		this.memberno = memberno;
		this.membername = membername;
	}

	public BoardVo(long no, String title, String content, long memberno,
			String membername, long viewcnt, Date regdate) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.memberno = memberno;
		this.membername = membername;
		this.viewcnt = viewcnt;
		this.regdate = regdate;
	}
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public long getMemberno() {
		return memberno;
	}
	public void setMemberno(long memberno) {
		this.memberno = memberno;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public long getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(long viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "BoardVo [no=" + no + ", title=" + title + ", content="
				+ content + ", memberno=" + memberno + ", membername="
				+ membername + ", viewcnt=" + viewcnt + ", regdate=" + regdate
				+ "]";
	}
	

}

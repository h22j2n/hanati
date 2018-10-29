package kr.or.kosta.blog.guestbook.domain;

public class Guestbook {
	
	private String gusetbook_id;
	private String user_id;
	private String contents;
	private String regdate;
	
	public Guestbook() {
		super();
	}
	
	public Guestbook(String gusetbook_id, String user_id, String contents, String regdate) {
		super();
		this.gusetbook_id = gusetbook_id;
		this.user_id = user_id;
		this.contents = contents;
		this.regdate = regdate;
	}

	public String getGusetbook_id() {
		return gusetbook_id;
	}

	public void setGusetbook_id(String gusetbook_id) {
		this.gusetbook_id = gusetbook_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "Guestbook [gusetbook_id=" + gusetbook_id + ", user_id=" + user_id + ", contents=" + contents
				+ ", regdate=" + regdate + "]";
	}
	

}

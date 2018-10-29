package kr.or.kosta.blog.article.domain;

public class Article {
	
	private String article_id;
	private String board_id;
	private String writer;
	private String subject;
	private String content;
	private String regdate;
	private String hitcount;
	private String ip;
	private String passwd;
	private String attach_file;
	private String group_no;
	private String level_no;
	private String order_no;
	
	public Article() {
		super();
	}

	public Article(String article_id, String board_id, String writer, String subject, String content, String regdate,
			String hitcount, String ip, String passwd, String attach_file, String group_no, String level_no,
			String order_no) {
		super();
		this.article_id = article_id;
		this.board_id = board_id;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.hitcount = hitcount;
		this.ip = ip;
		this.passwd = passwd;
		this.attach_file = attach_file;
		this.group_no = group_no;
		this.level_no = level_no;
		this.order_no = order_no;
	}

	public String getArticle_id() {
		return article_id;
	}

	public void setArticle_id(String article_id) {
		this.article_id = article_id;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getHitcount() {
		return hitcount;
	}

	public void setHitcount(String hitcount) {
		this.hitcount = hitcount;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAttach_file() {
		return attach_file;
	}

	public void setAttach_file(String attach_file) {
		this.attach_file = attach_file;
	}

	public String getGroup_no() {
		return group_no;
	}

	public void setGroup_no(String group_no) {
		this.group_no = group_no;
	}

	public String getLevel_no() {
		return level_no;
	}

	public void setLevel_no(String level_no) {
		this.level_no = level_no;
	}

	public String getOrder_no() {
		return order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	@Override
	public String toString() {
		return "Article [article_id=" + article_id + ", board_id=" + board_id + ", writer=" + writer + ", subject="
				+ subject + ", content=" + content + ", regdate=" + regdate + ", hitcount=" + hitcount + ", ip=" + ip
				+ ", passwd=" + passwd + ", attach_file=" + attach_file + ", group_no=" + group_no + ", level_no="
				+ level_no + ", order_no=" + order_no + "]";
	}

}

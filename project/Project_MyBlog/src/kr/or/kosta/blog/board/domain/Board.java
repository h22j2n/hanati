package kr.or.kosta.blog.board.domain;

public class Board {
	
	private String board_id;
	private String category;
	private String title;
	
	public Board() {
		super();
	}

	public Board(String board_id, String category, String title) {
		this.board_id = board_id;
		this.category = category;
		this.title = title;
	}

	public String getBoard_id() {
		return board_id;
	}

	public void setBoard_id(String board_id) {
		this.board_id = board_id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Board [board_id=" + board_id + ", category=" + category + ", title=" + title + "]";
	}

}

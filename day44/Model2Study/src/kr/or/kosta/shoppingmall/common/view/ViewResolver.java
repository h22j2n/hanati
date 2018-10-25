package kr.or.kosta.shoppingmall.common.view;

import javax.servlet.ServletException;

/**
 * View 선택 및 실행
 * @author 김기정
 *
 */
public class ViewResolver{
	
	public View resolve(String path) throws ServletException{
		View view = new JSPView(path);
//		View view = new XXXView(path);
		return view;
	}
}

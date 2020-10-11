// 애너테이션이 적용되려면 해당클래스가 반드시 component-scan 에서 설정한 패키지나 하위패키지에 존재해야합니다.
package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//컨트롤러 애너테이션을 이용해 MainController 클래스를 빈으로 자동변환합니다. 빈id는 mainController 입니다.
// 지정안하면 자동으로 클래스이름 에서 앞 소문자로 바껴서 적용됨 
@Controller("mainController")
// 첫번째 단계의 url 요청이 test 이면 mainController 빈을 요청합니다.
@RequestMapping("/test")
public class MainController {
	//두번재 단계의 url 요청이 /main1.do 이면 mainController 빈의 main1() 메서드에게 요청합니다.
	//method=requestmethod.get 으로 지정하면 GET방식으로 요청시 해당 메서드가 호출됩니다.
	@RequestMapping(value="/main1.do" ,method=RequestMethod.GET)
	public ModelAndView main1(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","main1");
		// 아래 main 이  jsp 파일명을 말한다.
		mav.setViewName("main");
		return mav;
	}
	
	@RequestMapping(value="/main1.do" ,method=RequestMethod.GET)
	public ModelAndView main2(HttpServletRequest request,HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg","main2");
		// 아래 main 이  jsp 파일명을 말한다.
		mav.setViewName("main");
		return mav;
	}
}
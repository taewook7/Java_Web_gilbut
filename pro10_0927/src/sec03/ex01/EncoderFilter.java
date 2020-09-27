package sec03.ex01;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncoderFilter
 */
@WebFilter("/*")
public class EncoderFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncoderFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter 호출");
		request.setCharacterEncoding("utf-8");
		
		String context= ((HttpServletRequest)request).getContextPath();  
		// 웹 애플리케이션의 컨텍스트 이름을 가져옵니다. 
		
		String pathinfo= ((HttpServletRequest)request).getRequestURI();
		// 웹 브라우저에서 요청한 요청 URI 를 가져옵니다.
		
		String realPath= request.getRealPath(pathinfo); 
		// 요청 uri 의 실제 경로를 가져옵니다.
		
		String mesg= "Context 정보:"+context + "\n URI 정보: " +pathinfo + "\n 물리적 경로: " +realPath;
		System.out.println(mesg);
		long begin=System.currentTimeMillis();  // 요청 필터에서 요청 처리 전의 시각을 구합니다.
		
		chain.doFilter(request, response);
		//분기점
		
		long end=System.currentTimeMillis();
		System.out.println("작업시간은 :" + (end-begin)+"ms");
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

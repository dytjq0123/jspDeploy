package kr.or.ddit.locale;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet Filter implementation class LocaleFilter
 */
@WebFilter("/localeSelect")
public class LocaleFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LocaleFilter.class);
	
    public LocaleFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//전처리
		HttpServletRequest req = (HttpServletRequest) request;
		
		logger.debug(req.getRequestURI()+"LocaleFilter doFilter");
		
		LocaleWrapper localeWrapper = new LocaleWrapper(req);
		
		//filter / servlet 요청처리
		//chain.doFilter(request, response);
		chain.doFilter(localeWrapper, response);
		
		//후처리
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

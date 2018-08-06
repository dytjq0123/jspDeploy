package kr.or.ddit.locale;

import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class LocaleWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> map;
	
	public LocaleWrapper(HttpServletRequest request) {
		super(request);
		
		map = new HashMap<String, String[]>(request.getParameterMap());
		
		String[] locales = map.get("locale");
		
		if(locales == null || locales[0].equals("")){
			map.put("locale", new String[]{"ja"});
		}
		
		
	}

	@Override
	public String getParameter(String name) {
		String[] values = getParameterValues(name);
		if(values != null){
			return values[0];
		}else{
			return null;
		}
	}

	@Override
	public Map<String, String[]> getParameterMap() {
		return map;
	}

	@Override
	public Enumeration<String> getParameterNames() {
		return Collections.enumeration(map.keySet());
	}

	@Override
	public String[] getParameterValues(String name) {
		return map.get(name);
	}

}

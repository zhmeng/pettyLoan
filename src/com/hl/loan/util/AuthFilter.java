package com.hl.loan.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;





/**
 * @author Leo
 */
public class AuthFilter implements Filter {
	private static final Log LOG = LogFactory.getLog(AuthFilter.class);

	@Override
	public void init(FilterConfig arg0) throws ServletException {

	}

	
	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		LOG.debug("Enter Auth Filter...");

		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		HttpSession session = request.getSession();

		String uri = request.getRequestURI();
		String context = request.getContextPath();
		uri = uri.replace(context, "");
		Object user = session.getAttribute(SystemSettings.SESSION_USER);
	
		if (uri.endsWith("login.jsp") || uri.endsWith("main.jsp") || user!=null || uri.endsWith("/sysUser/sysLogin") || uri.endsWith("/mast/code/getCode") || uri.endsWith("/mast/code/judCode")) {
			chain.doFilter(request, response);
			
		}  else {
			int index=uri.lastIndexOf(".");
			if(index==-1){
				response.sendRedirect(request.getContextPath() +"/login.jsp");
				return;
			}else{
				String str=uri.substring(index);
				if(str.equals(".jsp")){
					LOG.debug("doFilter请求被拦截，跳转到：" + context);
				
					response.sendRedirect(request.getContextPath() +"/login.jsp");
			
					return;
				}else{
					chain.doFilter(request, response);
				}
			}
				
		}
	}

	@Override
	public void destroy() {
		try {

		} catch (Exception ex) {
			LOG.debug(ex.getMessage());
		}
	}
}




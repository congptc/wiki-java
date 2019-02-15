package com.tpb.wiki.filters;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tpb.wiki.common.Constants;

public class CheckLoginedFilter implements Filter {

	public CheckLoginedFilter() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();

		if (req.getMethod().equalsIgnoreCase("GET") 
			&& session.getAttribute(Constants.SESSION_USER_LOGIN) == null) {
			// => /spath
			String servletPath = req.getServletPath();
			// => /abc/mnp
			String pathInfo = req.getPathInfo();

			String urlPattern = servletPath;

			if (pathInfo != null) {
				// => /spath/*
				urlPattern = servletPath + "/*";
			}

			// Key: servletName.
			// Value: ServletRegistration
			Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
					.getServletRegistrations();

			// Get all Servlet in WebApp.
			Collection<? extends ServletRegistration> values = servletRegistrations.values();
			for (ServletRegistration sr : values) {
				Collection<String> mappings = sr.getMappings();
				if (mappings.contains(urlPattern)) {
					RequestDispatcher dispatcher = req.getServletContext()
							.getRequestDispatcher("/WEB-INF/views/login.jsp");
					dispatcher.forward(req, res);
					return;
				}
			}
		}
		chain.doFilter(request, response);

	}

}

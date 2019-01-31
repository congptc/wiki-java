package com.tpb.wiki.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.apache.commons.lang3.StringUtils;

import com.tpb.wiki.utils.BuildHtml;

public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5217598574951469189L;
	
	
	
	public HomeServlet() {
		
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	protected void doGet(HttpServletRequest req, 
			HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext context = getServletContext();
		String rootPath = context.getRealPath("WEB-INF/datas/");
		
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp");
		String data = req.getParameter("data");
		String content = "";
		if(StringUtils.isNotBlank(data)) {
			content = FileUtils.readFileToString(new File(rootPath+data), "utf-8");
		}else {
			Collection<File> files = FileUtils.listFilesAndDirs(new File(rootPath), TrueFileFilter.INSTANCE, DirectoryFileFilter.DIRECTORY);
			BuildHtml bh = new BuildHtml();
			for (File file : files) {
				if(file.isDirectory()) {
					content += bh.category(file.getName());
				}else {
					content += bh.article(req.getContextPath()+"/?data="+file.getParentFile().getName()+ "/" + file.getName(),file.getName());
				}
			}
		}
		req.setAttribute("content", content);
		dispatcher.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
}

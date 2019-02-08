package com.tpb.wiki.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.Gson;

@MultipartConfig
public class UploadImgServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UploadImgServlet() {
		super();
	}



	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (ServletFileUpload.isMultipartContent(req)) {
			Map<Object, Object> responseData;
			DiskFileItemFactory factory = new DiskFileItemFactory();
			String fileName="";
			ServletContext context = getServletContext();
			String fullPath = context.getRealPath("/assets/article_img");
			try {
				
				factory.setSizeThreshold(1024 * 1024);
				factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setFileSizeMax(1024 * 1024 * 5);
				upload.setSizeMax(1024 * 1024 * 5 * 5);

				List<FileItem> formItems = upload.parseRequest(req);
				if (formItems != null && formItems.size() > 0) {
					for (FileItem item : formItems) {
						if (!item.isFormField()) {
							String extension = item.getName().substring(item.getName().lastIndexOf("."),item.getName().length());
							String randomFileName = UUID.randomUUID().toString()+extension;
							fileName = new File(randomFileName).getName();
							String filePath = fullPath + File.separator + fileName;
							File storeFile = new File(filePath);
							item.write(storeFile);
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				responseData = new HashMap<Object, Object>();
				responseData.put("error", e.toString());
			}finally {
	            // Build response data.
	            responseData = new HashMap < Object, Object > ();
	            responseData.put("link", req.getContextPath() + "/assets/article_img"+File.separator+fileName);
	 
	            // Send response data.
	            String jsonResponseData = new Gson().toJson(responseData);
	            resp.setContentType("application/json");
	            resp.setCharacterEncoding("UTF-8");
	            resp.getWriter().write(jsonResponseData);
	        }

		}
	}

}

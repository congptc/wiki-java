package com.tpb.wiki.utils;

import java.io.File;
import java.util.List;

public class ProcessEditorHtmlUtil {
	
	public void deleteFile(List<String> pathImgsWillBeDelete) {
		if (pathImgsWillBeDelete != null && pathImgsWillBeDelete.size() > 0) {
			for (String pathImg : pathImgsWillBeDelete) {
				deleteFile(pathImg);
			}
		}
	}
	
	public void deleteFile(String pathImg) {
		File deleteFile = null;

		deleteFile = new File(pathImg);
		try {
			// check if the file present or not
			if (deleteFile.exists())
				deleteFile.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

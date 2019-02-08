package com.tpb.wiki.conn;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;


public class DBCPDataSourceFactory {
	
	
	public static DataSource getDataSource() {
		Properties props = new Properties();
		InputStream  fs = null;
		BasicDataSource ds =  new BasicDataSource();
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();  
			fs =  loader.getResourceAsStream("/resources/db.properties");
			props.load(fs);
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		ds.setDriverClassName(props.getProperty("DRIVER_CLASS"));
		ds.setUrl(props.getProperty("URL"));
		ds.setUsername(props.getProperty("USERNAME"));
		ds.setPassword(props.getProperty("PASSWORD"));
		
		return  ds;
	}
	
}

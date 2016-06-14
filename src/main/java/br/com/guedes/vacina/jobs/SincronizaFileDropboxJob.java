package br.com.guedes.vacina.jobs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Locale;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dropbox.core.DbxAppInfo;
import com.dropbox.core.DbxAuthFinish;
import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWebAuthNoRedirect;
import com.dropbox.core.DbxWriteMode;

public class SincronizaFileDropboxJob implements Job {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SincronizaFileDropboxJob.class); 

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("SincronizaFileDropboxJob execute...");
		LOGGER.info("SincronizaFileDropboxJob execute...");
		
		// Dropbox app: Vacinas
		// App key: povlu27xgsenyag
		// App secret: 8bdvparzf739egx
		
		String key = "povlu27xgsenyag";
		String secret = "8bdvparzf739egx";
		
		try {
			DbxAppInfo appInfo = new DbxAppInfo(key, secret);
			
			DbxRequestConfig requestConfig = new DbxRequestConfig("JavaTutorial/1.0", Locale.getDefault().toString());
			DbxWebAuthNoRedirect authNoRedirect = new DbxWebAuthNoRedirect(requestConfig, appInfo);
			
//			String authorizeUrl = authNoRedirect.start();
//	        System.out.println("1. Go to: " + authorizeUrl);
//	        System.out.println("2. Click \"Allow\" (you might have to log in first)");
//	        System.out.println("3. Copy the authorization code.");
//	        String code = new BufferedReader(new InputStreamReader(System.in)).readLine();

//	        DbxAuthFinish authFinish = authNoRedirect.finish("kMY8QDuZDQgAAAAAAAAWV17UvrwtatdXDU6Hcbp7gOYpb8cy2BuV_wi3gcR1MWwy");
//	        String accessToken = authFinish.accessToken;

	        DbxClient client = new DbxClient(requestConfig, "kMY8QDuZDQgAAAAAAAAWV17UvrwtatdXDU6Hcbp7gOYpb8cy2BuV_wi3gcR1MWwy");
	        
	        System.out.println("Linked account: " + client.getAccountInfo().displayName);

	        File inputFile = new File("Template bootstrap.txt");
	        FileOutputStream inputStream = new FileOutputStream(inputFile);
	        
//	        DropboxAPI.DropboxFileInfo info = mApi.getFile(mFilePath, null, outputStream, null);
	        
	        DbxEntry.File uploadedFile = client.getFile("/Template bootstrap.txt", null, inputStream);//uploadFile("/Template bootstrap.txt",
//	                DbxWriteMode.add(), inputFile.length(), inputStream);
	            System.out.println("Uploaded: " + uploadedFile.toString());
	            
	            inputStream.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

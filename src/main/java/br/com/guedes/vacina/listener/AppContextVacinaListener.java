package br.com.guedes.vacina.listener;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firebase.client.Firebase;

import br.com.guedes.vacina.jobs.BackupDataBaseJob;
import br.com.guedes.vacina.jobs.SincronizaFileDropboxJob;

public class AppContextVacinaListener implements ServletContextListener {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AppContextVacinaListener.class);
	
	private final int TAMANHO_BUFFER = 12048;
	private byte[] dados = new byte[TAMANHO_BUFFER];
	private int cont;

	public void contextDestroyed(ServletContextEvent arg0) {
		
	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {
//			Firebase myFirebaseRef = new Firebase("https://vacinas-e9cc2.firebaseio.com/");

			
			
			
			// ******** Dropbox *************
//			// inicializando os agendamentos.
//			System.out.println("contextInitialized...");
//			LOGGER.info("LOGGER -contextInitialized ");
//
//			
//			JobDetail jobDetail = (JobDetail) JobBuilder
//					.newJob(SincronizaFileDropboxJob.class)
//					.withIdentity("SincronizaFileDropboxJob", "DropboxJob")
//					.build();
//			
//			Trigger trigger = TriggerBuilder
//					.newTrigger()
//					.withIdentity("dummyTriggerName", "DropboxJob")
////					.startNow()
////					.startAt(DateBuilder.todayAt(10, 20, 20)) // indicar a hora de execução...
//					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
//							.withIntervalInSeconds(2) // a cada dois segundos...
//							//.repeatForever() // executar sempre
//							.withRepeatCount(1)) 
//					
//					.build();
//			
//			SchedulerFactory shFactory = new StdSchedulerFactory();
//			Scheduler scheduler = shFactory.getScheduler();
//			
//			scheduler.scheduleJob(jobDetail, trigger);
//			scheduler.start();
			
			
			
			
			
			
//			System.out.println("Agendando o backup da base de dados...");
//			
//			// ******** Backup *************
//			// inicializando os agendamentos.
//			JobDetail jobDetail = (JobDetail) JobBuilder
//					.newJob(BackupDataBaseJob.class)
//					.withIdentity("BackupDataBaseJob", "BackupDataBase")
//					.build();
//			
//			Trigger trigger = TriggerBuilder
//					.newTrigger()
//					.withIdentity("dummyTriggerName", "BackupDataBase")
////					.startNow()
//					.startAt(DateBuilder.todayAt(10, 9, 00)) // indicar a hora de execução...
//					.withSchedule(SimpleScheduleBuilder.simpleSchedule()
//							.withIntervalInSeconds(1) // a cada dois segundos...
//							.repeatForever() // executar sempre
//							.withRepeatCount(1)) 
//					
//					.build();
//			
//			SchedulerFactory shFactory = new StdSchedulerFactory();
//			Scheduler scheduler = shFactory.getScheduler();
//			
//			scheduler.scheduleJob(jobDetail, trigger);
//			scheduler.start();
//			
//			System.out.println("SUCESSO no agendamento!!!!");
			
			
			// zipando o arquivo.
			FileOutputStream destino = new FileOutputStream("\\Users\\andrelessaguedes\\Documentos\\backup.zip");
			ZipOutputStream saida = new ZipOutputStream(new BufferedOutputStream(destino));
			FileInputStream streamDeEntrada = new FileInputStream(new File("\\Users\\andrelessaguedes\\Documentos\\backup.sql"));
			BufferedInputStream origem = new BufferedInputStream(streamDeEntrada, TAMANHO_BUFFER);
			ZipEntry entry = new ZipEntry("backup.sql");
			saida.putNextEntry(entry);
			while((cont = origem.read(dados, 0, TAMANHO_BUFFER)) != -1) {   
	            saida.write(dados, 0, cont);   
	        }
			saida.close();
	        origem.close();
	        
	     // preparando o email
	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.host", "smtp.live.com");
	        properties.put("mail.smtp.port", "443");
	        properties.put("mail.smtp.debug", "true");
//	        properties.put("mail.smtp.ssl.enable", "true");
	        
	          Authenticator authenticator = new Authenticator () {
	                public PasswordAuthentication getPasswordAuthentication(){
	                    return new PasswordAuthentication("sistema.vacina@outlook.com", "cxt@12345");
	                }
	            };

	            Session session = Session.getDefaultInstance( properties , authenticator); 
	            session.setDebug(true);
	        
			// configurando o email
//	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
//	        	protected PasswordAuthentication getPasswordAuthentication() {
//	        		return new PasswordAuthentication("sistema.vacina@outlook.com", "cxt@12345");
//	      		}
//	        });
	        // arquivo em anexo.
	        MimeBodyPart anexoBody = new MimeBodyPart();
	        FileDataSource fds = new FileDataSource("\\Users\\andrelessaguedes\\Documentos\\backup.sql");
	        anexoBody.setDataHandler(new DataHandler(fds));
	        anexoBody.setFileName(fds.getName());
	        
	        Multipart multipart = new MimeMultipart();  
	        multipart.addBodyPart(anexoBody);  
	        // envio do email.
	        MimeMessage message = new MimeMessage(session);
	        message.setFrom(new InternetAddress("sistema.vacina@outlook.com"));
	        message.addRecipient(Message.RecipientType.TO,new InternetAddress("andre@wdev.com.br"));
	        message.setSubject("Backup - Vacinas");
	        message.setText("Arquivo em anexo...");
	        message.setContent(multipart);
	        Transport.send(message);
	        
	        
	        
			
//			File inputFile = new File("\\Users\\andrelessaguedes\\Documentos\\backup.zip");
//			
//			FileOutputStream fileOutputStream = new FileOutputStream("\\Users\\andrelessaguedes\\Documentos\\backup.sql");
//			ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
//			
//			ZipEntry zipEntry = new ZipEntry(inputFile.getName());
//			zipOutputStream.putNextEntry(zipEntry);
//			
//			FileInputStream fileInputStream = new FileInputStream(inputFile);
//			byte[] buf = new byte[1024];
//			int bytesRead;
//			
//			while ((bytesRead = fileInputStream.read(buf)) > 0) {
//				zipOutputStream.write(buf, 0, bytesRead);
//			}
//			
//			zipOutputStream.closeEntry();
//			zipOutputStream.close();
//			zipOutputStream.close();
			
		} catch (Exception e) {
			System.out.println("******* ERRO no agendamento: " + e);
		} finally {
			
		}
	}
}

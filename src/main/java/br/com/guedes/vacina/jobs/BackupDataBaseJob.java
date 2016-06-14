package br.com.guedes.vacina.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BackupDataBaseJob implements Job {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BackupDataBaseJob.class); 

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("Executando backup da base de dados...");
		LOGGER.info("Executando backup da base de dados...");
		
		try {
			
			String executeCmd = "mysqldump -u root -pguedes vacinas -r /home/guedes/Documentos/BackupVacinas.sql";

	        Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
	        int processComplete = runtimeProcess.waitFor();

	        if (processComplete == 0) {
	            System.out.println("Backup Complete");
	        } else {
	            System.out.println("Backup Failure");
	        }
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

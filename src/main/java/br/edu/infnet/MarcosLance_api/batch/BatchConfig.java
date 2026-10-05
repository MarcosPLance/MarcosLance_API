package br.edu.infnet.MarcosLance_api.batch;

import org.springframework.batch.core.job.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.job.parameters.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.Step;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.infrastructure.item.ItemWriter;
import org.springframework.batch.infrastructure.item.file.FlatFileItemReader;
import org.springframework.batch.infrastructure.item.file.FlatFileItemWriter;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.infrastructure.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.infrastructure.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

import br.edu.infnet.MarcosLance_api.arq.trofeu.client.TrofeuClient;

public class BatchConfig {
	
	@Bean
	public FlatFileItemReader<TrofeuBatch> trofeuReader() {
		return new FlatFileItemReaderBuilder<TrofeuBatch>()
				.name("trofeuReader")
				.resource(new ClassPathResource("batch/trofeus.csv"))
				.linesToSkip(1)
				.delimited().delimiter(",")
				.names("id","nome","tipo")
				.targetType(TrofeuBatch.class)
				.build();
	}
	

	
	@Bean
	public FlatFileItemWriter<TrofeuBatch> trofeuWriter() {
		
		return new FlatFileItemWriterBuilder<TrofeuBatch>()
				.name("trofeuWriter")
				.resource(new FileSystemResource("target/trofeus-processados.csv"))
				.shouldDeleteIfExists(true)
				.headerCallback(write -> write.write("id;nome;tipo"))
				.delimited().delimiter(",")
				.names("id","nome","tipo")
				.build();
	}
	
	
	@Bean
	public ItemWriter<TrofeuRequest> trofeuApiWriter(TrofeuClient trofeuClient) {
		
		return chunk -> {
			for(TrofeuRequest trofeu : chunk.getItems())
				System.err.println("[trofeuApiWriter] Trofeu enviado para a api" + trofeu);
					trofeuClient.incluir(null);
		
		};
	}
	
	
	
	@Bean
	public Step importarTrofeusStep(
		
		JobRepository jobRepository,
		PlatformTransactionManager transactionManager,
		FlatFileItemReader<TrofeuBatch> trofeuReader,
		TrofeuProcessor trofeuProcessor,
		ItemWriter<TrofeuRequest> trofeuApiWriter
			){
		
		return new StepBuilder("importarTrofeuStep", jobRepository)
				.<TrofeuBatch, TrofeuRequest>chunk(3, transactionManager)
				.reader(trofeuReader)
				.processor(trofeuProcessor)
				.writer(trofeuApiWriter)
				.build();
	}
	
	
	public Step resumoProcessamentoStep(
			JobRepository jobRepository,
			PlatformTransactionManager transactionManager
			) {
			
		
		return new StepBuilder("resumoProcessamentoStep", jobRepository)
				.tasklet((contribution, chunkContext) -> {
					
					return RepeatStatus.FINISHED;
					}, transactionManager).build();
		}
	
	
	
	@Bean
	public Job importarTrofeuJob(
			JobRepository jobRepository,
			Step importarTrofeusStep
			) {
		
		return new JobBuilder("importarTrofeuJob", jobRepository)
				.incrementer(new RunIdIncrementer())
				.start(importarTrofeusStep)
				.build();
	}
	
	
}

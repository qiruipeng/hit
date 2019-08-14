package com.life.hits.springBatch.batch;

import com.life.hits.springBatch.vo.Person;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.MapJobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.support.transaction.ResourcelessTransactionManager;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;


/**
 * @author: qirp
 * @since: 2018/6/25 15:35
 **/
@Configurable
@EnableBatchProcessing
public class demoConfigration {

    @Bean
    public JobRepository jobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception{
        MapJobRepositoryFactoryBean jobRepositoryFactory = new MapJobRepositoryFactoryBean();
        jobRepositoryFactory.setTransactionManager(transactionManager);
        return jobRepositoryFactory.getObject();
    }

    @Bean
    public SimpleJobLauncher jobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception{
        SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
        jobLauncher.setJobRepository(this.jobRepository(dataSource, transactionManager));
        return jobLauncher;
    }

    @Bean
    public ResourcelessTransactionManager transactionManager(){
        ResourcelessTransactionManager transactionManager = new ResourcelessTransactionManager();
        return transactionManager;
    }

    @Bean
    public Step personStep(StepBuilderFactory stepBuilderFactory,
                           ItemReader<Person> reader, ItemWriter<Person> writer, ItemProcessor<Person, Person> processor){
        return stepBuilderFactory.get("personStep")
                .<Person, Person>chunk(5000) // 批处理每次提交5000条数据
                .reader(reader) // 给step绑定reader
                .processor(processor) // 给step绑定processor
                .writer(writer) // 给step绑定writer
                .build();
    }

}

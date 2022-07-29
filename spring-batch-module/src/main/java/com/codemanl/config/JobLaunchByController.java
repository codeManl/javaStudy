package com.codemanl.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class JobLaunchByController implements StepExecutionListener {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    private Map<String, JobParameter> jobParameters;

    @Bean
    public Step jobLaunchByControllerStep() {
        return stepBuilderFactory.get("JobLaunchByControllerStep")
                .tasklet(((contribution, chunkContext) -> {
                    System.out.println("step.... msg: " + jobParameters.get("msg").getValue());
                    return RepeatStatus.FINISHED;
                }))
                .listener(this)
                .build();
    }

    @Bean("JobLaunchByControllerJob")
    public Job jobLaunchByControllerJob() {
        return jobBuilderFactory.get("JobLaunchByControllerJob")
                .start(jobLaunchByControllerStep())
                .build();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        jobParameters = stepExecution.getJobParameters().getParameters();
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }
}

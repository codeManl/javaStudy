package com.codemanl.config;//package com.codemanl.config;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.JobLauncher;
//import org.springframework.batch.core.repository.JobRepository;
//import org.springframework.batch.core.step.builder.JobStepBuilder;
//import org.springframework.batch.core.step.builder.StepBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.transaction.PlatformTransactionManager;
//
///**
// * 多个Job嵌套，需要在配置文件中指定启动的Job
// */
//@Configuration
//public class EODJobLaunchDemo {
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private Job childJob1;
//
//    @Autowired
//    private Job childJob2;
//
//    @Autowired
//    private JobLauncher jobLauncher;
//
//    @Bean
//    public Job EODJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return jobBuilderFactory.get("EODJob")
//                .start(childJob1(jobRepository, transactionManager))
//                .next(childJob2(jobRepository, transactionManager))
//                .build();
//    }
//
//    public Step childJob1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new JobStepBuilder(new StepBuilder("childJob1"))
//                .job(childJob1)
//                .repository(jobRepository)
//                .transactionManager(transactionManager)
//                .launcher(jobLauncher)
//                .build();
//    }
//
//    public Step childJob2(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
//        return new JobStepBuilder(new StepBuilder("childJob2"))
//                .job(childJob2)
//                .repository(jobRepository)
//                .transactionManager(transactionManager)
//                .launcher(jobLauncher)
//                .build();
//    }
//}

package com.codemanl.decider;//package com.codemanl.decider;
//
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.StepExecution;
//import org.springframework.batch.core.job.flow.FlowExecutionStatus;
//import org.springframework.batch.core.job.flow.JobExecutionDecider;
///**
// * 自定义的决策器,创建了两个状态(自己创建的，不是内置),根据不同状态走不同step
// */
//public class MyDecider implements JobExecutionDecider {
//    private static int count = 0;
//
//    @Override
//    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
//        count++;
//        if (count % 2 == 0) {
//            return new FlowExecutionStatus("even");
//        } else {
//            return new FlowExecutionStatus("odd");
//        }
//
//    }
//
//}

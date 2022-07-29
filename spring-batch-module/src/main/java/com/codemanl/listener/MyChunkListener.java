package com.codemanl.listener;//package com.codemanl.listener;
//
//import org.springframework.batch.core.annotation.*;
//import org.springframework.batch.core.scope.context.ChunkContext;
//
///**
// * 注解的形式
// * 各个步骤都有对应注解
// */
//public class MyChunkListener {
//
//    @BeforeChunk
//    public void before(ChunkContext context) {
//        System.out.println(context.getStepContext().getStepName() + " chunk before execute");
//    }
//
//    @AfterChunk
//    public void after(ChunkContext context) {
//        System.out.println(context.getStepContext().getStepName() + " chunk after execute");
//    }
//}

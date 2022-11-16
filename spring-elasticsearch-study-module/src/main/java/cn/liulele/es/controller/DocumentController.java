package cn.liulele.es.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liulele
 * @description
 * @date 2022/9/18 0:12:12
 */
@RestController("/document")
public class DocumentController {
    @Operation(description = "测试")
    @PutMapping("/test")
    public String createDocument() {
        return  null;
    }

    @Operation(description = "测试")
    @PutMapping("/test2")
    public String createDocument2() {
        return  null;
    }
}

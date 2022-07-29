package entity;

import annotation.MyDateFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Parent {

    @MyDateFormat
    private String parentDate;
}

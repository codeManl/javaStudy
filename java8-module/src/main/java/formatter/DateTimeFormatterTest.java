package formatter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author liuele
 * @description
 * @date 2022/9/7 17:33:33
 */
public class DateTimeFormatterTest {

    public static DateTimeFormatter defaultDateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter simpleDateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    public static DateTimeFormatter defaultFormatterWithTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
//        System.out.println(defaultDateTimeFormatter.parse("2022-02-02"));
        LocalDate parse = LocalDate.parse("20220202", simpleDateTimeFormatter);
        System.out.println(parse);
        String format = parse.format(defaultDateTimeFormatter);
        System.out.println(format);

    }
}

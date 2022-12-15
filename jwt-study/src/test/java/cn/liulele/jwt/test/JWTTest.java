package cn.liulele.jwt.test;

import cn.liulele.jwt.entity.User;
import io.jsonwebtoken.*;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liulele
 * @description
 * @date 2022/12/6 19:43:43
 */
public class JWTTest {
    private static final String SECRET = "pwd=142857";

    @Test

    public void testCreateJwt() {

        User user = new User();
        user.setId(3L);
        user.setUserName("aaa");
        user.setPassword("bbb");
        Map<String, Object> map = new HashMap<>();
        map.put(user.getUserName(), user);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 10);
        Date date = calendar.getTime();
        String jwt = Jwts.builder()
                .setClaims(map)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setExpiration(date)
                .compact();
        System.out.println(jwt);

    }

    @Test
    public void testParseJwt() {
        String token = "eyJhbGciOiJIUzUxMiJ9.eyJhYWEiOnsiaWQiOjMsInVzZXJOYW1lIjoiYWFhIiwibmlja05hbWUiOm51bGwsInBhc3N3b3JkIjoiYmJiIiwic3RhdHVzIjpudWxsLCJlbWFpbCI6bnVsbCwicGhvbmVudW1iZXIiOm51bGwsInNleCI6bnVsbCwiYXZhdGFyIjpudWxsLCJ1c2VyVHlwZSI6bnVsbCwiY3JlYXRlQnkiOm51bGwsImNyZWF0ZVRpbWUiOm51bGwsInVwZGF0ZUJ5IjpudWxsLCJ1cGRhdGVUaW1lIjpudWxsLCJkZWxGbGFnIjpudWxsfSwiZXhwIjoxNjcwMzI5OTE0fQ.BbaMDv0cayJdJo9Eg8BJdvAAjmwVvqpoAU1I6uCMEhoLQWaRAyjIp4chSv63IXjczK-wf9mkPEdPsMgm5uPwWQ";
        Jws<Claims> jws = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
        Claims body = jws.getBody();

    }

}

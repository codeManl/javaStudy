package cn.liulele.jwt.filter;

import cn.liulele.mybatis.redis.service.RedisService;
import cn.liulele.jwt.entity.User;
import cn.liulele.jwt.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * @author liulele
 * @description
 * @date 2022/12/7 15:20:20
 */
@Component
@Slf4j
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private RedisService redisService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = (String) request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            filterChain.doFilter(request, response);
            return;
        }
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            log.error("jwt获取数据出错,错误原因:[{}]", e.getMessage());
            throw new RuntimeException(e);
        }

        User user  = redisService.getCacheObject(userId);

        if (Objects.isNull(user)) {
            log.error("用户未登录");
            throw new RuntimeException("用户未登录");
        }


        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, null);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        // 放行
        filterChain.doFilter(request, response);

    }
}

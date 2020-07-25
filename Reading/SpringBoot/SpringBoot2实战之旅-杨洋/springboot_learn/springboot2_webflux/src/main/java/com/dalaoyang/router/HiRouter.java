package com.dalaoyang.router;

        import com.dalaoyang.handler.HiHandler;
        import org.springframework.context.annotation.Bean;
        import org.springframework.context.annotation.Configuration;
        import org.springframework.http.MediaType;
        import org.springframework.web.reactive.function.server.RequestPredicates;
        import org.springframework.web.reactive.function.server.RouterFunction;
        import org.springframework.web.reactive.function.server.RouterFunctions;
        import org.springframework.web.reactive.function.server.ServerResponse;
/**
 * @author dalaoyang
 * @project springboot_learn
 * @package com.dalaoyang.router
 * @email yangyang@dalaoyang.cn
 * @date 2018/7/30
 */
@Configuration
public class HiRouter {
    @Bean
    public RouterFunction<ServerResponse> routeCity(HiHandler hiHandler) {
        return RouterFunctions
                .route(RequestPredicates.GET("/hi")
                                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                        hiHandler::Hi);
    }
}

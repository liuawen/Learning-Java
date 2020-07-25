package com.dalaoyang.handle;

import com.dalaoyang.model.User;
import com.dalaoyang.repository.UserRepository;
import com.dalaoyang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.handle
 * @email yangyang@dalaoyang.cn
 * @date 2018/9/1
 */
@Component
public class UserHandle {
    @Autowired
    private UserService userService;


    public Mono<ServerResponse> listPeople(ServerRequest request) {
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(userService.allUser(), User.class);
    }

    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<User> user = request.bodyToMono(User.class);
        return ServerResponse.ok().build(userService.saveUser(user));
    }

    public Mono<ServerResponse> getUser(ServerRequest request) {
        Long userid = Long.valueOf(request.pathVariable("id"));
        return userService.getUser(userid)
                .flatMap(person -> ServerResponse.ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(ServerResponse.notFound().build());
       // return ServerResponse.ok().contentType(APPLICATION_JSON).body(userService.getUser(userid), User.class);

    }
}

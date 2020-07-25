package com.springboot.handler;

import com.springboot.entity.UserInfo;
import com.springboot.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class UserHandler {

    private final UserRepository repository;

    public UserHandler(UserRepository repository) {
        this.repository = repository;
    }

    //http://localhost:8080/saveUser
    public Mono<ServerResponse> saveUser(ServerRequest request) {
        Mono<UserInfo> user = request.bodyToMono(UserInfo.class);
        return ServerResponse.ok().build(repository.insert(user).then());
    }

    //http://localhost:8080/deleteUser/1
    public Mono<ServerResponse> deleteUser(ServerRequest request) {
        Long userId = Long.valueOf(request.pathVariable("id"));
        return ServerResponse.ok().build(repository.deleteById(userId).then());
    }

    //http://localhost:8080/user/1
    public Mono<ServerResponse> getUser(ServerRequest request) {
        Long userId = Long.valueOf(request.pathVariable("id"));
        Mono<UserInfo> userInfo = repository.findById(userId);
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(userInfo, UserInfo.class);
    }

    //http://localhost:8080/listUser
    public Mono<ServerResponse> listUser(ServerRequest request) {
        Flux<UserInfo> userList = repository.findAll();
        return ServerResponse.ok().contentType(APPLICATION_JSON).body(userList, UserInfo.class);
    }

}

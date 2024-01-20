package com.turing.mongo.demo.service;
import com.turing.mongo.demo.dto.*;

import reactor.core.publisher.Mono;
public interface TodoService {
	Mono<TodoDto> getTodoById(String todoId);
}

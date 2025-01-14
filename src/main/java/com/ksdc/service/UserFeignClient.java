package com.ksdc.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ksdc.dto.User;

@FeignClient(name = "USER-SERVICE",path = "/api/users")
public interface UserFeignClient {
	@GetMapping("/{userId}")
    User getUserById(@PathVariable("userId") int userId);

    @PostMapping("/validate")
    boolean validateUser(@RequestBody User user);
}

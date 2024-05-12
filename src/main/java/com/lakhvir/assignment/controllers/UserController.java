package com.lakhvir.assignment.controllers;

import com.lakhvir.assignment.dto.UserDTO;
import com.lakhvir.assignment.models.UpdateRequest;
import com.lakhvir.assignment.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/get-all")
    public ResponseEntity<List<UserDTO>> getUsers(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) Integer pageSize
    ){
        Pageable p = PageRequest.of(pageNumber,pageSize, Sort.by("id").ascending());
        return ResponseEntity.ok(service.findAll(p));
    }

    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(
            @RequestBody UpdateRequest request
    ){
        return ResponseEntity.ok(service.updateUser(request));
    }
}

package com.lakhvir.assignment.services;

import com.lakhvir.assignment.dto.UserDTO;
import com.lakhvir.assignment.models.UpdateRequest;
import com.lakhvir.assignment.models.User;
import com.lakhvir.assignment.models.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public List<UserDTO> findAll(Pageable p) {
        List<User> users = repository.findAll(p).getContent();
        return users.stream()
                .map(user -> new UserDTO(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserDTO updateUser(UpdateRequest request) {
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();

        user.setName(request.getName());
        user.setProfileImage(request.getProfileImage());
        user.setUpdatedAt(LocalDateTime.now());
        User updatedUser = repository.save(user);
        return new UserDTO(updatedUser.getName(), updatedUser.getEmail());
    }
}

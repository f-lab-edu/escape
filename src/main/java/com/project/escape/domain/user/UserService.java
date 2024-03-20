package com.project.escape.domain.user;

import com.project.escape.global.utils.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public UserResponse me(Long id) {
        return UserResponse.of(userRepository.findById(id)
                .orElseThrow(ResponseFactory::notFound));
    }
}

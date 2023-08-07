package lt.neskelbiu.java.main.user;

import lombok.RequiredArgsConstructor;
import lt.neskelbiu.java.main.exceptions.UserNotFoundException;
import lt.neskelbiu.java.main.poster.PosterResponse;
import lt.neskelbiu.java.main.posterImg.PosterImg;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public List<UserResponse> getResponseAllUsers(List<User> userList) {
        List<UserResponse> responseList = userList.stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .username(user.getUsername())
                        .firstname(user.getFirstname())
                        .lastname(user.getLastname())
                        .email(user.getEmail())
                        .role(user.getRole())
                        .build())
                .toList();
        return responseList;
    }

    public String changeUserLockdownState(Long userId) {
        User user = findById(userId);
        user.setNotLocked(!user.isNotLocked());
        userRepository.save(user);
        return user.isNotLocked() ? "unlocked" : "locked";
    }
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public User findById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found by id:" + userId));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User with such username not found:" + username));
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User with such email not found:" + email));
    }
}
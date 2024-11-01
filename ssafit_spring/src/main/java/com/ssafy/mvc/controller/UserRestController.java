package com.ssafy.mvc.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.mvc.model.dto.UserDto;
import com.ssafy.mvc.model.service.UserService;

import jakarta.servlet.http.HttpSession;
@RestController
@RequestMapping("/api/user")
public class UserRestController {
    private final UserService service;

    public UserRestController(UserService userService) {
        this.service = userService;
    }

    // 사용자 프로필 조회 (ID로)
    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable int userId) {
        UserDto user = service.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // 새 사용자 등록(회원가입)
    @PostMapping()
    public ResponseEntity<Void> registUser(@ModelAttribute UserDto userDto) {
        service.registerUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 사용자 정보 업데이트
    @PutMapping("/{userId}")
    public ResponseEntity<Void> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        userDto.setId(id);
        service.modifyUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // 사용자 삭제
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        service.removeUser(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

    // 로그인 
    @PostMapping("/login")
    public ResponseEntity<?> login(@ModelAttribute UserDto user, HttpSession session) {
        List<UserDto> list = service.getList();

        for(UserDto u : list){
            if( session.getAttribute("loginUser") == null && u.getId().equals(user.getId()) && u.getPassword().equals(user.getPassword())){
                session.setAttribute("loginUser", u);
                System.out.println("login");
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }

                System.out.println("no");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
		if (session != null && session.getAttribute("loginUser") != null) {
		    session.invalidate();
		    return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}

package com.devsuperior.dslearnbds.resources;

import com.devsuperior.dslearnbds.dto.UserDTO;
import com.devsuperior.dslearnbds.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@RestController
@RequestMapping(value = "/users")
public class UserResource implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findProductById(@PathVariable Long id) {
        UserDTO dto = userService.findUserById(id);
        return ResponseEntity.ok().body(dto);

    }

}

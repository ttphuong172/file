package com.example.be.controller;




import com.example.be.config.JwtUtil;
import com.example.be.config.MyUserDetailsService;
import com.example.be.model.ERole;
import com.example.be.model.dto.JwtRequest;
import com.example.be.model.dto.JwtResponse;
import com.example.be.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private AccountService accountService;

    @PostMapping("/signin")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        String token = null;
        String username = null;
        ERole role = null;
        UserDetails userDetails;
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));
        } catch (DisabledException e) {
//            return new JwtResponse(token, username,role,"Account disabled !");
            return new JwtResponse(token,username);
        } catch (BadCredentialsException e) {
//            return new JwtResponse(token, username,role,"Username or password is incorrect !");
            return new JwtResponse(token,username);
        }

        userDetails = myUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
        token = jwtUtil.generateToken(userDetails);
        username = jwtRequest.getUsername();
        role = accountService.findById(jwtRequest.getUsername()).getRole();
//        return new JwtResponse(token, username, role,"Login succesfull");
        return new JwtResponse(token,username);
    }
}

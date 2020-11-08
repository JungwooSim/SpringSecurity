package me.security.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.sql.SQLOutput;

@Controller
public class UserController {

//    @Autowired
//    private UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

//    @Autowired
//    private RoleRepository roleRepository;

    @GetMapping(value="/users")
    public String createUser() throws Exception {

        return "user/login/register";
    }

//    @PostMapping(value="/users")
//    public String createUser(AccountDto accountDto) throws Exception {
//
//        ModelMapper modelMapper = new ModelMapper();
//        Account account = modelMapper.map(accountDto, Account.class);
//        account.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//
//        userService.createUser(account);
//
//        return "redirect:/";
//    }

//    @AuthenticationPrincipal Account account, Authentication authentication, Principal principal
    @GetMapping(value="/mypage")
    public String myPage() {
        System.out.println("okok");
        return "user/mypage";
    }

//    @GetMapping("/order")
//    public String order(){
//        userService.order();
//        return "user/mypage";
//    }
}

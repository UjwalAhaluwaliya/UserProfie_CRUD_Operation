package UserDetails.Controller;

import UserDetails.Model.UserDetails;
import UserDetails.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;


@Controller

public class UserController {
    @Autowired
    private UserService us;

    @GetMapping("/")
    public String home(Model model) {
        List<UserDetails> allUsers = us.findAll(); // You'll need to add this method to your service
        model.addAttribute("allUsers", allUsers);
        return "home";
    }


    @GetMapping("/register")
    public String userreg() {
        return "register";
    }

    @PostMapping("/register")
    public String UserDetails(UserDetails ud, Model model) {
        if (!ud.getPassword().equals(ud.getConfirmpassword())) {
            model.addAttribute("error", "Passwords do not match");
            System.out.println("Model attributes: " + model.asMap());  // This will print all attributes
            return "register";

        }
        us.save(ud);
        return "login";


    }

    @GetMapping("/login")
    public String userlog() {
        return "login";
    }

    @PostMapping("/login")
    public String Userlogin(UserDetails ud, Model model) {
        List<UserDetails> users = us.findByUsernameAndPassword(ud);
        if (!users.isEmpty()) {
            // User found - successful login
            UserDetails loggedInUser = users.get(0);
            model.addAttribute("userDetails", loggedInUser);
            List<UserDetails> allUsers = us.findAll();
            model.addAttribute("allUsers", allUsers);
            return "home";


        } else {
            // User not found - login failed
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
    @GetMapping("/update")
    public String ShowUpdateForm(@RequestParam("uid")int uid,Model model){
        Optional<UserDetails>user=us.findById(uid);
       if(user.isPresent()) {
           model.addAttribute("user", user.get());

           return "update";
       }
       else{
           return "redirect:/";
       }
    }
    @PostMapping("/update")
    public String UpdateUserDetails(UserDetails ud,Model model){
        us.save(ud);
        return "home";
    }
    @PostMapping("/delete")
    public String DeleteUserDetails(@RequestParam("uid")int uid,Model model){
        us.deleteById(uid);
        return "redirect:/";
    }

    }




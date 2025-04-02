package th.ac.mahidol.ict.gemini.controller;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import th.ac.mahidol.ict.gemini.model.*;
import th.ac.mahidol.ict.gemini.repository.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private AstronomerRepository astronomerRepository;

    @Autowired
    private ScienceObserverRepository observerRepository;

    @GetMapping("/")
    public String authenPage() {
        return "authen";
    }

    @GetMapping("/login/astronomer")
    public String loginAstronomerPage() {
        return "login_astronomer";
    }

    @GetMapping("/login/observer")
    public String loginObserverPage() {
        return "login_observer";
    }

    @GetMapping("/signup/astronomer")
    public String signupAstronomerPage() {
        return "signup_astronomer";
    }

    @GetMapping("/signup/observer")
    public String signupObserverPage() {
        return "signup_observer";
    }

    @PostMapping("/signup/astronomer")
    public String processSignupAstronomer(@ModelAttribute Astronomer astronomer, RedirectAttributes redirectAttributes) {
        astronomerRepository.save(astronomer);
        redirectAttributes.addFlashAttribute("message", "Sign up Success! Please, Log in again!");
        return "redirect:/login/astronomer";
    }

    @PostMapping("auth/signup/astronomer")
    public String successSignupAstronomer(@ModelAttribute Astronomer astronomer, RedirectAttributes redirectAttributes) {
        astronomerRepository.save(astronomer);
        redirectAttributes.addFlashAttribute("message", "Sign up Success! Please, Log in again!");
        return "redirect:/login/astronomer";
    }

    @PostMapping("/auth/signup/observer")
    public String processSignupObserver(@ModelAttribute ScienceObserver observer, RedirectAttributes redirectAttributes) {
        observerRepository.save(observer);
        redirectAttributes.addFlashAttribute("message", "Sign up Success! Please, Log in again!");
        return "redirect:/login/observer";
    }

    @PostMapping("/auth/login/astronomer")
    public String loginAstronomer(@ModelAttribute Astronomer user, Model model, RedirectAttributes redirectAttributes) {
        Astronomer dbUser = astronomerRepository.findByUsername(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("username", dbUser.getUsername());
            return "welcome";
        }
        redirectAttributes.addFlashAttribute("error", "User or Password incorrect");
        return "redirect:/login/astronomer";
    }

    @PostMapping("/auth/login/observer")
    public String loginObserver(@ModelAttribute ScienceObserver user, Model model, RedirectAttributes redirectAttributes) {
        ScienceObserver dbUser = observerRepository.findByUsername(user.getUsername());
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            model.addAttribute("username", dbUser.getUsername());
            return "welcome";
        }
        redirectAttributes.addFlashAttribute("error", "User or Password incorrect");
        return "redirect:/login/observer";
    }
}
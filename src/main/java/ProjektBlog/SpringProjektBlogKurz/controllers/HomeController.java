package ProjektBlog.SpringProjektBlogKurz.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    @GetMapping("/index")
    public String renderIndex() {
        return "pages/index";
    }

    @GetMapping("/contact")
    public String renderContact() {
        return "pages/contact";
    }

    @GetMapping("/references")
    public String renderReferences() {
        return "pages/references";
    }

    @GetMapping("/skills")
    public String renderSkills() {
        return "pages/skills";
    }
}

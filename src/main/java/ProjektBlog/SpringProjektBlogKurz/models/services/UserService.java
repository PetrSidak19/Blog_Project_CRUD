package ProjektBlog.SpringProjektBlogKurz.models.services;

import ProjektBlog.SpringProjektBlogKurz.models.DTO.UserDTO;
import jakarta.validation.Valid;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    void create(@Valid UserDTO user, boolean isAdmin);
}

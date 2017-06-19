package home.david.sfl.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Created by David on 6/16/2017.
 */

@Service
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public String findLoggedByUserName() {
        Object userDetalis = SecurityContextHolder.getContext().getAuthentication().getDetails();
        Object userDetalisRole = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetalis instanceof UserDetailsServiceImpl) {
            return ((UserDetails) userDetalis).getUsername();
        }
        return null;
    }
}

package poly.dn.huyndai.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import poly.dn.huyndai.Entity.Customer;
import poly.dn.huyndai.Service.CustomerService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final CustomerService customerService;
    private final PasswordEncoder passwordEncoder;

    @Autowired

    public CustomUserDetailsService(CustomerService customerService, PasswordEncoder passwordEncoder) {
        this.customerService = customerService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " +username));
        return User
                .withUsername(customer.getUsername())
                .password(passwordEncoder.encode(customer.getPassword()))
                .roles(customer.getAuthorities().stream().map(authority -> authority.getRole().getRoleId()).toArray(String[]::new))
                .build();
    }
}

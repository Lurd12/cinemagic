package com.lur.cinemagic;

import com.lur.cinemagic.dto.cinemauser.CinemaUserCreateDto;
import com.lur.cinemagic.dto.cinemauser.CinemaUserDetailsDto;
import com.lur.cinemagic.dto.cinemauser.CinemaUserUpdateDto;
import com.lur.cinemagic.model.CinemaUser;
import com.lur.cinemagic.repository.CinemaUserRepository;
import com.lur.cinemagic.service.CinemaUserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class UserServiceTest {
    @Mock
    CinemaUserRepository userRepository;
    @InjectMocks
    CinemaUserService userService;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
        userService.setPasswordEncoder(new BCryptPasswordEncoder());
    }


    @Test
    void getAllUsersTest(){
        when(userRepository.findAll()).thenReturn(List.of(new CinemaUser(), new CinemaUser(), new CinemaUser()));
        List<CinemaUserDetailsDto> cinemaUsers =userService.getAll();
        assertEquals(3, cinemaUsers.size());
    }

    @Test
    void getCurrentUser(){
        CinemaUser user = new CinemaUser();
        user.setId(1L);
        user.setUsername("lur");
        when(userRepository.findByUsername("lur")).thenReturn(Optional.of(user));
        SecurityContextHolder.getContext().setAuthentication(new Authentication() {
            @Override
            public Collection<? extends GrantedAuthority> getAuthorities() {
                return List.of();
            }

            @Override
            public Object getCredentials() {
                return null;
            }

            @Override
            public Object getDetails() {
                return null;
            }

            @Override
            public Object getPrincipal() {
                return null;
            }

            @Override
            public boolean isAuthenticated() {
                return false;
            }

            @Override
            public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {

            }

            @Override
            public String getName() {
                return "lur";
            }
        });

        CinemaUser u = userService.getCurrentUser();
        assertEquals(user, u);
    }


    @Test
    void registerUserTest(){
        CinemaUser cinemaUser = new CinemaUser();
        cinemaUser.setId(1L);
        cinemaUser.setUsername("lur");
        cinemaUser.setPassword(new BCryptPasswordEncoder().encode("lur"));
        cinemaUser.setRole("USER");
        when(userRepository.save(any(CinemaUser.class)))
                .thenReturn(cinemaUser);
        when(userRepository.existsByUsername("lur")).thenReturn(false);

        CinemaUserCreateDto cinemaUserCreateDto = new CinemaUserUpdateDto();
        cinemaUserCreateDto.setPassword("lur");
        cinemaUserCreateDto.setUsername("lur");

        CinemaUserDetailsDto cinemaUserDetailsDto = userService.register(cinemaUserCreateDto);

        assertEquals(cinemaUserDetailsDto, CinemaUserDetailsDto.getCinemaUserDetailsDtoFromUser(cinemaUser));

    }




}

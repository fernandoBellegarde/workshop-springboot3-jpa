package com.educandoweb.course.config;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Leticia Pink", "leticia@gmail.com", "966666666", "123456");
        User u4 = new User(null, "Allan Grey", "allan@gmail.com", "955555555", "123456");
        User u5 = new User(null, "Joseph Blue", "joseph@gmail.com", "944444444", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
        Order o4 = new Order(null, Instant.parse("2019-07-23T10:10:33Z"), u3);
        Order o5 = new Order(null, Instant.parse("2006-10-02T23:06:06Z"), u3);
        Order o6 = new Order(null, Instant.parse("2019-07-24T10:10:33Z"), u4);

        userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6));
    }
}

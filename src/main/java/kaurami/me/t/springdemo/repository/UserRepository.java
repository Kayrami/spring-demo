package kaurami.me.t.springdemo.repository;

import kaurami.me.t.springdemo.tacos.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}

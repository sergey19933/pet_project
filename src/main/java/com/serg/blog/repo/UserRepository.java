package com.serg.blog.repo;

import com.serg.blog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
User findByUsername(String username);
}

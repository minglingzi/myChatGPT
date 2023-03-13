package com.example.repository;

import com.example.beans.User;
import io.micronaut.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}

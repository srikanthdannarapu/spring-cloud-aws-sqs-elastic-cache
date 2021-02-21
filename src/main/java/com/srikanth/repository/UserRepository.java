package com.srikanth.repository;

import com.srikanth.model.User;

import java.util.Map;

public interface UserRepository {

  void save(User user);
  Map<Integer, User> findAll();
  User findById(Integer id);
  void update(User user);
  void delete(Integer id);
}

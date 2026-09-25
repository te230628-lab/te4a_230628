package com.example.spring_di_exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  
  // @Autowiredで自動注入
  @Autowired
  private UserRepository userRepository;

  /**
   * ユーザーを取得
   */
  public User getUser(Long id) {
    User user = userRepository.findById(id);
    if (user == null) {
      throw new RuntimeException("ユーザーが見つかりません：ID=" + id);
    }
    return user;
  }

  /**
   * ユーザーを更新
   */
  public void updateUser(User user) {
    if (user.getId() == null) {
      throw new RuntimeException("ユーザーIDが指定されていません");
    }
    userRepository.save(user);
  }

  /**
   * ユーザーを作成
   */
  public void createUser(String name, String email) {
    // 新しいIDを生成
    Long newId = userRepository.findAll().keySet().stream()
            .max(Long::compare)
            .orElse(0L) + 1;
    
    User user = new User(newId, name, email);
    userRepository.save(user);
  }
}
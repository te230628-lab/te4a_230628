package com.example.spring_thymeleaf_exercise;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
  
  // インメモリストレージ
  private List<User> users = new ArrayList<>();
  private Long nextId = 1L;

  public UserService() {
    // 初期データ
    users.add(new User(nextId++, "東北 太郎", "taro@example.com", "第1部門"));
    users.add(new User(nextId++, "東北 花子", "hanako@example.com", "第2部門"));
  }

  /**
   * すべてのユーザーを取得
   */
  public List<User> getAllUsers() {
    return users;
  }

  /**
   * 新しいユーザーを追加
   */
  public void addUser(UserForm form) {
    if (form.getName() == null || form.getName().isEmpty()) {
      throw new RuntimeException("名前を入力してください");
    }
    User user = new User(nextId++, form.getName(), form.getEmail(), form.getDepartment());
    users.add(user);
  }

  /**
   * ユーザーを削除
   */
  public void deleteUser(Long id) {
    users.removeIf(user -> user.getId().equals(id));
  }
}
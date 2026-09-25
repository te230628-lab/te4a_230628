package com.example.spring_di_exercise;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
  
  // インメモリストレージ（DBの代わり）
  private Map<Long, User> users = new HashMap<>();

  public UserRepository() {
    // 初期データを設定
    users.put(1L, new User(1L, "太郎", "taro@example.com"));
    users.put(2L, new User(2L, "花子", "hanako@example.com"));
    users.put(3L, new User(3L, "次郎", "jiro@example.com"));
  }

  /**
   * IDでユーザーを検索
   */
  public User findById(Long id) {
    return users.get(id);
  }

  /**
   * ユーザーを保存
   */
  public void save(User user) {
    users.put(user.getId(), user);
  }

  /**
   * すべてのユーザーを取得
   */
  public Map<Long, User> findAll() {
    return users;
  }
}
package com.example.spring_thymeleaf_exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
  
  @Autowired
  private UserService userService;

  /**
   * メイン画面（登録フォームと一覧表示）
   */
  @GetMapping("/")
  public String showUsers(Model model) {
    model.addAttribute("userForm", new UserForm());
    model.addAttribute("users", userService.getAllUsers());
    return "users";
  }

  /**
   * ユーザー登録処理
   */
  @PostMapping("/add")
  public String addUser(@ModelAttribute UserForm form, Model model) {
    try {
      userService.addUser(form);
    } catch (RuntimeException e) {
      model.addAttribute("error", e.getMessage());
    }
    model.addAttribute("userForm", new UserForm());
    model.addAttribute("users", userService.getAllUsers());
    return "users";
  }

  /**
   * ユーザー削除処理
   */
  @GetMapping("/delete/{id}")
  public String deleteUser(@PathVariable Long id) {
    userService.deleteUser(id);
    return "redirect:/";
  }
}
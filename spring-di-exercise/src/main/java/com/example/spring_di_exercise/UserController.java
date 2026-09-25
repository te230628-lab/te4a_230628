package com.example.spring_di_exercise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
  
  // @Autowiredでサービスを自動注入
  @Autowired
  private UserService userService;

  /**
   * 入力画面を表示
   */
  @GetMapping("/")
  public String showForm(Model model) {
    model.addAttribute("userForm", new UserForm());
    return "form";
  }

  /**
   * フォーム送信を処理
   */
  @PostMapping("/submit")
  public String submitForm(@ModelAttribute UserForm form, Model model) {
    try {
      // ServiceのgetUserメソッドを呼び出し
      User user = userService.getUser(form.getId());
      model.addAttribute("user", user);
      return "result";
    } catch (RuntimeException e) {
      model.addAttribute("error", e.getMessage());
      return "error";
    }
  }

  /**
   * ユーザー作成画面を表示
   */
  @GetMapping("/create")
  public String showCreateForm(Model model) {
    model.addAttribute("userForm", new UserForm());
    return "create";
  }

  /**
   * ユーザー作成を処理
   */
  @PostMapping("/create")
  public String createUser(@ModelAttribute UserForm form, Model model) {
    try {
      userService.createUser(form.getName(), form.getEmail());
      model.addAttribute("message", "ユーザーを作成しました");
      return "success";
    } catch (RuntimeException e) {
      model.addAttribute("error", e.getMessage());
      return "error";
    }
  }
}
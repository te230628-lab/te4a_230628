package com.example.spring_mvc_exercise;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TextController {

    /**
     * 1ページ目を表示（入力フォーム）
     */
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userText", "");
        return "form";
    }

    /**
     * フォーム送信を処理し、2ページ目に遷移
     */
    @PostMapping("/submit")
    public String submitForm(@RequestParam("userText") String userText, Model model) {
        // ユーザーが入力したテキストをModelに追加
        model.addAttribute("userText", userText);
        // 2ページ目のテンプレートに遷移
        return "result";
    }
}
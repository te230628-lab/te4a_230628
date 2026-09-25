package com.example.rest_api_exercise;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloApiController {

    /**
     * GETリクエストで"Hello World"を返す
     */
    @GetMapping("/api/hello")
    public String getHello() {
        return "Hello World";
    }

    /**
     * GETリクエストでJSON形式でメッセージを返す
     */
    @GetMapping("/api/message")
    public Message getMessage() {
        return new Message("Hello World", "This is a REST API response");
    }

    /**
     * メッセージクラス（内部クラス）
     */
    public static class Message {
        private String title;
        private String content;

        public Message(String title, String content) {
            this.title = title;
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
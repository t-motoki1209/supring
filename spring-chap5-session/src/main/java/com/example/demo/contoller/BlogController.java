package com.example.demo.contoller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Account;
import com.example.demo.model.Post;
import com.example.demo.model.PostList;

@Controller
public class BlogController {
	@Autowired
	HttpSession session;

	@Autowired
	Account account;

	@Autowired
	PostList postList;

	@PostMapping("/login")
	public String login(@RequestParam(name = "name", defaultValue = "") String name,
			Model model) {
		account.setName(name);
		model.addAttribute("name", name);
		return "blog";
	}

	@GetMapping({ "/", "/logout" })
	public String index() {
		session.invalidate();//セッションの破棄
		return "login";
	}

	@PostMapping("/blog")
	public String post(@RequestParam("title") String title,
			@RequestParam("content") String content,

			Model model) {
		List<Post> allPosts = postList.getPosts();
		allPosts.add(new Post(title, content));
		return "blog";
	}

}

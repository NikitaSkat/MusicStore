package com.company.MusicStore.controllers;


import com.company.MusicStore.modules.Post;
import com.company.MusicStore.repo.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CatalogController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/catalog")
    public String catalogMain(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "catalog-main";
    }


    @GetMapping("/catalog/add")
    public String catalogAdd(Model model) {
        return "catalog-add";
    }

    @PostMapping("/catalog/add")
    public String catalogPostAdd(@RequestParam String name,@RequestParam String maker,@RequestParam String country,@RequestParam String prod_text,@RequestParam String prodcoast,@RequestParam String full_text, Model model){
        Post post = new Post(name,maker,country,prod_text,prodcoast,full_text);
        postRepository.save(post);
        return "redirect:/catalog";
    }

    @GetMapping("/catalog/{id}")
    public String catalogDetails(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/catalog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "catalog-details";
    }
    @GetMapping("/catalog/{id}/edit")
    public String catalogEdit(@PathVariable(value = "id") long id, Model model) {
        if(!postRepository.existsById(id)){
            return "redirect:/catalog";
        }
        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "catalog-edit";
    }
    @PostMapping("/catalog/{id}/edit")
    public String catalogPostUpdate(@PathVariable(value = "id") long id,@RequestParam String name,@RequestParam String maker,@RequestParam String country,@RequestParam String prod_text,@RequestParam String prodcoast,@RequestParam String full_text, Model model){
        Post post = postRepository.findById(id).<RuntimeException>orElseThrow(()->{;
        throw new AssertionError();});
        post.setName(name);
        post.setMaker(maker);
        post.setCountry(country);
        post.setProd_text(prod_text);
        post.setCoast(prodcoast);
        post.setFull_text(full_text);
        postRepository.save(post);
        return "redirect:/catalog";
    }
    @PostMapping("/catalog/{id}/remove")
    public String catalogPostDelete(@PathVariable(value = "id") long id, Model model){
        Post post = postRepository.findById(id).orElseThrow(IllegalStateException::new);
        postRepository.delete(post);
        return "redirect:/catalog";
    }

}

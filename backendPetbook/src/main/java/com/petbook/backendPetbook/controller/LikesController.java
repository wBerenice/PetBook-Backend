package com.petbook.backendPetbook.controller;

import com.petbook.backendPetbook.models.Likes;
import com.petbook.backendPetbook.service.LikesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/likes/")
public class LikesController {
    private final LikesService likesService;
    @Autowired
    public LikesController(LikesService likesService) {
        this.likesService = likesService;
    }//constructor

    @GetMapping
    public List<Likes> getAllLikes(){
        return likesService.getAllLikes();
    }//getAll

    @GetMapping(path="{likeId}")
    public Likes getLike(@PathVariable("likeId") Long id){
        return likesService.getLikes(id);
    }//getLike

    @DeleteMapping(path="{likeId}")
    public Likes deleteLike(@PathVariable("likeId") Long id){
        return likesService.deleteLikes(id);
    }//deleteLike

    @PostMapping
    public Likes addLike(@RequestBody Likes likes){
        return likesService.addLikes(likes);
    }//addLikes

    @PutMapping(path="{likeId}")
    public Likes updateLike(@PathVariable("likeId") Long id,
                            Long id_usuario,
                            Long id_publicaciones){
        return likesService.updateLikes(id,id_usuario,id_publicaciones);
    }//updateLike



}

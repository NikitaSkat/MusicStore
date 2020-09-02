package com.company.MusicStore.repo;

import com.company.MusicStore.modules.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
}

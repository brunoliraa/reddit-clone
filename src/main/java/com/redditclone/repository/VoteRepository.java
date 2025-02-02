package com.redditclone.repository;

import com.redditclone.model.Post;
import com.redditclone.model.User;
import com.redditclone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepository extends JpaRepository<Vote, Long> {
    //encontra o voto mais recente, do usuario naquele post
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}

package com.redditclone.service;

import com.redditclone.dto.SubredditDto;
import com.redditclone.exception.SpringRedditException;
import com.redditclone.mapper.SubredditMapper;
import com.redditclone.model.Subreddit;
import com.redditclone.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {

    private final SubredditRepository subredditRepository;
//    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
//        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        Subreddit save = subredditRepository.save(mapSubRedditDto(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(this::mapToDto)
//                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

//    public SubredditDto getSubreddit(Long id) {
//        Subreddit subreddit = subredditRepository.findById(id)
//                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
//        return subredditMapper.mapSubredditToDto(subreddit);
//    }

    private Subreddit mapSubRedditDto(SubredditDto subredditDto){
        return Subreddit.builder().name(subredditDto.getName())
                .description(subredditDto.getDescription())
                .build();
    }

    //método usado tbm para mapear
    private SubredditDto mapToDto(Subreddit subreddit){
        return SubredditDto.builder()
                .name(subreddit.getName())
                .id(subreddit.getId())
                .numberOfPosts(subreddit.getPosts().size())
                .build();
    }
}

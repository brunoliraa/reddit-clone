package com.redditclone.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthenticationResponse {
    //contém as informações de resposta, quando o usuário loga no sistema
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String username;
}

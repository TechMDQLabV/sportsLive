package com.garguir.sportsLive.utils;

import com.garguir.sportsLive.models.BasketballGame;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SportsResponse {
    private List<BasketballGame> matches;
}

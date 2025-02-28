package com.main.dota2;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Player {
    @JsonProperty("profile")  // Ссылка на профиль игрока
    private Profile profile;

    @JsonProperty("rank_tier")
    private Integer rankTier;

    @JsonProperty("leaderboard_rank")
    private Integer leaderboardRank;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Integer getRankTier() {
        return rankTier;
    }

    public void setRankTier(Integer rankTier) {
        this.rankTier = rankTier;
    }

    public Integer getLeaderboardRank() {
        return leaderboardRank;
    }

    public void setLeaderboardRank(Integer leaderboardRank) {
        this.leaderboardRank = leaderboardRank;
    }
}
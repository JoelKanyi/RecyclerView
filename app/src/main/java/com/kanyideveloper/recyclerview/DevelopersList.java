package com.kanyideveloper.recyclerview;

public class DevelopersList {

    private String details;
    private String image_url;
    private String github_url;

    public String getDetails() {
        return details;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getGithub_url() {
        return github_url;
    }

    public DevelopersList(String login, String gitUrl, String avatar_url) {
        this.details = login;
        this.image_url = avatar_url;
        this.github_url = gitUrl;
    }
}

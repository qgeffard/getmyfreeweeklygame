package org.team68.model;

public class User {

    private String discordId;
    private String login;
    private String password;

    public User(String discordId, String login, String password) {
        this.discordId = discordId;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    public String getDiscordId() {
        return discordId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setDiscordId(String discordId) {
        this.discordId = discordId;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "discordId='" + discordId + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

package cn.fc.service;

public interface TokenService {

    String createToken();

    boolean validateToken(String token);

}

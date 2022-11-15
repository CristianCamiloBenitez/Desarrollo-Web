package co.edu.javeriana.libreria.service;

import co.edu.javeriana.libreria.dto.User;
import co.edu.javeriana.libreria.repository.UserRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;


@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    // POST
    public User login(String username, String pwd) throws Exception {

        String token = getJWTToken(username);
        User user = new User();

        String pwdPlain = decrypt(pwd);
        String pwdHash = getHash(pwdPlain);

        user.setUsername(username);
        user.setPassword(pwd);
        user.setToken(token);

        if (userRepository.findById(username).isEmpty())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username doesent exist");

        if (userRepository.findById(username).get().getPassword().equals(pwdHash)) {
            return user;
        } else
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wrong login parameters");
    }

    private String getJWTToken(String username) {
        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes())
                .compact();

        return "Bearer " + token;
    }

    public static String getHash(String text) throws Exception {
        String pin_hash = null;
        try {
            MessageDigest clase_md5 = MessageDigest.getInstance("SHA-256");
            clase_md5.update(text.getBytes());
            byte[] bytes = clase_md5.digest();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            pin_hash = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return pin_hash;
    }

    public static String decrypt(String ciphertext) throws Exception {
        SecretKey secretKey = getSecretKey("o9szYIOq1rRMiouNhNvaq96lqUvCekxR");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.getDecoder().decode(ciphertext)));
    }

    public static SecretKey getSecretKey(String secretKey) throws Exception {
        byte[] decodeSecretKey = Base64.getDecoder().decode(secretKey);
        return new SecretKeySpec(decodeSecretKey, 0, decodeSecretKey.length, "AES");
    }

}

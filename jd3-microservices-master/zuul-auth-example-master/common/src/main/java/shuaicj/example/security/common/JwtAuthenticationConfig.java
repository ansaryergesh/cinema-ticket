package shuaicj.example.security.common;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

@Getter
@ToString
public class JwtAuthenticationConfig {

    @Value("${shuaicj.security.jwt.url:/login}")
    private String url;

    @Value("${shuaicj.security.jwt.header:Authorization}")
    private String header;

    @Value("${shuaicj.security.jwt.prefix:Bearer}")
    private String prefix;

    @Value("${shuaicj.security.jwt.expiration:#{24*60*60}}")
    private int expiration; // default 24 hours

    @Value("${shuaicj.security.jwt.secret}")
    private String secret;

    public String getUrl() {
        return url;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return secret;
    }

    @Override
    public String toString() {
        return "JwtAuthenticationConfig{" +
                "url='" + url + '\'' +
                ", header='" + header + '\'' +
                ", prefix='" + prefix + '\'' +
                ", expiration=" + expiration +
                ", secret='" + secret + '\'' +
                '}';
    }
}

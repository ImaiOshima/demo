package com.wyh.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "home")
@Setter
@Getter
public class HomeProperties {
    private String city;
    private String province;
    private String desc;

    @Override
    public String toString() {
        return "HomeProperties{" +
                "city='" + city + '\'' +
                ", provice='" + province + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}

package com.wyh.demo.design.builder;

import com.baomidou.mybatisplus.extension.api.R;
import com.sun.org.apache.regexp.internal.RE;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;

/**
 * @Classname ResourcePoolConfig
 * @Description TODO
 * @Date 2022/10/4 14:00
 * @Created by 61635
 */
@Data
@Getter
@Setter
public class ResourcePoolConfig {
    private String name;
    private int maxTotal;
    private int maxIdle;
    private int minIdle;

    private ResourcePoolConfig(Builder builder){
        this.name = builder.name;
        this.maxTotal = builder.maxTotal;
        this.maxIdle = builder.maxIdle;
        this.minIdle = builder.minIdle;
    }

    public static class Builder{
        private static final int DEFAULT_MAX_TOTAL = 8;
        private static final int DEFAULT_MAX_IDLE = 8;
        private static final int DEFAULT_MIN_IDLE = 0;

        private String name;
        private int maxTotal = DEFAULT_MAX_TOTAL;
        private int maxIdle = DEFAULT_MAX_IDLE;
        private int minIdle = DEFAULT_MIN_IDLE;

        public ResourcePoolConfig build(){
            if(StringUtils.isBlank(name)){
                throw new IllegalArgumentException("...");
            }
            if(maxIdle > maxTotal){
                throw new IllegalArgumentException("...");
            }
            if(minIdle > maxTotal || minIdle > maxIdle){
                throw new IllegalArgumentException("...");
            }
            return new ResourcePoolConfig(this);
        }

        public Builder setName(String name){
            if(StringUtils.isBlank(name)){
                throw new IllegalArgumentException("...");
            }
            this.name = name;
            return this;
        }

        public Builder setMaxTotal(int maxTotal){
            if(maxTotal < 0){
                throw new IllegalArgumentException("...");
            }
            this.maxTotal = maxTotal;
            return this;
        }

        public Builder setMaxIdle(int maxIdle){
            if(maxIdle < 0){
                throw new IllegalArgumentException("...");
            }
            this.maxIdle = maxIdle;
            return this;
        }

        public Builder setMinIdle(int minIdle){
            if(minIdle < 0){
                throw new IllegalArgumentException("...");
            }
            this.minIdle = minIdle;
            return this;
        }
    }

    public static void main(String[] args) {
        ResourcePoolConfig config = new Builder()
                .setName("dbConnectionPool")
                .setMaxTotal(16)
                .setMaxIdle(10)
                .setMinIdle(8)
                .build();
    }
}

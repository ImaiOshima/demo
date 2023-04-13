package com.wyh.demo.config.redis;

/**
 * @author imai
 * @since 2021/3/9 11:57 下午
 */
//@Configuration
//public class RedissonConfig {
//
//    @Autowired
//    private Environment env;
//
//    @Bean
//    public RedissonClient redissonClient() {
//        Config config = new Config();
//        //config.setCodec(new JsonJacksonCodec()).useClusterServers().setPassword(null)
//        //        .addNodeAddress(env.getProperty("redisson.host.config").split(","));
//
//        config.setCodec(new JsonJacksonCodec()).useSingleServer().setPassword("123456")
//                .setAddress(env.getProperty("redisson.host.config"));
//
//        RedissonClient redisson = Redisson.create(config);
//        return redisson;
//    }
//}

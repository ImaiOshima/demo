package com.wyh.demo.redissontest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author imai
 * @since 2021/4/5 7:08 下午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedissonTest {
//    private static final Logger log = LoggerFactory.getLogger(RedissonTest.class);
//
//    @Autowired
//    private RedissonClient redissonClient;
//
//    /**
//     * redisson test config json
//     * @throws IOException
//     */
//    @Test
//    public void test1() throws IOException {
//        log.info("redisson的配置信息 {}",redissonClient.getConfig().toJSON());
//    }
//
//    @Test
//    public void test2(){
//        final String key = "myBloomFilterDataV2";
//        Long total = 1000L;
//
//        RBloomFilter<Integer> bloomFilter = redissonClient.getBloomFilter(key);
//
//        bloomFilter.tryInit(total,0.01);
//
//        for(int i =1;i<=total;i++){
//            bloomFilter.add(i);
//        }
//
//        log.info("过滤器是否包含1 {}",bloomFilter.contains(1));
//        log.info("过滤器是否包含-1 {}",bloomFilter.contains(-1));
//        log.info("过滤器是否包含100000 {}",bloomFilter.contains(10000));
//        log.info("过滤器是否包含10000000 {}",bloomFilter.contains(10000000));
//    }

//    @Autowired
//    private UserLoginPublisher userLoginPublisher;

//    @Test
//    public void test4(){
//        UserLoginDto dto = new UserLoginDto();
//        dto.setUserId(90001);
//        dto.setUserName("a-xiu-luo");
//        dto.setPassword("123456");
//        userLoginPublisher.sendMsg(dto);
//    }

//    @Test
//    public void test8(){
//        final String key = "myRedissonSortedSetV2";
//        RSetDto dto1 = new RSetDto(1,"N1",20,10.0D);
//        RSetDto dto2 = new RSetDto(2,"N2",18,2.0D);
//        RSetDto dto3 = new RSetDto(3,"N3",21,8.0D);
//        RSetDto dto4 = new RSetDto(4,"N4",19,6.0D);
//        RSetDto dto5 = new RSetDto(5,"N5",22,1.0D);
//        RSortedSet<RSetDto> rSortedSet = redissonClient.getSortedSet(key);
//        rSortedSet.trySetComparator(new RSetComparator());
//        rSortedSet.add(dto1);
//        rSortedSet.add(dto2);
//        rSortedSet.add(dto3);
//        rSortedSet.add(dto4);
//        rSortedSet.add(dto5);
//
//        Collection<RSetDto> result = rSortedSet.readAll();
//        log.info("此时有序集合 {}",result);
//    }

//    @Test
//    public void test9(){
//        final String key = "myRedissonScoredSortedSet";
//        RSetDto dto1 = new RSetDto(1,"N1",10.0D);
//        RSetDto dto2 = new RSetDto(2,"N2",2.0D);
//        RSetDto dto3 = new RSetDto(3,"N3",8.0D);
//        RSetDto dto4 = new RSetDto(4,"N4",6.0D);
//
//        RScoredSortedSet<RSetDto> rScoredSortedSet = redissonClient.getScoredSortedSet(key);
//        rScoredSortedSet.add(dto1.getScore(),dto1);
//        rScoredSortedSet.add(dto2.getScore(),dto2);
//        rScoredSortedSet.add(dto3.getScore(),dto3);
//        rScoredSortedSet.add(dto4.getScore(),dto4);
//
//        Collection<RSetDto> result = rScoredSortedSet.readSortAlpha(SortOrder.DESC);
//
//        log.info("排序 {}",result);
//    }
}

package com.blog;

import org.springframework.boot.test.context.SpringBootTest;

/**
 * Created on 2020/4/12
 * Package com.blog
 *
 * @author dsy
 */
@SpringBootTest
public class RedisTest {

//    @Autowired
//    private RedisTemplate<String, Object> redisTemplate;
//
//    @Autowired
//    private TypeService typeService;
//
//    @Autowired
//    private TagService tagService;
//
//    @Autowired
//    private BlogService blogService;
//
//    @Test
//    public void testConnectionRedis() {
//        System.out.println(redisTemplate);
//    }
//
//    /**
//     * opsForValue
//     */
//    @Test
//    public void testSetAndGetUserOfRedis() {
//        User user = new User();
//        user.setUserId(1);
//        user.setUsername("dsy");
//        user.setPassword("admin");
//        redisTemplate.opsForValue().set("user:" + 2, user);
//        System.out.println(redisTemplate.opsForValue().get("user:2"));
//    }
//
//    @Test
//    public void testHash() {
////        User user = new User();
////        user.setUserId(2);
////        user.setUsername("aaaa");
////        user.setPassword("admin");
////        redisTemplate.opsForHash().put("user",user.getUserId(),user);
////        System.out.println(redisTemplate.opsForHash().values("user"));
//
////        redisTemplate.opsForHash().put("tags",1,"aaa");
////        redisTemplate.opsForHash().put("tags",2,"bbb");
//        redisTemplate.delete("tags");
//    }
//
//    @Test
//    public void testCount() {
//        redisTemplate.opsForValue().set("BlogCount", 10);
//        redisTemplate.opsForValue().increment("BlogCount");
//    }
//
//    @Test
//    public void findSeveralTypes() {
//        List<TypeTops> types = typeService.findSeveralTypes(5);
//        System.out.println(types);
//    }
//
//    @Test
//    public void testList() {
//        redisTemplate.opsForList().leftPush("types", "aaa");
//        redisTemplate.opsForList().leftPush("types", "bbb");
//        redisTemplate.opsForList().leftPush("types", "ccc");
//        List<Object> types = redisTemplate.opsForList().range("types", 0, -1);
//        System.out.println(types);
//
//    }
//
//
//    @Test
//    public void findSeveralTopTags() {
//        tagService.findSeveralTopTags(9);
//    }
//
//
//    @Test
//    public void findTheLastBlog() {
//        List<Blog> theLastBlog = blogService.findTheLastBlog(5);
//        System.out.println(theLastBlog);
//        System.out.println(theLastBlog.size());
//    }
//
//
//
//    @Test
//    public void testHashMoreObject() {
//        Blog blog = new Blog();
//        blog.setBlogId(1);
//        Type type = new Type();
//        type.setTypeId(2);
//        blog.setType(type);
////        redisTemplate.opsForHash().put("users",blog.getBlogId(),blog);
//        Object users = redisTemplate.opsForHash().get("users", blog.getBlogId());
//        System.out.println(users);
//    }

}

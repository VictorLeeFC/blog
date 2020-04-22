package com.blog;

import org.springframework.boot.test.context.SpringBootTest;
/**
 * @description: some desc
 * @git: https://github.com/VictorLeeFC
 * @date: 2020-03-07
 * @author: li
 * @version: v0.1
 */
@SpringBootTest
class BlogApplicationTests {

//    @Test
//    void contextLoads() {
//    }
//
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
//    @Autowired
//    private CommentService commentService;
//
//
//    @Autowired
//    private BlogMapper blogMapper;
//
//
//
//
//    @Test
//    public void getTagByName(){
//        Tag tag = tagService.getTagByTagName("Redis");
//        System.out.println(tag);
//    }
//
//
//    @Test
//    public void getBlogsByPage(){
////        Type type = new Type();
////        type.setName("姓名");
////        Blog blog = new Blog();
////        blog.setType(type);
////        PageHelper.startPage(1,10);
////        Page<Blog> blogs = blogService.findBlogByPage(blog);
////        PageInfo<Blog> pageInfo = new PageInfo<>(blogs);
////        System.out.println(blogs);
//    }
//
//
//    @Test
//    public void testOneToOne(){
//        List<Blog> blogList = blogMapper.findBlogAll();
//        System.out.println(blogList);
//    }
//
//    @Test
//    public void testFindBlogsByIds(){
//        String ids = "1,2";
//        List<Tag> tags = tagService.listTag(ids);
//        System.out.println(tags);
//    }
//
//
//    @Test
//    public void selectBlogByKeyWords(){
////        Page<Blog> blogs = blogService.selectBlogByKeyWords("条件", null, null);
////        System.out.println(blogs);
//    }
//
//    @Test
//    public void findBlogByKeyWords(){
////        List<Blog> blogList = blogMapper.findBlogByKeyWords("条件", "12", "1");
////        System.out.println(blogList);
//    }
//
//    @Test
//    public void findTagsByBlogId() {
//        String tags = blogService.findTagsByBlogId(8);
//        System.out.println(tags);
//    }
//
//    @Test
//    public void deleteBlog() {
//        blogService.deleteBlog(12);
//    }
//
//
//    @Test
//    public void findSeveralTypes() {
//        List<TypeTops> types = typeService.findSeveralTypes(5);
//        System.out.println(types);
//    }
//
//    @Test
//    public void findSeveralTopTags() {
//        List<TagTops> topTags = tagService.findSeveralTopTags(2);
//        System.out.println(topTags);
//    }
//
//    @Test
//    public void findTheLastBlog() {
//        List<Blog> theLastBlog = blogService.findTheLastBlog(2);
//        System.out.println(theLastBlog);
//    }
//
//
//    @Test
//    public void findTagsListByBlogId() {
//        List<Tag> tagsByBlogId = tagService.findTagsByBlogId(8);
//        System.out.println(tagsByBlogId);
//    }
//
//    @Test
//    public void findCommentsByBlogId() {
//        List<Comment> comments = commentService.findCommentsByBlogId(8);
//        for (Comment list : comments) {
//            System.out.println(list);
//        }
//    }
//
//    @Value(value = "${avatar}")
//    private String avatar;
//
//    @Test
//    public void test() {
//        System.out.println(avatar);
//    }
//
//    @Test
//    public void testCount() {
//        Integer count = typeService.findCount();
//        System.out.println(count);
//    }
//
//    @Test
//    void selectBlogByTypeId() {
//        List<Blog> blogByTypeId = blogService.findBlogByTypeId(12);
//        System.out.println(blogByTypeId);
//    }
//
//    @Test
//    public void findArchiveBlog() {
//        blogService.findArchiveBlog();
//    }
//
//    @Test
//    public void findAllBlog() {
//        List<Blog> allBlogByPage = blogService.findAllBlogByPage();
//        System.out.println(allBlogByPage.get(2));
//    }
//
//
//    @Test
//    public void selectSeveralTopTypes() {
//        List<TagTops> severalTopTags = tagService.findSeveralTopTags(6);
//        System.out.println(severalTopTags);
//    }
//
//    @Test
//    public void testTypeAdd() {
////        Type type = new Type();
////        type.setName("aaaaaaa");
////        typeService.saveType(type);
//
//    }
//
//    @Test
//    public void testDeleteTagById() {
//        tagService.deleteTagById(25);
//    }

}

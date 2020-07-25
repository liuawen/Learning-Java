## init article
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (1, 'dalaoyang', '这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。这是第一篇博客的摘要。', '2019-01-01 00:00:00', '第一篇博客', 1, 1, 1);
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (2, 'dalaoyang', '这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。这是第二篇博客的摘要。', '2019-01-01 00:00:00', '第二篇博客', 1, 1, 1);
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (3, 'dalaoyang', '这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。这是第三篇博客的摘要。', '2019-01-01 00:00:00', '第三篇博客', 1, 1, 1);
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (4, 'dalaoyang', '这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。这是第四篇博客的摘要。', '2019-01-01 00:00:00', '第四篇博客', 1, 1, 1);
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (5, 'dalaoyang', '这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。这是第五篇博客的摘要。', '2019-01-01 00:00:00', '第五篇博客', 1, 1, 1);
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (6, 'dalaoyang', '这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。这是第六篇博客的摘要。', '2019-01-01 00:00:00', '第六篇博客', 1, 1, 1);
INSERT INTO `springbootBlog`.`article`(`article_id`, `article_authors`, `article_content`, `article_input_date`, `article_name`, `article_reading_time`, `is_enable`, `is_top`) VALUES (7, 'dalaoyang', '大家好，我是SpringBoot2实战之旅的作者杨洋，感谢大家对我的支持，谢谢。\n\n', '2019-02-21', 'About DALAOYANG!\n\n', 0, 0, 0);
## init link
INSERT INTO `springbootBlog`.`link`(`link_id`, `link_name`, `link_url`, `remark`) VALUES (1, '简书', 'https://www.jianshu.com/u/128b6effde53', '简书地址');
INSERT INTO `springbootBlog`.`link`(`link_id`, `link_name`, `link_url`, `remark`) VALUES (2, 'DALAOYANG', 'https://www.dalaoyang.cn', 'dalaoyang的博客');
## init tag
INSERT INTO `springbootBlog`.`tag`(`tag_id`, `tag_name`) VALUES (1, 'SpringBoot');
INSERT INTO `springbootBlog`.`tag`(`tag_id`, `tag_name`) VALUES (2, 'SpringCloud');
INSERT INTO `springbootBlog`.`tag`(`tag_id`, `tag_name`) VALUES (3, 'Nginx');
INSERT INTO `springbootBlog`.`tag`(`tag_id`, `tag_name`) VALUES (4, 'Linux');
INSERT INTO `springbootBlog`.`tag`(`tag_id`, `tag_name`) VALUES (5, 'Tomcat');
INSERT INTO `springbootBlog`.`tag`(`tag_id`, `tag_name`) VALUES (6, 'Java');
## init article_tag
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (1, 1);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (1, 3);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (2, 3);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (2, 6);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (3, 1);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (4, 2);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (5, 1);
INSERT INTO `springbootBlog`.`article_tag`(`article_id`, `tag_id`) VALUES (6, 2);

## maybe error----------
##init website_config
INSERT INTO `springbootBlog`.`website_config`(`id`, `about_page_article_id`, `author_name`, `blog_name`, `email_username`,  `domain_name`, `record_number`) VALUES (1, 7, 'dalaoyang', 'SpringBoot博客', 'smtp.aliyun.com',  'Dalaoyang.cn', '辽ICP备17014944号-1');
##init website_access
INSERT INTO `springbootBlog`.`website_access`(`id`, `access_count`, `access_date`) VALUES (1, 0, now());

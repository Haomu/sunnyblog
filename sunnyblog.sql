/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : sunnyblog

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 02/11/2020 18:16:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for blog
-- ----------------------------
DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `appreciation` bit(1) NOT NULL COMMENT '赞赏是否开启',
  `commentabled` bit(1) NOT NULL COMMENT '评论是否开启',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '内容',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `first_picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg ' COMMENT '首图',
  `flag` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '原创' COMMENT '标记(转载，原创等等)',
  `published` bit(1) NOT NULL COMMENT '是否发布',
  `recommend` bit(1) NOT NULL COMMENT '是否推荐',
  `share_statement` bit(1) NOT NULL COMMENT '转载声明是否开启',
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `views` int(11) NULL DEFAULT NULL COMMENT '浏览次数',
  `type_id` bigint(20) NULL DEFAULT NULL,
  `user_id` bigint(20) NULL DEFAULT NULL,
  `comment_count` int(255) NULL DEFAULT NULL COMMENT '评论次数',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  `tag_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK292449gwg5yf7ocdlmswv9w4j`(`type_id`) USING BTREE,
  INDEX `FK8ky5rrsxh01nkhctmo7d48p82`(`user_id`) USING BTREE,
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `type` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1295632080285601793 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博客数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of blog
-- ----------------------------
INSERT INTO `blog` VALUES (1, b'1', b'1', '测试专用', '2020-08-06 17:21:31', '测试专用', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '测试专用', '2020-08-06 17:22:12', 6, 1290951569965531138, 1, 0, b'1', '1291249703274930177');
INSERT INTO `blog` VALUES (2, b'0', b'0', '这是一个小测试', '2020-08-06 22:13:37', '这是一个小测试', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'0', b'0', '这是一个小测试', '2020-08-18 11:22:32', 0, 1290951771594031105, 1, 0, b'1', '1291254833139408897,1291261326219677698,1291261387783671810');
INSERT INTO `blog` VALUES (1292020901801820162, b'1', b'1', '## 1、Spring Boot 简介\r\n\r\n> 简化Spring应用开发的一个框架；\r\n>\r\n> 整个Spring技术栈的一个大整合；\r\n>\r\n> J2EE开发的一站式解决方案；\r\n\r\n## 2、微服务\r\n\r\n2014，martin fowler\r\n\r\n微服务：架构风格（服务微化）\r\n\r\n一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；\r\n\r\n单体应用：ALL IN ONE\r\n\r\n微服务：每一个功能元素最终都是一个可独立替换和独立升级的软件单元；\r\n\r\n[详细参照微服务文档](http', '2020-08-09 19:00:59', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '那就来分享一下SpringBoot吧', '2020-08-09 19:01:18', 156, 1290951569965531138, 1, NULL, b'1', '1291254833139408897');
INSERT INTO `blog` VALUES (1292022503556186113, b'1', b'1', '## 1、Spring Boot 简介\r\n\r\n> 简化Spring应用开发的一个框架；\r\n>\r\n> 整个Spring技术栈的一个大整合；\r\n>\r\n> J2EE开发的一站式解决方案；\r\n\r\n## 2、微服务\r\n\r\n2014，martin fowler\r\n\r\n微服务：架构风格（服务微化）\r\n\r\n一个应用应该是一组小型服务；可以通过HTTP的方式进行互通；\r\n\r\n单体应用：ALL IN ONE\r\n\r\n微服务：每一个功能元素最终都是一个可独立替换和独立升级的软件单元；\r\n\r\n[详细参照微服务文档](http', '2020-08-09 19:01:02', '哈哈哈哈哈哈', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '那就来分享一下SpringBoot吧', '2020-08-09 14:46:16', 0, 1290951771594031105, 1, NULL, b'1', '1291254833139408897,1291249703274930177,1291261432570449921');
INSERT INTO `blog` VALUES (1292027910571937793, b'1', b'1', '11111', '2020-08-06 19:01:05', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '不忘初心，牢记使命', '2020-08-09 19:01:20', 0, 1290951959880552450, 1, NULL, b'1', '1291261432570449921');
INSERT INTO `blog` VALUES (1292029680723415042, b'1', b'1', '11121212121', '2020-08-07 19:01:09', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '新时代我们要做到', '2020-08-09 19:01:23', 0, 1290951959880552453, 1, NULL, b'1', '1291261432570449921');
INSERT INTO `blog` VALUES (1292032023787429890, b'1', b'1', 'sasasasasa', '2020-08-08 17:36:54', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '1111', '2020-08-08 17:36:54', 0, 1290951959880552455, 1, NULL, b'1', '1291261432570449921');
INSERT INTO `blog` VALUES (1292038796892135426, b'1', b'1', '211221', '2020-08-08 18:03:49', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '121', '2020-08-08 18:03:49', 0, 1290951959880552456, 1, NULL, b'1', '1291261432570449921,1291261387783671810');
INSERT INTO `blog` VALUES (1292039046872653825, b'1', b'1', '123123213', '2020-08-08 18:04:48', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', '12212121', '2020-08-08 18:04:48', 0, 1290951569965531138, 1, NULL, b'1', '1291261387783671810');
INSERT INTO `blog` VALUES (1292040653546938370, b'1', b'1', '1232132131', '2020-08-08 18:11:11', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'0', b'1', b'1', '121212', '2020-08-08 18:11:11', 0, 1290951959880552456, 1, NULL, b'1', '1291261457992126465');
INSERT INTO `blog` VALUES (1292123069842153474, b'1', b'1', '111111', '2020-08-08 23:38:41', NULL, 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'0', b'1', b'1', '1111', '2020-08-08 23:38:41', 0, 1290951959880552455, 1, NULL, b'1', '1291261501742911489');
INSERT INTO `blog` VALUES (1292358521954230274, b'0', b'0', '21212121', '2020-08-09 15:14:17', '1212121', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'0', b'0', '1222112', '2020-08-09 15:14:17', 2, 1290951885779775490, 1, NULL, b'1', '1291261432570449921');
INSERT INTO `blog` VALUES (1292367422065991682, b'0', b'0', 'hahahahahahahhahahahha', '2020-08-09 15:49:39', 'sasasasasaassasa', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'0', b'0', '那就来分享一下SpringBoot吧', '2020-08-09 15:49:39', 1, 1290951569965531138, 1, NULL, b'1', '1291261432570449921');
INSERT INTO `blog` VALUES (1292795949571559426, b'0', b'0', '草稿', '2020-08-10 20:12:28', '草稿', 'https://picsum.photos/seed/picsum/800/450', '原创', b'0', b'0', b'0', '是一个草稿', '2020-08-10 20:12:28', 0, 1290951885779775490, 1, NULL, b'1', '1291261358389989378');
INSERT INTO `blog` VALUES (1293497987062194178, b'1', b'1', '**对于哈希表，有两种实现方式**\r\n\r\n**1. ~~数组+链表~~ （本文实现方式）**\r\n2. 数组+二叉树\r\n![哈希表的实现](https://img-blog.csdnimg.cn/20200711173712761.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hhb211YQ==,size_16,color_FFFFFF,t_70)\r\n这里画一张图，来表示一下哈希表，对于哈希表，第一种实现方式就是用数组，数组中包含有链表，链表中有一个个的节点。对于此图，数组实例化5个empLinkedList链表，然后在添加时，通过哈希算法计算出对应id应该放在哪个链表中，再在计算出位置的链表中插入一个emp节点，这样即完成了添加操作。\r\n**这里需要注意一点：**\r\n**在对哈希表，也就是数组的初始化时，应注意，给每个链表都进行初始化，不然会出现空指针异常。因为只给数组初始化，其内部都是null，需要对每个链表都进行初始化**\r\n![哈希表的初始化](https://img-blog.csdnimg.cn/20200711174232142.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L0hhb211YQ==,size_16,color_FFFFFF,t_70)\r\n**链表添加节点操作:**\r\n**首先进行判断，如果头节点为空，则将头节点指向要添加的emp节点。若头节点不为空，则借助一个辅助指针，循环，找到链表最后一个位置，如果找到最后一个位置，终止循环，如果未找到，则后移，直到找到位置。最后将辅助指针的下一个指针指向emp**\r\n<pre><code class=\"language-java\">\r\n//添加雇员\r\n    public void add(Emp emp){\r\n        if (head == null){\r\n            head = emp;\r\n            return;\r\n        }\r\n        Emp curEmp = head;\r\n        while (true){\r\n            if (curEmp.next == null){  //找到最后一个位置\r\n                break;\r\n            }\r\n            curEmp = curEmp.next;  //还没到最后一个位置，后移\r\n        }\r\n        //退出循环说明找到了最后一个位置\r\n        curEmp.next = emp;\r\n    }\r\n</code></pre>\r\n**删除节点操作：**\r\n**类似更新节点，重要的是在判空时应让辅助指针的下一个指针去判断，这样才能完成删除，如果拿辅助指针去判断，则无法删除**\r\n<pre><code class=\"language-java\">\r\n //删除雇员\r\n    public void delete(int id){\r\n        if (head == null) {\r\n            System.out.println(\"链表为空，无法删除\");\r\n            return;\r\n        }\r\n        Emp curEmp = head;\r\n        while (true){\r\n            if (curEmp.next == null){ //说明当前链表没有所找的雇员\r\n                System.out.println(\"未找到\" + id + \"号雇员\");\r\n                break;\r\n            }\r\n            if (curEmp.next.id == id){ //说明被找到了\r\n                curEmp.next = null;  //删除该节点\r\n                System.out.println(\"删除成功\");\r\n                break;\r\n            }\r\n            curEmp = curEmp.next;\r\n        }\r\n    }\r\n</code></pre>\r\n**根据id查询**\r\n**与之前大同小异，不再具体介绍**\r\n<pre><code class=\"language-java\">\r\n//查询雇员\r\n    public Emp query(int id){\r\n        if (head == null){ //判断链表是否为空\r\n            System.out.println(\"链表为空\");\r\n            return null;\r\n        }\r\n        Emp curEmp = head;\r\n        while (true) {\r\n            if (curEmp.id == id){ //说明被找到了\r\n                break;\r\n            }\r\n            if (curEmp.next == null){ //说明当前链表没有所找的雇员\r\n                return null;\r\n            }\r\n            curEmp = curEmp.next; //后移\r\n        }\r\n        return curEmp;\r\n    }\r\n</code></pre>\r\n**查询所有雇员**\r\n<pre><code class=\"language-java\">\r\n//查询所有雇员\r\n    public void list(int i){\r\n        if (head == null){ //说明当前链表为空\r\n            System.out.println(\"第 \"+ (i+1) +\" 条链表为空\");\r\n            return;\r\n        }\r\n        //退出循环说明链表有信息\r\n        System.out.print(\"第 \"+ (i+1) +\" 条链表信息为:\\t\");\r\n        Emp curEmp = head;\r\n        while (true){\r\n            System.out.printf(\"==> id = %d name = %s\\t\",curEmp.id,curEmp.name);\r\n            if (curEmp.next == null){  //说明当前curEmp已经是最后一个\r\n                System.out.println();\r\n                break;\r\n            }\r\n            //后移一位\r\n            curEmp = curEmp.next;\r\n        }\r\n    }\r\n</code></pre>\r\n**对于上述链表操作，在哈希表中操作时，需要通过散列函数，计算出要添加的emp应该添加在哪个链表上，然后再对该链表进行操作就行了**\r\n**例如：**\r\n<pre><code class=\"language-java\">\r\n//删除雇员\r\n    public void delete(int no){\r\n        //使用散列函数查找该去那个链表找\r\n        int i = hashAlgorithm(no);\r\n        empLinkedListsArr[i].delete(no);\r\n    }\r\n\r\n    //简易Hash算法,即散列函数，通过取模运算进行位置计算\r\n    public int hashAlgorithm(int id) {\r\n        return id % size;\r\n    }\r\n</code></pre>', '2020-08-12 18:42:07', '简单分析了一些哈希表，并且实现了部分功能', 'https://img-blog.csdnimg.cn/20200711173712761.png', '原创', b'1', b'1', b'1', '哈希表分析及功能实现', '2020-08-12 18:46:40', 34, 1290951771594031105, 1, NULL, b'0', '1291261387783671810,1291249703274930177');
INSERT INTO `blog` VALUES (1293499371396423682, b'0', b'0', '	1111', '2020-08-12 18:47:37', '121221312', 'https://picsum.photos/seed/picsum/800/450', '原创', b'1', b'0', b'0', '那就来分享一下SpringBoot吧', '2020-08-12 18:47:37', 38, 1290951569965531138, 1, NULL, b'1', '1291249703274930177');
INSERT INTO `blog` VALUES (1295618847227121665, b'1', b'1', '<pre><code class=\"language-java\">\r\npackage pers.haomu.rename;\r\n\r\nimport java.io.File;\r\nimport java.nio.file.Path;\r\n\r\n/**\r\n * @author Haomu\r\n * @Description\r\n * @Version 1.0\r\n * @create 2020-02-03-16:02\r\n */\r\npublic class FileRename {\r\n\r\n    /**\r\n     * @Author Haomu\r\n     * @Description  path:文件路径名，oldName:需要被更换的字符串，newName:新字符串\r\n     * @Date 2020/2/3\r\n     * @Param [path, oldName, newName]\r\n     * @return void\r\n     **/\r\n    public void renameFile(String path,String oldName,String newName){\r\n\r\n        File filePath = new File(path);\r\n        File[] files = filePath.listFiles();\r\n        for (File file : files) {\r\n            if (file.getName().contains(oldName)){\r\n                String newString = file.getName().replace(oldName,\"\");\r\n                File newFile = new File(path + \"\\\\\" + newString);\r\n                file.renameTo(newFile);\r\n                System.out.println(\"修改后为:\" + newFile);\r\n            }\r\n        }\r\n    }\r\n}\r\n</code></pre>\r\n', '2020-08-18 15:09:39', '今天看下载的视频资源，视频名字一大长串不需要的字，看不到后面的章节名，就写一个Java批量重命名的程序', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', 'Java批量文件重命名', '2020-08-18 15:09:39', 2, 1290951771594031105, 1, NULL, b'0', '1291249703274930177');
INSERT INTO `blog` VALUES (1295619774247997441, b'1', b'1', '**从下至少，先对结点集合进行排序，取出权值最小的和次小的，两个结点合并组成一个二叉树，父结点的权值为两个结点权值之和，然后将父节点左右孩子指向取出的两个结点，随后将两个结点从集合中删除，将新产生的父节点添加进去，一直循环到最后只剩一个根节点为止，此时霍夫曼树已经构建完毕。\r\n如果写霍夫曼编码，则需要再Node结点中添加一个data属性，作为数据记录，大致构建霍夫曼树的方法如上**\r\n<pre><code class=\"language-java\">\r\nclass Node implements Comparable<Node>{\r\n    int value;  //权值\r\n    Node left;  //左子结点\r\n    Node right;  //右子结点\r\n\r\n    public Node(int value) {\r\n        this.value = value;\r\n    }\r\n\r\n    @Override\r\n    public String toString() {\r\n        return \"Node{\" +\r\n                \"value=\" + value +\r\n                \'}\';\r\n    }\r\n\r\n    public void preOrder(){  //前序遍历\r\n        System.out.println(this);\r\n        if (this.left != null){\r\n            this.left.preOrder();\r\n        }\r\n        if (this.right != null){\r\n            this.right.preOrder();\r\n        }\r\n    }\r\n\r\n    @Override\r\n    public int compareTo(Node o) {\r\n        //表示从小到大排序\r\n        return this.value - o.value;\r\n    }\r\n}\r\n</code></pre>\r\n\r\n<pre><code class=\"language-java\">\r\npublic class HuffmanTree {\r\n    public static void main(String[] args) {\r\n        int[] arr = {13,7,8,3,29,6,1};\r\n        Node root = createHuffmanTree(arr);\r\n        preOrder(root);\r\n    }\r\n\r\n    public static Node createHuffmanTree(int[] arr){\r\n        List<Node> nodes = new ArrayList<>();\r\n        for (int value : arr) {\r\n            nodes.add(new Node(value));\r\n        }\r\n\r\n        while (nodes.size() > 1){\r\n            //进行排序\r\n            Collections.sort(nodes);\r\n            //取出权值最小的结点\r\n            Node leftNode = nodes.get(0);\r\n            //取出权值第二小的结点\r\n            Node rightNode = nodes.get(1);\r\n            //合并生成一个新父结点\r\n            Node parent = new Node(leftNode.value + rightNode.value);\r\n            //将父结点左右子节点指向\r\n            parent.left = leftNode;\r\n            parent.right = rightNode;\r\n\r\n            //将用于合并的两个结点删除\r\n            nodes.remove(leftNode);\r\n            nodes.remove(rightNode);\r\n            //将新合并的结点添加\r\n            nodes.add(parent);\r\n        }\r\n        //返回霍夫曼树根节点\r\n        return nodes.get(0);\r\n    }\r\n\r\n    public static void preOrder(Node root){  //前序遍历\r\n        if (root != null) {\r\n            root.preOrder();\r\n        } else {\r\n            System.out.println(\"霍夫曼树为空\");\r\n        }\r\n    }\r\n}\r\n</code></pre>\r\n', '2020-08-18 15:13:20', 'java实现霍夫曼树', 'https://i.loli.net/2020/08/10/ocHWYBEez7aNvjn.jpg', '原创', b'1', b'1', b'1', 'java实现霍夫曼树', '2020-08-18 15:13:35', 1, 1290951771594031105, 1, NULL, b'0', '1291261387783671810,1291249703274930177');
INSERT INTO `blog` VALUES (1295621451554361346, b'1', b'1', '**A) Service/DAO层方法命名规约。**\r\n\r\n1） 获取单个对象的方法用get做前缀。\r\n\r\n2） 获取多个对象的方法用list做前缀，复数结尾，如：listObjects。\r\n\r\n3） 获取统计值的方法用count做前缀。\r\n\r\n4） 插入的方法用save/insert做前缀。\r\n\r\n5） 删除的方法用remove/delete做前缀。\r\n\r\n6） 修改的方法用update做前缀。\r\n\r\n**B) 领域模型命名规约**\r\n\r\n1） 数据对象：xxxDO，xxx即为数据表名。\r\n\r\n2） 数据传输对象：xxxDTO，xxx为业务领域相关的名称。\r\n\r\n3） 展示对象：xxxVO，xxx一般为网页名称。\r\n\r\n4） POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO。', '2020-08-18 15:20:00', '阿里java开发手册命名规约', 'https://i.loli.net/2020/08/18/MTzPdcnsJOBGyeQ.png', '原创', b'1', b'1', b'1', '阿里java开发手册命名规约', '2020-08-18 15:20:00', 3, 1290951771594031105, 1, NULL, b'0', '1291249703274930177');
INSERT INTO `blog` VALUES (1295624604915994625, b'1', b'1', '|  选泡插 | 选择排序，冒牌排序，插入排序  |\r\n| ------------ | ------------ |\r\n| **快归堆希桶计基**  |  **快速排序，归并排序，堆排序，希尔排序，桶排序，计数排序，基数排序** |\r\n|  **恩方恩老恩恩一三** | **选泡插(n²,n²,n²)  快归堆(n*log2(n),nlog2(n),nlog2(n)) 希尔(n^1.3)**  |\r\n|  **不稳稳稳不稳稳** |  **选择(不稳),冒泡(稳),插入(稳),快速排序(不稳),归并排序(稳)** |\r\n|  **不稳不稳稳稳稳** |  **堆排序(不稳),希尔(不稳),桶排序(稳),计数(稳),基数(稳)** |\r\n\r\n[![基本排序算法](https://i.loli.net/2020/08/18/8KxPFbsgOUd5hue.png \"基本排序算法\")](https://i.loli.net/2020/08/18/8KxPFbsgOUd5hue.png \"基本排序算法\")', '2020-08-18 15:32:32', '基本排序算法', 'https://i.loli.net/2020/08/18/8KxPFbsgOUd5hue.png', '原创', b'1', b'1', b'1', '基本排序算法', '2020-08-18 15:35:12', 1, 1290951771594031105, 1, NULL, b'0', '1291249703274930177,1291261387783671810');


-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '评论内容',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '评论时间',
  `blog_id` bigint(20) NULL DEFAULT NULL COMMENT '博客id',
  `parent_comment_id` bigint(20) NULL DEFAULT NULL COMMENT '父评论id',
  `admin_comment` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否为博主评论',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1295617675720265730 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (1294571855600291842, '那你帮帮我嘛', 'jm@qq.com', '测试', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-15 17:49:17', 1292020901801820162, -1, b'0', b'0');
INSERT INTO `comment` VALUES (1295009685451460609, '那你帮帮我嘛', 'jm@qq.com', '哈哈哈哈', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-16 22:49:04', 1292020901801820162, -1, b'0', b'0');
INSERT INTO `comment` VALUES (1295014828834181122, 'sunny', '731574232@qq.com', '不用测试，是完美的', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-16 23:09:30', 1292020901801820162, 1294571855600291842, b'1', b'0');
INSERT INTO `comment` VALUES (1295617468609728514, 'Sunny', '731574232@qq.com', '顶顶', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-18 15:04:11', 1295615054913605634, -1, b'1', b'0');
INSERT INTO `comment` VALUES (1295617675720265730, 'Sunny', '731574232@qq.com', '嘿嘿嘿，自己顶顶', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-18 15:05:00', 1295615054913605634, -1, b'1', b'0');

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '内容',
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `parent_message_id` bigint(20) NULL DEFAULT NULL COMMENT '父评论id',
  `admin_message` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否为管理员消息',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1295345488669143041 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '留言数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES (100, '那你帮帮我嘛', 'jk@qq.com', '测试一下', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 15:41:04', -1, b'0', b'0');
INSERT INTO `message` VALUES (1295265632149180417, '那你帮帮我嘛', 'jm@qq.com', '咋样', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 15:46:06', 100, b'0', b'0');
INSERT INTO `message` VALUES (1295265632149180418, '测试一下', 'jk@qq.com', '测试', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 15:52:58', -1, b'0', b'1');
INSERT INTO `message` VALUES (1295265632149180419, '测试', 'jk@qq.com', '测试', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 15:53:29', -1, b'0', b'1');
INSERT INTO `message` VALUES (1295265632149180420, '测试', 'jk@qq.com', '测试', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 15:53:48', -1, b'0', b'0');
INSERT INTO `message` VALUES (1295289448745316353, '皓目啊', 'jm@qq.com', '不用测了非常棒', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 17:20:45', 1295265632149180420, b'0', b'0');
INSERT INTO `message` VALUES (1295290290160447489, 'Sunny', '731574232@qq.com', '哈哈哈哈你都会抢答了', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-17 17:24:05', 1295289448745316353, b'1', b'0');
INSERT INTO `message` VALUES (1295290366794575874, 'Sunny', '731574232@qq.com', '再来几条试试分页', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-17 17:24:23', -1, b'1', b'0');
INSERT INTO `message` VALUES (1295290390999904257, 'Sunny', '731574232@qq.com', '1', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-17 17:24:29', -1, b'1', b'0');
INSERT INTO `message` VALUES (1295290396024680449, 'Sunny', '731574232@qq.com', '2', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-17 17:24:30', -1, b'1', b'0');
INSERT INTO `message` VALUES (1295290404698501122, 'Sunny', '731574232@qq.com', '3', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-17 17:24:32', -1, b'1', b'0');
INSERT INTO `message` VALUES (1295290429344231426, 'Sunny', '731574232@qq.com', '4', 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-17 17:24:38', -1, b'1', b'0');
INSERT INTO `message` VALUES (1295345244107665409, '求求你了', 'haomua@163.com', '为什么啊', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 21:02:27', -1, b'0', b'0');
INSERT INTO `message` VALUES (1295345488669143041, '求你别吃了', 'gaga@qq.com', '真是怕了', 'https://i.loli.net/2020/08/16/ZjNTHscwIKzRptk.jpg', '2020-08-17 21:03:26', 1295345244107665409, b'0', b'0');

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `pictureaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片地址',
  `picturedescription` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片描述',
  `picturename` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片名',
  `picturetime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片时间',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '相册数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标签',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  `tag_blogs` int(11) NULL DEFAULT 0 COMMENT '某个标签对应的博客数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1295632195217920002 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '标签数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tag
-- ----------------------------
INSERT INTO `tag` VALUES (1291249703274930177, 'JavaSE', b'0', 6);
INSERT INTO `tag` VALUES (1291254833139408897, 'JavaEE', b'0', 1);
INSERT INTO `tag` VALUES (1291261326219677698, '数据库', b'0', 1);
INSERT INTO `tag` VALUES (1291261358389989378, '高并发', b'0', 0);
INSERT INTO `tag` VALUES (1291261387783671810, '数据结构与算法', b'0', 3);
INSERT INTO `tag` VALUES (1291261432570449921, 'SpringBoot', b'0', 1);
INSERT INTO `tag` VALUES (1291261457992126465, 'Spring', b'0', 0);
INSERT INTO `tag` VALUES (1291261479890587650, 'SpringMVC', b'0', 0);
INSERT INTO `tag` VALUES (1291261501742911489, 'Mybatis', b'0', 1);
INSERT INTO `tag` VALUES (1291261519535149057, 'Redis', b'0', 0);
INSERT INTO `tag` VALUES (1291261548832362497, 'SpringCloud', b'0', 0);
INSERT INTO `tag` VALUES (1291261603102461954, 'test1', b'1', 0);
INSERT INTO `tag` VALUES (1295300070258159618, '我的小白菜', b'0', 0);
INSERT INTO `tag` VALUES (1295300124394041346, '哈哈哈', b'1', 0);
INSERT INTO `tag` VALUES (1295301819765272577, '啦啦', b'1', 0);
INSERT INTO `tag` VALUES (1295301984987295745, '111', b'1', 0);
INSERT INTO `tag` VALUES (1295304631995772929, '2', b'1', 0);
INSERT INTO `tag` VALUES (1295306208676589570, '2222', b'1', 0);
INSERT INTO `tag` VALUES (1295306996262023169, '111', b'1', 0);
INSERT INTO `tag` VALUES (1295316302361440257, '', b'1', 0);
INSERT INTO `tag` VALUES (1295337412423577602, '啦啦', b'1', 0);
INSERT INTO `tag` VALUES (1295632195217920002, '我的生活', b'0', 1);

-- ----------------------------
-- Table structure for type
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '分类类名',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  `type_blogs` int(11) NULL DEFAULT 0 COMMENT '某个分类对应的博客数量',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1295316423518105602 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '博文分类数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES (1290951569965531138, '日常生活', b'0', 1);
INSERT INTO `type` VALUES (1290951771594031105, '学习笔记', b'0', 6);
INSERT INTO `type` VALUES (1290951885779775490, '好物分享', b'0', 0);
INSERT INTO `type` VALUES (1290951959880552450, '记事本', b'0', 0);
INSERT INTO `type` VALUES (1290951959880552451, '1111你好', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552452, '131231', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552453, 'test233', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552454, '111', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552455, '323232', b'1', 0);
INSERT INTO `type` VALUES (1290951959880552456, 'test1', b'1', 0);
INSERT INTO `type` VALUES (1290951959880552457, 'test2', b'1', 0);
INSERT INTO `type` VALUES (1290951959880552458, 'test3', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552459, 'test4', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552460, 'test5', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552461, 'test6', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552462, 'test7', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552463, 'test8', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552464, 'test9', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552465, 'test10', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552466, 'test11', b'1', NULL);
INSERT INTO `type` VALUES (1290951959880552467, 'test12', b'1', NULL);
INSERT INTO `type` VALUES (1291027637552500738, '生活啊', b'1', NULL);
INSERT INTO `type` VALUES (1291029663288086530, '啦啦', b'1', NULL);
INSERT INTO `type` VALUES (1291030245952409602, '我擦嘞', b'1', NULL);
INSERT INTO `type` VALUES (1291032895099981825, '德玛西亚d', b'1', NULL);
INSERT INTO `type` VALUES (1291036370479321089, 'de', b'1', NULL);
INSERT INTO `type` VALUES (1295300404569354242, '德玛', b'1', 0);
INSERT INTO `type` VALUES (1295304435031257090, '啦啦', b'1', 0);
INSERT INTO `type` VALUES (1295310543896621058, 'saa', b'1', 0);
INSERT INTO `type` VALUES (1295316423518105602, '', b'1', 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户头像',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '注册时间',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `type` int(11) NULL DEFAULT NULL COMMENT '用户类型',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `deleted` bit(1) NULL DEFAULT b'0' COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户数据表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'https://i.loli.net/2020/08/10/ZCv5rFPYqDmd3fp.jpg', '2020-08-04 20:05:43', '731574232@qq.com', 'Sunny', 'baec3767c952c683285044d59390adbc', 1, '2020-08-04 20:06:33', 'sunny', b'0');

SET FOREIGN_KEY_CHECKS = 1;

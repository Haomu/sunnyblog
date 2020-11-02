# sunnyblog v1.0.0
**秉承先上线后优化的理念，先将项目放上来，后续添加其他功能并进行优化**

### v1.0版本说明：

> 借鉴了李仁密老师的博客教程，前端由SemanticUI构成，借鉴了老师的前端布局，自己美化了一下，大致改了改，后端由SpirngBoot+Mybatis构成，老师使用的JPA作为持久层，我这里使用Mybatis+Mybatis-Plus进行重构。
整个项目删除方式我选用逻辑删除，这样可以避免多表关联删除出错的情况，并且有助于数据恢复

**前端：**
- UI框架：[semantic UI][1]

- 文本编辑：[editor.md][2]

- 代码高亮：[prism][3]

- 音乐播放器：[Aplayer][4]

- 文章目录生成：[Tocbot][5]

- 动画：[animate.css][6]

**后端：**

- 核心框架：SpringBoot 2.3.2

- 项目构建：Maven 3.6.3、Mybatis-Plus AutoGenerator 自动生成代码

- 持久层框架：Mybatis 3.5.5

- 通用mapper：Mybatis-Plus 3.3.2

- 分页插件：PageHelper 1.3.0

- 安全管理框架：Shiro 1.5.3

- 数据库：MySQL 8.0.21

- 数据源：Druid 1.1.23

- 运行环境：jdk1.8、CentOS7


### 新增：

**前端博客美化效果：**

- 使用js动画ribbon优化视觉效果

- 页面组件进行透明化处理

- 引入页面音乐播放器

- 使用pjax进行局部刷新，优化界面跳转效果

- footer采用动态js计算网站运营时间

- 对移动端进行适配


**后端功能：**
- 持久层为Mybatis，mapper主要由通用Mapper : Mybatis-Plus完成功能，少量由自己编写sql语句完成

- 安全框架使用shiro进行登录处理，密码采用盐值md5加密方式进行安全处理

- 使用Lombok简化实体对象创建


------------

#### v2.0预计新增：

- 使用Redis缓存首页推荐博客，标签，分类

- 使用ElasticSearch进行博客内容搜索

- 搭建自己的图床，将文章上传的图片都上传到图床服务器


------------

>  此项目由Sunny个人构建，未采用前后端分离，使用Thymeleaf模板引擎动态渲染html。希望认识会使用Vue的前端朋友或者会用SpringBoot的后端朋友一起做项目。






[1]: https://semantic-ui.com/ "semantic UI"
[2]: http://www.mdeditor.com/ "editor.md"
[3]: https://prismjs.com/ "prism"
[4]: https://aplayer.js.org/#/ "Aplayer"
[5]: https://tscanlin.github.io/tocbot/ "Tocbot"
[6]: https://animate.style/ "animate.css"

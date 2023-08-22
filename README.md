<p align="center">
  <img src="./assets/bug-2.png" alt="kill-bug">
</p>

<div align="center">

# Kill Bug
<!-- prettier-ignore-start -->
<!-- markdownlint-disable-next-line MD036 -->
_✨ Your Most Reliable Programming Assistant! ✨_
<!-- prettier-ignore-end -->
<p align="center">
  <img src="https://img.shields.io/github/v/release/Poison02/kill-bug?display_name=tag" />
  <img src="https://img.shields.io/github/stars/Poison02/kill-bug" />
  <img src="https://img.shields.io/github/forks/Poison02/kill-bug" />
  <img src="https://img.shields.io/github/issues/Poison02/kill-bug" />
  <img src="https://img.shields.io/badge/license-Apache%20-yellow.svg" />
</p>
</div>

# 项目简介
kill-bug是一个易于使用的平台，专为程序员解决日常开发中遇到的问题而设计。它提供搜索问题、发布问题、回答问题、发布悬赏任务、即时通信、协同编辑等功能。
灵感来源于这个网站：[openask](https://openask.me/home)，但是功能却要小得多。

## 项目模块
-   **问题模块**

    Kill Bug 用户可以自由发布与开发和编程相关的带有不同标签的问题。他们还可以回答问题以帮助其他用户。每个问题都有相应的点赞和回答数量，这意味着用户可以根据这些评估指标选择问题或答案。

-   **悬赏模块**

    Kill Bug 用户可以通过花费一定的金额来发布悬赏，以吸引其他编程高手。这意味着您更有可能获得更高质量的解决方案。用户也可以通过抢单来赚钱。在被抢单后，Kill-Bug平台会为发布者和抢单者创建一个聊天室。他们可以进入自己的聊天室进行协商，解决悬赏任务。此外，Kill Bug 平台还为他们提供了丰富的文本协同编辑器，方便分享代码或文档。

-   **聊天模块**

    如前所述，发布赏金和抢单者可以在聊天室中进行交流。然而，这并不仅限于这些用户。所有用户只需点击“消息”按钮就可以相互聊天，这也是其他主流社交网络应用的常见功能。

-   **用户模块**

    这是各类网站的常见模块。用户可以登录、注册、退出、查看个人信息和修改个人信息。此外，结合 Kill Bug 的主要功能，用户还可以查看他们发布的问题、发布的赏金以及领取的赏金。还有一个有趣的功能：成就。用户可以查看自己发布的问题数量、发布的赏金数量、获得的点赞数等等。

# 项目依赖
本项目核心依赖如下：

后端：

|     Technology     | Version    |
|:------------------:|:-----------|
|        JDK         | 1.8        |
|    Spring Boot     | 2.7.6      |
|    Spring Cloud    | 2021.0.5   |
| SpringCloudAlibaba | 2021.0.4.0 |
|       MySQL        | 8.0        |
|       Hutool       | 5.8.10     |
|        satoken     | 1.33.0     |

前端技术栈：

|  Technology  |                           Feature                            |
| :----------: | :----------------------------------------------------------: |
|    React     |              基本 Web 框架                |
|   Next.js    | SSR 框架 |
|  Ant Design  | UI 组件库 |
|     Mobx     | 全局状态管理库 |
|    Axios     | HTTP 请求库 |
|    Router    | 路由组件 |
|     Mock     | HTTP 请求 mock |
| Quill Editor | 富文本编辑器 |
|    Socket    | 即时通信 / 协同编辑    |
|  Js-Cookie   | Cookie 管理工具 |

## 模块树
```
├── killbug-common                   -> Common Module
│   ├── killbug-common-alibaba-bom       -> Spring-Cloud-Alibaba Dependency 
│   ├── killbug-common-bom               -> Common Dependency
│   ├── killbug-common-core              -> Core Configuration and Dependency
│   ├── killbug-common-doc               -> Swagger API Doc Configuration and Dependency
│   ├── killbug-common-dubbo             -> Dubbo RPC Configuration and Dependency
│   ├── killbug-common-idempotent        -> Idempotent Configuration
│   ├── killbug-common-elasticsearch     -> Elastic Configuration and Dependency
│   ├── killbug-common-mybatis           -> Mybatis Configuration and Dependency
│   ├── killbug-common-redis             -> Redis Cache Configuration and Dependency
│   ├── killbug-common-satoken           -> Sa-Token Authorization Framework Configuration and Dependency
│   ├── killbug-common-security          -> Security Interceptor Configuration
│   └── killbug-common-sentinel          -> Sentinel Flow Control Configuration and Dependency
├── killbug-api                      -> RPC Interface Module
├── killbug-auth                     -> Authentication and Authorization Service 
├── killbug-gateway                  -> Gateway Service
├── killbug-websocket                    -> Websocket Service
└── killbug-modules                  -> Business Module
    ├── killbug-user                    -> User Service
    ├── killbug-bounty                   -> Bounty Service
    ├── killbug-chat                     -> Chat Service
    ├── killbug-index                    -> Index Service
    ├── killbug-search                   -> Search Service
    └── killbug-question                 -> Question Service
```

## 快速开始

### 本地启动
1. 配置基础运行环境
- `jdk1.8`
- `maven3.6+`
- `nacos 2.1.2` 端口8848
- `redis 7.x` 端口6379
- `MySQL 8.x` 端口3306
2. 导入数据库数据，数据库数据在 `/data` 目录下，按照里面的`readme`导入即可
3. 修改以下几个模块的数据库配置信息，主要是更改数据库连接账号密码即可
- `killbug-modules/kullbug-bounty`
- `killbug-modules/kullbug-chat`
- `killbug-modules/kullbug-user`
- `killbug-modules/kullbug-question`
4. 启动以下几个微服务模块
- `killbug-auth`
- `killbug-modules/kullbug-bounty`
- `killbug-modules/kullbug-user`
- `killbug-modules/kullbug-question`
- `killbug-modules/kullbug-chat`
- `killbug-modules/kullbug-index`
- `killbug-websocket`
- `killbug-gateway`
5. 启动前端</br>
进入 `killbug-frontend`模块，使用命令启动
```bash
# 安装依赖
yarn

# 构建运行
yarn dev

# 打包
yarn build
```
6. 打开浏览器访问</br>
访问 http://localhost:3000 端口即可看到页面

### Docker部署
### Docker Compose部署
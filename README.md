### 本demo集成nacos配置详细如下：
##### 1、共存了本地properties
##### 2、在nacos共存原data-id的properties配置
##### 3、nacos多属性文件配置
##### 4、属性加解密配置

### 扩展
##### 加载本地属性文件还可以扩展文件类型，如json。
##### 加载nacos的配置在版本 2.1.3.RELEASE 是支持json格式的。

### nacos属性加载及加密过程：
##### 预处理环境信息-》加载本地属性-》执行ApplicationContextInitializer加载nacos远程属性-》EnvironmentDecryptApplicationInitializer解密属性

 
### 获取密文方法：
##### 以ConfigServerApplication启动，而 EncryptionController 暴露了加解密方法等接口，可以使用。

### 注意事项：
#### 1、使用refresh配置时，虽然监听了nacos配置变化，但是不会同步应用的原配置的值，如需同步刷新配置，则需要结合注解@RefreshScope使用，标注到相关类上即可（使用该注解时，配置若更新，则应用由ContextRefresher启动一个新的Context执行一遍SpringApplication.run()，然后将启动后加载的PropertySource替换原来context的旧PropertySource）
#### 2、关于属性的加解密，如果使用的时jdk8，
#####	2.1、window，则需要在JAVA_HOME外面的jre包把 local_policy.jar、US_export_policy.jar复制到文件夹 security 下。
#####	2.2、mac，不用操作，因为security下已经包含这两个jar。
#####	2.3、linux，根据系统版本不一样，自己去检查。
#####   另外，若碰到密文限制长度的话，则需修security目录下java.security文件的属性crypto.policy=unlimited（删除注释即可）。
#### 3、另外，demo的密钥都是暴露在项目resource中，如果使用在服务器上，可以将 密钥对 放置服务器上， 及 其他密码 放置独立jar于启动容器中。
 

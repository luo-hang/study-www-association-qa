## 接入指南

__Note__: *当前RMI注册端口固定为 **9099**, 数据传输端口为 **随机**(对客户端透明) 且要求**JDK1.8.x**版本 并且由于云上贵州服务器端口限制只有内网运行访问

* Step 1: 在集成项目的pom.xml文件中添加下面的依赖
```
        <dependency>
            <groupId>com.fsnip</groupId>
            <artifactId>rmi-common-hook</artifactId>
            <version>1.0.0</version>
		</dependency>
   	    <dependency>
            <groupId>com.fsnip</groupId>
            <artifactId>lims-internal-rmi</artifactId>
            <version>1.0.0</version>
   	    </dependency>
```
NOTE: 若本地没有进行lims-internal-rmi install, 需要添加仓库指引:
```
<repositories>
        <repository>
            <id>fsnip</id>
            <name>released</name>
            <url>http://maven.fsnip.com/content/groups/public/</url>
        </repository>
</repositories>
```
* Step 2: 添加 spring bean, 如下：
```
    <bean id="当前项目bean名" class="org.springframework.remoting.rmi.RmiProxyFactoryBean">  
        <property name="serviceUrl" value="rmi://${XXX_RMI_URL}/服务名" />  
        <property name="serviceInterface" value="接口路径" />  
        <property name="refreshStubOnConnectFailure" value="true" />
    	<property name="lookupStubOnStartup" value="false" />
    </bean> 
    
    eg:
    <bean id="instrumentAutoService" class="org.springframework.remoting.rmi.RmiProxyFactoryBean">  
        <property name="serviceUrl" value="rmi://${IAS_RMI_URL}/instrumentAutoService" />  
        <property name="serviceInterface" value="com.fsnip.ias.InstrumentAutoService" />  
        <property name="refreshStubOnConnectFailure" value="true" />
    	<property name="lookupStubOnStartup" value="false" />
    </bean>
```
* 端口说明：
```
    lims-service-flow	9291	9091
    lims-service-oms	9292	9092
    lims-service-sample	9293	9093
    lims-service-mds	9294	9094
    lims-service-cms	9295	9095
    lims-service-tms	9297	9097
    lims-service-pms	9298	9098
    lims-service-ias	9299	9099
    lims-service-sms	9299	9099
    lims-web-flow		9191
    lims-web-oms		9192
    lims-web-sample		9193
    lims-web-mds		9194
    lims-web-cms		9195
    lims-web-ias		9197
    lims-web-pms		9198
    lims-web-tms		9199
    lims-web-core   	7070
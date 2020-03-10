### his_backend

web课程设计 东软云后端

### 基本知识

（1）SpringBoot框架

掌握SpringBoot框架的基本使用，包括其中一些常见注解的使用，例如：@controller，@service，@dao，@RequestMapping，@Configuration等，需要理解SpringBoot框架中的控制反转和依赖注入思想。熟悉SpringBoot框架中基本拦截器的使用以及如何处理前后端跨域。熟悉SpringBoot框架中的MVC思想，实现视图模型分离，合理设计后端项目结构。

（2）JSON Web Token跨域身份验证

学会使用JSON Web Token进行用户信息验证，理解生成、传递、解析token的原理，便于开发。

（3）MyBatis框架

学会使用MyBatis进行数据库表单和实体的高级映射，掌握MyBatis中的xml配置文件的格式，并且学会使用xml配置文件编写SQL查询语句，实现后端与数据库的操作。熟悉MyBatis框架与SpringBoot框架整合的相关配置。



### 数据库设计



![ER图](images\ER图.png)

### 类和对象详细设计

使用CommonResult封装结果类。

自定义返回的结果
 CommonResult由三部分构成：

状态码：前端根据返回的状态码来进行用户权限管理和鉴别后端处理状态
        200：操作成功
        500：操作失败
        404：参数检验失败
        401：暂未登陆或者token已经过期
        403：没有相关权限
 消息提示：后端返回消息提示，根据状态码返回制定的消息提示，也可以自定义其他具体的消息提示

数据：后端要返回给前端的数据如果不返回数据可直接传入NULL

PO类使用从数据库中取出的数据进行实例化，对应数据表字段。例如缴费明细类

@Data
 **public class** CostDetail {
   Integer **registid**;*//**挂号id
\*   Integer **proid**;*//**项目id
\*   Integer **protype**;*//**后期可以根据处方中的医生进行获取
\*   String **proname**;*//**项目名称
\*   **double profee**;*//**项目费用
\*   Integer **quantity**;*//**数量
\*   Integer **depid**;*//**科室id
\*   String **starttime**;*//**开立时间
\*   Integer **startPersonID**;*//**开立人员id
\*   String **chargtime**;*//**收费时间
\*   Integer **chargPersonID**;*//**从settlementvo**中获取，收费人员id
\*   Integer **chargType**;*//**从外面传进来
\* }

 

VO是用前端传来的数据进行实例化封装，对应前端json中的字段。例如从前端传来的诊断信息

@Data
 **public class** DiagnoseVO {
   Integer **illid**;*//**疾病id
\*   Integer **diagnosetype**;*//**诊断类型
\*   Integer **finaldiagnose**;*//**确诊号（1* *待诊 2* *已诊 3* *诊毕）
\*   Integer **medicalrecordid**;*//**病历号
\*   Integer **registid**;*//**挂号id
\*   String **diagnosetime**;*//**诊断时间
\* }


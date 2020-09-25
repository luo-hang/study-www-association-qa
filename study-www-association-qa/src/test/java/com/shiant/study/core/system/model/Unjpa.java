package com.shiant.study.core.system.model;

import com.shiant.study.common.util.JpaUtils;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class Unjpa {

        /**
         * 测试jpa的保存
         *     案例，保存一个客户到数据库中
         * jpa的操作步骤
         *     1.加载配置文件创建工厂(实体管理类工厂)对象
         *     2.通过实体管理类工厂获取实体管理器
         *     3.获取事物对象，开启事物
         *     4.完成增删改查操作
         *     5.提交事物（回滚事物）
         *     6.释放资源
         */
        @Test
        public void testSave(){
//        1.加载配置文件创建工厂(实体管理类工厂)对象
//            EntityManagerFactory factory = Persistence.createEntityManagerFactory("myJpa");
//        2.通过实体管理类工厂获取实体管理器
            EntityManager em = JpaUtils.getEntityManager();
//        3.获取事物对象，开启事物
            EntityTransaction tx = em.getTransaction();  //获取事物对象
            tx.begin(); //开启事物
//        4.完成增删改查操作(保存一个客户到数据库中)
            Univers univers = new Univers();
            univers.setUnNature("私立");
            univers.setUnName("帝国理工");
            //保存
            em.persist(univers); //保存操作
//        5.提交事物（回滚事物）
            tx.commit();
//        6.释放资源
            em.close();

        }




}

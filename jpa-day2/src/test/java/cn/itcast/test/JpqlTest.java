package cn.itcast.test;

import cn.itcast.dao.CustomerDao;
import cn.itcast.domain.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //声明spring提供的单元测试环境
@ContextConfiguration(locations = "classpath:applicationContext.xml") //指定spring容器的配置信息
public class JpqlTest {
    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testFindJpql(){
        Customer customer = customerDao.findJpql("传智播客");
        System.out.println(customer);
    }

    @Test
    public void findCustNameAndId(){
        Customer customer = customerDao.findCustNameAndId(1l, "传智播客");
        System.out.println(customer);
    }

    /**
     * 测试jpql的更新操作
     *      *  springDataJpa中使用jpql完成 更新/删除操作
     *      *  需要手动添加事物的支持
     *      *  默认会执行结束之后，回滚事物
     *  @Rollback : 设置是否自动回滚
     *      false | true
     */
    @Test
    @Transactional
    @Rollback(value = false)
    public void testUpdateCustomer(){
        customerDao.updateCustomer(4l,"黑马程序员");
    }

    @Test
    public void testFindSql(){
        List<Object[]> list = customerDao.findSql("传智播客%");
        for (Object[] obj : list
             ) {
            System.out.println(Arrays.toString(obj));
        }
    }

    //侧事故方法命名规则的查询
    @Test
    public void testNaming(){
        Customer customer = customerDao.findByCustName("传智播客");
        System.out.println(customer);
    }

    //侧事故方法命名规则的查询
    @Test
    public void testFindByCustNameLike(){
        List<Customer> list = customerDao.findByCustNameLike("传智播客%");
        for (Customer customer : list) {
            System.out.println(customer);
        }
    }

    //测试方法命名规则的查询
    @Test
    public void testFindByCustNameLikeAndCustIndustry(){
        customerDao.findByCustNameLikeAndCustIndustry("传智播客1%","it教育");
    }



}

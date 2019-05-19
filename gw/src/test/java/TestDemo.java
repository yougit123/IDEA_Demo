import com.at.pojo.Account;
import com.at.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author:  by AT
 * Description: PACKAGE_NAME
 * version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:bean.xml"})
public class TestDemo {
    @Autowired
    private IAccountService as ;
    @Test
    public void tesge (){
        Account accountById = as.findAccountById(3);
        System.out.println(accountById);
    }
    @Test
    public void tesges (){
        as.transfer("fff", "eee", 1f);
    }
}

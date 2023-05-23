import com.bryan02.three.Bean;
import com.bryan02.two.BeanOne;
import com.bryan02.two.BeanThree;
import com.bryan02.two.BeanTwo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanTest {
    @Test
    public void test1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanOne beanOne = applicationContext.getBean("beanOne", BeanOne.class);

        System.out.println(beanOne);
    }

    @Test
    public void test02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanTwo beanTwo = applicationContext.getBean("beanTwo", BeanTwo.class);

        System.out.println(beanTwo);
    }

    @Test
    public void test03() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        BeanThree beanThree = applicationContext.getBean("beanThree", BeanThree.class);

        System.out.println(beanThree);
    }

    @Test
    public void test04() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        com.bryan02.three.Bean beanThree = applicationContext.getBean("bean1", com.bryan02.three.Bean.class);

        System.out.println(beanThree);
    }

    @Test
    public void test05() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("annotate.xml");
        Bean bean = applicationContext.getBean("bean", Bean.class);

        System.out.println(bean);

        Bean bean2 = applicationContext.getBean("bean2", Bean.class);
        System.out.println(bean2);
    }
}
import com.dragon2.dao.UserDaoMySqlImpl;
import com.dragon2.service.UserService;
import com.dragon2.service.UserServiceImpl;

/**
 * @author yanchongsheng
 * @since 2022-07-26
 */
public class MyTest {
    public static void main(String[] args){

        UserService service = new UserServiceImpl();
        service.setUserDao(new UserDaoMySqlImpl());
        service.getUser();
    }
}

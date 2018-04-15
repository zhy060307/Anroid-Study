package zhy.com.annotation;

public interface IUserService {

    @ReqType(reqType = ReqTypeEnum.POST)
    @ReqUrl("http://www.baidu.com/")
    void login(@ReqParam("username") String username,
               @ReqParam("password") String password);
}



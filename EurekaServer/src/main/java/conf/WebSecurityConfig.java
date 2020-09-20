//package conf;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {
//
//    //解决集群时 服务不可用
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//        super.configure(http);
//
//    //方法1:
////    http.csrf().ignoringAntMatchers("**/eureka/**");
////    super.configure(http);
//
//        //注意，如果直接disable的话会把安全验证也禁用掉
////        http.csrf().disable().authorizeRequests()
////                .anyRequest()
////                .authenticated()
////                .and()
////                .httpBasic();
//    }
//}

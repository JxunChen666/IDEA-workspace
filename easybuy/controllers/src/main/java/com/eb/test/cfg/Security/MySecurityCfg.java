package com.eb.test.cfg.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.DefaultHttpFirewall;
import org.springframework.security.web.firewall.HttpFirewall;

import com.eb.test.servicesImpli.xu.Security.MyUserDetail;



@EnableWebSecurity
public class MySecurityCfg extends WebSecurityConfigurerAdapter {
	@Autowired
	MyUserDetail myUserDetail;
	 
	
		@Bean
	    public HttpFirewall httpFirewall() {
	        return new DefaultHttpFirewall();
	    }
	
	
  	//定义密码加密方式
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    
    //配置自定义userDetailsService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //设置自定义userService
        auth.userDetailsService(myUserDetail);
    }

	
	//定制请求的授权规则
	@Override
	protected void configure(HttpSecurity http) throws Exception {
			

		http.authorizeRequests()
								.antMatchers("/index").permitAll()
								.antMatchers("/product/**").hasAnyRole("0","1")
								.antMatchers("/membercollect/**").hasAnyRole("0","1")
								.antMatchers("/goIcon/**").hasAnyRole("0","1")	
								.antMatchers("/selectAllDqsSP/**").hasRole("1")	
								.antMatchers("/selectAllOrder/**").hasRole("1")				
								.antMatchers("/insertProductdq/**").hasRole("1")				
								.antMatchers("/buycar/**").hasAnyRole("0","1");
							
		

		
		//开启自动配置的登录功能 /login 请求来到登录页,登录失败则重定向到 /login?error
		//默认post形式的请求代表处理登录h
		//一旦定制loginpage，那么loginpag 的 url post 请求就是处理登录
		http.formLogin()
			.usernameParameter("user")
			.passwordParameter("pwd")
			.loginPage("/userlogin")
			//登录成功跳转界面
			.successForwardUrl("/SSLoginsuccess")
			//登陆失败跳转
			.failureUrl("/loginfail");		
		
		//开启注销功能
		
		http.logout().logoutSuccessUrl("/index");//注销成功返回到此url
		
		//开启记住我功能
		http.rememberMe().rememberMeParameter("remember");
		
		
		
	}

	

	
		//定制请求的认证规则ss5 以下版本
	/*	@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			//new BCryptPasswordEncoder().encode("123456") Spring Security 5 密码需要加密
			auth.inMemoryAuthentication().withUser("laoliu").password(passwordEncoder().encode("123456")).roles("vip1","vip2")
										 .and().withUser("admin").password(passwordEncoder().encode("123456")).roles("vip1","vip2","vip3");
										 
			//super.configure(auth);
		}*/
	
	
	
		//定制请求的认证规则 报错There is no PasswordEncoder mapped for the id "null" 时使用
	
/*	    @Autowired
	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	        auth.inMemoryAuthentication() //认证信息存储到内存中
	                .passwordEncoder(passwordEncoder())
	                .withUser("laoliu").password(passwordEncoder().encode("123456")).roles("vip1","vip2")
					.and().withUser("admin").password(passwordEncoder().encode("123456")).roles("vip1","vip2","vip3");
	    }
	  	*/
	  

	
}

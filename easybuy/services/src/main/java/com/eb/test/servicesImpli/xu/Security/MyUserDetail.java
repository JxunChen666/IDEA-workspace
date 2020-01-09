package com.eb.test.servicesImpli.xu.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.eb.test.MapperDao.EasybuyUserMapper;
import com.eb.test.model.EasybuyUser;

@Component
public class MyUserDetail implements UserDetailsService {
	@Autowired
	EasybuyUserMapper userMapper;
	
	
	@Bean
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		/**
		 * 执行用户登录
		 */
		System.out.println("用户登录名为：" + name);

        if(name.contains("|")) {
        	System.out.println("||||||||");
        	String[] myname=name.split("\\|");
        	name=myname[1];
        }
        
		EasybuyUser	ebu = userMapper.selectUserByName(name);
	
		
		System.out.println(ebu.toString());
		// new BCryptPasswordEncoder().encode("123")
		
		//角色必须以`ROLE_`开头，数据库中没有，则在这里加
		String ro="ROLE_" +ebu.getType();	
  //      authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
		
        
        System.out.println(ro);
        
        
        name=ebu.getId()+"|"+ebu.getLoginname();
        
        System.out.println("NAME "+name);
		return new User(name,new BCryptPasswordEncoder().encode(ebu.getPassword()), AuthorityUtils.commaSeparatedStringToAuthorityList(ro));
	
	
	}

}

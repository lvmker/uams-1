package com.bgi.uams.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.bgi.uams.beans.User;
import com.bgi.uams.dao.UamsUserDao;

public class UamsShiroRealm extends AuthorizingRealm implements  Realm,InitializingBean{

    private Logger logger=Logger.getLogger(UamsShiroRealm.class);
    @Autowired
    private UamsUserDao uamsUserDao;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
	// TODO Auto-generated method stub
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(); 
        Set<String> roles = new HashSet<String>();  
        Set<String> permissions = new HashSet<String>();
	try {
	        String username = (String) super.getAvailablePrincipal(arg0);  
	        logger.info("开始授权："+username);
	        User user = uamsUserDao.getUamsUser(username);
	} catch (Exception e) {
	    // TODO: handle exception
	}
//        for (Role role : user.getRoleSet()) {  
//            roles.add(role.getName());  
//            for (Permission per : role.getPermissionSet()) {  
//                permissions.add(per.getName());  
//            }  
//        }  
  
        info.addRoles(roles);  
        info.addStringPermissions(permissions);  
  
        return info; 
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
	    AuthenticationToken arg0) throws AuthenticationException {
	// TODO Auto-generated method stub
	SimpleAuthenticationInfo info = null;
	try {
		UsernamePasswordToken token = (UsernamePasswordToken) arg0;  
		String username = token.getUsername();  
		logger.info("认证用户："+username);
		User user=uamsUserDao.getUamsUser(username);
	        if (user == null) {  
	            throw new AuthenticationException();  
	        }  
	        info = new SimpleAuthenticationInfo(user.getUserName(), user.getUserMd5Pwd(), getName());  
	} catch (Exception e) {
	    // TODO: handle exception
	}
       return info;

    }

    public void afterPropertiesSet() throws Exception {
	// TODO Auto-generated method stub
	Assert.notNull(uamsUserDao); 
    }  
}
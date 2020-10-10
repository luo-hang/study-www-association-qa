package com.shiant.user.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.rmi.RmiServiceExporter;

import com.shiant.rmi.user.ExpertToEnterpriseRmiService;
import com.shiant.rmi.user.OrganizationRmiService;
import com.shiant.rmi.user.RoleRmiService;
import com.shiant.rmi.user.UserRmiService;
import com.shiant.user.core.rmi.impl.ExpertToEnterpriseRmiServiceImpl;
import com.shiant.user.core.rmi.impl.OrganizationRmiServiceImpl;
import com.shiant.user.core.rmi.impl.RoleRmiServiceImpl;
import com.shiant.user.core.rmi.impl.UserRmiServiceImpl;

@Configuration
public class RmiConfig {
	
	@Autowired
	UserRmiServiceImpl userRmiService;
	
	@Autowired
	OrganizationRmiServiceImpl organizationRmiService;
	
	@Autowired
	RoleRmiServiceImpl roleRmiService;

	@Autowired
	ExpertToEnterpriseRmiServiceImpl expertToEnterpriseRmiService;
	
	@Value("${rmi.registryPort}")
	int registryPort;

	@Value("${rmi.servicePort}")
	int servicePort;
	
	@Bean  
	public RmiServiceExporter userRmiServiceExporter(){  
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();  
		rmiServiceExporter.setRegistryPort(registryPort);  
		rmiServiceExporter.setServicePort(servicePort);
		rmiServiceExporter.setServiceName("userRmiService");  
		rmiServiceExporter.setService(userRmiService);   
		rmiServiceExporter.setServiceInterface(UserRmiService.class) ;  
		return rmiServiceExporter ;  
	}  	

	@Bean  
	public RmiServiceExporter organizationRmiServiceExporter(){  
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();  
		rmiServiceExporter.setRegistryPort(registryPort);  
		rmiServiceExporter.setServicePort(servicePort);
		rmiServiceExporter.setServiceName("organizationRmiService");  
		rmiServiceExporter.setService(organizationRmiService);   
		rmiServiceExporter.setServiceInterface(OrganizationRmiService.class) ;  
		return rmiServiceExporter ;  
	}  	

	@Bean  
	public RmiServiceExporter roleRmiServiceExporter(){  
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();  
		rmiServiceExporter.setRegistryPort(registryPort);  
		rmiServiceExporter.setServicePort(servicePort);
		rmiServiceExporter.setServiceName("roleRmiService");  
		rmiServiceExporter.setService(roleRmiService);   
		rmiServiceExporter.setServiceInterface(RoleRmiService.class) ;  
		return rmiServiceExporter ;  
	}  	

	@Bean  
	public RmiServiceExporter expertToEnterpriseRmiServiceExporter(){  
		RmiServiceExporter rmiServiceExporter = new RmiServiceExporter();  
		rmiServiceExporter.setRegistryPort(registryPort);  
		rmiServiceExporter.setServicePort(servicePort);
		rmiServiceExporter.setServiceName("expertToEnterpriseRmiService");  
		rmiServiceExporter.setService(expertToEnterpriseRmiService);   
		rmiServiceExporter.setServiceInterface(ExpertToEnterpriseRmiService.class) ;  
		return rmiServiceExporter ;  
	}  	
	
}

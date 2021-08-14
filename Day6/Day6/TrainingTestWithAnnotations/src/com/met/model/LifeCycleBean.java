package com.met.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/*<bean class="com.met.model.LifeCycleBean" id="lifeCycleBean">*/

@Component
public class LifeCycleBean implements BeanNameAware/*implements InitializingBean, DisposableBean*/{

	public LifeCycleBean() {
		super();
		System.out.println("LifeCycleBean :: Default COnstructor invoked");
	}

	/*@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LifeCycleBean :: InitializingBean :: afterPropertiesSet");
		System.out.println("Initialize 20 connection bean objects");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("LifeCycleBean :: DisposableBean :: destroy");
		System.out.println("close 20 connection objecte created in postconrtuction of object "
				+ " or during initialization phase");
		
	}*/

	
	public void myInit(){
		System.out.println("LifeCycleBean :: init-method :: myInit  ");
		System.out.println("XML way to Initialize 20 connection bean objects");
	}
	
	
	public void myDestroy(){
		System.out.println("LifeCycleBean :: destroy-method :: myDestroy");
		System.out.println("XML way close 20 connection objecte created in postconrtuction of object "
				+ " or during initialization phase");
	}
	
	@PostConstruct
	public void customInit(){
		System.out.println("LifeCycleBean :: @PostConstruct :: customInit  ");
		System.out.println("Annotation way to Initialize 20 connection bean objects");
	}
	
	
	@PreDestroy
	public void customDestroy(){
		System.out.println("LifeCycleBean :: @PreDestroy :: customDestroy  ");
		System.out.println("Annotation way close 20 connection objecte created in postconrtuction of object "
				+ " or during initialization phase");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("Bean Name Created by SpringContainer is " + name);
		
	}
}

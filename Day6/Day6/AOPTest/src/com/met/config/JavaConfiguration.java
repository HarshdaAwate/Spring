package com.met.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.met.model.DotNetTrainer;
import com.met.model.JavaDotNetTrainer;
import com.met.model.JavaTrainer;
import com.met.model.Trainer;

@Configuration									//<beans
@ComponentScan(basePackages="com.met.model,com.met.aspect")					//<context:component-scan base-package="com.met.model" />
@PropertySource("classpath:app.properties")
public class JavaConfiguration {

	/*<bean id="javaTrainer1" class="com.met.model.JavaTrainer" >   primary="true"
			<property name="name" value="Ram"></property>
			<property name="subjects">
				<list>
					<value>OOPS</value>
					<value>COLLECTIONS</value>
					<value>JDBC</value>
				</list>
			</property>
		</bean>*/
		
	
	@Value("${javaTrainer1.name}")
	private String trainer1Name;
	
	@Value("#{${javaTrainer1.subjects}}")				//Expression Language
	private List<String> trainer1Subjects;
	
	
	@Value("${dotNetTrainer.name}")
	private String dotNetTrainerName;
	
	@Value("#{${dotNetTrainer.subjects}}")
	private List<String> dotNetSubjects;
	
	
	@Bean("javaTrainer1")										//<bean id="" in xml
	//@Lazy
	//@Scope("Prototype")
	public Trainer javaTrainer(){				//methodName specifies id of Spring bean
		
		/*JavaTrainer trainer = new JavaTrainer();
		trainer.setName("Ram");
		
		List<String> subjects = new ArrayList<String>();
		subjects.add("OOPS");
		subjects.add("COLLECTIONS");
		subjects.add("JDBC");
		
		trainer.setSubjects(subjects);*/
		
		
		JavaTrainer trainer = new JavaTrainer();
		trainer.setName(trainer1Name);
		trainer.setSubjects(trainer1Subjects);
		
		return trainer;
		
	}
	
	@Bean
	public Trainer javaTrainer2(){
		JavaTrainer trainer = new JavaTrainer();
		trainer.setName("Sham");
		
		List<String> subjects = new ArrayList<String>();
		subjects.add("HIBERNATE");
		subjects.add("JSP");
		subjects.add("SERVLETS");
		
		trainer.setSubjects(subjects);
		
		return trainer;
	}
	
	@Bean
	public Trainer dotNetTrainer(){
		
		/*List<String> subjects = new ArrayList<>();
		subjects.add("OOPS");
		subjects.add("C#");
		subjects.add("REMOTING");
		
		
		DotNetTrainer trainer = new DotNetTrainer("Ramesh", subjects);*/
		
		DotNetTrainer trainer = new DotNetTrainer(dotNetTrainerName, dotNetSubjects);
		
		
		return trainer;
		
	}
	
	
	@Bean
	public JavaDotNetTrainer javaDotNetTrainer(){
		
		List<String> subjects = new ArrayList<>();
		subjects.add("OOPS");
		subjects.add("C#");
		subjects.add("REMOTING");
		subjects.add("JSP");
		subjects.add("Servlets");
		
		JavaDotNetTrainer trainer = new JavaDotNetTrainer("Tom", subjects);
		
		return trainer;
		
	}
	
}

package kr.or.kosta.spring.sample.di;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("restaurant")
public class Restaurant {
	
	   @Value("희진이네레스토랑")
	   private String name;
//	   @Autowired
	   @Inject
	   private Chef chef;

	   public Restaurant() {
	      super();
	   }

	   public Restaurant(String name, Chef chef) {
	      super();
	      this.name = name;
	      this.chef = chef;
	   }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", chef=" + chef + "]";
	}

	@PostConstruct
	public void init() {
		System.out.println("빈 초기화 메소드");
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("청소 메소드");
	}
}

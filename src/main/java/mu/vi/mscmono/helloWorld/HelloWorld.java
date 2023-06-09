package mu.vi.mscmono.helloWorld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping(path = "/helloWorld")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/helloWorldBean")
	public HelloWroldBean helloWorldBean() {
		
		return new HelloWroldBean("Hello World");
	}
	
	@GetMapping(path = "/hello/{name}")
	public HelloWroldBean hello(@PathVariable String name) {
		return new HelloWroldBean("Hello "+name);
	}
}

package ${package}.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class FooServiceImpl implements FooService {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	public void sayHello(String name) {
		log.debug(" ----- sayHello method invoke ----- ");
		System.out.println(name);
	}

}

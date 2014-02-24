package ${package};

import java.util.Calendar;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
	static final Random random = new Random();
	
	@Autowired
	private FooService fooService;
	
	@ResponseBody
	@RequestMapping(value = "/foo", method = RequestMethod.GET)
	public Foo getFoo() {
		log.debug(" ----- foo method invoke ----- ");
		final String value = "Hello Spring MVC";
		fooService.sayHello(value);
		return new Foo(value);
	}
	
	class Foo {
		private long id;
		private String value;
		private Calendar date;

		public Foo(String value) {
			super();
			this.value = value;
			this.id = random.nextLong();
			this.date = Calendar.getInstance();
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public Calendar getDate() {
			return date;
		}

		public void setDate(Calendar date) {
			this.date = date;
		}

	}
}

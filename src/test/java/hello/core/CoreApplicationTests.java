package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CoreApplicationTests {

	@Autowired
	MemberService memberService;

	@Test
	void contextLoads() {

	}

}
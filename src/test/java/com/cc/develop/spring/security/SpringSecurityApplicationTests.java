package com.cc.develop.spring.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringSecurityApplicationTests {

    @Test
    public void test01(){

        /**
         * BCryptPasswordEncoder 是对 bcrypt 强散列方法的具体实现。是基于 Hash 算法实现的单
         * 向加密。可以通过 strength 控制加密强度，默认 10.
         */
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String develop = passwordEncoder.encode("develop");
        //$2a$10$.xYkWDIZbPbOgQdUTo05OOQArp2VxqSiAWIXL5HrcXx.dtYTdDckm
        //$2a$10$ibNzQZ0wKT9wofKyKFrSsuIehKP88/UUTfeoI6kC54xM2PjkAfje2
        System.out.println("加密后的数据="+develop);

        // 判断原字符加密后和加密之前是否匹配
        boolean result = passwordEncoder.matches("develop", develop);
        System.out.println("匹配后的结果"+result);

    }
}

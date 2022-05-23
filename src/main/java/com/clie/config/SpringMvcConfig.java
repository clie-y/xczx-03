package com.clie.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author： CleanLoamy
 * @date 2022/5/18
 */

@Configuration
@ComponentScan({"com.clie.controller"})
@EnableWebMvc
public class SpringMvcConfig {
}

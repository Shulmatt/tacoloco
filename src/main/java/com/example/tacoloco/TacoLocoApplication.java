package com.example.tacoloco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
@Controller
public class TacoLocoApplication {

  public static void main(String[] args) {
    SpringApplication.run(TacoLocoApplication.class, args);
  }
}

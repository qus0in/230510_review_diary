package io.playdata.diary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiaryApplication {

	// 1. port 겹침
	// 2. mysql 관련된 설정 X
	public static void main(String[] args) {
		SpringApplication.run(DiaryApplication.class, args);
	}

}

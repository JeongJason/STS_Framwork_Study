package com.example.ex02.domain.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class InfoDTO {
	private String name;
	private int age;
}

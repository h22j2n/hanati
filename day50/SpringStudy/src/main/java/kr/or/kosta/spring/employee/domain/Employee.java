package kr.or.kosta.spring.employee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor //디폴트 생성자
@Data
public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String email;
	

}

/**
 * 학생 객체 추상화
 */

/** 사용자 정의 객체(생성자) */
	function Student(name, korean, math, english, science) {
		this.name = name;
		this.korean = korean;
		this.math = math;
		this.english = english;
		this.science = science;

	}

	Student.schoolName = 'KOSTA 대학교'; // Student만을 위한 공유변수

	// 프로토타입에 메소드 저장
	Student.prototype.getSum = function() {
		return this.korean + this.math + this.english + this.science;
	};
	Student.prototype.getAverage = function() {
		return this.getSum() / 4;
	};
	Student.prototype.toString = function() { // 이때는 함수라고 하기보다 메소드라고 함
		return this.name + '\t' + this.korean + '\t' + this.math + '\t'
				+ this.english + '\t' + this.science;
	};
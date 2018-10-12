/**
 * 학생 객체 추상화
 */

var kosta = {}; // object 생성

kosta.school={}; // object 생성(패키지 개념처럼 쓰려고)

kosta.school.Student = function(name, korean, math, english, science){
	this.name = name;
	this.korean = korean;
	this.math = math;
	this.english = english;
	this.science = science;
}


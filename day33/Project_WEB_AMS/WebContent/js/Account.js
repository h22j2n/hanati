/**
 * Account 객체 추상화
 */

function Account(accountNum, accountOwner, passwd, restMoney) {
	this.accountNum = accountNum;
	this.accountOwner = accountOwner;
	this.passwd = passwd;
	this.restMoney = restMoney;
}

Account.bankName = 'Kosta은행';

Account.prototype.deposit = function(money) {
	this.restMoney += money;
	return this.restMoney;
}

Account.prototype.withdraw = function(money) {
	this.restMoney -= money;
	return this.restMoney;
}

Account.prototype.checkPasswd = function(pw) {
	return this.passwd == pw;
}

Account.prototype.toString = function() {
	return this.accountNum + '\t' + this.accountOwner + '\t' + this.restMoney;
}

/**
 * Account를 확장한 마이너스 계좌
 */

function MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney) {
	Account.call(this, accountNum, accountOwner, passwd);
	this.restMoney = restMoney - borrowMoney;
	this.borrowMoney = borrowMoney;
}

MinusAccount.prototype = new Account();

MinusAccount.prototype.toString = function() {
	return this.accountNum + '\t' + this.accountOwner + '\t' + this.restMoney
			+ '\t' + this.borrowMoney;
}

MinusAccount.prototype.constructor = MinusAccount;

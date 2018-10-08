/**
 * 은행계좌 관리
 */

function AccountManager() {
	this.accounts = new Array();
}

/* 계좌 추가 */
AccountManager.prototype.add = function(account) {
	for ( var i in this.accounts) {
		if (this.accounts[i].accountNum == account.accountNum) {
			alert('이미 등록된 계좌입니다.');
			return;
		}
	}
	this.accounts.push(account);

}

/* 계좌 목록 조회(입출금계좌, 마이너스계좌 순) */
AccountManager.prototype.list = function() {
	var result = new Array();
	for (var i = 0; i < this.accounts.length; i++) {
		if (!(this.accounts[i] instanceof MinusAccount)) {
			result.push(this.accounts[i]);
		}
	}
	for (var i = 0; i < this.accounts.length; i++) {
		if (this.accounts[i] instanceof MinusAccount) {
			result.push(this.accounts[i]);
		}
	}
	
	return result;
}

/* 계좌번호로 계좌 검색 */
AccountManager.prototype.get = function(accountNum) {
	if (accountNum.length < 1) {
		alert('계좌번호를 입력해주세요.');
		return;
	} else {
		for ( var i in this.accounts) {
			if (this.accounts[i].accountNum == accountNum) {
				flag = true;
				return this.accounts[i];
			}
		}
		alert('존재하지 않는 계좌입니다.');
		return null;
	}
}

/* 이름으로 계좌 검색 */
AccountManager.prototype.search = function(accountOwner) {
	for ( var i in this.accounts) {
		if (this.accounts[i].accountOwner == accountOwner) {
			return this.accounts[i];
		}
	}
	alert('예금주가 존재하지 않습니다.');
	return null;
}

/* 계좌번호 삭제 */
AccountManager.prototype.remove = function(accountNum) {
	for ( var i in this.accounts) {
		if (this.accounts[i].accountNum == accountNum) {
			delete this.accounts[i];
			alert('삭제가 완료되었습니다.');
			return true;
		}
	}
	alert('존재하지 않는 계좌입니다.');
	return false;
}

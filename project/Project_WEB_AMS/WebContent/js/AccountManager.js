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
			return '중복';
		}
	}
	
	this.accounts.push(account);
	return '추가';

}

/* 계좌 목록 조회(입출금계좌, 마이너스계좌 -> 이름 순) */
AccountManager.prototype.list = function() {
	var result = new Array();
	var tmp = new Array();
	for (var i = 0; i < this.accounts.length; i++) {
		if (!(this.accounts[i] instanceof MinusAccount)) {
			tmp.push(this.accounts[i]);
		}
	}
	tmp.sort(function(a,b){
		var nameA = a.accountOwner.toUpperCase();
		var nameB = b.accountOwner.toUpperCase();
		if (nameA < nameB) {
		    return -1;
		  }
		  if (nameA > nameB){
			  return 1;
		  }

		  return  0;
	});
	for ( var i in tmp) {
		result.push(tmp[i]);
	}
	
	tmp.length =0;
	
	for (var i = 0; i < this.accounts.length; i++) {
		if (this.accounts[i] instanceof MinusAccount) {
			tmp.push(this.accounts[i]);
		}
	}
	tmp.sort(function(a,b){
		var nameA = a.accountOwner.toUpperCase();
		var nameB = b.accountOwner.toUpperCase();
		if (nameA < nameB) {
		    return -1;
		  }
		  if (nameA > nameB){
			  return 1;
		  }

		  return  0;
	});
	for ( var i in tmp) {
		result.push(tmp[i]);
	}
	return result;
}

/* 계좌번호로 계좌 검색 */
AccountManager.prototype.get = function(accountNum) {

	for ( var i in this.accounts) {
		if (this.accounts[i].accountNum == accountNum) {
			flag = true;
			return this.accounts[i];
		}
	}
	return null;
}

/* 이름으로 계좌 검색 */
AccountManager.prototype.search = function(accountOwner) {
	var result = new Array();
	for ( var i in this.accounts) {
		if (this.accounts[i].accountOwner == accountOwner) {
			result.push(this.accounts[i]);
		}
	}
	if (result.length < 1) {
		return null;
	}
	return result;
}

/* 계좌번호 삭제 */
AccountManager.prototype.remove = function(accountNum) {
	for ( var i in this.accounts) {
		if (this.accounts[i].accountNum == accountNum) {
			this.accounts.splice(i, 1);
			return true;
		}
	}
	return false;
}


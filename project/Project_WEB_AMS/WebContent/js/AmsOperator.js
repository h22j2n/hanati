/**
 * ams.html에 해당하는 함수들
 */

var openWin;
var manager = new AccountManager();
var table;
var sender;
var receiveAccNum;
var receiveName;
var receivePasswd;

/* 초기화 */
function init() {
	var frm_elements = document.getElementById('myForm').elements;
	for (i = 0; i < frm_elements.length; i++) {
		field_type = frm_elements[i].type.toLowerCase();
		switch (field_type) {
		case "text":
		case "password":
		case "search":
			frm_elements[i].value = null;
			break;
		case "select-one":
		case "select-multi":
			frm_elements[i].selectedIndex = 0;
			break;
		default:
			break;
		}
	}

}

/* 수정된 정보 받아오기 */
function receive() {
	if (receiveAccNum != null) {
		var account = manager.get(receiveAccNum);
		account.accountOwner = receiveName;
		account.passwd = receivePasswd;
		listAccount();
		notice('adjust');
	}
}

/* 첫 시작 시 테이블 내용없음을 보여줌 */
function noneElements() {
	var body = document.getElementById('insertBody');
	var tr = document.createElement('tr');
	var td = document.createElement('td');
	td.setAttribute("colSpan", "5");
	td.setAttribute('id', 'none');
	td.innerHTML = '내용이 없습니다.';
	tr.appendChild(td);
	body.appendChild(tr);
}

/** 이벤트소스에 이벤트리스너 등록 */
function eventRegist() {
	var listnerRegist = document.getElementById('regist');
	listnerRegist.onclick = function() {
		add();
	}
	var listnerShow = document.getElementById('show');
	listnerShow.onclick = function() {
		show();
	}
	var listnerDelete = document.getElementById('delete');
	listnerDelete.onclick = function() {
		removeAccount();
	}
	var listnerList = document.getElementById('listall');
	listnerList.onclick = function() {
		listAccount();
	}
	var listnerSearch = document.getElementById('search');
	listnerSearch.onclick = function() {
		nameSearch();
	}
	var listnerSelect = document.getElementById('kind');
	listnerSelect.onclick = function() {
		able();
	}
	var keySearchAcc = document.getElementById('SearchAccNum');
	keySearchAcc.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			show();
		}
	}
	var keySearchName = document.getElementById('searchName');
	keySearchName.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			nameSearch();
		}
	}
	var keyRegistName = document.getElementById('name');
	keyRegistName.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			add();
		}
	}
	var keyRegistAcc = document.getElementById('accountNumber');
	keyRegistAcc.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			add();
		}
	}
	var keyRegistPasswd = document.getElementById('passwd');
	keyRegistPasswd.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			add();
		}
	}
	var keyRegistDeposit = document.getElementById('deposit');
	keyRegistDeposit.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			add();
		}
	}
	var keyRegistLoan = document.getElementById('loan');
	keyRegistLoan.onkeyup = function(e) {
		var event = e || window.event;
		if (e.keyCode == 13) {
			add();
		}
	}
	var listnerKind = document.getElementById('searchKind');
	listnerKind.onclick = function() {
		kindSearch();
	}

}

/* 계좌종류별로 검색 */
function kindSearch() {
	var list = manager.list();
	var accounts = new Array();
	if (document.getElementById('searchKind').value == '마이너스 계좌') {
		for ( var i in list) {
			if (list[i] instanceof MinusAccount) {
				accounts.push(list[i]);
			}
			
		}
		inputTemplate(accounts);
	} else if(document.getElementById('searchKind').value == '입출금 계좌') {
		for ( var i in list) {
			if (!(list[i] instanceof MinusAccount)) {
				accounts.push(list[i]);
			}
		}
		inputTemplate(accounts);
	}else{
		reset();
	}
	
	accounts.length = 0;
	rowEvent();
}

/* 테이블클릭 시 정보 수정 창 띄우기 */
function openModify() {
	window.name = "parentForm";
	openWin = window.open("modify.html", "childForm",
			"width=570, height=350, resizable = no, scrollbars = no");

}

/* 수정 창에게 정보 전달 */
function setModify() {
	openWin.document.getElementById('adjustKind').value = document
			.getElementById('tableAccKind').firstChild.textContent.toString();
}

/* 대출금액 활성화/비활성화 */
function able() {
	if (document.getElementById('kind').value == '마이너스 계좌') {
		document.getElementById('loan').disabled = false;
		document.getElementById('loan').placeholder = '예) 10000';
	} else {
		document.getElementById('loan').disabled = true;
		document.getElementById('loan').placeholder = '';
	}
}

/* 검색 시 테이블템플릿에 넣는 함수 */
function inputTemplate(accounts) {
	if (accounts != null) {
		// 내용이 없습니다. 삭제
		if (document.getElementById('none')) {
			var table = document.getElementById('insertBody');
			table.removeChild(table.lastChild);

		}
		var data = new Array();
		var tmp = null;
		for (var i = 0; i < accounts.length; i++) {
			if (accounts[i] instanceof MinusAccount) {

				tmp = {
					accountKind : '마이너스계좌',
					accountNum : accounts[i].accountNum,
					name : accounts[i].accountOwner,
					deposit : accounts[i].restMoney.toString().replace(
							/\B(?=(\d{3})+(?!\d))/g, ','),
					loan : accounts[i].borrowMoney.toString().replace(
							/\B(?=(\d{3})+(?!\d))/g, ',')
				}
			} else {
				tmp = {
					accountKind : '입출금계좌',
					accountNum : accounts[i].accountNum,
					name : accounts[i].accountOwner,
					deposit : accounts[i].restMoney.toString().replace(
							/\B(?=(\d{3})+(?!\d))/g, ','),
					loan : ''
				}
			}
			data.push(tmp);
		}
		template(data);

	}

}

/* 계좌번호로 계좌 검색 함수 */
function show() {
	if (accountAvailability()) {
		var accountNum = document.all.SearchAccNum.value;
		if (manager.get(accountNum) != null) {
			var account = manager.get(accountNum);
			var accounts = new Array();
			accounts.push(account);
			inputTemplate(accounts);
		} else {
			notice('noAcc');
		}
		document.getElementById('SearchAccNum').value = '';
	}
}

/* 계좌 삭제 함수 */
function removeAccount() {
	if (accountAvailability()) {
		var accountNum = document.all.SearchAccNum.value;
		if (!manager.remove(accountNum)) {
			notice('noAcc');
			reset();
		} else {
			notice('remove');
			listAccount();
		}
		init();

	}
}

/* 해당 계좌가 존재하지 않을 시 내용없음만을 보여줌 */
function reset() {
	if (document.getElementsByClassName('insertTr')) {
		var table = document.getElementById('insertBody');
		var len = table.childNodes.length;
		for (var i = 0; i < len; i++) {
			table.removeChild(table.lastChild);
		}
	}
	noneElements();
}

/* 전체 계좌 조회 함수 */
function listAccount() {
	var accounts = manager.list();
	inputTemplate(accounts);
	rowEvent();

}

/* 테이블 열에 이벤트 부여(더블클릭) */
function rowEvent() {
	table = document.getElementById('insertTable');
	for (var i = 1; i < table.rows.length; i++) {
		(function(i) {
			table.rows[i].ondblclick = function() {
				var acc = table.rows[i].childNodes[3].innerHTML;
				acc = acc.trim();
				sender = manager.get(acc);
				openModify();
			};
		})(i);
	}
}

/* 이름으로 계좌 조회 함수 */
function nameSearch() {
	if (nameAvailability()) {
		var accountOwner = document.all.searchName.value;
		if (manager.search(accountOwner) != null) {
			var accounts = manager.search(accountOwner);
			inputTemplate(accounts);
		} else {
			notice('noAcc');
			reset();
		}
		document.getElementById('searchName').value = '';
	}

}

/* 테이블에 추가하는 템플릿 */
function template(data) {
	var html = document.querySelector("#template-table").innerHTML;

	var resultHTML = "";

	for (var i = 0; i < data.length; i++) {
		resultHTML += html.replace("{accountKind}", data[i].accountKind)
				.replace("{accountNum}", data[i].accountNum).replace("{name}",
						data[i].name).replace("{deposit}", data[i].deposit)
				.replace("{loan}", data[i].loan);

	}

	document.querySelector('#insertBody').innerHTML = resultHTML;
}

/* 계좌 등록 함수 */
function add() {
	if (registAvailability()) {
		var accountNum = document.getElementById('accountNumber').value;
		var accountOwner = document.getElementById('name').value;
		var passwd = document.getElementById('passwd').value;
		var restMoney = document.getElementById('deposit').value;
		var borrowMoney = document.getElementById('loan').value;

		if (document.getElementById('kind').value == '입출금 계좌') {
			if (manager.add(new Account(accountNum, accountOwner, passwd,
					restMoney)) == '추가') {
				notice('create');
				init();
				listAccount();
				document.getElementById('accountNumber').style.backgroundColor = '#ffffff';
				
			} else {
				notice('overlap');
				document.getElementById('accountNumber').style.backgroundColor = '#fff000';
				document.getElementById('accountNumber').focus();
			
			}
		} else {
			if (manager.add(new MinusAccount(accountNum, accountOwner, passwd,
					restMoney, borrowMoney)) == '추가') {
				notice('create');
				init();
				listAccount();
				document.getElementById('accountNumber').style.backgroundColor = '#ffffff';
				

			
			} else {
				notice('overlap');
				document.getElementById('accountNumber').style.backgroundColor = '#fff000';
				document.getElementById('accountNumber').focus();
			}

		}
		
	}
}

/* 계좌번호로 검색/삭제 시 유효성 검증하는 함수 */
function accountAvailability() {
	var regAccount = /^[0-9]{4}-[0-9]{4}-[0-9]{4}$/;

	if (document.getElementById('SearchAccNum').value.length < 1) {
		document.getElementById('SearchAccNum').placeholder = '계좌번호를 입력하세요.';
		document.getElementById('SearchAccNum').style.backgroundColor = '#fff000';
		document.getElementById('SearchAccNum').focus();
		return false;
	}
	document.getElementById('SearchAccNum').style.backgroundColor = '#ffffff';
	if (!regAccount.test(document.getElementById('SearchAccNum').value)) {
		document.getElementById('SearchAccNum').value = '';
		document.getElementById('SearchAccNum').placeholder = '계좌형식에 맞게 입력하세요.';
		document.getElementById('SearchAccNum').style.backgroundColor = '#fff000';
		document.getElementById('SearchAccNum').focus();
		return false;
	}
	document.getElementById('SearchAccNum').style.backgroundColor = '#ffffff';
	return true;
}

/* 이름으로 검색 시 유효성 검증하는 함수 */
function nameAvailability() {
	var regName = /^[가-힣|a-z|A-Z|\*]+$/;

	if (document.getElementById('searchName').value.length < 1) {
		document.getElementById('searchName').placeholder = '이름을 입력하세요.';
		document.getElementById('searchName').style.backgroundColor = '#fff000';
		document.getElementById('searchName').focus();
		return false;
	}
	document.getElementById('searchName').style.backgroundColor = '#ffffff';
	if (!regName.test(document.getElementById('searchName').value)) {
		document.getElementById('searchName').value = "";
		document.getElementById('searchName').placeholder = '한글, 영문으로 입력하세요.';
		document.getElementById('searchName').style.backgroundColor = '#fff000';
		document.getElementById('searchName').focus();
		return false;
	}
	document.getElementById('searchName').style.backgroundColor = '#ffffff';
	return true;
}

/* 계좌 등록시 유효성 검증하는 함수 */
function registAvailability() {
	var regName = /^[가-힣|a-z|A-Z|\*]+$/;
	var regPasswd = /[0-9]{4}/;
	var regMoney = /^(0|[1-9][0-9]*)$/;
	var regAccount = /^[0-9]{4}-[0-9]{4}-[0-9]{4}$/;

	document.getElementById('kindLabel').innerText = '';

	if (document.getElementById('kind').value == '전체') {
		document.getElementById('kindLabel').innerText = '계좌종류를 선택해주세요.'
		document.getElementById('kind').focus();
		return false;
	}
	if (document.getElementById('name').value.length < 1) {
		document.getElementById('name').placeholder = '이름을 입력하세요.';
		document.getElementById('name').style.backgroundColor = '#fff000';
		document.getElementById('name').focus();
		return false;
	}
	document.getElementById('name').style.backgroundColor = '#ffffff';
	if (!regName.test(document.getElementById('name').value)) {
		document.getElementById('name').value = "";
		document.getElementById('name').placeholder = '한글, 영문으로 입력하세요.';
		document.getElementById('name').style.backgroundColor = '#fff000';
		document.getElementById('name').focus();
		return false;
	}
	document.getElementById('name').style.backgroundColor = '#ffffff';
	if (document.getElementById('accountNumber').value.length < 1) {
		document.getElementById('accountNumber').placeholder = '계좌번호를 입력하세요.';
		document.getElementById('accountNumber').style.backgroundColor = '#fff000';
		document.getElementById('accountNumber').focus();
		return false;
	}
	document.getElementById('accountNumber').style.backgroundColor = '#ffffff';
	if (!regAccount.test(document.getElementById('accountNumber').value)) {
		document.getElementById('accountNumber').value = '';
		document.getElementById('accountNumber').placeholder = '계좌형식에 맞게 입력하세요.';
		document.getElementById('accountNumber').style.backgroundColor = '#fff000';
		document.getElementById('accountNumber').focus();
		return false;
	}
	document.getElementById('accountNumber').style.backgroundColor = '#ffffff';
	if (document.getElementById('passwd').value.length < 1) {
		document.getElementById('passwd').placeholder = '비밀번호를 입력하세요.';
		document.getElementById('passwd').style.backgroundColor = '#fff000';
		document.getElementById('passwd').focus();
		return false;
	}
	document.getElementById('passwd').style.backgroundColor = '#ffffff';
	if (!regPasswd.test(document.getElementById('passwd').value)
			|| document.getElementById('passwd').value.length != 4) {
		document.getElementById('passwd').value = '';
		document.getElementById('passwd').placeholder = '4자리 숫자로 입력하세요.';
		document.getElementById('passwd').style.backgroundColor = '#fff000';
		document.getElementById('passwd').focus();
		return false;
	}
	document.getElementById('passwd').style.backgroundColor = '#ffffff';
	if (document.getElementById('deposit').value.length < 1) {
		document.getElementById('deposit').placeholder = '입금금액을 입력하세요.';
		document.getElementById('deposit').style.backgroundColor = '#fff000';
		document.getElementById('deposit').focus();
		return false;
	}
	document.getElementById('deposit').style.backgroundColor = '#ffffff';
	if (!regMoney.test(document.getElementById('deposit').value)) {
		document.getElementById('deposit').value = '';
		document.getElementById('deposit').placeholder = '형식에 맞게 입력하세요.';
		document.getElementById('deposit').style.backgroundColor = '#fff000';
		document.getElementById('deposit').focus();
		return false;
	}
	document.getElementById('deposit').style.backgroundColor = '#ffffff';
	if (document.getElementById('kind').value == '마이너스 계좌') {
		if (document.getElementById('loan').value.length < 1) {
			document.getElementById('loan').placeholder = '대출금액을 입력하세요.';
			document.getElementById('loan').style.backgroundColor = '#fff000';
			document.getElementById('loan').focus();
			return false;
		}
		document.getElementById('loan').style.backgroundColor = '#ffffff';
		if (!regMoney.test(document.getElementById('loan').value)) {
			document.getElementById('loan').value = "";
			document.getElementById('loan').placeholder = '형식에 맞게 입력하세요.';
			document.getElementById('loan').style.backgroundColor = '#fff000';
			document.getElementById('loan').focus();
			return false;
		}
		document.getElementById('loan').style.backgroundColor = '#ffffff';
	}

	return true;

}

/* 알림창 띄우기 */
function notice(id) {
	var x = document.getElementById(id);
	x.className = "show";
	setTimeout(function() {
		x.className = x.className.replace("show", "");
	}, 3000);
}

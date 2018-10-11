/**
 * modify.html에 해당하는 함수들
 */

/** 이벤트소스에 이벤트리스너 등록*/
	function eventRegist() {
		var listnerAdjust = document.getElementById('adjust');
		listnerAdjust.onclick = function() {
			send();
		}

		document.getElementById('adjustName').onkeyup = function(e) {
			var event = e || window.event;
			if (e.keyCode == 13) {
				send();
			}
		}

		document.getElementById('adjustPasswd').onkeyup = function(e) {
			var event = e || window.event;
			if (e.keyCode == 13) {
				send();
			}
		}
	}

	/* 부모창에게 정보 받아오기 */
	function getParentText() {
		var account = opener.sender;
		if (account.hasOwnProperty('borrowMoney')) {
			document.getElementById("adjustKind").value = '마이너스 계좌';
		} else {
			document.getElementById("adjustKind").value = '입출금 계좌';
		}

		document.getElementById("adjustName").value = account.accountOwner;
		document.getElementById("adjustAccountNumber").value = account.accountNum;
		document.getElementById("adjustPasswd").value = account.passwd;

	}

	/* 부모창에게 수정한 정보 보내기 */
	function send() {
		if (availability()) {
			opener.receiveAccNum = document
					.getElementById("adjustAccountNumber").value;
			opener.receiveName = document.getElementById("adjustName").value;
			opener.receivePasswd = document.getElementById("adjustPasswd").value;
			opener.onload();
			window.close();

		}

	}

	/* 유효성 검증 */
	function availability() {
		var regName = /^[가-힣|a-z|A-Z|\*]+$/;
		var regPasswd = /[0-9]{4}/;

		if (document.getElementById('adjustName').value.length < 1) {
			document.getElementById('adjustName').placeholder = '이름을 입력하세요.';
			document.getElementById('adjustName').focus();
			return false;
		}
		if (!regName.test(document.getElementById('adjustName').value)) {
			document.getElementById('adjustName').value = "";
			document.getElementById('adjustName').placeholder = '한글, 영문으로 입력하세요.';
			document.getElementById('adjustName').focus();
			return false;
		}
		if (document.getElementById('adjustPasswd').value.length < 1) {
			document.getElementById('adjustPasswd').placeholder = '비밀번호를 입력하세요.';
			document.getElementById('adjustPasswd').focus();
			return false;
		}
		if (!regPasswd.test(document.getElementById('adjustPasswd').value)
				|| document.getElementById('adjustPasswd').value.length != 4) {
			document.getElementById('adjustPasswd').value = '';
			document.getElementById('adjustPasswd').placeholder = '4자리 숫자로 입력하세요.';
			document.getElementById('adjustPasswd').focus();
			return false;
		}
		return true;
	}
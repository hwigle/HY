/**
*  post.js
*/

document.addEventListener('DOMContentLoaded', init);

// 전체리스트
function init() {
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', '../studentList.json');
	xhtp.send();
	xhtp.onload = function() {
		let data = JSON.parse(xhtp.responseText);
		console.log(data);
		let tbodyList = document.getElementById('list');
		data.forEach(function(elem) {
			let newTr = makeTr
			tbodyList.appendChild(makeTr(elem));

		})
	} //end of onload
} // end of init

// 변경처리

let modBtn = document.querySelector('input[type=button]');
modBtn.addEventListener('click', function() {
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="escore"]').value;
	let kor = document.querySelector('input[name="kscore"]').value;
	let xhtp = new XMLHttpRequest();
	xhtp.open('get', `modStudentServlet?a=${no}&b=${name}&c=${eng}&d=${kor}`);
	xhtp.send();
	xhtp.onload = function() {
		let result = JSON.parse(xhtp.responseText);
		if (result.retCode == 'Success') {
			// 결과값으로 받은 학생번호, 학생이름, 영어, 국어점수를 가지고 새로운 tr을 생성
			let obj = {
				studentNO: result.studNo,
				studentName: result.studName,
				engScore: result.engScore,
				korScore: result.korScore

			}
			let newTr = makeTr(obj);
			let oldTr = document.getElementById(result.studNo);
			document.getElementById('list').replaceChild(newTr, oldTr); // 새로운 tr을 만들어서 이전의 tr을 대체 수정을 가능케 한다.			
		} else {
			alert('변경 중 오류.')
		}
	}
});
function modStudent() {

}

// 한건추가.
function addStudent(e) {
	e.preventDefault();
	console.log(e);

	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="escore"]').value;
	let kor = document.querySelector('input[name="kscore"]').value;



	let xhtp = new XMLHttpRequest(); // 비동기방식으로 서버의 파일요청.
	xhtp.open('get', `addStudentServlet?sno=${no}&sname=${name}&escore=${eng}&kscore=${kor}`);
	xhtp.send()
	xhtp.onload = function() {
		console.log(xhtp.responseText);
		let result = JSON.parse(xhtp.responseText); //{retCod:"Success"}
		if (result.retCode == 'Success') {
			// 리스트에 새로운 값 추가
			successCallBack2(result);
		} else if (result.retCode == 'Fail') {
			// 처리중 에러가 발생했습니다 메시지 실행
			failCallBack();
		}
	} // end of function()
} // end of addStudent(e)

function makeTr(student) {
	let tr = document.createElement('tr');
	tr.setAttribute('id', student.studentNo); // 라인 삭제를 id 값을 기준으로 getElementById(id).remove(); 처리
	for (let field in student) {
		let td = document.createElement('td');
		td.innerHTML = student[field];
		tr.appendChild(td);
	}

	// 삭제버튼 생성.
	let delBtn = document.createElement('button');
	delBtn.innerHTML = '삭제';

	//이벤트 등록.
	delBtn.addEventListener('click', function() {
		// 삭제(id파악 =>ajax호출.)
		let id = this.parentElement.parentElement.firstChild.innerHTML;
		console.log(id);
		let xhtp = new XMLHttpRequest();
		xhtp.open('get', 'delStudentServlet?delId=' + id);
		xhtp.send();
		xhtp.onload = function() {
			let result = JSON.parse(xhtp.responseText);
			if (result.retCode == 'OK') {
				alert(result.retVal + '번이 삭제되었습니다.');
				document.getElementById(result.retVal).remove();
			} else {
				console.log(result.retVal);
			}
		}
	});

	let td = document.createElement('td');
	td.appendChild(delBtn);
	tr.appendChild(td);

	return tr;
} //end of makeTr(student)

function successCallBack2(retObj) {
	console.log(retObj);
	let obj = {
		studentNo: retObj.studNo,
		studentName: retObj.studName,
		engScokre: retObj.engScore,
		korScokre: retObj.korScore,
	}
	document.getElementById('list').appendChild(makeTr(obj));
} //end of successCallBack2(0)

function successCallBack() {
	// 사용자 입력값을 id='list' 하위 추가.
	let no = document.querySelector('input[name="sno"]').value;
	let name = document.querySelector('input[name="sname"]').value;
	let eng = document.querySelector('input[name="eScore"]').value;
	let kor = document.querySelector('input[name="kScore"]').value;

	let obj = {
		studNo: no,
		studName: name,
		engScore: eng,
		korScore: kor
	};
	let row = makeTr(obj);
	document.getElementById('list').appendChild(row);


}

function failCallBack() {
	alert('처리중 에러발생')
}

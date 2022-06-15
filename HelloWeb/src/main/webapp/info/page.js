console.log(member1);

let field = 'fullName';
console.log(member1.fullName)
console.log(member2['fullName'])
console.log(member3[field]); //제일 좋음

//배열요소르 반복적으로 읽어올 때 반복문 for of를 사용
for (let member of members) {
  console.log(`이름은 ${member.fullName}이고 나이는${member['age']} 점수는 ${member['score']}입니다`);
}

//오브젝트의 속성(필드)을 반복적으로 for in을 사용
for (let field in member1) {
  console.log(`${field} => ${member1[field]}`);
}

//각 배열요소의 각 필드를 출력
for (let member of members) {
  for (let field in member) {
    console.log(`${field} => ${member[field]}`);
  }
  console.log(`------------------`);
}
document.write('<table border=1>');
let fields = ['fullName', 'age', 'score'];
for (let member of members) {
  document.write('<tr>')
  for (let prop of fields) {
    console.log(`${prop} => ${member[prop]}`);
    document.write(`<td>${member[prop]}</td>`);
  }
  document.write('<td><button>클릭</button></td>')
  document.write('</tr>')
  console.log(`------------------`);
}
document.write('</table>');
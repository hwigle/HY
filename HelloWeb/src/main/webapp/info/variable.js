var myName ='진휘용'; // string
var yourName; // undefined
myName = 100; // number
myName = true; // boolean
myName = null; // object

console.log(typeof yourName);
var yourName = "홍길동";
console.log(typeof yourName);

// 전역변수(스크립트안에서 선언된 변수)
// 지역변수(함수안에서 선언된 변수)

function checkInfo(){
  var myName = 'JinHwiYong'; 
  console.log(myName); // 함수가 끝나면 사라짐
}
checkInfo();
console.log(myName);

// ES6 (ES2015) => let
// let 블럭레벨 변수선언.
function info(){
  let myName ='Hong';
  console.log(myName);
}
info();

{
  let myName ='Hong';
}

{
   let myName ='Hwang';
}

const otherName = 'Hong'
//otherName ='Hwang';

// var, let => 변수선언.
// const => 상수선언.

let member1 = {
  fullName: 'Hong',
  age: 20,
  score: 80
};
let member2 = {
  fullName: 'Hwang',
  age: 22,
  score: 88
};
let member3 = {
  fullName: 'Park',
  age: 25,
  score: 92
}
member1.fullName = '홍';
console.log(member1.fullName)
console.log(member2.age + member1.age)
// {key: value}. {key: value}

const members = [member1, member2, member3];
document.write('<h3>우효</h3>')
document.write('<ul>');
for (let i = 0; i < members.length; i++) {
  document.write('<li>'+members[i].fullName + '의 나이는 ' + members[i].age + '이고 점수는 ' + members[i].score + '입니다.'+ '</li>')
}
document.write('</ul>')
let welcome = `안녕하세요.
               반갑습니다`;
console.log(welcome)


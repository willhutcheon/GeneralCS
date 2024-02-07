console.log("Hello, World!");
console.log("James");
console.log("hello" + "james");
console.log("james".length);
console.log(1 + "1");

let isHungry = true;
let age = 17;
let isTeenager = age > 12 && age < 20;

hello();
hello();
function hello() {
    console.log('Hello!');
    console.log('Welcome to JavaScript');
}

square(3);
function square(num) {
    console.log(num * num);
}
square(3);

// alert("Test alert");
// confirm("Are you sure?");
// prompt("Enter some text");

let boxBtn = document.getElementById("box-btn");
boxBtn.addEventListener("click", openBox);
function openBox() {
    let box = document.getElementById("uncg"); // 1. Get the box image
    box.src = "https://www.uncg.edu/wp-content/uploads/2018/08/NewSpartan-36009 - F1.jpg"; // 2. Change the box image's src attribute!
}

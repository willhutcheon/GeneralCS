var boxBtn = document.getElementById("box-btn");
boxBtn.addEventListener("click", openBox);
function openBox() {
    // 1. Get the box image
    // let box = document.getElementById("#uncg-logo");
    let box = document.getElementById("uncg-logo");
    // 2. Change the box image's src attribute!
    box.src = "https://www.uncg.edu/wp-content/uploads/2018/08/NewSpartan-36009-F1.jpg";
}

const imgArray = document.querySelectorAll('img');
for (let index = 0; index < imgArray.length; index++) {
    const element = imgArray[index];
    element.addEventListener('click', addBorders);
}

function addBorders(event) {
    const img = event.currentTarget;
    img.style.border = "5px solid red";
}

const image = document.querySelector('img.shown');
image.addEventListener("click", remove);
function remove(event) {
    const image = event.currentTarget;
    image.classList.remove('shown');
    image.classList.add('hide');
}

let myDiv = document.querySelector("#div1");
myDiv.addEventListener("click", addPara);
function addPara(event) {
    let myDiv = event.currentTarget;
    let para = document.createElement("p");
    let node = document.createTextNode("This is new.");
    para.appendChild(node);
    let child = document.querySelector("#p1");
    myDiv.insertBefore(para, child);
    // myDiv.appendChild(para);
}

const parag = document.querySelector("p.highlight");
parag.addEventListener('click', textBackGround);
function textBackGround(event) {
    let parag = event.currentTarget;
    parag.style.backgroundColor = 'red';
}

const paragOther = document.querySelector("p.other");
paragOther.addEventListener("click", removePara);
function removePara(event) {
    const paragOther = event.currentTarget;
    paragOther.remove();
}

function addTwo(num1, num2) {
    let result = num1 + num2;
    return result;
}
console.log(addTwo(11, 56));
const addButton = document.querySelector('button');
addButton.addEventListener('click', displaySum);
function displaySum(event) {
    const num1 = document.querySelector("#first").value;
    const num2 = document.querySelector("#second").value;
    const res = addTwo(parseInt(num1), parseInt(num2));
    let resultDiv = document.querySelector("#result");
    resultDiv.textContent = num1 + " + " + num2 + " = " + res;
}

const gallery = document.querySelectorAll('img');
for (let index = 0; index < gallery.length; index++) {
    const element = gallery[index];
    element.addEventListener('click', expand);
}
function expand(event) {
    const smallImage = event.currentTarget;
    const bigImage = document.querySelector(".big");
    bigImage.classList.remove('big');
    bigImage.classList.add('small');
    smallImage.classList.remove('small');
    smallImage.classList.add('big');
}

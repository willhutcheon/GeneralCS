/* "use strict";
(function () {

    // put all script.js code in here
    
})(); */

let param = true;
let addButton = document.querySelector("button");
addButton.addEventListener("click", function () {
    displaySum(param);
});
function displaySum(param) {
    if (param) {
        let num1 = document.querySelector("#first").value;
        let num2 = document.querySelector("#second").value;
        let res = addTwo(parseInt(num1), parseInt(num2));
        let resultDiv = document.querySelector("#result");
        resultDiv.textContent = num1 + " + " + num2 + " = " + res;
    }
}


let button = document.querySelector("button");
button.addEventListener("click", function () {
    consolelog("ouch you clicked me");
});
button.addEventListener("click", function () {
    consolelog("ouch you clicked me");
});
button.addEventListener("click", function () {
    consolelog("ouch you clicked me");
});


var boxBtn = document.getElementById("box-btn");
boxBtn.addEventListener("click", boxFunction);
function boxFunction() {
    alert("this in event handler:" + this);
}


const module = {
    x: 42,
    getX: function () {
        return this.x;
    },
};
const unboundGetX = module.getX;
console.log(unboundGetX()); // The function gets invoked at the global scope
// Expected output: undefined
const boundGetX = unboundGetX.bind(module);
console.log(boundGetX());
// Expected output: 42



const person = {
    firstName: "John",
    lastName: "Doe",
    id: 5566,
    fullName: function () {
        return this.firstName + " " + this.lastName;
    }
};
console.log("this in method:" + person.fullName());

let globalVariable = this;
console.log("this alone:" + globalVariable);

function myFunction() {
    return this;
}
console.log("this in a function:" + myFunction());






/*
let addButton = document.querySelector("button");
addButton.addEventListener("click", displaySum);
function displaySum() {
    let num1 = document.querySelector("#first").value;
    let num2 = document.querySelector("#second").value;
    let res = addTwo(parseInt(num1), parseInt(num2));
    let resultDiv = document.querySelector("#result");
    resultDiv.textContent = num1 + " + " + num2 + " = " + res;
}*/

function addTwo(num1, num2) {
    return num1 + num2;
}

let sum = function (num1, num2) {
    let result = num1 + num2;
    return result;
};
console.log("anon sum: " + sum(2, 78));

let product = (num1, num2) => {
    return num1 * num2;
}
console.log("anon arrow product:" + product(56, 2));
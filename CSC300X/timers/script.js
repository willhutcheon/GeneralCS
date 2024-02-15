'use strict';
(function () {
    function delay() {
        id("demo-btn-delay").addEventListener("click", delayedMessage);
    }
    function delayedMessage() {
        id("output-text-delay").textContent = "Wait for it...";
        setTimeout(sayHello, 3000);
    }
    function sayHello() { // called when the timer goes off
        id("output-text-delay").textContent = "Hello!";
    }
    delay();



    // should always be global
    let timerId = null; // stores ID of interval timer
    function repeat() {
        id("demo-btn-repeat").addEventListener("click", repeatedMessage);
    }
    function repeatedMessage() {
        timerId = setInterval(sayHello, 1000);
    }
    function sayHello() {
        id("output-text-repeat").textContent += "Hello!";
    }
    repeat();



    let toggleTimerId = null; // stores ID of interval timer
    function toggle() {
        id("toggle-btn").addEventListener("click",
            toggleMessageInterval);
    }
    function toggleMessageInterval() {
        if (toggleTimerId === null) {
            toggleTimerId = setInterval(sayHello, 1000);
        } else {
            clearInterval(toggleTimerId);
            toggleTimerId = null; // 2. Why is this line important?
            // 3. What happens if you swap the two lines above?
        }
    }
    function sayHello() {
        id("output-text-toggle").textContent += "Hello!";
    }
    toggle();


    


    //helper function
    function id(id) {
        return document.getElementById(id);
    }
})();
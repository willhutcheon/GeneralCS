//stopwatch.js
'use strict';
(function () {
    // global
    let timerId = null;

    // introduce any module global variables necessary here
    window.addEventListener('load', init);
    /**
    * initiates page upon load
    */
    function init() {
        id('stopwatch').addEventListener('click', toggleStopwatch);
        id('reset').addEventListener('click', resetStopwatch);
    }
    /**
    * toggles the stop watch time
    */
    function toggleStopwatch() {
        // TODO: complete this function
        // added
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
    toggleStopwatch();
    // stop added




    /**
    * resets the stop watch
    */
    function resetStopwatch() {
        // TODO: complete this function (hint: it's a super short one)
    }
    /* -------------------- Helper Function -------------------- */
    /**
    * id helper function
    * @param {String} idName name of id
    * @return {Object} element with id name
    */
    function id(idName) {
        return document.getElementById(idName);
    }
})();
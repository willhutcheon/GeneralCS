'use strict';

(function () {

    const GITHUB_API_BASEURL = 'https://api.github.com/users/';
    const POST_BASEURL = 'https://crudcrud.com/api/c831ab645e1b49e9adb66bd8c595084f/users';

    window.addEventListener('load', init);

    function init() {
        id('input-form').addEventListener('submit', function (e) {
            e.preventDefault();
            submitForm();
        });
    }

    function submitForm() {
        let params = new FormData(id('input-form'));
        let jsonBody = JSON.stringify(Object.fromEntries(params));
        fetch(POST_BASEURL, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: jsonBody
        })
        .then(checkStatus)
        .then(console.log)
        .catch(alert);
    }

    function getUserRepos() {
        let gitHubUsername = 'willhutcheon';
        let url = GITHUB_API_BASEURL + gitHubUsername + '/repos?sort=created';
        fetch(url)
        .then(checkStatus)
        .then((repoData) => {
            console.log(repoData);
            let div = id('container');
            for (const item of repoData) {
                let repoName = document.createElement('p');
                const name = item['name'];
                repoName.innerHTML = 'Name:' + name;
                div.appendChild(repoName);
                let repoDate = document.createElement('p');
                const date = item['created_at'];
                repoDate.innerHTML = 'Created:' + date;
                div.appendChild(repoDate);
                let upateDate = document.createElement('p');
                const updated = item['updated_at'];
                upateDate.innerHTML = 'Updated:' + updated;
                div.appendChild(upateDate);
                let rule = document.createElement('hr');
                div.appendChild(rule);
            }
        })
        .catch((error) => {
            console.error('Error: ', error);
        });
    }

    //helper functions
    function id(idName) {
        return document.getElementById(idName);
    }

    function checkStatus(response) {
        if (!response.ok) {
            throw Error('Error in request: ' + response.statusText);
        }
        return response.json();
    }

})();

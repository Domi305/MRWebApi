let userId = getUrlParameter('userId')
if (userId == null || userId == '') {
    userId = localStorage.getItem('userId')
    if (userId == null || userId == '') {
        document.getElementById('createUser').value = true
    } else {
        // fetch('/savedPreferences?userId=' + userId)
        //     .then(response => esponse.json())
        //     .then(jsonResponse => console.log(jsonResponse))
        window.location.href ='/?userId=' +userId
    }
}

if (userId != null && userId != '') {
    localStorage.setItem('userId', userId)
    document.getElementById('userId').value = userId
}

let marsApiButtons = document.querySelectorAll("input[id*='marsApi']")

marsApiButtons.forEach(input => input.addEventListener('click', function () {
    const inputId = this.id
    const roverId = inputId.split('marsApi')[1]
    let apiData = document.getElementById("marsApiRoverData")
    apiData.value = roverId
    document.getElementById('fromRoverType').submit()
}))

function getUrlParameter(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
};

let marsRoverType = document.getElementById('marsApiRoverData').value
//console.log(getUrlParameter("marsApiRoverData"))

highlightInputByRoverType(marsRoverType)

let marsSol = getUrlParameter('marsSol')
if (marsSol != null && marsSol != '' && marsSol >= 0) {
    document.getElementById('marsSol').value = marsSol
}

function highlightInputByRoverType(roverType) {
    if (roverType == '')
        roverType = 'Curiosity'
    document.getElementById('marsApi' + roverType).checked = true
}

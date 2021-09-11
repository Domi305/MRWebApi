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

let marsRoverType = getUrlParameter("marsApiRoverData")
//console.log(getUrlParameter("marsApiRoverData"))

highlightInputByRoverType(marsRoverType)

let marsSol = getUrlParameter('marsSol')
document.getElementById('marsSol').value = marsSol

function highlightInputByRoverType(roverType) {
    if (roverType == '')
        roverType = 'Curiosity'
    document.getElementById('marsApi' + roverType).checked = true
}

// if (marsRoverType == 'Opportunity') {
//     document.getElementById('marsApiOpportunity').checked = true
// } else if (marsRoverType == 'Spirit') {
//     document.getElementById('marsApiSpirit').checked = true
// } else {
//     document.getElementById('marsApiCuriosity').checked = true
// }

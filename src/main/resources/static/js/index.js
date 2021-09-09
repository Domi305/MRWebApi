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

// const marsRoverType = getUrlParameter("marsApiRoverData")
// //console.log(getUrlParameter("marsApiRoverData"))
// if (marsRoverType == 'Curiosity') {
//         document.getElementById('marsApiCuriosity').classList.remove('btn-outline-secondary')
//         document.getElementById('marsApiCuriosity').classList.add('btn-outline-primary')
//     } else if (marsRoverType == 'Opportunity') {
//         document.getElementById('marsApiOpportunity').classList.remove('btn-outline-secondary')
//         document.getElementById('marsApiOpportunity').classList.add('btn-outline-primary')
//     } else if (marsRoverType == 'Spirit') {
//         document.getElementById('marsApiSpirit').classList.remove('btn-outline-secondary')
//         document.getElementById('marsApiSpirit').classList.add('btn-outline-primary')
//     } else {
//         document.getElementById('marsApiOpportunity').classList.remove('btn-outline-secondary')
//         document.getElementById('marsApiOpportunity').classList.add('btn-outline-primary')
//     }

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

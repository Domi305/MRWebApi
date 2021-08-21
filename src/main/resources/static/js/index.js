let marsApiButtons = document.querySelectorAll("input[id*='marsApi']")

marsApiButtons.forEach(input => input.addEventListener('click', function () {
    const inputId =this.id
    const roverId = inputId.split('marsApi')[1]
    alert(roverId)
}))
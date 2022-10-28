const cep = document.querySelector("#cep")

const showData = (result) => {
    for(const campo in result) {
        if(document.querySelector('#'+campo)) {
            document.querySelector("#"+campo).value = result[campo]
            campo.addClass("is-valid")
        }
    }
}

cep.addEventListener("blur",()=>{
    let search = cep.value.replace("-" , "")
    $.ajax({
        url: 'https://api.postmon.com.br/v1/cep/' + search,
        dataType: "json",
        crossDomain: true,
            statusCode: {
                200: function(data) {
                    console.log(data);
                }
            }
    })

})
$(document).ready(function () {
  $("#formCadastrar").validate({
    onsubmit: true,
    rules: {
      cpf: { 
        cpf: true,
        required: true 
      },
      nome: {
        required: true,
        minlength: 3
      },
      sexo: {
        required: true
      },
      raca: {
        required: true
      },
      estadoCivil: {
        required: true
      },
      dataNascimento: {
        required: true
      },
      paisNascimento: {
        required: true
      },
      paisNacionalidade: {
        required: true
      },
      '[[@{endereco.cep.numeroCep}]]': {
        required: true
      },
      tipoEndereco: {
        required: true
      }

    },
    messages: {
      cpf: { cpf: "Por valor, insira um CPF válido!", required: "Por valor, insira um CPF!" },
      nome: { required: "Por favor, insira um nome!", minlength: "O nome deve ter no mínimo 3 caracteres!" },
      sexo: { required: "Por favor, insira o sexo!"},
      raca: { required: "Por favor, insira a raça!"},
      estadoCivil: { required: "Por favor, insira o estado civil!"},
      dataNascimento: { required: "Por favor, insira a data de nascimento!"},
      paisNascimento: { required: "Por favor, insira a data de nascimento!"},
      paisNacionalidade: { required: "Por favor, insira a data de nascimento!"},
      '[[@{endereco.cep.numeroCep}]]': { required: "a"},
      tipoEndereco: { required: "Por favor, insira a data de nascimento!"}
    }
  })



  jQuery.validator.addMethod("cpf", function (value, element) {
    value = jQuery.trim(value);

    value = value.replace('.', '');
    value = value.replace('.', '');
    cpf = value.replace('-', '');
    while (cpf.length < 11) cpf = "0" + cpf;
    var expReg = /^0+$|^1+$|^2+$|^3+$|^4+$|^5+$|^6+$|^7+$|^8+$|^9+$/;
    var a = [];
    var b = new Number;
    var c = 11;
    for (i = 0; i < 11; i++) {
      a[i] = cpf.charAt(i);
      if (i < 9) b += (a[i] * --c);
    }
    if ((x = b % 11) < 2) { a[9] = 0 } else { a[9] = 11 - x }
    b = 0;
    c = 11;
    for (y = 0; y < 10; y++) b += (a[y] * c--);
    if ((x = b % 11) < 2) { a[10] = 0; } else { a[10] = 11 - x; }

    var retorno = true;
    if ((cpf.charAt(9) != a[9]) || (cpf.charAt(10) != a[10]) || cpf.match(expReg)) retorno = false;

    return this.optional(element) || retorno;

  }, "Informe um CPF válido");

});
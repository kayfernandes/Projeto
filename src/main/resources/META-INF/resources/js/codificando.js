function efeito (label) {

    const labels = document.querySelectorAll(".estiloinput label");
    labels.forEach((label)=> {
        label.innerHTML = label.innerText
            .split("")
            .map(
                (letter, idx) =>
                    <span style = "transition-delay:${idx * 50}ms">${letter}</span>
            )
            .join ("");
    });
}

function verifica(){
    if (document.forms[0].email.value.length === 0) {
        alert("Por favor, informe o seu EMAIL.");
        document.frmEnvia.email.focus();
        return false;
    }
    return true;
}

function validacaoEmail(field) {
    usuario = field.value.substring(0, field.value.indexOf("@"));
    dominio = field.value.substring(field.value.indexOf("@")+ 1, field.value.length);

    if ((usuario.length >=1) &&
        (dominio.length >=3) &&
        (usuario.search("@")===-1) &&
        (dominio.search("@")===-1) &&
        (usuario.search(" ")===-1) &&
        (dominio.search(" ")===-1) &&
        (dominio.search(".")!==-1) &&
        (dominio.indexOf(".") >=1)&&
        (dominio.lastIndexOf(".") < dominio.length - 1)) {
        document.getElementById("msgemail").innerHTML="E-mail válido";
        alert("E-mail valido");
    }
    else{
        document.getElementById("msgemail").innerHTML="<font color='red'>E-mail inválido </font>";
        alert("E-mail invalido");
    }
}
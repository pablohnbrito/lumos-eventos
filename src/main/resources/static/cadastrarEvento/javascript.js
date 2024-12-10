async function sendData(data) {
    const formData = {
        "id": null,
        "titulo": document.getElementById("titulo").value,
        "descricao": document.getElementById("descricao").value,
        "lotacao": document.getElementById("lotacao").value,
        // "realizacaoInicio": "2024-12-31T00:00:00",
        // "realizacaoFim": "2024-12-31T00:00:00"
        "realizacaoInicio": document.getElementById("realizacaoInicio").value,
        "realizacaoFim": document.getElementById("realizacaoFim").value
    }
  
    try {
      const response = await fetch("/evento", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(formData)
      });
      console.log(await response.json());
      alert("Cadastrado com sucesso!!");
      window.location.href = "../index.html";
    } catch (e) {
      console.error(e);
      alert("Dados incorretos!")
    }
  }
  
  const send = document.querySelector("#btnCadastrarEvento");
  send.addEventListener("click", sendData);  
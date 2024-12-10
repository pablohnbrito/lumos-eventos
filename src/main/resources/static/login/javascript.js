async function getLogin(data) {
    const formData = {
        "email": document.getElementById("email").value
    }
  
    try {
      const response = await fetch("/usuario", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
      });
      const data = await response.json();
      console.log(data);
      if (Array.isArray(data) && data.some(user => user.email === formData) ) {
        alert("Logado com sucesso!!");
        window.location.href = "../index.html";
      } 
    } catch (e) {
      console.error(e);
      alert("Dados incorretos!");
    }
  }
  
  const send = document.querySelector("#btnLogin");
  send.addEventListener("click", getLogin);  
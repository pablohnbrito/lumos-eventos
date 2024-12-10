async function getLogin(data) {
    const formData = {
        "email": document.getElementById("email").value
    }
  
    try {
      const response = fetch("/usuario", {
        method: "GET",
        headers: {
            "Content-Type": "application/json"
        }
      });
      const data = response.json();
      users = data.content
      console.log(data);
      if (Array.isArray(users) && users.some(user => user.email === formData.email) ) {
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
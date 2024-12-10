// Quantidade de imagens que podem ser adicionadas ao carousel próximos
// eventos, o nome da imagem tem que ser no padrão imagem1.PNG
// Apenas o número pode mudar.
const qtdImagens = 4;
const qtdEventos = 9;

async function getEvento() {
    try {
        const resposta = await fetch("/evento?size="+qtdEventos, {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });

        resposta.json().then(createCards);
    } catch(e) {
        console.error(e);
    }
}

function createCards(eventosList) {
    let carousel = document.querySelector("#carouselProximosEventos").querySelector(".carousel-inner");
    let cardGroup;
    let carouselItem = `
        <div class="carousel-item">
          <div class="card-group m-5">
          </div>
        </div>
    `;
    const parser = new DOMParser();

    for (let index = 0; index < eventosList.content.length; index++) {
        if (index%3 == 0){
            cardGroup = parser.parseFromString(carouselItem, 'text/html').querySelector(".carousel-item");
            carousel.appendChild(cardGroup);

            if (index == 0)
                cardGroup.classList.add("active");
        }

        let evento = eventosList.content[index];
        let card = `
            <div class="card mx-auto" style="width: 18rem;">
              <img src="imagens/imagem${(index%qtdImagens)+1}.PNG" class="card-img-top" alt="${evento.titulo}">
              <div class="card-body">
                <h5 class="card-title">${evento.titulo}</h5>
                <p class="card-text">${evento.descricao}</p>
              </div>
              <div class="card-footer text-muted">
                De: ${new Date(evento.realizacaoInicio).toLocaleString()} a ${new Date(evento.realizacaoFim).toLocaleString()}
              </div>
            </div>
        `;
        cardGroup.querySelector(".card-group").appendChild(
            parser.parseFromString(card, 'text/html').querySelector(".card")
        );
    }
}


getEvento();
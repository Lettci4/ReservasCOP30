const localInput = document.querySelector("#buscarLocal");
const precoInput = document.querySelector("#buscarPreco");
const form = document.querySelector("#buscarForm");

const cards = document.querySelectorAll(".hotel-card");

form.addEventListener("submit", (event) => {
    event.preventDefault();

    const local = localInput.value.toLowerCase();
    const preco = precoInput.value;

    let total = 0;

    cards.forEach(card => {
        const cardLocal = card.dataset.local.toLowerCase();
        const cardPreco = Number(card.dataset.preco);
        const coluna = card.closest(".col-md-4");

        let match = true;

        if (local && !cardLocal.includes(local)) match = false;
        if (preco && cardPreco > preco) match = false;

        if (match) {
            coluna.style.display = "block";
            total++;
        } else {
            coluna.style.display = "none";
        }
    });

    const mensagem = document.querySelector("#contador");
    if (mensagem) {
        mensagem.innerHTML = ` ${total} hotel(is) encontrado(s).`;
    }
});

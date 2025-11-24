document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("buscarForm");
    const inputLocal = document.getElementById("buscarLocal");
    const inputPreco = document.getElementById("buscarPreco");
    const colunas = document.querySelectorAll(".hotel-card");
    const contador = document.getElementById("contador");

    form.addEventListener("submit", function(event) {
        event.preventDefault();

        const normalizar = (texto) =>
            texto.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase();

        const local = normalizar(inputLocal.value.trim());
        const precoMax = inputPreco.value.trim() ? Number(inputPreco.value) : null;

        let encontrados = 0;

        colunas.forEach(card => {

            const col = card.closest(".col-md-4");
            if (!col) return;

            const cardLocal = normalizar(card.getAttribute("data-local"));
            const cardPreco = Number(card.getAttribute("data-preco"));

            const okLocal = !local || cardLocal.includes(local);
            const okPreco = !precoMax || cardPreco <= precoMax;

            if (okLocal && okPreco) {
                col.classList.remove("d-none");
                encontrados++;
            } else {
                col.classList.add("d-none");
            }
        });

        contador.textContent =
            encontrados === 0
                ? "Nenhum hotel encontrado"
                : `${encontrados} ${encontrados === 1 ? "hotel encontrado" : "hotéis encontrados"}`;
    });
});

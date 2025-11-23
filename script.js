document.getElementById("buscarForm").addEventListener("submit", function(event) {
    event.preventDefault();

    const normalizar = (texto) =>
        texto.normalize("NFD").replace(/[\u0300-\u036f]/g, "").toLowerCase();

    const local = normalizar(document.getElementById("buscarLocal").value);
    const precoMax = document.getElementById("buscarPreco").value;
    const colunas = document.querySelectorAll(".col-md-4");
    const contador = document.getElementById("contador");

    let encontrados = 0;

    colunas.forEach(col => {
        const card = col.querySelector(".hotel-card");

        const cardLocal = normalizar(card.getAttribute("data-local"));
        const cardPreco = Number(card.getAttribute("data-preco"));

        const okLocal = !local || cardLocal.includes(local);
        const okPreco = !precoMax || cardPreco <= precoMax;

        if (okLocal && okPreco) {
            col.style.display = "";
            encontrados++;
        } else {
            col.style.display = "none";
        }
    });

    contador.innerHTML = `${encontrados} hotel(is) encontrado(s)`;
});

document.getElementById("reservaForm").addEventListener("submit", function(event) {
  event.preventDefault();

  const nome = document.getElementById("nome").value;
  const data = document.getElementById("data").value;
  
  const mensagem = document.getElementById("mensagem");
  mensagem.innerHTML = `<div class="alert alert-success">
    Obrigado, ${nome}! Sua reserva para ${data} foi confirmada com sucesso.
  </div>`;

  this.reset();
});
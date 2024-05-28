document.addEventListener('DOMContentLoaded', function() {
    const carrello = []; 
    
    function aggiungiAlCarrello(prodottoId, prezzo) {
        const prodottoIndex = carrello.findIndex(item => item.id === prodottoId);
        if (prodottoIndex !== -1) {
            carrello[prodottoIndex].quantità++;
        } else {      
            carrello.push({
                id: prodottoId,
                quantità: 1,
                prezzo: prezzo
            });
        }

        document.getElementById('numeroCarrello').innerText = carrello.reduce((total, item) => total + item.quantità, 0);
    }

    function rimuoviDalCarrello(prodottoId) {
        const prodottoIndex = carrello.findIndex(item => item.id === prodottoId);

        if (prodottoIndex !== -1) {
            if (carrello[prodottoIndex].quantità > 1) {
                carrello[prodottoIndex].quantità--;
            } else {
                carrello.splice(prodottoIndex, 1);
            }
        }

        document.getElementById('numeroCarrello').innerText = carrello.reduce((total, item) => total + item.quantità, 0);
    }

    const pulsantiAggiungi = document.querySelectorAll('.acquista');
    pulsantiAggiungi.forEach(pulsante => {
        pulsante.addEventListener('click', function() {
            const prodottoId = this.value;
            const prezzo = parseFloat(this.parentElement.querySelector('.prezzo').innerText.replace('€ ', ''));
            aggiungiAlCarrello(prodottoId, prezzo);
        });
    });

    const pulsantiPiu = document.querySelectorAll('.piu');
    pulsantiPiu.forEach(pulsante => {
        pulsante.addEventListener('click', function() {
            const prodottoId = this.parentElement.querySelector('.acquista').value;
            const prezzo = parseFloat(this.parentElement.querySelector('.prezzo').innerText.replace('€ ', ''));
            aggiungiAlCarrello(prodottoId, prezzo);
        });
    });

    const pulsantiMeno = document.querySelectorAll('.meno');
    pulsantiMeno.forEach(pulsante => {
        pulsante.addEventListener('click', function() {
            const prodottoId = this.parentElement.querySelector('.acquista').value;
            rimuoviDalCarrello(prodottoId);
        });
    });
});
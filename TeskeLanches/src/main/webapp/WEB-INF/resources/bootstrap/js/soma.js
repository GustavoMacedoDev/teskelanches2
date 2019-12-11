/**
 * 
 */

    // Atribui à tdsValores uma lista com os elementos tds    
    //que possuem a classe info-valor
    let tdsValores = document.querySelectorAll('.info-valor')

    let total = 0 // Variável auxiliar

    // Itera sobre a lista de elementos tds (tdsValores)
    for (let i = 0; i < tdsValores.length; i++) {

        // Você acessa o texto dentro de um elemento
        // por meio da propriedade textContent
        // a função parseFloat converte um texto pra número de ponto flutuante
        // caso contrário ao somar os valores na verdade você os concatenaria, 
        // obtendo "39.9060.9039.90"
        let valor = parseFloat(tdsValores[i].textContent)

        // a cada iteração total vai receber o valor dela mesma
        // mais o valor atual da iteração
        total = total + valor // ou total += valor
    }

    console.log(total) // imprime no console o valor final de total

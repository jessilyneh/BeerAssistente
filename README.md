# Beer-Assistente
 Projeto de criaçao de máquina que lista cervejas
 
 Descrição do desafio:
1. Crie um microserviço para os estilos de cerveja
Precisamos que crie uma api que possamos listar, cadastrar, deletar e atualizar nossos estilos de cerveja e suas temperaturas(C.R.U.D).

2. Criar um endpoint
Para nos ajudar a criar nossa máquina cervejeira, desenvolva uma api Restful na qual, dada uma temperatura, ela nos devolva o estilo de cerveja mais adequado para aquela temperatura e uma playlist que contenha o nome desse estilo(use a api do spotify para buscar as playlist).
Regras de negócio
* Todo estilo de cerveja tem uma temperatura mínima e uma temperatura máxima.
* O cálculo para selecionar o estilo de cerveja adequado: é qual estilo contém a média das suas temperaturas mais próxima do input dado pela api.(Se o input foi -2 e temos as cervejas Dunkel e Weissbier o estilo selecionado é o Dunkel).
* Caso o resultado seja mais de um estilo de cerveja, devolver o estilo por ordem alfabética(entre Pilsens e IPA voltára IPA) e caso de empate na primeira letra, ordernar pela segunda e assim por diante.
* Caso não tenha uma playlist que contenha o nome do estilo, retornar um HTTP Status que achar mais adequado.
* A lista dada foi um exemplo, a api tem que estar pronta para receber mais estilos e mais temperaturas.

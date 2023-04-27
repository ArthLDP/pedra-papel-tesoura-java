import javax.swing.JOptionPane;
import java.util.Random;

class Main
{
    public static void main(String[] args) 
    {
        Random aleatorio = new Random(); // Criando um objeto da classe Random chamado aleatorio que é responsável pelo uso da função de escolher números aleatórios

        String[] escolhas = new String[3]; // escolhas possíveis de string no jogo
        escolhas[0] = "Pedra";
        escolhas[1] = "Papel";
        escolhas[2] = "Tesoura";

        int escolherNumBot = aleatorio.nextInt(3); // variável que armazena número inteiro aleatório entre 0, 1, 2 para o bot
        boolean sairJogo = false; // variável responsável pelo loop principal do jogo
        int escolherNumJogador = 0; // variável que armazena o número da escolha do jogador
        String escolherTextoJogador = ""; // variável que transforma o número escolhido pelo jogador para string
        String escolherTextoBot = ""; // variável que transforma o número escolhido pelo bot para string
        int continuarPartida = 0; // variável responsável pelo loop de continuar a partida
        int vidasJogador = 3; // variável que armazena o número de vidas do jogador
        int vidasBot = 3; // variável que armazena o número de vidas do bot

        while(sairJogo == false)
        {
            while (escolherNumJogador != 1 && escolherNumJogador!= 2 && escolherNumJogador != 3) // se a escolha do jogador for nenhuma das possíveis escolhas ele não vai sair do menu
            {
                escolherNumJogador = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções abaixo\n\n1 - Pedra\n2 - Papel\n3 - Tesoura"));

                switch(escolherNumJogador) // switch para ler o número escolhido pelo jogador e atribuir a string "pedra", "papel" ou "tesoura", para string que armazena opção em texto do jogador
                {
                    case 1: escolherTextoJogador = escolhas[0]; //Pedra
                    break;
                    case 2: escolherTextoJogador = escolhas[1]; //Papel
                    break;
                    case 3: escolherTextoJogador = escolhas[2]; // Tesoura
                    break;

                    default: JOptionPane.showMessageDialog(null, "Opção inválida");
                }
        
            }
            

            switch(escolherNumBot) // switch para ler o número escolhido pelo bot e atribuir a string "pedra", "papel" ou "tesoura", para string que armazena opção em texto do bot
            {
                case 0: escolherTextoBot = escolhas[0]; //Pedra
                break;
                case 1: escolherTextoBot = escolhas[1]; //Papel
                break;
                case 2: escolherTextoBot = escolhas[2]; //Tesoura
            }

            /////////////////// LÓGICA DO JOGO //////////////////////////

            // JOGADOR FOR IGUAL AO BOT

            if (escolherTextoJogador == escolherTextoBot) // Se forem iguais = empate
            {
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nPartida empatada" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }

            // JOGADOR PEDRA

            else if (escolherTextoJogador == escolhas[0] && escolherTextoBot == escolhas[1]) // Se Jogador Pedra vs Bot Papel = jogador perde uma vida
            {
                vidasJogador--; // jogador perde uma vida
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nVocê perdeu uma vida :(" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }
            else if (escolherTextoJogador == escolhas[0] && escolherTextoBot == escolhas[2]) // Se Jogador Pedra vs Bot Tesoura = bot perde uma vida
            {
                vidasBot--; // bot perde uma vida
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nVocê ganhou :)" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }

            // JOGADOR PAPEL

            else if (escolherTextoJogador == escolhas[1] && escolherTextoBot == escolhas[0])// Se jogador Papel vs Bot Pedra = bot perde uma vida
            {
                vidasBot--; // bot perde uma vida
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nVocê ganhou :)" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }
            else if (escolherTextoJogador == escolhas[1] && escolherTextoBot == escolhas[2]) // Se jogador Papel vs Bot Tesoura = jogador perde uma vida
            {
                vidasJogador--; // jogador perde uma vida
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nVocê perdeu uma vida :(" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }

            // JOGADOR TESOURA

            else if (escolherTextoJogador == escolhas[2] && escolherTextoBot == escolhas[0]) // Se jogador Tesoura vs Bot Pedra = jogador perde uma vida
            {
                vidasJogador--; // jogador perde uma vida
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nVocê perdeu uma vida :(" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }
            else // Se jogador Tesoura vs Bot Papel = bot perde uma vida
            {
                vidasBot--; // bot perde uma vida
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nVocê ganhou :)" + "\n\nSua escolha: " + escolherTextoJogador + "\nEscolha do bot: " + escolherTextoBot);
            }

            // CHECAR VIDAS APÓS CHECAR TODAS POSSIBILIDADES

            if (vidasJogador == 0) // Se a vida do jogador acabar
            {
                continuarPartida = 2; // sair do loop do menu de continuar a partida
                sairJogo = true; // sair do loop do jogo
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nSuas vidas acabaram, você perdeu :(");
            }
            else if (vidasBot == 0) // Se a vida do bot acabar
            {
                continuarPartida = 2;
                sairJogo = true;
                JOptionPane.showMessageDialog(null, "Vidas do jogador: " + vidasJogador + "\nVidas do bot: " + vidasBot + "\n\nAs vidas do bot acabaram, você ganhou :D");
            }

            //////////////////////////////// FIM DAS CONDIÇÕES /////////////////////////////

           while (continuarPartida != 1 && continuarPartida != 2) // se a escolha do jogador for nenhuma das possíveis escolhas ele não vai sair do menu
           {
                continuarPartida = Integer.parseInt(JOptionPane.showInputDialog("Deseja continuar a partida?\n\n1 - Sim\n2 - Não"));
        
                switch(continuarPartida)
                {
                    case 1:
                    break;
                    case 2: sairJogo = true;
                            JOptionPane.showMessageDialog(null, "Até mais!");
                    break;

                    default: JOptionPane.showMessageDialog(null, "Essa opção não existe");
                }
           }

           escolherNumJogador = 0; //resetar o inteiro que armazena a opção do jogador para entrar no loop while no inicio
           continuarPartida = 0; // resetar o inteiro que armazena a opção de continuar partida para entrar no loop while no final
           escolherNumBot = aleatorio.nextInt(3); // fazer o bot escolher outra opção
        }

    }
}
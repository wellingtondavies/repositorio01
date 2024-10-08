package Fag;

import objetos.*;

import java.util.*;

public class Main {
    public static Scanner scan = new Scanner(System.in);

    // instancia publicas para ter acesso sempre aos metodos do Main;
    private static Cardapio cardapio = new Cardapio();
    private static List<Mesa> listaMesa = new ArrayList<>();
    private static Funcionario funcionarios = new Funcionario();
    private static Pedidos pedidos = new Pedidos();
    private static Produto produto = new Produto();
    private static Mesa mesas = new Mesa();
    //variavel necessaria para minha logica de relatorios diarios
    public static double vendasDoDia = 0.0;

    public static void main(String[] args) {
        inicializador();

        boolean escolha = true;
        boolean dados = true;

        System.out.println("ESCOLHA ENTRE AS OPÇÕES \n");
        while (escolha) {
            System.out.println(""" 
                    \n
                    1-CADASTRO DE FUNCIONÁRIOS: 
                    2-GERENCIAMENTO DE CARDÁPIO: 
                    3-CADASTRO DE MESAS:|---|
                    4-REGISTRO DE PEDIDOS: 
                    5-ACOMPANHAMENTO DE VENDAS POR FUNCIONÁRIO: 
                    6-FECHAMENTO DE CONTA E FATURAMENTO: 
                    7-RELATÓRIO DE FATURAMENTO DO RESTAURANTE:
                    8-SAIR DO PROGRAMA 
                    """);
            System.out.println("QUAL OPCÂO DESEJA \n");
            int opcao = scan.nextInt();
            switch (opcao) {
                case 1:{
                    cadastraFuncionario();
                    System.out.println("\n DESEJA LISTAR OS FUNCIONARIOS?:(1 - SIM | 2 - NÃO) \n");
                    int opcao2 = scan.nextInt();
                    switch (opcao2) {
                        case 1:{
                            System.out.println(" FUNCIONARIOS CADASTRADOS (1 - SIM| 2 - NÃO! \n");
                            listarFuncionarios();
                            break;
                        }
                        default:{
                            System.out.println(" FUNCIONARIOS CADASTRADOS COM SUCESSO! \n");
                        }
                    }
                    break;
                }
                case 2:{
                    System.out.println(" CRIANDO CARDAPIO: \n");
                    cardapio();
                    System.out.println("\n DESEJA LISTAR O CARDAPIO?: (1 - SIM | 2 NÃO) \n");
                    int opcao2 = scan.nextInt();
                    switch (opcao2) {
                        case 1:{
                            System.out.println(" LISTANDO CARDAPIO  \n");
                            mostraCardapio();
                            break;
                        }
                        default:{
                            System.out.println(" SEGUINDO \n ");
                            break;
                        }
                    }
                    break;
                }
                case 3:{
                    System.out.println(" CRIANDO MESAS \n ");
                    registroMesa();
                    System.out.println(" MESAS CADASTRADAS COM SUCESSO, DESEJA-LISTALAS? ( 1 - SIM | 2 - NÃO ) \n ");
                    System.out.println(" (1 - SIM | 2 - NÃO) \n");
                    int opcao2 = scan.nextInt();
                    switch (opcao2) {
                        case 1:{
                            System.out.println(" LISTANDO MESAS \n");
                            mostraMesa();
                            break;
                        }
                        default:{
                            System.out.println(" SEGUINDO \n");
                        }
                    }
                    break;
                }
                case 4:{
                    System.out.println(" CRIANDO PEDIDOS \n ");
                    pedidos();
                    System.out.println(" PEDIDOS CRIADOS COM SUCESSO! \n");
                    System.out.println(" DESEJA LISTA-LOS ( 1 - SIM | 2 - NÃO ) \n");
                    int opcao2 = scan.nextInt();
                        if(opcao2 == 1){
                            listarPedidos();
                            System.out.println(" PEDIDOS LISTADOS COM SUCESSO \n");
                        } else if (opcao2 == 2) {
                            System.out.println(" VOLTANDO \n");
                        }else{
                            System.out.println("OPÇÃO INVALIDA ERRO!");
                        }
                    break;
                }
                case 5:{
                    System.out.println(" ACOMPANHAMENTO DE VENDAS POR FUNCIONARIO \n");
                    acompanhamentoPorFuncionario();
                    System.out.println(" FIM DO RELATORIO \n");
                    break;
                }
                case 6:{
                    System.out.println(" EXCLUIR PEDIDOS \n");
                    System.out.println(" CASO EXCLUA OS PEDIDOS EXISTESTES SERA IMPOSSIVEL GERAR O RELATORIO DIARIO \n");
                    System.out.println(" GERE O RELATORIO DIARIO ANTES DA EXCLUSÃO DOS PEDIDOS \n");
                    excluirPedidos();
                    break;
                }
                case 7:{
                    System.out.println(" GERANDO RELATORIO \n");
                    relatorioFaturamento();
                    break;
                }
                case 8:{
                    System.out.println(" SAINDO DO PROGRAMA \n");
                    escolha = false;
                    break;

                }
                default:{
                    System.out.println(" PROGRAMA ENCERRADO INCORRTAMENTE, ERRO \n");
                    break;
                }
            }
        }
    }

    public static void cadastraFuncionario() {
        boolean cadastrado = true;
        while (cadastrado) {
            int vendasGarcom = 0;

            System.out.println("DIGITE O NOME DO FUNCIONARIO: \n");
            String nomeFuncionario = scan.next();

            System.out.println("DIGITE O ID DO FUNCIONARIO: \n");
            int idFuncionario = scan.nextInt();

            System.out.println("ENTRE COM  O CARGO DO FUNCIONARIO: \n");
            System.out.println("| GARCOM | COZINHEIRO | GERENTE: \n");
            String cargoFuncionario = scan.next();

            if(cargoFuncionario.equalsIgnoreCase("garcom")) {
                System.out.println("QUANTIDADE DE VENDAS \n");
                vendasGarcom = scan.nextInt();
            }
            //funcionarios.setVendasFuncionario(vendasGarcom);
            int vendasFuncionario = vendasGarcom;
            funcionarios.addFuncionario(new Funcionario( null,nomeFuncionario,idFuncionario,cargoFuncionario,vendasFuncionario ));

            System.out.println("FUNCIONARIO CADASTRADO COM SUCESSO!\n");
            System.out.println("DESEJA CASASTAR MAIS FUNCIONARIOS?: \n");
            System.out.println("(1 - SIM | 2 - NÃO) \n");
            int opcao = scan.nextInt();
            if(opcao == 1) {
                cadastrado = true;
            }else if(opcao == 2) {
                cadastrado = false;
            }else {
                System.out.println(" ERRO ");
            }
        }
    }

    public static void listarFuncionarios() {
        for (int i = 0; i < funcionarios.getListaFuncionarios().size(); i++) {
            System.out.println(funcionarios.getListaFuncionarios().get(i).toString()+"\n");
        }
    }

    public static void cardapio() {

        boolean rodar = true;
        while (rodar) {

            System.out.println("JA EXISTEM ITENS DISPONIVEIS, DESEJA CADASTRAR NOVOS ITENS? ( 1 - SIM | 2 - NÃO )");
            int condicao = scan.nextInt();

            if(condicao == 1) {

                System.out.println("DIGITE O NOME DO PRATO: ");
                String nome = scan.next();
                System.out.println("DIGITE O CODIGO DO PRODUTO: ");
                int codigo = scan.nextInt();
                System.out.println("DIGITE O PREÇO DO PRODUTO: ");
                scan.useLocale(Locale.US);  // Isso força o uso do ponto como separador decimal
                double preco = scan.nextDouble();
                System.out.println("DISPONIBILIDADE DEFINIDA AUTOMATICAMENTE PARA SIM: ");
                boolean disponivel = true;

                System.out.println(" UNIDADES NO ESTOQUE ? ");
                int estoque = scan.nextInt();

                Produto produto = new Produto(nome, codigo, preco, disponivel,estoque);
                cardapio.addProduto(produto);

                System.out.println("PRODUTO ADICIONADO COM SUCESSO! \n");

                System.out.println(" ADICIONAR MAIS UM?: ");
                System.out.println("\n | 1 - SIM | 2 - NÃO | ");
                int opc = scan.nextInt();

                if (opc == 1) {
                    rodar = true;
                }else{
                    rodar = false;
                }
            } else if (condicao == 2) {
                rodar = false;
            }


        }
    }

    public static void mostraCardapio() {
        System.out.println(" EXIBINDO CARDAPIO ");

        for (Produto produto : cardapio.getListaProdutos()) {
            System.out.println(produto.toString());
        }
    }

    public static void registroMesa() {
        boolean rodar = true;
        while (rodar) {

            System.out.println("JA EXISTEM MESAS DISPONIVEIS, DESEJA ADICIONAR MAIS ? ( 1 - SIM | 2 - NÃO ) \n");
            int condicao = scan.nextInt();
            if(condicao == 1) {

                System.out.println("DIGITE O ID DA MESA \n");
                int id = scan.nextInt();

                System.out.println("DIGITE A CAPACIDADE DA MESA \n");
                int capacidade = scan.nextInt();

                System.out.println(" MESA DISPONIVEL! \n");
                boolean disponivel = true;
                Mesa mesa = new Mesa(id, capacidade, disponivel);
                listaMesa.add(mesa);

                System.out.println("DESEJA ADICIONAR MAIS MESAS? ( 1 - SIM | 2 - NÃO ) \n");
                int escolha = scan.nextInt();

                boolean adicionar = false;
                if (escolha == 1) {
                    adicionar = true;
                }else{
                    adicionar = false;
                }
                //if para encerrar o programa:
                if (adicionar) {
                    rodar = true;
                }else {
                    rodar = false;
                }
            }
            else{
                rodar = false;
            }


        }
    }

    public static void mostraMesa() {
        System.out.println(" EXIBINDO MESAS DISPONIVEIS \n");

        for (Mesa mesa1 : listaMesa) {
            System.out.println(mesa1.toString());
        }
    }

    public static void pedidos() {
        double valorPedido;
        int pedidoPorGarcom = 0;
        System.out.println(" PEDIDOS \n");
        boolean rodar = true;
        while (rodar) {
            System.out.println("DESEJA VER O CARDAPIO? (1 - SIM | 2 - NÃO) \n");
            int opcao2 = scan.nextInt();
            if (opcao2 > 0 || opcao2 < 3) {
                switch (opcao2) {
                    case 1: {
                        mostraCardapio();
                        break;
                    }
                    default: {
                        System.out.println(" SEGUINDO: ");
                    }
                }
            } else {
                System.out.println(" ERRO AO VER O CARDAPIO! \n");
            }

            System.out.println("QUAL SEU PEDIDO: \n");
            String pedidoCliente = scan.next();

            for (int i = 0; i < cardapio.getListaProdutos().size(); i++) {
                Produto produto = cardapio.getListaProdutos().get(i);

                if (produto.getNomeOrder().equalsIgnoreCase(pedidoCliente)) {

                    System.out.println("LISTANDO OS GARÇONS DISPONIVEIS \n");

                    for (int j = 0; j < funcionarios.getListaFuncionarios().size(); j++) {
                        Funcionario funcionarioAtual = funcionarios.getListaFuncionarios().get(j);

                        if (funcionarioAtual.getCargoFuncionario().equalsIgnoreCase("garcom")) {
                            System.out.println("GARÇOM: " + funcionarioAtual.getNomeFuncionario());
                        }
                    }

                    System.out.println("QUAL O GARCOM RESPONSAVEL ? \n");
                    String garcomResponsavel = scan.next();

                    for (Funcionario funcionario : funcionarios.getListaFuncionarios()) {
                        if (funcionario.getNomeFuncionario().equalsIgnoreCase(garcomResponsavel)) {

                            garcomResponsavel = funcionario.getNomeFuncionario();

                            int vendasPorGarcom = funcionario.getVendasFuncionario();
                            vendasPorGarcom++;
                            funcionario.setVendasFuncionario(vendasPorGarcom);

                            double vendaTotal = produto.getPrecoItem();
                            pedidos.setValorPedido(pedidos.getValorPedido() + vendaTotal); // Adiciona o valor do pedido ao total

                            break;
                        }
                    }

                    mostraMesa();
                    System.out.println("QUAL A MESA DO PEDIDO?: \n");
                    int identificador = scan.nextInt();
                    int mesa = identificador;

                    for (int j = 0; j < listaMesa.size(); j++) {
                        Mesa mesaAtual = listaMesa.get(j);
                        if (mesaAtual.getIdMesa() == identificador) {
                            mesa = mesaAtual.getIdMesa();
                        }
                    }

                    double valor = produto.getPrecoItem();
                    System.out.println("O VALOR DE SEU PEDIDO É: \n" + valor);
                    int estoque = produto.getEstoqueTotal();
                    estoque--;
                    produto.setEstoqueTotal(estoque);
                    Pedidos pedidos1 = new Pedidos(mesa, garcomResponsavel, estoque, valor, null);
                    pedidos.addListaPedido(pedidos1);
                }
                ;
            }

            System.out.println("DESEJA ECERRAR PEDIDO?:( 1 - SIM | 2 - NÃO) \n");
            int encerrar = scan.nextInt();
            if (encerrar == 1) {
                rodar = false;
            }else{
                rodar = true;
            }

        }

    }

    public static void listarPedidos() {
        System.out.println(" EXIBINDO PEDIDOS \n");

        for (Pedidos pedido : pedidos.getListaPedidos()) {
            System.out.println(pedido.toString());
        }
    }

    public static void acompanhamentoPorFuncionario() {
        System.out.println("VERIFICANDO OS GARCONS: \n");

        for (int i = 0; i < funcionarios.getListaFuncionarios().size(); i++) {
            Funcionario funcionarioAtual = funcionarios.getListaFuncionarios().get(i);

            if (funcionarioAtual.getCargoFuncionario().equalsIgnoreCase("garcom")) {
                System.out.println("GARÇOM: " + funcionarioAtual.getNomeFuncionario());
                System.out.println("VENDAS: " + funcionarioAtual.getVendasFuncionario());
                System.out.println("TOTAL VENDIDO: " + pedidos.getValorPedido());
            }
        }
    }
    public static void excluirPedidos() {
        double troco;
        double troco2 = 0.0;
        System.out.println("LISTANDO PEDIDOS \n");

        for (Pedidos pedido : pedidos.getListaPedidos()) {
            System.out.println(pedido.toString());
        }

        System.out.println("DIGITE A MESA QUE DESEJA FECHAR OS PEDIDOS: \n");
        int mesa = scan.nextInt();

        double debito = 0.0;
        for (Pedidos pedido : pedidos.getListaPedidos()) {
            if (pedido.getMesa() == mesa) {
                debito += pedido.getValorPedido();
            }
        }
        System.out.println("O VALOR DO PEDIDO É: " + debito);

        System.out.println("VALOR A PAGAR: \n");
        scan.useLocale(Locale.US);  // Isso força o uso do ponto como separador decimal
        double pagar = scan.nextDouble();

        if (pagar >= debito) {
            Iterator<Pedidos> iterator = pedidos.getListaPedidos().iterator();
            // verifica se existem mais itens na lista
            while (iterator.hasNext()) {
                Pedidos pedido = iterator.next();
                if (pedido.getMesa() == mesa) {
                    troco = pagar - debito;
                    troco2 = troco;
                    vendasDoDia += pedido.getValorPedido();
                    iterator.remove();
                }
            }
            String resultado = String.format("%.2f", troco2);
            System.out.println(" SEU TROCO É: " + resultado);

            System.out.println("PEDIDOS DA MESA " + mesa + " FORAM REMOVIDOS COM SUCESSO. \n");
        } else {
            System.out.println("ERRO VALOR INCORRETO.");
        }

        System.out.println("LISTANDO PEDIDOS ATUALIZADOS: \n");
        if (pedidos.getListaPedidos().isEmpty()) {
            System.out.println("TODOS OS PEDIDOS FORAM EXCLUÍDOS.\n");
        } else {
            for (Pedidos pedido : pedidos.getListaPedidos()) {
                System.out.println(pedido.toString());
            }
        }
    }
    public static void relatorioFaturamento() {

        System.out.println("RELATÓRIO DE FATURAMENTO DIÁRIO: \n");

        System.out.println("TOTAL DE VENDAS REALIZADAS NO DIA: R$ " + vendasDoDia);

        System.out.println("\nTOTAL DE VENDAS POR MESA:\n");
        for (Mesa mesa : listaMesa) {
            double totalMesa = 0;
            for (Pedidos pedido : pedidos.getListaPedidos()) {
                if (pedido.getMesa() == mesa.getIdMesa()) {
                    totalMesa += pedido.getValorPedido();
                }
            }
            System.out.println("Mesa " + mesa.getIdMesa() + ": R$ " + totalMesa);
        }


        System.out.println("\nTOTAL DE VENDAS POR FUNCIONÁRIO: \n");
        acompanhamentoPorFuncionario();

    }
    public static void inicializador(){
        //precisei inicializar esses itens para não comprometer a logica do programa;
        // itens ja no cardapio
        Produto coca = new Produto("coca", 15, 10.50, true, 10);
        cardapio.addProduto(coca);
        Produto pizzas = new Produto("pizza", 12, 55.50, true, 10);
        cardapio.addProduto(pizzas);
        Produto lanche = new Produto("lanche", 13, 16.50, true, 10);
        cardapio.addProduto(lanche);
        Produto porcao = new Produto("porcao", 14, 17.50, true, 10);
        cardapio.addProduto(porcao);

        //funcionarios ja cadastrados
        Funcionario funcionario = new Funcionario("wellington", 1, "garcom");
        funcionarios.addFuncionario(funcionario);
        Funcionario funcionario1 = new Funcionario(null, "Bruno", 2,"gerente",0);
        funcionarios.addFuncionario(funcionario1);
        Funcionario funcionario2 = new Funcionario(null, "Flavinho tonhão", 3, "cozinheiro",0);
        funcionarios.addFuncionario(funcionario2);

        //mesas disponiveis
        Mesa mesaTeste = new Mesa(15, 4, true);
        listaMesa.add(mesaTeste);
        Mesa mesa1 = new Mesa(17, 2, true);
        listaMesa.add(mesa1);
        Mesa mesa2 = new Mesa(13, 4, true);
        listaMesa.add(mesa2);
    }
}
import pilha.PilhaLista;
import pilha.PilhaVetor;

import java.util.Scanner;

public class app {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String op = "";

        System.out.println("{----- Início -----}");
        while(!op.equals("1") && !op.equals("2")){
            System.out.println("Selecione tipo de pilha desejada:");
            System.out.println("1 - Vetor");
            System.out.println("2 - Dinâmica");
            System.out.println("(1/2):");
            op = teclado.nextLine();
            if(!op.equals("1") && !op.equals("2")){
                System.out.println("Resposta inválida");
            }
        }
        switch(op){
            case "1":
                System.out.println("Insira sua operação em notação pós-fixa:");
                op = teclado.nextLine();
                System.out.println(op);

                PilhaVetor pv = new PilhaVetor<>(100);
                String valor = "";
                Double operando1;
                Double operando2;

                for(int i = 0; i < op.length(); i++){
                    System.out.println(op.charAt(i));
                    if(op.charAt(i) == '+'||op.charAt(i) == '-'||op.charAt(i) == '*'||op.charAt(i) == '/'){
                        switch (op.charAt(i)){
                            case '+':
                                operando2 = (double) pv.pop();
                                operando1 = (double) pv.pop();
                                pv.push(operando1 + operando2);
                                break;
                            case '-':
                                operando2 = (double) pv.pop();
                                operando1 = (double) pv.pop();
                                pv.push(operando1 - operando2);
                                break;
                            case '*':
                                operando2 = (double) pv.pop();
                                operando1 = (double) pv.pop();
                                pv.push(operando1 * operando2);
                                break;
                            case '/':
                                operando2 = (double) pv.pop();
                                operando1 = (double) pv.pop();
                                pv.push(operando1 / operando2);
                                break;
                        }
                    } else {
                        if(op.charAt(i) != ' '){
                            valor += op.charAt(i);
                        } else {
                            if(!valor.isEmpty()){
                                pv.push(Double.parseDouble(valor));
                                valor = "";
                            }
                        }
                    }
                }

                System.out.println("O resultado da operação é: " +pv.pop());
                break;

            case "2":
                System.out.println("Insira sua operação em notação pós-fixa:");
                op = teclado.nextLine();
                System.out.println(op);

                PilhaLista pl = new PilhaLista();
                String valor2 = "";
                Double operando3;
                Double operando4;

                for(int i = 0; i < op.length(); i++){
                    System.out.println(op.charAt(i));
                    if(op.charAt(i) == '+'||op.charAt(i) == '-'||op.charAt(i) == '*'||op.charAt(i) == '/'){
                        switch (op.charAt(i)){
                            case '+':
                                operando4 = (double) pl.pop();
                                operando3 = (double) pl.pop();
                                pl.push(operando3 + operando4);
                                break;
                            case '-':
                                operando4 = (double) pl.pop();
                                operando3 = (double) pl.pop();
                                pl.push(operando3 - operando4);
                                break;
                            case '*':
                                operando4 = (double) pl.pop();
                                operando3 = (double) pl.pop();
                                pl.push(operando3 * operando4);
                                break;
                            case '/':
                                operando4 = (double) pl.pop();
                                operando3 = (double) pl.pop();
                                pl.push(operando3 / operando4);
                                break;
                        }
                    } else {
                        if(op.charAt(i) != ' '){
                            valor2 += op.charAt(i);
                        } else {
                            if(!valor2.isEmpty()){
                                pl.push(Double.parseDouble(valor2));
                                valor2 = "";
                            }
                        }
                    }
                }

                System.out.println("O resultado da operação é: " +pl.pop());
                break;
        }
    }
}

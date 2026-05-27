# Sistema de Triagem - Hospital São Binário

Este projeto consiste na implementação de um sistema moderno de triagem para o Pronto-Socorro do Hospital "São Binário", substituindo o modelo convencional de ordem de chegada por uma fila baseada em **prioridade clínica**.

O sistema gerencia o fluxo de atendimento utilizando uma estrutura de dados de **Fila com Prioridade** implementada analiticamente por meio de um **Heap Binário Máximo**.

## Requisitos do Projeto

A prioridade dos pacientes é avaliada através de três critérios em cascata (o critério seguinte só é consultado em caso de empate no anterior):
1. **Nível de Urgência:** Protocolo simplificado de 1 (Azul/Não Urgente) a 5 (Vermelho/Imediato). Maior urgência é atendida primeiro.
2. **Tempo de Espera:** Em caso de mesma urgência, o paciente com maior tempo de espera em minutos é priorizado.
3. **Grupo Vulnerável:** Pacientes com menos de 12 anos ou mais de 65 anos têm prioridade caso os critérios anteriores empatem.

## Estrutura do Código

* `Paciente.java`: Entidade contendo os atributos clínicos e a implementação da lógica de comparação (`Comparable`).
* `FilaPrioridadeHeap.java`: Implementação genérica do Heap Binário com os métodos estruturais de `sobeHeap` e `desceHeap`.
* `Main.java`: Ponto de entrada da aplicação que simula a chegada e o atendimento dos pacientes de teste.

## Compilação e Execução

Para compilar e executar o projeto diretamente por um terminal com o Java Development Kit (JDK) instalado:

1. **Compilar os arquivos:**
```bash
   javac -d bin src/hospital/*.java

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atividade01.Ordenacao;

/**
 *
 * @author nu3_lab7
 */
public class Ordenacao {

   static int[] bubbleSort(int vetor[]) {
    int i, j, n, temp;
    n = vetor.length;
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i -1; j++) {
            if (vetor[j] > vetor[j + 1]) {
                temp = vetor[j];
                vetor[j] = vetor[j + 1];
                vetor[j + 1] = temp;
            }
        }
    }
    return vetor;
}
static String imprimevetor(int vetor[]){
    String mat = "";
    for  (int i=0; i < vetor.length;i++){
        mat = mat + vetor[i] + " ";
    }
    return mat;
} 
static int[] insertionSort(int vetor[]) {
    int i, j, c, n;
    n = vetor.length;
    for (i = 1; i < n; i++) {
        c = vetor[i];
        j = i - 1;
        while (j >= 0 && vetor[j] > c) {
            vetor[j + 1] = vetor[j];
            j = j - 1;
        }
        vetor[j + 1] = c;
    }
    return vetor;
}
    static int[] selectionSortMaior(int vetor[]) {
        int imax, max, i, j;
        int n = vetor.length;
        for (i = n - 1; i >= 1; i--) {
            max = vetor[0];
            imax = 0;
            for (j = 1; j < i; j++) {
                if (vetor[j] > max) {
                    max = vetor[j];
                    imax = j;
                }
            }
            vetor[imax] = vetor[i];
            vetor[i] = max;
        }
        return vetor;
    }
    static int[] selectionSortMenor(int vetor[]) {
        int imin, temp, i, j;
        int n = vetor.length;
        for (i = 0; i <= n - 1; i++) {
            imin = i;
            for (j = i + 1; j < n; j++) {
                if (vetor[j] < vetor[imin]) {
                    imin = j;
                }
            }
            temp = vetor[imin];
            vetor[imin] = vetor[i];
            vetor[i] = temp;
        }
        return vetor;
    }
    static int[] mergesort(int esq[], int dir[]) {
        int[] aux = new int[esq.length + dir.length];
        int indexDir = 0, indexEsq = 0, indexAux = 0;
        while (indexEsq < esq.length || indexDir < dir.length) {
            if (indexEsq < esq.length && indexDir < dir.length) {
                if (esq[indexEsq] <= dir[indexDir]) {
                    aux[indexAux] = esq[indexEsq];
                    indexAux++;
                    indexEsq++;
                } else {
                    aux[indexAux] = dir[indexDir];
                    indexAux++;
                    indexDir++;
                }
            } else if (indexEsq < esq.length) {
                aux[indexAux] = esq[indexEsq];
                indexAux++;
                indexEsq++;
            } else if (indexDir < dir.length) {
                aux[indexAux] = dir[indexDir];
                indexAux++;
                indexDir++;
            }
        }
        return aux;
    }
    static int[] sort(int vetor[]) {
        if (vetor.length <= 1) {
            return vetor;
        }
        int meio = vetor.length / 2;
        int[] dir = vetor.length % 2 == 0 ? new int[meio] : new int[meio + 1];
        int[] esq = new int[meio];
        int[] aux = new int[vetor.length];
        for (int i = 0; i < meio; i++) {
            esq[i] = vetor[i];
        }
        int auxIndex = 0;
        for (int i = meio; i < vetor.length; i++) {
            dir[auxIndex] = vetor[i];
            auxIndex++;
        }
        esq = sort(esq);
        dir = sort(dir);
        aux = mergesort(esq, dir);
        return aux;
    }
    static int[] quickSort(int vetor[], int esquerda, int direita) {
        int esq = esquerda;
        int dir = direita;
        int troca;
        int pivo = vetor[(esq + dir) / 2];
        while (esq <= dir) {
            while (vetor[esq] < pivo) {
                esq = esq + 1;
            }
            while (vetor[dir] > pivo) {
                dir = dir - 1;
            }
            if (esq <= dir) {
                troca = vetor[esq];
                vetor[esq] = vetor[dir];
                vetor[dir] = troca;
                esq = esq + 1;
                dir = dir - 1;
            }
        }
        if (dir > esquerda) {
            quickSort(vetor, esquerda, dir);
        }
        if (esq < direita) {
            quickSort(vetor, esq, direita);
        }
        return vetor;
    }
public static void main(String[] args){
    int V[] = {34, 5, 7, 2, 1, 0, 26, 4, 3};
    int V2[] = V;
    int V3[] = V;
    int V4[] = V;
    int V5[] = V;
    int V6[] = V;
    long inicio, fim;
    inicio= System.nanoTime();
    System.out.print("Vetor Ordenado: " +imprimevetor(insertionSort(V)));
    fim = System.nanoTime();
    System.out.println("\nTempo "+ (fim-inicio));
    long inicio2, fim2;
    inicio2= System.nanoTime();
    System.out.println("\nVetor Ordenado: " +imprimevetor(bubbleSort(V2)));
    fim2 = System.nanoTime();
    System.out.println("\nTempo "+ (fim2-inicio2));
    System.out.println("\nVetor Ordenado: " +imprimevetor(selectionSortMaior(V3)));
    System.out.println("\nVetor Ordenado: " +imprimevetor(selectionSortMenor(V4)));
    System.out.println("\nVetor Ordenado: " +imprimevetor(sort(V5)));
    System.out.println("\nVetor Ordenado: " +imprimevetor(quickSort(V6, 0,V6.length-1)));
}   
}

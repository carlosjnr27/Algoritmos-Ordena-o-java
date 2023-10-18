package OrdenacaoStrings;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        OrdenaAlgoritmo heapsort = new HeapSort();
        OrdenaAlgoritmo insertionsort = new InsertionSort();
        OrdenaAlgoritmo introsort = new IntroSort();
        OrdenaAlgoritmo mergesort = new MergeSort();
        OrdenaAlgoritmo quicksort = new QuickSort();
        OrdenaAlgoritmo selectionsort = new SelectionSort();

        String fileName = "./OrdenacaoStrings/arquivos5.txt";
        String[] fileNames = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = reader.readLine();
            if (line != null) {
                line = line.replace("[", "").replace("]", "").replaceAll("\\s+", "");
                fileNames = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileNames != null) {
            measureAndPrintPerformance("Heapsort", heapsort, fileNames);
            measureAndPrintPerformance("Insertion Sort", insertionsort, fileNames);
            measureAndPrintPerformance("Intro Sort", introsort, fileNames);
            measureAndPrintPerformance("Merge Sort", mergesort, fileNames);
            measureAndPrintPerformance("Quick Sort", quicksort, fileNames);
            measureAndPrintPerformance("Selection Sort", selectionsort, fileNames);
        }
    }

    public static void measureAndPrintPerformance(String nomeAlgoritmo, OrdenaAlgoritmo algoritmo, String[] fileNames) {
        long startTime = System.nanoTime();
        String[] sorted = algoritmo.sort(fileNames);
        long endTime = System.nanoTime();

        long executionTime = (endTime - startTime) / 1000; // Tempo em microssegundos

        System.out.println(nomeAlgoritmo + " executado em " + executionTime + " microssegundos");
        System.out.println("Numero de comparações do " + nomeAlgoritmo + ":" + algoritmo.getComparacoes());
        System.out.println("Lista Ordenada: " + Arrays.toString(sorted));
        System.out.println("");
    }

}

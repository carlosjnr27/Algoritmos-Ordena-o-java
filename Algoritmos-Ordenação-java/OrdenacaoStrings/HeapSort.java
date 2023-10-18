package OrdenacaoStrings;

public class HeapSort implements OrdenaAlgoritmo {
    private static long comparacoes;

    @Override
    public String[] sort(String[] lista) {
        heapsort(lista);
        return lista;
    }

    public static void heapsort(String[] fileNames) {
        int n = fileNames.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(fileNames, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            String temp = fileNames[0];
            fileNames[0] = fileNames[i];
            fileNames[i] = temp;
            heapify(fileNames, i, 0);
        }
    }

    private static void heapify(String[] fileNames, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;
        if (esquerda < n && fileNames[esquerda].compareTo(fileNames[maior]) > 0) {
            maior = esquerda;
            comparacoes++;
        }
        if (direita < n && fileNames[direita].compareTo(fileNames[maior]) > 0) {
            maior = direita;
            comparacoes++;
        }
        if (maior != i) {
            String temp = fileNames[i];
            fileNames[i] = fileNames[maior];
            fileNames[maior] = temp;
            heapify(fileNames, n, maior);
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

}

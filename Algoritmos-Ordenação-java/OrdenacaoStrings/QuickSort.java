package OrdenacaoStrings;

public class QuickSort implements OrdenaAlgoritmo {
    private static long comparacoes;

    @Override
    public String[] sort(String[] lista) {
        comparacoes = 0;
        quicksort(lista, 0, lista.length - 1);
        return lista;
    }

    private static void quicksort(String[] fileNames, int menor, int maior) {
        if (menor < maior) {
            int pivot = partition(fileNames, menor, maior);
            quicksort(fileNames, menor, pivot - 1);
            quicksort(fileNames, pivot + 1, maior);
        }
    }

    private static int partition(String[] fileNames, int menor, int maior) {
        String pivot = fileNames[maior];
        int i = menor - 1;
        for (int j = menor; j < maior; j++) {
            if (fileNames[j].compareTo(pivot) < 0) {
                i++;
                String temp = fileNames[i];
                fileNames[i] = fileNames[j];
                fileNames[j] = temp;

            }
            comparacoes++;
        }
        String temp = fileNames[i + 1];
        fileNames[i + 1] = fileNames[maior];
        fileNames[menor] = temp;
        return i + 1;

    }

    public long getComparacoes() {
        return comparacoes;
    }

}

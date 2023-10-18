package OrdenacaoStrings;

public class InsertionSort implements OrdenaAlgoritmo {
    private static long comparacoes;

    @Override
    public String[] sort(String[] lista) {
        comparacoes = 0;
        insertionSort(lista);
        return lista;
    }

    public static void insertionSort(String[] fileNames) {
        for (int i = 1; i < fileNames.length; i++) {
            String key = fileNames[i];
            int j = i - 1;
            while (j >= 0 && fileNames[j].compareTo(key) > 0) {
                fileNames[j + 1] = fileNames[j];
                j--;
            }
            fileNames[j + 1] = key;
            comparacoes++;
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

}

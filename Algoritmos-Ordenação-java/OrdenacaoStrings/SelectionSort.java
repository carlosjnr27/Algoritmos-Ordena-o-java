package OrdenacaoStrings;

public class SelectionSort implements OrdenaAlgoritmo {
    private static long comparacoes;

    @Override
    public String[] sort(String[] lista) {
        comparacoes = 0;
        selectionSort(lista);
        return lista;
    }

    public static void selectionSort(String[] fileNames) {
        for (int i = 0; i < fileNames.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < fileNames.length; j++) {
                if (fileNames[j].compareTo(fileNames[minIndex]) < 0) {
                    minIndex = j;
                }
                comparacoes++;
            }
            String temp = fileNames[i];
            fileNames[i] = fileNames[minIndex];
            fileNames[minIndex] = temp;
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

}

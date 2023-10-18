package OrdenacaoStrings;

public class MergeSort implements OrdenaAlgoritmo {
    private static long comparacoes;

    @Override
    public String[] sort(String[] lista) {
        comparacoes = 0;
        mergesort(lista);
        return lista;
    }

    public static void mergesort(String[] fileNames) {
        if (fileNames.length <= 1)
            return;
        String[] temp = new String[fileNames.length];
        mergesort(fileNames, temp, 0, fileNames.length - 1);
    }

    private static void mergesort(String[] fileNames, String[] temp, int menor, int maior) {
        if (menor < maior) {
            int meio = (menor + maior) / 2;
            mergesort(fileNames, temp, menor, meio);
            mergesort(fileNames, temp, meio + 1, maior);
            merge(fileNames, temp, menor, meio, maior);
        }
    }

    private static void merge(String[] fileNames, String[] temp, int menor, int meio, int maior) {
        for (int i = menor; i <= maior; i++) {
            temp[i] = fileNames[i];
        }
        int i = menor;
        int j = meio + 1;
        int k = menor;
        while (i <= meio && j <= maior) {
            comparacoes++;
            if (temp[i].compareTo(temp[j]) <= 0) {
                fileNames[k] = temp[i];
                i++;
            } else {
                fileNames[k] = temp[j];
                j++;
            }
            k++;
        }
        while (i <= maior) {
            fileNames[k] = temp[i];
            k++;
            i++;
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

}

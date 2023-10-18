package OrdenacaoStrings;

public class IntroSort implements OrdenaAlgoritmo {
    private static long comparacoes;

    @Override
    public String[] sort(String[] lista) {
        comparacoes = 0;
        introsort(lista);
        return lista;
    }

    public static void introsort(String[] lista) {
        int maxDepth = (int) (Math.log(lista.length) * 2);
        introsort(lista, 0, lista.length - 1, maxDepth);
        insertionSort(lista);
    }

    private static void introsort(String[] lista, int menor, int maior, int maxDepth) {
        if (menor < maior) {
            if (maxDepth == 0) {
                heapsort(lista, menor, maior);
            } else {
                int pivotIndex = partition(lista, menor, maior);
                introsort(lista, menor, pivotIndex, maxDepth - 1);
                introsort(lista, pivotIndex + 1, maior, maxDepth - 1);
            }
        }
    }

    private static int partition(String[] lista, int menor, int maior) {
        String pivot = lista[menor];
        int i = menor - 1;
        int j = maior + 1;

        while (true) {
            do {
                i++;
                comparacoes++;
            } while (lista[i].compareTo(pivot) < 0);

            do {
                j--;
                comparacoes++;
            } while (lista[j].compareTo(pivot) > 0);

            if (i < j) {
                String temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            } else {
                return j;
            }
        }
    }

    private static void heapsort(String[] lista, int menor, int maior) {
        int n = maior - menor + 1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(lista, i, n, menor);
        }

        for (int i = n - 1; i >= 0; i--) {
            String temp = lista[menor];
            lista[menor] = lista[menor + i];
            lista[menor + i] = temp;

            heapify(lista, 0, i, menor);
        }
    }

    private static void heapify(String[] lista, int i, int n, int low) {
        String root = lista[low + i];
        while (i < n / 2) {
            int child = 2 * i + 1;
            if (child + 1 < n && lista[low + child].compareTo(lista[low + child + 1]) < 0) {
                child++;
            }
            if (root.compareTo(lista[low + child]) >= 0) {
                break;
            }
            lista[low + i] = lista[low + child];
            i = child;
            comparacoes++;
        }
        lista[low + i] = root;
    }

    private static void insertionSort(String[] lista) {
        for (int i = 1; i < lista.length; i++) {
            String key = lista[i];
            int j = i - 1;
            while (j >= 0 && lista[j].compareTo(key) > 0) {
                lista[j + 1] = lista[j];
                j--;
            }
            lista[j + 1] = key;
            comparacoes++;
        }
    }

    public long getComparacoes() {
        return comparacoes;
    }

}

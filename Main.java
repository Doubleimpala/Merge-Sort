import java.util.*;

class Main {
  private static int EndGameRun = 0;
  private static List<Integer> Original = new ArrayList<Integer>();

  public static void main(String[] args) {
    for (int g = 1; g <= 8; g++) {
      Original.add(g);
    }
  }

  public static void split(List<Integer> A) {
    int ALLength = A.size();
    int halfway = Math.round(ALLength / 2);
    List<Integer> L = A.subList(0, halfway);
    List<Integer> R = A.subList(halfway, A.size());
    if (L.size() == 1 && R.size() == 1) {
      merge(L, R);
    } else {
      split(L);
      split(R);
    }
  }

  public static void merge(List<Integer> L, List<Integer> R) {
    int nL = L.size();
    int nR = R.size();
    int k = 0;
    int i = 0;
    int j = 0;
    ArrayList C = new ArrayList();
    while (i < nL && j < nR) {
      if (L.get(i) <= R.get(j)) {
        C.add(L.get(i));
        i++;
      } else {
        C.add(R.get(j));
        j++;
      }
    }
    while (i < nL) {
      C.add(L.get(i));
      i++;
    }
    while (j < nR) {
      C.add(R.get(j));
      j++;
    }

    EndGame(C);

  }

  public static void EndGame(List<Integer> N) {
    EndGameRun++;
    if (N.size() == Original.size()) {
      print(N);
    } else {
      List<Integer> M = new ArrayList<Integer>();
      if (EndGameRun == 2) {
        EndGameRun = 0;
        merge(M, N);
      } else {
        M = N;
      }
    }

  }

  public static void print(List<Integer> P) {
    int o = 0;
    while (o != Original.size() + 1) {
      System.out.println(P.get(o));
      o++;
    }
    return;
  }
}
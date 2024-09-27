import java.util.*;;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] array = { "Nhap canh a : ", "Nhap canh b : ", "Nhap canh c : " };
        double[] edge = new double[3];
        for (int i = 0; i < edge.length; i++) {
            System.out.print(array[i]);
            edge[i] = sc.nextDouble();
        }
        if (edge[0] > 0 && edge[1] > 0 && edge[2] > 0) {
            for (int j = 0; j < 2; j++) {
                for (int i = 0; i < edge.length - 1; i++) {
                    if (edge[i] > edge[i + 1]) {
                        edge[i] += edge[i + 1];
                        edge[i + 1] = edge[i] - edge[i + 1];
                        edge[i] -= edge[i + 1];
                    }
                }
            }
            String a = ((edge[0] == edge[1]) && (edge[1] == edge[2])) ? "Tam giac deu"
                    : (edge[0] == edge[1]) || (edge[1] == edge[2]) ? "Tam giac can"
                            : (edge[0] * edge[0] + edge[1] * edge[1] == edge[2] * edge[2]) ? "Tam giac vuong"
                                    : "Tam giac thuong";
            System.out.println(a);
        }
        sc.close();
    }
}

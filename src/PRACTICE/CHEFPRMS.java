package PRACTICE;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


class CHEFPRMS {

    static Reader rb;

    public static void main(String[] args)
            throws IOException {

        try {

            rb = new Reader();
            int t = rb.nextInt();

            ArrayList<Integer> sp  = new ArrayList<>();

            for (int m= 1 ; m <= 200 ; m++){
                if(semiPrime(m)){
                    sp.add(m);
                }
            }

            while (t-->0){
                int N = rb.nextInt();
                int n = sp.size();
                boolean ans = false;
                for(int i = 0 ; i < n ; i++) {
                    for (Integer integer : sp) {
                        if (sp.get(i) + integer == N) {
                            ans = true;
                            // System.out.println("a: "+ semi.get(i) + " b: " + integer);
                            break;
                        }
                    }
                }

                if(ans) System.out.println("YES");
                else System.out.println("NO");


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


//=====================- SOLUTION -===================>

    static void Solution(ArrayList<Integer> sp) throws IOException {

            int n = rb.nextInt();
            boolean flag = false;

            for (int j = 0 ; j < sp.size() ; j ++){
                for (Integer semi : sp){
                    if(semi + sp.get(j)== n) flag= true;
                }
            }

            System.out.println(flag?"Yes":"No");
//
//            for (Integer im : sp ){
//                System.out.println(semiPrime(im));
//            }








    }

    static ArrayList<Integer> seive(int n){
        int[] arr = new int[n+1];
        Arrays.fill(arr,1);
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2 ; i*i <= n ; i ++){
            if(arr[i]==1){
                for(int j = 2; j*i <= n ; j ++){
                    arr[j*i]=0;
                }
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int k = 2 ; k<= n ; ++k){
            if(arr[k]==1){
                arr[k] = k;
                arrayList.add(k);
            }
        }


        return arrayList;
    }



    private static boolean semiPrime(int n) {
        int count = 0;
        int a = -1 ,b = -1;
        int x = n;
        for(int i = 2 ; x >1 ; i++) {
            if(i > x ) break;
            if(x%i == 0) {
                if(a == -1)a = i;
                else if(b == -1) b = i;
                else return false;
                count++;
                while(x > 1 && x%i == 0) {
                    x = x/i;
                }
            }
        }
        return count == 2 && a*b ==n;
    }




    static int[] convStrngArrToint(String[] arr) {
        int arr_lenght = arr.length;
        int[] int_arr = new int[arr_lenght];
        for (int i = 0; i < arr_lenght; i++) {
            int_arr[i] = Integer.parseInt(arr[i]);
        }
        return int_arr;
    }

    static Integer[] convStrngArrToInt(String[] arr) {
        int arr_lenght = arr.length;
        Integer[] int_arr = new Integer[arr_lenght];
        for (int i = 0; i < arr_lenght; i++) {
            int_arr[i] = Integer.parseInt(arr[i]);
        }
        return int_arr;
    }


    static boolean isPresent(int[] a, int value) {
        boolean isPresent = false;
        for (int i : a) {
            if (i == value) {
                isPresent = true;
                break;

            }

        }
        return isPresent;
    }

    static boolean isEven(long n) {
        return (n ^ 1) == n + 1;
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1000000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}


//================================= Reader ===================================================>



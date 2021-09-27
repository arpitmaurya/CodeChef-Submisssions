package SEPLONG;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;


class Sep4 {

    static Reader rb;

    public static void main(String[] args)
            throws IOException {


      // System.out.println(convertDecToN(216,16));

        try {
            rb = new Reader();
            int t = rb.nextInt();

            for (int i = 1; i <= t; ++i) {
                Solution();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

//=====================- SOLUTION -===================>

   static int sumDigit(String num){
        int sum = 0;
        for (int i = 0 ; i < num.length() ; i++){
            sum += num.charAt(i)-48;
        }

        return sum;
    }

    static void Solution() throws IOException {

        String[] inp = rb.readLine().split(" ");

        int num = Integer.parseInt(inp[0]);
        int l = Integer.parseInt(inp[1]);
        int r = Integer.parseInt(inp[2]);

        int min = Integer.MAX_VALUE;
        int flag = 0;

        if (l<num && num<r){
            System.out.println(num);
        }
        else if(r>num){
            System.out.println(r);
        }
        else{

        for (int i = r ; i >= l ; i --){

            int sum = 0;
            int ntemp = num;

            while(ntemp >0){

                sum+= ntemp % i;
                ntemp /= i;

                if(sum>min){
                    break;
                }
            }
            if(min>sum) {
                min = sum;
                flag = i;
            }
            if(min == 1){
                break;
            }
            //System.out.println("converted base with "+i+" :"+s);
            // System.out.println(sum);
        }

        System.out.println(flag);

}
    }


    static String convertDecToN(long dec,int n){
        StringBuilder s = new StringBuilder();
        while (dec>0){
            s.append((char) (dec%n+48));
            dec /= n;
        }
        return new String(s.reverse());
    }

    static int  fasterModulo(int dividend , int divisor){
        while (dividend >= divisor) dividend-=divisor;
        return dividend;
    }

    static int  fastestModulo(int dividend, int divisor){
        return dividend & (divisor -1);
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



package START12C;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;


class MAKEDIV3 {

    static Reader rb;
    static int MAX_INT = Integer.MAX_VALUE;

    public static void main(String[] args)
            throws IOException {

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

    static void Solution() throws IOException {
        String inp[] = rb.readLine().split(" ");

        // f(n) => x<=10^n-1
        //System.out.println(Arrays.toString(inp));


        for (String i : inp){

            int pow = Integer.parseInt(i);
           // long start = (long) Math.pow(10,pow-1)-1;  // if n = 1 > start = 0 , end 9 , if n = 2 > start = 10 , end = 99
            //long end = (long) (Math.pow(10,pow-1));
           // System.out.println(end);
            if (pow ==1) {
             System.out.println("3");
            }else if(pow == 2 ){
                System.out.println("15");
            }
            else{
                StringBuilder x = new StringBuilder("10");
                for(int j = 3; j < pow ; j++){
                    x.append("0");
                }
                System.out.println(x.append("5"));
            }


//            int start = power(10,pow-1,MAX_INT)-1;  // if n = 1 > start = 0 , end 9 , if n = 2 > start = 10 , end = 99
//            int end = power(10,pow,MAX_INT)-1;

         //   System.out.println(start);
          //  System.out.println(end);
           // System.out.println(Math.pow(10,0));

//            boolean flag=false;
//            for (long j = start; j <= end; j+=3){
//
//                if(j%3==0 && !isEven(j) && j%9!=0){
//                    System.out.println(j);
//                    flag=true;
//                }
//                if (flag) break;


           //     System.out.println(j);

            }

        }





    static int[] convStrngArrToint(String[] arr) {
        int arr_lenght = arr.length;
        int[] int_arr = new int[arr_lenght];
        for (int i = 0; i < arr_lenght; i++) {
            int_arr[i] = Integer.parseInt(arr[i]);
        }
        return int_arr;
    }

    static int power(int x, int y, int p)
    {
        int res = 1; // Initialize result

        x = x % p; // Update x if it is more than or
        // equal to p

        if (x == 0)
            return 0; // In case x is divisible by p;

        while (y > 0)
        {

            // If y is odd, multiply x with result
            if ((y & 1) != 0)
                res = (res * x) % p;

            // y must be even now
            y = y >> 1; // y = y/2
            x = (x * x) % p;
        }
        return res;
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



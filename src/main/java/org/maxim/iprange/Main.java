package org.maxim.iprange;
import java.net.*;
import java.util.*;

/**
 * Created by Maxim on 25.08.2016.
 */


public class Main {

    private static final long mod = 256*256*256;
    private static final long mod1 = 256*256;
    private static final long mod2 = 256;

    private static long toLong(InetAddress address)
    {
        byte arrIP[] = address.getAddress();
        int i0 = arrIP[0]; if (i0<0) i0+=256;
        int i1 = arrIP[1]; if (i1<0) i1+=256;
        int i2 = arrIP[2]; if (i2<0) i2+=256;
        int i3 = arrIP[3]; if (i3<0) i3+=256;
        return (mod *i0)+(mod1*i1)+(mod2 *i2)+i3;
    }

    private static String toStr(long address)
    {
        long add = address;
        long l = add / mod;
        add -= (l* mod);
        long l1 = add / mod1;
        add -= (l1*mod1);
        long l2 = add / mod2;
        add -= (l2* mod2);
        long l3 = add;

        return l+"."+l1+"."+l2+"."+l3;
    }


    public static void main(String[] args) throws UnknownHostException {
        System.out.println("Enter firs ip: ");
        Scanner sc = new Scanner(System.in);
        String ipStr = sc.nextLine();
        InetAddress ip = InetAddress.getByName(ipStr);
        System.out.println("Enter second ip: ");
        String ipStr1 = sc.nextLine();
        InetAddress ip2 = InetAddress.getByName(ipStr1);
        long lip1;
        long lip2;
        lip1 = toLong(ip);
        lip2 = toLong(ip2);
        for (long i = lip1; i <= lip2; i++) {
            String result;
            result = toStr(i);
            System.out.println(result);
        }

    }

}
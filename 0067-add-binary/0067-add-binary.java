class Solution {
    public String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int a1 = a.length()-1;
        int b1 = b.length()-1;
        int c = 0;
        while(a1>= 0||b1>= 0) {
            int v1 = a1 < 0 ? 0 : a.charAt(a1)-'0';
            int v2 = b1 < 0 ? 0 : b.charAt(b1)-'0';
            int s = (v1 + v2 + c)%2;
            c=(v1+v2+c)/2;
            sb.append(s);
            a1--;
            b1--;
        }
        if(c == 1) sb.append("1");
        return sb.reverse().toString();
    }
}
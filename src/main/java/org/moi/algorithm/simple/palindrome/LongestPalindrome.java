package org.moi.algorithm.simple.palindrome;

/**
 * @program:
 * @description: 5. ������Ӵ� �Ѷȣ�medium
 * @author: moi
 * @create: 2021/1/18 22:02
 **/
public class LongestPalindrome {

    /**
     * ��Ŀ������һ���ַ��� s���ҵ� s ����Ļ����Ӵ���
     *
     * ?
     *
     * ʾ�� 1��
     *
     * ���룺s = "babad"
     * �����"bab"
     * ���ͣ�"aba" ͬ���Ƿ�������Ĵ𰸡�
     *
     *
     */

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        char[] str= manacherString(s);
        int[] parr = new int[str.length];
        //����������ұ߽�
        int R = -1;
        //������������ĵ�
        int C = -1;
        int max = Integer.MIN_VALUE;
        int num = Integer.MIN_VALUE;
        for(int i = 0;i<str.length;i++){
            //ÿ��parr[]�е�Ԫ�س�ʼ����Ϊ1�������i�㴦��Ŀǰ�������ַ������ұ߽�R�ڲ�ʱ����ȡ���������ַ��������ĵ�C������parr����ĶԳƵ�
            //����ĶԳƵ�Ļ�������Χ�Ѿ������������ַ���������Χ����ʱ����ȡ���ߵ���Сֵ
            parr[i] = R>i ?Math.min(parr[2*C-i],R-i):1;
            //��ÿ��parrԪ�����еķ�Χ��ȥ�ж�����ķ�Χ�Ƿ��ܲ��ܹ��ɻ��Ĵ���������ԣ�����İ뾶Ҫ��1������������ѭ��
            while (i + parr[i] < str.length && i - parr[i] > -1) {
                if (str[i + parr[i]] == str[i - parr[i]]) {
                    parr[i]++;
                }else {
                    break;
                }
            }
            //������ָ���Ļ����ַ�����ʱ���ƶ����ұ߽磬���ҽ����ĵ�ı�
            if (i + parr[i] > R) {
                R = i + parr[i];
                C = i;
            }
            //�ҵ��������ַ�������ʼ�±�
            num = max>parr[i]?num:i-parr[i]+1;
            //��max��ֵΪ���Ļ��İ뾶
            max = Math.max(max, parr[i]);

        }
        StringBuffer sb = new StringBuffer();
        for (int i = num; i < num+(max-1)*2; i++) {
            if(str[i]!='#'){
                sb.append(str[i]);
            }
        }
        //��󷵻ص��������������ַ��ļ��룬��Ҫ��ȥ1
        return sb.toString();
    }

    public static char[] manacherString(String str){
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        int index = 0;
        for (int i = 0; i != res.length; i++) {
            res[i] = (i & 1) == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        new LongestPalindrome().longestPalindrome(s);
    }
}
